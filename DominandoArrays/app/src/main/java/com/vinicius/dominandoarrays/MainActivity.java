package com.vinicius.dominandoarrays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // int[] arrayInteiros = {1,3,5,8,9,3,2,4,6,7};
//
//        String[] arrayString = new String[4];
//        arrayString[0] = "Maria";
//        arrayString[1] = "Joao";
//        arrayString[2] = "Jose";
//        arrayString[3] = "Paola";

//        ArrayList listaHeterogenea = new ArrayList();
//
//        listaHeterogenea.add("Maria");
//        listaHeterogenea.add(29);
//        listaHeterogenea.add(1500.00);
//        listaHeterogenea.add(true);
//        listaHeterogenea.add("Joao");
//        listaHeterogenea.add(50);
//        listaHeterogenea.add(2000.00);
//        listaHeterogenea.add(false);

//        ArrayList<String> listaOmogenea = new ArrayList<>();
//
//        listaOmogenea.add("Maria");
//        listaOmogenea.add("Joaquim");
//        listaOmogenea.add("Jose");
//        listaOmogenea.add("Pedro");
//        listaOmogenea.add("Joao");
//        listaOmogenea.add("Mariana");
//        listaOmogenea.add("Paula");
//        listaOmogenea.add("Suzana");

        HashMap<Integer, String> listaDeBuscaRapida = new HashMap<>();


        listaDeBuscaRapida.put(1, "Botafogo");
        listaDeBuscaRapida.put(2, "Palmeiras");
        listaDeBuscaRapida.put(3, "Bahia");
        listaDeBuscaRapida.put(4, "Vitoria");

        TextView arrayView = findViewById(R.id.arrayView);

        for (Object liUn : listaDeBuscaRapida.keySet()) {

            arrayView.append("\n"+liUn + "  "+ listaDeBuscaRapida.get(liUn));
        }

    }

    // EditText edtNumeros = findViewById(R.id.editeNum);





}