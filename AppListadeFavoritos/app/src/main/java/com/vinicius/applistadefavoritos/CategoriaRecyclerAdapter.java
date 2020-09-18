package com.vinicius.applistadefavoritos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.vinicius.applistadefavoritos.R.layout.viewholder_categoria;

public class CategoriaRecyclerAdapter extends RecyclerView.Adapter<CategoriaViewHolder> {

//    String [] categorias = {"Hobbies", "Esportes", "Games", "Aparelhos Eletrônicos", "Comidas", "Países"};

    private ArrayList<Categoria> categorias;

    public CategoriaRecyclerAdapter(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(viewholder_categoria, parent, false);

        return  new CategoriaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {

        holder.getTxtCategoriaNumero().setText(Integer.toString(position + 1));
        holder.getTxtCategoriaNome().setText(categorias.get(position).getNome());

    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public void addCategoria(Categoria categoria) {

        categorias.add(categoria);
        notifyItemInserted(categorias.size() - 1);
    }
}
