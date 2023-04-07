package classes_projet;
import java.util.*;

public class Achat {
	
	
    private long identifiant;
    
    private double prixDépart;
    
    private double prixFinal;
    
    private Date date;
    
    private Ménage menage;
    
    private Commerce commerce;
    
    private ArrayList<Bon> listeBonsUtilisés;
    
    protected static long suiviIdentifiant = 1;
    
    
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
        this.commerce.getListeAchats().add(this);       
    }

   
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
    
    public String listeBonsToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < listeBonsUtilisés.size(); i++) {
            sb.append(listeBonsUtilisés.get(i).getIdentifiant());
            if (i < listeBonsUtilisés.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


	@Override
	public String toString() {
		return "Achat [identifiant=" + identifiant + ", prixDépart=" + prixDépart + ", prixFinal=" + prixFinal
				+ ", date=" + date + ", menage=" + menage.getIdentifiant() + ", commerce=" + commerce.getNom() + ", listeBonsUtilisés="
				+ listeBonsUtilisés + "]";
	}
  
    
    
}  
