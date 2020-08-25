/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage;

/**
 *
 * @author PC
 */
import java.awt.*;  
import java.awt.event.*;  
import java.awt.image.*;  
import javax.swing.*;  
import java.awt.Frame;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import jxl.Sheet;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
class imageLoad extends Canvas  
{  
 static ArrayList images =new ArrayList();
 int nbrimg=0;
 Image img;  
 public imageLoad(Image img)  
 {  
  this.img = img;  
 }  
 public void paint(Graphics g)  
 {  
  if (img != null)  
  {  
   g.drawImage(img,10, 30, this);  
  }  
 }  
 public void setImage(Image img)  
 {  
  this.img = img;  
 }  
 
 
 public static void function_inserer_excel( WritableSheet s, int t) throws SQLException, IOException{
     
    
                       // JLabel test1 = new JLabel(new ImageIcon(raw));
                        
     
     
     if(imageLoad.images.size()>=3){
         for(int i=0;i<imageLoad.images.size();i++){
             
             Blob a;
              try {
                ArrayList ab=JDBC.have_image(t);
                a = (Blob) ab.get(i);
                BufferedInputStream   is = new BufferedInputStream(a.getBinaryStream());
                Image raw = ImageIO.read(is);
                byte [] bytes = a.getBytes(1l, (int)a.length());
      WritableImage image = new WritableImage(0, 0, 2, 0,bytes);
             
         s.addImage(image);
                
            } catch (SQLException ex) {
                Logger.getLogger(textile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(textile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
     
     
     
      }
     }
     else{}
     }
 }  
