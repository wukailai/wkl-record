import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
    public static void main(String[] args) throws Exception {
        DelayQueue<Delay> queue = new DelayQueue<>();
        Delay delay1 = new Delay(System.currentTimeMillis() + 5000);
        Delay delay2 = new Delay(System.currentTimeMillis() + 10000);
        queue.add(delay1);
        queue.add(delay2);
        while (!queue.isEmpty()) {
            Delay delay = queue.poll();
            if (delay != null) {
                System.out.println("get success, execTime = " + delay.execTime);
            } else {
                System.out.println("get fail");
            }
            Thread.sleep(1000);
        }
        System.out.println("finish");
    }

    public static class Delay implements Delayed {
        private long execTime;

        public Delay(long execTime) {
            this.execTime = execTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return execTime - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }
    }
}