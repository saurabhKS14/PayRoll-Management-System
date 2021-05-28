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
/**
 *
 * @author SAURABH KUMAR
 */
public class Login extends JFrame implements ActionListener{
    JLabel usernameLabel,passwordLabel;
    JTextField usernameInput;
    JPasswordField passwordInput;
    JButton login,cancel;
    
    Login(){
        super("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        String loginPosterLocation = "Images/defaultpic.png";
        String loginImageLocation = "Images/login.png";
        String cancelImageLocation = "Images/Cancel.png";
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource(loginPosterLocation));
        JLabel loginPoster = new JLabel(image);
        
        
        login = new JButton("Login",new ImageIcon(ClassLoader.getSystemResource(loginImageLocation)));
        cancel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource(cancelImageLocation)));
        
        login.addActionListener(this);
        cancel.addActionListener(this);
        
        JPanel p1,p2,p3,p4;
        p1 = new JPanel();
        p2 = new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        
        usernameLabel = new JLabel("User Name   ");
        passwordLabel = new JLabel("Password     ");
        
        usernameInput = new JTextField(10);
        passwordInput = new JPasswordField(10);
        
        add(loginPoster,BorderLayout.WEST);
        p2.add(usernameLabel);
        
        p2.add(usernameInput);
        
        p2.add(passwordLabel);
        p2.add(passwordInput);
        
        p4.add(login);
        p4.add(cancel);
        
        add(p2,BorderLayout.CENTER);
        
        add(p4,BorderLayout.SOUTH);
        
        
        setSize(400,250);
        //setLocation(600,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()== login){
                Conn connect = new Conn();


                String username = usernameInput.getText();
                String password = passwordInput.getText();
                String query = "SELECT * FROM `login` WHERE username='"+username+"' AND password = '"+password+"'";

                ResultSet rs = connect.s.executeQuery(query);

                if(rs.next()){
                    new Project();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    
                }
            }
            else{
                System.exit(0);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
//    public static void main(String[] args){
//        new Login();
//    }
}
