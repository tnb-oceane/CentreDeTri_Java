package classes_projet;
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
    public boolean supprimerNotification(PoubelleIntelligente poubelle) {/*idPoubelle au lieu de poubelle*/
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
        return this.listeQuartierDesservie.add(quartier);
    }

    public boolean supprimerQuartier(String quartier) {
        return this.listeQuartierDesservie.remove(quartier);
    }

    
    public boolean ajouterPoubelleBleue(long latitude, long longitude, String quartier, double capacitéMaxPapier) {
    	return this.listePoubelles.contains(new PoubelleBleue(this, longitude, latitude, quartier, capacitéMaxPapier));	
    }
    
    public boolean ajouterPoubelleVerte(long latitude, long longitude, String quartier, double capacitéMaxVerre) {
    	return this.listePoubelles.contains(new PoubelleVerte(this, longitude, latitude, quartier, capacitéMaxVerre));	
    }
    
    public boolean ajouterPoubelleClassique(long latitude, long longitude, String quartier, double capacitéMaxAutre) {
    	return this.listePoubelles.contains(new PoubelleBleue(this, longitude, latitude, quartier, capacitéMaxAutre));
    }
    
    public boolean ajouterPoubelleJaune(long latitude, long longitude, String quartier, double capacitéMaxTotal,
			double capacitéMaxEmballage, double capacitéMaxCarton, double capacitéMaxPlastique,
			double capacitéMaxCanetteConserve) {
    	return this.listePoubelles.contains(new PoubelleJaune(this, latitude, longitude, quartier, capacitéMaxTotal, capacitéMaxEmballage, capacitéMaxCarton, capacitéMaxPlastique, capacitéMaxCanetteConserve));
    }


    public boolean supprimerPoubelle(PoubelleIntelligente poubelle) {
    	return this.listePoubelles.remove(poubelle);
    }

  
    public boolean placerPoubelleDisponible() {
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (!this.listePoubelles.get(i).isPlacer()) {
    			this.listePoubelles.get(i).setPlacer(true);
    		}
    	}
        return true;
    }

    /*Ajoute une poubelle à un quartier si toutes les poubelles de ce quartier ne sont pas déjà placé dans le quartier*/
    public boolean ajouterPoubelleQuartier(String quartier) {
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (this.listePoubelles.get(i).getQuartier()== quartier && !this.listePoubelles.get(i).isPlacer()) {
    			this.listePoubelles.get(i).setPlacer(true);
    			return true;
    		}
    	}
        return false;
    }
    

    /*Supprime une poubelle d'un quartier si il y a des poubelles placé dans ce quartier*/
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
    public boolean collecterDechet(String quartier) {/*A compléter*/
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (this.listePoubelles.get(i).getQuartier()== quartier && this.listePoubelles.get(i).isPlacer()) {
    			this.listePoubelles.get(i).setPlacer(false);//On ramene au la poubelle au centre de tri
    			this.listeDechets.addAll(this.listePoubelles.get(i).listeDéchet);//on mets les dechet de la poubelle au centre de tri
    			this.listePoubelles.get(i).viderPoubelle();//on vide la poubelle
    		}
    	}
        return true;
    }
    
    
    public boolean voirNotification() {
    	System.out.println(this.notification);
    	return this.supprimerNotification();
    }

    /**
     * @param commerce 
     * @param dateDebut 
     * @param dateFin 
     * @param catégorie 
     * @param prix 
     * @param reductionEnPoint 
     * @param achatEnPoint 
     * @return
     */
    public boolean creerContrat(String commerce, Date dateDebut, Date dateFin, ArrayList<String> catégorie, double prix, int reductionEnPoint, int achatEnPoint) {
        // TODO implement here
        return false;
    }
    

    public boolean faireStatistique() {
        // TODO implement here
        return false;
    }


	
	
	

}
