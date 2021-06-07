package 第十三章IO流与File类.IO流;

import org.junit.Test;

import java.io.*;

/**
 转换流提供了在字节流和字符流之间的转换
 Java API提供了两个转换流：
      InputStreamReader：将InputStream转换为Reader
      OutputStreamWriter：将Writer转换为OutputStream
  字节流中的数据都是字符时，转成字符流操作更高效。
  很多时候我们使用转换流来处理文件乱码问题。实现编码和解码的功能

 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 *   InputStreamReader：将一个字节的输入流转换为字符的输入流
 *   OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3. 解码：字节、字节数组  --->字符数组、字符串
 *    编码：字符数组、字符串 ---> 字节、字节数组
 *
 *
 * 4.字符集
 *ASCII：美国标准信息交换码。
 用一个字节的7位可以表示。
 ISO8859-1：拉丁码表。欧洲码表
 用一个字节的8位表示。
 GB2312：中国的中文编码表。最多两个字节编码所有字符
 GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。

 * @author Yunjl
 * @create 2021-04-15 21:20
 */
public class 转换流 {
    /*
    此时处理异常的话，仍然应该使用try-catch-finally
    InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
     */
    @Test
    public void test1(){

        InputStreamReader isr = null;//使用系统默认的字符集
        try {
            FileInputStream fis = new FileInputStream("dbcp.txt");
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
            //参数2指明了字符集，具体使用哪个字符集，取决于文件dbcp.txt保存时使用的字符集
            isr = new InputStreamReader(fis,"UTF-8");

            char[] cbuf = new char[20];
            int len;
            while((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr != null){

                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /*

    综合使用InputStreamReader和OutputStreamWriter
     */
    @Test
    public void test2() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //1.造文件、造流
            File file1 = new File("dbcp.txt");
            File file2 = new File("dbcp_gbk.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");

            //2.读写过程
            char[] cbuf = new char[20];
            int len;
            while((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭资源
            if(isr != null){

                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw != null){

                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
