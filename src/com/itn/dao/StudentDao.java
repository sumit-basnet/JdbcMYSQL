/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.dao;

import com.itn.model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author sumit
 */
public class StudentDao {
    private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/jdbc_demo";
    private static final String  USER="root";
    private static final String PASS="";
    
    public  Statement connection(){
      Connection conn= null;
      Statement stmt=null;
      try{
      Class.forName(DRIVER_CLASS);
      conn= DriverManager.getConnection(URL, USER, PASS);
      stmt= conn.createStatement();
      }catch(ClassNotFoundException | SQLException ex ){
          System.out.println(ex);
      }
      return stmt;
    }
    
    public void insertOperation(Student s){
            
        Student std= s;
                
        Statement stmt1= connection();
        String sql="insert into student_table (name, address, roll) values('"+std.getName()+"',"
                + "'"+std.getAddress()+"',"+std.getRoll()+")";
        
        try{
        int i= stmt1.executeUpdate(sql);
        if(i >0){
            System.out.println("data inserted");
        }else{
            System.out.println("operation failed");
        }
      }catch(SQLException se){
            System.out.println(se);
      }
        
    }
    
    public LinkedList <Student>  allSelectOperation(){
        LinkedList l1= new LinkedList();
        
        Statement stmt1 = connection();
        String sql= "select * from student_table";
        try{
        ResultSet rs = stmt1.executeQuery(sql);
        if(rs!=null){
        while(rs.next()){
            int id= rs.getInt("id");
            String name= rs.getString("name");
            String address= rs.getString("address");
            int roll=rs.getInt("roll");
            Student s= new Student(id,name,address,roll);
            l1.add(s);
        }
        }else{
            System.out.println("data cannot be found");
        }
        }catch(SQLException se){
            System.out.println(se);
        }
        return l1;
    }
    
}
