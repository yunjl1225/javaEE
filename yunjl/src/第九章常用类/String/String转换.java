package 第九章常用类.String;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.lang.String;
import java.util.Arrays;

/**
 * 涉及到String类与其他类转换
 *
 * @author Yunjl
 * @create 2021-04-11 9:11
 */
public class String转换 {
    /*
    String 与基本数据类型、包装类之间的转换。

        String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
        基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)
     */
    @Test
    public void test1(){
        String s1 = "12345";
        int i1 = Integer.parseInt(s1);      //String --> 基本数据类型、包装类 调用包装类的静态方法：parseXxx(str)
        System.out.println(i1);//12345

        String s2 = String.valueOf(i1+1);    //基本数据类型、包装类 --> String    调用String重载的valueOf(xxx)
        System.out.println(s2);//"12346"
    }

    /*
    String 与 char[] 之间的转换

        String ---> char[] :    调用String的toCharArray()
        char[] ---> String ：   调用String的构造器
     */
    @Test
    public void test2(){
        String s1 = "abc123";
        char[] c1 = s1.toCharArray();           //String ---> char[] :    toCharArray()
        for (int i = 0; i < c1.length; i++) {   //遍历chars数组
            System.out.println(c1[i]);
        }

        char arr[] = new char[]{'y','u','n','j','l'};
        String s2 = new String(arr);            //char[] ---> String ：   调用String的构造器
        System.out.println(s2);

    }
    /*
    String 与 字节数组byte[] 之间的转换

        编码：String --> byte[]:调用String的getBytes()
        解码：byte[] --> String:调用String的构造器

        编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
        解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）

        说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码。
        System.out.println(Arrays.toString(bytes));
        System.out.println(str1);

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码。
        System.out.println(Arrays.toString(gbks));

        System.out.println("******************");

        String str2 = new String(bytes);//使用默认的字符集，进行解码。
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3);//出现乱码。原因：编码集和解码集不一致！


        String str4 = new String(gbks, "gbk");
        System.out.println(str4);//没有出现乱码。原因：编码集和解码集一致！

    }
}
