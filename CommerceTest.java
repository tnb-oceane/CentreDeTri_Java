package projetJava;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TestCommerce {

    public static void main(String[] args) {
    	
        // Création objet centre de tri
        CentreDeTri centreDeTri = new CentreDeTri("Centre de tri 1", "avenue du parc", 2);
        
        
        
        // Création d'un objet Commerce
        Commerce commerce1 = new Commerce("commerce1", new ArrayList<String>());
        
        
        // Ajout de catégories de produits vendus
        commerce1.ajouterCategorie("morceaux de verre");
        commerce1.ajouterCategorie("morceaux de tissu");
        
        // Vérification que les catégories ont bien été ajoutées
        ArrayList<String> categories = commerce1.getListeCategorieProduitVendu();
        System.out.println("Catégories du commerce1 : " + categories.toString());
        
        // Suppression d'une catégorie
        commerce1.supprimerCategorie("morceaux de tissu");
        
        // Vérification que la catégorie a bien été supprimée
        categories = commerce1.getListeCategorieProduitVendu();
        System.out.println("Catégories du commerce1 après suppression : " + categories.toString());
        
        // Création de deux types de bons admissibles
        TypeBon typeBon1 = TypeBon.ACHAT;
        TypeBon typeBon2 = TypeBon.REDUCTION;

        // // Création d'un objet Calendar pour la date de fin
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
        Contrat contrat1 = new Contrat(dateDebut, dateFin, 100, commerce1.getListeCategorieProduitVendu(), 100, 100, new ArrayList<TypeBon>(), centreDeTri, commerce1); // Utilisation de commerce1.getListeCategorieProduitVendu() pour obtenir la liste des catégories de produits vendus


        // Ajout des types de bons admissibles au contrat
        contrat1.getTypeBonAdmissible().add(typeBon1);
        contrat1.getTypeBonAdmissible().add(typeBon2);
        
        
        System.out.println(contrat1.toString());
        
        
        // Ajout du contrat au commerce1
        commerce1.getListeContrats().add(contrat1);
        
        // Renouvellement du contrat
        boolean renouvellement = commerce1.renouvelerContrat(1);
        System.out.println("Renouvellement du contrat1 : " + renouvellement);
        
        // Création d'un bon
        ArrayList<String> produitsConcernes = new ArrayList<String>();
        produitsConcernes.add("bureau");
        Bon bon1 = new Bon(TypeBon.ACHAT, 10, 100, commerce1, dateDebut, dateFin, produitsConcernes, true);
        
        // Publication du bon
        boolean publication = commerce1.publierBon(TypeBon.ACHAT, 10, 1, produitsConcernes, dateDebut);
        System.out.println("Publication du bon1 : " + publication);

        
        System.out.println(commerce1.toString());

     

    }
    
  
}
