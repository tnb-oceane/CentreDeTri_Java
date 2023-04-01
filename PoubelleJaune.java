package classes_projet;
import java.util.*;

public class PoubelleJaune extends PoubelleIntelligente {
	
	
	private double capacitéMaxEmballage;

    private double capacitéMaxCarton;

    private double capacitéMaxPlastique;

    private double capacitéMaxCanetteConserve;

    private double capacitéActuelleEmballage;

    private double capacitéActuelleCarton;

    private double capacitéActuellePlastique;

    private double capacitéActuelleCanetteConserve;

    private static List<TypeDéchet> typeDéchetAccepté = List.of(TypeDéchet.EMBALLAGE,TypeDéchet.CARTON,TypeDéchet.PLASTIQUE,TypeDéchet.CONSERVECANETTE);
	
   
    

	public PoubelleJaune(CentreDeTri centre, long latitude, long longitude, String quartier, double capacitéMaxTotal,
			double capacitéMaxEmballage, double capacitéMaxCarton, double capacitéMaxPlastique,
			double capacitéMaxCanetteConserve) {
		super(centre, latitude, longitude, quartier, capacitéMaxTotal);
		this.capacitéMaxEmballage = capacitéMaxEmballage;
		this.capacitéMaxCarton = capacitéMaxCarton;
		this.capacitéMaxPlastique = capacitéMaxPlastique;
		this.capacitéMaxCanetteConserve = capacitéMaxCanetteConserve;
		this.capacitéActuelleEmballage = capacitéMaxEmballage;
		this.capacitéActuelleCarton = capacitéMaxCarton;
		this.capacitéActuellePlastique = capacitéMaxPlastique;
		this.capacitéActuelleCanetteConserve = capacitéMaxCanetteConserve;
	}

   

	
	public double getCapacitéMaxEmballage() {
		return capacitéMaxEmballage;
	}

	public double getCapacitéMaxCarton() {
		return capacitéMaxCarton;
	}

	public double getCapacitéMaxPlastique() {
		return capacitéMaxPlastique;
	}

	public double getCapacitéMaxCanetteConserve() {
		return capacitéMaxCanetteConserve;
	}

	public double getCapacitéActuelleEmballage() {
		return capacitéActuelleEmballage;
	}

	public double getCapacitéActuelleCarton() {
		return capacitéActuelleCarton;
	}

	public double getCapacitéActuellePlastique() {
		return capacitéActuellePlastique;
	}

	public double getCapacitéActuelleCanetteConserve() {
		return capacitéActuelleCanetteConserve;
	}

	public static List<TypeDéchet> getTypeDéchetAccepté() {
		return typeDéchetAccepté;
	}

	
	
	
	@Override
	public double verifierTypeDechet(ArrayList<Déchet> listeDechet) {
		double compteurPénalité=0;
		double point=0;
		for(Déchet d: listeDechet) {
			if (!typeDéchetAccepté.contains(d.getType())) {
				compteurPénalité+=d.getPoids();
			}
			else {
				point++;
			}
		}
		return (point - compteurPénalité);
	}

	@Override
	public int attribuerPoint(ArrayList<Déchet> listeDechet) {
		double point = this.verifierTypeDechet(listeDechet)*this.centredetri.getPointParGrammeDechet();
		return (int)point;
	}

	@Override
	public String toString() {
		return "PoubelleJaune [capacitéMaxEmballage=" + capacitéMaxEmballage + ", capacitéMaxCarton="
				+ capacitéMaxCarton + ", capacitéMaxPlastique=" + capacitéMaxPlastique + ", capacitéMaxCanetteConserve="
				+ capacitéMaxCanetteConserve + ", capacitéActuelleEmballage=" + capacitéActuelleEmballage
				+ ", capacitéActuelleCarton=" + capacitéActuelleCarton + ", capacitéActuellePlastique="
				+ capacitéActuellePlastique + ", capacitéActuelleCanetteConserve=" + capacitéActuelleCanetteConserve
				+ ", centredetri=" + centredetri.getNom() + ", identifiant=" + identifiant + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", quartier=" + quartier + ", CapacitéMaxTotal=" + CapacitéMaxTotal
				+ ", CapacitéActuelleTotal=" + CapacitéActuelleTotal + ", placer=" + placer + ", listeDéchet="
				+ listeDéchet + "]\n";
	}
	
	

}
