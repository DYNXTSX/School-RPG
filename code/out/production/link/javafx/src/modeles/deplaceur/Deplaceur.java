package modeles.deplaceur;

import modeles.collisionneur.Collisionneur;
import modeles.entites.Entite;
import modeles.entites.Joueur;

public abstract class Deplaceur {

    /**
     * Pour notre deplaceur, nous avons besoin :
     * d'un pas => qui définir la distance que va parcourir notre personnage
     * du collisionneur => qui va vérifier la présente ou non d'un objet solide que notre personnage ne peut pas traverser (un mur par exemple)
     */
    protected int pas;
    protected Collisionneur leCollisionneur;

    /**
     * Constructeur de notre Deplaceur
     * @param unCollisionneur => un collisionneur pour vérifier la présence d'objets solide lors d'un déplacement
     */
    public Deplaceur (Collisionneur unCollisionneur){
        leCollisionneur = unCollisionneur;
    }

    /**
     * Deplacement vers le haut
     * @param e => entite a déplacer
     * @param m => la map haute
     */
    public abstract void moveUp(Entite e, Entite m);

    /**
     * Deplacement vers le bas
     * @param e => entite a déplacer
     * @param m => la map haute
     */
    public abstract void moveDown(Entite e, Entite m);

    /**
     * Deplacement vers la gauche
     * @param e => entite a déplacer
     * @param m => la map haute
     */
    public abstract void moveLeft(Entite e, Entite m);

    /**
     * Deplacement vers la droite
     * @param e => entite a déplacer
     * @param m => la map haute
     */
    public abstract void moveRight(Entite e, Entite m);

    /**
     * Return le pas
     * @return
     */
    public int getPas() {
        return pas;
    }

}
