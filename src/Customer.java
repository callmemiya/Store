import java.util.Random;

public abstract class Customer {
    private int purchaseCount;
    private boolean isJustCome;
    private int remainsOfPurchases;

    public Customer(){
        Random random = new Random();
        this.purchaseCount = random.nextInt(5) + 1;
        this.remainsOfPurchases = this.purchaseCount;
    }

    abstract String getName();

    abstract Cash choosingCash(Cash[] cash);

    public int getRemains(){
        return this.remainsOfPurchases;
    };

    public void changeRemains(int rest){
        this.remainsOfPurchases = rest;
    };
}
