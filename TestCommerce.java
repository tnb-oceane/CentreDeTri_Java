package project_test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import project_class.*;


public class TestCommerce {

public static void main(String[] args) {
    	
        // Création objet centre de tri
        CentreDeTri centreDeTri = new CentreDeTri("Centre de tri 1", "avenue du parc", 2);
        
        
        // Création d'un objet Commerce
        Commerce commerce1 = new Commerce("commerce1", new ArrayList<String>());
        System.out.println("Les caracteristiques du commerce sont :");
        System.out.println(commerce1 + "\n");
        
        
        // Ajout de catégories de produits vendus
        System.out.println("On ajoute des categorie de produit au commerce:");
        commerce1.ajouterCategorie("morceaux de verre");
        commerce1.ajouterCategorie("morceaux de tissu");
        System.out.println(commerce1.getListeCategorieProduitVendu() + "\n");
        
        
        //Suppression d'une catégorie
        System.out.println("On supprime une categorie de produit du commerce:");
        commerce1.supprimerCategorie("morceaux de tissu");
        System.out.println(commerce1.getListeCategorieProduitVendu() + "\n");
        

        //Création d'un objet Calendar pour la date de fin
        Calendar calDebut = Calendar.getInstance(); //crée un nouvel objet Calendar en utilisant la méthode statique getInstance() de la classe Calendar. Cela renvoie un objet Calendar représentant la date et l'heure actuelles du système.
        calDebut.set(Calendar.YEAR, 2022); 
        calDebut.set(Calendar.MONTH, Calendar.NOVEMBER); 
        calDebut.set(Calendar.DAY_OF_MONTH, 1); 
        Date dateDebut = calDebut.getTime(); //ligne obtient la date de début sous forme d'objet Date en utilisant la méthode getTime() de l'objet Calendar. Cela renvoie un objet Date représentant la date de début spécifiée dans l'objet Calendar.

        //Création d'un objet Calendar pour la date de fin
        Calendar calFin = Calendar.getInstance();
        calFin.set(Calendar.YEAR, 2023); 
        calFin.set(Calendar.MONTH, Calendar.APRIL); 
        calFin.set(Calendar.DAY_OF_MONTH, 1); 
        Date dateFin = calFin.getTime();

        
        // Création d'un contrat avec les valeurs spécifiées
        Contrat contrat1 = new Contrat(dateDebut, dateFin, 100, commerce1.getListeCategorieProduitVendu(), 100, 100, new ArrayList<TypeBon>(), centreDeTri, commerce1);
        contrat1.getTypeBonAdmissible().add(TypeBon.ACHAT);
        commerce1.getListeContrats().add(contrat1);
        System.out.println("On cree un contrat expire au commerce :");
        System.out.println(commerce1.getListeContrats() + "\n");
        
        // Renouvellement du contrat
        System.out.println("On renouvelle le contrat pour 12 mois :");
        System.out.println("contrat1 est il renouvelle ? " + commerce1.renouvelerContrat(1,12));
        System.out.println(commerce1.getListeContrats() + "\n");
        
        
        // Publier un bon
        System.out.println("On publie un bon accepte dans le contrat :");
        ArrayList<String> produitsConcernes = new ArrayList<String>();
        produitsConcernes.add("bureau");
        System.out.println("Le bon a t-il ete publier ? " + commerce1.publierBon(TypeBon.ACHAT, 10, 1, produitsConcernes, dateDebut));
        System.out.println(commerce1.getListeBons()+ "\n"); 
        
        
        System.out.println("On publie un bon non accepte dans le contrat :");
        System.out.println("Le bon a t-il ete publier ? " + commerce1.publierBon(TypeBon.REDUCTION, 10, 1, produitsConcernes, dateDebut));
        System.out.println(commerce1.getListeBons()+ "\n");
    }

}
