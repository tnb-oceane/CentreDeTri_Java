package classes_projet;
import java.util.*;

public abstract class PoubelleIntelligente {

    public PoubelleIntelligente(CentreDeTri centre, long latitude, long longitude, String quartier,
			double capacitéMaxTotal, double capacitéActuelleTotal) {
		super();
		this.centredetri = centre;
		this.identifiant = suiviIdentifiant;
		this.latitude = latitude;
		this.longitude = longitude;
		this.quartier = quartier;
		CapacitéMaxTotal = capacitéMaxTotal;
		CapacitéActuelleTotal = capacitéActuelleTotal;
		
		/*Une nouvelle poubelle est au centre de tri donc non placer et est vide*/
		this.placer = false;
		this.listeDéchet = new ArrayList<Déchet>();
		
		/*On incrémente suiviIdentifiant de 1 car les identifiants sont unique*/
		suiviIdentifiant += 1;
		
		/*On ajoute la poubelle à la liste des poubelles du centre de tri*/
		this.centredetri.getPoubelles().add(this);
	}
    
    protected CentreDeTri centredetri;

	protected long identifiant;

    protected long latitude;
    
    protected long longitude;

    protected String quartier;

    protected double CapacitéMaxTotal;

    protected double CapacitéActuelleTotal;
   
    /*true si la poubelle est dans son quartier, false si elle est au centre de tri*/
    protected boolean placer;

    protected static long suiviIdentifiant = 1;
    
    /*Liste des déchets présent dans la poubelle*/
    protected ArrayList<Déchet> listeDéchet;

    

    public CentreDeTri getCentredetri() {
		return this.centredetri;
	}


	public long getIdentifiant() {
        return this.identifiant;
    }


    public long getLatitude() {
        return this.latitude;
    }
    
    public long getLongitude() {
        return this.longitude;
    }

    public String getQuartier() {
        return this.quartier;
    }

    public double getCapacitéMaxTotal() {
        return this.CapacitéMaxTotal;
    }

    public double getCapacitéActuelleTotal() {
        return this.CapacitéActuelleTotal;
    }

    public ArrayList<Déchet> getListeDechet() {
        return this.listeDéchet;
    }

    public boolean getPlacer() {
        return this.placer;
    }
    public void setPlacer(boolean bool) {
        this.placer=bool;
    }

    public long getSuiviIdentifiant() {
        return suiviIdentifiant;
    }

    
    /*On vérifie que le code du Ménage exise bien dans la liste des code d'accès*/
    public boolean identifierUtilisateur(int codeAccès) {
        return this.centredetri.getListeCodeAccès().contains(codeAccès);
    }

    /*Met la poubelle dans la liste des notifications du centre de tri*/
    public boolean envoyerNotification() {
        return this.centredetri.getNotification().add(this);
    }
    
    public boolean viderPoubelle() {
    	if(this.listeDéchet.isEmpty()) {
    		return false;
    	}
    	this.listeDéchet.clear();
    	return true;
    }


    public abstract double calculQuantité(Dépot depot, String typeDechet);


    public abstract int verifierTypeDechet(Dépot depot);


    public abstract boolean attribuerPoint(Ménage ménage, int points);
	
}
