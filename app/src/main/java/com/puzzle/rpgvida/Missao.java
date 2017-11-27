package com.puzzle.rpgvida;

/**
 * Created by dieisson on 24/11/17.
 */

public class Missao {
    private String nome;
    private String descricao;
    private int dificuldade;


    public Missao() {
    }

    public Missao(String nome, String descricao, int dificuldade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldade = dificuldade;
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
