package application;

import entities.CurrencyConverter;
import entities.Employee;
import entities.Rectangle;
import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double preco;
        double quantidade;
        System.out.print("What is the dollar price? ");
        CurrencyConverter.cotacaoDolar = sc.nextDouble();
        System.out.print("How many dollars will be bought? ");
        CurrencyConverter.quantidade = sc.nextDouble();
        System.out.println("Amount to be paid in reais = " + CurrencyConverter.compraDolar());


        /*Student stud = new Student();
        stud.name = sc.nextLine();
        stud.grade1 = sc.nextDouble();
        stud.grade2 = sc.nextDouble();
        stud.grade3 = sc.nextDouble();

        System.out.printf("FINAL GRADE: %.2f%n", stud.finalGrade());
        if (stud.finalGrade() < 60.0) {
            System.out.println("FAILED");
            System.out.printf("MISSING %.2f POINTS%n", stud.missingPoints());
        }
        else {
            System.out.println("PASS");
        }

         */


        /*
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Employee e = new Employee();
        System.out.print("Name: ");
        e.name = sc.next();
        System.out.print("Gross salary: ");
        e.grossSalary = sc.nextDouble();
        System.out.print("Tax: ");
        e.tax = sc.nextDouble();

        System.out.println("Employee: " + e.name + ", $" + e.netSalary());


        System.out.print("Which percentage to increase salary? ");
        double percentage = sc.nextDouble();
        e.increaseSalary(percentage);
        System.out.println("Updated data: " + e.name + " $" + e.netSalary());
        sc.close();
        */



        /*
        Rectangle r = new Rectangle();

        System.out.println("Enter rectangle width and height: ");
        r.width = sc.nextDouble();
        r.height = sc.nextDouble();

        System.out.printf("Area: " + r.area());
        System.out.println();
        System.out.printf("Perimeter: " + r.perimeter());
        System.out.println();
        System.out.printf("Diagonal: " + r.diagonal());
         */
    }
}