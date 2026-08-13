import java.util.HashMap;
import java.util.Scanner;

class Account {

    int accountId;
    String name;
    double balance;

    Account(int accountId, String name) {
        this.accountId = accountId;
        this.name = name;
        this.balance = 0;
    }
}

public class Main1 {

    static HashMap<Integer, Account> accounts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void createAccount() {

        System.out.println("===== CREATE ACCOUNT =====");

        System.out.print("Enter Account ID: ");
        int accountId = sc.nextInt();
        sc.nextLine();

        if (accounts.containsKey(accountId)) {
            System.out.println("Account already exists!");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        Account account = new Account(accountId, name);

        accounts.put(accountId, account);

        System.out.println("Account created successfully!");
        System.out.println("Account ID : " + account.accountId);
        System.out.println("Name       : " + account.name);
        System.out.println("Balance    : " + account.balance);
    }

    public static void depositMoney() {

        System.out.println("\n===== DEPOSIT MONEY =====");

        System.out.print("Enter Account ID: ");
        int accountId = sc.nextInt();

        Account account = accounts.get(accountId);

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
            System.out.println("Invalid Deposit Amount!");
        }
    }

    public static void withdrawMoney() {

        System.out.println("\n===== WITHDRAW MONEY =====");

        System.out.print("Enter Account ID: ");
        int accountId = sc.nextInt();

        Account account = accounts.get(accountId);

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Withdrawal Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount!");
        } 
        else if (amount > account.balance) {
            System.out.println("Insufficient Balance!");
        } 
        else {
            account.balance = account.balance - amount;

            System.out.println("Amount withdrawn successfully!");
            System.out.println("Current Balance: " + account.balance);
        }
    }

    public static void checkBalance() {

        System.out.println("\n===== CHECK BALANCE =====");

        System.out.print("Enter Account ID: ");
        int accountId = sc.nextInt();

        Account account = accounts.get(accountId);

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.println("Account ID : " + account.accountId);
        System.out.println("Name       : " + account.name);
        System.out.println("Balance    : " + account.balance);
    }

    public static void main(String[] args) {

        createAccount();

        depositMoney();

        withdrawMoney();

        checkBalance();

        sc.close();
    }
}