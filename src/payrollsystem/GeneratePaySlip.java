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
import java.util.Date;
import java.time.*;
import java.util.Calendar;
import java.util.spi.CalendarDataProvider;
/**
 *
 * @author SAURABH KUMAR
 */
public class GeneratePaySlip extends JFrame implements ActionListener ,  ItemListener{
    Choice empIdChoice;
    JTextArea paySlipText;
    JButton generatePay,print;
    JScrollPane scroll;
    
    GeneratePaySlip(){
        
        setSize(800,700);
        setLocationRelativeTo(null);
        empIdChoice = new Choice();
        try{
            Conn connect = new Conn();
            ResultSet rs = connect.s.executeQuery("select * from salary");
            empIdChoice.add("");
            while(rs.next()){
                empIdChoice.add(rs.getString("id"));
            }
        }catch(Exception e) { }
    
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        
        panel.add(new JLabel("Select Id"));
        panel.add(empIdChoice);
        add(panel,"North");
        // empIdChoice.addItemListener(this);
    
        paySlipText = new JTextArea(30,80);
        scroll = new JScrollPane(paySlipText);
     
        Font font = new Font("arial",Font.BOLD,20);
        paySlipText.setFont(font);
        
        add(scroll,"Center");
        JPanel south = new JPanel();
        generatePay = new JButton("Generate Pay Slip");
        
        
        print = new JButton("Print");
        print.setSize(100, 100);
        south.add(print);
        south.add(generatePay);
        
        add(south ,"South");
        generatePay.addActionListener(this);
        print.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(empIdChoice.getSelectedItem() == ""){
            JOptionPane.showMessageDialog(null,"Please Select Employee ID");
            return;
        }
        if( ae.getSource() == print){
            try{
                paySlipText.print();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Printing Error ,Please Try Again");
            }
        }
        else{
            try{
            Conn connect = new Conn();
            String query = "SELECT * FROM `employee` WHERE id='"+empIdChoice.getSelectedItem()+"'";
            ResultSet rs = connect.s.executeQuery(query);
            rs.next();
            String name = rs.getString("name");
            rs.close();
         
            rs = connect.s.executeQuery("SELECT * FROM `salary` WHERE id='"+empIdChoice.getSelectedItem()+"'");
            double gross=0;
            double net=0;
 
            Date date = new java.util.Date();
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int m = cal.get(Calendar.MONTH);
            Month mth =Month.of(m);
            String month = mth.toString();
            paySlipText.setText(" ----------------   PAY SLIP FOR THE MONTH OF "+month+" ,2019  ------------------------");
            paySlipText.append("\n");
  
            if(rs.next()){
          
                paySlipText.append("\n     Employee ID "+rs.getString("id"));
                paySlipText.append("\n     Employee Name "+name);
 
                paySlipText.append("\n----------------------------------------------------------------");
                paySlipText.append("\n");

                double hra = rs.getDouble("hra");
                paySlipText.append("\n                  HRA         : "+hra);
                double da  = rs.getDouble("da");
                paySlipText.append("\n                  DA          : "+da);
                double med  = rs.getDouble("med");
                paySlipText.append("\n                  MED         : "+med);
                double pf  = rs.getDouble("pf");
                paySlipText.append("\n                  PF          : "+pf);
                double basic = rs.getDouble("basic_salary");
                gross = hra+da+med+pf+basic;
                net = gross - pf;
                paySlipText.append("\n                  BASIC SALARY : "+basic);

                paySlipText.append("\n-------------------------------------------------------");
                paySlipText.append("\n");
 
                paySlipText.append("\n       GROSS SALARY :"+gross+"    \n       NET SALARY : "+net);
                paySlipText.append("\n       Tax   :   2.1% of gross "+ (gross*2.1/100));   
                paySlipText.append("\n -------------------------------------------------");
                paySlipText.append("\n");
                paySlipText.append("\n");    
                paySlipText.append("\n");
                paySlipText.append("   (  Signature  )      ");

            }
            }catch(Exception ee) {
                ee.printStackTrace();
            }
        }
        
    }
    
    public static void main(String[] args) {
        new GeneratePaySlip();
    }
}
