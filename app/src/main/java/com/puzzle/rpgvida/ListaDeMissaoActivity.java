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
        List<Missao> missoes = missaoDB.findAllOpen();

        ListView listaDeMissao = (ListView) findViewById(R.id.lista);

        //chamada da nossa implementação
        AdapterMissaoPersonalizado adapter =
                new AdapterMissaoPersonalizado(missoes, this);

        listaDeMissao.setAdapter(adapter);
    }

    }
