/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.crud;

import com.itn.model.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sumit
 */
public class UsingPreparedSrtatement {
    private static final String DRIVER_CLASS= "com.sql.jdbc.Driver";
    private static final String URL= "jdbc:sql://localhost:3306/jdbc_demo";
    private static final String USER="root";
    private static final String  PASS="";
    
    public PreparedStatement connect(String sql){
         Connection conn = null;
         PreparedStatement ps= null;
         try{ Class.forName(DRIVER_CLASS);
          conn=DriverManager.getConnection(URL, USER, PASS);
          ps=conn.prepareStatement(sql);
         }
         catch(ClassNotFoundException | SQLException e){
             System.out.println(e);
         }
         return ps;
            
    }
    public void insert(Employee e){
//          PreparedStatement ps= null;
           String sql="insert into employee_table1 (name,address,salary) values(?,?,?)";
            PreparedStatement ps= connect(sql);
        try{
         
            ps.setString(1, e.getName());
            ps.setString(2, e.getAddress());
            ps.setDouble(3, e.getSalary());
            
            ps.executeUpdate(); // hamile paila nai sql statemnt ps ma  save gareko xau tesaile () blank rakheko hoo
        }catch(SQLException se){
            System.out.println(se);
        }finally{
            try{
                ps.close();
            }catch(SQLException se){
                System.out.println(se);
            }
        }
    } 
    
}
