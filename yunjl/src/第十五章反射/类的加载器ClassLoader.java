package 第十五章反射;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * 类加载器作用是用来把类(class)装载进内存的。
 * 类加载器的作用：
  类加载的作用：将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构，
        然后在堆中生成一个代表这个类的java.lang.Class对象，作为方法区中类数据的访问入口。
  类缓存：标准的JavaSE类加载器可以按要求查找类，但一旦某个类被加载到类加载器中，它将维持加载（缓存）一段时间。
        不过JVM垃圾回收机制可以回收这些Class对象。

 * @author Yunjl
 * @create 2021-04-16 23:33
 */
public class 类的加载器ClassLoader {
    @Test
    public void test(){
        //对于自定义类，使用系统类加载器进行加载,获取当前类的加载器
        ClassLoader classLoader = 类的加载器ClassLoader.class.getClassLoader();
        System.out.println(classLoader);    //sun.misc.Launcher$AppClassLoader@18b4aac2     系统类加载器
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);   //sun.misc.Launcher$ExtClassLoader@452b3a41     扩展类加载器
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);   //null                                          引导类加载器,该加载器无法直接获取

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);   //null
    }

    /**
     * Properties：用来读取配置文件。
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {

        Properties pros =  new Properties();
        //因为用的单元测试，此时的文件默认在当前的module下。
        //首先在当前module下新建一个配置文件jdbc.properties
        //读取配置文件的方式一：
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        FileInputStream fis = new FileInputStream("src\\jdbc1.properties");
//        pros.load(fis);

        //配置文件默认识别为：当前module的src下
        //首先在当前module的src下新建一个配置文件jdbc1.properties
        //读取配置文件的方式二：使用ClassLoader
        ClassLoader classLoader = 类的加载器ClassLoader.class.getClassLoader();  //系统类加载器
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);

    }
}
