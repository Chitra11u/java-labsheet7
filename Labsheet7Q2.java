class MyRunnable2 implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class Labsheet7Q2 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable2());
        t.start();
    }
}
