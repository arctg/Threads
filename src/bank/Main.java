package bank;

public class Main {

    public static void main(String[] args) {


        Bank bank = new Bank(200);
        System.out.println(bank.getAccountList());
        System.out.println("Before transfer: " + bank.getTotalSumOfBank());

        System.out.println(bank.getAccountList().get(0).getSumTotal());
        System.out.println(bank.getAccountList().get(15).getSumTotal());



        for (int i=0;i<bank.getAccountList().size();i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    System.out.println(bank.getAccountList().get(0).getSumTotal());
//                    System.out.println(bank.getAccountList().get(15).getSumTotal());
                    bank.transfer(
                            bank.getAccountList().get(Randoma.randInt(0,bank.getAccountList().size()-1)),
                            bank.getAccountList().get(Randoma.randInt(0,bank.getAccountList().size()-1)),
//                            bank.getAccountList().get(0),
//                            bank.getAccountList().get(15),
                            Randoma.randInt(20,50))
                    ;
//                    System.out.println(bank.getAccountList().get(0).getSumTotal());
//                    System.out.println(bank.getAccountList().get(15).getSumTotal());

                }
            }).start();
        }

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Active: " + Thread.activeCount());
        System.out.println("After transfer: " + bank.getTotalSumOfBank());
    }
}
