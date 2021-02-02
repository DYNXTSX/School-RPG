package controlleur;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Screen;
import javafx.stage.Stage;
import launch.Launcher;
import modeles.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;


public class ControlleurAccueilJeu {
    /**
     * Elements FXML
     * TextFiels => rentrer le pseudo du joueur
     * Button => pour lancer le jeu
     */
    @FXML
    private TextField pseudo;
    @FXML
    private Button jouer;

    /**
     * Récupérer le manager depuis le Launcher
     */
    Manager leManager = Launcher.getLeManager();

    /**
     * Langer le jeu
     * @param actionEvent => Quand le joueur clique sur le button
     */
    public void Jouer(ActionEvent actionEvent) throws IOException {
        jouer();
    }

    /**
     * Fonction pour lancer la nouvelle vue
     * => Mettre le pseudo du joueur a jour
     * => Créer le nouvelle vue
     * => Créer le nouveau controlleur
     * => Ajouter les événements
     * => Afficher la nouvelle vue
     */
    public void jouer() throws IOException {
        Screen screen = Screen.getPrimary();

        leManager.setPseudo(pseudo.getText());
        Stage stage = (Stage) jouer.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/jeu.fxml"));
        Parent root = (Parent) loader.load();

        Scene newScene = new Scene(root, 730, 470/*bounds.getWidth()-200, bounds.getHeight()-200*/);
        newScene.getStylesheets().add(getClass().getResource("/css/tout.css").toExternalForm()); //erreur
        Stage newStage = new Stage();

        ControlleurJeu ccc = loader.getController();
        newScene.addEventFilter(KeyEvent.KEY_PRESSED,  leManager::deplace);
        newScene.addEventFilter(KeyEvent.KEY_PRESSED, ccc::reset2);
        newScene.addEventFilter(KeyEvent.KEY_RELEASED,  leManager::modifierEtat);

        newStage.setTitle("Jeu");
        newStage.setScene(newScene);
        leManager.getLeCollisionneur().heightProperty().bind(newStage.heightProperty());
        stage.hide();
        newStage.show();
    }

    /**
     * Lancer la méthode jouer avec le clavier
     * @param keyEvent => Si le joueur appuie sur entrer
     */
    public void bouger(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode() == KeyCode.ENTER){
            jouer();
        }
    }
}
