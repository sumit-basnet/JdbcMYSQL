/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.dao;

import com.itn.model.Student1;
//import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author sumit
 */
import java.util.logging.Logger;
public class StdPreparedDao {
    private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
    private static final String URL= "jdbc:mysql://localhost:3306/jdbc_demo";
    private static final String USER="root";
    private static final String PASS="";
    
    private static PreparedStatement connect(String sql) throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER_CLASS);
        Connection conn= DriverManager.getConnection(URL, USER, PASS);
        return conn.prepareStatement(sql);
    }
    public static void saveStudent(Student1 s){
        PreparedStatement ps= null;
        try{
            String sql="insert into student_table1(name,address,phone) values(?,?,?)";
            ps=connect(sql);
            if(ps!=null){
                ps.setString(1, s.getName());
                ps.setString(2, s.getAddress());
                ps.setLong(3, s.getPhone());
                //execute prepared statement after adding values dynamically
                int i =ps.executeUpdate();
                //yeha sql pass garnu paardean as tyo alredy prepared ayera basesakeko hunxa
                if(i>0){
                    System.out.println("record inserted");
                }
                
                
            }else{
                System.out.println("Database connection Failure ..");
            }
        }catch(ClassNotFoundException | SQLException se){
            System.out.println(se);
        }finally{
            try{
                if(ps!=null){
                    ps.close();
                }
            }catch(SQLException se){
                System.out.println(se);
                
            }
        }
    }
    
    
    public static ArrayList<Student1> getAllStudents(){
        ArrayList<Student1> sl= new ArrayList();
        PreparedStatement ps=null;
        try{
            String sql="select * from student_table1";
            ps=connect(sql);
            if(ps!=null){
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                    sl.add(new Student1(rs.getInt("id"),
                           rs.getString("name"),
                           rs.getString("address"),
                           rs.getLong("phone")
                    ));
                }
                
            }else{
                System.out.println("connection problem");
            }
        }catch(ClassNotFoundException ex){
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE,null,ex);
        }catch(SQLException se){
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE,null,se);
        }finally{
    try{
        if(ps!=null){
            ps.close();
        }
    }catch(SQLException se){
        System.out.println(se);
    }
       
    }
        return sl;
    }
    
        public static  Student1 getStudentById(int  id){
        PreparedStatement ps=null;
        Student1 s= null;
        try{
           
            String sql="select * from student_table1 where id=?";
            ps=connect(sql);
            
                 ps.setInt(1, id);
                 ResultSet rs= ps.executeQuery();
                if(rs.next()){
                   
                    s=new Student1(rs.getInt("id"),
                           rs.getString("name"),
                           rs.getString("address"),
                           rs.getLong("phone")
                    );
                }else{
                System.out.println("connection problem");
                }
            
            
          
        }catch(ClassNotFoundException ex){
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE,null,ex);
        }catch(SQLException |NullPointerException se){
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE,null,se);
        }finally{
    try{
        if(ps!=null){
            ps.close();
        }
    }catch(SQLException se){
        System.out.println(se);
    }
       
    }
           return s;
}
         public static  void updateStudent(Student1 s){
        
        PreparedStatement ps=null;
        
        try{
           
            String sql="update student_table1 set name=?, address=?, phone=? where id=?";
            ps=connect(sql);
            if(ps!=null){
                 ps.setString(1, s.getName());
                 ps.setString(2, s.getAddress());
                 ps.setLong(3, s.getPhone());
                 ps.setInt(4, s.getId());
                 int i= ps.executeUpdate();
                if(i>0){
                    System.out.println("record update");
                }else{
                    System.out.println("connection plroblem..");
                }
                
            }else{
                System.out.println("connection problem");
            }
          
        }catch(ClassNotFoundException ex){
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE,null,ex);
        }catch(SQLException se){
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE,null,se);
        }finally{
    try{
        if(ps!=null){
            ps.close();
        }
    }catch(SQLException se){
        System.out.println(se);
    }
       
    }
          
}
         
         
      public static  void deleteStudent(int id){
        
        PreparedStatement ps=null;
        
        try{
           
            String sql="delete from student_table1 where id=?";
            ps=connect(sql);
            if(ps!=null){
                    ps.setInt(1, id);
                 int i= ps.executeUpdate();
                if(i>0){
                    System.out.println("record deleted");
                }else{
                    System.out.println("connection plroblem..");
                }
                
            }else{
                System.out.println("connection problem");
            }
          
        }catch(ClassNotFoundException ex){
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE,null,ex);
        }catch(SQLException se){
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE,null,se);
        }finally{
    try{
        if(ps!=null){
            ps.close();
        }
    }catch(SQLException se){
        System.out.println(se);
    }
       
    }
          
}
}
        


       