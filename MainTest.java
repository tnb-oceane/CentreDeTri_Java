package classes_projet;
import java.util.*;

public class MainTest {

	public static void main(String[] args) {
		//Créer un centre de tri et lui ajouter de poubelles et des quartier
		CentreDeTri tri123 = new CentreDeTri("TRI123","Avenue du tri",10);
		tri123.ajouterQuartier("Quartier1");
		tri123.ajouterQuartier("Quartier2");
		tri123.ajouterPoubelleClassique(0, 0, "Quartier1", 15);
		tri123.ajouterPoubelleBleue(0, 0, "Quartier1", 15);
		tri123.ajouterPoubelleJaune(0, 0, "Quartier2", 15);
		tri123.ajouterPoubelleVerte(0, 0, "Quartier2", 15);

		
		//Créer deux ménages
		Ménage menage1 = new Ménage();
		Ménage menage2 = new Ménage();
		
		//Créer un compte aux ménages
		menage1.creerCompte("password1", tri123);
		menage2.creerCompte("password2", tri123);
		System.out.println(menage1.getCodeAcces() +", "+ menage2.getCodeAcces());
		
		//Placer les poubelles
		tri123.placerPoubelleDisponible();
		
		//Créer des listes de dechets
		ArrayList<Déchet> liste1 = new ArrayList<Déchet>();
		ArrayList<Déchet> liste2 = new ArrayList<Déchet>();
		liste1.add(new Déchet(TypeDéchet.AUTRE, 5));
		liste1.add(new Déchet(TypeDéchet.VERRE, 5));
		liste2.add(new Déchet(TypeDéchet.PLASTIQUE, 5));
		liste2.add(new Déchet(TypeDéchet.CARTON, 5));
		liste2.add(new Déchet(TypeDéchet.CONSERVECANETTE, 5));
		
		//Ménage jete ses dechets
		System.out.println(menage1.getListeDépots());
		menage1.jeterDechet(liste1, tri123.getListePoubelles().get(0));
		System.out.println(menage1.getListeDépots());
		System.out.println(menage2.getListeDépots());
		menage2.jeterDechet(liste2, tri123.getListePoubelles().get(2));
		System.out.println(menage2.getListeDépots());
		
		//Point du ménage 2
		System.out.println(menage2.getPoint());
		
		//Créer un commerce
		ArrayList<String> categories = new ArrayList<String>();
		categories.add("Charcuterie");
		categories.add("Boulangerie");
		Commerce abc123 = new Commerce("ABC123", categories);
		
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
		
        ArrayList<TypeBon> typeBonAdmissible = new ArrayList<TypeBon>();
        typeBonAdmissible.add(TypeBon.ACHAT);
        typeBonAdmissible.add(TypeBon.REDUCTION);
		tri123.creerContrat(dateDebut, dateFin, 0, categories, 5, 10, typeBonAdmissible , abc123);
		System.out.println(abc123.getListeContrats());
		
		//Publier un bon
		abc123.publierBon(TypeBon.ACHAT, 10, 1, categories, dateFin);
		System.out.println(abc123.getListeBons());
		
		//Acheter un bon
		System.out.println(menage2.getPoint());
		menage2.acheterBon(abc123.getListeBons().get(0));
		System.out.println(menage2.getListeBons());
		System.out.println(menage2.getPoint());
		
		//Faire un achat
		menage2.faireAchat(20, abc123, menage2.getListeBons(), categories);
		System.out.println(menage2.getListeAchats());
		
		

	}

}
