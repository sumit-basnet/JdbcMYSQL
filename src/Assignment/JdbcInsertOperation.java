/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sumit
 */
public class JdbcInsertOperation {
    private static final String DRIVER_CLASS ="com.mysql.jdbc.Driver";
    //yo chai driver halna ko lagi ho as without driver data bse sanga kaam gardaena 
    private static final String URL="jdbc:mysql://localhost:3306/jdbc_demo";
    //yo chai server ko lagi ho  as mysql need to be hosted
     private static final String USER="root";
     private static final String PASSWORD="";
    
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt= null;
        try{
            //1. driver registration
            Class.forName(DRIVER_CLASS);
            
            //2.creating connection object
            conn= DriverManager.getConnection(URL,USER,PASSWORD);
            //creating the statement 
            stmt= conn.createStatement();
            
            //now finally writing the sql query
            String sql ="insert into employee_table1 (name,address,salary) "
                    + "values('avinaya','kalanki',34000.00)";
            
            // aaba chai data base ma halne 
            int  i = stmt.executeUpdate(sql);
            if(i==1){
                System.out.println("onr record has been inserted");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }finally{
            //6. closing opened statement
            try{
                if(stmt!=null){
                    stmt.close();
                }if(conn!=null){
                    conn.close();
                }
            }catch(SQLException e){
                        System.out.println(e);
                        }
        }
        
    }
}
