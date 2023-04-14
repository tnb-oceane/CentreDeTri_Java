package project_test;
import java.util.*;

import project_class.CentreDeTri;
import project_class.Commerce;


public class TestCentreDeTri {

	public static void main(String[] args) {
		
		//On créer un centre de tri
		CentreDeTri tri123 = new CentreDeTri("TRI123", "addresseCentre",10);
		System.out.println("Les caracteristiques du centre de tri sont :");
        System.out.println(tri123 + "\n");
		
		//On ajoute des quartier
		tri123.ajouterQuartier("Quartier1");
		tri123.ajouterQuartier("Quartier2");
		tri123.ajouterQuartier("Quartier3");
		System.out.println("Les quartiers desservie par le centre de tri sont :");
		System.out.println(tri123.getListeQuartierDesservie()+ "\n");
		
		//On supprime un quartier
		System.out.println("On supprime le Quartier3 :");
		tri123.supprimerQuartier("Quartier3");
		System.out.println(tri123.getListeQuartierDesservie()+ "\n");
		
		//On ajoute des poubelles
		tri123.ajouterPoubelleBleue(0, 1, "Quartier1", 15);
		tri123.ajouterPoubelleVerte(0, 2, "Quartier1", 15);
		tri123.ajouterPoubelleJaune(0, 3, "Quartier2", 15);
		tri123.ajouterPoubelleClassique(0, 4, "Quartier2", 15);
		System.out.println("Les poubelles possede par le centre de tri sont :");
		System.out.println(tri123.getListePoubelles()+ "\n");
		
		//On place les poubelles : placer = true
		System.out.println("On place une seule poubelle dans le Quartier1 :");
		tri123.ajouterPoubelleQuartier("Quartier1");
		System.out.println(tri123.getListePoubelles().get(0));
		System.out.println(tri123.getListePoubelles().get(1)+ "\n");
		
		System.out.println("On supprime une seule poubelle du Quartier1 :");
		tri123.supprimerPoubelleQuartier("Quartier1");
		System.out.println(tri123.getListePoubelles().get(0));
		System.out.println(tri123.getListePoubelles().get(1)+ "\n");
		
		System.out.println("On place toutes les poubelles du centre de tri :");
		tri123.placerPoubelleDisponible();
		System.out.println(tri123.getListePoubelles().get(0));
		System.out.println(tri123.getListePoubelles().get(1));
		System.out.println(tri123.getListePoubelles().get(2));
		System.out.println(tri123.getListePoubelles().get(3)+ "\n");
		
		
		//On supprime des poubelles
		System.out.println("On ne peux pas supprimer une poubelle qui est dans son quartier ou qui n'existe pas :");
		System.out.println(tri123.supprimerPoubelle(11));// Pas de poubelle associé a cette identifiant
		System.out.println(tri123.supprimerPoubelle(1)+ "\n");
		
		System.out.println("On doit collecter les dechets de la poubelle avant de la supprimer :");
		tri123.collecterDechet("Quartier1");
		System.out.println(tri123.supprimerPoubelle(1));
		System.out.println(tri123.getListePoubelles() + "\n");
		
		
		//On supprime un Quartier
		System.out.println("En supprimant un quartier on supprime aussi les poubelles associees :");
		tri123.supprimerQuartier("Quartier1");
		System.out.println(tri123.getListeQuartierDesservie());
		System.out.println(tri123.getListePoubelles()+ "\n");
		
		
		//Les notifications
		System.out.println("Les notifications du centre de tri sont :");
		tri123.getListePoubelles().get(0).envoyerNotification();
		tri123.getListePoubelles().get(1).envoyerNotification();
		System.out.println(tri123.getNotification()+"\n");
		
		System.out.println("On supprime la notification de la poubelle jaune :");
		tri123.supprimerNotification(3);	
		System.out.println(tri123.getNotification()+ "\n");
		
		System.out.println("On affiche les notifications puis on les supprime :");
		tri123.voirNotification();
		System.out.println(tri123.getNotification()+ "\n");
		
		
		//On crée un contrat
		Commerce abc123 = new Commerce("ABC123", null);
		tri123.creerContrat(new Date(), new Date(), 0, null, 0, 0, null,abc123);
		System.out.println("Les contrats du centre de tri sont :");
		System.out.println(tri123.getListeContrats()+ "\n");
		
		
		//Les statistiques
		System.out.println("Les statistiques du centre de tri sont :");
		tri123.faireStatistique();	

	}

}
