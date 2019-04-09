/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sumit
 */
public class JdbcInsert {

  private static final String DRIVER_CLASS ="com.mysql.jdbc.Driver";
  private static final String URL= "jdbc:mysql://localhost:3306/jdbc_demo";
  // line no 14 maa mysql. jdbc lekheko vayera tala 15 maa jdbc:mysql
  
  private static final String USER="root";
  private static final String PASS="";
  
          
          
          
    public static void main(String[] args) {
        Connection conn= null;
        Statement stmt= null;
        //import from java.sql pakage
        try{
        //1. Driver ragistration
        Class.forName(DRIVER_CLASS);
        //2. creating connection object
        conn= DriverManager.getConnection(URL,USER,PASS);
        
        //3. create a statement object using connecation
        stmt = conn.createStatement();
        
        //4.write sql query
        String sql ="insert into employee_table1 (name,address,salary) "
                + "values('Russa','Koteshwor',12000.00)";
        
        // 5. Execute sql query using statement object
         int i=stmt.executeUpdate(sql);
         if(i==1){
             System.out.println("One record has been inserted ");
         }
                
        }catch(ClassNotFoundException |SQLException e){
            System.out.println(e);
        }finally{
            //6. Closing Opened resources
            try{
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null){
                conn.close();
            }
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        
    }
    
}
