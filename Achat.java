package classes_projet;
import java.util.*;

public class Achat {
	
	public Achat(double prixDépart, Ménage menage, Commerce commerce) {
       
		this.identifiant = suiviIdentifiant;
        this.prixDépart = prixDépart;
        this.prixFinal = prixDépart;
        this.date = new Date();
        this.menage = menage;
        this.commerce = commerce;
        this.listeBonsUtilisés = new ArrayList<Bon>();
        
        suiviIdentifiant++;
        
        this.menage.getListeAchats().add(this);
        //this.commerce.getListeAchats().add(this);
        
    }
	
	
    private long identifiant;
    
    private double prixDépart;
    
    private double prixFinal;
    
    private Date date;
    
    private Ménage menage;
    
    private Commerce commerce;
    
    private ArrayList<Bon> listeBonsUtilisés;
    
    protected static long suiviIdentifiant = 1;

   

    public long getIdentifiant() {
        return identifiant;
    }

    public double getPrixDépart() {
        return prixDépart;
    }

    public double getPrixFinal() {
        return prixFinal;
    }

    public Date getDate() {
        return date;
    }

    public Ménage getMenage() {
        return menage;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public ArrayList<Bon> getListeBonsUtilisés() {
        return listeBonsUtilisés;
    }
    
    public static long getSuiviIdentifiant() {
    	return suiviIdentifiant;
    }
    
    
    
   /* public void ajouterBonUtilisé(Bon bon) {
        if (!listeBonsUtilisés.contains(bon)) {
            listeBonsUtilisés.add(bon);
            double remise = bon.getValeur();
            prixFinal -= remise;
            if (prixFinal < 0) {
                prixFinal = 0;
            }
        }
    }*/ //J'ai modifié legerement la fonction pour quelle modifie le prix final en fonction du type de Bon
    public void ajouterBonUtilisé(Bon bon) {
      if (!listeBonsUtilisés.contains(bon)) {
          listeBonsUtilisés.add(bon);
          bon.setAchat(this);
          double remise = bon.getValeur();
          switch (bon.getType()) {
          	case ACHAT:
          		prixFinal -= remise;//Le bon d'achat retire une partie du prix final
          		break;
          	case REDUCTION:
          		prixFinal *= 1+(remise/100);// le bon de réduction retire un pourcentage du prix final
          		break;
          }
          if (prixFinal < 0) {
              prixFinal = 0;
          }
      }
    }
  
  /*public void retirerBonUtilisé(Bon bon) {
      if (listeBonsUtilisés.contains(bon)) {
          listeBonsUtilisés.remove(bon);
          double remise = bon.getValeur();
          prixFinal += remise;
      }
  }*/ //Je ne pense pas que cette fonction soit utile
  
    
 /* public void appliquerBonsUtilisés() {
      double remiseTotale = 0;
      for (Bon bon : listeBonsUtilisés) {
          remiseTotale += bon.getValeur();
      }
      prixFinal = prixDépart - remiseTotale;
      if (prixFinal < 0) {
          prixFinal = 0;
      }
  } //CalculPrixFinal();*/ //Pas utile car en ajoutant les bon le prix final est directement calculer
  
}  
