package 第十六章Java8的新特性.StreamAPI;

import org.junit.Test;
import 第十六章Java8的新特性.方法引用与构造器引用.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream 是 Java8 中处理集合的关键抽象概念，
 * 它可以指定你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作。
 * 使用Stream API 对集合数据进行操作，就类似于使用 SQL 执行的数据库查询。
 *
 *  Stream 和 Collection 集合的区别：
 * Collection 是一种静态的内存数据结构，而 Stream 是有关计算的。
 *  前者是主要面向内存，存储在内存中，后者主要是面向 CPU，通过 CPU 实现计算。
 *
 *  Stream到底是什么呢？
 *     是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。
 *      “集合讲的是数据，Stream讲的是计算！”

    1. Stream关注的是对数据的运算，与CPU打交道
 *    集合关注的是数据的存储，与内存打交道
    2.
     ①Stream 自己不会存储元素。
     ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
     ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。

 *  3.Stream 执行流程
 *   ① Stream的实例化
 *  ② 一系列的中间操作（过滤、映射、...)
 *  ③ 终止操作
 *
 * 4.说明：
 * 4.1 一个中间操作链，对数据源的数据进行处理
 * 4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 * @author Yunjl
 * @create 2021-04-18 9:26
 */
public class StreamAPI {
    //创建 Stream方式一：通过集合
    @Test
    public void test1(){
        //因为类重名了，所以前面需要加上包名
        List<第十六章Java8的新特性.方法引用与构造器引用.Employee> employees = EmployeeData.getEmployees();

//        default Stream<E> stream() : 返回一个顺序流
        Stream<第十六章Java8的新特性.方法引用与构造器引用.Employee> stream = employees.stream();

//        default Stream<E> parallelStream() : 返回一个并行流
        Stream<第十六章Java8的新特性.方法引用与构造器引用.Employee> parallelStream = employees.parallelStream();

    }

    //创建 Stream方式二：通过数组
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);

    }
    //创建 Stream方式三：通过Stream的of()
    @Test
    public void test3(){

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

    }

    //创建 Stream方式四：创建无限流
    @Test
    public void test4(){

//      迭代
//      public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);


//      生成
//      public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
