/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author SAURABH KUMAR
 */
public class Salary extends JFrame implements ActionListener, ItemListener{
    JLabel empNo,hra,da,med,pf,basicSalary;
    JTextField hraTextField,daTextField,medTextField,pfTextField,basicTextField;
    JButton submit , cancel;
    Choice empIdChoice;
    
    Salary(){
        
        super("Set Salary");
       
        setLayout(new GridLayout(8,2,20,20));
        
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
        
        //employee id
        add(new JLabel("Select Empno"));
        add(empIdChoice);
        
        
        //hra section
        hra = new JLabel("HRA");
        hraTextField = new JTextField(15);
        add(hra);
        add(hraTextField);
        
        //da section
        da = new JLabel("DA");
        daTextField = new JTextField(15);
        add(da);
        add(daTextField);
        
        
        //med section
        med = new JLabel("MED");
        medTextField = new JTextField(15);
        add(med);
        add(medTextField); 
        
        
        //pf section
        pf = new JLabel("PF");
        pfTextField = new JTextField(15);
        add(pf);
        add(pfTextField);
        
        //basic salary
        basicSalary = new JLabel("Basic Salary");
        basicTextField = new JTextField(15);
        add(basicSalary);
        add(basicTextField);
        
        
        //submit button
        submit =new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
       //cancel button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        
        add(submit);
        add(cancel);
       
        //adding onclick listeners to buttons
        submit.addActionListener(this);
        cancel.addActionListener(this);
        
        //settigng size and making frame centered
        setSize(450,550);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
        }
        else{
            String hra = hraTextField.getText();
            String id = empIdChoice.getSelectedItem();
            String da = daTextField.getText();
            String med = medTextField.getText();
            String pf = pfTextField.getText();
            String basic = basicTextField.getText();
            String qry = "INSERT INTO `salary` VALUES('"+ id +"','"+hra+"','"+da+"','"+med+"','"+pf+"','"+basic+"')";

            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Salary updated");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new Salary();
    }
}
