public class Withdrawal implements Runnable {

    private final String cashier;
    private final int sum;

    public Withdrawal(String cashier, int sum) {
        this.cashier = cashier;
        this.sum = sum;
    }

    @Override
    public void run() {
        try {
            Bank.withdraw(cashier, sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
