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
public class UpdateSalary extends JFrame implements ActionListener, ItemListener{
    JLabel empNo,hra,da,med,pf,basicSalary;
    JTextField hraTextField,daTextField,medTextField,pfTextField,basicTextField;
    JButton update , delete;
    Choice empIdChoice;

    UpdateSalary() {
        super("Update Salary");
       
        setLayout(new GridLayout(8,2,20,20));
        
        empIdChoice = new Choice();
       
        try{
            Conn connect = new Conn();
            String query = "SELECT * FROM `salary`";
            ResultSet rs = connect.s.executeQuery(query);
            empIdChoice.add("");
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
        
        
        //update button
        update =new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
       //delete button
        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        
        add(update);
        add(delete);
       
        //adding onclick listeners to buttons
        update.addActionListener(this);
        delete.addActionListener(this);
        
        //adding action Listener to empid choice
        
        empIdChoice.addItemListener(this);
        
        //settigng size and making frame centered
        setSize(450,550);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(empIdChoice.getSelectedItem() == ""){
            JOptionPane.showMessageDialog(null,"Please Select Employee ID");
            return;
        }
        if(ae.getSource() == delete){
            String query ="DELETE FROM `salary` WHERE id='"+empIdChoice.getSelectedItem()+"'";
            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(query);
                c1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Salary Deleted");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        else{
            Double hra = Double.parseDouble(hraTextField.getText());
            Double id = Double.parseDouble(empIdChoice.getSelectedItem());
            Double da = Double.parseDouble(daTextField.getText());
            Double med = Double.parseDouble(medTextField.getText());
            Double pf = Double.parseDouble(pfTextField.getText());
            Double basic = Double.parseDouble(basicTextField.getText());
            String query = "UPDATE `salary` SET hra='"+hra+"',da='"+da+"',med='"+med+"',pf='"+pf+"',basic_salary='"+basic+"' where id='"+empIdChoice.getSelectedItem()+"'";

            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Salary updated");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        
        
    }
    public void itemStateChanged(ItemEvent ie){
        try{
            if(empIdChoice.getSelectedItem() == ""){
                hraTextField.setText("");
                daTextField.setText("");
                medTextField.setText("");
                pfTextField.setText("");
                basicTextField.setText("");
                return;
            }
            Conn c1 = new Conn();
            String query = "SELECT * FROM `salary` WHERE id='"+empIdChoice.getSelectedItem()+"'";
            //System.out.println(query);
            ResultSet rs = c1.s.executeQuery(query);
            if(rs.next()){
                hraTextField.setText(rs.getString("hra"));
                daTextField.setText(rs.getString("da"));
                medTextField.setText(rs.getString("med"));
                pfTextField.setText(rs.getString("pf"));
                basicTextField.setText(rs.getString("basic_salary"));
                
            }
        }catch(Exception e){
           e.printStackTrace();
        }
    
    }
    
    
    
    public static void main(String[] args) {
        new UpdateSalary();
    }
    
    
}
