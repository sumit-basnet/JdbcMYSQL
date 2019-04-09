/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.dao;

import com.itn.model.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sumit
 */
public class EmployeeDao {
  private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/jdbc_demo";
    private static final String USER= "root";
    private static final String PASS="";
    
    public void  insertEmployee (Employee e){
        //insert a record of employee into database;
        Connection conn= null;
        Statement stmt= null;
        try{
            Class.forName(DRIVER_CLASS);
            conn= DriverManager.getConnection(URL, USER, PASS);
            conn.setAutoCommit(false);
            stmt=conn.createStatement();
            
            String sql= "insert into employee_table1(name,address,salary) "
                    + "values('"+e.getName()+"','"+e.getAddress()+"',"+e.getSalary()+")";
            System.out.println("sql : "+sql);
            
//            stmt.executeUpdate(sql);
            int i =stmt.executeUpdate(sql);
            if (i>0){
                System.out.println("record inserted");
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex);
            try{
                conn.rollback();
            }catch(SQLException exx){
                System.out.println(exx);
            }
        }finally{
            try{
               if(conn!=null){
                conn.commit();
                conn.close();
            }if(stmt !=null){
                stmt.close();
            } 
            }catch(SQLException se){
                System.out.println(se);
            }
        }
    }
    
    public ArrayList<Employee> getAllEmployee(){
      ArrayList<Employee> al= new ArrayList();
      Connection conn= null;
      Statement stmt= null;
      try{
          Class.forName(DRIVER_CLASS);
          conn= DriverManager.getConnection(URL, USER, PASS);
          stmt = conn.createStatement();
          String sql= "select * from employee_table1";
          ResultSet rs= stmt.executeQuery(sql);
          
          while(rs.next()){
              int id= rs.getInt("id");
              String name= rs.getString("name");
              String address = rs.getString("address");
              double salary= rs.getDouble("salary");
              //Employee table's field to employee object Mapping
              Employee e= new Employee(id,name,address,salary);
              al.add(e);
          }
          
      }catch(ClassNotFoundException | SQLException ex){
          System.out.println(ex);
     
          
      }finally{
          try{
              if(stmt!=null){
                  stmt.close();
              }if(conn!=null){
                  conn.close();
              }   
          }catch(SQLException se){
              System.out.println(se);        
              }
      }
      
      return al;
    }
    
    public Employee getEmployeeById( int id) {
        //get specific employee from employee_table1 with provided id
       Connection conn = null;
       Statement stmt= null;
       Employee e= null;
       try{
           Class.forName(DRIVER_CLASS);
           conn = DriverManager.getConnection(URL,USER,PASS);
           stmt = conn.createStatement();
           String sql ="select id,name ,address ,salary from employee_table1 where id="+id;
           ResultSet rs= stmt.executeQuery(sql);
           //euta matra return gaarxa so while loop nalagako
           if(rs.next()){
               int eid= rs.getInt(1);
               String name= rs.getString(2);
               String address= rs.getString(3);
               double salary= rs.getDouble(4);
               
               e= new Employee(eid,name,address,salary);
               // if the data is not found than object is not created so the null value 
               //that we have assigned in line 110 is returned 
               
               
           }
       }catch(ClassNotFoundException | SQLException se){
           System.out.println(se);
       }finally{
           try{
           if(stmt !=null){
               stmt.close();
           }if(conn !=null){
               conn.close();
           }
           }catch(SQLException se){
                   System.out.println(se);
                   }
       }
       
       
       return e;
    }

    public void updateEmployee(Employee emp) {
        //get specific employee from employee_table1 with provided id
       Connection conn = null;
       Statement stmt= null;
       Employee e= null;
       try{
           Class.forName(DRIVER_CLASS);
           conn = DriverManager.getConnection(URL,USER,PASS);
           stmt = conn.createStatement();
           String sql ="update employee_table1 set "
                   + "name='"+emp.getName()+"', "
                   + "address='"+emp.getAddress()+"', "
                   +"salary="+emp.getSalary()+" where id="+emp.getId();
           int i = stmt.executeUpdate(sql);
                   if (i>0){
                       System.out.println("update operation s completed ");
                   }
//           ResultSet rs= stmt.executeQuery(sql);
//           //euta matra return gaarxa so while loop nalagako
//           if(rs.next()){
//               int eid= rs.getInt(1);
//               String name= rs.getString(2);
//               String address= rs.getString(3);
//               double salary= rs.getDouble(4);
//               
//               e= new Employee(eid,name,address,salary);
//               // if the data is not found than object is not created so the null value 
//               //that we have assigned in line 110 is returned 
               
               
//           }
           
       }catch(ClassNotFoundException | SQLException se){
           System.out.println(se);
       }finally{
           try{
           if(stmt !=null){
               stmt.close();
           }if(conn !=null){
               conn.close();
           }
           }catch(SQLException se){
                   System.out.println(se);
                   }
       }
//       return e;
    }
    public void deleteData(int id){
        Connection conn= null;
        Statement stmt= null;
        try{
            Class.forName(DRIVER_CLASS);
            conn=DriverManager.getConnection(URL, USER, PASS);
            stmt= conn.createStatement();
            String sql= "delete from employee_table1 where id =" +id;
            int i= stmt.executeUpdate(sql);
            if(i>0){
                System.out.println("record has been deleted");
            }else{
                System.out.println("record not found ");
            }
                    
                    
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        }
    } 

}
