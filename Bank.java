interface HomeLoan{
     void applyHomeLoan(double amount);
}

interface AutoLoan{
     void applyAutoLoan(double amount);
}

class Account
{
    protected double balance;
    Account(double balance)
    {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void  deposit(double amount)
    {
        this.balance += amount;
    }
    public double getBalance()
    {
        return balance;
    }
}

class SavingsAccount extends  Account implements HomeLoan {
    SavingsAccount(double balance) {
        super(balance);
    }

    public void applyHomeLoan(double amount){
        System.out.println("Home loan of ₹" + amount + " applied successfully for Savings Account.");
    }
}

class CurrentAccount extends Account implements AutoLoan
{
    public static final int MIN_BALANCE = 2000;
    CurrentAccount(double balance)
    {
        super(balance);
    }
    public void withdraw(double amount)
    {
        if (balance-amount >= MIN_BALANCE) {
            balance -= amount;
        }
        else {
            System.out.println(" !!! Mandatory balance : "+ MIN_BALANCE + " and remaining balance will be: " + (balance-amount) );
        }
    }
    public void applyAutoLoan(double amount)
    {
        System.out.println("Auto loan of ₹" + amount + " applied successfully for Savings Account.");
    }

}

public class Bank{
    public static void main(String[] args)
    {
        SavingsAccount savingsAccount = new SavingsAccount(500);
        CurrentAccount currentAccount = new CurrentAccount(500);
        savingsAccount.withdraw(500);
        currentAccount.withdraw(500);
        System.out.println(savingsAccount.getBalance());
        System.out.println(currentAccount.getBalance());
        savingsAccount.applyHomeLoan(400000);
        currentAccount.applyAutoLoan(250000);
    }
}