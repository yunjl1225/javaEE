package 第八章线程.线程安全问题;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock锁方法解决实现Runnable接口创建线程导致的线程安全问题
 *
 *
 * @author Yunjl
 * @create 2021-04-10 15:50
 */
class Window5 implements Runnable {

    private int ticket = 100;//票数,这里不需要声明为static，因为main中只创建了一个Window2类的对象

    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try{
                //2.调用锁定lock方法
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);//睡眠100毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票、票号为：" + ticket);
                    ticket--;
                } else if (ticket == 0) {
                    break;
                }
            }finally {
                //调用解锁方法
                lock.unlock();
            }

        }
    }
}

public class WindowTest5 {
    public static void main(String[] args) {
        Window5 w = new Window5();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }

}