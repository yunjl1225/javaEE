package 第十一章集合.Map接口;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 TreeMap存储 Key-Value 对时，需要根据 key-value 对进行排序。
        TreeMap 可以保证所有的 Key-Value 对处于有序状态。
 TreeSet底层使用红黑树结构存储数据
 TreeMap 的 Key 的排序：    //要按照key进行排序,不能按照value值排序
     自然排序：TreeMap 的所有的 Key 必须实现 Comparable 接口，而且所有的 Key 应该是同一个类的对象，否则将会抛出 ClasssCastException
     定制排序：创建 TreeMap 时，传入一个 Comparator 对象，该对象负责对TreeMap 中的所有 key 进行排序。
                此时不需要 Map 的 Key 实现Comparable 接口
  TreeMap判断两个key相等的标准：两个key通过compareTo()方法或者compare()方法返回0。


 * @author Yunjl
 * @create 2021-04-14 15:13
 */
public class TreeMap类 {
    @Test
    public void test1(){

        TreeMap map = new TreeMap();
        User user1 = new User("yjl", 18);
        User user2 = new User("zt", 21);
        User user3 = new User("lrx", 20);
        User user4 = new User("ymq", 19);
        map.put(user1,1225);
        map.put(user2,1009);
        map.put(user3,1221);
        map.put(user4,0714);

        //自然排序，根据自定义类User类中重写的compareTo()
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }
    //定制排序,按照年龄排序
    @Test
    public void test2(){

        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User s1 = (User)o1;
                    User s2 = (User)o2;
                    return Integer.compare(s1.getAge(),s2.getAge());
                }
//                return 0;
                throw new RuntimeException("传入数据类型不一致");
            }
        });
        User user1 = new User("yjl", 18);
        User user2 = new User("zt", 21);
        User user3 = new User("lrx", 20);
        User user4 = new User("ymq", 19);
        map.put(user1,1225);
        map.put(user2,1009);
        map.put(user3,1221);
        map.put(user4,0714);


        //自然排序，根据自定义类User类中重写的compareTo()
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
