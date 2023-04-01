package classes_projet;
import java.util.*;

public class CentreDeTri {

    public CentreDeTri(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.listeQuartierDesservie = new ArrayList<String>();
		this.notification = new ArrayList<PoubelleIntelligente>();
		this.listeCodeAccès = new ArrayList<Integer>();
		this.listeMénageAvecCompte = new ArrayList<Ménage>();
		this.listePoubelles = new ArrayList<PoubelleIntelligente>();
		this.listeCommercePartenaire = new ArrayList<Commerce>();
		this.listeContrats = new ArrayList<Contrat>();
		this.listeDechets = new ArrayList<Déchet>();
	}

	private String nom;

    private String adresse;

    private ArrayList<String> listeQuartierDesservie;

    private ArrayList<PoubelleIntelligente> listePoubelles;
    
    private ArrayList<PoubelleIntelligente> notification;
    
    private ArrayList<Integer> listeCodeAccès;
    
    private ArrayList<Ménage> listeMénageAvecCompte;
    
    private ArrayList<Commerce> listeCommercePartenaire;
    
    private ArrayList<Contrat> listeContrats;
    
    private ArrayList<Déchet> listeDechets;
 

    
    
    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public ArrayList<PoubelleIntelligente> getPoubelles() {
        return this.listePoubelles;
    }

    public ArrayList<String> getListeQuartierDesservie() {
        return this.listeQuartierDesservie;
    }

    public ArrayList<Commerce> getListeCommercesPartenaire() {
        return this.listeCommercePartenaire;
    }

    public ArrayList<Contrat> getListeContrats() {
        return this.listeContrats;
    }

    public ArrayList<PoubelleIntelligente> getNotification() {
        return this.notification;
    }
    
    public ArrayList<Integer> getListeCodeAccès() {
		return this.listeCodeAccès;
	}

	public ArrayList<Ménage> getListeMénageAvecCompte() {
		return this.listeMénageAvecCompte;
	}
	
    public ArrayList<Déchet> getListeDechets() {
		return listeDechets;
	}

	/*supprime la notification envoyer par une poubelle*/
    public boolean supprimerNotification(PoubelleIntelligente poubelle) {
        return this.notification.remove(poubelle);
    }
    
    /*supprime toute les notification*/
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

    /**
     * @param coordonées 
     * @param quartier 
     * @param capacitéMax 
     * @param capacitéActuelle 
     * @return
     */
    public boolean ajouterPoubelle(long coordonées, String quartier, double capacitéMax, double capacitéActuelle) {
    	// TODO implement here
    	return false;
    }


    public boolean supprimerPoubelle(long idPoubelle) {
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (this.listePoubelles.get(i).getIdentifiant() == idPoubelle) {
    			 return this.listePoubelles.remove(this.listePoubelles.get(i));
    		}
    	}
    	return false;
    }

    /**
     * @return
     */
    public boolean placerPoubelleDisponible() {/*A completer*/
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (!this.listePoubelles.get(i).getPlacer()) {
    			this.listePoubelles.get(i).setPlacer(true);
    			// TODO implement here
    		}
    	}
        return false;
    }

    /*Ajoute une poubelle à un quartier si toutes les poubelles de ce quartier ne sont pas déjà placé dans le quartier*/
    public boolean ajouterPoubelleQuartier(String quartier) {
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (this.listePoubelles.get(i).getQuartier()== quartier && !this.listePoubelles.get(i).getPlacer()) {
    			this.listePoubelles.get(i).setPlacer(true);
    			return true;
    		}
    	}
        return false;
    }

    /*Supprime une poubelle d'un quartier si il y a des poubelles placé dans ce quartier*/
    public boolean supprimerPoubelleQuartier(String quartier) {
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (this.listePoubelles.get(i).getQuartier()== quartier && this.listePoubelles.get(i).getPlacer()) {
    			this.listePoubelles.get(i).setPlacer(false);
    			return true;
    		}
    	}
        return false;
    }

    /*Collecte tout les déchets d'un quartier : on ramène les poubelles au centre de tri et on les vides*/
    public boolean collecterDechet(String quartier) {/*A compléter*/
    	for (int i=0; i< this.listePoubelles.size();i++) {
    		if (this.listePoubelles.get(i).getQuartier()== quartier && this.listePoubelles.get(i).getPlacer()) {
    			this.listePoubelles.get(i).setPlacer(false);
    			this.listeDechets.addAll(this.listePoubelles.get(i).listeDéchet);
    			this.listePoubelles.get(i).viderPoubelle();
    		}
    	}
    	//// TODO implement here
        return false;
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

    
    public boolean voirNotification() {
    	System.out.println(this.notification);
    	return this.supprimerNotification();
    }
    

    public boolean faireStatistique() {
        // TODO implement here
        return false;
    }
	
	

}
