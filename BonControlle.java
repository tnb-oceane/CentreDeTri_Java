package classes_projet;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.util.ArrayList;

public class BonController {

    @FXML
    private TextField identifiantTextField;

    @FXML
    private TextField typeTextField;

    @FXML
    private TextField valeurTextField;

    @FXML
    private TextField prixBonTextField;

    @FXML
    private TextField dateEmissionTextField;

    @FXML
    private TextField dateLimiteTextField;

    @FXML
    private TextField actifTextField;

    @FXML
    private Button validerButton;

    @FXML
    private Button annulerButton;

    // Exemple d'instances de Bon, Commerce et Ménage.
    private Bon bonExemple;
    private Commerce commerceExemple;
    private Ménage menageExemple;

    public BonController() {
        // Initialisation des exemples de Commerce, Ménage et Bon.
        ArrayList<String> listeCategorieProduitVendu = new ArrayList<>();
        listeCategorieProduitVendu.add("categorie1");
        commerceExemple = new Commerce("commerceExemple", listeCategorieProduitVendu);

        menageExemple = new Ménage();

        ArrayList<String> listeCatégorieConcernés = new ArrayList<>();
        listeCatégorieConcernés.add("categorie1");
        bonExemple = new Bon(TypeBon.ACHAT, 50, 500, commerceExemple, new Date(), new Date(), listeCatégorieConcernés, true);
    }

    @FXML
    public void validerBon(ActionEvent event) {
        // Récupérer les valeurs des TextField et créer ou modifier un objet Bon selon les besoins
        long identifiant = Long.parseLong(identifiantTextField.getText());
        TypeBon type = TypeBon.valueOf(typeTextField.getText());
        double valeur = Double.parseDouble(valeurTextField.getText());
        int prixBon = Integer.parseInt(prixBonTextField.getText());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateEmission = null;
        Date dateLimite = null;
        try {
            dateEmission = dateFormat.parse(dateEmissionTextField.getText());
            dateLimite = dateFormat.parse(dateLimiteTextField.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean actif = Boolean.parseBoolean(actifTextField.getText());

        // Mettre à jour le champ 'actif' de l'exemple de Bon avec la valeur récupérée
        bonExemple.setActif(actif);
    }

    @FXML
public void annuler(ActionEvent event) {
    // Fermer la fenêtre en obtenant le Stage à partir de l'élément déclencheur de l'événement (annulerButton)
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
}

}
