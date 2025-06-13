import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private static int balance = 0;
    private static int numberOfOperations = 0;

    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();


    public static void deposit(String cashier, int amount) throws InterruptedException {
        lock.lock();
            Thread.sleep(1000);
            if (balance + amount < 1000) {
                balance += amount;
                System.out.println(cashier + " положил " + amount + " баланс: " + balance);
                numberOfOperations++;
                if (numberOfOperations % 10 == 0) {
                    System.out.println("Выполнено 10 операций, текущий баланс: " + balance);
                }
            } else {
                System.out.println("Баланс: " + balance + " касса переполнена "
                        + cashier + " не смог положить " + amount);
            }
        condition.await();
        condition.signalAll();
        lock.unlock();
    }

    public static void withdraw(String cashier, int amount) throws InterruptedException {
        lock.lock();
            if (amount > balance) {
                System.out.println("Баланс: " + balance + " " + cashier + " не смог снять сумму: " + amount);
            } else {
                balance -= amount;
                System.out.println(cashier + " снял " + amount + " баланс: " + balance);
                numberOfOperations++;
                if (numberOfOperations % 10 == 0) {
                    System.out.println("Выполнено 10 операций, текущий баланс: " + balance);
                }
            }
        condition.await();
        condition.signalAll();
        lock.unlock();
    }
}
