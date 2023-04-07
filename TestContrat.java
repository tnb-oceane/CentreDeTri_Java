package projetJava;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TestContrat {

    public static void main(String[] args) {

        // Création d'un centre de tri
        CentreDeTri centreDeTri = new CentreDeTri("Centre de tri 1", "avenue du parc", 2);

     // Création d'une liste de catégories de produits vendus
        ArrayList<String> listeCategorieProduitVendu = new ArrayList<>();
        listeCategorieProduitVendu.add("metal");
        listeCategorieProduitVendu.add("bois");
        listeCategorieProduitVendu.add("fer");

        // Création d'un objet Commerce 
        Commerce commerce = new Commerce("Mon Commerce", listeCategorieProduitVendu);

        // Création de deux types de bons admissibles
        TypeBon typeBon1 = TypeBon.ACHAT;
        TypeBon typeBon2 = TypeBon.REDUCTION;

        // // Création d'un objet Calendar pour la date de début
        Calendar calDebut = Calendar.getInstance(); //crée un nouvel objet Calendar en utilisant la méthode statique getInstance() de la classe Calendar. Cela renvoie un objet Calendar représentant la date et l'heure actuelles du système.
        calDebut.set(Calendar.YEAR, 2022); 
        calDebut.set(Calendar.MONTH, Calendar.NOVEMBER); 
        calDebut.set(Calendar.DAY_OF_MONTH, 1); 

        Date dateDebut = calDebut.getTime(); //ligne obtient la date de début sous forme d'objet Date en utilisant la méthode getTime() de l'objet Calendar. Cela renvoie un objet Date représentant la date de début spécifiée dans l'objet Calendar.

        // Création d'un objet Calendar pour la date de fin
        Calendar calFin = Calendar.getInstance();
        calFin.set(Calendar.YEAR, 2023); 
        calFin.set(Calendar.MONTH, Calendar.APRIL); 
        calFin.set(Calendar.DAY_OF_MONTH, 1); 

        // Obtention de la date de fin
        Date dateFin = calFin.getTime();

        // Création d'un contrat avec les valeurs spécifiées
        Contrat contrat1 = new Contrat(dateDebut, dateFin, 100, listeCategorieProduitVendu, 100, 100,
                new ArrayList<TypeBon>(), centreDeTri, commerce);


        // Ajout des types de bons admissibles au contrat
        contrat1.getTypeBonAdmissible().add(typeBon1);
        contrat1.getTypeBonAdmissible().add(typeBon2);

        // Affichage des informations du contrat
        System.out.println(contrat1.toString());

        // Renouvellement du contrat
        boolean renouvellement = contrat1.renouvelerContrat();
        if (renouvellement) {
            System.out.println("Le contrat a été renouvelé avec succès.");
        } else {
            System.out.println("Le contrat n'a pas été renouvelé car il n'est pas expiré.");
        }

       
    }
}
