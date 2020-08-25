/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

/**
 *
 * @author PC
 */
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import static javax.swing.text.html.HTML.Tag.SELECT;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import static stage.JDBC.DB_URL;
import static stage.aprespage_1.rap;
import static stage.vis_ima.path;
import static sun.security.krb5.Confounder.bytes;

public class JDBC {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/CTTH_R";
    static boolean dejaim= false;

   public JDBC(){}
   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   public static  ArrayList types = new ArrayList();
   public static  ArrayList rapports_id = new ArrayList();
    public static  ArrayList respo = new ArrayList();
    public static  ArrayList cat = new ArrayList();
    public static ArrayList  images_rapport=new ArrayList();
     static String path="";
  public static File file ;
    public static  int  nbr_image_rapport=0;
    public static void type() {
     //  ArrayList types = new ArrayList();
   Connection conn = null;
   Statement stmt = null;
 
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT id, nom FROM type_rapport";
      ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         String nom=rs.getString("nom");
         
         types.add(nom);
                 

         
         //Display values
         System.out.print("ID: " + id);
         System.out.print(",nom: " + nom);
        
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
      
   }//end try
   System.out.println("Goodbye!");
}//end main
public static void respo(){
    Connection conn = null;
   Statement stmt = null;
 
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT * FROM `responsables`";
        //STEP 5: Extract data from result set
        try (ResultSet rss = stmt.executeQuery(sql)) {
            //STEP 5: Extract data from result set
            /*     /*/        while(rss.next()){
                //Retrieve by column name
                int id  = rss.getInt("id");
                String nom=rss.getString("nom");
                
                
                
                
                
                //Display values
                System.out.print("ID: " + id);
                System.out.print(",nom: " + nom);
                respo.add(nom);
                
            } }
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}
public static void cat(){
    Connection conn = null;
   Statement stmt = null;
 
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT * FROM `categorie`";
        //STEP 5: Extract data from result set
        try (ResultSet rss = stmt.executeQuery(sql)) {
            //STEP 5: Extract data from result set
            /*     /*/        while(rss.next()){
                //Retrieve by column name
                int id  = rss.getInt("id");
                String nom=rss.getString("nom");
                
                
                
                
                
                //Display values
                System.out.print("ID: " + id);
                System.out.print(",nom: " + nom);
                cat.add(nom);
                
            } }
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}
public static void rapports_id() {
     //  ArrayList types = new ArrayList();
   Connection conn = null;
   Statement stmt = null;
 
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT * FROM `rapport`";
      ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("bash");
       
         
         rapports_id.add(id);
                 

         
         //Display values
         System.out.print("ID: " + id);
        
        
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
      
   }//end try
   System.out.println("Goodbye!");
}

        public static void delete(int bash) throws ClassNotFoundException, SQLException{
              Connection conn = null;
   Statement stmt = null;
 
  
              Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      stmt = conn.createStatement();
     
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      
      String sql = "DELETE FROM rapport " +
                   "WHERE bash = "+bash;
      String sql2 = "DELETE FROM images " +
                   "WHERE rapport_id = "+bash;
      stmt.executeUpdate(sql);
      stmt.executeUpdate(sql2);
      conn.close();
      
 }

        public static  void  delete(String path){
            try{

            File file = new File(path);
 System.err.println(file.getName() + path);
            file.delete();

        }catch(Exception e){

            e.printStackTrace();

        }
        }
        /*
public static  void insertrapport() throws SQLException, FileNotFoundException, ClassNotFoundException{
 //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      //Récupérer la connexion
      Connection conn = null;
   Statement stmt = null;
    Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");

    
     
      //Insertion de valeurs
      String query = "INSERT INTO rapport(ID, rapport) VALUES (?, ?)";
      PreparedStatement pr = conn.prepareStatement(query);
      pr.setInt(1, 101);
      FileReader reader = new FileReader("C:\\Users\\PC\\Desktop\\stage\\fichier.txt");
      pr.setCharacterStream(2, reader);
      pr.execute();
      System.out.println("Données insérées...");}
*/
//save image
public static void save(String location, String name,int r){
    Connection conn = null;
   Statement stmt = null;
 try { 
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
     
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
            Statement st = conn.createStatement(); 
            
           byte[] b= JDBC.extractBytes(location);
           String bb=b.toString();
           // st.executeUpdate("INSERT INTO `images` (`name`,`byte`,`image`,`rapport_id`) VALUES ( '"+name+"','"+bb+"',"+r+")"); 
            String query = "INSERT INTO `images` (`name`,`byte`,`image`,`rapport_id`) VALUES ( ?,?,?,?)";
      PreparedStatement pstmt = conn.prepareStatement(query);
pstmt.setString(1, name);
pstmt.setString(2, bb);
pstmt.setInt(4, r);
      FileInputStream fin = new FileInputStream(location);
      pstmt.setBinaryStream(3, fin);
       pstmt.execute();
            conn.close(); 
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
  }
public static boolean rapport_exist(int r){
    Boolean exist=false; 
    Connection conn = null;
   Statement stmt = null;
   try{
     Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
                 stmt = conn.createStatement();
      String query = "select count(*) from `rapport` Where bash="+r;
      //Executing the query
      
      ResultSet rs = stmt.executeQuery(query);
      
      //Retrieving the result
      rs.next();
      int count = rs.getInt(1);
      System.out.println("Number of records in the cricketers_data table: "+count);
      if(count>0){
          exist=true;
          
          
      }
       conn.close(); 
       return (exist);
        } catch (ClassNotFoundException | SQLException | HeadlessException | SecurityException e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
 imageLoad.images.clear();
    return exist;
}
//save rapport 
public static void save_rapport(int r){
    Connection conn = null;
   Statement stmt = null;
 try { 
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
     
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
            Statement st = conn.createStatement(); 
        String location="C:\\Users\\PC\\Desktop\\stage\\Stage\\Rapport_textile\\Rapport_textile"+r+".xls";
       System.out.println(location);
           
         
            String query = "INSERT INTO `rapport` ( `rapport`,`bash`)  VALUES ( ?,?)";
     
      PreparedStatement pstmt = conn.prepareStatement(query);


      FileInputStream fin = new FileInputStream(location);
      
       System.out.println(fin);


      pstmt.setInt(2, r);
      pstmt.setBinaryStream(1, fin);
     
       pstmt.execute();
            conn.close(); 
           
        } catch (Exception e) { 
            System.err.println("rapport not saved  "); 
            System.err.println(e.getMessage()); 
        } 
  }
public static  byte[] extractBytes (String ImageName) throws IOException {
 // open image
 File imgPath = new File(ImageName);
 BufferedImage bufferedImage = ImageIO.read(imgPath);

 // get DataBufferBytes from Raster
 WritableRaster raster = bufferedImage .getRaster();
 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

 return ( data.getData() );
}
public static  void annuler_rapport ( int r ) throws SQLException{
     Connection conn = null;
   Statement stmt = null;
 String sql = "delete from images  where `rapport_id`="+r;

    
       conn = DriverManager.getConnection(DB_URL, USER, PASS);
       stmt = conn.createStatement(); 
      
      stmt.executeUpdate(sql);
      System.out.println("Record deleted successfully");
    
}

public static  void savetype(String type ) {

 Connection conn = null;
   Statement stmt = null;
 try { 
     
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
            Statement st = conn.createStatement(); 
            
        
            st.executeUpdate("INSERT INTO `type_rapport` (`nom`) VALUES ('"+type+"')"); 
            

            conn.close(); 
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
 
}


public static boolean verifier(int r){
    Connection conn = null;
   Statement stmt = null;
   try{
     Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
                 stmt = conn.createStatement();
      String query = "select count(*) from images where rapport_id="+r;
      //Executing the query
      
      ResultSet rs = stmt.executeQuery(query);
      
      //Retrieving the result
      rs.next();
      int count = rs.getInt(1);
      System.out.println("Number of records in the cricketers_data table: "+count);
      if(count>=3){
          dejaim=true;
          
          
      }
       conn.close(); 
       return (dejaim);
        } catch (ClassNotFoundException | SQLException | HeadlessException | SecurityException e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        } 
 
    return dejaim;
}


public static ArrayList have_image(int r) throws SQLException, ClassNotFoundException{
    Connection conn = null;
   Statement stmt = null;
   
     Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
                 stmt = conn.createStatement();
      String query = "SELECT * FROM `images` WHERE rapport_id="+r;
      //Executing the query
      
      ResultSet rs = stmt.executeQuery(query);
      
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        Blob blob = rs.getBlob("image");
         
         nbr_image_rapport++;
        //  byte[] bb = b.getBytes();
         images_rapport.add(blob);
      
      
      //Retrieving the result
      
      
      
       
        }  conn.close(); 
 
    return images_rapport;
}
   @SuppressWarnings("empty-statement")
   public static void  read_excel(Blob blob,int r, String pat ) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{
  Connection conn = null;
   
   
     Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
          
     
 
    // Préparer la requête SQL
   
      String sql = "SELECT * FROM `rapport` WHERE bash="+r;;
 
    // Préparer la requête SQL
    PreparedStatement stmt = conn.prepareStatement(sql);
       System.err.println(pat);
     path=  pat+"//"+r+".xls";;
   
    
    // Exécuter la requête
    ResultSet res = stmt.executeQuery();
    file = new File(pat);
    
    while (res.next())
    {
  System.err.println("in boucle "); 
      String nom= res.getString(1);
      //convertion byte 
  byte [] bytes = blob.getBytes(1l, (int)blob.length());
     
    OutputStream os = new FileOutputStream(path); 
  
            // Starts writing the bytes in it 
            os.write(bytes); 
            System.err.println("Successfully"
                               + " byte inserted"); 
 
    }
    path="";//vis_ima.path="";
    conn.close();}
//end JDBCExample
public static Blob  selectblob (int r) throws ClassNotFoundException, SQLException{
   Connection conn = null;
   Statement stmt = null;
   
     Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
                 stmt = conn.createStatement();
      String query = "SELECT * FROM `rapport` WHERE bash="+r;
      //Executing the query
      
      ResultSet rs = stmt.executeQuery(query);
      
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        Blob blob = rs.getBlob("rapport");
          System.err.println(blob);
       
      
      
      //Retrieving the result
      
      
      
       
         conn.close(); 
         return blob;
      }
    return null;
      }
public static Blob  selectblob_pdf (int r) throws ClassNotFoundException, SQLException{
 
    Connection conn = null;
   Statement stmt = null;
   
     Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
                 stmt = conn.createStatement();
      String query = "SELECT * FROM `pdf` WHERE bash="+r;
      //Executing the query
      
      ResultSet rs = stmt.executeQuery(query);
      
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
        Blob blob = rs.getBlob("pdf");
          System.err.println(blob);
       
      
      
      //Retrieving the result
      
      
      
       
         conn.close(); 
         return blob;
      }
    return null;
      }
