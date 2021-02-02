package boucleur;

public class BoucleurSimple extends Boucleur{

    @Override
    public void run() {
        while(actif){
            beep();
            if(gameOver){
                actif = false;
            }
            heure();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                actif = false;
            }
        }
    }
}
