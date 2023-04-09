package classes_projet;
import java.util.*;

public class PoubelleClassique extends PoubelleIntelligente {

	public PoubelleClassique(CentreDeTri centre, long latitude, long longitude, String quartier,
			double capacitéMaxTotal) {
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
				point+=d.getPoids();
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
		return "PoubelleClassique [centredetri=" + centredetri.getNom() + ", identifiant=" + identifiant + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", quartier=" + quartier + ", CapaciteMaxTotal=" + CapacitéMaxTotal
				+ ", CapaciteActuelleTotal=" + CapacitéActuelleTotal + ", placer=" + placer + ", listeDechet="
				+ listeDéchet + ", listeMenages=" + listeMénages + "]";
	}
	
}
