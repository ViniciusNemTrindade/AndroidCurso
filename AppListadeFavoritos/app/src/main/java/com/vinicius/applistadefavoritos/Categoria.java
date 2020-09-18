package com.vinicius.applistadefavoritos;

import java.util.ArrayList;

public class Categoria {

    private String nome;
    private ArrayList<String> itens = new ArrayList<>();

    public Categoria(String nome, ArrayList<String> itens) {
        this.nome = nome;
        this.itens = itens;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getItens() {
        return itens;
    }
}
