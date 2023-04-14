package project_class;
import java.util.*;

public class Commerce {
	
    private String nom;
    
    private ArrayList<String> listeCategorieProduitVendu;
    
    private ArrayList<Contrat> listeContrats; //dans la classe Commerce, nous stockons une liste des contrats associés à ce commerce, car un commerce peut avoir plusieurs contrats avec le centre de tri.
    
    private ArrayList<Bon> listeBons; // nous stockons une liste des bons publiés par ce commerce
    
    private CentreDeTri centreTri;
    
    private ArrayList<Ménage> listeMenages;
    
    private ArrayList<Achat> listeAchats;

    
    
    public Commerce(String nom, ArrayList<String> listeCategorieProduitVendu) {
        this.nom = nom; //Lorsqu'un objet Commerce est créé, nous passons un nom en paramètre au constructeur. Pour stocker cette valeur dans l'attribut "nom" de l'objet courant, nous utilisons l'instruction this.nom = nom;.
        this.listeCategorieProduitVendu = listeCategorieProduitVendu; //de même pour listeCategorieProduitVendu
        this.listeContrats = new ArrayList<Contrat>();
        this.listeBons = new ArrayList<Bon>(); /*Lorsqu'un nouvel objet Commerce est créé, il n'a pas encore de contrat ni de bon. 
                                       donc on initialise ces listes vides avec new ArrayList<>(). Ainsi, ces listes pourront 
                                       être remplies au fur et à mesure de l'ajout de contrats et de bons.*/
        this.centreTri=null;
        this.listeMenages=new ArrayList<Ménage>();
        this.listeAchats=new ArrayList<Achat>();
    }


    public String getNom()
    {
		return nom;
	}



	public ArrayList<String> getListeCategorieProduitVendu() 
	{
		return listeCategorieProduitVendu;
	}



	public ArrayList<Contrat> getListeContrats() 
	{
		return listeContrats;
	}



	public ArrayList<Bon> getListeBons() 
	{
		return listeBons;
	}

	

	public CentreDeTri getCentreTri() {
		return centreTri;
	}


	public ArrayList<Ménage> getListeMenages() {
		return listeMenages;
	}


	public ArrayList<Achat> getListeAchats() {
		return listeAchats;
	}

	

	public boolean renouvelerContrat(int idContrat, int mois)
	{
        for (Contrat contrat : listeContrats) //parcourir tous les contrats présents dans listeContrats de l'objet de la classe Commerce. ( comme en python qd on fait for k in L, et ici la liste reste statique )
        {
            if (contrat.getIdentifiant() == idContrat) //si l'identifiant du contrat est égal à l'identifiant du contrat passé en paramètre.
            {
                return contrat.renouvelerContrat(mois); //appel de la méthode qui est dans la classe contrat
            }
        }
        return false; //Si aucun contrat n'a été trouvé avec l'identifiant passé en paramètre
    }

	
	public boolean publierBon(TypeBon typeBon, double valeurBon, int idContratAssocie, ArrayList<String> listeProduitsConcernés, Date dateExpiration) {
		Contrat contratAssocie = null;
		double prixBon = 0;
		for(Contrat c : this.listeContrats) {
			if (c.getIdentifiant()==idContratAssocie) {
				contratAssocie = c;
			}//On récupère le contrat associé
		}
		if (contratAssocie == null || contratAssocie.getDateExpiration().before(new Date()) || !contratAssocie.getTypeBonAdmissible().contains(typeBon)  ) {
			return false;
		}// On vérifie que le contrat est valide et accepte ce type de bon
		//On détermine le prix du bon à partir du contrat
		switch(typeBon) {
      	case ACHAT:
      		prixBon = contratAssocie.getAchatEnPoint()*valeurBon;
      		break;
      	case REDUCTION:
      		prixBon = contratAssocie.getReductionEnPoint()*valeurBon;
      		break;
		}
		new Bon(typeBon,valeurBon,(int)prixBon,this,new Date(),dateExpiration,listeProduitsConcernés, true);
		return true;
    }

	
    public boolean ajouterCategorie(String categorie) {
        if (!listeCategorieProduitVendu.contains(categorie)) {
        	return listeCategorieProduitVendu.add(categorie); 
        }
        return false;
    }

    public boolean supprimerCategorie(String categorie) {
       return listeCategorieProduitVendu.remove(categorie); //remove renvoie un boolean, il renvoie automatiquement false si la liste des catégories ne contient pas la catégorie passée en argument
    }


	@Override
	public String toString() {
		return "Commerce [nom=" + nom + ", listeCategorieProduitVendu=" + listeCategorieProduitVendu + "]";
	}
 
    

   
}

