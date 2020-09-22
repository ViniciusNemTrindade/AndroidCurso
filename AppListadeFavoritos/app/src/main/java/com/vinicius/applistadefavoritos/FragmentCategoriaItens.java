package com.vinicius.applistadefavoritos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCategoriaItens#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCategoriaItens extends Fragment {

    private RecyclerView itensRecyclerView;
    Categoria categoria;
    private static final String CATEGORY_ARGS = "CATEGORY_ARGS";

    public FragmentCategoriaItens() {
        // Required empty public constructor
    }

    public static FragmentCategoriaItens newInstance(Categoria categoria) {

        FragmentCategoriaItens fragmentCategoriaItens = new FragmentCategoriaItens();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CATEGORY_ARGS, categoria);
        fragmentCategoriaItens.setArguments(bundle);
        return fragmentCategoriaItens;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            categoria = (Categoria) getArguments().getSerializable(CATEGORY_ARGS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_categoria_itens, container, false);

        if (view != null) {

            itensRecyclerView = view.findViewById(R.id.itens_recycler_view);
            itensRecyclerView.setAdapter(new ItensRecyclerAdapter(categoria));
            itensRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

        return view;
    }
    public void addItemParaCategoria(String item) {

        categoria.getItens().add(item);
        ItensRecyclerAdapter itensRecyclerAdapter = (ItensRecyclerAdapter) itensRecyclerView.getAdapter();
        itensRecyclerAdapter.setCategoria(categoria);
        itensRecyclerAdapter.notifyDataSetChanged();

    }
}