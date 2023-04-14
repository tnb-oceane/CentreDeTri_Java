package project_test;
import java.util.*;
import project_class.*;


public class TestMénage {

	public static void main(String[] args) {
		
		// Créer un centre de tri
        CentreDeTri tri123 = new CentreDeTri("TRI123", "addresseCentre", 10);

        
        // Créer un ménage
        Ménage menage1 = new Ménage();
        System.out.println("Les caracteristiques du menage sont :");
        System.out.println(menage1 + "\n");

        
        // Créer un compte pour le ménage
        System.out.println("Le menage cree un compte et obtient un code d'acces :");
        menage1.creerCompte("password123", tri123);
        System.out.println(menage1 + "\n");


        // Créer un commerce
        ArrayList<String> produitsConcernes = new ArrayList<>();
        produitsConcernes.add("Pain");
        produitsConcernes.add("Croissant");
        Commerce abc123 = new Commerce("ABC123", produitsConcernes);

        
        // Créer une date d'émission et une date limite
        Date dateEmission = new Date();
        Date dateLimite = new Date(dateEmission.getTime() + (1000 * 60 * 60 * 24 * 7)); // Date limite dans une semaine

        
        // Créer un bon
        Bon bon1 = new Bon(TypeBon.ACHAT, 5, 25, abc123, dateEmission, dateLimite, produitsConcernes, true);
        ArrayList<Bon> listebon = new ArrayList<Bon>();
        listebon.add(bon1);
        
        // Ajouter des points au ménage pour acheter un bon
        menage1.setPoint(15);
        System.out.println("Le menage n'a pas assez de point pour acheter le bon :");
        System.out.println("Le bon a t-il ete achete ? "+ menage1.acheterBon(bon1));
        System.out.println(menage1.getListeBons()+"\n");
        
        menage1.setPoint(25);
        System.out.println("Le menage a assez de point :");
        System.out.println("Le bon a t-il ete achete ? "+ menage1.acheterBon(bon1));
        System.out.println(menage1.getListeBons()+"\n");
        
        
        // Créer un achat
        System.out.println("Le menage fait un achat de 15 euros avec le bon1 :");
        menage1.faireAchat(15,abc123, listebon,produitsConcernes);
        System.out.println(menage1.getListeAchats()+"\n");


        // Utiliser un bon pour un achat
        System.out.println("Le menage utilise a nouveaux le bon :");
        System.out.println("Le bon est il utilise une deuxieme fois ? "+menage1.utiliserBon(bon1, menage1.getListeAchats().get(0)));

       

	}

}
