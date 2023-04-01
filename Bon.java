package classes_projet;
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
    
    private ArrayList<String> listeProduitsConcernés;
    
    private boolean actif;
    
    protected static long suiviIdentifiant = 1;

    

	
	


    public Bon(TypeBon type, double valeur, int prixBon, Commerce commerce,Date dateEmission, Date dateLimite, ArrayList<String> listeProduitsConcernés, boolean actif) {
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
		this.listeProduitsConcernés = listeProduitsConcernés;
		this.actif = actif;
		
		suiviIdentifiant++;
		
		//this.commerce.getBonsPublier().add(this);
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

	public ArrayList<String> getListeProduitsConcernés() {
		return listeProduitsConcernés;
	}

	public boolean isActif() {
		return actif;
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

	   

   /* public boolean estUtilisable(Date date, String produit) {
        return actif && !date.after(dateLimite) && (listeProduitsConcernés.isEmpty() || listeProduitsConcernés.contains(produit));
    }*/ //Fonction pas utile car l'attribut actif nous donne déja si le bon est utilisable ou pas.

    /*public boolean utiliser() {
        if (actif) {
            actif = false;
            return true;
        } else {
            return false;
        }
    }*/ // Fonction inutile et trop longue on peut la remplacer par setActif(false);
    
    
}

