package classes_projet;

import java.util.ArrayList;
import java.util.Date;

public class TestBon {

	public static void main(String[] args) {
		// Créer un commerce
		Commerce commerce1 = new Commerce("COM1", "Boulangerie");
		
		// Créer une liste de produits concernés
		ArrayList<String> produitsConcernés = new ArrayList<>();
		produitsConcernés.add("Pain");
		produitsConcernés.add("Croissant");
		
		// Créer une date d'émission et une date limite
		Date dateEmission = new Date();
		Date dateLimite = new Date(dateEmission.getTime() + (1000 * 60 * 60 * 24 * 7)); // Date limite dans une semaine
		
		// Créer un bon
		Bon bon1 = new Bon(TypeBon.REDUCTION, 5, 10, commerce1, dateEmission, dateLimite, produitsConcernés, true);
		
		// Afficher les informations du bon
		System.out.println(bon1.toString());
		
		// Vérifier si le bon est toujours actif
		System.out.println("Le bon est-il actif ? " + bon1.isActif());
		
		// Simuler l'expiration du bon
		Date dateExpiree = new Date(dateEmission.getTime() - (1000 * 60 * 60 * 24 * 7));
		bon1.setDateLimite(dateExpiree);
		System.out.println("Le bon est-il actif ? " + bon1.isActif());
	}
}
