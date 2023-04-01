package classes_projet;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		CentreDeTri tri123 = new CentreDeTri("TRI123", "addresseCentre",12);
		tri123.ajouterPoubelleBleue(1, 1, "Quartier1", 15);
		tri123.ajouterPoubelleQuartier("Quartier1");
		tri123.ajouterPoubelleBleue(1, 2, "Quartier1", 15);
		System.out.println(PoubelleVerte.getTypeDéchetAccepté());
		System.out.println(PoubelleJaune.getTypeDéchetAccepté());

	}
	

}
