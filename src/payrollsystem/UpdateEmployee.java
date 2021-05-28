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
public class UpdateEmployee extends JFrame implements ActionListener, ItemListener{
    JLabel name,gender,state,email,phone,address,city,empNo;
    JTextField nameTextField,stateTextField,cityTextField,emailTextField,phoneTextField,addressTextField;
    Choice genderChoice,empIdChoice;
    JButton update,delete;
    
    UpdateEmployee(){
        super("Update Employee");
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        empIdChoice = new Choice();
        empIdChoice.setBounds(160,40,200,20);
        
        try{
            Conn connect = new Conn();
            String query = "SELECT * FROM `employee`";
            ResultSet rs = connect.s.executeQuery(query);
            empIdChoice.add("");
            while(rs.next()){
                empIdChoice.add(rs.getString("id"));
            }            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        //adding employee id choice and label in the frame
        empNo = new JLabel("Select EmpNo.");
        empNo.setBounds(40, 40, 100, 20);
        add(empNo);
        add(empIdChoice);
        
        
        //adding gender choice in the frame
        name = new JLabel("Name : ");
        nameTextField = new JTextField(15);
        
        name.setBounds(40,80,100,20);
        nameTextField.setBounds(160,80,200,20);
        add(name);
        add(nameTextField);
       
        genderChoice = new Choice();
        genderChoice.add("Male");
        genderChoice.add("Female");
       
        gender = new JLabel("Gender : ");
        
        gender.setBounds(40,120,100,20);
        genderChoice.setBounds(160,120,200,20);
        add(gender);
        add(genderChoice);
        
        address = new JLabel("Address : ");
        addressTextField = new JTextField(15);
        
        address.setBounds(40,160,100,20);
        addressTextField.setBounds(160,160,200,20);
        add(address);
        add(addressTextField);
        
        state = new JLabel("State : ");
        stateTextField = new JTextField(15);
        
        state.setBounds(40,200,100,20);
        stateTextField.setBounds(160,200,200,20);
        add(state);
        add(stateTextField); 
        
        city = new JLabel("City : ");
        cityTextField = new JTextField(15);
        
        city.setBounds(40,240,100,20);
        cityTextField.setBounds(160,240,200,20);
        add(city);
        add(cityTextField);
        
        email = new JLabel("Email : ");
        emailTextField = new JTextField(15);
        
        email.setBounds(40,280,100,20);
        emailTextField.setBounds(160,280,200,20);
        add(email);
        add(emailTextField);
        
        phone = new JLabel("Phone : ");
        phoneTextField= new JTextField(15);
        
        phone.setBounds(40,320,100,20);
        phoneTextField.setBounds(160,320,200,20);
        add(phone);
        add(phoneTextField);
        
        update =new JButton("Update");
        delete = new JButton("Delete");
        
        update.setBounds(40,400,150,30);
        delete.setBounds(200,400,150,30);
        add(update);
        add(delete);
        
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        
        update.addActionListener(this);
        delete.addActionListener(this);
        
        empIdChoice.addItemListener(this);
        
        setVisible(true);
        setSize(400,550);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String id = empIdChoice.getSelectedItem();
        if(id == ""){
            JOptionPane.showMessageDialog(null,"Please Select Employee ID");
            return;
        }
        if(ae.getSource()==update){
            
            String name = nameTextField.getText();
            String gender = genderChoice.getSelectedItem();
            String address = addressTextField.getText();
            String state = stateTextField.getText();
            String city = cityTextField.getText();
            String email = emailTextField.getText();
            String phone = phoneTextField.getText();
                String query = "UPDATE `employee` SET name='"+name+"',gender='"+gender+"',address='"+address+"',state='"+state+"',city='"+city+"',email='"+email+"',phone='"+phone+"' WHERE id='"+id+"'";
       
            try{
                Conn connect = new Conn();
                connect.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Updated");
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        
        if(ae.getSource()==delete){
            try{
                
                String query = "DELETE FROM `employee` WHERE id='"+id+"'";
                Conn connect = new Conn();
                connect.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Deleted");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }
    
    public void itemStateChanged(ItemEvent ie){
        try{
            if(empIdChoice.getSelectedItem() == ""){
                nameTextField.setText("");
                addressTextField.setText("");
                stateTextField.setText("");
                cityTextField.setText("");
                emailTextField.setText("");
                phoneTextField.setText("");
                return;
            }
            Conn c1 = new Conn();
            String query = "SELECT * FROM `employee` WHERE id='"+empIdChoice.getSelectedItem()+"'";
            //System.out.println(query);
            ResultSet rs = c1.s.executeQuery(query);
            if(rs.next()){
                nameTextField.setText(rs.getString("name"));
                addressTextField.setText(rs.getString("address"));
                stateTextField.setText(rs.getString("state"));
                cityTextField.setText(rs.getString("city"));
                emailTextField.setText(rs.getString("email"));
                phoneTextField.setText(rs.getString("phone"));
            }
        }catch(Exception e){
           e.printStackTrace();
        }
    
    }
    
    public static void main(String[] args) {
        new UpdateEmployee();
    }
}
