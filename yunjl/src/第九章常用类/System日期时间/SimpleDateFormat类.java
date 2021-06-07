package 第九章常用类.System日期时间;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *      jdk 8之前的日期时间的API测试
   Date类的API不易于国际化，大部分被废弃了，
    java.text.SimpleDateFormat类是一个不与语言环境有关的方式来格式化和解析日期的具体类。
  它允许进行格式化：日期文本（字符串）、解析：文本（字符串）日期
  格式化：
      SimpleDateFormat() ：默认的模式和语言环境创建对象
      public SimpleDateFormat(String pattern)：该构造方法可以用参数pattern指定的格式创建一个对象，该对象调用：
      public String format(Date date)：方法格式化时间对象date
  解析：
     public Date parse(String source)：从给定字符串的开始解析文本，以生成一个日期

 * @author Yunjl
 * @create 2021-04-11 22:37
 */
public class SimpleDateFormat类 {
    @Test
    public void test() throws ParseException {
        //实例化SimpleDateFormat，使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期文本（字符串）
        Date date = new Date();
        System.out.println(date);   //Sun Apr 11 22:44:13 CST 2021

        String format = sdf.format(date);   //格式化
        System.out.println(format); //21-4-11 下午10:45

        //解析： 文本（字符串）日期
        String str = "19-12-18 上午11:43";
        Date date1 = sdf.parse(str);
        System.out.println(date1);


        //*************按照指定的方式格式化和解析：调用带参的构造器*****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);//2019-02-18 11:48:27
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        Date date2 = sdf1.parse("2020-02-18 11:48:27");
        System.out.println(date2);

    }
    /*
    练习一：字符串"2020-09-08"转换为java.sql.Date

    练习二："三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？

    举例：2020-09-08 ？ 总天数

    总天数 % 5 == 1,2,3 : 打渔
    总天数 % 5 == 4,0 : 晒网

    总天数的计算？
    方式一：毫秒数 ( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
    方式二：1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
//        System.out.println(date);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }


    /*
    Calendar日历类(抽象类）的使用

     */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
}
