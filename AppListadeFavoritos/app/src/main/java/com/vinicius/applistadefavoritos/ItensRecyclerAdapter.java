package com.vinicius.applistadefavoritos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItensRecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private Categoria categoria;

    public ItensRecyclerAdapter(Categoria categoria) {

        this.categoria = categoria;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_holder, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        holder.itemTextView.setText(String.valueOf(categoria.getItens().get(position)));

    }

    @Override
    public int getItemCount() {
        return categoria.getItens().size();
    }
}
