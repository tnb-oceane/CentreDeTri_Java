package classes_projet;
import java.util.*;

public class PoubelleVerte extends PoubelleIntelligente {
	
	public PoubelleVerte(CentreDeTri centre, long latitude, long longitude, String quartier, double capacitéMaxTotal,
			double capacitéActuelleTotal, double capacitéMaxVerre, double capacitéActuelleVerre) {
		super(centre, latitude, longitude, quartier, capacitéMaxTotal, capacitéActuelleTotal);
		this.capacitéMaxVerre = capacitéMaxVerre;
		this.capacitéActuelleVerre = capacitéActuelleVerre;
	}
	
	

	private double capacitéMaxVerre;

    private double capacitéActuelleVerre;

    private static TypeDéchet typeDéchetAcceptéVerte = TypeDéchet.VERRE;

    
    
    public double getCapacitéMaxVerre() {
        return this.capacitéMaxVerre;
    }

    public double getCapacitéActuelleVerre() {
        return this.capacitéActuelleVerre;
    }

    public static TypeDéchet getTypeDéchetAccepté() {
		return typeDéchetAcceptéVerte;
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
			if (!d.getType().equals(typeDéchetAcceptéVerte)) {
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
