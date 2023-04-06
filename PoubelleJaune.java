package classes_projet;
import java.util.*;

public class PoubelleJaune extends PoubelleIntelligente {
	

    private static List<TypeDéchet> typeDéchetAccepté = List.of(TypeDéchet.EMBALLAGE,TypeDéchet.CARTON,TypeDéchet.PLASTIQUE,TypeDéchet.CONSERVECANETTE);
	
    

	public PoubelleJaune(CentreDeTri centre, long latitude, long longitude, String quartier, double capacitéMaxTotal) {
		super(centre, latitude, longitude, quartier, capacitéMaxTotal);
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
		return "PoubelleBleue [centredetri=" + centredetri.getNom() + ", identifiant=" + identifiant + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", quartier=" + quartier + ", CapacitéMaxTotal=" + CapacitéMaxTotal
				+ ", CapacitéActuelleTotal=" + CapacitéActuelleTotal + ", placer=" + placer + ", listeDéchet="
				+ listeDéchet + ", listeMénages=" + listeMénages + "]";
	}

}
	
	


