package classes_projet;
import java.util.*;

public class TestBon {

	public static void main(String[] args) {
		
		// Créer un commerce
		ArrayList<String> produitsConcernés = new ArrayList<>();
		produitsConcernés.add("Pain");
		produitsConcernés.add("Croissant");
		Commerce abc123 = new Commerce("ABC123", produitsConcernés);
		
		//On crée un ménage
		Ménage menage1 = new Ménage();
		
		//On crée un achat
        Achat achat1 = new Achat(15, menage1, abc123,produitsConcernés);
		
		// Créer une date d'émission et une date limite
		Date dateEmission = new Date();
		Date dateLimite = new Date(dateEmission.getTime() + (1000 * 60 * 60 * 24 * 7)); // Date limite dans une semaine
		
		// Créer un bon
		Bon bon1 = new Bon(TypeBon.REDUCTION, 5, 10, abc123, dateEmission, dateLimite, produitsConcernés, true);
		bon1.setMenage(menage1);
		bon1.setAchat(achat1);
		
		// Afficher les informations du bon
		System.out.println(bon1+ "\n");
		
		// Vérifier si le bon est toujours actif
		System.out.println("Le bon est-il actif ? " + bon1.isActif()+ "\n");
		
		// Simuler un bon expiré
		Bon bon2 = new Bon(TypeBon.REDUCTION, 5, 10, abc123, dateEmission, new Date(), produitsConcernés, true);
		bon2.setMenage(menage1);
		bon2.setAchat(achat1);
		System.out.println("Le bon est-il actif ? " + bon2.isActif()+ "\n");
		
		// Simuler un bon expiré dont tous les produit ne sont pas vendu par le commerce
		ArrayList<String> produitNonVendu = new ArrayList<>();
		produitNonVendu.add("Café");
		produitNonVendu.add("Croissant");
		Bon bon3 = new Bon(TypeBon.REDUCTION, 5, 10, abc123, dateEmission, dateLimite, produitNonVendu, true);
		bon3.setMenage(menage1);
		bon3.setAchat(achat1);
		System.out.println("Le bon est-il actif ? " + bon3.isActif()+ "\n");

	}

}
