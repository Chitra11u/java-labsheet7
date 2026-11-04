class MultiPriorityThread extends Thread {
    public MultiPriorityThread(String name, int priority) {
        super(name);
        setPriority(priority);
    }
    public void run() {
        System.out.println(getName() + " with priority " + getPriority() + " finished.");
    }
}

public class Labsheet7Q9 {
    public static void main(String[] args) {
        MultiPriorityThread t1 = new MultiPriorityThread("Thread-2", 2);
        MultiPriorityThread t2 = new MultiPriorityThread("Thread-4", 4);
        MultiPriorityThread t3 = new MultiPriorityThread("Thread-6", 6);
        MultiPriorityThread t4 = new MultiPriorityThread("Thread-8", 8);
        MultiPriorityThread t5 = new MultiPriorityThread("Thread-10", 10);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
