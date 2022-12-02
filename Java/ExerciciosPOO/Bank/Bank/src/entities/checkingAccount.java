package entities;

public class checkingAccount {
    private String accountOwner;
    private int numAccount;
    private double balance = 0;

    public checkingAccount(){

    }

    public checkingAccount(String accountOwner, int numAccount, double initialDeposit) {
        this.accountOwner = accountOwner;
        this.numAccount = numAccount;
        deposit(initialDeposit);
    }

    public checkingAccount(String accountOwner, int numAccount){
        this.accountOwner = accountOwner;
        this.numAccount = numAccount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public int getNumAccount() {
        return numAccount;
    }
    public double withdrawl(double value){
        int tax = 5;

        if(this.balance >= value) {
            double correctValue = value + tax;
            this.balance -= correctValue;
            System.out.print("Succesful withdrawal, current balance: " + this.getBalance() + "\n");
        } else if(this.balance < value){
            double correctValue = value + tax;
            this.balance -= correctValue;
            System.out.println("Succesful withdrawal, current balance: " + this.getBalance());
        }

        return balance;
    }

    public double deposit(double value){
        if(value > 0){
            this.balance += value;
        } else{
            System.out.println("Unable to perform this operation, try another value!");
        }

        return balance;
    }

    public String toString(){
        return "Account "
                + numAccount
                + ", Owner: "
                + accountOwner
                + ", Balance: $"
                + String.format("%.2f", balance);
    }


}
