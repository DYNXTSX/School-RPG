package modeles.entites;

public class Pnj extends Entite{
    /**
     * Un pnj a un nom et une réplique
     */
    private String nom;
    private String replique;

    /**
     * Constructeur de notre PNJ
     * @param x => position x
     * @param y => position y
     * @param z => position z
     * @param image => son image
     * @param nom => son nom
     * @param replique => sa réplique
     */
    public Pnj(double x, double y, double z, String image, String nom, String replique) {
        super(x, y, z, image);
        this.nom = nom;
        this.replique = replique;

    }

    /**
     * Récupérer le nom du PNJ
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Récupérer la réplique du PNJ
     * @return
     */
    public String getReplique() {
        return replique;
    }
}
