package 第十一章集合.Collection接口;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 在List内去除重复数字值，要求尽量简单
 * @author Yunjl
 * @create 2021-04-14 0:56
 */
public class SetExer {
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

    /**
     * 面试题
     */
    @Test
    public void exer2(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);

        System.out.println(set);//[Person{name='BB', age=1002}, Person{name='AA', age=1001}]

        p1.name = "CC";
        boolean remove = set.remove(p1);//按照1001，“CC”的哈希值找不到由1001，“AA”改为“CC”的索引
        System.out.println(remove);//false  删除失败
        System.out.println(set);//[Person{name='BB', age=1002}, Person{name='CC', age=1001}]

        set.add(new Person(1001,"CC"));
        //两个CC 的哈希值不一样
        System.out.println(set);//[Person{name='BB', age=1002}, Person{name='CC', age=1001}, Person{name='CC', age=1001}]

        set.add(new Person(1001,"AA"));
        //equals判断时，内容不一样，可以加入。
        System.out.println(set);//[Person{name='BB', age=1002}, Person{name='CC', age=1001}, Person{name='CC', age=1001}, Person{name='AA', age=1001}]
    }


}
