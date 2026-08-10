import java.util.ArrayList;
import java.util.Scanner;

class Account {
    int accountNumber;
    String name;
    double balance;

    Account(int accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0.0;
    }
}

public class Main {

    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===== BANKING MANAGEMENT SYSTEM =====");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        boolean exists = false;

        for (Account account : accounts) {
            if (account.accountNumber == accountNumber) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Account already exists!");
        } else {
            Account account = new Account(accountNumber, name);
            accounts.add(account);

            System.out.println("Account created successfully!");
            System.out.println("Account Number: " + account.accountNumber);
            System.out.println("Account Holder: " + account.name);
            System.out.println("Balance: " + account.balance);
        }
    }
}