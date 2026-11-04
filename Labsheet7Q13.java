class Buffer {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait();
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!hasData) {
            wait();
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify();
    }
}

class Producer implements Runnable {
    private Buffer buffer;
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.produce(i);
            }
        } catch (InterruptedException e) {
        }
    }
}

class Consumer implements Runnable {
    private Buffer buffer;
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.consume();
            }
        } catch (InterruptedException e) {
        }
    }
}

public class Labsheet7Q13 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));
        producer.start();
        consumer.start();
    }
}
