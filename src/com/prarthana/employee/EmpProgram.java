/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.employee;

import com.prarthana.employee.dao.EmployeeDAO;
import com.prarthana.employee.dao.impl.EmployeeImpl;
import com.prarthana.employee.obj.Employee;
import java.util.Scanner;

/**
 *
 * @author Pavilion G4
 */
public class EmpProgram {

    
    public static void main(String[] args) {
       
 EmployeeDAO empDAO = new EmployeeImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("EMPLOYEE MANAGEMENT SYSTEM MENU");
            System.out.println("........................................");
            System.out.println("1. Add a new Employee");
            System.out.println("2. Delete an Employee by ID");
            System.out.println("3. Print Employee List");
            System.out.println("4. Search Employee By ID");
            System.out.println("5. Exit");
            System.out.println("Enter your choice[1-5]:");

            switch (sc.nextInt()) {
                case 1:
                    
                    Employee e = new Employee();
                    System.out.println("Enter ID: ");
                    e.setId(sc.nextInt());
                   
                    System.out.println("Enter Name: ");
                    e.setName(sc.next());
                    
                    System.out.println("Enter Address: ");
                    e.setAddress(sc.next());
                    
                    System.out.println("Enter Post: ");
                    e.setPost(sc.next());
                    
                    System.out.println("Enter Salary: ");
                    e.setSalary(sc.nextFloat());
                    
                    System.out.println("Enter Status: ");
                    e.setStatus(sc.nextBoolean());

                    if (empDAO.insert(e)) {
                        System.out.println("Inserted Successfully!!");
                    } else {
                        System.out.println("Can't add more Employees. Data Full!!");
                    }

                    break;
                case 2:
                    System.out.println("Enter the ID of the Employee you want to delete: ");
                    int idd = sc.nextInt();
                    if (empDAO.delete(idd)) {
                        System.out.println("The Employee with ID no. :" + idd + " is deleted successfully.");
                    } else {
                        System.out.println("ID not found.");
                    }

                    break;
                case 3:
                    System.out.println("Employees Record");
                    System.out.println(".................................");
                    Employee[] employees = empDAO.getAll();
                    for (int i = 0; i < employees.length; i++) {
                        Employee employee = employees[i];
                        if (employee != null) {
                            System.out.println("ID = " + employee.getId());
                            System.out.println("Name = " + employee.getName());
                            System.out.println("Address = " + employee.getAddress());
                            System.out.println("Post = " + employee.getPost());
                            System.out.println("Salary = Rs." + employee.getSalary());
                            System.out.println("Status = " + employee.isStatus());

                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the ID of the employee you want to search: ");
                    int id = sc.nextInt();
                    Employee em = empDAO.getById(id);

                    System.out.println("ID = " + em.getId());
                    System.out.println("NAME = " + em.getName());
                    
                    System.out.println("ADDRESS = " + em.getAddress());
                    System.out.println("POST = " + em.getPost());
                    System.out.println("SALARY = Rs." + em.getSalary());
                    System.out.println("STATUS = " + em.isStatus());

                    break;
                case 5:
                    System.out.println("Do you really want to exit [Y/N]");
                    if (sc.next().equalsIgnoreCase("y")) {
                        System.out.println("Thankyou, Visit Again.");
                        System.exit(0);
                    }
                    System.exit(0);
                    break;

            }

        }
    }

}
