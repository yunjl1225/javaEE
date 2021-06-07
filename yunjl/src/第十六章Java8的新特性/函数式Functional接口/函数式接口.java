package 第十六章Java8的新特性.函数式Functional接口;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
  只包含一个抽象方法的接口，称为函数式接口。
  你可以通过 Lambda 表达式来创建该接口的对象。（若 Lambda 表达式抛出一个受检异常(即：非运行时异常)，
        那么该异常需要在目标接口的抽象方法上进行声明）。
  我们可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式接口。
        同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口。

 * java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 *
 * @author Yunjl
 * @create 2021-04-17 21:36
 */
public class 函数式接口 {
    @Test
    public void test(){

        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("购物花了" + aDouble + "元");
            }
        });

        System.out.println("***********Lambda 表达式************");
        happyTime(400,money -> System.out.println("天上人间花了" + money + "元"));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }


    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");

        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filterStrs);


        List<String> filterStrs1 = filterString(list,s -> s.contains("京"));
        System.out.println(filterStrs1);
    }
    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> filterList = new ArrayList<>();

        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;

    }
}
