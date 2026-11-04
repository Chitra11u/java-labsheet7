public class Labsheet7Q15 {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: acquired lock1");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (lock2) {
                    System.out.println("Thread 1: acquired lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 2: acquired lock1");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (lock2) {
                    System.out.println("Thread 2: acquired lock2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
