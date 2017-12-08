package com.puzzle.rpgvida;

/**
 * Created by acneidert on 07/12/17.
 */

class Session {
    private static final Session ourInstance = new Session();
    private static Perfil perfil = null;

    static Session getInstance() {
        return ourInstance;
    }

    private Session() {
    }

    public static Perfil getPerfil(){
        if(perfil == null){
            perfil = new Perfil(true);
        }
        return perfil;
    }

    public static void setPerfil(Perfil p){
        perfil = p;
    }
}
