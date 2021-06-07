package 第九章常用类.String;

import java.lang.String;

/**
 * @author Yunjl
 * @create 2021-04-10 23:03
 */
public class StringTest {
    String str = new  String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public void change(String str, char ch[]) {
//        this.str = "test ok";       //test ok
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }
}
