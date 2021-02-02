package modeles.entites;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Entite {
    /**
     * Nos entite ont une position x qui leurs est bindé
     * => getX() : récupérer le x
     * => setX() : mettre à jour le x
     */
    protected DoubleProperty x = new SimpleDoubleProperty();
    public double getX() {return x.get();}
    public DoubleProperty xProperty(){return x;}
    public void setX(double x){this.x.set(x);}

    /**
     * Nos entite ont une position y qui leurs est bindé
     * => getY() : récupérer le y
     * => setY() : mettre à jour le y
     */
    protected DoubleProperty y = new SimpleDoubleProperty();
    public double getY() {return y.get();}
    public DoubleProperty yProperty(){return y;}
    public void setY(double y){this.y.set(y);}

    /**
     * Nos entite ont une position Z qui leurs est bindé
     * => getZ() : récupérer le z
     * => setZ() : mettre à jour le z
     */
    protected DoubleProperty z = new SimpleDoubleProperty();
    public double getZ() {return z.get();}
    public DoubleProperty zProperty(){return z;}
    public void setZ(double z){this.z.set(z);}

    /**
     * Chaque entite a une image qui le représente
     */
    protected String image;

    /**
     * Méthode pour récupérer le chemin de l'image
     * @return
     */
    public String getImage() {
        return image;
    }

    /**
     * Méthode pour mettre à jour l'image
     * @param image
     *              nous passons en paramètre le chemin de l'image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Constructeur d'une entite
     * @param x => position x
     * @param y => position y
     * @param z => position z
     * @param image => une image qui le représente
     */
    public Entite(double x, double y, double z, String image){
        this.x.set(x);
        this.y.set(y);
        this.image = image;
    }


}
