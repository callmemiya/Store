import java.util.Random;

public class Women extends Customer {
//    private int purchaseCount;
//    private boolean isJustCome;
//    private int remainsOfPurchases;

//    public Women(){
//        super();
//    }

    public String getName(){
        return "Woman";
    }

    public Cash choosingCash(Cash[] cash) {
        int minQueue = cash[0].getCountQueue();
        Cash chosenCash = cash[0];
        for (Cash value : cash) {
            if (minQueue > value.getCountQueue()) {
                minQueue = value.getCountQueue();
                chosenCash = value;
            }
        }
        return chosenCash;
    }

//    public int getRemains(){
//        return this.remainsOfPurchases;
//    }
//
//    public void changeRemains(int rest){
//        this.remainsOfPurchases = rest;
//    }
}
