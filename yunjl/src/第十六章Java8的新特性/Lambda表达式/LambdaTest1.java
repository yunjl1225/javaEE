package 第十六章Java8的新特性.Lambda表达式;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用举例
 * @author Yunjl
 * @create 2021-04-17 21:10
 */
public class LambdaTest1 {
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱你");
            }
        };
        r1.run();
        System.out.println("*********Lambda表达式重写*************");

        Runnable r2 = () ->System.out.println("我爱yunjl");
        r2.run();

    }
    @Test
    public void test2(){
        //比较大小
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);
        System.out.println("*********Lambda表达式重写*************");

        Comparator<Integer> com2 = ( o1,o2) -> Integer.compare(o1,o2);
        int compare2 = com2.compare(32, 25);
        System.out.println(compare2);
        System.out.println("*********方法引用的写法*************");

        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(32, 25);
        System.out.println(compare3);
    }
}
