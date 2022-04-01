import java.util.Scanner;

public class Application {
    public static void printCashes(Cash[] cashes){
        int maxCountQueue = cashes[0].getCountQueue();
        for (int i = 1; i < cashes.length; i++){
            if (cashes[i].getCountQueue() > maxCountQueue){
                maxCountQueue = cashes[i].getCountQueue();
            }
        }
        System.out.printf("%15s", "Cash №1[" + cashes[0].getSpeed() + "]");
        System.out.printf("%15s", "Cash №2[" + cashes[1].getSpeed() + "]");
        System.out.printf("%15s", "Cash №3[" + cashes[2].getSpeed() + "]");
        System.out.printf("%15s%n", "Cash №4[" + cashes[3].getSpeed() + "]");
        for (int i = 0; i < maxCountQueue; i++){
            for (int j = 0; j < cashes.length; j++){
                if (cashes[j].getCountQueue() - 1 < i){
                    System.out.printf("%15s", "");
                } else {
                    String name = cashes[j].getQueue().get(i).getName();
                    int count = cashes[j].getQueue().get(i).getRemains();
                    System.out.printf("%15s", name + "[" + count + "]");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write the number of customers");
        int countOfCustomers = in.nextInt();
        Cash[] cashes = new Cash[4];
        CustomerFactory factory = new CustomerFactory();
        System.out.println("Write speeds of 4 cashes");
        for (int i = 0; i < cashes.length; i++){
            int speed = in.nextInt();
            while (speed < 1 || speed > 3){
                System.out.println("Please, write correct speed. It should be 1 <= speed <= 3");
                speed = in.nextInt();
            }
            cashes[i] = new Cash(speed);
        }
        System.out.println("Write the number of cycles of the store");
        int countOfSteps = in.nextInt();
        for (int i = 0; i < countOfSteps; i++){
            if (i < countOfCustomers) {
                Customer customer = factory.createCustomer();
                Cash chosenCash = customer.choosingCash(cashes);
                chosenCash.addCustomer(customer);
            }
            printCashes(cashes);
            for (Cash cash:cashes){
                cash.service();
            }
        }
        System.out.println("State of cashes before closing the store");
        printCashes(cashes);
    }
}
