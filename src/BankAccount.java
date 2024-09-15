public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.balance = amount;
    }

    // Method to deposit money
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount.");
        }
        balance += amount;
        System.out.println("Depositing $" + amount);
        System.out.println("New balance: $" + balance);
    }

    // Method to withdraw money
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds!");
        }
        balance -= amount;
        System.out.println("New balance: $" + balance);
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to get account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Method to transferMoney to another account
    public void transferMoney(BankAccount toAccount, double amount) throws InsufficientFundsException, InvalidAmountException {
        this.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Transferred $" + amount + " to account " + toAccount.getAccountNumber());
    }
}
