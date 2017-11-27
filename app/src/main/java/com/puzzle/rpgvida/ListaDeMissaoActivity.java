package com.puzzle.rpgvida;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dieisson on 24/11/17.
 */

public class ListaDeMissaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Missao> missoes = new ArrayList<Missao>(); //pegando via protobuff mais tarde
        missoes.add(teste());
        missoes.add(teste());
        missoes.add(teste());
        missoes.add(teste());
        missoes.add(teste());
        missoes.add(teste());

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
