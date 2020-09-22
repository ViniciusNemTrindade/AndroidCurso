package com.vinicius.applistadefavoritos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentCategoria extends Fragment implements CategoriaRecyclerAdapter.InterfaceCategoriaFoiPressionada {

    private RecyclerView categoriaRecyclerView;
    private GerenciadorDeCategorias mGerenciadorDeCategorias;

    public GerenciadorDeCategorias getmGerenciadorDeCategorias() {
        return mGerenciadorDeCategorias;
    }

    interface OnCategoriaInterectionListener {

        void categoriaFoiPressionada(Categoria categoria);
    }

    private OnCategoriaInterectionListener listenerObjetct;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnCategoriaInterectionListener) {

            listenerObjetct = (OnCategoriaInterectionListener) context;
            mGerenciadorDeCategorias = new GerenciadorDeCategorias(context);

        }else {

            throw new RuntimeException("E aí Desenvolvedor. O context or activity deve implementar a OnCategoriaInteractionListener");
        }

    }

    public FragmentCategoria() {
        // Required empty public constructor
    }

    public static FragmentCategoria newInstance() {

        return new FragmentCategoria();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categoria, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Categoria> categorias = mGerenciadorDeCategorias.recuperarCategorias();
        if (getView() != null) {
            categoriaRecyclerView = getView().findViewById(R.id.categoria_recyclerview);
            categoriaRecyclerView.setAdapter(new CategoriaRecyclerAdapter(categorias, this));
            categoriaRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listenerObjetct = null;

    }


    @Override
    public void categoriaFoiPressionada(Categoria categoria) {
            listenerObjetct.categoriaFoiPressionada(categoria);
    }

    public  void fornecaCategoriaParaOGerenciador(Categoria categoria) {

        mGerenciadorDeCategorias.armazenaCategoria(categoria);
        CategoriaRecyclerAdapter categoriaRecyclerAdapter = (CategoriaRecyclerAdapter) categoriaRecyclerView.getAdapter();
        categoriaRecyclerAdapter.addCategoria(categoria);
    }

    public void armazenaCategoria (Categoria categoria) {

        mGerenciadorDeCategorias.armazenaCategoria(categoria);

        atualizaRecyclerView();
    }

    private void atualizaRecyclerView() {

        ArrayList<Categoria> categorias = mGerenciadorDeCategorias.recuperarCategorias();
        categoriaRecyclerView.setAdapter(new CategoriaRecyclerAdapter(categorias, this));

    }

}