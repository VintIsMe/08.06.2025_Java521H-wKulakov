public class Deposit implements Runnable{

    private final String cashier;
    private final int sum;

    public Deposit(String cashier, int sum) {
        this.cashier = cashier;
        this.sum = sum;
    }

    @Override
    public void run() {
        try {
            Bank.deposit(cashier, sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
