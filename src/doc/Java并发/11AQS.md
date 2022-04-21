### 11.1AQS简介

**AQS：AbstractQueuedSynchronizer的简称**，即**抽象队列同步器**

- 抽象：抽象类，只实现一些主要逻辑，有些方法由子类实现
- 队列：使用先进先出（FIFO）队列存储数据
- 同步：实现了同步功能



AQS是一个用来构建锁和同步器的框架，使用AQS能高效地构造出应用广泛的同步器



### 11.2AQS的数据结构

AQS内部使用一个volatile标识的变量state来作为资源的标识。同时定义了几个获取和改变state的==protected==方法

```java
getState()
setState()
compareAndSetState()//实现基于Unsafe类的CompareAndSwapInt方法
```

AQS类本身实现的是一些排队和阻塞的机制，比如具体线程等待队列的维护（如获取资源失败入队/唤醒出队），内部使用了一个双向队列，队列中存储的是内部类Node节点，Node中拥有线程



### 11.3资源共享模式

资源有两种共享模式（同步模式）

- 独占模式（Exclusive）：资源是独占的，一次只能有一个线程获取，如ReentrantLock
- 抢占模式（Share）：同时可以被多个线程获取，具体的资源个数可以由参数指定，如Semphore/CountDownLatch

一般情况子类只需要实现一个模式，也有实现两个模式的如ReadWriteLock



AQS关于这两种资源共享模式的代码在内部类Node中

```java
static final class Node {
        /** Marker to indicate a node is waiting in shared mode */
        static final Node SHARED = new Node();
        /** Marker to indicate a node is waiting in exclusive mode */
        static final Node EXCLUSIVE = null;

        /** waitStatus value to indicate thread has cancelled */
        static final int CANCELLED =  1;
        /** waitStatus value to indicate successor's thread needs unparking */
        static final int SIGNAL    = -1;
        /** waitStatus value to indicate thread is waiting on condition */
        static final int CONDITION = -2;
        /**
         * waitStatus value to indicate the next acquireShared should
         * unconditionally propagate
         */
        static final int PROPAGATE = -3;

        /**
         * Status field, taking on only the values:
         *   SIGNAL:     The successor of this node is (or will soon be)
         *               blocked (via park), so the current node must
         *               unpark its successor when it releases or
         *               cancels. To avoid races, acquire methods must
         *               first indicate they need a signal,
         *               then retry the atomic acquire, and then,
         *               on failure, block.
         *   CANCELLED:  This node is cancelled due to timeout or interrupt.
         *               Nodes never leave this state. In particular,
         *               a thread with cancelled node never again blocks.
         *   CONDITION:  This node is currently on a condition queue.
         *               It will not be used as a sync queue node
         *               until transferred, at which time the status
         *               will be set to 0. (Use of this value here has
         *               nothing to do with the other uses of the
         *               field, but simplifies mechanics.)
         *   PROPAGATE:  A releaseShared should be propagated to other
         *               nodes. This is set (for head node only) in
         *               doReleaseShared to ensure propagation
         *               continues, even if other operations have
         *               since intervened.
         *   0:          None of the above
         *
         * The values are arranged numerically to simplify use.
         * Non-negative values mean that a node doesn't need to
         * signal. So, most code doesn't need to check for particular
         * values, just for sign.
         *
         * The field is initialized to 0 for normal sync nodes, and
         * CONDITION for condition nodes.  It is modified using CAS
         * (or when possible, unconditional volatile writes).
         */
        volatile int waitStatus;

        /**
         * Link to predecessor node that current node/thread relies on
         * for checking waitStatus. Assigned during enqueuing, and nulled
         * out (for sake of GC) only upon dequeuing.  Also, upon
         * cancellation of a predecessor, we short-circuit while
         * finding a non-cancelled one, which will always exist
         * because the head node is never cancelled: A node becomes
         * head only as a result of successful acquire. A
         * cancelled thread never succeeds in acquiring, and a thread only
         * cancels itself, not any other node.
         */
        volatile Node prev;

        /**
         * Link to the successor node that the current node/thread
         * unparks upon release. Assigned during enqueuing, adjusted
         * when bypassing cancelled predecessors, and nulled out (for
         * sake of GC) when dequeued.  The enq operation does not
         * assign next field of a predecessor until after attachment,
         * so seeing a null next field does not necessarily mean that
         * node is at end of queue. However, if a next field appears
         * to be null, we can scan prev's from the tail to
         * double-check.  The next field of cancelled nodes is set to
         * point to the node itself instead of null, to make life
         * easier for isOnSyncQueue.
         */
        volatile Node next;

        /**
         * The thread that enqueued this node.  Initialized on
         * construction and nulled out after use.
         */
        volatile Thread thread;

        /**
         * Link to next node waiting on condition, or the special
         * value SHARED.  Because condition queues are accessed only
         * when holding in exclusive mode, we just need a simple
         * linked queue to hold nodes while they are waiting on
         * conditions. They are then transferred to the queue to
         * re-acquire. And because conditions can only be exclusive,
         * we save a field by using special value to indicate shared
         * mode.
         */
        Node nextWaiter;

        /**
         * Returns true if node is waiting in shared mode.
         */
        final boolean isShared() {
            return nextWaiter == SHARED;
        }

        /**
         * Returns previous node, or throws NullPointerException if null.
         * Use when predecessor cannot be null.  The null check could
         * be elided, but is present to help the VM.
         *
         * @return the predecessor of this node
         */
        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (p == null)
                throw new NullPointerException();
            else
                return p;
        }

        Node() {    // Used to establish initial head or SHARED marker
        }

        Node(Thread thread, Node mode) {     // Used by addWaiter
            this.nextWaiter = mode;
            this.thread = thread;
        }

        Node(Thread thread, int waitStatus) { // Used by Condition
            this.waitStatus = waitStatus;
            this.thread = thread;
        }
    }


//AQS的addWaiter私有方法
private Node addWaiter(Node mode){
    //使用node的构造函数
    Node node = new Node(Thread.currentThread(),mode);
}
```

