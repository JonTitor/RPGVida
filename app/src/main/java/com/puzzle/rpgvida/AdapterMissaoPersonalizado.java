package com.puzzle.rpgvida;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dieisson on 27/11/17.
 */

public class AdapterMissaoPersonalizado extends BaseAdapter {

    private final List<Missao> missoes;
    private final Activity act;

    public AdapterMissaoPersonalizado(List<Missao> missoes, Activity act) {
        this.missoes = missoes;
        this.act = act;
    }

    @Override
    public int getCount() {
        return missoes.size();
    }

    @Override
    public Object getItem(int i) {
        return missoes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = act.getLayoutInflater()
                .inflate(R.layout.lista_missao_personalizada, viewGroup, false);
        Missao missao = missoes.get(i);
        //pegando as referências das Views
        TextView nome = (TextView)
                view.findViewById(R.id.txvNome);
        TextView descricao = (TextView)
                view.findViewById(R.id.txvDescricao);
        TextView dificuldade = (TextView)
                view.findViewById(R.id.txvDificuldade);

        //populando as Views
        nome.setText(missao.getNome());
        descricao.setText(missao.getDescricao());
        dificuldade.setText(""+ missao.getDificuldade());


        return view;
    }
}
