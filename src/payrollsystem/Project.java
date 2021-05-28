/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author SAURABH KUMAR
 */
public class Project extends JFrame implements ActionListener{
    
    Project(){
        super("Payroll Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000,1100);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon homePage = new ImageIcon(ClassLoader.getSystemResource("Images/payroll.jpg"));
        Image homePageScaled = homePage.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(homePageScaled);
        JLabel homePageLabel = new JLabel(scaledIcon);
        add(homePageLabel);
        
        // creating a horizontal menu bar 
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu master = new JMenu("Master");
        master.setForeground(Color.blue);
        
        //adding option 1 to master Menu
        JMenuItem item1 = new JMenuItem("New Employee");
        item1.setForeground(Color.blue);
        item1.setFont(new Font("monospaced",Font.PLAIN,12));
        item1.setMnemonic('N');
        item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        item1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/New.png")));
        master.add(item1);
        
        //adding option 2 to master Menu 
        JMenuItem item2 = new JMenuItem("Salary");
        item2.setForeground(Color.blue);
        item2.setFont(new Font("monospaced",Font.PLAIN,12));
        item2.setMnemonic('S');
        item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        item2.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/schedreport.png")));
        master.add(item2);
        
        
        //adding option 3 to master Menu
        JMenuItem item3 = new JMenuItem("List Employee");
        item3.setForeground(Color.blue);
        item3.setFont(new Font("monospaced",Font.PLAIN,12));
        item3.setMnemonic('L');
        item3.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/newinvoice.png")));
        item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        master.add(item3);
        
        ///adding master menu to menubar
        menuBar.add(master);
        
        //adding onclick actions to all master menu items
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        
        
        //creating edit and adding options below
        JMenu edit =new JMenu("Update");
        edit.setForeground(Color.RED);
        
        //adding option 1 to Edit Menu
        JMenuItem s1 = new JMenuItem("Update Salary");
        s1.setForeground(Color.blue);
        s1.setFont(new Font("monospaced",Font.PLAIN,12));
        s1.setMnemonic('U');
        s1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/EditOpen.png")));
        s1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        edit.add(s1);
        
        //adding option 2 to Edit Menu
        JMenuItem s2 = new JMenuItem("Update Employee");
        s2.setForeground(Color.blue);
        s2.setFont(new Font("monospaced",Font.PLAIN,12));
        s2.setMnemonic('p');
        s2.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/empreport.png")));
        s2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        edit.add(s2);
        
        //adding option 3 to Edit Menu
        JMenuItem s3 = new JMenuItem("Take Attendence");

        s3.setForeground(Color.blue);
        s3.setFont(new Font("monospaced",Font.PLAIN,12));
        s3.setMnemonic('T');
        s3.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/EXPENSE.PNG")));
        s3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        edit.add(s3);
    
        
        //adding onclick actions to all edit menu items
        s1.addActionListener(this);
        s2.addActionListener(this);
        s3.addActionListener(this);
        
        //adding edit menu to menubar
        menuBar.add(edit);
        
        // creating report menu 
        JMenu rep =new JMenu("Reports");
        rep.setForeground(Color.blue);
    
        //adding option 1 to report menu
        JMenuItem p1 = new JMenuItem("Generate PaySlip");
        p1.setForeground(Color.blue);
        p1.setFont(new Font("monospaced",Font.PLAIN,12));
        p1.setMnemonic('P');
        p1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/payments.png")));
        p1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        rep.add(p1);
        
        //adding option 2 to report menu
        JMenuItem p2 = new JMenuItem("List Attendence");
        p2.setForeground(Color.blue);
        p2.setFont(new Font("monospaced",Font.PLAIN,12));
        p2.setMnemonic('L');
        p2.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/empreport.png")));
        p2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        rep.add(p2);
        
        //adding onclick actions to all report menu items
        p1.addActionListener(this);
        p2.addActionListener(this);
        
        //adding report menu to menubar
        menuBar.add(rep);
        
        //creating utilities menu 
        JMenu util =new JMenu("Utilities");
        util.setForeground(Color.red);
        
        // adding option 1 to utilities menu
        JMenuItem u1 = new JMenuItem("Notepad");
        u1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/New.png")));
   
        u1.setForeground(Color.blue);
        u1.setFont(new Font("monospaced",Font.PLAIN,12));
        u1.setMnemonic('o');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        util.add(u1);
        
        // adding option 2 to utilities menu
        JMenuItem u2 = new JMenuItem("Calculator");
        u2.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/calc.png")));
        u2.setForeground(Color.blue);
        u2.setFont(new Font("monospaced",Font.PLAIN,12));
        u2.setMnemonic('C');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        util.add(u2);
        
        // adding option 3 to utilities menu
        JMenuItem u3 = new JMenuItem("Web Browser");
        u3.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/explorer.jpg")));
        u3.setForeground(Color.blue);
        u3.setFont(new Font("monospaced",Font.PLAIN,12));
        u3.setMnemonic('E');
        u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        util.add(u3);
        
        
        //adding onclick actions to all utility menu items
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        
        //adding utilities menu to menubar
        menuBar.add(util);
        
        JMenu ex = new JMenu("Exit");
        JMenuItem exit = new JMenuItem("Exit");
        exit.setForeground((Color.blue));
        exit.setFont(new Font("monospaced", Font.PLAIN, 14));
        exit.setMnemonic('X');
        exit.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/exit.PNG")));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        ex.add(exit);
        
        exit.addActionListener(this);
        
        menuBar.add(ex);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
//        System.out.println("hello");
        switch (msg) {
            case "New Employee":
                new NewEmployee().setVisible(true);
                break;
            
            case "Salary":
                new Salary();
                break;
                
            case "Update Employee":
                new UpdateEmployee();
                break;
               
            case "List Employee":
                new ListEmployee();
                break;
                
            case "Update Salary":
                new UpdateSalary();
                break;
            
            case "Generate PaySlip":
                new GeneratePaySlip();
                break;
                
            case "List Attendence":
                new ListAttendence();
                break;
               
            case "Take Attendence":
                new TakeAttendance();
                break;
            case "Exit":
                System.exit(0);
            case "Notepad":
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){ }
                break;
            case "Calculator":
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){ }
                break;
            case "Web Browser":
                try{
                    Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                }catch(Exception e){ }
                break;
            default:
                break;
        }
        
    }
    
    public static void main(String args[]){
        new Project().setVisible(true);
    }
}

