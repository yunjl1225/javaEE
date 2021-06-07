package 第八章线程.线程安全的单例模式;

/**
 * 使用同步机制将单例模式的懒汉式改写为线程安全的
 *
 * @author Yunjl
 * @create 2021-04-10 12:26
 */
public class BankTest {

}

class Bank {
    private Bank() {

    }

    private static Bank instance = null;

//    public synchronized static Bank getInstance() {   //同步监视器：Bank.class

    //或者使用同步代码块
    public static Bank getInstance() {   //同步监视器：Bank.class
        if(instance == null){
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;


    }
}