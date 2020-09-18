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

    interface InterfaceCategoriaFoiPressionada {

        void categoriaFoiPressionada(Categoria categoria);

    }

    private ArrayList<Categoria> categorias;
    private InterfaceCategoriaFoiPressionada interfaceCategoriaFoiPressionada;

    public CategoriaRecyclerAdapter(ArrayList<Categoria> categorias, InterfaceCategoriaFoiPressionada interfaceCategoriaFoiPressionada) {
        this.categorias = categorias;
        this.interfaceCategoriaFoiPressionada = interfaceCategoriaFoiPressionada;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(viewholder_categoria, parent, false);

        return  new CategoriaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, final int position) {

        holder.getTxtCategoriaNumero().setText(Integer.toString(position + 1));
        holder.getTxtCategoriaNome().setText(categorias.get(position).getNome());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interfaceCategoriaFoiPressionada.categoriaFoiPressionada(categorias.get(position));
            }
        });

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
