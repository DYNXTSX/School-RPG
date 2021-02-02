package modeles;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modeles.entites.Entite;
import modeles.entites.Joueur;
import modeles.entites.Pnj;

public class Monde {
    /**
     * Cette observableList contient toutes nos entite
     * observableListe => événements de mise a jours dans les listes quand leur contenu est modifié
     * FXCollections => contient des méthodes permettant de créer de nouvelles collections observables
     *
     * Cette liste nous est utile pour stocker toutes nos entite (plus facile pour les deplacer, etc)
     */
    private ObservableList<Entite> lesEntites = FXCollections.observableArrayList();

    /**
     * Permet d'ajouter une entite dans notre liste observable
     * @param e
     *          C'est l'entite passe en parametre, a ajouter dans la liste
     */
    public void ajouterEntite(Entite e){
        lesEntites.add(e);
    }

    /**
     * Permet de supprimer une entite de notre liste observable
     * @param e
     *           C'est l'entite passe en parametre, a supprimer de la liste
     */
    public void supprimerEntite(Entite e){
        lesEntites.remove(e);
    }

    /**
     * Permet de nous retourner notre liste d'entite
     * unmodifiableObservableList => liste non modifiable
     * @return
     */
    public ObservableList<Entite> getLesEntites(){
        return FXCollections.unmodifiableObservableList(lesEntites);
    }

    /**
     * Permet de nous retourner notre liste d'entite à déplacer (tous sauf le joueur)
     * Nous sommes parti du principe quand dans les anciens jeu, le personnage restait toujours au milieu et c'est le fond qui se déplacait
     * @return
     *          return une liste non modifiable des entites à déplacer
     */
    public ObservableList<Entite> getLesEntitesABouger(){
        ObservableList<Entite> abouger = FXCollections.observableArrayList();
        for(Entite e : lesEntites){
            if(e.getClass() != Joueur.class){
                abouger.add(e);
            }
        }
        return FXCollections.unmodifiableObservableList(abouger);
    }
}
