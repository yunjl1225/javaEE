package 第十三章IO流与File类.File类;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 1. 利用File构造器，new 一个文件目录file
     1)在其中创建多个文件和目录
     2)编写方法，实现删除file中指定文件的操作
         2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
         3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
     拓展1：并计算指定目录占用空间的大小
     拓展2：删除指定文件目录及其下的所有文件

 * @author Yunjl
 * @create 2021-04-15 13:12
 */
public class FileTest {
    @Test
    public void test() throws IOException {
        File file = new File("D:\\Java\\file\\hello.txt");

        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
            //先实例化需要创建的文件的对象
        File destFile = new File(file.getParent(),"haha.txt");
            //创建所要求的文件，创建成功返回true
        boolean newFile = destFile.createNewFile();
            //判断是否创建成功
        if(newFile){
            System.out.println("haha.txt创建成功！");
        }

        File destFile1 = new File(file.getParent(),"yun.jpg");
        boolean newFile1 = destFile1.createNewFile();   //创建文件
        if(newFile1){
            System.out.println("yun.jpg创建成功！");
        }

        File destFile2 = new File(file.getParent(),"yu");
        boolean newFile2 = destFile2.mkdirs();  //创建目录
        if(newFile2){
            System.out.println("yu目录创建成功！");
        }
    }


}
