package 第九章常用类.String;

import org.junit.Test;

import java.lang.String;

/**
 *  int length()：            返回字符串的长度： return value.length
 *  char charAt(int index)：  返回某索引处的字符return value[index]
 *  boolean isEmpty()：       判断是否是空字符串：return value.length == 0
 *  String toLowerCase()：    使用默认语言环境，将 String 中的所有字符转换为小写
 *  String toUpperCase()：    使用默认语言环境，将 String 中的所有字符转换为大写
 *  String trim()：           返回字符串的副本，忽略前导空白和尾部空白
 *  boolean equals(Object obj)：  比较字符串的内容是否相同
 *  boolean equalsIgnoreCase(String anotherString)：  与equals方法类似，忽略大小写
 *  String concat(String str)：   将指定字符串连接到此字符串的结尾。 等价于用“+”
 *  int compareTo(String anotherString)： 比较两个字符串的大小
 *  String substring(int beginIndex)：    返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
 *  String substring(int beginIndex, int endIndex) ： 返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
 *  boolean endsWith(String suffix)： 测试此字符串是否以指定的后缀结束
 *  boolean startsWith(String prefix)：   测试此字符串是否以指定的前缀开始
 *  boolean startsWith(String prefix, int toffset)：  测试此字符串从指定索引开始的子字符串是否以指定前缀开始
 *  boolean contains(CharSequence s)：    当且仅当此字符串包含指定的 char 值序列时，返回 true
 *  int indexOf(String str)： 返回指定子字符串在此字符串中第一次出现处的索引
 *  int indexOf(String str, int fromIndex)：  返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
 *  int lastIndexOf(String str)： 返回指定子字符串在此字符串中最右边出现处的索引
 *  int lastIndexOf(String str, int fromIndex)：  返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
 * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
 * 替换
 *  String replace(char oldChar, char newChar)：  返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
 *  String replace(CharSequence target, CharSequence replacement)：   使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
 *  String replaceAll(String regex, String replacement) ：    使 用 给 定 的replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
 *  String replaceFirst(String regex, String replacement) ：  使 用 给 定 的replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
 * 匹配
 *  boolean matches(String regex)：   告知此字符串是否匹配给定的正则表达式。
 * 切片
 *  String[] split(String regex)：    根据给定正则表达式的匹配拆分此字符串。
 *  String[] split(String regex, int limit)： 根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
 *
 * @author Yunjl
 * @create 2021-04-10 23:18
 */
public class String常用方法 {

    @Test
    public void test1() {
        String s1 = "HelloWorld";

        System.out.println(s1.length());    //返回字符串的长度
        System.out.println(s1.charAt(2));   //返回某索引处的字符,范围char数组长度0-9
        System.out.println(s1.isEmpty());   //判断是否是空字符串,return value.length == 0
        System.out.println(s1.toLowerCase());//将 String 中的所有字符转换为小写
        System.out.println(s1.toUpperCase());//将 String 中的所有字符转换为大写
        System.out.println(s1);              //s1不可变，仍然为HelloWorld

        String s2 = "  Hel  lo   Wo rld   ";
        String s3 = s2.trim();      //返回字符串的副本，忽略前导空白和尾部空白
        System.out.println(s3);
        System.out.println(s2);     //s2不变
        System.out.println(s1.equals(s2));  //比较字符串的内容是否相同
        System.out.println(s1.equalsIgnoreCase(s1.toLowerCase()));  //与equals方法类似，忽略大小写

        String s4 = "abc";
        String s5 = s4.concat("def");       //将指定字符串连接到此字符串的结尾。 等价于用“+”
        System.out.println(s5);

        String s6 = new String("abd");
        System.out.println(s4.compareTo(s6));       //比较两个字符串的大小,返回负数表示前面的小

        String s7 = "0123456789";
        System.out.println(s7.substring(2));    //返回一个新的字符串，它是此字符串的从参数下标开始截取到最后的一个子字符串。
        System.out.println(s7.substring(2, 5)); //返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。

        System.out.println(s7.endsWith("9"));   //测试此字符串是否以指定的后缀结束
        System.out.println(s7.startsWith("01"));//测试此字符串是否以指定的前缀开始
        System.out.println(s7.startsWith("234", 2));//测试此字符串从指定索引开始的子字符串是否以指定前缀开始

        String s8 = "yunjl1150447nj718";
        String s9 = "nj";
        System.out.println(s8.contains(s9));    //当且仅当此字符串包含指定的 char 值序列时，返回 true
        System.out.println(s8.indexOf(s9));     //返回指定子字符串在此字符串中第一次出现处的索引,未找到返回-1
        System.out.println(s8.indexOf(s9, 3));     //返回指定子字符串在此字符串中第一次出现处的索引,从指定的索引开始，未找到返回-1
        System.out.println(s8.lastIndexOf(s9)); //返回指定子字符串在此字符串中最右边出现处的索引,从后往前找，返回的仍然是正索引，未找到返回-1
        System.out.println(s8.lastIndexOf(s9, 2));//返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索，未找到返回-1

    }

    @Test
    public void test2() {
        String st1 = "安徽省宿州市安徽县";
        String st2 = st1.replace('安', '上');//返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有oldChar得到的。
        String st3 = st1.replace("安徽", "北京");//使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);

        System.out.println("*************************");
        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);

        System.out.println("*************************");
        str = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);


        System.out.println("*************************");
        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }

    }

}
