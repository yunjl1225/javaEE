package 第八章线程.exer;

/**
 * 线程Thread的练习
 * 创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程100以内的奇数
 * @author Yunjl
 * @create 2021-04-09 16:32
 */
public class ThreadDome {
    public static void main(String[] args) {
//        MyThread1 t1 = new MyThread1();
//        t1.start();
//        MyThread2 t2 = new MyThread2();
//        t2.start();

        //或者创建Thread的匿名子类
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 ==0){
                        System.out.println(i + "Thread匿名子类1");
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    if(i % 2 !=0){
                        System.out.println(i+ "Thread匿名子类2");
                    }
                }
            }
        }.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 ==0){
                System.out.println(i + "Thread1");
            }
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if(i % 2 !=0){
                System.out.println(i+ "Thread2");
            }
        }
    }
}