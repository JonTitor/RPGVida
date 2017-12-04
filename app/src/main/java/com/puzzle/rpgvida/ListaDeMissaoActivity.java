package com.puzzle.rpgvida;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.puzzle.rpgvida.db.MissaoDB;

import java.util.List;

/**
 * Created by dieisson on 24/11/17.
 */

public class ListaDeMissaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MissaoDB missaoDB = new MissaoDB(this);
        List<Missao> missoes = missaoDB.findAll();

        ListView listaDeMissao = (ListView) findViewById(R.id.lista);

        //chamada da implementaçao do android:
        //ArrayAdapter<Curso> adapter = new ArrayAdapter<Curso>(this,
        //android.R.layout.simple_list_item_1, cursos);

        //chamada da nossa implementação
        AdapterMissaoPersonalizado adapter =
                new AdapterMissaoPersonalizado(missoes, this);

        listaDeMissao.setAdapter(adapter);
    }
    public Missao teste(){
        Missao teste = new Missao();
        teste.setNome("TESTE");
        teste.setDescricao("Veneno, sangue de vigem, olhos de cabra, uma pitada de sal do imalaiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        teste.setDificuldade(3);
        return teste;
    }
    }
