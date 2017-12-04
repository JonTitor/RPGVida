package com.puzzle.rpgvida;

/**
 * Created by dieisson on 24/11/17.
 */

public class Missao {
    private String nome;
    private String descricao;
    private int dificuldade;
    private boolean feito;
    private long id;


    public Missao() {
    }

    public Missao(String nome, String descricao, int dificuldade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;

    }

    public Missao(String nome, String descricao, int dificuldade, boolean feito, long id) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.feito = feito;
        this.id = id;
    }

    public boolean getFeito() {
        return feito;
    }

    public long getId() {
        return id;
    }

    public void setFeito(boolean feito) {
        this.feito = feito;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
    public String toString() {
        return "Missão: " + nome + " Descrição: " +
                descricao + " Dificuldade: " + dificuldade;
    }
}
