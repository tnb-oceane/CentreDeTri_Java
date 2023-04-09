package classes_projet;
import java.util.*;


public class Contrat {
	
    private long identifiant;
    
    private Date dateDebut;
    
    private Date dateExpiration;
    
	private double prix;
	
    private ArrayList<String> listeCategorie;
    
    private int reductionEnPoint;
    
    private int achatEnPoint;
    
    private static long suiviIdentifiant=1;
    
    private ArrayList<TypeBon> typeBonAdmissible;
    
    private CentreDeTri centredetri;
    
    private Commerce commerce;
   

    public Contrat(Date dateDebut,Date dateExpiration, double prix, ArrayList<String> listeCategorie,
                   int reductionEnPoint, int achatEnPoint, ArrayList<TypeBon> typeBonAdmissible,CentreDeTri centredetri, Commerce commerce) { //si dans reduc on met 100, ça veut dire que pour ce contrat il faudra 100 points pour avoir une réduction de 1%, pour achat : 100 voudra dire 100 points pour 1 euro
        this.identifiant = suiviIdentifiant;
        this.dateDebut = dateDebut;
        this.dateExpiration = dateExpiration;
        this.prix = prix;
        this.listeCategorie = listeCategorie;
        this.reductionEnPoint = reductionEnPoint;
        this.achatEnPoint = achatEnPoint;
        this.typeBonAdmissible = typeBonAdmissible;
        this.commerce = commerce;
        this.centredetri = centredetri;
        suiviIdentifiant++;
        
        //on ajoute ce contrat dans la liste de contrats du commerce et du centre de tri.
        this.commerce.getListeContrats().add(this);
        this.centredetri.getListeContrats().add(this);
    }

    public boolean renouvelerContrat(int mois)
    {
        // Vérifier si le contrat est expiré
        if (this.dateExpiration.before(new Date())) {
            // Calculer la nouvelle date d'expiration
            Calendar calendar = Calendar.getInstance(); // Cela permet d'obtenir la date et l'heure actuelles
            calendar.setTime(this.dateExpiration); //permet d'initialiser l'objet calendar avec la date d'expiration du contrat en cours.
            calendar.add(Calendar.MONTH, mois); // Ajouter un mois
            this.dateExpiration = calendar.getTime(); //mettre à jour la date d'expiration du contrat 
            return true;
        } 
        else {
            return false;
        }
    }

    public long getSuiviIdentifiant() {
        return suiviIdentifiant;
    }


    public ArrayList<TypeBon> getTypeBonAdmissible() {
        return typeBonAdmissible;
    }

    public int getAchatEnPoint() {
        return achatEnPoint;
    }

    public int getReductionEnPoint() {
        return reductionEnPoint;
    }

    public ArrayList<String> getListeCategorie() {
        return listeCategorie;
    }

    public double getPrix() {
        return prix;
    }
    
    public Date getDateExpiration()
    {
		return dateExpiration;
	}
    

    public CentreDeTri getCentreDeTri() {
        return this.centredetri;
    }

    public Commerce getCommerce() {
       return this.commerce;
    }


    public Date getDateDebut() {
        return dateDebut;
    }

    public long getIdentifiant() {
        return identifiant;
    }

	@Override
	public String toString() {
		return "Contrat [identifiant=" + identifiant + ", dateDebut=" + dateDebut + ", dateExpiration=" + dateExpiration
				+ ", prix=" + prix + ", listeCategorie=" + listeCategorie + ", reductionEnPoint=" + reductionEnPoint
				+ ", achatEnPoint=" + achatEnPoint + ", typeBonAdmissible=" + typeBonAdmissible + ", centredetri="
				+ centredetri.getNom() + ", commerce=" + commerce.getNom() + "]";
	}
    
    

}

