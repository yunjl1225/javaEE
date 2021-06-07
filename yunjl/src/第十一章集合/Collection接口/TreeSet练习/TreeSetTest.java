package 第十一章集合.Collection接口.TreeSet练习;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
     1). 使 Employee 实现 Comparable 接口，并按 name 排序
     2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
 * @author Yunjl
 * @create 2021-04-13 23:42
 */
public class TreeSetTest {
    //使用自然排序
    public static void main(String[] args) {

        TreeSet Set = new TreeSet();

        Employee e1 = new Employee("ge", 21, new MyDate(1999, 10, 24));
        Employee e2 = new Employee("zhao", 22, new MyDate(1999, 10, 9));
        Employee e3 = new Employee("yun", 20, new MyDate(1999, 12, 25));
        Employee e4 = new Employee("li", 19, new MyDate(1999, 12, 21));
        Employee e5 = new Employee("yan", 18, new MyDate(1999, 7, 23));

        Set.add(e1);
        Set.add(e2);
        Set.add(e3);
        Set.add(e4);
        Set.add(e5);

        //利用迭代器遍历
        Iterator iterator = Set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    //按生日日期的先后排序。
    @Test
    public void test2(){

        TreeSet Set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee)o1;
                    Employee e2 = (Employee)o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    int minusYear = b1.getYear() - b2.getYear();
                    int minusMonth = b1.getMonth() - b2.getMonth();
                    int minusDay = b1.getDay() - b2.getDay();
                    if(minusYear != 0){
                        return  minusYear;
                    }else if(minusMonth != 0){
                        return minusMonth;
                    }else if(minusDay != 0){
                        return minusDay;
                    }else{
                        return 0;
                    }
                }
//                return 0;
                throw new RuntimeException("传入的数据类型不一致");
            }
        });

        Employee e1 = new Employee("ge", 21, new MyDate(1999, 10, 24));
        Employee e2 = new Employee("zhao", 22, new MyDate(1999, 10, 9));
        Employee e3 = new Employee("yun", 20, new MyDate(1999, 12, 25));
        Employee e4 = new Employee("li", 19, new MyDate(1999, 12, 21));
        Employee e5 = new Employee("yan", 18, new MyDate(1999, 7, 23));

        Set.add(e1);
        Set.add(e2);
        Set.add(e3);
        Set.add(e4);
        Set.add(e5);

        //利用迭代器遍历
        Iterator iterator = Set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
