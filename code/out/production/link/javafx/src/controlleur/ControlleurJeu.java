package controlleur;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import launch.Launcher;
import modeles.entites.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class ControlleurJeu {
    /**
     * Partie FXML
     * => Pane : zone contenant tout
     * => VBox : conteneur de notre joueur
     */
    @FXML
    private Pane zoneDeJeu;

    @FXML
    private VBox conteneur;

    /**
     * Méthode au lancement de la vue
     * => Pour toutes les entite dans la liste des entites
     * => Lancer la méthode UpdatePanneau avec l'entite en parametre
     *
     * => Si la liste change : supprimer le joueur et la supperposition haute et update le panneau
     */
    public void initialize(){
        for(Entite entite : Launcher.getLeManager().getListeEntite()){
            UpdatePanneau(entite);
        }

        Launcher.getLeManager().getListeEntite().addListener((ListChangeListener.Change<? extends Entite> change)-> {
                    change.next();
                    for(Entite entite : change.getAddedSubList()) {
                        zoneDeJeu.getChildren().remove(Launcher.getLeManager().getListeEntite().size() - 2);
                        UpdatePanneau(entite);
                    }
                }
        );
    }

    /**
     * Méthode UpdatePanneau
     * @param entite => Entite passé en parametre
     *
     * => Si l'entite est le joueur, alors on créé sa VBox avec son pseudo et on l'affiche
     * => Sinon, créé l'entité avec une événement clic en fonction de s'il est possible ou non d'intéragir avec l'entite
     */
    private void UpdatePanneau(Entite entite) {
        //donner un id a l'image view et enssuite y acceder via les autres page
        if(entite.getClass() == Joueur.class){
            VBox conteneur = new VBox();
            Label nom = new Label();
            nom.setId("nomJoueur");
            nom.textProperty().bind(((Joueur) entite).pseudoProperty());
            ImageView entiteAAfficher = new ImageView();
            entiteAAfficher.setImage(new Image(getClass().getResource(entite.getImage()).toExternalForm()));
            entiteAAfficher.setViewOrder(entite.getZ());
            conteneur.getChildren().add(entiteAAfficher);
            conteneur.getChildren().add(nom);
            conteneur.setAlignment(Pos.BASELINE_CENTER);
            conteneur.layoutXProperty().bind(entite.xProperty());
            conteneur.layoutYProperty().bind(entite.yProperty());
            zoneDeJeu.getChildren().add(conteneur);
        }
        else{
            //mettre les entite dans des image view
            ImageView entiteAAfficher = new ImageView();
            entiteAAfficher.setOnMouseClicked(e -> {
                try {
                    clicker(entite);
                } catch (InterruptedException | IOException interruptedException) {
                    interruptedException.printStackTrace();
                }
            });
            entiteAAfficher.setImage(new Image(getClass().getResource(entite.getImage()).toExternalForm()));
            entiteAAfficher.layoutXProperty().bind(entite.xProperty());
            entiteAAfficher.layoutYProperty().bind(entite.yProperty());
            entiteAAfficher.setViewOrder(entite.getZ());

            zoneDeJeu.getChildren().add(entiteAAfficher);
        }
    }

    /**
     * Méthode si on clique sur l'entite
     * @param entite => entite passé en parametre, celle sur laquelle on clique
     *
     * => Si l'entité est un OBJET :
     *               ==> En général : récupere le message et le nom et l'affiche avec la méthode affichage
     *               ==> Si pas secrétaire : affichage normal avec false pour la méthode affichage
     *               ==> Si secrétaire : vérification game over et nombre de quete et lancement ou non du partiel
     *
     * => Si l'entité est un PNJ :
     *               ==> Affichage normal avec la méthode affichage
     *
     * => Si l'entité est un PROF :
     *               ==> Mettre a jour les quetes et affichage avec la méthode affichage
     */
    private void clicker(Entite entite) throws InterruptedException, IOException {
        if(entite.getClass() == Objets.class){
            String message = ((Objets) entite).getMessage();
            String nom = ((Objets) entite).getNom();
            if(((Objets) entite).getNom() == "Secrétaire")
            {
                if(Launcher.getLeManager().getJoueurEnCours().getNbQueteAFaire() == 0 && Launcher.getLeManager().getLeBoucleur().isActif()){
                    Stage stage = (Stage) zoneDeJeu.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/partiel.fxml"));
                    Parent root = (Parent) loader.load();

                    Scene newScene = new Scene(root, 730, 470/*bounds.getWidth()-200, bounds.getHeight()-200*/);
                    newScene.getStylesheets().add(getClass().getResource("/css/tout.css").toExternalForm()); //erreur
                    Stage newStage = new Stage();

                    ControlleurPartiel cp = loader.getController();
                    cp.setQuestion("Que veut dire le S des principes S.O.L.I.D ? (n'oubliez pas les majuscules!)");
                    cp.setRep("Single Responsibility Principle");
                    cp.setScore(0);


                    //si pas de pression
                    newStage.setTitle("Jeu");
                    newStage.setScene(newScene);
                    stage.hide();
                    newStage.show();
                }else{
                    affichage(message, nom, true);
                }
            }else{
                affichage(message, nom, false);
            }
        }
        if(entite.getClass() == Pnj.class){
            String message = ((Pnj) entite).getReplique();
            String nom = ((Pnj) entite).getNom();
            affichage(message, nom, false);
        }
        if(entite.getClass() == Prof.class){
            String message = ((Prof) entite).getCours();
            String nom = ((Prof) entite).getNom();
            affichage(message, nom, false);
            int quete = ((Prof) entite).getNumQuete();
            ArrayList<Quete> liste = Launcher.getLeManager().getJoueurEnCours().getListeQuete();
            for(int i = 0; i<liste.size(); i++){
                if(liste.get(i).getNumero() == quete){
                    if(!liste.get(i).getFait()){
                        liste.get(i).setFait(true);
                        Launcher.getLeManager().getJoueurEnCours().setNbQueteAFaire(1);
                    }
                }
            }
            Launcher.getLeManager().getJoueurEnCours().setListeQuete(liste);
        }
    }

    //node c'est group, vbox, button, label
    private Set<Node> markedNumbers = new HashSet<>();

    private void affichage(String message, String nom, Boolean secretaire) throws InterruptedException {
        String msg = nom + " : " + message;
        String quete="";

        Pane lemsg = new AnchorPane();

        lemsg.setMinHeight(470);
        lemsg.setMinWidth(740);
        lemsg.setOnMouseClicked(e -> reset());
        lemsg.setId("test");


        ImageView img = new ImageView();
        img.imageProperty().set(new Image("/imgs/map/speaker.png"));

        VBox contenutxt = new VBox();
        contenutxt.setPadding(new Insets(30, 20, 0, 20));
        Label lenom = new Label();
        Label mesg = new Label();
        //Cas du message de la secrétaire
        if(secretaire){
            if(Launcher.getLeManager().getLeBoucleur().isActif()){
                mesg.textProperty().set(message + " Il te reste " +Launcher.getLeManager().getLeBoucleur().getHeure()+" pour faire les "+Launcher.getLeManager().getJoueurEnCours().getNbQueteAFaire()+" quetes restantes !!");
                quete ="Voici vos quetes : \n";
                for(int i = 0; i<Launcher.getLeManager().getJoueurEnCours().getListeQuete().size(); i++){
                    quete = quete+Launcher.getLeManager().getJoueurEnCours().getListeQuete().get(i).toString()+"\n";
                }
                quete = quete;
            } else{
                mesg.textProperty().set("Malheureusement, tu es en retard ! Tu ne peux plus passer ton partiel !");
            }

        }else{
            mesg.textProperty().set(message);
        }

        lenom.textProperty().set(nom);
        lenom.setId("nomMsg");
        lenom.alignmentProperty().set(Pos.TOP_LEFT);
        mesg.setId("msgMsg");
        Label affichageQuete = new Label(quete);
        affichageQuete.setId("quete");

        contenutxt.getChildren().add(lenom);
        contenutxt.getChildren().add(mesg);
        lemsg.getChildren().add(img);
        lemsg.getChildren().add(contenutxt);
        AnchorPane a = new AnchorPane();
        AnchorPane.setBottomAnchor(affichageQuete, -470.0);
        a.getChildren().add(affichageQuete);
        AnchorPane.setRightAnchor(a, 20.0);
        lemsg.getChildren().add(a);
        markedNumbers.add(lemsg);
        zoneDeJeu.getChildren().add(lemsg);
    }

    private void reset() {
        for(Node node:markedNumbers){
            zoneDeJeu.getChildren().remove(node);
        }
        markedNumbers.clear();
    }

    public void reset2(KeyEvent event) {
        for(Node node:markedNumbers){
            zoneDeJeu.getChildren().remove(node);
        }
        markedNumbers.clear();
    }
}