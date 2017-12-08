package com.puzzle.rpgvida;

import com.puzzle.rpgvida.Utilitarios.Utilitaria;

/**
 * Created by acneidert on 04/12/17.
 */

public class Perfil {
    private long id;
    private String nome;
    private String user;
    private String senha;
    private int xp;
    private boolean isLogged;

    public Perfil() {
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public Perfil(long id) {
        this.id = id;
    }
    public Perfil(boolean createNull) {
        if(createNull){
            id = 0;
            nome = null;
            user = null;
            senha = null;
            xp = 0;
            isLogged = false;
        }
    }

    public Perfil(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public Perfil(long id, String nome, String user, String senha, int xp) {
        this.id = id;
        this.nome = nome;
        this.user = user;
        this.senha = senha;
        this.xp = xp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void incXp(double dificuldade) {
        this.xp = xp + (int) ((dificuldade*100)* Integer.parseInt((Utilitaria.RetornaNivel(xp) + "")));
    }
}
