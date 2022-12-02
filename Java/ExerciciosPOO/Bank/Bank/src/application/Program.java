package application;

import entities.checkingAccount;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        checkingAccount acc;

        System.out.print("Enter account number: ");
        int num = sc.nextInt();
        System.out.print("Enter account holder: ");
        sc.nextLine();
        String accountOwner = sc.nextLine();
        System.out.print("Is there a initial deposit? (y/n) ");
        char response = sc.next().charAt(0);
        if(response == 'y') {
            System.out.println("Enter initial deposit value: ");
            double value = sc.nextDouble();
            acc = new checkingAccount(accountOwner, num, value);
        } else{
            acc =  new checkingAccount(accountOwner, num);
        }

        System.out.println("Account data:");
        System.out.println(acc);

        double deppositValue;
        System.out.print("Enter a deposit value: ");
        deppositValue = sc.nextDouble();
        acc.deposit(deppositValue);
        System.out.println("Updated account data: ");
        System.out.println(acc);

        double withdrawValue;
        System.out.print("Enter a withdraw value: ");
        withdrawValue = sc.nextDouble();
        acc.withdrawl(withdrawValue);
        System.out.println("Updated account data: ");
        System.out.println(acc);

    }
}