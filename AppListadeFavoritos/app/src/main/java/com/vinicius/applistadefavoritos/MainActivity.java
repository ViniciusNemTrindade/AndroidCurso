package com.vinicius.applistadefavoritos;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
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
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentCategoria.OnCategoriaInterectionListener {

    public static final String CATEGORIA_OBJECT_KEY = "CATEGORIA_KEY";
    public static final int MAIN_ACTIVITY_REQUEST_CODE = 1000;
    private  FragmentCategoria mFragmentCategoria;
    private boolean  estaEmPaisagem = false;
    private FragmentCategoriaItens mFragmentCategoriaItens;
    FloatingActionButton fab;

    private FrameLayout categoriaItensFragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFragmentCategoria = (FragmentCategoria) getSupportFragmentManager().findFragmentById(R.id.fragment_categoria);
        categoriaItensFragmentContainer = findViewById(R.id.categoria_itens_fragment_container);

        estaEmPaisagem = categoriaItensFragmentContainer != null;

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                mFragmentCategoria.fornecaCategoriaParaOGerenciador(categoria);
                dialogInterface.dismiss();
                mostrarItensDaCategoria(categoria);
            }
        });

        alertBuilder.create().show();

    }

    private void  mostrarItensDaCategoria(Categoria categoria) {

        if (!estaEmPaisagem) {
            Intent itensCategoriaIntent = new Intent(this, ItensDaCategoriaActivity.class);
            itensCategoriaIntent.putExtra(CATEGORIA_OBJECT_KEY, categoria);

            startActivityForResult(itensCategoriaIntent, MAIN_ACTIVITY_REQUEST_CODE);
        }else {
            if (mFragmentCategoriaItens != null){

                getSupportFragmentManager().beginTransaction()
                        .remove(mFragmentCategoriaItens).commit();
                mFragmentCategoriaItens = null;

            }
            setTitle(categoria.getNome());
            mFragmentCategoriaItens = FragmentCategoriaItens.newInstance(categoria);
            if (mFragmentCategoriaItens != null) {

                getSupportFragmentManager().beginTransaction().replace(R.id.categoria_itens_fragment_container, mFragmentCategoriaItens).addToBackStack(null).commit();

            }

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mostrarDialogoDoItemCategoriaCriada();
                }
            });

        }

    }

    private void mostrarDialogoDoItemCategoriaCriada() {

        final EditText itemEditText = new EditText(this);
        itemEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        new AlertDialog.Builder(this)
                .setTitle("Digite aqui, o nome do item")
                .setView(itemEditText)
                .setPositiveButton("Criar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String item = itemEditText.getText().toString();
                        mFragmentCategoriaItens.addItemParaCategoria(item);
                        dialogInterface.dismiss();
                    }
                })
                .create()
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MAIN_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            if (data != null) {
                mFragmentCategoria.armazenaCategoria((Categoria) data.getSerializableExtra(CATEGORIA_OBJECT_KEY));
            }
        }
    }


    @Override
    public void categoriaFoiPressionada(Categoria categoria) {


        mostrarItensDaCategoria(categoria);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        setTitle(getString(R.string.app_name));

        if (mFragmentCategoriaItens.categoria != null) {

            mFragmentCategoria.getmGerenciadorDeCategorias().armazenaCategoria(mFragmentCategoriaItens.categoria);
        }

        if (mFragmentCategoriaItens != null) {
            getSupportFragmentManager().beginTransaction()
                    .remove(mFragmentCategoriaItens).commit();
            mFragmentCategoriaItens = null;
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogoCategoriaCriada();
            }
        });

    }
}