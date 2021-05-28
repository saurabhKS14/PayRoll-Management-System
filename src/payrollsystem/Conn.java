/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author SAURABH KUMAR
 */
public class Conn {
    public Connection c;
    public Statement s;
 
    public Conn(){
        try{
            
            c=DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
            System.out.println("connected");
//            String query = "SELECT * FROM `login`";
            s = c.createStatement();
//            ResultSet rs = s.executeQuery(query);
//            
//            while(rs.next()){
//                String log = rs.getString("username");
//                String pass = rs.getString("password");
//                System.out.println(log+" "+pass);
//            }
            
        
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Database could not be connected");
        }
    }
    
//    public static void main(String args[]){
//        conn();
//    }
}
