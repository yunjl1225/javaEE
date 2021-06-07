package 第八章线程.线程通信;

/**
 * 生产者(Producer)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员会叫生产者停一下，
 * 如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，
 * 如果店中有产品了再通知消费者来取走产品。
 *
 * @author Yunjl
 * @create 2021-04-10 17:56
 */
class Clerk{//店员
    private int productCount = 0;//产品数量
    //生产产品方法
    public synchronized void produceProduct() {//同步方法解决线程安全
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+"：开始生产第" + productCount + "个产品");
            notifyAll();//生产了一个产品就会唤醒所有的消费者
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    //消费产品方法
    public synchronized void consumeProduct() {//同步方法解决线程安全
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName()+"开始消费第" + productCount + "个产品");
            productCount--;
            notify();//消费量一个产品就会唤醒生产者
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{//生产者

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始生产产品....." );

        while(true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }

    }
}

class Comsumer extends Thread{//消费者
    private Clerk clerk;

    public Comsumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始消费产品....." );

        while(true){

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }

    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        Comsumer c1 = new Comsumer(clerk);
        c1.setName("消费者1");
        Comsumer c2 = new Comsumer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }
}
