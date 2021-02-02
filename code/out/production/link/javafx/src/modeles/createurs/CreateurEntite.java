package modeles.createurs;

import modeles.Monde;
import modeles.entites.*;

public abstract class CreateurEntite {

    /**
     * Méthode pour créer notre joueur
     * @param m => monde dans lequel va être notre joueur
     * @return => le joueur
     */
    public abstract Joueur creerJoueur(Monde m);

    /**
     * Méthode pour créer notre maphaute
     * @param m => monde dans lequel va être notre entite
     * @return => la mapsuperposition
     */
    public abstract MapSuperposition creerMapHaute(Monde m);

    /**
     * Méthode pour créer notre mapbasse
     * @param m => monde dans lequel va être notre entite
     * @return => la mapsuperposition
     */
    public abstract MapSuperposition creerMapBasse(Monde m);


    /**
     * Méthode pour créer un prof
     * @param m => monde dans lequel va être notre entite
     * @param num => Numero du prof
     * @return => le prof
     */
    public abstract Prof creerProf(Monde m, int num);

    /**
     * Méthode pour créer notre secrétaire
     * @param m => monde dans lequel va être notre entite
     * @return => la secrétaire
     */
    public abstract Objets creerObjtSecreatire(Monde m);

    /**
     * Méthode pour créer notre statue
     * @param m => monde dans lequel va être notre entite
     * @return => la statue
     */
    public abstract Objets creerObjtStatue(Monde m);

    /**
     * Méthode pour créer notre affiche
     * @param m => monde dans lequel va être notre entite
     * @return => l'affiche
     */
    public abstract Objets creerObjetAffiche(Monde m, int num);

    /**
     * Méthode pour créer notre ballon
     * @param m => monde dans lequel va être notre entite
     * @return => le ballon
     */
    public abstract Objets creerObjetBallon(Monde m);

    /**
     * Méthode pour créer notre cadre
     * @param m => monde dans lequel va être notre entite
     * @return => le cadre
     */
    public abstract Objets creerObjetCadre(Monde m);

    /**
     * Méthode pour créer nos casiers
     * @param m => monde dans lequel va être notre entite
     * @return => les casiers
     */
    public abstract Objets creerObjetCasier(Monde m);

    /**
     * Méthode pour créer notre diplome
     * @param m => monde dans lequel va être notre entite
     * @return => le diplome
     */
    public abstract Objets creerObjetDiplome(Monde m);

    /**
     * Méthode pour créer notre Distributeur
     * @param m => monde dans lequel va être notre entite
     * @param num => numéro du distributeur
     * @return => le distributeur
     */
    public abstract Objets creerObjetDistributeur(Monde m, int num);

    /**
     * Méthode pour créer notre eau
     * @param m => monde dans lequel va être notre entite
     * @return => l'eau
     */
    public abstract Objets creerObjetEau(Monde m);

    /**
     * Méthode pour créer notre ordinateur
     * @param m => monde dans lequel va être notre entite
     * @return => l'ordinateur
     */
    public abstract Objets creerObjetOrdinateur1(Monde m);

    /**
     * Méthode pour créer notre ordinateur de prof
     * @param m => monde dans lequel va être notre entite
     * @return => l'ordinateur prof
     */
    public abstract Objets creerObjetOrdinateurProf(Monde m);

    /**
     * Méthode pour créer notre panneau prof
     * @param m => monde dans lequel va être notre entite
     * @param num => numéro du panneau
     * @return => le panneau
     */
    public abstract Objets creerObjetPanneauProf(Monde m, int num);

    /**
     * Méthode pour créer notre tableau
     * @param m => monde dans lequel va être notre entite
     * @param num => numéro de tableau
     * @return => le tableau
     */
    public abstract Objets creerObjetTableau(Monde m, int num);

    /**
     * Méthode pour créer notre tableau prof
     * @param m => monde dans lequel va être notre entite
     * @return => le tableau prof
     */
    public abstract Objets creerObjetTableauProf(Monde m);

    /**
     * Méthode pour créer un PNJ
     * @param m => monde dans lequel va être notre PNJ
     * @param num => le numéro du pnj
     * @return
     */
    public abstract Pnj creerPng(Monde m, int num);
}
