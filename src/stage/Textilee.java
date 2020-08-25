



package stage;

import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


/**
 *
 * @author PC
 */



public class Textilee {

  
  static int Rapport; 
  String Date_de_rédaction ;
  String Date_de_début_des_essais ;
  String Date_de_fin_des_essais ;
  String Date_de_réception_échantillon;
  String Demandeur;
  int Nombre_échantillons;
  int  Identification_échantillion ;
  int Prelevement ;
  String marque_Ref;
  String Categorie;
  String Rédigé_par ;
  String Validé_par;
  int DUM;
  String Importateur;
  String Adresse_Importateur;
  String  Facture_au_nom_de ;
  String Adresse;
  String Colorants_Azoiques;
  String PCP;
  String Métaux_lourds;
   int  ice;
  Textilee(int r ){
      
      this.Rapport=r;
  }
  
  Textilee(int Rapport, String Date_de_rédaction, String Date_de_début_des_essais,  String Date_de_fin_des_essais,String Date_de_réception_échantillon,String Demandeur,int Nombre_échantillons
  ,int  Identification_échantillion, int Prelevement,String marque_Ref,String Categorie,String Rédigé_par,String Validé_par,int DUM,
  String Importateur,String  Facture_au_nom_de,String Adresse, int ice,String Colorants_Azoiques,String PCP,String Métaux_lourds)
  
  
  {
      this.ice=ice;
this.Date_de_fin_des_essais=Date_de_fin_des_essais;
      
    this.Rapport=Rapport;
    this.Date_de_rédaction=Date_de_rédaction;
    this.Date_de_début_des_essais=Date_de_début_des_essais;
    this.Date_de_réception_échantillon=Date_de_réception_échantillon;
    this.Demandeur=Demandeur;
    this.Identification_échantillion=Identification_échantillion;
    this.Prelevement=Prelevement;
    this.marque_Ref=marque_Ref;
    this.Categorie=Categorie;
    this.Rédigé_par=Rédigé_par;
    this.Validé_par=Validé_par;
    this.DUM=DUM;
    this.Importateur=Importateur;
    this.Facture_au_nom_de=Facture_au_nom_de;
    this.Adresse=Adresse;
    this.Colorants_Azoiques=Colorants_Azoiques;
    this.PCP=PCP;
    this.Métaux_lourds=Métaux_lourds;
    
    
    
}


          
                
          
}