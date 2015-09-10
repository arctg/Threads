package bank;

import java.io.IOException;

/**
 * Created by dennis on 9/9/2015.
 */
public class Account {

    private Integer sumTotal;
    private int id;

    Account(Integer sumTotal,int id){
        this.sumTotal=sumTotal;
        this.id = id;
    }

    public void deposit (Integer amount){
        this.sumTotal = this.sumTotal + amount;
    }

    public void withdraw (Integer amount) throws IOException{
        if (amount>this.sumTotal){
            throw new IOException("There is not enough money to withdraw");
        } else this.sumTotal = this.sumTotal-amount;
    }

    public Integer getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(Integer sumTotal) {
        this.sumTotal = sumTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
