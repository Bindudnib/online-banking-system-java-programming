import java.util.*;

public class Account {
    private String username;
    private double balance;
    private List<Transaction> transactions;
    private User user;

    public Account(String username, double initialDeposit) {
        this.username = username;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        this.user = new User(username);
        transactions.add(new Transaction("Deposit", initialDeposit));
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public boolean transferTo(Account receiver, double amount) {
        if (withdraw(amount)) {
            receiver.deposit(amount);
            transactions.add(new Transaction("Transfer to " + receiver.getUsername(), amount));
            receiver.addTransaction(new Transaction("Transfer from " + username, amount));
            return true;
        }
        return false;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printTransactionHistory() {
        System.out.println("Transaction history for " + username + ":");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public String getUsername() {
        return username;
    }

    public User getUser() {
        return user;
    }
}
