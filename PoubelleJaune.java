package classes_projet;
import java.util.*;

public class PoubelleJaune extends PoubelleIntelligente {


    

	public PoubelleJaune(CentreDeTri centre, long latitude, long longitude, String quartier, double capacitéMaxTotal,
			double capacitéActuelleTotal, double capacitéMaxEmballage, double capacitéMaxCarton,
			double capacitéMaxPlastique, double capacitéMaxCanetteConserve, double capacitéActuelleEmballage,
			double capacitéActuelleCarton, double capacitéActuellePlastique, double capacitéActuelleCanetteConserve) {
		super(centre, latitude, longitude, quartier, capacitéMaxTotal, capacitéActuelleTotal);
		this.capacitéMaxEmballage = capacitéMaxEmballage;
		this.capacitéMaxCarton = capacitéMaxCarton;
		this.capacitéMaxPlastique = capacitéMaxPlastique;
		this.capacitéMaxCanetteConserve = capacitéMaxCanetteConserve;
		this.capacitéActuelleEmballage = capacitéActuelleEmballage;
		this.capacitéActuelleCarton = capacitéActuelleCarton;
		this.capacitéActuellePlastique = capacitéActuellePlastique;
		this.capacitéActuelleCanetteConserve = capacitéActuelleCanetteConserve;
	}

	private double capacitéMaxEmballage;

    private double capacitéMaxCarton;

    private double capacitéMaxPlastique;

    private double capacitéMaxCanetteConserve;

    private double capacitéActuelleEmballage;

    private double capacitéActuelleCarton;

    private double capacitéActuellePlastique;

    private double capacitéActuelleCanetteConserve;

    private static TypeDéchet[] typeDéchetAccepté = {TypeDéchet.EMBALLAGE,TypeDéchet.CARTON,TypeDéchet.PLASTIQUE,TypeDéchet.CONSERVECANETTE};


    
    

	
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

	public static TypeDéchet[] getTypeDéchetAccepté() {
		return typeDéchetAccepté;
	}

	
	
	@Override
	public double calculQuantité(Dépot depot, String typeDechet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int verifierTypeDechet(Dépot depot) {
		int compteurPénalité=0;
		for(Déchet d: depot.getListeDechets()) {
			if (!d.getType().equals(typeDéchetAccepté.) {
				compteurPénalité+=1;/*A changer en fonction de la pénalité*/
			}
		}
		return compteurPénalité;
	}

	@Override
	public boolean attribuerPoint(Ménage ménage, int points) {
		// TODO Auto-generated method stub
		return false;
	}

}
