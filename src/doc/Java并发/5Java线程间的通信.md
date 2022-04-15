### 5.1锁与同步

Java中，锁的概念都是基于对象的，所以通常被称为对象锁。

线程同步是指线程按照一定的顺序来执行



### 5.2通知机制

Java多线程的等待/通知机制是基于Object类的wait()方法和notify()/notifyAll()实现（锁是同一个对象才行）

> notify方法会随机叫醒一个正在等待的线程，而notifyAll方法会叫醒所有正在等待的线程



### 5.3信号量

JDK提供了一个类似于”信号量“功能的类**Semaphore**

也可以基于**volatile**关键字实现信号量通信

> volatile关键字能保证内存的可见性，如果用volatile关键字声明的变量在一个线程里改变了这个变量的值，其他线程是立马可见更改后的值



### 5.4管道

管道是基于**管道流**的通信方式，JDK提供了**PipedReader**，**PipedWriter**，**PipedOutputStream**，**PipedInputStream**，前两个基于字符，后两个基于字节

```java
public class Pipe {
    static class ReaderThread extends Thread {
        private PipedInputStream inputStream;

        public ReaderThread(PipedInputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            System.out.println("this is reader");
            int receive = 0;
            char ch;
            try {
                while ((receive = inputStream.read()) != -1) {
                    System.out.println((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriteThread implements Runnable {
        private PipedOutputStream outputStream;

        public WriteThread(PipedOutputStream outputStream) {
            this.outputStream = outputStream;
        }

        @Override
        public void run() {
            System.out.println("this is writer");
            int receive = 0;
            try {
                outputStream.write("Hello Word".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream();
        outputStream.connect(inputStream);
        Thread a = new Thread(new ReaderThread(inputStream));
        a.start();
        new Thread(new WriteThread(outputStream)).start();
        System.out.println(a.getState());
    }
}

```



### 5.5其他通信相关

#### 5.5.1join

join方法是Thread类的一个实例方法，作用是让当前线程进入等待状态，等join的这个线程执行完毕后再继续执行当前线程

> join有两个重载方法join(long)，join(long,int)
>
> 实际上这两个方法内部都是调用了wait(long)方法
>
> 对于join(long,int)对于第二个参数纳秒做了过半秒当一秒或者long=0当1秒的简单处理
>
> 调用join()时等待join线程执行完毕（一直判断线程是否是isAlive并调用wait方法），带参数的会wait指定时间而不是等待join线程执行完毕



#### 5.5.2sleep方法

sleep方法是Thread类的一个静态方法，作用是让当前线程睡眠一段时间，有两个方法

> sleep(long),sleep(long,int)第二个方法对纳秒参数只做简单判断处理，实际仍调用第一个方法

sleep和wait的区别

> sleep不会释放当前持有的锁，而wait会
>
> wait可以指定时间也可以不指定，而sleep必须指定
>
> wait释放cpu资源和锁，sleep释放cpu资源但是不释放锁
>
> wait必须放在同步块或者同步锁中，sleep可以在任何位置
>
> wait是Object类的实例方法，sleep是Thread类的静态方法



#### 5.5.3ThreadLoacl类

ThreadLocal是一个本地线程副本变量工具类，内部是一个弱引用Map维护



#### 5.5.4InheritedThreadLocal类

和ThreadLocal类似，区别在于子类也可以访问父类的变量