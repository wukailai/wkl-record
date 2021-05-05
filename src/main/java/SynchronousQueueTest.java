import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        new Product(queue).start();
        new Customer(queue).start();
    }
    public static class Product extends Thread {
        private SynchronousQueue<Integer> queue;

        public Product(SynchronousQueue<Integer> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                int rand = new Random().nextInt(1000);
                System.out.println("生产了一个产品："+rand);
                System.out.println("等待三秒后运送出去...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    queue.put(rand);
                    System.out.println("运送成功");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(queue.isEmpty());
            }
        }
    }

    public static class Customer extends Thread{
        private SynchronousQueue<Integer> queue;

        public Customer(SynchronousQueue<Integer> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("消费了一个产品:"+queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("------------------------------------------");
            }
        }
    }
}