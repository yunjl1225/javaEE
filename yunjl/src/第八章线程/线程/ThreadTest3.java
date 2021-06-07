package 第八章线程.线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 方式三：   实现Callable接口                  JDK5.0新增
 * <p>
 * 与使用Runnable相比， Callable功能更强大些
 *  相比run()方法，可以有返回值
 *  方法可以抛出异常
 *  支持泛型的返回值
 *  需要借助FutureTask类，比如获取返回结果
 *
 *
 *
 *
 *
 * 1.创建一个实现Callable接口的实现类
 * 2.实现call()方法，将此线程需要执行的操作放在call()方法中（可以有返回值）
 * 3.创建Callable接口实现类的对象
 * 4.将此Callable接口实现类的对象作为参数传递到FutureTask的构造器中，创建FutureTask类的对象
 * 5.将FutureTask类的对象作为参数传递到Thread类的构造器中，创建Thread类的对象，并调用start()
 * 6.利用FutureTask类的对象的get()方法获取Callable中call()方法的返回值
 *
 * @author Yunjl
 * @create 2021-04-10 18:36
 */
//1.创建一个实现Callable接口的实现类
class NumThread implements Callable {
    private int sum;

//2.实现call()方法，将此线程需要执行的操作放在call()方法中（可以有返回值）
    //需要重写call()方法，遍历1-100的偶数，并且返回和
    @Override
    public Object call() throws Exception {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }

        }
        return sum;
    }
}

public class ThreadTest3 {
    public static void main(String[] args) {
//3.创建Callable接口实现类的对象
        NumThread n = new NumThread();
//4.将此Callable接口实现类的对象作为参数传递到FutureTask的构造器中，创建FutureTask类的对象
        FutureTask f = new FutureTask(n);
//5.将FutureTask类的对象作为参数传递到Thread类的构造器中，创建Thread类的对象，并调用start()
        new Thread(f).start();
//6.利用FutureTask类的对象的get()方法获取Callable中call()方法的返回值
        try {
            //get()的返回值即为FutureTask构造器参数Callable实现类重写的call()方法的返回值
            Object sum = f.get();
            System.out.println("总和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        

    }
}
