package classes_projet;
import java.util.*;

public class PoubelleBleue extends PoubelleIntelligente {

    
    public PoubelleBleue(CentreDeTri centre, long latitude, long longitude, String quartier, double capacitéMaxTotal) {
		super(centre, latitude, longitude, quartier, capacitéMaxTotal);
		// TODO Auto-generated constructor stub
	}


	private static TypeDéchet typeDéchetAcceptéBleue = TypeDéchet.PAPIER;
	
	

	public static TypeDéchet getTypeDéchetAccepté() {
		return typeDéchetAcceptéBleue;
	}
	
	
	
	@Override
	public double verifierTypeDechet(ArrayList<Déchet> listeDechet) {
		double compteurPénalité=0;
		double point=0;
		for(Déchet d: listeDechet) {
			if (!d.getType().equals(typeDéchetAcceptéBleue)) {
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
