package 第十章枚举类与注解.注解;

/**
 * 注解Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。
 * Annotation 可以像修饰符一样被使用, 可用于修饰包,类,构造器,方法,成员变量,参数, 局部变量的声明,
 *      这些信息被保存在 Annotation的 “name=value” 对中
 *
 示例一：生成文档相关的注解
         @author 标明开发该类模块的作者，多个作者之间使用,分割
         @version 标明该类模块的版本
         @see 参考转向，也就是相关主题
         @since 从哪个版本开始增加的
         @param 对方法中某参数的说明，如果没有参数就不能写
         @return 对方法返回值的说明，如果方法的返回值类型是void就不能写
         @exception 对方法可能抛出的异常进行说明 ，如果方法没有用throws显式抛出的异常就不能写
 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
         @Override: 限定重写父类方法, 该注解只能用于方法
         @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
         @SuppressWarnings: 抑制编译器警告

 如何自定义注解：参照@SuppressWarnings定义
  * ① 注解声明为：@interface
  * ② 内部定义成员，通常使用value表示
  * ③ 可以指定成员的默认值，使用default定义
  * ④ 如果自定义注解没有成员，表明是一个标识作用。

 如果注解有成员，在使用注解时，需要指明成员的值。
 自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
 自定义注解通过都会指明两个元注解：Retention、Target

 4. jdk 提供的4种元注解
     元注解：对现有的注解进行解释说明的注解
 Retention：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS（默认行为）\RUNTIME
     只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 Target:用于指定被修饰的 Annotation 能用于修饰哪些程序元素
  *******出现的频率较低*******
 Documented:表示所修饰的注解在被javadoc解析时，保留下来。
 Inherited:被它修饰的 Annotation 将具有继承性。

 5.通过反射获取注解信息 ---到反射内容时系统讲解

 6. jdk 8 中注解的新特性：可重复注解、类型注解

 6.1 可重复注解：① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 ② MyAnnotation的Target和Retention等元注解与MyAnnotations相同。

 6.2 类型注解：
 ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。

 * @author Yunjl
 * @create 2021-04-12 18:32
 */

@MyAnnotation(value = "Hello")
public class 注解 {


}
