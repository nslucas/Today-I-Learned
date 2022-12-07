package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Employee " + i + " data");
            System.out.print("Outsourced? (y/n) ");
            String outsourced = sc.next();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            if(outsourced.contains("y")){
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                OutsourcedEmployee outEmp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                list.add(outEmp);
            } else {
                Employee emp = new Employee(name, hours, valuePerHour);
                list.add(emp);
            }

        }
        System.out.println("PAYMENTS: ");
        for (Employee emp : list){
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
        }

        sc.close();
    }
}