public class Man extends Customer {
//    private int purchaseCount;
//    private boolean isJustCome;
//    private int remainsOfPurchases;

//    public Men(){
//        super();
//    }

    public String getName(){
        return "Man";
    }

    public Cash choosingCash(Cash[] cash) {
        int purchase = this.getRemains();
        Cash chosenCash = cash[0];
        for (Customer customer: cash[0].getQueue()){
            purchase += customer.getRemains();
        }
        double minRestSteps = purchase / (double)cash[0].getSpeed();
        for (int i = 1; i < cash.length; i++){
            purchase = this.getRemains();
            for (Customer customer: cash[i].getQueue()){
                purchase += customer.getRemains();
            }
            double restSteps = purchase / (double)cash[i].getSpeed();
            if (restSteps < minRestSteps){
                minRestSteps = restSteps;
                chosenCash = cash[i];
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
