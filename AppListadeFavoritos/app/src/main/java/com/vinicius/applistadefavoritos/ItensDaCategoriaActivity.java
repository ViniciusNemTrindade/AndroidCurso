package com.vinicius.applistadefavoritos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ItensDaCategoriaActivity extends AppCompatActivity {

    private RecyclerView itensRecyclerView;
    private FloatingActionButton addItemFloatingActionButton;

    Categoria categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens_da_categoria);

        categoria = (Categoria) getIntent().getSerializableExtra(MainActivity.CATEGORIA_OBJECT_KEY);

        setTitle(categoria.getNome());

        itensRecyclerView = findViewById(R.id.itens_recycler_view);
        itensRecyclerView.setAdapter(new ItensRecyclerAdapter(categoria));
        itensRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        addItemFloatingActionButton = findViewById(R.id.add_item_button);
        addItemFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mostrarItemCreationDialog();
            }
        });
    }

    private void mostrarItemCreationDialog() {

        final EditText itemEditText = new EditText(this);
        itemEditText.setInputType(InputType.TYPE_CLASS_TEXT);

        new AlertDialog.Builder(this)
                .setTitle(R.string.item_dialog_titulo)
                .setView(itemEditText)
                .setPositiveButton(R.string.positive_button_item, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String itemNome = itemEditText.getText().toString();
                        categoria.getItens().add(itemNome);
                        ItensRecyclerAdapter itensRecyclerAdapter = (ItensRecyclerAdapter) itensRecyclerView.getAdapter();
                        itensRecyclerAdapter.notifyItemInserted(categoria.getItens().size() - 1);
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();


    }

}