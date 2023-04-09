package classes_projet;
import java.util.*;

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
        System.out.println(achat1 + "\n");
        

		//On crée un bon valide
		Date dateEmission = new Date();
		Date dateLimite = new Date(dateEmission.getTime() + (1000 * 60 * 60 * 24 * 7)); 
		Bon bon1 = new Bon(TypeBon.REDUCTION, 10, 100, commerce1, dateEmission, dateLimite, categories, true);
		bon1.setMenage(menage1);
		
        
		//On affiche les changements de prix
        achat1.ajouterBonUtilisé(bon1);
        System.out.println(achat1 + "\n");

        //On ne peux utiliser un bon qu'une seule fois
        achat1.ajouterBonUtilisé(bon1);
        System.out.println(achat1 + "\n");
	}

}
