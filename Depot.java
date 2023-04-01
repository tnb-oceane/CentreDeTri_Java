import java.util.*;
public class Depot {
    private int id;
    private int menage;
    private int poubelle;
    private Date heure = new Date();
    private double quantiteDeDechet;
    private ArrayList<String> dechetDepose = new ArrayList<>();
    private long suivi_identifiant;
    
    public int getId() {
        return id;
    }

    public int getMenage() {
        return menage;
    }

    public int getPoubelle() {
        return poubelle;
    }

    public Date getHeure() {
        return heure;
    }

    public double getQuantiteDeDechet() {
        return quantiteDeDechet;
    }

    public ArrayList<String> getDechetDepose() {
        return dechetDepose;
    }

    public long getSuiviIdentifiant() {
        return suivi_identifiant;
    }

}
