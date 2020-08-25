/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage;

import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class ImagesLoading implements ActionListener  
{  
    String location=null;
 JFrame fr = new JFrame("Image loading program Using awt");  
 Label Label1 = new Label("Choose your image");  
 Button Button1 = new Button("select");  
 Button Button2 = new Button("annuler"); 
 Button Button3 = new Button("OK");
 Image Image1;  
 imageLoad Canvas1;  
 
 FileDialog fd = new FileDialog(fr, "Open", FileDialog.LOAD); 
 
    JTextField inter=new JTextField(25);
    
 void initialize()  
 {  
      inter.setEditable(false);
        inter.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        inter.setForeground(new java.awt.Color(0, 102, 153));
        inter.setText("vous etes entrain de telecharger la premiere photo");
        
        
  fr.setSize(500, 500);  
  fr.setLocation(100, 100);  
  fr.setBackground(Color.lightGray);  
  fr.setLayout(new FlowLayout());  
  fr.add(Label1);  
  fr.add(Button1);  
  fr.add(Button2);
  fr.add(Button3);
  fr.add(inter);
  fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  Button1.addActionListener(this);  
  Button2.addActionListener(this); 
  Button3.addActionListener(this); 
  Canvas1 = new imageLoad(null);  
  Canvas1.setSize(300, 600);  
  fr.add(Canvas1);  
  fr.show();  
  
 
 }  
 void imageload()  
 {  
  fd.show();  
     System.out.println(fd.getDirectory()+fd.getFile());
  if (fd.getFile() == null)  
  {  
   Label1.setText("You have not select");  
  } else  
  {  
   String d = (fd.getDirectory() + fd.getFile());  
   Toolkit toolkit = Toolkit.getDefaultToolkit();  
   Image1 = toolkit.getImage(d);  
   
   Canvas1.setImage(Image1);  
   Canvas1.repaint();  
   location=fd.getDirectory()+fd.getFile();
  }  
 }  
 public void windowClosing(WindowEvent e)  
 {  
  System.exit(0);  
 }  
 public void windowActivated(WindowEvent e)  
 {  
 }  
 public void windowClosed(WindowEvent e)  
 {  
 }  
 public void windowDeactivated(WindowEvent e)  
 {  
 }  
 public void windowDeiconified(WindowEvent e)  
 {  
 }  
 public void windowIconified(WindowEvent e)  
 {  
 }  
 public void windowOpened(WindowEvent e)  
 {  
 }  
 public void actionPerformed(ActionEvent event)  
 {  
  Button b = (Button) event.getSource();  
  if (b == Button1)  
  {  
       
       
      if(Canvas1.nbrimg>=3 ){
      JOptionPane optionPane = new JOptionPane("vous avez deja depassez les 3 images necessaiires", JOptionPane.ERROR_MESSAGE);    
JDialog dialog = optionPane.createDialog("Failure");
dialog.setAlwaysOnTop(true);
dialog.setVisible(true);}
      
      System.out.println(Canvas1.nbrimg);
   imageload();   
   Canvas1.images.add(location);
   
 /*     JDBC j=new JDBC();
      j.save(location,fd.getName(),textile.r);*/
         Canvas1.nbrimg++;
      System.out.println(Canvas1.nbrimg);
       if(Canvas1.nbrimg==1){
        inter.setText("vous etes entrain de telecharger la deuxieme photo");}
        if(Canvas1.nbrimg==2){
        inter.setText("vous etes entrain de telecharger la troixieme photo");}
        if(Canvas1.nbrimg==3){
        inter.setText("c'est fait cliquer sur ok ");
        }
  } 
  
         if (b == Button2)  
  { 
      Canvas1.nbrimg--;
  System.out.println(Canvas1.nbrimg);
      fr.hide();
  }  
         if(b==Button3) {
             JDBC j=new JDBC();
             j.verifier(textile.r);
             
         fr.hide();}
  
 }  

  
} 

