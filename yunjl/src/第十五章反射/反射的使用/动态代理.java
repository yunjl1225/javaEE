package 第十五章反射.反射的使用;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *动态代理的举例
 * @author Yunjl
 * @create 2021-04-17 19:25
 */
interface Human{

    String getBelief();

    void eat(String food);

}
//被代理类
class SuperMan implements Human{


    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil{

    public void method1(){
        System.out.println("====================通用方法一====================");

    }

    public void method2(){
        System.out.println("====================通用方法二====================");
    }

}

/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。


 */

class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){//obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();//创建InvocationHandler接口实现类的对象
        //调用接口实现类中的方法，对被代理类的对象进行赋值，把本方法中的形参obj赋值给实现接口类的被代理类obj对象
        handler.bind(obj);
        //创建一个代理类的对象，   参数：（类的加载器，被代理类实现的接口，InvocationHandler接口实现类的对象）
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }

}
//InvocationHandler接口实现类
class MyInvocationHandler implements InvocationHandler {
    //被代理对象
    private Object obj;//需要使用被代理类的对象进行赋值
    //实例化对象的方法
    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    //invoke（）中的参数：（代理类的对象，代理类的对象调用的方法，同名方法的参数）
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();

        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj,args);

        util.method2();

        //上述方法的返回值就作为当前类中的invoke()的返回值。
        return returnValue;

    }
}

public class 动态代理 {

    public static void main(String[] args) {
        //被代理类的对象
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类的对象，被代理类对象当做形参
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

        System.out.println("*****************************");
        //创建耐克被代理类的对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        //proxyClothFactory:代理类的对象，被代理类对象当做形参
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        //通过代理类对象调用被代理类的方法
        proxyClothFactory.produceCloth();

    }

}
