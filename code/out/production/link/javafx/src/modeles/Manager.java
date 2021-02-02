package modeles;

import boucleur.Boucleur;
import boucleur.BoucleurSimple;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modeles.collisionneur.Collisionneur;
import modeles.collisionneur.CollisionneurSimple;
import modeles.createurs.CreateurEntite;
import modeles.createurs.CreateurEntiteSimple;
import modeles.deplaceur.Deplaceur;
import modeles.deplaceur.DeplaceurSimple;
import modeles.entites.*;

public class Manager implements InvalidationListener {
    private Monde leMonde = new Monde();
    private CreateurEntite leCreateur = new CreateurEntiteSimple();
    private Boucleur leBoucleur = new BoucleurSimple();
    private Collisionneur leCollisionneur = new CollisionneurSimple();
    private Deplaceur leDeplaceur = new DeplaceurSimple(leCollisionneur);
    private Joueur joueurEnCours;
    private MapSuperposition mapHaute;
    private MapSuperposition mapBasse;

    //Partie Profs
    private Prof prof1;
    private Prof prof2;
    private Prof prof3;
    private Prof prof4;
    private Prof prof5;
    //Partie Objets
    private Objets obj1;
    private Objets obj2;
    private Objets ObjetAffiche2;
    private Objets ObjetAffiche1;
    private Objets ObjetAffiche3;
    private Objets ObjetBallon;
    private Objets ObjetCadre;
    private Objets ObjetCasier;
    private Objets ObjetDiplome;
    private Objets ObjetDistributeur1;
    private Objets ObjetDistributeur2;
    private Objets ObjetEau;
    private Objets ObjetOrdinateur1;
    private Objets ObjetOrdinateurProf;
    private Objets ObjetPanneauProf;
    private Objets ObjetPanneauProf2;
    private Objets ObjetPanneauProf3;
    private Objets ObjetTableau1;
    private Objets ObjetTableau2;
    private Objets ObjetTableau3;
    private Objets ObjetTableau;
    private Objets ObjetTableauProf;
    //Partie pnjs
    private Pnj pnj1;
    private Pnj pnj2;
    private Pnj pnj3;
    private Pnj pnj4;
    private Pnj pnj5;
    private Pnj pnj6;
    private Pnj pnj7;
    private Pnj pnj8;
    private Pnj pnj9;
    private Pnj pnj10;
    private Pnj pnj11;
    private Pnj pnj12;

    private int frameEnCour = 1;
    private String etatEnCour = "R";
    private String etatVerif = "R";

    public Manager(){
        mapBasse = leCreateur.creerMapBasse(leMonde);
        //OBJETS
        obj1 = leCreateur.creerObjtSecreatire(leMonde);
        obj2 = leCreateur.creerObjtStatue(leMonde);
        ObjetAffiche1 = leCreateur.creerObjetAffiche(leMonde, 1);
        ObjetAffiche2 = leCreateur.creerObjetAffiche(leMonde, 2);
        ObjetAffiche3 = leCreateur.creerObjetAffiche(leMonde, 3);
        ObjetBallon = leCreateur.creerObjetBallon(leMonde);
        ObjetCadre = leCreateur.creerObjetCadre(leMonde);
        ObjetCasier = leCreateur.creerObjetCasier(leMonde);
        ObjetDiplome = leCreateur.creerObjetDiplome(leMonde);
        ObjetDistributeur1 = leCreateur.creerObjetDistributeur(leMonde, 1);
        ObjetDistributeur2 = leCreateur.creerObjetDistributeur(leMonde, 2);
        ObjetEau = leCreateur.creerObjetEau(leMonde);
        ObjetOrdinateur1 = leCreateur.creerObjetOrdinateur1(leMonde);
        ObjetOrdinateurProf = leCreateur.creerObjetOrdinateurProf(leMonde);
        ObjetPanneauProf = leCreateur.creerObjetPanneauProf(leMonde, 1);
        ObjetPanneauProf2 = leCreateur.creerObjetPanneauProf(leMonde, 2);
        ObjetPanneauProf3 = leCreateur.creerObjetPanneauProf(leMonde, 3);
        ObjetTableau1 = leCreateur.creerObjetTableau(leMonde, 1);
        ObjetTableau2 = leCreateur.creerObjetTableau(leMonde, 2);
        ObjetTableau3 = leCreateur.creerObjetTableau(leMonde, 3);
        ObjetTableau = leCreateur.creerObjetTableau(leMonde, 4);
        ObjetTableauProf = leCreateur.creerObjetTableauProf(leMonde);

        pnj1 = leCreateur.creerPng(leMonde, 1);
        pnj2 = leCreateur.creerPng(leMonde, 2);
        pnj3 = leCreateur.creerPng(leMonde, 3);
        pnj4 = leCreateur.creerPng(leMonde, 4);
        pnj5 = leCreateur.creerPng(leMonde, 5);
        pnj6 = leCreateur.creerPng(leMonde, 6);
        pnj7 = leCreateur.creerPng(leMonde, 7);
        pnj8 = leCreateur.creerPng(leMonde, 8);
        pnj9 = leCreateur.creerPng(leMonde, 9);
        pnj10 = leCreateur.creerPng(leMonde, 10);
        pnj11 = leCreateur.creerPng(leMonde, 11);
        pnj12 = leCreateur.creerPng(leMonde, 12);

        prof1 = leCreateur.creerProf(leMonde, 1);
        prof2 = leCreateur.creerProf(leMonde, 2);
        prof3 = leCreateur.creerProf(leMonde, 3);
        prof4 = leCreateur.creerProf(leMonde, 4);
        prof5 = leCreateur.creerProf(leMonde, 5);

        joueurEnCours = leCreateur.creerJoueur(leMonde);

        mapHaute = leCreateur.creerMapHaute(leMonde);
        leBoucleur.addListener(this);
        leBoucleur.setActif(true);
        new Thread(leBoucleur).start();
    }

