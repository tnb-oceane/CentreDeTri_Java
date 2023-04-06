package classes_projet;

public class Déchet {
	
	private TypeDéchet type;

    private double poids;
    
    private PoubelleIntelligente poubelleContientDechet;
	
    private Dépot depot;
    
    private CentreDeTri centredetri;
    
    
	public Déchet(TypeDéchet type, double poids) {
		super();
		this.type = type;
		this.poids = poids;
		this.poubelleContientDechet = null;
		this.depot = null;	
		this.centredetri=null;
	}


	public TypeDéchet getType() {
		return type;
	}


	public double getPoids() {
		return poids;
	}


	public PoubelleIntelligente getPoubelleContientDechet() {
		return poubelleContientDechet;
	}


	public Dépot getDepot() {
		return depot;
	}


	public CentreDeTri getCentredetri() {
		return centredetri;
	}


	@Override
	public String toString() {
		return "Déchet [type=" + type + ", poids=" + poids + ", poubelleContientDechet=" + poubelleContientDechet.getIdentifiant()
				+ ", depot=" + depot.getIdentifiant() + ", centredetri=" + centredetri.getNom() + "]";
	}
	
    
  
}
