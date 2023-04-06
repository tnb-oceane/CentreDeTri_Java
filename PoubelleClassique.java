package classes_projet;
import java.util.*;

public class PoubelleClassique extends PoubelleIntelligente {

	public PoubelleClassique(CentreDeTri centre, long latitude, long longitude, String quartier,
			double capacitéMaxTotal, double capacitéMaxAutre) {
		super(centre, latitude, longitude, quartier, capacitéMaxTotal);
	}


    private static TypeDéchet typeDéchetAcceptéClassique = TypeDéchet.AUTRE;
    
    

    public static TypeDéchet getTypeDéchetAccepté() {
		return typeDéchetAcceptéClassique;
	}

    
    
    @Override
	public double verifierTypeDechet(ArrayList<Déchet> listeDechet) {
		double compteurPénalité=0;
		double point=0;
		for(Déchet d: listeDechet) {
			if (!d.getType().equals(typeDéchetAcceptéClassique)) {
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
		return "PoubelleBleue [centredetri=" + centredetri.getNom() + ", identifiant=" + identifiant + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", quartier=" + quartier + ", CapacitéMaxTotal=" + CapacitéMaxTotal
				+ ", CapacitéActuelleTotal=" + CapacitéActuelleTotal + ", placer=" + placer + ", listeDéchet="
				+ listeDéchet + ", listeMénages=" + listeMénages + "]";
	}
	
}
