package 第八章线程.线程安全问题;

/**
 * 使用同步代码块的方式来解决继承Thread类的方式创建线程导致的线程安全问题
 *
 * 例子：创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
 *
 * @author Yunjl
 * @create 2021-04-09 18:28
 */
public class WindowTest1 {

    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();

    }
}

class Window extends Thread {
    private static int ticket = 100;//票数
//    Object obj = new Object();        //多个线程必须共用同一把锁,main中new了三个对象，三把锁
    private static Object obj = new Object();

    //卖票
    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
            //或者
//            synchronized(Window.class){   //Window.class智慧加载一次，唯一，

            //错误的，这里创建了三个对象，不能用this
            // synchronized (this) {
                if (ticket > 0) {

                    //这里线程安全问题
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else if (ticket == 0) {
                    break;
                }
            }
        }
    }
}