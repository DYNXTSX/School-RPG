package modeles.serialisation;

import launch.Launcher;

import java.io.*;

public class Deseria {

    public double px = 0;
    public double py = 0;
    public String pseudo;

    public void readFromFile(){
        try {
            FileInputStream fis = new FileInputStream("dimension.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            px = (Double) ois.readObject();
            py = (Double) ois.readObject();
            pseudo = (String) ois.readObject();

        } catch (EOFException e) {
            System.out.println("Fichier Vide");
        } catch (FileNotFoundException e) {
            System.out.println("Erreur ouverture fichier");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public double getPx() {
        return px;
    }

    public double getPy() {
        return py;
    }

    public String getPseudo() { return pseudo; }
}
