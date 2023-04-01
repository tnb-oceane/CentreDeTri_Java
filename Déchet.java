package classes_projet;
import java.util.*;

public class Déchet {
	
	

	public Déchet(TypeDéchet type, double poids) {
		super();
		this.type = type;
		this.poids = poids;
	}

	private TypeDéchet type;

    private double poids;

	public TypeDéchet getType() {
		return type;
	}

	public void setType(TypeDéchet type) {
		this.type = type;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}    
    
  
}
