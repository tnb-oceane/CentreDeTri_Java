package classes_projet;

public class TestCentreDeTri {

	public static void main(String[] args) {
		CentreDeTri tri123 = new CentreDeTri("TRI123", "addresseCentre",12);
		tri123.ajouterPoubelleBleue(1, 1, "Quartier1", 15);
		tri123.getListePoubelles().get(0).envoyerNotification();
		tri123.voirNotification();
		
		tri123.ajouterQuartier("QuartierTest");
		tri123.collecterDechet("QuartierTest");
		tri123.faireStatistique();
		

	}
}
