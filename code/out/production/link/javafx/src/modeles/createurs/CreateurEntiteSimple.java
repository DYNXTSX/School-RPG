package modeles.createurs;

import modeles.Monde;
import modeles.entites.*;
import modeles.serialisation.Deseria;

public class CreateurEntiteSimple extends CreateurEntite {

    public int ajout;
    public int ajoutx;

    public CreateurEntiteSimple(){
        Deseria des = new Deseria();
        des.readFromFile();
        int gx = (int) des.getPx();
        if(gx != 0){gx = gx+1428;};
        int gy = (int) des.getPy();
        if(gy != 0){gy = gy+786;};
        //System.out.println("Chargement Fait !");
        //System.out.println(gx + " " + gy);
        ajout = 180 + gy;
        ajoutx = 0 + gx;
    }

    /**
     * Méthode pour créer notre joueur
     * @param m => monde dans lequel va être notre joueur
     * @return
     */
    public Joueur creerJoueur(Monde m){
        Deseria des = new Deseria();
        des.readFromFile();
        String pseudo = (String) des.getPseudo();
        Joueur retour = new Joueur(348, 230, 2,"/imgs/characters/repos/repos_2.png", pseudo);
        m.ajouterEntite(retour);
        return retour;
    }

    /**
     * Méthode pour créer notre maphaute
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public MapSuperposition creerMapHaute(Monde m){
        MapSuperposition haut = new MapSuperposition(-1428+ajoutx,-966+ajout,1,"/imgs/map/superposition_haute.png");
        m.ajouterEntite(haut);
        return haut;
    }

    /**
     * Méthode pour créer notre mapbasse
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public MapSuperposition creerMapBasse(Monde m){
        MapSuperposition bas = new MapSuperposition(-1428+ajoutx,-966+ajout,4,"/imgs/map/superposition_basse.png");
        m.ajouterEntite(bas);
        return bas;
    }

    /**
     * Méthode pour créer nos prof
     * @param m => monde dans lequel va être notre entite
     * @param num => Numero du prof
     * @return
     */
    public Prof creerProf(Monde m, int num){
        if(num == 1){
            Prof one = new Prof(40+ajoutx, -25+ajout, 3, "/imgs/profs/1.png", "Mme LEMAIRE", "Cours1",1,"Le S de SOLID : Single Responsibility Principle");
            m.ajouterEntite(one);
            return one;
        }
        if(num == 2){
            Prof one = new Prof(-685+ajoutx, 350+ajout, 3, "/imgs/profs/2.png","M LAURENT","Cours2",2,"Le O de SOLID : Open/Close Principle");
            m.ajouterEntite(one);
            return one;
        }
        if(num == 3){
            Prof one = new Prof(-580+ajoutx, 100+ajout, 3, "/imgs/profs/3.png","M POIRIER","Cours3",3,"Le L de SOLID : Liskov Substitution Principle");
            m.ajouterEntite(one);
            return one;
        }
        if(num == 4){
            Prof one = new Prof(1350+ajoutx, 80+ajout, 3, "/imgs/profs/4.png","Mme POUCHARD","Cours4",4,"Le I de SOLID : Interface Segregation Principle");
            m.ajouterEntite(one);
            return one;
        }
        if(num == 5){
            Prof one = new Prof(680+ajoutx, -230+ajout, 3, "/imgs/profs/5.png","Mme PAQUETTE","Cours5",5,"Le D de SOLID : Dependency Inversion Principle");
            m.ajouterEntite(one);
            return one;
        }
        return null;
    }

    /**
     * Méthode pour créer notre secrétaire
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public Objets creerObjtSecreatire(Monde m){
        Objets obj = new Objets(315+ajoutx,-22+ajout,0,"/imgs/map/objets/secretaire_bas.png","Secrétaire","Bienvenu à l'IUT !! ");
        m.ajouterEntite(obj);
        return obj;
    }

    /**
     * Méthode pour créer notre statue
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public Objets creerObjtStatue(Monde m) {
        Objets obj = new Objets(317+ajoutx,315+ajout,0,"/imgs/map/objets/statue_bas.png","Statue","Représente la sagesse de notre professeur de C");
        m.ajouterEntite(obj);
        return obj;
    }

    /**
     * Méthode pour créer notre affiche
     * @param m => monde dans lequel va être notre entite
     * @param num => numéro de l'affiche à créer
     * @return
     */
    public Objets creerObjetAffiche(Monde m, int num){
        if(num == 1){
            Objets obj = new Objets(0+ajoutx,-35+ajout,0,"/imgs/map/objets/affiche1_bas.png","Affiche","CE SOIR BOWLING !");
            m.ajouterEntite(obj);
            return obj;
        }
        if(num == 2){
            Objets obj = new Objets(-70+ajoutx,-35+ajout,0,"/imgs/map/objets/affiche2_bas.png","Affiche","SAMEDI TOURNOIS DE FOOT ! PSG VS OM");
            m.ajouterEntite(obj);
            return obj;
        }
        if(num == 3){
            Objets obj = new Objets(-270+ajoutx,441+ajout,0,"/imgs/map/objets/affiche3_bas.png","Affiche","BRAVO LES GAGNANTS DE LA LAN CS:GO");
            m.ajouterEntite(obj);
            return obj;
        }
        return null;
    }

