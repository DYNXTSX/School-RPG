package modeles.entites;

public class Quete {
    /**
     * Une quete est définie par un numéro de quete,
     * Une présentation de cette quete,
     * Un booleen pour savoir si elle est faite ou non
     * Et le texte de cette quete
     */
    private int numero;
    private String presentation;
    private Boolean fait;
    private String cours;
    /**
     * Constructeur prenant en paramètres
     * @param numero
     *              Un numéro de quete
     * @param presentation
     *                    Une présentation de cette quete
     *
     * => Bien évidement, nous initialisons la quete en "non fait"
     */
    public Quete(int numero, String presentation){
        this.presentation = presentation;
        this.cours = "T'a paas encore le cours Narvalo!";
        this.numero = numero;
        this.fait = false;
    }

    /**
     * Récupérer le numéro de la quete
     * @return
     *        return le numéro de la quete
     */
    public int getNumero(){
        return this.numero;
    }

    /**
     * Récupérer le booleen afin de savoir si la quete est faite ou non
     * @return
     *        return le booleen de la quete
     */
    public Boolean getFait(){
        return this.fait;
    }

    /**
     * Mettre à jour la quete, définir si elle est faite ou non
     * @param b
     */
    public void setFait(Boolean b){
        this.fait = b;
    }

    /**
     * Récupérer le cours
     * @return
     */
    public String getCours() {
        return cours;
    }

    /**
     * Mettre à jours le cours
     * @param cours
     */
    public void setCours(String cours) {
        this.cours = cours;
    }

    /**
     * toString pour écrire la quete suivi de son booleen (utilisé par la secrétaire)
     * @return
     *        return le message contenant le text complet
     */
    @Override
    public String toString(){
        String message = "Quete "+ this.getNumero()+" ";
        if(this.getFait()){
            message = message+"faite";
        }else{
            message = message+"pas faite";
        }
        return message;
    }
}