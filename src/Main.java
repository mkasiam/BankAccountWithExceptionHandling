// Main.java
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123", 100.0);

        try {
            // Deposit $50
            account.deposit(50);
            // Withdraw $200
            System.out.println("Attempting to withdraw $200.0");
            account.withdraw(200);
        } catch (InsufficientFundsException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempting to withdraw $50.0");
        }

        try {
            // Withdraw $50
            account.withdraw(50);
        } catch (InsufficientFundsException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempting to deposit -$10.0");
        }

        try {
            // Invalid deposit of -$10
            account.deposit(-10);
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        // Printing the final balance
        System.out.println("Final balance: $" + account.getBalance());

        // Finally end of the transaction
        System.out.println("End of transaction.");
    }
}
