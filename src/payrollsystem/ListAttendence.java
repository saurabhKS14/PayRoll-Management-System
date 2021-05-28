/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author SAURABH KUMAR
 */
public class ListAttendence extends JFrame implements ActionListener {
    JTable attendenceTable;
    JLabel empIdLabel;
    String [] colHead = {"ID" , "Date & Time" , "First Half" , "Second Half"};
    String [][] attendenceData = new String[15][4];
    Choice empIdChoice;
    JButton print;
    JScrollPane scroll ;
    int i = 0, j = 0;

    ListAttendence(){
        super("Employee Attendence");
        
        setSize(800,300);
        setLocationRelativeTo(null);
        
        empIdChoice = new Choice();
        try{
            String query = "SELECT * FROM `attendence`";
            Conn connect = new Conn();
            ResultSet rs = connect.s.executeQuery(query);
//            empIdChoice.add("");
            while(rs.next()){
//                empIdChoice.add(rs.getString("id"));
                attendenceData[i][j++]= rs.getString("id");
                attendenceData[i][j++]= rs.getString("date_tm");
                attendenceData[i][j++]= rs.getString("f_half");
                attendenceData[i][j]= rs.getString("s_half");
                i++;
                j=0;
            }
            
        }
        catch(Exception e){
            
        }
        
        //adding data to the table
        attendenceTable = new JTable(attendenceData , colHead);
        scroll = new JScrollPane(attendenceTable);
        print = new JButton("Print");
        add(print,"South");
        add(scroll);
        
        print.addActionListener(this);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            attendenceTable.print();
        }
        catch(Exception e){
            
        }
    }
    
//    public static void main(String[] args) {
//        new ListAttendence();
//    }
    
//    public void itemStateChanged(ItemEvent ie){
//        String id = empIdChoice.getSelectedItem();
//        
//        if(id == ""){
//            return;
//        }
//        try{
//            int i=0,j=0;
//            String query = "SELECT * FROM `attendence` WHERE id='"+id+"";
//            Conn connect = new Conn();
//            ResultSet rs = connect.s.executeQuery(query);
//            empIdChoice.add("");
//            while(rs.next()){
////                empIdChoice.add(rs.getString("id"));
//                attendenceData[i][j++]= rs.getString("id");
//                attendenceData[i][j++]= rs.getString("date_tm");
//                attendenceData[i][j++]= rs.getString("f_half");
//                attendenceData[i][j]= rs.getString("s_half");
//                i++;
//                j=0;
//            }
//            attendenceTable = new JTable(attendenceData , colHead);
//            
//        }
//        catch(Exception e){
//            
//        }
//        
//        scroll = new JScrollPane(attendenceTable);
//        
//    }
    
    
    
}
