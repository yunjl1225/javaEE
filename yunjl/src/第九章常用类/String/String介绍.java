package 第九章常用类.String;
import org.junit.Test;

/**
 *  String类：代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
 *  String是一个final类，代表不可变的字符序列。
 *  字符串是常量，用双引号引起来表示。它们的值在创建之后不能更改。
 *  String对象的字符内容是存储在一个字符数组value[]中的。
 *
 * @author Yunjl
 * @create 2021-04-10 21:45
 */
/*
    String:字符串，使用一对""引起来表示。
    1.String声明为final的，不可被继承
    2.String实现了Serializable接口：表示字符串是支持序列化的。
            实现了Comparable接口：表示String可以比较大小
    3.String内部定义了final char[] value用于存储字符串数据
    4.String:代表不可变的字符序列。简称：不可变性。
        体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
             2. 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
             3. 当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
    5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
    6.字符串常量池中是不会存储相同内容的字符串的。
     */
public class String介绍 {
    /*
    结论：
    1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
    2.只要其中有一个是变量，结果就在堆中。
    3.如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test4() {
        java.lang.String s1 = "javaEEhadoop";
        java.lang.String s2 = "javaEE";
        java.lang.String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);//false

        final java.lang.String s4 = "javaEE";//s4:常量
        java.lang.String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);//true

    }

    @Test
    public void test1() {
        java.lang.String s1 = "javaEE";
        java.lang.String s2 = "hadoop";

        java.lang.String s3 = "javaEEhadoop";
        java.lang.String s4 = "javaEE" + "hadoop";
        java.lang.String s5 = s1 + "hadoop";
        java.lang.String s6 = "javaEE" + s2;
        java.lang.String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        java.lang.String s8 = s6.intern();//返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8);//true


    }
}
