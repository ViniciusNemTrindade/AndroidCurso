package com.vinicius.applistadefavoritos;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CategoriaViewHolder extends RecyclerView.ViewHolder {

    private TextView txtCategoriaNumero;
    private TextView txtCategoriaNome;

    public CategoriaViewHolder(View view) {
        super(view);

        txtCategoriaNumero = view.findViewById(R.id.categoria_numero_textview);
        txtCategoriaNome = view.findViewById(R.id.categoria_nome_textview);
    }

    public TextView getTxtCategoriaNumero() {
        return txtCategoriaNumero;
    }

    public TextView getTxtCategoriaNome() {
        return txtCategoriaNome;
    }
}
