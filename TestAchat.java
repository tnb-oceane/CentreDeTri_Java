package classes_projet;
import java.util.*;

public class TestAchat {

    public static void main(String[] args) {
    	
        Ménage menage1 = new Ménage();
        
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Boulangerie");
        Commerce commerce1 = new Commerce("COM1", categories);

        
        Achat achat1 = new Achat(15, menage1, commerce1);
        
        System.out.println(achat1.toString());
        
		ArrayList<String> produitsConcernés = new ArrayList<>();
		produitsConcernés.add("Pain");
		produitsConcernés.add("Croissant");

		Date dateEmission = new Date();
		Date dateLimite = new Date(dateEmission.getTime() + (1000 * 60 * 60 * 24 * 7)); 
		Bon bon1 = new Bon(TypeBon.REDUCTION, 5, 10, commerce1, dateEmission, dateLimite, produitsConcernés, true);
        
        achat1.ajouterBonUtilisé(bon1);
        
        System.out.println("Achat [identifiant=" + achat1.getIdentifiant() + ", prixDépart=" + achat1.getPrixDépart()
        + ", prixFinal=" + achat1.getPrixFinal() + ", date=" + achat1.getDate() + ", menage=" + achat1.getMenage().getIdentifiant()
        + ", commerce=" + achat1.getCommerce().getNom() + ", listeBonsUtilisés=" + achat1.listeBonsToString() + "]");



    }
}
