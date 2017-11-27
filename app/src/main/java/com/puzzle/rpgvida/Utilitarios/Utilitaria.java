package com.puzzle.rpgvida.Utilitarios;

/**
 * Created by dieisson on 27/11/17.
 */

public class Utilitaria {
    public static int RetornaNivel(double xp){
        int countnivel = 1;
        int xpnivel = 1000;
        while (xp > xpnivel){
            countnivel ++;
            xp = xp/1.5;
        }
        return countnivel;
    }
}
