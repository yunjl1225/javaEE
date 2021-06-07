package 第十章枚举类与注解.注解;

/**
 *如何自定义注解：参照@SuppressWarnings定义
 * ① 注解声明为：@interface
 * ② 内部定义成员，通常使用value表示
 * ③ 可以指定成员的默认值，使用default定义
 * ④ 如果自定义注解没有成员，表明是一个标识作用。

 如果注解有成员，在使用注解时，需要指明成员的值。
 自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
 自定义注解通过都会指明两个元注解：Retention、Target

 * @author Yunjl
 * @create 2021-04-12 20:34
 */
public @interface MyAnnotation {
    String value();         //没有默认值，使用时需要赋值
//    String value() default "Hello";       初始化默认值



}
