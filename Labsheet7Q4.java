class CountThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - Count: " + i);
        }
    }
}

public class Labsheet7Q4 {
    public static void main(String[] args) {
        CountThread t1 = new CountThread();
        CountThread t2 = new CountThread();
        t1.start();
        t2.start();
    }
}
