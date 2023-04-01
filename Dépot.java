package classes_projet;
import java.util.*;

public class Dépot {

	public Dépot(ArrayList<Déchet> listeDechets) {
		super();
		this.identifiant = suiviIdentifiant;
		this.dateHeure = new Date();
		this.quantitéDechet = 0.0;
		this.pointGagné = 0;
		this.listeDechets = listeDechets;
		
		/*On incrémente suiviIdentifiant de 1 car les identifiants sont unique*/
		suiviIdentifiant += 1;
	}
	
	

	private long identifiant;

    private Date dateHeure;

    private double quantitéDechet;

    private int pointGagné;

    private static ArrayList<Dépot> listeDepots;

    private static long suiviIdentifiant;
    
    /*Les déchets jeter lors du dépot*/
    private ArrayList<Déchet> listeDechets;
    
    

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

	public static ArrayList<Dépot> getListeDepots() {
		return listeDepots;
	}
	
	public static long getSuiviIdentifiant() {
		return suiviIdentifiant;
	}

	public ArrayList<Déchet> getListeDechets() {
		return listeDechets;
	}

}
