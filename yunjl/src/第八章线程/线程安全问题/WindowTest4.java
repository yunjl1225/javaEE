package 第八章线程.线程安全问题;

/**
 *  使用同步方法解决继承Thread类创建线程导致的线程安全问题
 * @author Yunjl
 * @create 2021-04-10 12:09
 */
public class WindowTest4 {

    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();

    }
}

class Window4 extends Thread {
    private static int ticket = 100;//票数，需要声明为static

    //卖票
    @Override
    public void run() {
        while (true) {
            show();
            if(ticket <= 0){
                break;
            }
        }
    }
    //同步方法
    private static synchronized void show(){    //同步监视器：Window4.class
//    private synchronized void show(){    //同步监视器：this，但是在main中创建了三个对象，锁不唯一
        if (ticket > 0) {

            //这里线程安全问题
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票、票号为：" + ticket);
            ticket--;
        }
    }
}