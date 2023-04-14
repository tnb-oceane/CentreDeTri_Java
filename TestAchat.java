package project_test;
import java.util.*;
import project_class.*;

public class TestAchat {

	public static void main(String[] args) {
		//On crée un ménage
		Ménage menage1 = new Ménage();
        
		//On crée une liste de catégorie et un commerce qui vend ces produits
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("Boulangerie");
        Commerce commerce1 = new Commerce("COM1", categories);

        //On crée un achat
        Achat achat1 = new Achat(15, menage1, commerce1,categories);
        System.out.println("Les caracteristiques de achat1 sont :");
        System.out.println(achat1 + "\n");
        

		//On crée un bon valide
		Date dateEmission = new Date();
		Date dateLimite = new Date(dateEmission.getTime() + (1000 * 60 * 60 * 24 * 7)); 
		Bon bon1 = new Bon(TypeBon.REDUCTION, 10, 100, commerce1, dateEmission, dateLimite, categories, true);
		
        
		//On affiche les changements de prix
        achat1.ajouterBonUtilisé(bon1);
        System.out.println("On ajoute bon1 dans les caracteristiques de achat1 - le prix change :");
        System.out.println(achat1 + "\n");

        //On ne peux utiliser un bon qu'une seule fois
        System.out.println("On ne peut utiliser un bon qu'une seule fois - le prix ne change pas :");
        achat1.ajouterBonUtilisé(bon1);
        System.out.println(achat1 + "\n");
	}

}
