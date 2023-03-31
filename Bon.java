import java.util.ArrayList;
import java.util.Date;

public class Bon {
    private long identifiant;
    private String type;
    private double valeur;
    private int coût;
    private Commerce commerce;
    private Date dateEmission;
    private Date dateLimite;
    private ArrayList<String> listeProduitsConcernés;
    private boolean actif;
    private static ArrayList<Bon> listeBonsDisponibles = new ArrayList<>();

    public Bon(long identifiant, String type, double valeur, int coût, Commerce commerce, Date dateEmission, Date dateLimite, ArrayList<String> listeProduitsConcernés) {
        this.identifiant = identifiant;
        this.type = type;
        this.valeur = valeur;
        this.coût = coût;
        this.commerce = commerce;
        this.dateEmission = dateEmission;
        this.dateLimite = dateLimite;
        this.listeProduitsConcernés = listeProduitsConcernés;
        this.actif = true;
        listeBonsDisponibles.add(this);
    }

    public long getIdentifiant() {
        return identifiant;
    }

    public String getType() {
        return type;
    }

    public double getValeur() {
        return valeur;
    }

    public int getCoût() {
        return coût;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public ArrayList<String> getListeProduitsConcernés() {
        return listeProduitsConcernés;
    }

    public boolean estActif() {
        return actif;
    }

    public static ArrayList<Bon> getListeBonsDisponibles() {
        return listeBonsDisponibles;
    }

    public boolean estUtilisable(Date date, String produit) {
        return actif && !date.after(dateLimite) && (listeProduitsConcernés.isEmpty() || listeProduitsConcernés.contains(produit));
    }

    public boolean utiliser() {
        if (actif) {
            actif = false;
            return true;
        } else {
            return false;
        }
    }
}

