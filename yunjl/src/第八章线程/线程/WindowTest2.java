package 第八章线程.线程;

/**
 * 创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方法
 * @author Yunjl
 * @create 2021-04-09 20:27
 */
class Window2 implements Runnable{

    private  int ticket = 100;//票数,这里不需要声明为static，因为main中只创建了一个Window2类的对象
    @Override
    public void run() {
        while (true) {
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket --;
            }else if(ticket == 0){
                System.out.println("票已卖完");
                break;
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

        t1.start();
        t2.start();
        t3.start();
    }

}
