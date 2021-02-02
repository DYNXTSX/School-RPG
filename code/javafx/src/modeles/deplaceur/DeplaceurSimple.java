package modeles.deplaceur;


import launch.Launcher;
import modeles.collisionneur.Collisionneur;
import modeles.entites.Entite;

public class DeplaceurSimple extends Deplaceur{

    /**
     * Constructeur de notre DeplaceurSimple avec un collisionneur et un pas qui lui est initialisé.
     * @param unCollisionneur => Pour les collisions
     *
     */
    public DeplaceurSimple(Collisionneur unCollisionneur) {
        super(unCollisionneur);
        pas = 10;
    }

    /**
     * Déplacement vers le haut
     * => Si on peut déplacer l'entité, alors on met a jours son x et son y
     *
     * @param e => entite a déplacer
     * @param m => la map haute
     */
    @Override
    public void moveUp(Entite e, Entite m) {
        if(leCollisionneur.canMove(m.getX(), m.getY()+getPas())){
            e.setX(e.getX());
            e.setY(e.getY()+getPas());
        }

    }

    /**
     * Déplacement vers le bas
     * => Si on peut déplacer l'entité, alors on met a jours son x et son y
     *
     * @param e => entite a déplacer
     * @param m => la map haute
     */
    @Override
    public void moveDown(Entite e, Entite m) {
        if(leCollisionneur.canMove(m.getX(), m.getY()-getPas())){
            e.setX(e.getX());
            e.setY(e.getY()-getPas());
        }
    }

    /**
     * Déplacement vers la gauche
     * => Si on peut déplacer l'entité, alors on met a jours son x et son y
     *
     * @param e => entite a déplacer
     * @param m => la map haute
     */
    @Override
    public void moveLeft(Entite e, Entite m) {
        if(leCollisionneur.canMove(m.getX() + getPas(), m.getY())){
            e.setX(e.getX()+getPas());
            e.setY(e.getY());
        }

    }

    /**
     * Déplacement vers la droite
     * => Si on peut déplacer l'entité, alors on met a jours son x et son y
     *
     * @param e => entite a déplacer
     * @param m => la map haute
     */
    @Override
    public void moveRight(Entite e, Entite m) {
        if(leCollisionneur.canMove(m.getX()-getPas(), m.getY())){
            e.setX(e.getX()-getPas());
            e.setY(e.getY());
        }
    }



}
