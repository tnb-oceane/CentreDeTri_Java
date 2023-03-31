import java.util.ArrayList;

public class Menage {
    private long identifiant;
    private String motDePasse;
    private int codeAcces;
    private int point;
    private ArrayList<Bon> listeBons;
    private Commerce commerce;
    private ArrayList<Poubelle> listePoubelles;
    private static long suiviIdentifiant = 0;
    private ArrayList<Achat> listeAchats;


    // Constructor
    public Menage(String motDePasse, int codeAcces, Commerce commerce) {
        this.identifiant = getSuiviIdentifiant();
        this.motDePasse = motDePasse;
        this.codeAcces = codeAcces;
        this.point = 0;
        this.listeBons = new ArrayList<>();
        this.commerce = commerce;
        this.listePoubelles = new ArrayList<>();
        this.listeAchats = new ArrayList<>();
    }

    // Methods
    public long getIdentifiant() {
        return identifiant;
    }

    public static long getSuiviIdentifiant() {
        return suiviIdentifiant++;
    }

    public int getCodeAcces() {
      return codeAcces;
   }

    public void setCodeAcces(int codeAcces) {
      this.codeAcces = codeAcces;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String mdp) {
        this.motDePasse = mdp;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public ArrayList<Bon> getPossedeBons() {
        return listeBons;
    }
    public void setPossedeBons(ArrayList<Bon> listeBons) {
      this.listeBons = listeBons;
  }

  // Implement these methods based on your application logic
  public ArrayList<Achat> getListeAchats() {
      return new ArrayList<>();
  }

  public void setListeAchats(ArrayList<Achat> listeAchats) {
  }

  public ArrayList<Depot> getListeDepots() {
      return new ArrayList<>();
  }

  public void setListeDepots(ArrayList<Depot> listeDepots) {
  }

  public boolean creerCompte(String motDePasse) {
      if (motDePasseValid(motDePasse)) {
          this.motDePasse = motDePasse;
          return true;
      } else {
          return false;
      }
  }

  private boolean motDePasseValid(String motDePasse) {
    //Verifer la longeur de motdepass
    return motDePasse.length() >= 8;
}

public boolean acheterBon(int idBon) {
    //  Trouvez le Bon dans la liste des Bons disponibles
    for (Bon bon : Bon.getListeBonsDisponibles()) {
        if (bon.getIdentifiant() == idBon && this.point >= bon.getPrixBon()) {
            this.point -= bon.getPrixBon();
            this.listeBons.add(bon);
            return true;
        }
    }
    return false;
}

public boolean utiliserBon(int idBon, int idAchat) {
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
}

public boolean jeterDechet(ArrayList<Dechet> dechets) {
  // Ajoutez des objets Déchet à la Poubelle associée et mettez à jour les points.
  CentreDeTri centreDeTri = getCentreDeTri();
  for (Dechet dechet : dechets) {
      Poubelle poubelle = centreDeTri.getPoubelleByType(dechet.getType());
      if (poubelle != null) {
          poubelle.ajouterDechet(dechet);
          this.point += dechet.getPoints();
      } else {
          return false;
      }
  }
  return true;
}

public CentreDeTri getCentreDeTri() {
  //Obtenez l'objet CentreDeTri associé au Commerce de ce Ménage.
  return commerce.getCentreDeTri();
}

// 

public Commerce getCommerce() {
  return commerce;
}

public void setCommerce(Commerce commerce) {
  this.commerce = commerce;
}

public ArrayList<Poubelle> getListePoubelles() {
  return listePoubelles;
}

public void setListePoubelles(ArrayList<Poubelle> listePoubelles) {
  this.listePoubelles = listePoubelles;
}


}



   
