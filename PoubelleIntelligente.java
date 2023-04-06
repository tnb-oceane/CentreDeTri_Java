package classes_projet;
import java.util.*;

public abstract class PoubelleIntelligente {

    
    protected CentreDeTri centredetri;

	protected long identifiant;

    protected long latitude;
    
    protected long longitude;

    protected String quartier;

    protected double CapacitéMaxTotal;

    protected double CapacitéActuelleTotal;
    
    private ArrayList<Dépot> listeDépots;
   
    /*true si la poubelle est dans son quartier, false si elle est au centre de tri*/
    protected boolean placer;

    protected static long suiviIdentifiant = 1;
    
    /*Liste des déchets présent dans la poubelle*/
    protected ArrayList<Déchet> listeDéchet;
    
    protected ArrayList<Ménage> listeMénages;
    
    private static ArrayList<Integer> listeCodeAccès;

    
    
    public PoubelleIntelligente(CentreDeTri centre, long latitude, long longitude, String quartier,
			double capacitéMaxTotal) {
		super();
		this.centredetri = centre;
		this.identifiant = suiviIdentifiant;
		this.latitude = latitude;
		this.longitude = longitude;
		this.quartier = quartier;
		CapacitéMaxTotal = capacitéMaxTotal;
		CapacitéActuelleTotal = capacitéMaxTotal;
		
		/*Une nouvelle poubelle est au centre de tri donc non placer et est vide*/
		this.placer = false;
		this.listeDéchet = new ArrayList<Déchet>();
		this.listeMénages = new ArrayList<Ménage>();
		this.listeDépots = new ArrayList<Dépot>();
		
		/*On incrémente suiviIdentifiant de 1 car les identifiants sont unique*/
		suiviIdentifiant++;
		
		/*On ajoute la poubelle à la liste des poubelles du centre de tri*/
		this.centredetri.getListePoubelles().add(this);
	}
    
    
     

    
    public CentreDeTri getCentredetri() {
		return centredetri;
	}

	public long getIdentifiant() {
		return identifiant;
	}

	public long getLatitude() {
		return latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public String getQuartier() {
		return quartier;
	}

	public double getCapacitéMaxTotal() {
		return CapacitéMaxTotal;
	}

	public double getCapacitéActuelleTotal() {
		return CapacitéActuelleTotal;
	}

	public ArrayList<Dépot> getListeDépots() {
		return listeDépots;
	}

	public boolean isPlacer() {
		return placer;
	}

	public static long getSuiviIdentifiant() {
		return suiviIdentifiant;
	}

	public ArrayList<Déchet> getListeDéchet() {
		return listeDéchet;
	}

	public ArrayList<Ménage> getListeMénages() {
		return listeMénages;
	}

	public static ArrayList<Integer> getListeCodeAccès() {
		return listeCodeAccès;
	}

	public void setPlacer(boolean placer) {
		this.placer = placer;
	}
	


	public void setCapacitéActuelleTotal(double capacitéActuelleTotal) {
		CapacitéActuelleTotal = capacitéActuelleTotal;
	}



	/*On vérifie que le code du Ménage exise bien dans la liste des code d'accès*/
    public boolean identifierUtilisateur(int codeAccès) {
        return listeCodeAccès.contains(codeAccès);
    }

    
    
    /*Met la poubelle dans la liste des notifications du centre de tri*/
    public boolean envoyerNotification() {
        return this.centredetri.getNotification().add(this);
    }
    
    
    
    public boolean viderPoubelle() {
    	if(this.listeDéchet.isEmpty()) {
    		return false;//on ne vide pas une poubelle deja vide
    	}
    	this.listeDéchet.clear();
    	return true;
    }


    public double calculQuantité(Dépot depot, TypeDéchet typeDechet) {
		double quantité = 0;
		for(Déchet d:depot.getListeDechets()) {
			if (d.getType().equals(typeDechet)) {
				quantité += d.getPoids();
			}
		}
		return quantité;
	}


    public abstract double verifierTypeDechet(ArrayList<Déchet> listeDechet);


    public abstract int attribuerPoint(ArrayList<Déchet> listeDechet);
	
}
