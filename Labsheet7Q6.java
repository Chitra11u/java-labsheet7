class AliveTestThread extends Thread {
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}

public class Labsheet7Q6 {
    public static void main(String[] args) throws InterruptedException {
        AliveTestThread t = new AliveTestThread();
        System.out.println("Before start: " + t.isAlive());
        t.start();
        System.out.println("While running: " + t.isAlive());
        t.join();
        System.out.println("After finishing: " + t.isAlive());
    }
}
