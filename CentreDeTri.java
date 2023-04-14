package project_class;
import java.util.*;

public class CentreDeTri {


	private String nom;

    private String adresse;

    private ArrayList<String> listeQuartierDesservie;

    private ArrayList<PoubelleIntelligente> listePoubelles;
    
    private ArrayList<PoubelleIntelligente> notification;
    
    private ArrayList<Ménage> listeMénageAvecCompte;
    
    private ArrayList<Commerce> listeCommercePartenaire;
    
    private ArrayList<Contrat> listeContrats;
    
    private ArrayList<Déchet> listeDechets;
 
    private int pointParGrammeDechet;
    
    
    
    public CentreDeTri(String nom, String adresse,int pointParGrammeDechet) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.listeQuartierDesservie = new ArrayList<String>();
		this.notification = new ArrayList<PoubelleIntelligente>();
		this.listeMénageAvecCompte = new ArrayList<Ménage>();
		this.listePoubelles = new ArrayList<PoubelleIntelligente>();
		this.listeCommercePartenaire = new ArrayList<Commerce>();
		this.listeContrats = new ArrayList<Contrat>();
		this.listeDechets = new ArrayList<Déchet>();
		this.pointParGrammeDechet = pointParGrammeDechet;
	}
    
    
    
    

	public String getNom() {
		return nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public ArrayList<String> getListeQuartierDesservie() {
		return listeQuartierDesservie;
	}

	public ArrayList<PoubelleIntelligente> getListePoubelles() {
		return listePoubelles;
	}

	public ArrayList<PoubelleIntelligente> getNotification() {
		return notification;
	}

	public ArrayList<Ménage> getListeMénageAvecCompte() {
		return listeMénageAvecCompte;
	}

	public ArrayList<Commerce> getListeCommercePartenaire() {
		return listeCommercePartenaire;
	}

	public ArrayList<Contrat> getListeContrats() {
		return listeContrats;
	}

	public ArrayList<Déchet> getListeDechets() {
		return listeDechets;
	}

	public int getPointParGrammeDechet() {
		return pointParGrammeDechet;
	}




	/*supprime la notification envoyée par une poubelle*/
    public boolean supprimerNotification(long idPoubelle) {
    	PoubelleIntelligente poubelle = null;
    	for (PoubelleIntelligente p: this.listePoubelles) {
    		if (p.getIdentifiant() == idPoubelle) {
    			poubelle = p;
    		}
    	}
    	if(poubelle == null) {
    		return false; //cette poubelle n'existe pas
    	}
    	return this.notification.remove(poubelle);
    }
    
    /*supprime toutes les notification*/
    public boolean supprimerNotification() {
        if (this.notification.isEmpty()) {
        	return false;
        }
        this.notification.clear();
        return true;  
    }

    public boolean ajouterQuartier(String quartier) {
    	if(this.listeQuartierDesservie.contains(quartier)) {//si le quartier est déja désservie on ne l'ajoute pas
    		return false;
    	}
        return this.listeQuartierDesservie.add(quartier);
    }

    public boolean supprimerQuartier(String quartier) {
    	this.collecterDechet(quartier);
    	for(int i=0;i< this.listePoubelles.size();i++) {
    		if (this.listePoubelles.get(i).getQuartier()==quartier) {
    			this.supprimerPoubelle(this.listePoubelles.get(i).getIdentifiant());
    		}
    	}
        return this.listeQuartierDesservie.remove(quartier);
    }

    
    public void ajouterPoubelleBleue(long latitude, long longitude, String quartier, double capacitéMaxPapier) {
    	 new PoubelleBleue(this, latitude, longitude, quartier, capacitéMaxPapier);	
    }
    
    public void ajouterPoubelleVerte(long latitude, long longitude, String quartier, double capacitéMaxVerre) {
    	new PoubelleVerte(this, latitude, longitude, quartier, capacitéMaxVerre);	
    }
    
    public void ajouterPoubelleClassique(long latitude, long longitude, String quartier, double capacitéMaxAutre) {
    	new PoubelleClassique(this, latitude, longitude, quartier, capacitéMaxAutre);
    }
    
    public void ajouterPoubelleJaune(long latitude, long longitude, String quartier, double capacitéMaxAutre) {
    	new PoubelleJaune(this, latitude, longitude, quartier, capacitéMaxAutre);
    }


    public boolean supprimerPoubelle(long idPoubelle) {
    	PoubelleIntelligente poubelle = null;
    	for (PoubelleIntelligente p: this.listePoubelles) {
    		if (p.getIdentifiant() == idPoubelle) {
    			poubelle = p;
    		}
    	}
    	if(poubelle == null) {
    		return false; //cette poubelle n'existe pas
    	}
    	if(poubelle.placer) {
    		return false;//la poubelle est dans son quartier il faut d'abord la ramener au centre de tri
    	}
    	if(!poubelle.getListeDéchet().isEmpty()) {//si la poubelle est remplie il faut la vider avant de la supprimer
    		this.listeDechets.addAll(poubelle.getListeDéchet());
    		poubelle.getListeDéchet().clear();
    	}
    	return this.listePoubelles.remove(poubelle);
    }

  
    public void placerPoubelleDisponible() {
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (!this.listePoubelles.get(i).isPlacer()) {
    			this.listePoubelles.get(i).setPlacer(true);
    		}
    	}
    }

    /*Ajoute une poubelle à un quartier si toutes les poubelles de ce quartier ne sont pas déjà placé dans le quartier*/
    public boolean ajouterPoubelleQuartier(String quartier) {
    	if(!this.listeQuartierDesservie.contains(quartier)) {//si le quartier n'est pas désservie on n'y place pas de poubelle
    		return false;
    	}
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (this.listePoubelles.get(i).getQuartier()== quartier && !this.listePoubelles.get(i).isPlacer()) {
    			this.listePoubelles.get(i).setPlacer(true);
    			return true;
    		}
    	}
        return false;
    }
    

    /*Ramène une poubelle d'un quartier si il y a des poubelles placé dans ce quartier*/
    public boolean supprimerPoubelleQuartier(String quartier) {
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (this.listePoubelles.get(i).getQuartier()== quartier && this.listePoubelles.get(i).isPlacer()) {
    			this.listePoubelles.get(i).setPlacer(false);
    			return true;
    		}
    	}
        return false;
    }
    

    /*Collecte tout les déchets d'un quartier : on ramène les poubelles au centre de tri et on les vides*/
    public void collecterDechet(String quartier) {/*A compléter*/
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (this.listePoubelles.get(i).getQuartier()== quartier && this.listePoubelles.get(i).isPlacer()) {
    			this.listePoubelles.get(i).setPlacer(false);//On ramene au la poubelle au centre de tri
    			this.listeDechets.addAll(this.listePoubelles.get(i).listeDéchet);//on mets les dechet de la poubelle au centre de tri
    			this.listePoubelles.get(i).viderPoubelle();//on vide la poubelle
    		}
    	}
    }
    
    
    public boolean voirNotification() {
    	System.out.println(this.notification+"\n");
    	return this.supprimerNotification();
    }


    public void creerContrat(Date dateDebut,Date dateExpiration, double prix, ArrayList<String> listeCategorie,
            int reductionEnPoint, int achatEnPoint, ArrayList<TypeBon> typeBonAdmissible, Commerce commerce) {
        new Contrat(dateDebut,dateExpiration,prix,listeCategorie,reductionEnPoint,achatEnPoint,typeBonAdmissible,this,commerce);
    }
    

    public void faireStatistique() {
       System.out.println("Nombre de foyer avec compte : " + this.listeMénageAvecCompte.size());
       System.out.println("Liste des commerces partenaires : " + this.listeCommercePartenaire);
       System.out.println("Nombre de contrat : " + this.listeContrats.size());
       System.out.println("Quantite de dechet collecte : " + this.listeDechets.size());
       
    }





	@Override
	public String toString() {
		return "CentreDeTri [nom=" + nom + ", adresse=" + adresse + ", pointParGrammeDechet=" + pointParGrammeDechet + ", notification=" + notification + "]";
	}

   

}
