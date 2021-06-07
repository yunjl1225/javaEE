package 第八章线程.线程;

/**
 * 例子：创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
 *
 * @author Yunjl
 * @create 2021-04-09 18:28
 */
public class WindowTest {

    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");
        w1.start();
        w2.start();
        w3.start();

    }
}

class Window extends Thread {
    private static int ticket = 100;//票数

    //卖票
    @Override
    public void run() {
        while (true) {
            if(ticket > 0){
                System.out.println(getName() + ":卖票，票号为：" + ticket);
                ticket --;
            }else if(ticket == 0){
                System.out.println("票已卖完");
                break;
            }
        }
    }
}