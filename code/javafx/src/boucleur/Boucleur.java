package boucleur;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import java.util.ArrayList;
import java.util.List;

public abstract class Boucleur implements Runnable, Observable {

    private List<InvalidationListener> lesObservateurs = new ArrayList<>();
    private int couldownMinutes = 10;
    private int couldownSecondes = 0;
    protected boolean gameOver = false;
    protected boolean actif = false;

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @Override
    public void addListener(InvalidationListener listener) {
        lesObservateurs.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        lesObservateurs.remove(listener);
    }

    protected void beep(){
        lesObservateurs.forEach(o -> o.invalidated(this));
    }

    protected void isGameOver(){
        if(couldownMinutes == 0 && couldownSecondes ==0){
            gameOver = true;
        }
    }

    protected void heure(){
        isGameOver();
        if(couldownSecondes == 0){
            couldownSecondes = 59;
            couldownMinutes--;
        }
        else{
            couldownSecondes--;
        }
    }

    public String getHeure(){
        return couldownMinutes + "m "+couldownSecondes+ "s";
    }
}
