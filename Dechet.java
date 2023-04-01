import java.util.*;
public class Dechet {
   private String type;
	private double poids;
	private Poubelle poubelleContientDechet;
	private depot depot;
	private ArrayList<String> listeTypeDechet= new ArrayList<>();
	
	public String gettype(){
		return type;
	}
	public double getpoids() {
		return poids;
	}
	public Poubelle getpoubelleContientDechet() {
		return poubelleContientDechet;
	}
	 public depot getdepot() {
		 return depot;
	 }
	 public ArrayList<String> getlisteTypeDechet(){
		 return listeTypeDechet;
	 }
}
