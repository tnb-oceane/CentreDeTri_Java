package classes_projet;
import java.util.*;

public class PoubelleClassique extends PoubelleIntelligente {

	public PoubelleClassique(CentreDeTri centre, long latitude, long longitude, String quartier,
			double capacitéMaxTotal, double capacitéActuelleTotal, double capacitéMaxAutre,
			double capacitéActuelleAutre) {
		super(centre, latitude, longitude, quartier, capacitéMaxTotal, capacitéActuelleTotal);
		this.capacitéMaxAutre = capacitéMaxAutre;
		this.capacitéActuelleAutre = capacitéActuelleAutre;
	}
	

	private double capacitéMaxAutre;

    private double capacitéActuelleAutre;

    private static TypeDéchet typeDéchetAcceptéClassique = TypeDéchet.AUTRE;
    
    

    public double getCapacitéMaxAutre() {
        return this.capacitéActuelleAutre;
    }

    public double getCapacitéActuelleAutre() {
        return this.capacitéActuelleAutre;
    }

    public static TypeDéchet getTypeDéchetAccepté() {
		return typeDéchetAcceptéClassique;
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
			if (!d.getType().equals(typeDéchetAcceptéClassique)) {
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
