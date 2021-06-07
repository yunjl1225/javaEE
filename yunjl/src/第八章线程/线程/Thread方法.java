package 第八章线程.线程;

/**
 * 测试Thread类中的方法
 *  1.start()             启动当前线程，调用当前线程的run()方法
 *  2.run()               通常需要重写，将创建的线程需要执行的操作放在里面
 *  3.currentThread()     静态方法返回当前代码正在执行的线程
 *  4.getName()           获取当前线程的名字
 *  5.setName()           设置当前线程的名字
 *  6.yield()             释放当前CPU的执行权
 *  7.join()              在线程a中调用线程b的join()方法，此时线程a进入阻塞状态，等b执行结束后才会继续执行
 *  8.stop()              已过时不推荐使用，当执行此方法时，强制结束当前线程
 *  9.sleep(long millitime):使当前线程睡眠（ 单位毫秒）睡眠期间是阻塞状态
 *  10.isAlive()          判断当前线程是否还存活，返回true OR false
 *
 * 线程的优先级
 *  1.线程的优先级等级
 *      MAX_PRIORITY：10    最大
 *      MIN _PRIORITY：1    最低
 *      NORM_PRIORITY：5    (默认优先级)
 *  2.如何获取设置当前线程的优先级
 *      setPriority(int p);
 *      getPriority();
 *
 * @author Yunjl
 * @create 2021-04-09 16:46
 */
public class Thread方法 {

    public static void main(String[] args) {
        Threadfangfa t1 = new Threadfangfa();
        t1.setName("yunjl");//设置分线程的名字
        t1.setPriority( 1);//设置分线程的优先级

        t1.start();
        System.out.println(Thread.currentThread());//获取main主线程
        System.out.println(Thread.currentThread().getName()+ "\t猪线程的名字");//获取main主线程
        Thread.currentThread().setName("主线程");//获取main主线程
        System.out.println(Thread.currentThread().getName()+ "\t猪线程的新名字" + "\t优先级：" + Thread.currentThread().getPriority() );//获取main主线程
        System.out.println(t1.getName() + "\t线程的名字");
        System.out.println(Threadfangfa.currentThread().getName() + "\t主线程main");
        for (int i = 0; i < 100; i++) {
            if(i % 2 ==0){
                System.out.println(i + "\tmain");
            }
            //此时主线程main进入阻塞状态，等分线程执行结束后才会继续执行
            if(i == 1){
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Threadfangfa extends Thread{
    @Override
    public void run() {
        System.out.println("hello");
        System.out.println(Threadfangfa.currentThread().getName() + "\t分线程里" + "\t优先级：" + Threadfangfa.currentThread().getPriority());
        for (int i = 0; i < 100; i++) {
            if(i % 2 ==0){
                System.out.println(i + "\tThread");
            }

            if(i == 2){
                try {
                    sleep(100);//睡眠100毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //释放当前CPU的执行权
            if(i % 20 == 0){
                yield();
            }
        }

    }
}