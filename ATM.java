
import java.util.HashMap;
import java.util.Scanner;

public class ATM {

    private HashMap<String, Account> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.initializeAccounts();
        atm.run();
    }

    public void run() {
        System.out.println("Welcome to the ATM!");

        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();

        if (authenticateUser(accountNumber, pin)) {
            mainMenu(accountNumber);
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private boolean authenticateUser(String accountNumber, String pin) {
        Account account = accounts.get(accountNumber);
        return account != null && account.getPin().equals(pin);
    }

    // Account management
    private void initializeAccounts() {
        accounts.put("123456", new Account("123456", "1234", 500.0));
        accounts.put("654321", new Account("654321", "4321", 1000.0));
    }

    private void mainMenu(String accountNumber) {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw(accountNumber);
                    break;
                case 2:
                    deposit(accountNumber);
                    break;
                case 3:
                    balanceInquiry(accountNumber);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void withdraw(String accountNumber) {
        Account account = accounts.get(accountNumber);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    private void deposit(String accountNumber) {
        Account account = accounts.get(accountNumber);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    private void balanceInquiry(String accountNumber) {
        Account account = accounts.get(accountNumber);
        System.out.println("Your current balance is: " + account.getBalance());
    }
}
