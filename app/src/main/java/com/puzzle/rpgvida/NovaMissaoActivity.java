package com.puzzle.rpgvida;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.puzzle.rpgvida.db.MissaoDB;

public class NovaMissaoActivity extends AppCompatActivity {
    private TextView textNome;
    private TextView textDescricao;
    private EditText edNome;
    private EditText edDescricao;
    //private
    private Missao missao;
    private  MissaoDB missaoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_missao);

        edDescricao   = (EditText) findViewById(R.id.editMDescricao);
        edNome        = (EditText) findViewById(R.id.editMnome);

        textNome      = (TextView) findViewById(R.id.txvNome);
        textDescricao = (TextView) findViewById(R.id.txvDescricao);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dificuldade_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btnSalvar = (Button) findViewById(R.id.btnSalvarNovaMissao);



        missaoDB = new MissaoDB(this);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //acessa o banco e salva as informações
                //Toast.makeText(NovaMissaoActivity.this, edNome.getText().toString(), Toast.LENGTH_LONG).show();
                missao = new Missao();
                missao.setNome(edNome.getText().toString());
                missao.setDescricao(edDescricao.getText().toString());
                //pegar dificuldade do spinner
                missao.setDificuldade(/*spinner.getSelectedItem().toString()*/ 1);
                if(! missaoDB.saveMissao(missao)){
                    Toast.makeText(NovaMissaoActivity.this,"Erro ao salvar misão: " + missao.getNome(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(NovaMissaoActivity.this,"Missão Salva: " + missao.getNome(), Toast.LENGTH_LONG).show();
                    //atualizar tela principal
                    NovaMissaoActivity.this.finish();
                }




            }
        });
    }
}
