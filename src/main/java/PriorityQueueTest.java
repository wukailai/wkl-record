import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new PriorityQueue<>();
        addInteger(queue1);
        printInteger(queue1);
        Queue<IdAndName> queue2 = new PriorityQueue<>(Comparator.comparingInt(IdAndName::getId));
        addIdAndName(queue2);
        printIdAndName(queue2);
    }

    private static void addInteger(Queue<Integer> queue) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            queue.add(random.nextInt(10));
        }
    }

    private static void printInteger(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            System.out.println(value);
        }
    }

    private static void addIdAndName(Queue<IdAndName> queue) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            queue.add(new IdAndName(random.nextInt(20), "" + i));
        }
    }

    private static void printIdAndName(Queue<IdAndName> queue) {
        while (!queue.isEmpty()) {
            IdAndName value = queue.poll();
            System.out.println("name = " + value.getName() + ", id = " + value.getId());
        }
    }
}

class IdAndName {
    private int id;
    private String name;

    public IdAndName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}