> 通过Node可以实现两个队列，一个是prev和next组成实现CLH队列（线程同步队列，双向队列），二是nextWaiter实现Condition条件上的等待队列（单向队列），这个Condition主要用在ReentrantLock类上





### 11.4AQS的主要源码及解析

AQS的设计是基于**模板方法模式**的，有一些方法必须要子类去实现，主要由

- isHeldExclusively():该线程是否正在独占资源，只有用到condition才需要去实现
- tryAcquire(int):独占方式，尝试获取资源，成功则返回true，失败返回false
- treRelease(int):独占方式，尝试释放资源，成功true,失败false
- tryAcqurieShared(int):共享方式，尝试获取资源，返回负数代表失败，0代表成功，但没有剩余资源，正数表示成功且有剩余资源
- tryReleaseShared(int):共享方式，尝试释放资源，如果释放后允许唤醒后续等待节点返回true，否则返回失败

这些方法在AQS中没有具体实现，而是直接抛出异常



#### 11.4.1获取资源

```java
//首先调用tryAcquire(arg)尝试获取资源，如果失败则通过addWaiter(Node.EXCLUSIVE)方法将线程插入到等待队列中，传入的参数代表要插入的Node是独占的
public final void acquire(int arg) {
        if (!tryAcquire(arg) &&
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            selfInterrupt();
    }


private Node addWaiter(Node mode) {
    	//生成该线程对应的Node节点
        Node node = new Node(Thread.currentThread(), mode);
        // Try the fast path of enq; backup to full enq on failure
        Node pred = tail;
        if (pred != null) {
            node.prev = pred;
            //尝试使用CAS尝试，成功返回
            if (compareAndSetTail(pred, node)) {
                pred.next = node;
                return node;
            }
        }
    	//如果队列是空的或则CAS失败，调用enq自旋CAS插入
        enq(node);
        return node;
    }

//自旋CAS插入等待队列
 private Node enq(final Node node) {
        for (;;) {
            Node t = tail;
            if (t == null) { // Must initialize
                if (compareAndSetHead(new Node()))
                    tail = head;
            } else {
                node.prev = t;
                if (compareAndSetTail(t, node)) {
                    t.next = node;
                    return t;
                }
            }
        }
    }



final boolean acquireQueued(final Node node, int arg) {
        boolean failed = true;
        try {
            boolean interrupted = false;
            for (;;) {
                final Node p = node.predecessor();
                //如果node的前驱节点是头节点，表示node是第二个节点，可以尝试获取资源
                if (p == head && tryAcquire(arg)) {
                    //拿到资源后，将head指向这个节点
                    //所以head节点就是当前获取到资源的节点或者是null
                    setHead(node);
                    p.next = null; // help GC
                    failed = false;
                    return interrupted;
                }
                //如果自己可以休息了，就进入waiting状态，直到被unpark()
                if (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt())
                    interrupted = true;
            }
        } finally {
            if (failed)
                cancelAcquire(node);
        }
    }

```

> parkAndCheckInterrupt方法内部使用到了LockSupport.park(this)
>
> LockSupport类是Java6引入的一个类，提供了基本的线程同步原语。
>
> LockSupport实际使用了Unsafe类里面函数，归结到Unsafe里，只有两个函数
>
> - park(boolean isAbsolut,long time):阻塞当前线程
> - unpark(Thread jthread):使给定的线程停止阻塞

所以**节点进入等待队列后，是调用park使它进入阻塞状态的，只有头节点的线程是处于活跃状态的**

除了acquire还有其他三个方法

- acquireInterruptibly:申请可中断的资源（独占模式）
- acquireShared：申请共享模式的资源
- acquireSharedInterruptibly:申请可中断的状态（共享模式）



> 可中断意思为在线程中断时可能会抛出InterrputedException





#### 11.4.2资源的释放

```java
   public final boolean release(int arg) {
        if (tryRelease(arg)) {
            Node h = head;
            if (h != null && h.waitStatus != 0)
                unparkSuccessor(h);
            return true;
        }
        return false;
    }

 private void unparkSuccessor(Node node) {
        /*
         * If status is negative (i.e., possibly needing signal) try
         * to clear in anticipation of signalling.  It is OK if this
         * fails or if status is changed by waiting thread.
         */
        int ws = node.waitStatus;
        if (ws < 0)
            compareAndSetWaitStatus(node, ws, 0);

        /*
         * Thread to unpark is held in successor, which is normally
         * just the next node.  But if cancelled or apparently null,
         * traverse backwards from tail to find the actual
         * non-cancelled successor.
         */
        Node s = node.next;
        if (s == null || s.waitStatus > 0) {
            s = null;
            for (Node t = tail; t != null && t != node; t = t.prev)
                if (t.waitStatus <= 0)
                    s = t;
        }
        if (s != null)
            LockSupport.unpark(s.thread);
    }
```

