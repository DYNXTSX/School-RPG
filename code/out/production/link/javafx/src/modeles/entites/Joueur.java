package modeles.entites;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Joueur extends Entite{
    /**
     * Une joueur a un pseudo
     * => Ici, pour le data-binding nous avons
     * getPseudo() => récupérer le pseudo
     * pseudoProperty() => récupérer le pseudo pour le get et set
     * setPseudo() => mettre à jour le pseudo
     */
    private StringProperty pseudo = new SimpleStringProperty();
    public String getPseudo() {
        return pseudoProperty().get();
    }
    public StringProperty pseudoProperty(){
        return pseudo;
    }
    public void setPseudo(String value) {
        pseudoProperty().set(value);
    }

    /**
     * Un joueur a un nombre de quete à faire (ici, 5)
     * Et il a également une liste de quete
     */
    private int nbQueteAFaire = 5;
    private ArrayList<Quete> listeQuete;

    /**
     * Constructeur d'un Joueur
     * @param x => position x
     * @param y => position y
     * @param z => position z
     * @param image => son image
     * @param pseudo => son pseudo
     */
    public Joueur(double x, double y, double z, String image, String pseudo){
        super(x, y, z,image);
        setPseudo(pseudo);
        this.listeQuete = new ArrayList<>();
        for(int i = 1; i<=this.getNbQueteAFaire(); i++){
            listeQuete.add(new Quete(i, "Quete "+i));
        }
    }

    /**
     * Partie quete :
     * getListeQuete() => récupérer la liste des quetes
     * @return
     */
    public ArrayList<Quete> getListeQuete(){ return this.listeQuete; }

    /**
     * Récupérer le nombre de quete à faire
     * @return
     */
    public int getNbQueteAFaire(){ return this.nbQueteAFaire; }

    /**
     * Mettre à jour la liste de quete
     * @param liste
     */
    public void setListeQuete(ArrayList<Quete> liste){ this.listeQuete = liste; }

    /**
     * Mettre à jour le nombre de quete à faire
     */
    public void setNbQueteAFaire(int i){this.nbQueteAFaire = this.nbQueteAFaire- i;}
}
