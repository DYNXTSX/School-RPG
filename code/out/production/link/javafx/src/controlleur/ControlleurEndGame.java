package controlleur;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControlleurEndGame {
    /**
     * Partie FXML
     * => Label : gagné/perdu
     * => Label : message en plus
     */
    @FXML
    private Label EtatPartie;
    @FXML
    private Label Messageplus;

    /**
     * Fermer le programme si le joueur clique
     * @param mouseEvent => en cas de clique
     */
    @FXML
    public void fermerFenetre(MouseEvent mouseEvent) {
        Platform.exit();
    }

    /**
     * Mettre l'état de la game
     * @param etat => gagné / perdu
     */
    public void changeEtat(String etat){
        EtatPartie.setText(etat);
    }

    /**
     * Mettre le message plus
     * @param msg => message qui accompagne l'état
     */
    public void changeMsg(String msg){
        Messageplus.setText(msg);
    }
}
