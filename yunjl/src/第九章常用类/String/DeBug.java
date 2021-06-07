package 第九章常用类.String;

/**
 * @author Yunjl
 * @create 2021-04-11 21:53
 */
public class DeBug {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
        System.out.println(sb1);//
    }
}
