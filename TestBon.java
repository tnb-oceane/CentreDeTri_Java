package project_test;
import java.util.*;
import project_class.*;

public class TestBon {

	public static void main(String[] args) {
		
		// Créer un commerce
		ArrayList<String> produitsConcernés = new ArrayList<>();
		produitsConcernés.add("Pain");
		produitsConcernés.add("Croissant");
		Commerce abc123 = new Commerce("ABC123", produitsConcernés);
	
		
		// Créer une date d'émission et une date limite
		Date dateEmission = new Date();
		Date dateLimite = new Date(dateEmission.getTime() + (1000 * 60 * 60 * 24 * 7)); // Date limite dans une semaine
		
		// Créer un bon
		Bon bon1 = new Bon(TypeBon.REDUCTION, 5, 10, abc123, dateEmission, dateLimite, produitsConcernés, true);
		System.out.println("Les caracteristiques du bon sont : ");
		System.out.println(bon1+ "\n");
		
		
		// Vérifier si le bon est toujours actif
		System.out.println("Le bon1 est correcte : ");
		System.out.println("Le bon1 est-il actif ? " + bon1.isActif()+ "\n");
		
		// Simuler un bon expiré
		System.out.println("Le bon2 est expire : ");
		Bon bon2 = new Bon(TypeBon.REDUCTION, 5, 10, abc123, dateEmission, new Date(), produitsConcernés, true);
		System.out.println("Le bon2 est-il actif ? " + bon2.isActif()+ "\n");
		
		// Simuler dont tous les produit ne sont pas vendu par le commerce
		System.out.println("Tous les produits du bon3 ne sont pas vendu par le commerce : ");
		ArrayList<String> produitNonVendu = new ArrayList<>();
		produitNonVendu.add("Café");
		produitNonVendu.add("Croissant");
		Bon bon3 = new Bon(TypeBon.REDUCTION, 5, 10, abc123, dateEmission, dateLimite, produitNonVendu, true);
		System.out.println("Le bon3 est-il actif ? " + bon3.isActif()+ "\n");

	}

}
