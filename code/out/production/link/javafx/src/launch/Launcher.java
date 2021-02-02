package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modeles.Manager;
import modeles.serialisation.Seria;

/**
 * Classe Launcher, classe de démarrage de l'application
 * @author PEYRON Hugo et PERALDE François
 */
public class Launcher extends Application {

    /**
     * Créer notre manager pour servir de passerelle entre le joueur et le jeu
     */
    private static Manager leManager = new Manager();

    /**
     * Méthode start pour afficher une vue.
     *
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vues/accueilJeu.fxml"));
        Scene scene = new Scene(root, 715, 465);
        scene.getStylesheets().add(getClass().getResource("/css/tout.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Accueil");
        stage.show();
    }

    /**
     * Méthode pour stoper notre boucleur
     */
    @Override
    public void stop() throws Exception {
        leManager.stopBoucleur();
        Seria save = new Seria();
        save.saveDataToFile();
        super.stop();
    }

    /**
     * Méthode pour récupérer le manager
     * @return
     *        Cela va nous return le manager
     */
    public static Manager getLeManager(){
        return leManager;
    }
}
