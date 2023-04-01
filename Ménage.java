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
    
    private static long suiviIdentifiant = 0;
    
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
    }
	
	

  /*public boolean creerCompte(String motDePasse) {
      if (motDePasseValid(motDePasse)) {
          this.motDePasse = motDePasse;
          return true;
      } else {
          return false;
      }
  }*/ //Lorsque l'on crée un compte on y attribut un mot de passe et on obtiens un code d'accès du centre de tri
	public boolean creerCompte(String motDePasse,CentreDeTri centredetri) {
		if (this.codeAcces != 0) {
			return false;//Le ménage à déja un compte
		}
		if (!this.motDePasseValid(motDePasse)) {
			return false;//mot de passe non valide
		}
		this.motDePasse = motDePasse;
		this.obtenirCodeAccès();
		this.centredetri = centredetri;
		this.centredetri.getListeMénageAvecCompte().add(this);
		return true;
	}





	/*public boolean acheterBon(int idBon) {
	    //  Trouvez le Bon dans la liste des Bons disponibles
	    for (Bon bon : Bon.getListeBonsDisponibles()) {
	        if (bon.getIdentifiant() == idBon && this.point >= bon.getPrixBon()) {
	            this.point -= bon.getPrixBon();
	            this.listeBons.add(bon);
	            return true;
	        }
	    }
	    return false;
	}*///Ta fonction est correcte j'ai juste remplacer idBon par Bon pour rendre  ça plus simple
	public boolean acheterBon(Bon bon) {
		if (this.point >= bon.getPrixBon()) {
			this.point -= bon.getPrixBon();
            this.listeBons.add(bon);
            return true;
        }
    return false;
	}
	
	

	/*public boolean utiliserBon(int idBon, int idAchat) {
	    // Trouvez le Bon dans la liste des Bons du Ménage et appliquez-le à l'Achat.
	    for (Bon bon : this.listeBons) {
	        if (bon.getIdentifiant() == idBon) {
	            for (Achat achat : this.listeAchats) {
	                if (achat.getIdentifiant() == idAchat) {
	                    achat.ajouterBonUtilisé(bon);
	                    this.listeBons.remove(bon);
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}*///Une fois utilisé le bon n'est plus actif mais il est toujours dans la liste des bons du ménage
	public boolean utiliserBon(Bon bon, Achat achat) {
		if (!bon.isActif()) {
			return false;//Bon non actif donc inutilisable
		}
		achat.getListeBonsUtilisés().add(bon);
		bon.setActif(false);// après l'avoir utilisé on désactive le bon
		return true;
	}


	/*public boolean jeterDechet(ArrayList<Déchet> dechets) {
	  // Ajoutez des objets Déchet à la Poubelle associée et mettez à jour les points.
	  CentreDeTri centreDeTri = getCentreDeTri();
	  for (Déchet dechet : dechets) {
	      PoubelleIntelligente poubelle = centreDeTri.getPoubelleByType(dechet.getType());
	      if (poubelle != null) {
	          poubelle.ajouterDechet(dechet);
	          this.point += dechet.getPoints();
	      } else {
	          return false;
	      }
	  }
	  return true;
	}*/ //Je n'ai pas compris ce que fait ta fonction, elle est plus simple a faire si on ajoute la poubelle dans les attributs car le ménage doit crééer un dépot
	public boolean jeterDechet(ArrayList<Déchet> dechets, PoubelleIntelligente poubelle) {
		if (!PoubelleIntelligente.getListeCodeAccès().contains(this.codeAcces)) {
			return false; //Le ménage n'a pas de compte, elle n'est pas identifier
		}
		if (dechets.isEmpty()) {
			return false;//Le ménage n'a aucun déchets à jeter
		}
		int pointTransaction = poubelle.attribuerPoint(dechets);
		new Dépot(dechets, this, poubelle,pointTransaction);
		this.point += pointTransaction;
		this.listePoubelles.add(poubelle);
		poubelle.getListeMénages().add(this);//On ajoute le ménage à la liste des ménage ayant utilisé cette poubelle
		return true;	
	}

	
	public void faireAchat(double prixDépart,Commerce commerce, ArrayList<Bon> listeBon) {
		Achat achat = new Achat(prixDépart, this, commerce);
		for (Bon bon: listeBon) {
			this.utiliserBon(bon, achat);
			achat.ajouterBonUtilisé(bon);
		}
		
	}
	
}



   




   
