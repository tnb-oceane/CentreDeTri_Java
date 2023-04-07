package classes_projet;
import java.util.*;

public class Ménage {
	

    private long identifiant;
    
    private String motDePasse;
    
    private int codeAcces;
    
    private int point;
    
    private ArrayList<Bon> listeBons;
    
    private CentreDeTri centredetri;
    
    private ArrayList<Commerce> commercePartenaire;
    
    private ArrayList<PoubelleIntelligente> listePoubelles;
    
    private static long suiviIdentifiant = 1;
    
    private ArrayList<Achat> listeAchats;
    
    private ArrayList<Dépot> listeDépots;


    

    public Ménage() {
        this.identifiant = getSuiviIdentifiant();
        this.motDePasse = null;
        this.codeAcces = 0;
        this.point = 0;
        this.centredetri = null;
        this.listeBons = new ArrayList<Bon>();
        this.commercePartenaire = new ArrayList<Commerce>();
        this.listePoubelles = new ArrayList<PoubelleIntelligente>();
        this.listeAchats = new ArrayList<Achat>();
        this.listeDépots = new ArrayList<Dépot>();
        
        suiviIdentifiant++;
     
    }

	
	public long getIdentifiant() {
		return identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public int getCodeAcces() {
		return codeAcces;
	}

	public int getPoint() {
		return point;
	}

	public ArrayList<Bon> getListeBons() {
		return listeBons;
	}

	public CentreDeTri getCentredetri() {
		return centredetri;
	}

	public ArrayList<Commerce> getCommercePartenaire() {
		return commercePartenaire;
	}

	public ArrayList<PoubelleIntelligente> getListePoubelles() {
		return listePoubelles;
	}

	public static long getSuiviIdentifiant() {
		return suiviIdentifiant;
	}

	public ArrayList<Achat> getListeAchats() {
		return listeAchats;
	}

	public ArrayList<Dépot> getListeDépots() {
		return listeDépots;
	}

	

	//Verifer la longeur de motdepass
	private boolean motDePasseValid(String motDePasse) {
	    return motDePasse.length() >= 8;
	}
	
	
	/*Fonction pour obtenir un code d'accès*/
	public void obtenirCodeAccès() {
    	int r = new Random().nextInt(10000);
    	if (PoubelleIntelligente.getListeCodeAccès().contains(r)) {
    		this.obtenirCodeAccès();
    	}
    	this.codeAcces = r;
    	PoubelleIntelligente.getListeCodeAccès().add(r);
    }
	
	

  //Lorsque l'on crée un compte on y attribut un mot de passe et on obtiens un code d'accès du centre de tri
	public boolean creerCompte(String motDePasse,CentreDeTri centredetri) {
		if (this.codeAcces != 0) {
			return false;//Le ménage à déja un compte
		}
		if (!this.motDePasseValid(motDePasse)) {
			System.out.println("Le mot de passe doit faire au moins 8 caractères");
			return false;//mot de passe non valide
		}
		this.motDePasse = motDePasse;
		this.obtenirCodeAccès();
		this.centredetri = centredetri;
		this.centredetri.getListeMénageAvecCompte().add(this);
		return true;
	}


	
	public boolean acheterBon(Bon bon) {
		if (this.point >= bon.getPrixBon()) {
			this.point -= bon.getPrixBon();
            this.listeBons.add(bon);
            return true;
        }
    return false;
	}
	
	
	public boolean utiliserBon(Bon bon, Achat achat) {
		if (!bon.isActif()) {
			return false;//Bon non actif donc inutilisable
		}
		achat.getListeBonsUtilisés().add(bon);
		bon.setActif(false);// après l'avoir utilisé on désactive le bon
		return true;
	}


	
	public boolean jeterDechet(ArrayList<Déchet> dechets, PoubelleIntelligente poubelle) {
		if (!poubelle.identifierUtilisateur(codeAcces)) {
			return false; //Le ménage n'a pas de compte, elle n'est pas identifier
		}
		if (dechets.isEmpty()) {
			return false;//Le ménage n'a aucun déchets à jeter
		}
		int pointTransaction = poubelle.attribuerPoint(dechets);
		new Dépot(dechets, this, poubelle,pointTransaction);
		this.point += pointTransaction;
		if (!this.listePoubelles.contains(poubelle)) {
			this.listePoubelles.add(poubelle);
		}
		if (!poubelle.getListeMénages().contains(this)) {
			poubelle.getListeMénages().add(this);//On ajoute le ménage à la liste des ménage ayant utilisé cette poubelle
		}
		return true;	
	}

	
	public void faireAchat(double prixDépart,Commerce commerce, ArrayList<Bon> listeBon) {
		Achat achat = new Achat(prixDépart, this, commerce);
		for (Bon bon: listeBon) {
			this.utiliserBon(bon, achat);
			achat.ajouterBonUtilisé(bon);
		}
		
	}


	@Override
	public String toString() {
		return "Ménage [identifiant=" + identifiant + ", motDePasse=" + motDePasse + ", codeAcces=" + codeAcces
				+ ", point=" + point + ", listeBons=" + listeBons + ", centredetri=" + centredetri.getNom()
				+ ", commercePartenaire=" + commercePartenaire + ", listePoubelles=" + listePoubelles + ", listeAchats="
				+ listeAchats + ", listeDépots=" + listeDépots + "]";
	}
	
	
	
}



   




   
