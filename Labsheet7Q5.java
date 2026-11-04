class WorkerThread extends Thread {
    public WorkerThread(String name) {
        super(name);
    }
    public void run() {
        try {
            int sleepTime = (int)(Math.random() * 501);
            Thread.sleep(sleepTime);
            System.out.println(getName() + " slept for " + sleepTime + " ms and finished.");
        } catch (InterruptedException e) {
        }
    }
}

public class Labsheet7Q5 {
    public static void main(String[] args) {
        WorkerThread t1 = new WorkerThread("Reader");
        WorkerThread t2 = new WorkerThread("Writer");
        WorkerThread t3 = new WorkerThread("Logger");
        t1.start();
        t2.start();
        t3.start();
    }
}
