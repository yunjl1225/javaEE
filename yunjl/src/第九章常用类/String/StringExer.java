package 第九章常用类.String;

import org.junit.Test;

import java.lang.String;

/**
 * 算法题
 * 1. 模拟一个trim方法，去除字符串两端的空格。
 * <p>
 * 2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 * <p>
 * 3. 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 * <p>
 * 4.获取两个字符串中最大相同子串。
 * 比如：str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 * <p>
 * 5.对字符串中字符进行自然顺序排序。提示：
 * 1）字符串变成字符数组。
 * 2）对数组排序，选择，冒泡，Arrays.sort();
 * 3）将排序后的数组变成字符串
 *
 * @author Yunjl
 * @create 2021-04-11 11:14
 */
public class StringExer {
    public static void main(String[] args) {
        System.out.println("第二题");
        StringExer2 str2 = new StringExer2();
        str2.test2();
        System.out.println("\n************************");
        System.out.println("第三题");
        StringExer3 str3 = new StringExer3();
        str3.test3();
        System.out.println("\n************************");
        System.out.println("第四题");
        StringExer4 str4 = new StringExer4();
        str4.test4();


    }
}
/**
 * 2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 */
class StringExer2{
    //方式一：转换为char[]
    public String reverse(String str, int startIndex, int endIndex) {

        if (str != null) {

            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {

                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        } else if (str == "") {
            return "";
        } else {

            return null;
        }
    }
    //方式二:使用String的拼接

    public String reverse1(String str, int startIndex, int endIndex) {

        if (str != null) {
            //第一部分 (前面不变得部分)
            String reverseStr = str.substring(0, startIndex);
            //第二部分 (中间需要转换的部分)
            for (int i = endIndex; i >= startIndex; i--) {
                reverseStr += str.charAt(i);
            }
            //第三部分 (后面不变的部分)
            reverseStr += str.substring(endIndex + 1);
            return reverseStr;
        } else {
            return null;
        }

    }

    //方式三：使用StringBuffer/StringBuilder代替String(提高效率)
    public String reverse2(String str, int startIndex, int endIndex) {
        if (str != null) {
            StringBuilder builder = new StringBuilder(str.length());
            //第一部分
            builder.append(str.substring(0, startIndex));
            //第二部分
            for (int i = endIndex; i >= startIndex; i--) {
                builder.append(str.charAt(i));
            }
            //第三部分
            builder.append(str.substring(endIndex + 1));
            return builder.toString();
        } else {
            return null;
        }


    }

    @Test
    public void test2() {

        String str = "abcdefg";
        String reverse = reverse(str, 2, 5);
        System.out.println("方式一转换后" + reverse);

        String reverse1 = reverse(str, 2, 5);
        System.out.println("方式二转换后" + reverse1);

        String reverse2 = reverse(str, 2, 5);
        System.out.println("方式三转换后" + reverse2);

    }
}

/**
 *  3. 获取一个字符串在另一个字符串中出现的次数。
 *     比如：获取“ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 */
class StringExer3{
    /**
     *  获取subStr在mainStr中出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr,String subStr){
        int mainLength  = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if(mainLength >= subLength){

//         方式一
//            while((index = mainStr.indexOf(subStr)) != -1){//先在mainStr中找subStr，找到返回首位索引值，未找到返回-1
//                count ++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
//         方式二（改进）
            while((index = mainStr.indexOf(subStr,index)) != -1){//返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
                count ++;
                index += subLength;
            }

            return count;
        }else{
            return 0;

        }

    }

    @Test
    public void test3(){

        String mainStr = "abdsfsdgfdaabaadsabaadaba";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }

}

/**
 * 4.获取两个字符串中最大相同子串。
 * 比如：str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
 */
//前提，两个字符串中只有一个最大相同子串
class StringExer4{
    public String getMaxSameString(String str1,String str2){
       if(str1 != null && str2 != null){
           String maxStr = (str1.length() >= str2.length()) ? str1 : str2;//找出长度大的字符串
           String minStr = (str1.length() < str2.length()) ? str1 : str2;
           int length = minStr.length();
           for (int i = 0; i < length; i++) {
               for(int x = 0,y = length - i; y <= length ;x++,y++){
                   String substr = minStr.substring(x, y);
                   if(maxStr.contains(substr)){
                       return substr;
                   }
               }
           }
       }
        return null;
    }

    @Test
    public void test4(){
        String str1 = "abcw1erthelloyuiodef";
        String str2 = "cvhellobnm";
        String s = getMaxSameString(str1,str2);
        System.out.println(s);

    }

}