package 第八章线程.线程;

/**
 * 多线程的创建
 * 方式一:
 * 1.创建一个继承于Thread的子类
 * 2.重写Thread类的run()方法 --->将此线程执行的操作声明在run()中
 * 3.创建Thread的子类的对象
 * 4.通过此对象调用start()
 * <p>
 * 例子：遍历100以内所有的偶数
 *
 * @author Yunjl
 * @create 2021-04-09 16:05
 */

//1.创建一个继承于Thread的子类
class MyThread extends Thread {

    //2.重写Thread类的run()方法
    @Override
    public void run() {
        //遍历100以内所有的偶数
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

}

public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建Thread的子类的对象
        MyThread t1 = new MyThread();

        //4.通过此对象调用start(),启动上面的线程，调用线程的run()
        t1.start();

        //不能通过对象.方法() 的形式调用线程
//        t1.run();

        //在启动一个线程，需要在new一个对象
        MyThread t2 = new MyThread();
        t2.start();

        //以下操作任然是在主线程中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "*******");
            }
        }
    }
}
