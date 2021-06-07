package 第九章常用类.Java比较器;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一：说明：JAVA中的对象正常情况下，只能进行比较 == 或者 != 。不能使用 < 或者 > 的
 *          但是开发中需要对多个对象进行排序，需要比较对象的大小
 *          如何实现？       使用两个接口的任何一个：Comparator 或 Comparator
 *
 * 二、Comparable接口与Comparator的使用的对比：
 *    Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
 *    Comparator接口属于临时性的比较。
 *
 *
 * @author Yunjl
 * @create 2021-04-12 15:34
 */
public class Compare {
    /**
     *  Comparator接口的使用例子   自然排序
     *      1.像String、包装类等实现了 Comparable接口，重写了 CompareTo(obj) 方法，给出了比较两个对象大小的方式（从小到大的排列）
     *      2.重写CompareTo(obj) 方法的规则：
     *          如果当前对象this大于形参对象obj，则返回正整数，
     *          如果当前对象this小于形参对象obj，则返回负整数，
     *          如果当前对象this等于形参对象obj，则返回零。
     *      3.对于自定义类，如果需要排序，可以让自定义类实现Comparable接口,重写CompareTo(obj) 方法
     *          在CompareTo(obj) 方法中指明如何排序
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","BB","MM","GG","ZZ","KK"};//String 实现了 Comparable 接口
        Arrays.sort(arr);   //排序

        System.out.println(Arrays.toString(arr));

    }
    @Test
    public void test2(){    //自定义类Goods
        Goods[] g = new Goods[5];
        g[0] = new Goods("lenovoMouse",34);
        g[1] = new Goods("dellMouse",43);
        g[2] = new Goods("xiaomiMouse",12);
        g[3] = new Goods("huaweiMouse",65);
        g[4] = new Goods("microsoftMouse",43);
        Arrays.sort(g);
        System.out.println(Arrays.toString(g));
    }
    /**
     *  Comparator接口的使用：定制排序
     1.背景：
         当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
         或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
         那么可以考虑使用 Comparator 的对象来排序
     2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
         如果方法返回正整数，则表示o1大于o2；
         如果返回0，表示相等；
         返回负整数，表示o1小于o2。
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr,new Comparator(){

            //按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof  String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        }); //匿名内部类
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){    //自定义类Goods
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("huaweiMouse",224);
        arr[5] = new Goods("microsoftMouse",43);

        Arrays.sort(arr, new Comparator() {
            //指明商品比较大小的方式:按照产品名称从低到高排序,再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });    //匿名内部类

        System.out.println(Arrays.toString(arr));
    }


}
