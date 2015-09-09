package bank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dennis on 9/9/2015.
 */
public class Bank {

    private List<Account> accountList;
    private Integer countOfAccounts;

    Bank(Integer countOfAccounts) {
        this.accountList = new ArrayList<>();
        this.countOfAccounts = countOfAccounts;
        for (int i = 0; i < countOfAccounts; i++) {
            accountList.add(new Account(Randoma.randInt(500, 12000)));
        }
    }

    public void transfer(Account from, Account to, int amount) {

        synchronized (from) {
            synchronized (to) {
                try {
                    from.withdraw(amount);
                } catch (IOException e) {
                    System.out.println(e);
                }
                to.deposit(amount);
            }
        }
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Integer getTotalSumOfBank() {
        Integer totalSumOfBank = 0;
        for (int i = 0; i < accountList.size(); i++) {
            totalSumOfBank = totalSumOfBank + accountList.get(i).getSumTotal();
        }
        return totalSumOfBank;
    }
}
