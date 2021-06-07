package 第八章线程.线程通信;

/**
 * 线程通信的例子：
 * 使用两个线程打印 1-100。线程1, 线程2 交替打印
 * <p>
 * 涉及到的方法：
 * wait()          一旦执行此方法，当前线程就进入阻塞状态，并释放锁
 * notify()        一旦执行此方法，就会唤醒被wait()的一个线程，如果有多个线程，则唤醒优先级高的那个
 * notifyAll()     一旦执行此方法，就会唤醒被wait()的所有线程。
 * 前提：
 * 1.必须使用在同步代码块或同步方法中
 * 2.三个方法的调用者必须是同步代码块或同步的方法中的同步监视器
 *    否则会出现异常：IllegalMonitorStateException
 * 3.上面三个方法都是定义在Object类中的
 *
 * 面试题：sleep() 与 wait() 的异同
 *  同：都可以使当前线程进入阻塞状态
 *  异：1）声明的位置不同：        Thread类中声明静态的sleep()            Object类中声明的wait()
 *      2）调用的要求不同：       sleep()可以在任何需要的场景下被调用     wait()必须在同步代码块或同步方法中
 *      3）关于是否释放同步监视器的问题：如果两个方法都是用在同步代码块或同步方法中
 *                               sleep()不释放                         wait()释放同步监视器
 * @author Yunjl
 * @create 2021-04-10 17:05
 */
class Number implements Runnable {
    private int num = 1;
//    private Object obj = new Object();    //下面的this也都得换成obj

    @Override
    public void run() {
        while (true) {

            //同步代码块解决线程安全问题
            synchronized (this) {

                this.notify();//唤醒一个线程

                if (num <= 100) {

                    try {//输出延迟10毫秒
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;

                    //输出一个数后阻塞一下
                    try {
                        this.wait();//使当前线程进入阻塞状态，并释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}

public class Communication {
    public static void main(String[] args) {
        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
