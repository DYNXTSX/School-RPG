package modeles.serialisation;

import launch.Launcher;

import java.io.*;

public class Seria {
    public void saveDataToFile(){
        //Nous souhaitons sauvegarder la position x et y des éléments ainsi que le pseudo du joueur
        double posx = Launcher.getLeManager().getMapHaute().getX();
        double posy = Launcher.getLeManager().getMapHaute().getY();
        String pseudo = Launcher.getLeManager().getJoueurEnCours().getPseudo();

        try {

            FileOutputStream fos = new FileOutputStream("dimension.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(posx);
            os.writeObject(posy);
            os.writeObject(pseudo);
            os.close();
            System.out.println("Sauvegarde : " + posx + " " + posy + " " + pseudo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
