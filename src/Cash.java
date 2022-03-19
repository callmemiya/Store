import java.util.LinkedList;
import java.util.Queue;

public class Cash {
    private final int speed;
    private LinkedList<Customer> queue;

    public Cash(int speed){
        this.speed = speed;
        this.queue = new LinkedList<>();
    }

    public void addCustomer(Customer customer){
        this.queue.add(customer);
    }

    public int getSpeed(){
        return this.speed;
    }

    public LinkedList<Customer> getQueue(){
        return this.queue;
    }

    public int getCountQueue(){
        return queue.size();
    }

    public void service(){
        int remains = this.speed;
        for (Customer customer : queue){
            int rest = customer.getRemains() - remains;
            if (rest > 0){
                customer.changeRemains(rest);
                break;
            } else if (rest < 0){
                queue.remove(customer);
                remains = -rest;
            } else {
                queue.remove(customer);
                break;
            }
        }
    }
}
