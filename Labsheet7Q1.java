class MyThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class Labsheet7Q1 {
    public static void main(String[] args) {
        MyThread1 t = new MyThread1();
        t.start();
    }
}
