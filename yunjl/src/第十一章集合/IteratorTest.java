package 第十一章集合;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator对象称为迭代器(设计模式的一种)，主要用于遍历 Collection 集合中的元素。
 * 集合元素的遍历，使用迭代器Iterator接口
 *
 *  Collection接口继承了java.lang.Iterable接口，该接口有一个iterator()方法，
 *  那么所有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了Iterator接口的对象。
  Iterator 仅用于遍历集合，Iterator 本身并不提供承装对象的能力。
    如果需要创建Iterator 对象，则必须有一个被迭代的集合。
  集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前

 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasNext() 和  next()
 *          hasNext():判断是否还有下一个元素
 *          next():①指针下移 ②将下移以后集合位置上的元素返回
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
 * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 * @author Yunjl
 * @create 2021-04-13 11:09
 */
public class IteratorTest {
    @Test
    public void test() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("abc");
        coll.add(false);
        coll.add(new String("abc"));
        coll.add(new Person("yujl", 18));//自定义类

        Iterator iterator = coll.iterator();
        //方式一
        /*
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        //NoSuchElementException        报错集合中只有五个元素
//        System.out.println(iterator.next());
        */

        //方式二       不推荐
//        for (int i = 0; i < coll.size() ; i++) {
//            System.out.println(iterator.next());
//        }

        //方式三       推荐
        while (iterator.hasNext()) {//集合中是否还有下一元素
            System.out.println(iterator.next());
        }


    }

    @Test
    public void test2() {

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //错误方式一：
//        Iterator iterator = coll.iterator();
//        while((iterator.next()) != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
        while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next());
        }

    }
    //测试Iterator中的remove()
    //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
    // 再调用remove都会报IllegalStateException。
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //删除集合中"Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
//            iterator.remove();
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
//                iterator.remove();
            }

        }
        //遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}