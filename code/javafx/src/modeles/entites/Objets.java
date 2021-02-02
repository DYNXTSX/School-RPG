package modeles.entites;

public class Objets extends Entite{
    /**
     * Un objet a un nom et un message
     */
    private String nom;
    private String message;

    /**
     * Constructeur d'un objet
     * @param x => position x
     * @param y => position y
     * @param z => position z
     * @param image => son image
     * @param nom => son nom
     * @param message => son message
     */
    public Objets(double x, double y, double z, String image, String nom, String message) {
        super(x, y, z, image);
        this.nom = nom;
        this.message = message;
    }

    /**
     * Récupérer le message de l'objet
     * @return
     *        return son message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Récupérer le nom de l'objet
     * @return
     *        return son nom
     */
    public String getNom() {
        return nom;
    }
}
