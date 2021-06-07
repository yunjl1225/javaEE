package 第八章线程.线程安全问题;

/**
 * 银行有一个账户。有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 * @author Yunjl
 * @create 2021-04-10 16:42
 */
class Account {//账户类
    private double balance;//余额

    public Account(double balance) {
        this.balance = balance;
    }
    public synchronized void deposit(double amt){//存钱
        if(amt > 0){
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":存钱成功，当前余额为：" + balance);
        }else{
            System.out.println("你输入的钱数非法");
        }
    }
}

class Customer extends Thread {//客户类
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);
        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
