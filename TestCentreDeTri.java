package classes_projet;
import java.util.*;


public class TestCentreDeTri {

	public static void main(String[] args) {
		
		//On créer un centre de tri
		CentreDeTri tri123 = new CentreDeTri("TRI123", "addresseCentre",10);
		
		//On ajoute des quartier
		tri123.ajouterQuartier("Quartier1");
		tri123.ajouterQuartier("Quartier2");
		tri123.ajouterQuartier("Quartier3");
		System.out.println(tri123.getListeQuartierDesservie()+ "\n");
		
		//On supprime un quartier
		tri123.supprimerQuartier("Quartier3");
		System.out.println(tri123.getListeQuartierDesservie()+ "\n");
		
		//On ajoute des poubelles
		tri123.ajouterPoubelleBleue(0, 1, "Quartier1", 15);
		tri123.ajouterPoubelleVerte(0, 2, "Quartier1", 15);
		tri123.ajouterPoubelleJaune(0, 3, "Quartier2", 15);
		tri123.ajouterPoubelleClassique(0, 4, "Quartier2", 15);
		System.out.println(tri123.getListePoubelles()+ "\n");
		
		//On place les poubelles
		tri123.ajouterPoubelleQuartier("Quartier1");
		System.out.println(tri123.getListePoubelles());
		tri123.supprimerPoubelleQuartier("Quartier1");
		System.out.println(tri123.getListePoubelles());
		tri123.placerPoubelleDisponible();
		System.out.println(tri123.getListePoubelles()+ "\n");
		
		//On supprime des poubelles
		System.out.println(tri123.supprimerPoubelle(1));
		tri123.collecterDechet("Quartier1");
		System.out.println(tri123.supprimerPoubelle(1));
		System.out.println(tri123.getListePoubelles() + "\n");
		
		//On supprime un Quartier
		tri123.supprimerQuartier("Quartier1");
		System.out.println(tri123.getListeQuartierDesservie());
		System.out.println(tri123.getListePoubelles()+ "\n");
		
		//Les notifications
		tri123.getListePoubelles().get(0).envoyerNotification();
		tri123.getListePoubelles().get(1).envoyerNotification();
		System.out.println(tri123.getNotification());
		tri123.supprimerNotification(3);	
		tri123.voirNotification();
		System.out.println(tri123.getNotification()+ "\n");
		
		//On crée un contrat
		/*ArrayList<String> listeVide = new ArrayList<>();
       		Commerce abc123 = new Commerce("ABC123", listeVide);*/
		Commerce abc123 = new Commerce("ABC123", null);
		tri123.creerContrat(new Date(), new Date(), 0, null, 0, 0, null,abc123);
		System.out.println(tri123.getListeContrats()+ "\n");
		
		
		//Les statistiques
		tri123.faireStatistique();	

	}

}
