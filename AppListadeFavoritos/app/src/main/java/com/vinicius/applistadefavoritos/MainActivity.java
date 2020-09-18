package com.vinicius.applistadefavoritos;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CategoriaRecyclerAdapter.InterfaceCategoriaFoiPressionada {

    private RecyclerView categoriaRecyclerView;
    private GerenciadorDeCategorias mGerenciadorDeCategorias = new GerenciadorDeCategorias(this);

    public static final String CATEGORIA_OBJECT_KEY = "CATEGORIA_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArrayList<Categoria> categorias = mGerenciadorDeCategorias.recuperarCategorias();
        categoriaRecyclerView = findViewById(R.id.categoria_recyclerview);
        categoriaRecyclerView.setAdapter(new CategoriaRecyclerAdapter(categorias, MainActivity.this));
        categoriaRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Fab foi pressionado!", Toast.LENGTH_SHORT).show();
                mostrarDialogoCategoriaCriada();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void mostrarDialogoCategoriaCriada() {

        String tituloAlert = getString(R.string.criar_categoria);
        String positiveButtonTitulo = getString(R.string.positive_button_titulo);
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        final EditText categoriaEditText = new EditText(this);
        categoriaEditText.setInputType(InputType.TYPE_CLASS_TEXT);

        alertBuilder.setTitle(tituloAlert);
        alertBuilder.setView(categoriaEditText);

        alertBuilder.setPositiveButton(positiveButtonTitulo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Categoria categoria = new Categoria(categoriaEditText.getText().toString(), new ArrayList<String>());
                mGerenciadorDeCategorias.armazenaCategoria(categoria);

                CategoriaRecyclerAdapter categoriaRecyclerAdapter = (CategoriaRecyclerAdapter) categoriaRecyclerView.getAdapter();
                categoriaRecyclerAdapter.addCategoria(categoria);

                dialogInterface.dismiss();
                mostrarItensDaCategoria(categoria);
            }
        });

        alertBuilder.create().show();

    }

    private void  mostrarItensDaCategoria(Categoria categoria) {

        Intent itensCategoriaIntent = new Intent(this, ItensDaCategoriaActivity.class);
        itensCategoriaIntent.putExtra(CATEGORIA_OBJECT_KEY, categoria);

        startActivity(itensCategoriaIntent);


    }

    @Override
    public void categoriaFoiPressionada(Categoria categoria) {

        mostrarItensDaCategoria(categoria);
    }
}