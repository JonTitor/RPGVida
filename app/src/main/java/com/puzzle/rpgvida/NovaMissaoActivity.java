package com.puzzle.rpgvida;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NovaMissaoActivity extends AppCompatActivity {
    private TextView textNome;
    private  TextView textDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_missao);


        textNome = (TextView) findViewById(R.id.txvNome);
        textDescricao = (TextView) findViewById(R.id.txvDescricao);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dificuldade_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btnSalvar = (Button) findViewById(R.id.btnSalvarNovaMissao);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //acessa o banco e salva as informações
//                try {
//
//
//                }catch (){
//
//                }
                //tentar fazer aparecer balao dizendo que missao foi criada ou nao


                Toast.makeText(NovaMissaoActivity.this,"Missão Salva!", Toast.LENGTH_LONG).show();
                NovaMissaoActivity.this.finish();
            }
        });
    }
}
