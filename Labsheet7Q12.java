class BankAccount {
    private int balance = 2000;
    private final Object lock = new Object();
    public void withdraw(int amount) {
        synchronized (lock) {
            if (balance >= amount) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                balance -= amount;
            }
        }
    }
    public int getBalance() {
        return balance;
    }
}

class WithdrawalTask implements Runnable {
    private BankAccount account;
    public WithdrawalTask(BankAccount account) {
        this.account = account;
    }
    public void run() {
        for (int i = 0; i < 1000; i++) {
            account.withdraw(1);
        }
    }
}

public class Labsheet7Q12 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        Thread t1 = new Thread(new WithdrawalTask(account), "User1");
        Thread t2 = new Thread(new WithdrawalTask(account), "User2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Balance: " + account.getBalance());
    }
}
