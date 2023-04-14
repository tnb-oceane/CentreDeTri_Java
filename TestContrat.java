package project_test;
import java.util.*;
import project_class.*;

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
        Date dateFin = calFin.getTime();

        
        // Création d'un contrat avec les valeurs spécifiées
        Contrat contrat1 = new Contrat(dateDebut, dateFin, 100, listeCategorieProduitVendu, 100, 100,
        		typeBonAdmissible, centreDeTri, commerce);
        System.out.println("Les caracteristiques du contrat1 sont :");
        System.out.println(contrat1 + "\n");
       
        
        //Création d'un contrat expirer
        Contrat contrat2 = new Contrat(dateDebut, dateDebut, 100, listeCategorieProduitVendu, 100, 100,
        		typeBonAdmissible, centreDeTri, commerce);
        System.out.println("Les caracteristiques du contrat2 sont :");
        System.out.println(contrat2 + "\n");
        
        
        
        // Renouvellement de trois mois des contrats
        System.out.println("Le contrat1 a t-il ete renouvelle ? " + contrat1.renouvelerContrat(3));
        System.out.println(contrat1 + "\n"); 
        
        System.out.println("Le contrat2 a t-il ete renouvelle ? " + contrat2.renouvelerContrat(3));
        System.out.println(contrat2 + "\n"); 
 

	}

}
