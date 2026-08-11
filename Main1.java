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

    public static void main(String[] args) {

        System.out.println("===== BANK MANAGEMENT SYSTEM =====");

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
}