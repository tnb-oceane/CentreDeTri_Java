import java.util.ArrayList;
import java.util.Date;

public class Achat {
    private String identifiant;
    private double prixDépart;
    private double prixFinal;
    private Date date;
    private Menage menage;
    private Commerce commerce;
    private ArrayList<Bon> listeBonsUtilisés;

    public Achat(String identifiant, double prixDépart, double prixFinal, Date date, Menage menage, Commerce commerce) {
        this.identifiant = identifiant;
        this.prixDépart = prixDépart;
        this.prixFinal = prixFinal;
        this.date = date;
        this.menage = menage;
        this.commerce = commerce;
        this.listeBonsUtilisés = new ArrayList<>();
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public double getPrixDépart() {
        return prixDépart;
    }

    public double getPrixFinal() {
        return prixFinal;
    }

    public Date getDate() {
        return date;
    }

    public Menage getMenage() {
        return menage;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public ArrayList<Bon> getListeBonsUtilisés() {
      return listeBonsUtilisés;
  }

  public void ajouterBonUtilisé(Bon bon) {
      if (!listeBonsUtilisés.contains(bon)) {
          listeBonsUtilisés.add(bon);
          double remise = bon.getValeur();
          prixFinal -= remise;
          if (prixFinal < 0) {
              prixFinal = 0;
          }
      }
  }

  public void retirerBonUtilisé(Bon bon) {
      if (listeBonsUtilisés.contains(bon)) {
          listeBonsUtilisés.remove(bon);
          double remise = bon.getValeur();
          prixFinal += remise;
      }
  }

  public void appliquerBonsUtilisés() {
      double remiseTotale = 0;
      for (Bon bon : listeBonsUtilisés) {
          remiseTotale += bon.getValeur();
      }
      prixFinal = prixDépart - remiseTotale;
      if (prixFinal < 0) {
          prixFinal = 0;
      }
  }
}

