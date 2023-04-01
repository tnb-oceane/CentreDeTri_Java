package classes_projet;
import java.util.*;

public class PoubelleBleue extends PoubelleIntelligente {
	
    public PoubelleBleue(CentreDeTri centre, long latitude, long longitude, String quartier, double capacitéMaxTotal,
			double capacitéActuelleTotal, double capacitéMaxPapier, double capacitéActuellePapier) {
		super(centre, latitude, longitude, quartier, capacitéMaxTotal, capacitéActuelleTotal);
		this.capacitéMaxPapier = capacitéMaxPapier;
		this.capacitéActuellePapier = capacitéActuellePapier;
	}
    

	private double capacitéMaxPapier;

    private double capacitéActuellePapier;
    
    private static TypeDéchet typeDéchetAcceptéBleue = TypeDéchet.PAPIER;
	
	
    
    
    public double getCapacitéMaxPapier() {
        return this.capacitéMaxPapier;
    }

    public double getCapacitéActuellePapier() {
        return this.capacitéActuellePapier;
    }

	public static TypeDéchet getTypeDéchetAccepté() {
		return typeDéchetAcceptéBleue;
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
			if (!d.getType().equals(typeDéchetAcceptéBleue)) {
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