    /**
     * Méthode pour créer notre ballon
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public Objets creerObjetBallon(Monde m) {
        Objets obj = new Objets(-160+ajoutx,-680+ajout,0,"/imgs/map/objets/ballon_bas.png","Ballon","SWITCH !");
        m.ajouterEntite(obj);
        return obj;
    }

    /**
     * Méthode pour créer notre cadre
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public Objets creerObjetCadre(Monde m) {
        Objets obj = new Objets(-490+ajoutx,-35+ajout,0,"/imgs/map/objets/cadre_bas.png","Cadre","Tableau représentant la secrétaire");
        m.ajouterEntite(obj);
        return obj;
    }

    /**
     * Méthode pour créer nos casiers
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public Objets creerObjetCasier(Monde m) {
        Objets obj = new Objets(815+ajoutx,-40+ajout,0,"/imgs/map/objets/casiers_bas.png","Casier","Ce n'est pas votre casier");
        m.ajouterEntite(obj);
        return obj;
    }

    /**
     * Méthode pour créer notre diplome
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public Objets creerObjetDiplome(Monde m) {
        Objets obj = new Objets(-445+ajoutx,-495+ajout,0,"/imgs/map/objets/diplome_bas.png","Diplome","Diplome d'ingénieur en Algo");
        m.ajouterEntite(obj);
        return obj;
    }

    /**
     * Méthode pour créer notre distributeur
     * @param m => monde dans lequel va être notre entite
     * @param num => numéro du distributeur
     * @return
     */
    public Objets creerObjetDistributeur(Monde m, int num) {
        if (num == 1) {
            Objets obj = new Objets(395+ajoutx, -730 + ajout, 0, "/imgs/map/objets/distributeur1_bas.png", "Distributeur", "Prend votre argent mais ne donne rien");
            m.ajouterEntite(obj);
            return obj;
        }
        if (num == 2) {
            Objets obj = new Objets(600+ajoutx, -495 + ajout, 0, "/imgs/map/objets/distributeur2_bas.png", "Distributeur", "Plus de kinder bueno");
            m.ajouterEntite(obj);
            return obj;
        }
        return null;
    }

    /**
     * Méthode pour créer notre eau
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public Objets creerObjetEau(Monde m) {
        Objets obj = new Objets(-210+ajoutx,-43+ajout,0,"/imgs/map/objets/eau1_bas.png","Eau","Un p'tit verre ?");
        m.ajouterEntite(obj);
        return obj;
    }

    /**
     * Méthode pour créer notre ordinateur
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public Objets creerObjetOrdinateur1(Monde m) {
        Objets obj = new Objets(478+ajoutx,-259+ajout,0,"/imgs/map/objets/ordinateur1_bas.png","Ordinateur","50 BITCOINS !");
        m.ajouterEntite(obj);
        return obj;
    }

    /**
     * Méthode pour créer notre ordinateur prof
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public Objets creerObjetOrdinateurProf(Monde m) {
        Objets obj = new Objets(73+ajoutx,-685+ajout,0,"/imgs/map/objets/ordinateurprof_bas.png","Ordinateur","Corrigé du controle de JAVAFX");
        m.ajouterEntite(obj);
        return obj;
    }

    /**
     * Méthode pour créer notre panneau prof
     * @param m => monde dans lequel va être notre entite
     * @param num => numéro du panneau
     * @return
     */
    public Objets creerObjetPanneauProf(Monde m, int num) {
        if(num == 1){
            Objets obj = new Objets(-390+ajoutx,60+ajout,0,"/imgs/map/objets/panneauprof.png","Panneau","Professeur de C");
            m.ajouterEntite(obj);
            return obj;
        }
        if(num == 2){
            Objets obj = new Objets(-390+ajoutx,-170+ajout,0,"/imgs/map/objets/panneauprof.png","Panneau","Professeur d'SQL");
            m.ajouterEntite(obj);
            return obj;
        }
        if(num == 3){
            Objets obj = new Objets(-390+ajoutx,-410+ajout,0,"/imgs/map/objets/panneauprof.png","Panneau","Professeur d'EPS");
            m.ajouterEntite(obj);
            return obj;
        }
        return null;
    }

