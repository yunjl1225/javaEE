package 第十一章集合;

import org.junit.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 *
 * 1.第十一章集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *       比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *          Collection接口：单列集合，用来存储一个一个的对象
 *              List接口:存储有序的，可重复的数据     --->“动态”数组
 *                      ArrayList、LinkedList、Vector
 *              Set接口：存储无序的，不可重复的数据   --->高中讲的"第十一章集合"
 *                      HashSet、LinkedHashSet、TreeSet
 *          Map接口：双列集合，用来存储一对（key--value）一对的数据      --->高中的函数
 *                      HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 * 三、Collection接口中的方法
 *  向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
     1、添加
          add(Object obj)
          addAll(Collection coll)
     2、获取有效元素的个数
          int size()
     3、清空集合
         void clear()
     4、是否是空集合
         boolean isEmpty()
     5、是否包含某个元素
         boolean contains(Object obj)：是通过元素的equals方法来判断是否是同一个对象
         boolean containsAll(Collection c)：也是调用元素的equals方法来比较的。拿两个集合的元素挨个比较。
     6、删除
         boolean remove(Object obj) ：通过元素的equals方法判断是否是要删除的那个元素。只会删除找到的第一个元素
         boolean removeAll(Collection coll)：取当前集合的差集
     7、取两个集合的交集
         boolean retainAll(Collection c)：把交集的结果存在当前集合中，不影响c
     8、集合是否相等
         boolean equals(Object obj)
     9、转成对象数组
         Object[] toArray()
     10、获取集合对象的哈希值
         hashCode()
     11、遍历
         iterator()：返回迭代器对象，用于集合遍历
 *
 * @author Yunjl
 * @create 2021-04-12 21:05
 */
public class Java集合框架概述 {
    /**
     * Collection接口中的方法
     */
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        //1.add(Object e);    将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add("123");//自动装箱
        coll.add("DD456");
        coll.add(new Date());

        //addAll(Collection coll1);         将coll1中的所有元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");        //coll1添加了两个元素
        coll.addAll(coll1);     //将coll1中的所有元素添加到coll中
        System.out.println(coll.size());    //7
        System.out.println(coll);    //[AA, BB, 123, DD456, Mon Apr 12 23:32:58 CST 2021, 456, CC]

        //2.size();           获取添加的元素的个数
        System.out.println(coll.size());    //5


        //3.clear();              清空当前集合元素
        coll.clear();

        //4.isEmpty();            判断当前集合是否为空
        System.out.println(coll.isEmpty());    //true              return size == 0;

        System.out.println("****************");
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add("abc");
        coll2.add(new String ("abc"));
        coll2.add(false);
        coll2.add(new Person("yujl",18));//自定义类
        System.out.println(coll2);

        //5.contains(Object obj)            判断当前集合是否包含obj,会调用obj对象所在类的equals()方法
        boolean contains = coll2.contains(123);     //true
        System.out.println(contains);
        System.out.println(coll2.contains(new String("abc")));  //true 调用了String中重写了的equals()，判断的是内容不是地址
        System.out.println(coll2.contains(new Person("yujl",18)));  //true 自定义类中如果没有重写equals，本质上还是 == ，则为false

        //containsAll(Collection coll3 )    判断形参coll3中的所有元素是否都存在于当前集合中。
        Collection coll3 = Arrays.asList(123,"abc");//利用多态新建Collection对象
        boolean b = coll2.containsAll(coll3);
        System.out.println(b);

        //6.remove(Object obj)                移除某个元素 ,前提：obj类需要重写equals()
        boolean remove = coll2.remove(123);//返回值 Boolean
        System.out.println(remove);//true
        System.out.println(coll2);

        //removeAll(Collection coll3);      差集：从当前集合中移除coll3中所有的元素。前提：obj类需要重写equals()
        boolean b1 = coll2.removeAll(coll3);
        System.out.println(b1);
        System.out.println(coll2);

    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(new String ("abc"));
        coll.add(false);
        coll.add(new Person("yujl",18));//自定义类
        System.out.println(coll);

        //7.retainAll(Collection coll1):    交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add("abc");
        coll2.add(false);
        coll2.add(new String ("abc"));
        coll2.add(new Person("yujl",18));//自定义类
        //8.equals(Object obj)           集合是否相等
        System.out.println(coll.equals(coll2)); //false  ArrayList是有序的，顺序不一样

        //9.toArray()                    第十一章集合-->对象数组
        Object[] arr = coll2.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr数组第"+(i+1)+"个元素："+arr[i]);
        }
        //Arrays.asList(Object[] arr);                对象数组-->第十一章集合
        List<String> list = Arrays.asList(new String[]{"aa", "bb", "cc"});
        System.out.println(list);
        //注意使用包装类类型
        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2

        //10.hashCode()                  获取集合对象的哈希值
        System.out.println(coll.hashCode());

        //11.iterator()：                返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试


    }

}
