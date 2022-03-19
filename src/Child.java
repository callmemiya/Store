import java.util.Random;

public class Child extends Customer{
//    private int purchaseCount;
//    private boolean isJustCome;
//    private int remainsOfPurchases;

//    public Child(){
//        super();
//    }

    public String getName(){
        return "Child";
    }

    public Cash choosingCash(Cash[] cash){
        Random rnd = new Random();
        return cash[rnd.nextInt(cash.length)];
    }

//    public int getRemains(){
//        return this.remainsOfPurchases;
//    }

//    public void changeRemains(int rest){
//        this.remainsOfPurchases = rest;
//    }
}
