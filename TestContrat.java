package classes_projet;
import java.util.*;

public class TestContrat {

	public static void main(String[] args) {
		// Création d'un centre de tri
        CentreDeTri centreDeTri = new CentreDeTri("Centre de tri 1", "avenue du parc", 2);

        // Création d'une liste de catégories de produits vendus
        ArrayList<String> listeCategorieProduitVendu = new ArrayList<>();
        listeCategorieProduitVendu.add("metal");
        listeCategorieProduitVendu.add("bois");
        listeCategorieProduitVendu.add("fer");

        // Création d'un commerce 
        Commerce commerce = new Commerce("Mon Commerce", listeCategorieProduitVendu);

        // Création de deux types de bons admissibles
        ArrayList<TypeBon> typeBonAdmissible = new ArrayList<TypeBon>();
        typeBonAdmissible.add(TypeBon.ACHAT);
        typeBonAdmissible.add(TypeBon.REDUCTION);

        //Création d'un objet Calendar pour la date de début
        Calendar calDebut = Calendar.getInstance(); //crée un nouvel objet Calendar en utilisant la méthode statique getInstance() de la classe Calendar. Cela renvoie un objet Calendar représentant la date et l'heure actuelles du système.
        calDebut.set(Calendar.YEAR, 2022); 
        calDebut.set(Calendar.MONTH, Calendar.NOVEMBER); 
        calDebut.set(Calendar.DAY_OF_MONTH, 1); 

        Date dateDebut = calDebut.getTime(); //ligne obtient la date de début sous forme d'objet Date en utilisant la méthode getTime() de l'objet Calendar. Cela renvoie un objet Date représentant la date de début spécifiée dans l'objet Calendar.

        // Création d'un objet Calendar pour la date de fin
        Calendar calFin = Calendar.getInstance();
        calFin.set(Calendar.YEAR, 2023); 
        calFin.set(Calendar.MONTH, Calendar.APRIL); 
        calFin.set(Calendar.DAY_OF_MONTH, 22); 

        // Obtention de la date de fin
        Date dateFin = calFin.getTime();

        // Création d'un contrat avec les valeurs spécifiées
        Contrat contrat1 = new Contrat(dateDebut, dateFin, 100, listeCategorieProduitVendu, 100, 100,
        		typeBonAdmissible, centreDeTri, commerce);
       
        //Création d'un contrat expirer
        Contrat contrat2 = new Contrat(new Date(), new Date(), 100, listeCategorieProduitVendu, 100, 100,
        		typeBonAdmissible, centreDeTri, commerce);
        
        // Affichage des informations du contrat
        System.out.println(contrat1 + "\n");

        // Renouvellement de trois mois du contrat
        boolean renouvellement = contrat1.renouvelerContrat(3);
        if (renouvellement) {
            System.out.println("Le contrat 1 a été renouvelé avec succès.\n");
        } else {
            System.out.println("Le contrat 1 n'a pas été renouvelé car il n'est pas expiré.\n");
        }
        
        boolean renouvellement2 = contrat2.renouvelerContrat(3);
        if (renouvellement2) {
            System.out.println("Le contrat 2 a été renouvelé avec succès.\n");
        } else {
            System.out.println("Le contrat 2 n'a pas été renouvelé car il n'est pas expiré.\n");
        }
        
        // Affichage des informations du contrat renouvellé
        System.out.println(contrat2);
        

	}

}
