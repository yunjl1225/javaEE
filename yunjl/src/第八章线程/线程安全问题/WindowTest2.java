package 第八章线程.线程安全问题;

/**
 * 线程安全问题
 * 创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方法
 *
 *  1.卖票过程中出现了错票、重票--->线程安全
 *  2.出现问题的原因：当某个线程操作车票的过程中，尚未完成操作，其他线程参与进来也操作车票导致
 *  3.如何解决：当一个线程执行时，其他线程不能参与进来，直到执行结束
 *  4.在java中我们通过同步机制来解决线程安全问题
 *
 *      方式一：同步代码块   （Test1、2）
 *                  synchronized(同步监视器){
 *                      //需要被同步的代码
 *                  }
 *                  说明：1.操作共享数据的代码即为需要被同步的代码
 *                       2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
 *                       3.同步监视器：俗称：锁。任何一个类的对象都可以充当锁
 *                          要求：多个线程必须要共用同一把锁
 *                      补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
 *                            在继承Thread类创建多线程的方式中，慎用this充当同步监视器，可以考虑使用当前类充当同步监视器
 *
 *      方式二：同步方法    （Test3、4）
 *                  如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的。
 *                  总结：1.同步方法仍然涉及到同步监视器只是不需要我显式的声明。
 *                       2.非静态的同步方法，同步监视器为：this
 *                          静态的同步方法，同步监视器为：当前类本身（类名.class）
 *      方式三：Lock锁      （Test5、6）             ---JDK5.0新增
 *
 *  面试题1：使用synchronized 与 lock 的异同？
 *          同：都可以解决线程安全问题
 *          异：synchronized机制在执行完相应的同步代码后，自动释放同步监视器（锁）
 *              lock需要手动的启动（lock()）、结束（unlock()）同步
 *  面试题2：如何解决线程安全问题？有几种方式？
 *
 *  优先使用顺序：
 *          Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 *
 *  5.使用同步的方式，解决了线程安全的问题。（优点）
 *    操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。（缺点）
 *
 * @author Yunjl
 * @create 2021-04-09 20:27
 */
class Window2 implements Runnable {

    private int ticket = 100;//票数,这里不需要声明为static，因为main中只创建了一个Window2类的对象
    Object obj = new Object();

    //同步代码块
    @Override
    public void run() {
//        Object obj = new Object();    不能放在这里，多个线程必须共用同一把锁
        while (true) {
            synchronized (this) {    //synchronized (obj) {     这里只创建了一个对象w,this代指唯一对象w。
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);//睡眠100毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else if (ticket == 0) {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w = new Window2();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        Thread t4 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
