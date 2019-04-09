/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.app;

import com.itn.dao.EmployeeDao;
import com.itn.model.Employee;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sumit
 */
public class EmpMgmt {
    private static Scanner sc= new Scanner(System.in);
    public Employee newEmployee(){
   
        Employee emp= new Employee();
        System.out.println("enter your name");
        emp.setName(sc.nextLine());
        System.out.println("enter your address");
        emp.setAddress(sc.nextLine());
        System.out.println("enter your salary");
        emp.setSalary(sc.nextDouble());
        return emp;
    }
       public Employee updateEmployee( int id){
        Employee emp = new Employee();
        emp.setId(id);
        sc.nextLine();
        System.out.println("enter your name");
        emp.setName(sc.nextLine());
        System.out.println("enter your address");
        emp.setAddress(sc.nextLine());
        System.out.println("enter your salary");
        emp.setSalary(sc.nextDouble());
        return emp;
    }
    public void displayEmployee(Employee e){
        System.out.println(e.toString());
    }
    
    public void menu(){
        System.out.println("welcome to employee managment system");
        System.out.println("employee mangment services");
        System.out.println("1. Add new Employee..\n2. view all employee. \n"
                +"3. View selected employee. \n4. update employee record. \n "
                +"5. Delete employee record \n"+"6.do you want to quit.");
    }
    
    public static void main(String[] args) {
        
        System.out.println("welcome to employee managment");
        EmpMgmt em= new EmpMgmt();
        EmployeeDao empDao= new EmployeeDao();
       
       while(true){ 
         em.menu();
        int choice =sc.nextInt();
        switch(choice){
            case 1: //insert employee record
                Employee e= em.newEmployee();
                //new employee fills a employee information into default employee object
                //and returns that object
                empDao.insertEmployee(e);
                break;
            case 2://select all employee
                ArrayList<Employee> al= empDao.getAllEmployee();
                for(Employee e1:al){
                    em.displayEmployee(e1);
                }
                break;
            case 3:// select one employee with gien id
                System.out.println("enter id of employee");
                int id = sc.nextInt();
                e=empDao.getEmployeeById(id);
                if  (e!=null){
                    em.displayEmployee(e);
                }else{
                    System.out.println("record of employee with id "+id+ "not found");
                    
                }
                break;
            case 4: // update employee record
                System.out.println("enter id of employee to update ");
                id = sc.nextInt();
                //display employee and then update
                e=empDao.getEmployeeById(id);
                if(e!=null){
                    em.displayEmployee(e);
                    //update this employee
                    e=em.updateEmployee(id);
                    empDao.updateEmployee(e);
                }
                else{
                    System.out.println("record of employee not found");
                }
                
                break;
            case 5 :
                System.out.println("enter id of the employee to delete : ");
                id= sc.nextInt();
                Employee emp = empDao.getEmployeeById(id);
                if(emp!=null){
                    System.out.println(emp.toString());
                }else{
                    System.out.println("no any data is found");
                }
                empDao.deleteData(id);
                
                
                
                System.out.println("Record Deleted");
                break;
            case 6:
                System.out.println("do you want to quit :");
                 char quit= sc.next().charAt(0);
                if(quit == 'y' || quit =='Y'){
                    System.exit(0);
                }
                
            default:
                System.out.println("wrong choice selected");
        }
      }
        

    }
}
