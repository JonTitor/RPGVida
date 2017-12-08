package com.puzzle.rpgvida;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.puzzle.rpgvida.db.PerfilDB;

public class CriarPerfilActivity extends AppCompatActivity {
    private EditText Nome;
    private EditText Usuario;
    private EditText Senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_perfil);

        Nome   = (EditText) findViewById(R.id.etpNome);
        Usuario   = (EditText) findViewById(R.id.etpUsuario);
        Senha   = (EditText) findViewById(R.id.etpSenha);

        final PerfilDB perfilDB = new PerfilDB(this);


        Button btnSalvar =(Button) findViewById(R.id.btnpsalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Perfil perfil = new Perfil();
                perfil.setNome(Nome.getText().toString());
                perfil.setUser(Usuario.getText().toString());
                perfil.setSenha(Senha.getText().toString());
                perfil.setXp(1);
                if(! perfilDB.savePerfil(perfil)){
                    Toast.makeText(CriarPerfilActivity.this,"Erro ao salvar perfil ", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(CriarPerfilActivity.this,"Perfil salvo com sucesso ", Toast.LENGTH_LONG).show();
                    //atualizar tela principal
                    CriarPerfilActivity.this.finish();
                }

            }
        });




    }

}
