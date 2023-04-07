package classes_projet;

import java.util.ArrayList;
import java.util.Date;

public class TestAchat {

    public static void main(String[] args) {
        // Créer un ménage
        Ménage menage1 = new Ménage(1, 3);
        
        // Créer un commerce
        Commerce commerce1 = new Commerce("COM1", "Boulangerie");
        
        // Créer un achat
        Achat achat1 = new Achat(15, menage1, commerce1);
        
        // Afficher les informations de l'achat
        System.out.println(achat1.toString());
        
        // Créer une liste de produits concernés
		ArrayList<String> produitsConcernés = new ArrayList<>();
		produitsConcernés.add("Pain");
		produitsConcernés.add("Croissant");

		// Créer une date d'émission et une date limite
		Date dateEmission = new Date();
		Date dateLimite = new Date(dateEmission.getTime() + (1000 * 60 * 60 * 24 * 7)); // Date limite dans une semaine

		// Créer un bon
		Bon bon1 = new Bon(TypeBon.REMISE, 5, 10, commerce1, dateEmission, dateLimite, produitsConcernés, true);
        
        // Ajouter un bon utilisé à l'achat
        achat1.ajouterBonUtilisé(bon1);
        
        // Afficher les informations de l'achat après l'ajout du bon
        System.out.println(achat1.toString());
    }
}
