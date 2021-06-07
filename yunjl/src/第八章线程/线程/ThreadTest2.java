package 第八章线程.线程;

/**
 * 多线程的创建
 * 方式二 （实现Runnable接口）（推荐使用方式二，类的单继承局限性，方式一类不能继承其他类）
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法: run()---->将此线程执行的操作声明在run()中
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()-->调用了Runnable类型的target的run()
 *
 *两个创建线程的方式的比较
 *  开发中优先选择方式二（实现Runnable接口）
 *      原因：1.实现的方式没有类的单继承性的局限性
 *           2.实现的方式更适合来处理多个线程有共享数据的情况。（如：不需要加static修饰）
 *  联系：Thread本身也是实现了Runnable接口
 *      两种方式都需要重写run()方法，将线程需要执行的操作放在run()方法中
 *
 * @author Yunjl
 * @create 2021-04-09 18:44
 */
//1.创建一个实现了Runnable接口的类
class MyThread2 implements Runnable {
    //2.实现类去实现Runnable中的抽象方法:
    //重写接口中的抽象方法，将此线程执行的操作声明在run()中
    @Override
    public void run() {
        //遍历100以内所有的偶数
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
//3.创建实现类的对象
        MyThread2 m1 = new MyThread2();

//4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(m1);
        t1.setName("线程一");
//5.通过Thread类的对象调用start()
        t1.start();

//再启动一个线程，遍历100以内所有的偶数
        Thread t2 = new Thread(m1);
        t2.setName("线程二");
        t2.start();
    }


}
