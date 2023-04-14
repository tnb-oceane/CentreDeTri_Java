package project_class;

public class Déchet {
	
	private TypeDéchet type;

    private double poids;
    
    
    
	public Déchet(TypeDéchet type, double poids) {
		super();
		this.type = type;
		this.poids = poids;
	}


	public TypeDéchet getType() {
		return type;
	}


	public double getPoids() {
		return poids;
	}

	
	@Override
	public String toString() {
		return "Dechet [type=" + type + ", poids=" + poids + "]";
	}
	
    
  
}
