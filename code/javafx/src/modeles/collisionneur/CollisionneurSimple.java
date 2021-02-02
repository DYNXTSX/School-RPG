package modeles.collisionneur;


public class CollisionneurSimple extends Collisionneur {
    /**
     * Fonction pour savoir si le joueur peur aller a l'endroit qu'il souhaite aller / définir les collisions
     * @param x => position x
     * @param y => position y
     * @return
     */
    @Override
    public boolean canMove(double x, double y) {
        if (    // Murs tour
                (y <= -1130 && x <= -1138)
                        || (x <= -2148 && y >= -1106 && y<= -876)
                        || (x <= -1138 && y <= -1106 && y >= -1376)
                        || (x >= -1128 && y <= -1376)
                        || (x <= -648 && x >= -688 && y >= -1366 && y <= -1006)
                        || (x >= -108)
                        || (x <= -108 && x >= -418 && y >= -956)
                        || (x <= -108 && x >= -688 && y >= -936 && y <= -876)
                        || (x >= -688 && y >= -266)
                        || (y >= -6)
                        || (x <= -1618 && y >= -246)
                        || (x <= -2818)
                        //MURS INTERIEURS
                        || (x<= -2148 && x >= -2198 && y >= -816 && y <= -306) //Murs sale droite
                        || (x <= -1708 && x >= -2038 && y <= -636 && y >= -696) //Murs classe droite
                        || (x <= -2008 && x >= -2038 && y <= -416 && y >= -696) //Murs droit salle droite
                        || (x <= -1278 && x >= -1568 && y <= -646 && y >= -706) //Murs secrétaire
                        || (x <= -1188 && x >= -1228 && y <= -416 && y >= -696) //Murs gauche bibliotheque
                        || (x <= -818 && x >= -2038 && y >= -496 && y <= -416) //Murs arriere biblio
                        || (x <= -1318 && x >= -1528 && y <= -536 && y>= -606) //Murs inté biblio
                        || (x <= -1608 && x >= -1658 && y <= -506 && y >= -696) //Murs droit biblio
                        || (x <= -818 && x >= -1138 && y <= -626 && y >= - 696) //Mur avant salle de classe gauche
                        || (x <= -818 && x>= -948 && y <= -416 && y >= -686) //Mur gauche salle de classe gauche
                        || (x <= -698 && x >= -828 && y <= -1116 && y >= -1176) //Murs haut salle musique
                        || (x <= -648 && x >= -698 && y <= -856 && y >= -876) //Murret bureau 1
                        || (x <= -648 && x >= -698 && y <= -626 && y >= -786) //Murret bureau 1 et 2
                        || (x >= -646 && y >= -726 && y <= -646) //Mur séparation bureau 1 et 2
                        || (x <= -648 && x >= -698 && y >= -546 && y <= -396) //Murret bureau 2 et 3
                        || (x >= -646 && y <= -416 && y >= -486) //Mur séparation bureau 2 et 3
                        || (x <= -648 && x >= -698 && y >= -326) //Murret bueau 3
                        || (x <= -708 && x >= -728 && y <= -186 && y>= -246) //Murret directeur
                        || (x <= -788 && x >= -1228 && y <= -186 && y >= -246) //Mur directeur
                        || (x <= -1198 && x >= -1228 && y >= -186) //Mur 2 directeur
                        // Salle principale
                        || (x <= -1358 && x >= -1478 && y <= -946  && y >= -1046)//statue
                        || (x <= -1358 && x >= -1488 && y <= -716 && y >= -756) //secrétaire
                        || (x <= -1748 && x >= -1778 && y <= -1046 && y >= -1076)//plante 1
                        || (x <= -1918 && x >= -1948 && y <= -1046 && y >= -1076)//plante 2
                        || (x <= -1738 && x >= -1998 && y <= -706 && y >= -716)//casiers
                        || (x <= -828 && x >= -878 && y <= -696 && y >= -716)//eau
                        // Salle de musique
                        || (x <= -696 && x >= -728 && y <= -1186 && y >= -1206) //enceinte
                        || (x <= -818 && x >= -868 && y <= -1246 && y >= -1296) //piano
                        // Salle de TP
                        || (x <= -168 && x >= -228 && y <= -1176 && y >= -1226)
                        || (x <= -298 && x >= -348 && y <= -1176 && y >= -1226)
                        || (x <= -528 && x >= -588 && y <= -1176 && y >= -1226)
                        || (x <= -528 && x >= -588 && y <= -1066 && y >= -1116)
                        || (x <= -288 && x >= -468 && y <= -1066 && y >= -1116)
                        // BUREAU 1
                        || (x <= -428 && x >= -538 && y <= -746 && y >= -796)
                        || (x >= -498 && y <= -716 && y >= -736)
                        // BUREAU 2
                        || (x <= -478 && x >= -588 && y <= -496 && y >= -566)
                        // BUREAU 3
                        || (x >= -528 && y >= -296)
                        // BUREAU PROF
                        || (x <= -748 && x >= -798 && y <= -66 && y >= -116)
                        || (x <= -708 && x >= -748 && y <= -16 && y >= -76)
                        || (x <= -758 && x >= -828 && y <= -16 && y >= -46)
                        || (x <= -928 && x >= -1168 && y <= -16 && y >= -26)
                        || (x <= -1028 && x >= -1168 && y <= -36 && y >= -56)
                        || (x <= -1118 && x >= -1168 && y <= -66 && y >= -106)
                        // CUISINE
                        || (x <= -1268 && x >= -1388 && y <= -96 && y >= -206) //table
                        || (x <= -1258 && x >= -1498 && y <= -16 && y >= -26) //partie fond
                        || (x <= -1488 && x >= -1608 && y <= -106 && y >= -176) //table 2
                        // CLASSE DROITE
                        || (x <= -1738 && x >= -1978 && y <= -566 && y >= -626) //table
                        || (x <= -1908 && x >= -1978 && y <= -506 && y >= -556) //bureau
                        // CLASSE GAUCHE
                        || (x <= -958 && x >= -1108 && y <= -566 && y >= -616) //bureau
                        // SALLE DE CONTROLE
                        || (x <= -2448 && x >= -2618 && y <= -776 && y >= -836) //bureau
        )
            return false;
        return true;
    }

}
