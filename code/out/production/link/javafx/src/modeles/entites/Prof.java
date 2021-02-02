package modeles.entites;

public class Prof extends Pnj{
    /**
     * Un prof a un un numéro de quete qui lui est attribué
     * Un prof a un cours qui lui est attribué
     */
    private int numQuete;
    private String cours;

    /**
     * Constructeur du prof
     * @param x => position x
     * @param y => position y
     * @param z => position z (superposition)
     * @param image => son image
     * @param nom => un nom
     * @param replique => une réplique
     * @param q => Son numéro de cours
     * @param c => Un descriptif de son cours
     */
    public Prof(double x, double y, double z, String image, String nom, String replique, int q, String c) {
        super(x, y, z, image, nom, replique);
        this.numQuete = q;
        this.cours = c;
    }

    /**
     * Récupérer le cours du prof
     * @return
     *        return le cours du prof
     */
    public String getCours() {
        return cours;
    }

    /**
     * Récupérer le numéro du cours du prof
     * @return
     *        return son numéro de cours
     */
    public int getNumQuete(){
        return numQuete;
    }

}
