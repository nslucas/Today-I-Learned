package application;

import entitites.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        List<Employee> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            System.out.println("Employee " + (i+1) + ":");
            Integer empId;
            String empName;
            Double empSalary;
            sc.nextLine();
            System.out.print("Id: ");
            empId = sc.nextInt();
            while (hasId(list, empId)){
                System.out.println("Id already taken! Try again: ");
                empId = sc.nextInt();
            }

            System.out.print("Name: ");
            empName = sc.next();
            sc.nextLine();
            System.out.print("Salary: ");
            empSalary = sc.nextDouble();

            Employee emp = new Employee(empId, empName, empSalary);
            list.add(emp);
        }

            System.out.print("Enter the employee id that will have salary increase: ");
            int idSalary = sc.nextInt();
            Integer pos = position(list, idSalary);

            if(pos == null) {
                System.out.println("This id does not exist!");
            } else {
                System.out.print("Enter the percentage: ");
                double percent = sc.nextDouble();
                list.get(pos).increaseSalary(percent);
            }
        System.out.println();
        System.out.println("List of employees: ");
        for(Employee emp : list){
            System.out.println(emp);
        }

        sc.close();
    }

    public static Integer position(List<Employee> list, int id) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                 return i;
            }
        }
        return null;

    }

    public static boolean hasId(List<Employee> list, int id){
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}

