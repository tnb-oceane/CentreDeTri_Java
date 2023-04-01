package classes_projet;
import java.util.*;

public class PoubelleVerte extends PoubelleIntelligente {

	public PoubelleVerte(CentreDeTri centre, long latitude, long longitude, String quartier, double capacitéMaxTotal) {
		super(centre, latitude, longitude, quartier, capacitéMaxTotal);
	}


    private static TypeDéchet typeDéchetAcceptéVerte = TypeDéchet.VERRE;

    

    public static TypeDéchet getTypeDéchetAccepté() {
		return typeDéchetAcceptéVerte;
	}

    

    @Override
	public double verifierTypeDechet(ArrayList<Déchet> listeDechet) {
		double compteurPénalité=0;
		double point=0;
		for(Déchet d: listeDechet) {
			if (!d.getType().equals(typeDéchetAcceptéVerte)) {
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


}
