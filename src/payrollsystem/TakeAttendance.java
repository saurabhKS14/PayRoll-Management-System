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
import java.util.*;
/**
 *
 * @author SAURABH KUMAR
 */
public class TakeAttendance extends JFrame implements ActionListener,ItemListener{
    JLabel empId,firstHalf,secondHalf;
    JButton submit,cancel;
    Choice firstChoice, secondChoice,empIdChoice;

    TakeAttendance(){
        super("Take Attendence");
        setLayout(new GridLayout(4,2,50,50));
        
        empIdChoice = new Choice();
        
        try{
            Conn connect = new Conn();

            String query = "SELECT * FROM `employee`";

            ResultSet rs = connect.s.executeQuery(query);
            
            while(rs.next()){
                empIdChoice.add(rs.getString("id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //adding empid label and choice to the frame 
        empId = new JLabel("Select Emp No :");
        add(empId);
        add(empIdChoice);
        
//        //adding action listener to the empid choice
//        empIdChoice.addItemListener(this);
        
        // adding first half label and choice to the frame
        firstChoice = new Choice();
        firstChoice.add("Present");
        firstChoice.add("Absent");
        
        firstHalf = new JLabel("First Half :");
        add(firstHalf);
        add(firstChoice);
        
        
        //adding second half label and choice the frame
        secondChoice = new Choice();
        secondChoice.add("Present");
        secondChoice.add("Absent");
        
        secondHalf = new JLabel("Second Half :");
        add(secondHalf);
        add(secondChoice);
        
        
        
        //adding submit and cancel Button
        
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        submit.setBackground(Color.WHITE);
        cancel.setBackground(Color.WHITE);
        
        submit.setForeground(Color.BLACK);
        cancel.setForeground(Color.BLACK);
        add(submit);
        add(cancel);
        
        //adding onclick action to the buttons
        submit.addActionListener(this);
        cancel.addActionListener(this);
        setSize(400,450);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit){
            String id = empIdChoice.getSelectedItem();
            String first = firstChoice.getSelectedItem();
            String second = secondChoice.getSelectedItem();
            String date =  new java.util.Date().toString();
            String query = "INSERT INTO `attendence` VALUES('"+id+"','"+date+"','"+first+"', '"+second+"')";
            
            try{
                Conn connect = new Conn();
                connect.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Attendace Taken");
                setVisible(false);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error Occured ,Try Again");
            }
        }
        else{
            setVisible(false);
        }
        
        
    }
    
   
//    public static void main(String[] args) {
//        new TakeAttendance();
//    }
    
    
}
