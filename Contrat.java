
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;

public class Contrat 
{
    private long identifiant;
    private Date dateDebut;
    private Date dateFin;
    private Date dateExpiration;
	private double prix;
    private ArrayList<String> listeCategorie;
    private int reductionEnPoint;
    private int achatEnPoint;
    private static long suiviIdentifiant=1;
    private ArrayList<Contrat> listeContrats;
    private String typeBonAdmissible;
    private CentreDeTri centredetri;
   

    public Contrat(long identifiant, Date dateDebut, Date dateFin, double prix, ArrayList<String> listeCategorie,
                   int reductionEnPoint, int achatEnPoint, String typeBonAdmissible) //si dans reduc on met 100, ça veut dire que pour ce contrat il faudra 100 points pour avoir une réduction de 1%, pour achat : 100 voudra dire 100 points pour 1 euro
    {
        this.identifiant = suiviIdentifiant;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.listeCategorie = listeCategorie;
        this.reductionEnPoint = reductionEnPoint;
        this.achatEnPoint = achatEnPoint;
        this.listeContrats = new ArrayList<Contrat>();
        this.typeBonAdmissible = typeBonAdmissible;
        suiviIdentifiant++;
        this.centredetri.getListeContrats().add(this); //on ajoute ce contrat dans la liste de contrats du centre de tri.
    }

    public boolean renouvelerContrat()
    {
        // Vérifier si le contrat est expiré
        if (this.dateExpiration.before(new Date())) 
        {
            // Calculer la nouvelle date d'expiration
            Calendar calendar = Calendar.getInstance(); // Cela permet d'obtenir la date et l'heure actuelles
            calendar.setTime(this.dateExpiration); //permet d'initialiser l'objet calendar avec la date d'expiration du contrat en cours.
            calendar.add(Calendar.MONTH, 1); // Ajouter un mois
            this.dateExpiration = calendar.getTime(); //mettre à jour la date d'expiration du contrat 
            return true;
        } 
        else 
        {
            return false;
        }
    }

    public long getSuiviIdentifiant() {
        return suiviIdentifiant;
    }

    public ArrayList<Contrat> getListeContrats() {
        return listeContrats;
    }

    public String getTypeBonAdmissible() {
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
    

  /*  public CentreDeTri getCentreDeTri() {
        // Code pour obtenir le centre de tri associé à ce contrat
        return null;
    }*/

   /* public Commerce getCommerce() {
        // Code pour obtenir le commerce associé à ce contrat
        return null;
    }
*/
    public Date getDateFin() {
        return dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public long getIdentifiant() {
        return identifiant;
    }

}