    /**
     * Mettre à jour le pseudo du joueur
     * @param nom
     *           Le nom est le nouveau nom à donner au joueur
     */
    public void setPseudo(String nom){
        joueurEnCours.setPseudo(nom);
    }

    /**
     * Récupérer le boucleur (acceder au temps qu'il reste, savoir si nous sommes en game over)
     * @return
     */
    public Boucleur getLeBoucleur() {
        return leBoucleur;
    }

    /**
     * Récupérer toutes les entités
     * @return
     */
    public  ObservableList<Entite> getListeEntite(){
        return leMonde.getLesEntites();
    }

    /**
     * Récupérer toutes les entités à déplacer
     * @return
     */
    public  ObservableList<Entite> getListeEntiteToMove(){
        return leMonde.getLesEntitesABouger();
    }

    /**
     * Récupérer le joueur en cours
     * @return
     */
    public Joueur getJoueurEnCours() {
        return joueurEnCours;
    }

    /**
     * Récupérer la "MapHaute".
     * La map haute désigne l'entité qui se situe (en terme de superposition) au dessus du joueur.
     * C'est à dire que quand le joueur a une position x et y se situe au même niveau que la mapHaute.
     * Alors, le joueur sera "caché" par cette image.
     *
     * @return
     */
    public MapSuperposition getMapHaute() {
        return mapHaute;
    }

    /**
     * Arreter le boucleur
     */
    public void stopBoucleur(){
        leBoucleur.setActif(false);
    }

    @Override
    public void invalidated(Observable observable) {

    }

    /**
     * Récupérer le collisionneur
     * @return
     */
    public Collisionneur getLeCollisionneur() {
        return leCollisionneur;
    }

    /**
     * Mettre a jour l'état en cours.
     * Cela devait servir pour nos frames définir un état avancer, reculer, aller a gauche, aller a droite et repos.
     * De façon à ce que quand le personnage était en état repos, déclencher une animation de repos
     *
     * @param e
     */
    public void setEtatEnCour(String e){etatEnCour = e;}

    /**
     * Vérifier si notre frame suivante ne dépassait pas la liste des frames.
     * Sinon recommencer l'animation des frames en repartant de 1.
     */
    public void verifFrame(){
        if(frameEnCour > 10){
            frameEnCour = 1;
        }
        else {
            frameEnCour = frameEnCour + 1;
        }
    }

    /**
     * Mettre à jour la vue.
     * A la suite du déplacement des entités, nous avons pu remarquer que les éléments nouvellement modifié se plaçaient au dessus en terme de superposition.
     * Pour cela, nous devions supprimer le joueur et la maphaute, de façon à les rerajouter pour qu'ils soient supperposer au dessus du reste.
     */
    public void majVue(){
        leMonde.supprimerEntite(joueurEnCours);
        leMonde.ajouterEntite(joueurEnCours);
        leMonde.supprimerEntite(mapHaute);
        leMonde.ajouterEntite(mapHaute);
    }

    /**
     * Récupérer le créateur pour nos sérialisation
     * @return
     */
    public CreateurEntite getLeCreateur() {
        return leCreateur;
    }

    /**
     * Fonction servant à changer l'état du personnage en fonction de son déplacement
     * @param event
     *              C'est la touche pressé par le joueur
     */
    public void modifierEtat(KeyEvent event){
        if(event.getCode() == KeyCode.A || event.getCode() == KeyCode.Z || event.getCode() == KeyCode.Q || event.getCode() == KeyCode.D){
            setEtatEnCour("R");
        }
    }

    /**
     * Méthode permettant le déplacement de notre joueur.
     * En fonction de la touche pressé (Z / Q / S / D) effectue un déplacement
     * => Déplacer toutes les entités à déplacer
     * => Vérifier la frame
     * => Mettre à jour la frame
     * => Resuperposer le joueur et la maphaute au dessus
     *
     * @param event
     *              C'est la touche pressé par le joueur
     */
    public void deplace(KeyEvent event) {
        if(event.getCode() == KeyCode.Z){
            for(Entite e : getListeEntiteToMove()){
                leDeplaceur.moveUp(e, getMapHaute());
            }
            verifFrame();
            joueurEnCours.setImage("/imgs/characters/avancer/avance_" + frameEnCour + ".png");
            setEtatEnCour("Z");
            majVue();
        }
        if(event.getCode() == KeyCode.S){
            for(Entite e : getListeEntiteToMove()){
                leDeplaceur.moveDown(e, getMapHaute());
            }
            verifFrame();
            joueurEnCours.setImage("/imgs/characters/reculer/recule_" + frameEnCour + ".png");
            setEtatEnCour("S");
            majVue();
        }
        if(event.getCode() == KeyCode.Q){
            for(Entite e : getListeEntiteToMove()){
                leDeplaceur.moveLeft(e, getMapHaute());
            }
            verifFrame();
            joueurEnCours.setImage("/imgs/characters/gauche/gauche_" + frameEnCour + ".png");
            setEtatEnCour("Q");
            majVue();
        }
        if(event.getCode() == KeyCode.D){
            for(Entite e : getListeEntiteToMove()){
                leDeplaceur.moveRight(e, getMapHaute());
            }
            verifFrame();
            joueurEnCours.setImage("/imgs/characters/droite/droite_" + frameEnCour + ".png");
            setEtatEnCour("D");
            majVue();
        }
    }
}
