package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDAO departmentDAO = DaoFactory.createDepartmentDAO();
        System.out.println("\n=== TEST 1: Department findById ===");
        Department dep = departmentDAO.findById(1);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: Department findAll ===");
        List<Department> list = departmentDAO.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n=== TEST 3: Department insert ===");
        Department newDepartment = new Department(null, "Human Resources - HR");
        /*departmentDAO.insert(newDepartment);
        System.out.println("New id" + newDepartment.getId()); */

        System.out.println("\n=== TEST 4: Department update ===");
        Department dep2 = departmentDAO.findById(5);
        dep2.setName("Operational");
        departmentDAO.update(dep2);
        System.out.println("Update completed!");

        System.out.println("\n=== TEST 5: Department delete ===");
        System.out.print("Enter ID for delete test: ");
        int id = sc.nextInt();
        departmentDAO.deleteById(id);
        System.out.println("Deleted!");

    }
}
