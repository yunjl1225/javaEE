package 第八章线程.线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 *  方式四：    使用线程池                   JDK5.0新增
 *
 * 1.提供指定线程数量的线程池
 * 2.执行指定的线程，需要提供实现Runnable接口或者Callable接口实现类的对象
 * 3.关闭连接池
 * 4.
 *
 *  提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。
 *  可以避免频繁创建销毁、实现重复利用。
 *  好处：
  提高响应速度（减少了创建新线程的时间）
  降低资源消耗（重复利用线程池中线程，不需要每次都创建）
  便于线程管理

 Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池
  Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池
  Executors.newFixedThreadPool(n); 创建一个可重用固定线程数的线程池
  Executors.newSingleThreadExecutor() ：创建一个只有一个线程的线程池
  Executors.newScheduledThreadPool(n)：创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行


 * @author Yunjl
 * @create 2021-04-10 18:37
 */
class NumberThread1 implements Runnable{


    @Override
    public void run() {
        for (int i = 1; i <= 100 ; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class NumberThread2 implements Callable {
    private int sum;

    @Override
    public Object call() throws Exception {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadTest4 {
    public static void main(String[] args) {
//1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
//2.执行指定的线程，需要提供实现Runnable接口或者Callable接口实现类的对象
        service.execute(new NumberThread1());//适用于Runnable

        service.submit(new FutureTask(new NumberThread2())); //适用于Callable
//3.关闭连接池
        service.shutdown();
    }
}
