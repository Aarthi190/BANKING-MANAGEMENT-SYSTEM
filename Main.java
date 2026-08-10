import java.util.ArrayList;
import java.util.Scanner;

class Account {
    int accountNumber;
    String name;
    double balance;

    Account(int accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0;
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== BANKING MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Bank Balance");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    System.out.println("Thank you for using Banking Management System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    static void createAccount() {

        System.out.println("\n===== CREATE ACCOUNT =====");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        for (Account a : accounts) {
            if (a.accountNumber == accountNumber) {
                System.out.println("Account already exists!");
                return;
            }
        }

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        Account account = new Account(accountNumber, name);
        accounts.add(account);

        System.out.println("Account Created Successfully!");
    }

    static void deposit() {

        System.out.println("\n===== DEPOSIT =====");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Deposit Amount!");
            return;
        }

        account.balance += amount;

        System.out.println("Deposit Successful!");
        System.out.println("Current Balance: " + account.balance);
    }

    static void withdraw() {

        System.out.println("\n===== WITHDRAW =====");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        System.out.print("Enter Withdraw Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Withdraw Amount!");
        } else if (amount > account.balance) {
            System.out.println("Insufficient Balance!");
        } else {
            account.balance -= amount;

            System.out.println("Withdraw Successful!");
            System.out.println("Current Balance: " + account.balance);
        }
    }

    static void checkBalance() {

        System.out.println("\n===== CHECK BANK BALANCE =====");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();

        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account Not Found!");
            return;
        }

        System.out.println("Account Number: " + account.accountNumber);
        System.out.println("Account Holder: " + account.name);
        System.out.println("Bank Balance: " + account.balance);
    }

    static Account findAccount(int accountNumber) {

        for (Account account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }

        return null;
    }
}