package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args){

        DepartmentDAO departmentDAO = DaoFactory.createDepartmentDAO();
        System.out.println("\n=== TEST 1: Department insert ===");
        Department newDepartment = new Department(null, "Human Resources - HR");
        /*departmentDAO.insert(newDepartment);
        System.out.println("New id" + newDepartment.getId()); */

        System.out.println("\n=== TEST 2: Department update ===");
        Department dep2 = departmentDAO.findById(5);
        dep2.setName("Operational");
        departmentDAO.update(dep2);
        System.out.println("Update completed!");


    }
}
