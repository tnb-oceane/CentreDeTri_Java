package classes_projet;
import java.util.*;

public class Dépot {	

	private long identifiant;

    private Date dateHeure;

    private double quantitéDechet;

    private int pointGagné;
    
    private Ménage menage;
    
    private PoubelleIntelligente poubelle;

    private static long suiviIdentifiant;
    
    /*Les déchets jeter lors du dépot*/
    private ArrayList<Déchet> listeDechets;
    
    
    
    public Dépot(ArrayList<Déchet> listeDechets, Ménage menage, PoubelleIntelligente poubelle,int pointGagné) {
		super();
		this.identifiant = suiviIdentifiant;
		this.dateHeure = new Date();
		this.quantitéDechet = 0;
		for (Déchet d : listeDechets) {
			this.quantitéDechet += d.getPoids();
		}
		
		poubelle.setCapacitéActuelleTotal(poubelle.CapacitéActuelleTotal-this.quantitéDechet);
		
		this.pointGagné = pointGagné;
		this.listeDechets = listeDechets;
		this.menage = menage;
		this.poubelle = poubelle;
		
		/*On incrémente suiviIdentifiant de 1 car les identifiants sont unique*/
		suiviIdentifiant += 1;
		
		this.menage.getListeDépots().add(this);
		this.poubelle.getListeDépots().add(this);
	}
    
    

	public long getIdentifiant() {
		return identifiant;
	}

	public Date getDateHeure() {
		return dateHeure;
	}

	public double getQuantitéDechet() {
		return quantitéDechet;
	}

	public int getPointGagné() {
		return pointGagné;
	}
	
	public static long getSuiviIdentifiant() {
		return suiviIdentifiant;
	}

	public ArrayList<Déchet> getListeDechets() {
		return listeDechets;
	}

	public PoubelleIntelligente getPoubelle() {
		return poubelle;
	}

	public Ménage getMenage() {
		return menage;
	}



	@Override
	public String toString() {
		return "Dépot [identifiant=" + identifiant + ", dateHeure=" + dateHeure + ", quantitéDechet=" + quantitéDechet
				+ ", pointGagné=" + pointGagné + ", menage=" + menage.getIdentifiant() + ", poubelle=" + poubelle.getIdentifiant() + ", listeDechets="
				+ listeDechets + "]";
	}

	
}


