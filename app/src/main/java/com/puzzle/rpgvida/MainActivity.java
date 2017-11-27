package com.puzzle.rpgvida;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.puzzle.rpgvida.Utilitarios.Utilitaria;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Nivel main
        TextView txtNivel = (TextView) findViewById(R.id.txtNivel);
        txtNivel.setText("NIVEL:" + Utilitaria.RetornaNivel(2000000000)); // pega nivel do banco

        //Abre tela para novo cadastro de missoes
        Button btnNovo =(Button) findViewById(R.id.btnNovo);
        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, NovaMissaoActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        //////////////////////////////
        //Abre tela para novo cadastro de perfil
//        Button btnPerfil =(Button) findViewById(R.id.btnPerfil);
//        btnNovo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        //////////////////////////////

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

        listaDeMissao.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dialog();

            }
        });

    }


    public Missao teste(){
        Missao teste = new Missao();
        teste.setNome("TESTE");
        teste.setDescricao("Veneno, sangue de vigem, olhos de cabra, uma pitada de sal do imalaiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        teste.setDificuldade(3);
        return teste;
    }

    public void Dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("teste")
                .setTitle("Teste")
                .setNegativeButton("Não feito!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Feito", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        builder.show();

    }





}
