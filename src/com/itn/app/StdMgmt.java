/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.app;

import com.itn.dao.StudentDao;
import com.itn.model.Student;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author sumit
 */
public  class StdMgmt  {
    Scanner sc= new Scanner(System.in);
  public Student insert(){
      Student std= new Student();
      System.out.println("enter name : ");
      String name = sc.nextLine();
      std.setName(name);
      System.out.println("enter address : ");
      String address= sc.nextLine();
      std.setAddress(address);
      System.out.println("enter roll number : ");
      int roll =sc.nextInt();
      std.setRoll(roll);
      return std;
      
  }  
  
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the number ");
        int n= sc.nextInt();
    switch(n){
        case 1:  // now performng the insert operation 

            StdMgmt stm= new StdMgmt();
            StudentDao StdDao= new StudentDao();
            Student s=stm.insert();
            StdDao.insertOperation(s);
            break;
        case 2:// performing the select all operation
            LinkedList<Student> ll= new LinkedList();
            StudentDao StdDao1= new StudentDao();
            ll= StdDao1.allSelectOperation();
            for(Student s1:ll){
                System.out.println(s1.toString());
            }
            break;
        default :
            System.out.println("no operation performed");
    }
  }
 
  
   
}
