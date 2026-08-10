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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        // CREATE ACCOUNT

        System.out.println("===== CREATE ACCOUNT =====");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        Account account = new Account(accountNumber, name);
        accounts.add(account);

        System.out.println("\nAccount Created Successfully!");
        System.out.println("Account Number: " + account.accountNumber);
        System.out.println("Account Holder: " + account.name);
        System.out.println("Balance: " + account.balance);

        // DEPOSIT

        System.out.println("\n===== DEPOSIT =====");

        System.out.print("Enter Account Number: ");
        int depositAccountNumber = sc.nextInt();

        Account depositAccount = null;

        for (Account a : accounts) {
            if (a.accountNumber == depositAccountNumber) {
                depositAccount = a;
                break;
            }
        }

        if (depositAccount != null) {

            System.out.print("Enter Deposit Amount: ");
            double amount = sc.nextDouble();

            if (amount > 0) {
                depositAccount.balance = depositAccount.balance + amount;

                System.out.println("\nDeposit Successful!");
                System.out.println("Deposited Amount: " + amount);
                System.out.println("Current Balance: " + depositAccount.balance);
            } else {
                System.out.println("Invalid Deposit Amount!");
            }

        } else {
            System.out.println("Account Not Found!");
        }

        // WITHDRAW

        System.out.println("\n===== WITHDRAW =====");

        System.out.print("Enter Account Number: ");
        int withdrawAccountNumber = sc.nextInt();

        Account withdrawAccount = null;

        for (Account a : accounts) {
            if (a.accountNumber == withdrawAccountNumber) {
                withdrawAccount = a;
                break;
            }
        }

        if (withdrawAccount != null) {

            System.out.print("Enter Withdraw Amount: ");
            double withdrawAmount = sc.nextDouble();

            if (withdrawAmount <= 0) {
                System.out.println("Invalid Withdraw Amount!");
            } else if (withdrawAmount > withdrawAccount.balance) {
                System.out.println("Insufficient Balance!");
            } else {
                withdrawAccount.balance = withdrawAccount.balance - withdrawAmount;

                System.out.println("\nWithdraw Successful!");
                System.out.println("Withdrawn Amount: " + withdrawAmount);
                System.out.println("Current Balance: " + withdrawAccount.balance);
            }

        } else {
            System.out.println("Account Not Found!");
        }

        sc.close();
    }
}
