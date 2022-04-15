### 2.1Thread类和Runnable接口

JDK提供了Thread类和Runnable接口来实现线程类

- 继承Thread类，重写run方法
- 实现Runnable接口，实现run方法



### 2.2Thread类构造方法



```java
//init 方法
private void init(ThreadGroup g,Runnable target,String name,long stackSize,AccessControllerContext acc,boolean inheritThreadLocals){}
  
//构造器调用init方法
public Thread(Runnable target){
    init(null,target,"Thread-"+nextThreadNum(),0);
}

//片段3，使用init方法里初始化AccessControllerContext类型的私有属性
this.inhertiedAccessControllerContext = acc!=null?acc:AccessController.getContext();

//片段4，两个对用于支持ThreadLoacl的私有属性
ThreadLocal.ThreadLocalMap threadLoacls = null;
ThreadLoacl.ThreadLocalMap inheritableThreadLoacls = null;
```

大多数情况下直接调用

```
Thread(Runnable target)和Thread(Runnable target,String name)
```



### 2.3Thread常用方法

- currentThread():静态方法，返回当前正在执行的线程对象的引用
- start():开始执行线程的方法，Java虚拟机会调用线程内的run方法
- yield():当前线程愿意让出对当前处理器的占用，但是不一定有效，即调用yield方法后程序在调度时仍有可能执行这个线程
- sleep()：静态方法，使当前线程睡眠一段时间
- join():使当前线程等待另一个线程执行完毕后再继续执行，内部调用Object的wait()方法实现



sleep方法和wait方法的区别

1.sleep是Thread类的静态本地方法，wait是Object类的本地方法

2.sleep不会对象锁，wait会释放对象锁

3.sleep不需要在同步块中调用，wati需要在同步块中调用

4.sleep需要一个时间参数，到时间自动唤醒，wait可以不传入时间参数，此时需要notify/notifyAll唤醒





### 2.4Thread类和Runnable接口的比较

- 由于Java“单继承，多实现”特征，Runnable接口比Thread类更灵活
- Runnable更符合面向对象特征，将线程单独进行对象的封装
- Runnable接口的出现，降低了线程对象和线程任务的耦合性
- 如果使用线程时不需要使用Thread类的诸多方法，显然使用Runnable更轻量









## 2.5Callable、Future与FutureTask

使用Runnable和Thread创建的线程有一个弊端，run方法没有返回值，JDK提供了Callable接口和Future类为我们解决这个问题，这也是所谓的==“异步模型”==

### 2.5.1Callable接口

```
//Callable接口和Runnable接口类型，同样是只有一个抽象方法的函数式接口，不同的是Callable接口的方法有返回值，而且支持泛型
@FunctionalInterfac
public Intreface Callable{
	V call() throws Exception;
}
```

Callable一般配合线程池工具ExecutorService来使用，ExecutorService可以调用submit方法来让一个Callable接口执行，它会返回一个Future,我们后续的程序可以通过这个Future的get方法得到结果



### 2.5.2Future接口

Future接口只有几个简单的方法

```java
public interface Future<V> {

    /**
     * Attempts to cancel execution of this task.  This attempt will
     * fail if the task has already completed, has already been cancelled,
     * or could not be cancelled for some other reason. If successful,
     * and this task has not started when {@code cancel} is called,
     * this task should never run.  If the task has already started,
     * then the {@code mayInterruptIfRunning} parameter determines
     * whether the thread executing this task should be interrupted in
     * an attempt to stop the task.
     *
     * <p>After this method returns, subsequent calls to {@link #isDone} will
     * always return {@code true}.  Subsequent calls to {@link #isCancelled}
     * will always return {@code true} if this method returned {@code true}.
     *
     * @param mayInterruptIfRunning {@code true} if the thread executing this
     * task should be interrupted; otherwise, in-progress tasks are allowed
     * to complete
     * @return {@code false} if the task could not be cancelled,
     * typically because it has already completed normally;
     * {@code true} otherwise
     */
    boolean cancel(boolean mayInterruptIfRunning);

    /**
     * Returns {@code true} if this task was cancelled before it completed
     * normally.
     *
     * @return {@code true} if this task was cancelled before it completed
     */
    boolean isCancelled();

    /**
     * Returns {@code true} if this task completed.
     *
     * Completion may be due to normal termination, an exception, or
     * cancellation -- in all of these cases, this method will return
     * {@code true}.
     *
     * @return {@code true} if this task completed
     */
    boolean isDone();

    /**
     * Waits if necessary for the computation to complete, and then
     * retrieves its result.
     *
     * @return the computed result
     * @throws CancellationException if the computation was cancelled
     * @throws ExecutionException if the computation threw an
     * exception
     * @throws InterruptedException if the current thread was interrupted
     * while waiting
     */
    V get() throws InterruptedException, ExecutionException;

    /**
     * Waits if necessary for at most the given time for the computation
     * to complete, and then retrieves its result, if available.
     *
     * @param timeout the maximum time to wait
     * @param unit the time unit of the timeout argument
     * @return the computed result
     * @throws CancellationException if the computation was cancelled
     * @throws ExecutionException if the computation threw an
     * exception
     * @throws InterruptedException if the current thread was interrupted
     * while waiting
     * @throws TimeoutException if the wait timed out
     */
    V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}

```

如果为了可取消性使用Future又不提供可使用的结果，可以声明Future<?>形式类型，并返回null作为底层任务的结果



### 2.5.3FutureTask类

FutureTask类实现了RunnableFuture接口，这个接口同时继承了Future和Runnable接口

在高并发环境下，FutureTask能确保任务只执行一次



### 2.5.4FutureTask的几个状态

```java
 /**
     * The run state of this task, initially NEW.  The run state
     * transitions to a terminal state only in methods set,
     * setException, and cancel.  During completion, state may take on
     * transient values of COMPLETING (while outcome is being set) or
     * INTERRUPTING (only while interrupting the runner to satisfy a
     * cancel(true)). Transitions from these intermediate to final
     * states use cheaper ordered/lazy writes because values are unique
     * and cannot be further modified.
     *
     * Possible state transitions:
     * NEW -> COMPLETING -> NORMAL
     * NEW -> COMPLETING -> EXCEPTIONAL
     * NEW -> CANCELLED
     * NEW -> INTERRUPTING -> INTERRUPTED
     */
    private volatile int state;
    private static final int NEW          = 0;
    private static final int COMPLETING   = 1;
    private static final int NORMAL       = 2;
    private static final int EXCEPTIONAL  = 3;
    private static final int CANCELLED    = 4;
    private static final int INTERRUPTING = 5;
    private static final int INTERRUPTED  = 6;java
```

