package 第八章线程.线程安全问题;

/**
 * 使用同步方法解决实现Runnable接口创建线程导致的线程安全问题
 *
 * @author Yunjl
 * @create 2021-04-10 11:54
 */
class Window3 implements Runnable {

    private int ticket = 100;//票数,这里不需要声明为static，因为main中只创建了一个Window2类的对象

    @Override
    public void run() {
        while (true) {
            show();
            //结束while循环
            if(ticket <= 0){
                break;
            }
        }
    }
    //同步方法
    private synchronized void show(){//同步监视器：this
        if (ticket > 0) {
            try {
                Thread.sleep(100);//睡眠100毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }

}