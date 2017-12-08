package com.puzzle.rpgvida;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.puzzle.rpgvida.Utilitarios.Utilitaria;
import com.puzzle.rpgvida.db.MissaoDB;
import com.puzzle.rpgvida.db.PerfilDB;

import java.util.List;

/**
 * Created by acneidert on 07/12/17.
 */

public class PerfilActivity extends AppCompatActivity {
    private TextView tvNome;
    private TextView tvUsuario;
    private TextView tvXp;
    private TextView tvXpTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        //Pegar Valores
        PerfilDB perfilDB = new PerfilDB(this);
        Perfil perfil = perfilDB.findByID(1);

        tvNome = (TextView) findViewById(R.id.tvNome);
        tvUsuario = (TextView) findViewById(R.id.tvUsuario);
        tvXp = (TextView) findViewById(R.id.tvXp);
        tvXpTotal = (TextView) findViewById(R.id.tvXpTotal);

        tvNome.setText("Dieisson");
        tvUsuario.setText("D1");
        tvXp.setText(Utilitaria.RetornaNivel(1));
        tvXpTotal.setText(""+1);
        //txtXP = (TextView) findViewById(R.id.)//

        
    }
}
