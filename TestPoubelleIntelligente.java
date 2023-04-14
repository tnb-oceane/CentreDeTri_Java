package project_test;
import java.util.*;
import project_class.*;


public class TestPoubelleIntelligente {

	public static void main(String[] args) {
		
		//On crée un centre de tri et des poubelles et un ménage
		CentreDeTri tri123 = new CentreDeTri("TRI123", "addresseCentre",10);
		
		//On crée un ménage
		Ménage menage = new Ménage();
		
		//On crée des poubelles de chaques couleurs
		PoubelleBleue Pb = new PoubelleBleue(tri123, 0, 1, "Quartier1", 15);
		PoubelleVerte Pv = new PoubelleVerte(tri123, 0, 2, "Quartier1", 6);
		PoubelleJaune Pj = new PoubelleJaune(tri123, 0, 3, "Quartier1", 15);
		PoubelleClassique Pc = new PoubelleClassique(tri123, 0, 4, "Quartier1", 15);
		System.out.println("Les poubelles crees sont automatiquement dans la liste des poubelles du centre de tri :");
		System.out.println(tri123.getListePoubelles()+ "\n");
		
		
		//On vérifie les types de dechets accepté
		System.out.println("On verifie les types de dechets accepte :");
		System.out.println(PoubelleBleue.getTypeDéchetAccepté());
		System.out.println(PoubelleVerte.getTypeDéchetAccepté());
		System.out.println(PoubelleJaune.getTypeDéchetAccepté());
		System.out.println(PoubelleClassique.getTypeDéchetAccepté()+ "\n");
		
		
		//On identifie le ménage
		System.out.println("On identifie un message sans compte :");
		System.out.println("Le menage est il identifie ? "+Pb.identifierUtilisateur(menage.getCodeAcces())+ "\n");
		
		System.out.println("On identifie un message avec compte :");
		menage.creerCompte("mdp1234567", tri123);
		System.out.println("Le menage est il identifie ? "+ Pj.identifierUtilisateur(menage.getCodeAcces())+ "\n");
		
		
		//On crée une liste de déchets
		Déchet dechetVerre = new Déchet(TypeDéchet.VERRE,4);
		Déchet dechetAutre = new Déchet(TypeDéchet.AUTRE,2);
		ArrayList<Déchet> listedechet = new ArrayList<Déchet>();
		listedechet.add(dechetVerre);
		listedechet.add(dechetAutre);

		//On rempli la poubelle
		System.out.println("Le menage rempli la poubelle verte :");
		menage.jeterDechet(listedechet, Pv);
		System.out.println("Capacite maximale : "+ Pv.getCapacitéMaxTotal() + ", Capacite actuelle : "+ Pv.getCapacitéActuelleTotal());
		System.out.println("Point gagne : "+ menage.getPoint() + "\n");// 40 points pour le verre et -20 pour autre
		
		
		//On envoie une notification
		System.out.println("La poubelle verte est pleine donc elle envoie une notification au centre de tri :");
		tri123.voirNotification();
		
		
		//On calcule la quantité de dechet de type Verre
		System.out.println("Quantite de dechet dans la poubelle verte :");
		System.out.println("AUTRE : "+Pv.calculQuantité(Pv.getListeDépots().get(0), TypeDéchet.AUTRE));
		System.out.println("VERRE : "+Pv.calculQuantité(Pv.getListeDépots().get(0), TypeDéchet.VERRE)+ "\n");
		
		
		//On vide la poubelle
		System.out.println("Les dechets present dans la poubelles sont :");
		System.out.println(Pv.getListeDéchet()+ "\n");
		
		System.out.println("On vide la poubelle :");
		Pv.viderPoubelle();
		System.out.println(Pv.getListeDéchet()+ "\n");

	}

}
