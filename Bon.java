package project_class;
import java.util.*;

public class Bon {
	
    private long identifiant;
    
    private TypeBon type;
    
    private double valeur;
    
    private int prixBon;
    
    private Commerce commerce;
    
    private Ménage menage;
    
    private Achat achat;
    
    private Date dateEmission;
    
    private Date dateLimite;
    
    private ArrayList<String> listeCatégorieConcernés;
    
    private boolean actif;
    
    protected static long suiviIdentifiant = 1;

	


    public Bon(TypeBon type, double valeur, int prixBon, Commerce commerce,Date dateEmission, Date dateLimite, ArrayList<String> listeCatégorieConcernés, boolean actif) {
		super();
		this.identifiant = suiviIdentifiant;
		this.type = type;
		this.valeur = valeur;
		this.prixBon = prixBon;
		this.commerce = commerce;
		this.menage = null;
		this.achat = null;
		this.dateEmission = dateEmission;
		this.dateLimite = dateLimite;
		this.listeCatégorieConcernés = listeCatégorieConcernés;
		this.actif = actif;
		
		suiviIdentifiant++;
		
		this.commerce.getListeBons().add(this);
	}




	public long getIdentifiant() {
		return identifiant;
	}

	public TypeBon getType() {
		return type;
	}

	public double getValeur() {
		return valeur;
	}

	public int getPrixBon() {
		return prixBon;
	}

	public Commerce getCommerce() {
		return commerce;
	}

	public Ménage getMenage() {
		return menage;
	}

	public Achat getAchat() {
		return achat;
	}
	
	public Date getDateEmission() {
		return dateEmission;
	}

	public Date getDateLimite() {
		return dateLimite;
	}

	public ArrayList<String> getListeCatégorieConcernés() {
		return listeCatégorieConcernés;
	}

	public boolean isActif() {
		return this.verifierBon();
	}

	public static long getSuiviIdentifiant() {
		return suiviIdentifiant;
	}
	
	public void setMenage(Ménage menage) {
		this.menage = menage;
	}

	public void setAchat(Achat achat) {
		this.achat = achat;
	}
	
	public void setActif(boolean actif) {
		this.actif = actif;
	}

	   
	/*Pour etre utilisable, le bon doit être actif, ne pas avoir dépassé la date limite et les produit concernés doivent toujours être vendu par le commerce*/
   public boolean verifierBon() {
       this.actif = actif && dateLimite.after(new Date()) && commerce.getListeCategorieProduitVendu().containsAll(listeCatégorieConcernés);
       return actif;
    }




@Override
public String toString() {
	return "Bon [identifiant=" + identifiant + ", type=" + type + ", valeur=" + valeur + ", prixBon=" + prixBon
			+ ", commerce=" + commerce.getNom() + ", dateEmission=" + dateEmission
			+ ", dateLimite=" + dateLimite + ", listeCategorieConcernes=" + listeCatégorieConcernés + ", actif=" + actif
			+ "]";
}




   
   
   
   
   
    
    
}

