package classes_projet;

import java.util.ArrayList;
import java.util.Date;

public class TestMenage {

    public static void main(String[] args) {
        // Créer un centre de tri
        CentreDeTri tri123 = new CentreDeTri("TRI123", "addresseCentre",10);

        // Créer un ménage
        Ménage menage1 = new Ménage();

        // Créer un compte pour le ménage
        menage1.creerCompte("password123", tri123);

        // Créer un commerce
        Commerce commerce1 = new Commerce("COM1", "Boulangerie");

        // Créer une liste de produits concernés
        ArrayList<String> produitsConcernes = new ArrayList<>();
        produitsConcernes.add("Pain");
        produitsConcernes.add("Croissant");

        // Créer une date d'émission et une date limite
        Date dateEmission = new Date();
        Date dateLimite = new Date(dateEmission.getTime() + (1000 * 60 * 60 * 24 * 7)); // Date limite dans une semaine

        // Créer un bon
        Bon bon1 = new Bon(TypeBon.REDUCTION, 5, 10, commerce1, dateEmission, dateLimite, produitsConcernes, true);

        // Ajouter des points au ménage
        menage1.setPoint(15);

        // Acheter un bon
        menage1.acheterBon(bon1);

        // Créer un achat
        Achat achat1 = new Achat(15, menage1, commerce1);

        // Utiliser un bon pour un achat
        menage1.utiliserBon(bon1, achat1);

        // Afficher les informations du ménage
        System.out.println(menage1.toString());
    }
}
