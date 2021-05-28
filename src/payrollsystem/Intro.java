/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author SAURABH KUMAR
 */
public class Intro {
    
    public static void main(String args[]){
        SFrame sf = new SFrame("Payroll Management System");
        sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sf.setVisible(true);
        int i=1,x=1;
        //sf.setLocation(650, 600);
        for(i =2; i<=600; i+=4,x+=1){
            //sf.setLocationRelativeTo(null);
            sf.setLocation((700-((i+x)/2) ),400-(i/2));
            
            sf.setSize(i+x,i);
            
            
            try{
                Thread.sleep(10);
            }catch(Exception e) { }
        }
    }
    
}

class SFrame extends JFrame implements Runnable{
    Thread threadForLoadingEffect;
    SFrame(String s){
        super(s);
        setLayout(new FlowLayout());
        
        //we get the location of the image
        String locationOfImage = "Images/Splash-Background.jpg";
        
        // we set the image as a imageicon
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource(locationOfImage));
        
        //Scaling the image to a desired height and width , returns scaled image
        Image image = background.getImage().getScaledInstance(730, 550,Image.SCALE_DEFAULT);
        
        //creating imageicon with the scaled image
        ImageIcon scaledBackground = new ImageIcon(image);
        
        JLabel backgroundLabel = new JLabel(scaledBackground);
        add(backgroundLabel);
        
        threadForLoadingEffect = new Thread(this);
        threadForLoadingEffect.start();
        
    }
    
    public void run(){
        try{
            Thread.sleep(7000);
            
            this.setVisible(false);
            Login f1 = new Login();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
