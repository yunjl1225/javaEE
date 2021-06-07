package 第九章常用类.System日期时间;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * @author Yunjl
 * @create 2021-04-11 15:55
 */
public class DateTime {
    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);

    }

    /*
   java.util.Date类
          |---java.sql.Date类

   1.两个构造器的使用
       >构造器一：Date()：创建一个对应当前时间的Date对象
       >构造器二：创建指定毫秒数的Date对象
   2.两个方法的使用
       >toString():显示当前的年、月、日、时、分、秒
       >getTime():获取当前Date对象对应的毫秒数。（时间戳）

   3. java.sql.Date对应着数据库中的日期类型的变量
       >如何实例化
       >如何将java.util.Date对象转换为java.sql.Date对象
    */
    @Test
    public void test2(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//显示当前时间   Sun Apr 11 15:58:38 CST 2021

        System.out.println(date1.getTime());//1550306204104

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1550350620410L);
        System.out.println(date2.toString());

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(35235325345L);
        System.out.println(date3);//1971-02-13

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(2343243242323L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());


    }

}
