
public class Main {
    public static void main(String[] args) {

        int [] arr1 = {300, 700, 500, 400, 600};
        int [] arr2 = {600, 500, 700, 400, 300};
        int [] arr3 = {500, 400, 600, 300, 700};
        int [] arr4 = {400, 700, 300, 500, 600};
        int [] arr5 = {300, 500, 400, 600, 700};

        for (int i = 0; i < 5; i++) {
        new Thread(new Deposit("Кассир 1", arr1[i])).start();
        new Thread(new Deposit("Кассир 2", arr2[i])).start();
        new Thread(new Withdrawal("Кассир 3", arr3[i])).start();
        new Thread(new Withdrawal("Кассир 4", arr4[i])).start();
        new Thread(new Withdrawal("Кассир 5", arr5[i])).start();
        }
    }
}