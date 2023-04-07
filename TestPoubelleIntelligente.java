package classes_projet;
import java.util.*;

public class TestPoubelleIntelligente {

	public static void main(String[] args) {
		
		//On crée un centre de tri et des poubelles et un ménage
		CentreDeTri tri123 = new CentreDeTri("TRI123", "addresseCentre",10);
		
		Ménage menage = new Ménage();
		
		PoubelleBleue Pb = new PoubelleBleue(tri123, 0, 1, "Quartier1", 15);
		PoubelleVerte Pv = new PoubelleVerte(tri123, 0, 2, "Quartier1", 15);
		PoubelleJaune Pj = new PoubelleJaune(tri123, 0, 3, "Quartier1", 15);
		PoubelleClassique Pc = new PoubelleClassique(tri123, 0, 4, "Quartier1", 15);
		System.out.println(tri123.getListePoubelles()+ "\n");
		
		//On vérifie les types de dechets accepté
		System.out.println(PoubelleBleue.getTypeDéchetAccepté());
		System.out.println(PoubelleVerte.getTypeDéchetAccepté());
		System.out.println(PoubelleJaune.getTypeDéchetAccepté());
		System.out.println(PoubelleClassique.getTypeDéchetAccepté()+ "\n");
		
		//On identifie le ménage
		System.out.println(menage.getCodeAcces());
		menage.creerCompte("mdp1234567", tri123);
		System.out.println(menage.getCodeAcces());
		System.out.println(PoubelleIntelligente.getListeCodeAccès());
		System.out.println(Pb.identifierUtilisateur(menage.getCodeAcces()));
		System.out.println(Pj.identifierUtilisateur(menage.getCodeAcces())+ "\n");
		
		//On remplie la poubelle
		Déchet dechetVerre = new Déchet(TypeDéchet.VERRE,4);
		Déchet dechetAutre = new Déchet(TypeDéchet.AUTRE,2);
		ArrayList<Déchet> listedechet = new ArrayList<Déchet>();
		listedechet.add(dechetVerre);
		listedechet.add(dechetAutre);
		System.out.println(listedechet);
		menage.jeterDechet(listedechet, Pv);
		System.out.println(menage.getListeDépots());
		System.out.println("Capacité actuelle : "+Pv.getCapacitéActuelleTotal() +", Depot : "+Pv.getListeDépots()+ "\n");
		
		//On calcule la quantité de dechet de type Verre
		System.out.println(Pv.calculQuantité(Pv.getListeDépots().get(0), TypeDéchet.AUTRE));
		System.out.println(Pv.calculQuantité(Pv.getListeDépots().get(0), TypeDéchet.VERRE)+ "\n");
		
		//On vide la poubelle
		System.out.println(Pv.getListeDéchet());
		Pv.viderPoubelle();
		System.out.println(Pv.getListeDéchet()+ "\n");

		//On envoie une notification
		Pc.envoyerNotification();
		tri123.voirNotification();
	}

}
