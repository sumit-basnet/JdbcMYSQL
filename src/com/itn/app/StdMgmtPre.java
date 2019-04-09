/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.app;

import com.itn.dao.StdPreparedDao;
import com.itn.model.Student1;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sumit
 */
public class StdMgmtPre {
      Scanner sc= new Scanner(System.in);
  public Student1 insert(){
      Student1 std= new Student1();
      System.out.println("enter name : ");
      String name = sc.nextLine();
      std.setName(name);
      System.out.println("enter address : ");
      String address= sc.nextLine();
      std.setAddress(address);
      System.out.println("enter phone : ");
      long phone =sc.nextLong();
      std.setPhone(phone);
      return std;
      
  }  
    public  Student1 update(int id){
      Student1 std= new Student1();
      std.setId(id);
      System.out.println("enter name : ");
      String name = sc.nextLine();
      std.setName(name);
      System.out.println("enter address : ");
      String address= sc.nextLine();
      std.setAddress(address);
      System.out.println("enter phone : ");
      long phone =sc.nextInt();
      std.setPhone(phone);
      return std;
    }
      
    public static void menu(){
        System.out.println("welcome to student managment system");
        System.out.println("student mangment services");
        System.out.println("1. Add new Student..\n2. view all Students. \n"
                +"3. View selected student.. \n4. update Student record. \n "
                +"5. Delete Student record \n"+"6.do you want to quit.");
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
    while(true){ 
       menu();
       System.out.println("enter the number ");
        int n= sc.nextInt();
    switch(n){
        case 1:  // now performng the insert operation 

            StdMgmtPre stm= new StdMgmtPre();
            StdPreparedDao StdDao= new StdPreparedDao();
            Student1 s=stm.insert();
            StdPreparedDao.saveStudent(s);
            break;
        case 2:// performing the select all operation
            ArrayList<Student1> ll= new ArrayList();
            ll=StdPreparedDao.getAllStudents();
            for(Student1 s1:ll){
                System.out.println(s1.toString());
            }
            break;
        case 3: //performing select by id operation
            System.out.println("enter id for selection ");
            int id=sc.nextInt();
            s=StdPreparedDao.getStudentById(id);
            System.out.println(s.toString());
            break;
            
        case 4: //performing update operation
            System.out.println("insert id to update the student :");
            id =sc.nextInt();
            StdMgmtPre st= new StdMgmtPre();
            s=StdPreparedDao.getStudentById(id);
            System.out.println(s.toString());
            Student1 stu=st.update(id);
            StdPreparedDao.updateStudent(stu);
            break;
            
        case 5: //performing the delete operation
            System.out.println("insert id to deleteoperation : ");
            id= sc.nextInt();
            StdPreparedDao.deleteStudent(id);
            break;
        case 6://to quit
            System.out.println("do you want to quit(Y/N)");
            char del=sc.next().charAt(0);
            if(del=='Y' || del=='y' ){
                System.exit(0);
            }
            break;
        default :
            System.out.println("no operation performed");
            break;
      }
   }
 }
    
}
