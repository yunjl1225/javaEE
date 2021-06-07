package 第十五章反射;

import org.junit.Test;

import java.lang.annotation.ElementType;

/**
 关于java.lang.Class类的理解
 1.类的加载过程：
     程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
     接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
     加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
     运行时类，就作为Class的一个实例。

 2.换句话说，Class的实例就对应着一个运行时类。
 3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
 4.哪些类型可以有Class对象？
     （1）class： 外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
     （2）interface：接口
     （3）[]：数组
     （4）enum：枚举
     （5）annotation：注解@interface
     （6）primitive type：基本数据类型
     （7）void
 5.Class类的常用方法
     static Class forName(String name) 返回指定类名 name 的 Class 对象
     Object newInstance() 调用缺省构造函数，返回该Class对象的一个实例
     getName() 返回此Class对象所表示的实体（类、接口、数组类、基本类型或void）名称
     Class getSuperClass() 返回当前Class对象的父类的Class对象
     Class [] getInterfaces() 获取当前Class对象的接口
     ClassLoader getClassLoader() 返回该类的类加载器
     Class getSuperclass() 返回表示此Class所表示的实体的超类的Class
     Constructor[] getConstructors() 返回一个包含某些Constructor对象的数组
     Field[] getDeclaredFields() 返回Field对象的一个数组
     Method getMethod(String name,Class … paramTypes)返回一个Method对象，此对象的形参类型为paramType
 * @author Yunjl
 * @create 2021-04-16 23:20
 */
public class Class类 {
    /**
     * 获取Class的实例的方式（前三种方式需要掌握）
     */
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<Person> clazz1 =Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象,调用getClass()
        Person p2 = new Person();
        Class clazz2 = p2.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)        推荐使用
        Class clazz3 = Class.forName("第十五章反射.Person");//包括包名        体现反射的动态性
        System.out.println(clazz3);

        //上面三个对象是同一个
        System.out.println(clazz1 == clazz2);   //true
        System.out.println(clazz1 == clazz3);   //true

        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = 反射Reflection.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("第十五章反射.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz4);
    }

    //万事万物皆对象？对象.xxx,File,URL,反射,前端、数据库操作


    //Class实例可以是哪些结构的说明：
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;           //枚举类
        Class c6 = Override.class;              //注解
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;                 //Class本身

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }
}
