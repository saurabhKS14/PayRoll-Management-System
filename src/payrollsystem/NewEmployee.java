/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import javax.swing.border.EmptyBorder;


/**
 *
 * @author SAURABH KUMAR
 */
public class NewEmployee extends JFrame implements ActionListener{
    
    JLabel name,gender,state,email,phone,address,city;
    JButton submit,cancel;
    JTextField nameTextField,stateTextField,cityTextField,emailTextField,phoneTextField,addressTextField;
    Choice genderChoice;
    
    
    
    public NewEmployee() {
    
        super("New Employee");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,650);
        //setLocation(600, 200);
        getContentPane().setBackground(Color.WHITE);
        //making jframe in center
        setLocationRelativeTo(null);
//        setVisible(true);

     
        //creating a panel for new employee form
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        //                             row   col   hgap   vgap
        panel.setLayout(new GridLayout(8  ,  2  ,  10  ,  40));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        //adding the labels and textFields
        
        
        //adding name 
        name = new JLabel("Name");
        nameTextField = new JTextField(15);
        panel.add(name);
        panel.add(nameTextField);
        
        //adding choice for gender
        gender = new JLabel("Gender");
        
        genderChoice = new Choice();
        genderChoice.add("Male");
        genderChoice.add("Female");
        
        panel.add(gender);
        panel.add(genderChoice);
        
        //adding address 
        address = new JLabel("Address");
        addressTextField = new JTextField(15);
        
        panel.add(address);
        panel.add(addressTextField);
        
        
        //adding State
        state = new JLabel("State");
        stateTextField = new JTextField(15);
        panel.add(state);
        panel.add(stateTextField);
        
        
        //adding city
        city = new JLabel("City");
        cityTextField = new JTextField(15);
        panel.add(city);
        panel.add(cityTextField);
        
        //adding email
        email = new JLabel("Email");
        emailTextField = new JTextField(15);
        panel.add(email);
        panel.add(emailTextField);
        
        //adding phone
        phone = new JLabel("Phone");
        
        phoneTextField= new JTextField(15);
  
        panel.add(phone);
        panel.add(phoneTextField);
        
        submit =new JButton("Submit");
        cancel = new JButton("Cancel");
        panel.add(submit);
        panel.add(cancel);
       
        setLayout(new BorderLayout());
        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("Images/new_employee.png"))),"West");
        add(panel,"Center");
        
        //adding on click functionality to cancel button
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        
        
        //adding on click functionality to cancel button
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand() == "Cancel"){
            this.setVisible(false);
        }else{
            
            String name = nameTextField.getText();
            String gender = genderChoice.getSelectedItem();
            String address = addressTextField.getText();
            String state = stateTextField.getText();
            String city = cityTextField.getText();
            String email = emailTextField.getText();
            String phone = phoneTextField.getText();
            String qry = "INSERT INTO `employee` VALUES(null,'"+name+"','"+gender+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phone+"')";

            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Employee Created");
                this.setVisible(false);  
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error , Please Try Again");
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String args[]){
        new NewEmployee().setVisible(true);
      }
    
    
    
    
}
