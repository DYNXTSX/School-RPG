package modeles.entites;

public class MapSuperposition extends Entite {
    /**
     * Constructeur de la map superposition
     * => Une superposition basse : le joueur marche sur le sol
     * => Une superposition haute : le joueur est caché par le toit
     * @param x => position x
     * @param y => position y
     * @param z => position z
     * @param image => son image
     */
    public MapSuperposition(double x, double y, double z, String image) {
        super(x, y, z, image);
    }
}
