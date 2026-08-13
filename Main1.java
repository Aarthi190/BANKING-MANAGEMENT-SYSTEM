import java.util.HashMap;
import java.util.Scanner;

class Account {

    int accountId;
    String name;
    double balance;

    Account(int accountId, String name) {
        this.accountId = accountId;
        this.name = name;
        balance = 0;
    }
}

public class Main1 {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Account> accounts = new HashMap<>();

    static void createAccount() {

        System.out.println("\n===== CREATE ACCOUNT =====");

        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (accounts.containsKey(id)) {
            System.out.println("Account already exists!");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        Account account = new Account(id, name);

        accounts.put(id, account);

        System.out.println("Account created successfully!");
        System.out.println("Account ID : " + account.accountId);
        System.out.println("Name       : " + account.name);
        System.out.println("Balance    : " + account.balance);
    }

    static void depositMoney() {

        System.out.println("\n===== DEPOSIT MONEY =====");

        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        Account account = accounts.get(id);

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            account.balance = account.balance + amount;

            System.out.println("Amount deposited successfully!");
            System.out.println("Current Balance: " + account.balance);
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    static void withdrawMoney() {

        System.out.println("\n===== WITHDRAW MONEY =====");

        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        Account account = accounts.get(id);

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Withdrawal Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        } else if (amount > account.balance) {
            System.out.println("Insufficient Balance!");
        } else {
            account.balance = account.balance - amount;

            System.out.println("Amount withdrawn successfully!");
            System.out.println("Current Balance: " + account.balance);
        }
    }

    static void checkBalance() {

        System.out.println("\n===== CHECK BALANCE =====");

        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        Account account = accounts.get(id);

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.println("Account ID : " + account.accountId);
        System.out.println("Name       : " + account.name);
        System.out.println("Balance    : " + account.balance);
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== BANKING MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    depositMoney();
                    break;

                case 3:
                    withdrawMoney();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}