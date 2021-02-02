package controlleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlleurPartiel {
    /**
     * Partie FXML
     * => Label : Question
     * => TextField : Réponse
     */
    @FXML
    private Label bonsoir;

    @FXML
    private TextField Reponse;

    /**
     * Question : pour la question
     * Rep : pour la réponse
     * Score : pour calculer la moyenne
     * tour : pour les question
     */
    private String question;
    private String rep;
    private int score;
    private int tour = 0;

    /**
     * Afficher la question
     * @param question => question à afficher
     */
    public void setQuestion(String question) {
        this.question = question;
        bonsoir.setText(question);
    }

    /**
     * Définir la réponse
     * @param rep
     */
    public void setRep(String rep){
        this.rep = rep;
    }

    /**
     * Définir le score
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Récupérer le score
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * Définir le tour
     * @param tour
     */
    public void setTour(int tour) {
        this.tour = tour;
    }

    /**
     * Afficher la vue avec la question, etc.
     * Ou en cas de partiel terminé, affiche si gagné ou perdu
     * @param actionEvent => clic sur le boutton
     */
    public void reponse(ActionEvent actionEvent) throws IOException {
        tour = tour+1;
        if(Reponse.getText().equals(rep)){
            score = score+1;
        }
        Stage stage = (Stage) bonsoir.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/partiel.fxml"));
        Parent root = (Parent) loader.load();

        Scene newScene = new Scene(root, 730, 470);
        newScene.getStylesheets().add(getClass().getResource("/css/tout.css").toExternalForm());
        Stage newStage = new Stage();

        ControlleurPartiel cp = loader.getController();
        if(tour < 5){
            if(tour == 1){
                cp.setQuestion("Que veut dire le O des principes S.O.L.I.D ? (n'oubliez pas les majuscules!)");
                    cp.setRep("Open/Close Principle");
            }
            if(tour == 2){
                cp.setQuestion("Que veut dire le L des principes S.O.L.I.D ? (n'oubliez pas les majuscules!)");
                cp.setRep("Liskov Substitution Principle");
            }
            if(tour == 3){
                cp.setQuestion("Que veut dire le I des principes S.O.L.I.D ? (n'oubliez pas les majuscules!)");
                cp.setRep("Interface Segregation Principle");
            }
            if(tour == 4){
                cp.setQuestion("Que veut dire le D des principes S.O.L.I.D ? (n'oubliez pas les majuscules!)");
                cp.setRep("Dependency Inversion Principle");
            }
            cp.setScore(score);
            cp.setTour(tour);

            newStage.setTitle("Jeu");
            newStage.setScene(newScene);
            stage.hide();
            newStage.show();
        }else{
            String titre;
            String msg;
            if(score == 5){
                titre = "Bravo";
                msg = "Tu a réussi le partiel";
            }else{
                titre = "Game Over";
                msg = "Tu a échoué petit mauvais";
            }

            FXMLLoader l = new FXMLLoader(getClass().getResource("/vues/endGame.fxml"));
            Parent r = (Parent) l.load();

            Scene ns = new Scene(r, 730, 470);
            ns.getStylesheets().add(getClass().getResource("/css/tout.css").toExternalForm());

            Stage nst = new Stage();

            ControlleurEndGame ceg = l.getController();
            ceg.changeEtat(titre);
            ceg.changeMsg(msg);

            nst.setTitle("Fin du jeu");
            nst.setScene(ns);
            stage.hide();
            nst.show();
        }
    }
}
