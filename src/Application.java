import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void printCashes(Cash[] cashes){
        int maxCountQueue = cashes[0].getCountQueue();
        for (int i = 1; i < cashes.length; i++){
            if (cashes[i].getCountQueue() > maxCountQueue){
                maxCountQueue = cashes[i].getCountQueue();
            }
        }
        System.out.printf("%10s", "Cash №1");
        System.out.printf("%10s", "Cash №2");
        System.out.printf("%10s", "Cash №3");
        System.out.printf("%10s%n", "Cash №4");
        for (int i = 0; i < maxCountQueue; i++){
            for (int j = 0; j < cashes.length; j++){
                if (cashes[j].getCountQueue() - 1 < i){
                    System.out.printf("%10s", "");
                } else {
                    String name = cashes[j].getQueue().get(i).getName();
                    System.out.printf("%10s", name);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int countOfCustomers = in.nextInt();
        Cash[] cashes = new Cash[4];
        System.out.println("Write speeds of 4 cashes");
        for (int i = 0; i < cashes.length; i++){
            int speed = in.nextInt();
            while (speed < 1 || speed > 3){
                System.out.println("Please, write correct speed. It should be 1 <= speed <= 3");
                speed = in.nextInt();
            }
            cashes[i] = new Cash(speed);
        }
        int countOfSteps = in.nextInt();
        for (int i = 0; i < countOfSteps; i++){
            if (i < countOfCustomers) {
                Random rnd = new Random();
                int custNum = rnd.nextInt(3);
                Customer customer;
                if (custNum == 0) {
                    customer = new Child();
                    System.out.println(customer.getName() + "     " +customer.getRemains());
                } else if (custNum == 1) {
                    customer = new Women();
                    System.out.println(customer.getName() + "     " +customer.getRemains());
                } else {
                    customer = new Man();
                    System.out.println(customer.getName() + "     " +customer.getRemains());
                }
                Cash chosenCash = customer.choosingCash(cashes);
                chosenCash.addCustomer(customer);
            }
            for (Cash cash:cashes){
                cash.service();
            }
            printCashes(cashes);
        }
    }
}