public static void button(JButton b){
 try {
                    System.err.println(JDBC.selectblob(aprespage_1.rap));
                    JFileChooser chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("choisir un dossier");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    //  
   
    if (chooser.showOpenDialog(b) == JFileChooser.APPROVE_OPTION) { 
          path=chooser.getSelectedFile()+"\\";
          System.err.println( "vispath " +path);
       
      }
    else {
      System.out.println("No Selection ");
      }
                    JDBC.pdf_read(JDBC.selectblob_pdf(aprespage_1.rap),aprespage_1.rap, path);
                    System.err.println("fichier can be upload");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(vis_ima.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(vis_ima.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(vis_ima.class.getName()).log(Level.SEVERE, null, ex);
                }
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            
}
public static void converter(int r, String pat) throws ClassNotFoundException, SQLException{
     
    
     Workbook workbook = new Workbook();
         // a modfier 
     
        workbook.loadFromFile(pat+r+".xls");
System.err.println(pat+r+".xls");
        //Fit to page
        workbook.getConverterSetting().setSheetFitToPage(true);

        //Save as PDF document
        System.err.println(pat+r+".xls");
        workbook.saveToFile(pat+r+".pdf",FileFormat.PDF);
        
        System.err.println(pat+r+".pdf");
        
      
         
        
        
        
}
public static void pdf_to_blob_insert(int r){
 Connection conn = null;
   Statement stmt = null;
 try { 
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
     
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
            Statement st = conn.createStatement(); 
        String location="C:\\Users\\PC\\Desktop\\stage\\Stage\\Rapport_textile\\Rapport_textile"+r+".pdf";
       System.out.println(location);
           
         
            String query = "INSERT INTO `pdf` (`pdf` ,`bash`) VALUES ( ?,?)";
     
      PreparedStatement pstmt = conn.prepareStatement(query);


      FileInputStream fin = new FileInputStream(location);
      
       System.out.println(fin);


      pstmt.setInt(2,r );
      
      pstmt.setBinaryStream(1, fin);
     
       pstmt.execute();
            conn.close(); 
fin.close();
        } catch (Exception e) { 
            System.err.println("rapport not saved  "); 
            System.err.println(e.getMessage()); 
        }        }
public static void pdf_read (Blob blob,int r, String pat ) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{
  Connection conn = null;
   
   
     Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
          
     
 
    // Préparer la requête SQL
   
      String sql = "SELECT * FROM `pdf` WHERE bash="+r;;
 
    // Préparer la requête SQL
    PreparedStatement stmt = conn.prepareStatement(sql);
       System.err.println(pat);
     path=  pat+"//"+r+".pdf";;
   
    
    // Exécuter la requête
    ResultSet res = stmt.executeQuery();
    file = new File(pat);
    
    while (res.next())
    {
  System.err.println("in boucle "); 
      String nom= res.getString(1);
      //convertion byte 
  byte [] bytes = blob.getBytes(1l, (int)blob.length());
     
    OutputStream os = new FileOutputStream(path); 
  
            // Starts writing the bytes in it 
            os.write(bytes); 
            
            System.err.println("Successfully"
                               + " byte inserted"); 
 /*           PdfReader reader = new PdfReader(file);
       Document doc = new Document(PageSize.LEGAL, 0, 0, 0, 0);
       PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(pdfOut));
       doc.open();
       PdfContentByte cb = writer.getDirectContent();
       for(int i=1; i<=reader.getNumberOfPages(); i++){
           doc.newPage();
           PdfImportedPage page = writer.getImportedPage(reader, i);
           cb.addTemplate(page, scale, 0, 0, scale, x, y);
       }
       doc.close();
 */
    }
    path="";//vis_ima.path="";
    conn.close();}
    static int i=0;
public static void insert_to( WritableSheet s,String path,Textilee t1) throws IOException, BiffException {
 double CELL_DEFAULT_HEIGHT = 30;
 double CELL_DEFAULT_WIDTH = 90;

File imageFile = new File(path);
BufferedImage input = ImageIO.read(imageFile);
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(input, "PNG", baos);
s.addImage(new WritableImage(i,19,input.getWidth() / CELL_DEFAULT_WIDTH,
    input.getHeight() / CELL_DEFAULT_HEIGHT,baos.toByteArray()));
i=i+4;
if(i==8){
i=0;}


}
static int nombre_dans=0;
public static  ArrayList <String>   read_image(String pat,WritableSheet s,Textilee t1)
 throws ClassNotFoundException, SQLException, FileNotFoundException, IOException, BiffException{
      Connection conn = null;
   
   
     Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       
          
     ArrayList <String> a=new ArrayList<String >();
 
    // Préparer la requête SQL
   
      String sql = "SELECT * FROM `images` WHERE rapport_id="+t1.Rapport;
 
    // Préparer la requête SQL
    PreparedStatement stmt = conn.prepareStatement(sql);
       
     
   
    
    // Exécuter la requête
    ResultSet res = stmt.executeQuery();
   
    System.err.println("berra while ");
    while (res.next())
    {
        path=  pat+"\\"+t1.Rapport+"_"+nombre_dans+".jpeg" ;
        System.err.println(path);
    file = new File(path);
  System.err.println("in boucle "); 
      String nom= res.getString(1);
      
      com.mysql.jdbc.Blob blob =(com.mysql.jdbc.Blob) res.getBlob("image");
      //convertion byte 
  byte [] bytes = blob.getBytes(1l, (int)blob.length());
     
    OutputStream os = new FileOutputStream(path); 
  System.err.println("dakhlwhile ");
    if(nombre_dans==3){
     
     nombre_dans=0;
     conn.close(); 
        System.err.println("return listand nbr=3");
        System.err.println(a);
     return a;
 }            // Starts writing the bytes in it 
            os.write(bytes); 
           a.add(path);
           nombre_dans++;
         
 

    }
   conn.close(); 
    //path="";//vis_ima.path="";
    System.err.println("return NULL");
   return a;
}

public static void y_a(ArrayList<String> b,WritableSheet a ,Textilee t1) throws IOException, BiffException{
    
    for(int i=0;i<3;i++){
    JDBC.insert_to( a,(String)b.get(i),t1);
     try{

            File file = new File((String)b.get(i));
 System.err.println(file.getName() + (String)b.get(i));
            file.delete();

        }catch(Exception e){

            e.printStackTrace();

        }
    
    
    }
    
}

}
