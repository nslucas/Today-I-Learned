import exceptions.DomainException;
import model.entities.Account;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data: ");
        System.out.print("Number: ");
        int num = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();
        Account acc = new Account(num, holder, balance, withdrawLimit);
        System.out.println("Saldo disponivel: " + acc.getBalance());

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();
        try {
            acc.withdraw(amount);
            System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
        }
        catch(DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected error!");
        }
        sc.close();

    }
}