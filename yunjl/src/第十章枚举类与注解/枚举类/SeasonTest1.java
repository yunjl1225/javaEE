package 第十章枚举类与注解.枚举类;

/**
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 *   说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * 三、Enum类中的常用方法：
 *    values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *    valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。
 *          如不是，会有运行时异常：IllegalArgumentException。
 *    toString()：返回当前枚举类对象常量的名称
 *
 * 四、使用enum关键字定义的枚举类实现接口的情况
 *   情况一：实现接口，在enum类中实现抽象方法
 *   情况二：让枚举类的对象分别实现接口中的抽象方法
 *
 *
 * @author Yunjl
 * @create 2021-04-12 19:26
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        //toString()：返回当前枚举类对象常量的名称
        System.out.println(Season1.SPRING.toString());//SPRING  对象名

        //values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        Season1 winter = Season1.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);

        // 实现接口
        Season1.SPRING.show();
    }
}

//接口
interface Info{
    void show();
}

//使用enum关键字创建枚举类
enum  Season1 implements Info{

    //1.提供当前枚举类的多个对象
    //每个对象重写各自的show()方法
    SPRING ("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天是春暖花开");
        }
    },   //多个对象之间用逗号 ,
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天是夏日炎炎");
        }
    },
    AUTUMN ("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天是秋高气爽");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天是冰天雪地");
        }
    };    //分号结束 ;

    //2.声明私有属性:   private final修饰,在类的构造器中赋予初始值
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;

    }

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    //5.其他诉求2：提供toString()方法
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }

    //重写接口中的show()方法    在这里重写，Enum类中的每一个对象调用同一个show()方法
//    public  void show(){
//        System.out.println("Enum类实现接口");
//    }
}

