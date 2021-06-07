package 第九章常用类.BigInteger与BigDecimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * java.math包的BigInteger可以表示不可变的任意精度的整数。
 * Integer类作为int的包装类，能存储的最大整型值为2的31-1，Long类也是有限的，最大为2的63-1。
 * 如果要表示再大的整数，不管是基本数据类型还是他们的包装类都无能为力，更不用说进行运算了。
 *
 * 常用方法
      public BigInteger abs()：返回此 BigInteger 的绝对值的 BigInteger。
      BigInteger add(BigInteger val) ：返回其值为 (this + val) 的 BigInteger
      BigInteger subtract(BigInteger val) ：返回其值为 (this - val) 的 BigInteger
      BigInteger multiply(BigInteger val) ：返回其值为 (this * val) 的 BigInteger
      BigInteger divide(BigInteger val) ：返回其值为 (this / val) 的 BigInteger。整数相除只保留整数部分。
      BigInteger remainder(BigInteger val) ：返回其值为 (this % val) 的 BigInteger。
      BigInteger[] divideAndRemainder(BigInteger val)：返回包含 (this / val) 后跟(this % val) 的两个 BigInteger 的数组。
      BigInteger pow(int exponent) ：返回其值为 (thisexponent) 的 BigInteger。


  一般的Float类和Double类可以用来做科学计算或工程计算，但在商业计算中，要求数字精度比较高，故用到java.math.BigDecimal类。
  BigDecimal类支持不可变的、任意精度的有符号十进制定点数。

 构造器
      public BigDecimal(double val)
      public BigDecimal(String val)
  常用方法
      public BigDecimal add(BigDecimal augend)
      public BigDecimal subtract(BigDecimal subtrahend)
      public BigDecimal multiply(BigDecimal multiplicand)
      public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
 * @author Yunjl
 * @create 2021-04-12 17:49
 */
public class BigInteger与BigDecimal {

    @Test
    public void test() {
        BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);

//        bd/bd2
        //报错，除不尽时需要指定保留小数位数（可以指定默认）
//         System.out.println(bd.divide(bd2));

        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));               //默认保留3位小数
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));     //保留25位小数

    }
}