    /**
     * Méthode pour créer notre tableau
     * @param m => monde dans lequel va être notre entite
     * @param num => numéro de tableau
     * @return
     */
    public Objets creerObjetTableau(Monde m, int num) {
        if(num == 1){
            Objets obj = new Objets(450+ajoutx,-40+ajout,0,"/imgs/map/objets/tableau1_bas.png","Tableau","Polochon de la petite sirène");
            m.ajouterEntite(obj);
            return obj;
        }
        if(num == 2){
            Objets obj = new Objets(450+ajoutx,-730+ajout,0,"/imgs/map/objets/tableau2_bas.png","Tableau","Au bord de l'eau");
            m.ajouterEntite(obj);
            return obj;
        }
        if(num == 3){
            Objets obj = new Objets(-600+ajoutx,205+ajout,0,"/imgs/map/objets/tableau3_bas.png","Tableau","Ceci est un lion");
            m.ajouterEntite(obj);
            return obj;
        }
        if(num == 4){
            Objets obj = new Objets(-90+ajoutx,-268+ajout,0,"/imgs/map/objets/tableau_bas.png","Tableau","Pourquoi ne pas dessiner un coeur ?");
            m.ajouterEntite(obj);
            return obj;
        }
        return null;
    }

    /**
     * Méthode pour créer notre tableau prof
     * @param m => monde dans lequel va être notre entite
     * @return
     */
    public Objets creerObjetTableauProf(Monde m) {
        Objets obj = new Objets(-620+ajoutx,-268+ajout,0,"/imgs/map/objets/tableauprof_bas.png","Tableau","Evolution du cours du BTC");
        m.ajouterEntite(obj);
        return obj;
    }

    /**
     * Méthode pour créer nos PNJs
     * @param m => monde dans lequel va être notre PNJ
     * @param num => le numéro du pnj
     * @return
     */
    public Pnj creerPng(Monde m, int num){
        if(num == 1){
            Pnj pnj = new Pnj(-50+ajoutx,400+ajout,0,"/imgs/pnj/bas/1.png","Papy","Salut petit ! Tu sais en quelle salle est le cours de C# ?");
            m.ajouterEntite(pnj);
            return pnj;
        }
        if(num == 2){
            Pnj pnj = new Pnj(-240+ajoutx,-490+ajout,0,"/imgs/pnj/bas/2.png","Théo","C'est le bureau du directeur ! Je l'attends pour lui poser des questions sur son cour !");
            m.ajouterEntite(pnj);
            return pnj;
        }
        if(num == 3){
            Pnj pnj = new Pnj(180+ajoutx,-630+ajout,0,"/imgs/pnj/bas/3.png","Miriem","LA BOUFFFFFFFE !!!! ");
            m.ajouterEntite(pnj);
            return pnj;
        }
        if(num == 4){
            Pnj pnj = new Pnj(750+ajoutx,200+ajout,0,"/imgs/pnj/droite/1.png","Nadia","Que veut dire le S des principes S.O.L.I.D ?");
            m.ajouterEntite(pnj);
            return pnj;
        }
        if(num == 5){
            Pnj pnj = new Pnj(800+ajoutx,200+ajout,0,"/imgs/pnj/gauche/1.png","Diana","Solidarité !");
            m.ajouterEntite(pnj);
            return pnj;
        }
        if(num == 6){
            Pnj pnj = new Pnj(-300+ajoutx,300+ajout,0,"/imgs/pnj/droite/2.png","Alexandre","Le cours de flexbox était trop facile ! Fallait faire un prof en pixelart !");
            m.ajouterEntite(pnj);
            return pnj;
        }
        if(num == 7){
            Pnj pnj = new Pnj(-150+ajoutx,-350+ajout,0,"/imgs/pnj/droite/3.png","JeSaisPasQuiCest","Moi de base je voulais être cycliste ! Mais finalement je fais de l'HTML.");
            m.ajouterEntite(pnj);
            return pnj;
        }
        if(num == 8){
            Pnj pnj = new Pnj(900+ajoutx,-450+ajout,0,"/imgs/pnj/gauche/2.png","Mathieu","C'est leur de manger !!!");
            m.ajouterEntite(pnj);
            return pnj;
        }
        if(num == 9){
            Pnj pnj = new Pnj(-530+ajoutx,-380+ajout,0,"/imgs/pnj/gauche/3.png","Mlle Mireille","Désolé, j'ai pas le temps j'ai rien à faire !");
            m.ajouterEntite(pnj);
            return pnj;
        }
        if(num == 10){
            Pnj pnj = new Pnj(390+ajoutx,320+ajout,0,"/imgs/pnj/haut/1.png","Camillia","J'adore cette statue ! ");
            m.ajouterEntite(pnj);
            return pnj;
        }
        if(num == 11){
            Pnj pnj = new Pnj(370+ajoutx,-230+ajout,0,"/imgs/pnj/haut/2.png","Cyril","J'ai envie de prendre un livre sur le système !! ");
            m.ajouterEntite(pnj);
            return pnj;
        }
        if(num == 12){
            Pnj pnj = new Pnj(980+ajoutx,-200+ajout,0,"/imgs/pnj/haut/3.png","Ludovic","Faut pas que je sois en retard pour le partiel...");
            m.ajouterEntite(pnj);
            return pnj;
        }
        return null;
    }
}
