package 第十五章反射;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *反射相关的主要API
  java.lang.Class:代表一个类  java.lang.reflect.Method:代表类的方法
  java.lang.reflect.Field:代表类的成员变量
  java.lang.reflect.Constructor:代表类的构造器
 * @author Yunjl
 * @create 2021-04-16 21:41
 */
public class 反射Reflection {
    /**
     * 反射之前可以对Person类做的事
     */
    @Test
    public void test1(){
        //1.创建Person类的对象
        Person p1 = new Person("yjl",18);

        //通过对象调用其内部(非私有)的属性与方法
        // 在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        //     比如：name、showNation()以及私有的构造器
        p1.age = 20;
        System.out.println(p1.toString());

        p1.show();
    }
    /**
     * 反射之后
     */
    @Test
    public void test2() throws Exception{
        Class clazz = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("yjl", 18);
        System.out.println(obj.toString());
        //强制转换
        Person p = (Person)obj;
        System.out.println(p.toString());
        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("****************");

        //通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        //通过私有构造器创建了name为yun的对象p1
        Person p1 = (Person) cons1.newInstance("yun");
        System.out.println(p1);

        //调用私有属性
        Field  name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        //把对象p1的私有name属性改为yunjl
        name.set(p1,"yunjl");
        System.out.println(p1);

        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        //调用私有方法并返回String类型的参数
        String nation = (String) showNation.invoke(p1,"中国");
        System.out.println(nation);

        //疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
        //建议：直接new的方式。
        //什么时候会使用：反射的方式。 反射的特征：动态性
        //疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
        //不矛盾。
    }
    /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
    运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类。
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
    来获取此运行时类。
    4.
     */
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
        Class clazz3 = Class.forName("第十五章反射.Person");//包括包名
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
}
