package 第九章常用类.System类;

import org.junit.Test;

/**
 * System类代表系统，系统级的很多属性和控制方法都放置在该类的内部。该类位于java.lang包。
 *  由于该类的构造器是private的，所以无法创建该类的对象，也就是无法实例化该类。
 *    其内部的成员变量和成员方法都是static的，所以也可以很方便的进行调用。
 *  成员变量
      System类内部包含in、out和err三个成员变量，分别代表标准输入流(键盘输入)，标准输出流(显示器)和标准错误输出流(显示器)。
 *  成员方法
      native long currentTimeMillis()：
        该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数。
      void exit(int status)：
        该方法的作用是退出程序。其中status的值为0代表正常退出，非零代表异常退出。
        使用该方法可以在图形界面编程中实现程序的退出功能等。
      void gc()：
        该方法的作用是请求系统进行垃圾回收。
        至于系统是否立刻回收，则取决于系统中垃圾回收算法的实现以及系统执行时的情况。
      String getProperty(String key)：
        该方法的作用是获得系统中属性名为key的属性对应的值。

 * @author Yunjl
 * @create 2021-04-12 17:39
 */
public class System类 {
    @Test
    public void test(){
        String javaVersion = System.getProperty("java.version");    //java的版本
        System.out.println("java的version:" + javaVersion);

        String javaHome = System.getProperty("java.home");          //java文件的路径
        System.out.println("java的home:" + javaHome);

        String osName = System.getProperty("os.name");              //系统的名称
        System.out.println("os的name:" + osName);

        String osVersion = System.getProperty("os.version");        //系统的版本
        System.out.println("os的version:" + osVersion);

        String userName = System.getProperty("user.name");          //系统的用户名
        System.out.println("user的name:" + userName);

        String userHome = System.getProperty("user.home");          //系统用户名路径
        System.out.println("user的home:" + userHome);

        String userDir = System.getProperty("user.dir");            //用户当前工作目录
        System.out.println("user的dir:" + userDir);
    }
}
