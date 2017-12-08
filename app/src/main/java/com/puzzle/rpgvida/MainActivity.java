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
import com.puzzle.rpgvida.db.MissaoDB;
import com.puzzle.rpgvida.db.PerfilDB;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static MainActivity INSTANCE = null;

    public static synchronized MainActivity getInstance(){
        if(INSTANCE == null){
            INSTANCE = new MainActivity();
        }
        return INSTANCE;
    }

    private static synchronized void setInstance(MainActivity main){
        INSTANCE = main;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        this.setInstance(this);
        setContentView(R.layout.activity_main);

        PerfilDB perfilDB = new PerfilDB(this);

//        if (){
//            Intent myIntent = new Intent(MainActivity.this, CriarPerfilActivity.class);
//            MainActivity.this.startActivity(myIntent);
//
//        }



        //Nivel main
        TextView txtNivel = (TextView) findViewById(R.id.txtNivel);
        txtNivel.setText("NIVEL:" + Utilitaria.RetornaNivel(1)); // pega nivel do banco

        //Abre tela para novo cadastro de missoes
        Button btnNovo =(Button) findViewById(R.id.btnNovo);
        btnNovo.setBackgroundResource(R.drawable.ic_assignment_black_36dp);
        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, NovaMissaoActivity.class);
                MainActivity.this.startActivity(myIntent);
                MainActivity.this.atualizaListView();
            }
        });
        //////////////////////////////

        //Abre tela para novo cadastro de perfil
        Button btnPerfil = (Button) findViewById(R.id.btnPerfil);
        btnPerfil.setBackgroundResource(R.drawable.ic_face_black_36dp);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iperfil = new Intent(MainActivity.this, PerfilActivity.class);
                startActivity(iperfil);


            }
        });
        //////////////////////////////

        this.atualizaListView();


    }


    public void atualizaListView(){
        MissaoDB missaoDB = new MissaoDB(this);
        final List<Missao> missoes = missaoDB.findAllOpen();

        final ListView listaDeMissao = (ListView) findViewById(R.id.lista);

        //chamada da implementaçao do android:
        //ArrayAdapter<Curso> adapter = new ArrayAdapter<Curso>(this,
        //android.R.layout.simple_list_item_1, cursos);

        //chamada da nossa implementação
        final AdapterMissaoPersonalizado adapter =
                new AdapterMissaoPersonalizado(missoes, this);

        listaDeMissao.setAdapter(adapter);

        listaDeMissao.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AdapterMissaoPersonalizado adapter2 = (AdapterMissaoPersonalizado) adapterView.getAdapter();
                Missao m = (Missao) adapter2.getItem(i);
                Dialog(m);

            }
        });
    }
    public void Dialog(final Missao missao){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(missao.getDescricao())
                .setTitle(missao.getNome())
                .setNegativeButton("Não feito!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Feito", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MissaoDB missaoDB = new MissaoDB(MainActivity.this);
                        missao.setFeito(true);
                        missaoDB.setMissaoFeito(missao);
                        MainActivity.this.atualizaListView();
                        PerfilDB perfilDB = new PerfilDB(MainActivity.this);
                        perfilDB.
                    }
                });

        builder.show();

    }





}
