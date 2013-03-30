package fr.stateofmind.cucumber;

public class Account {
    private Integer balance = 0;

    public Integer getBalance() {
        return balance;
    }

    public void deposit(int depositedAmount) {
        balance += depositedAmount;
    }
}
