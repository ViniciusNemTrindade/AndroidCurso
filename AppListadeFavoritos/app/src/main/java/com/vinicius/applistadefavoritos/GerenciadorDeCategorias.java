package com.vinicius.applistadefavoritos;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GerenciadorDeCategorias {

    private Context mContext;

    public GerenciadorDeCategorias(Context context) {

        mContext = context;

    }

    public void armazenaCategoria(Categoria categoria) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        HashSet itensHashSet = new HashSet(Arrays.asList(categoria.getItens()));

        editor.putStringSet(categoria.getNome(), itensHashSet);

        editor.apply();
    }

    public ArrayList<Categoria> recuperarCategorias() {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        Map<String, ?> dado = sharedPreferences.getAll();

    }

}
