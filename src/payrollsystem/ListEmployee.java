/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author SAURABH KUMAR
 */
public class ListEmployee extends JFrame implements ActionListener{
    
    JTable employeeTable;
    JButton printButton;
    String columnNames[]={"Emp id","Name","Gender","Address","State","City","Email id","Phone"};
    String employeeList[][]=new String[20][8];  
    int i=0,j=0;
    
    
    public ListEmployee(){
    
        super("View Employees");
        
        setSize(1000,400);
        
        setLocationRelativeTo(null);
        
        
        
        try{
            String q="SELECT * FROM `employee`";
            Conn connect=new Conn();
            ResultSet rs=connect.s.executeQuery(q);
            while(rs.next()){
                // i = 0 j = 0
                employeeList[i][j++]=rs.getString("id");
                employeeList[i][j++]=rs.getString("name");
                employeeList[i][j++]=rs.getString("gender");
                employeeList[i][j++]=rs.getString("address");
                employeeList[i][j++]=rs.getString("state");
                employeeList[i][j++]=rs.getString("city");
                employeeList[i][j++]=rs.getString("email");
                employeeList[i][j++]=rs.getString("phone");
                i++;
                j=0;
            }
            employeeTable=new JTable(employeeList,columnNames); 

        }
        catch(Exception e){}
        
        printButton=new JButton("Print");
        add(printButton,"South");
        JScrollPane scroll=new JScrollPane(employeeTable);
        add(scroll);
        
        printButton.addActionListener(this);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
           employeeTable.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args) {
        new ListEmployee();
    }
    
    
    
}
