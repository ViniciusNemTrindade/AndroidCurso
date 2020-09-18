package com.vinicius.applistadefavoritos;

import android.content.DialogInterface;
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

public class MainActivity extends AppCompatActivity {

    private RecyclerView categoriaRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        categoriaRecyclerView = findViewById(R.id.categoria_recyclerview);

        categoriaRecyclerView.setAdapter(new CategoriaRecyclerAdapter());
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
        EditText categoriaEditText = new EditText(this);
        categoriaEditText.setInputType(InputType.TYPE_CLASS_TEXT);

        alertBuilder.setTitle(tituloAlert);
        alertBuilder.setView(categoriaEditText);

        alertBuilder.setPositiveButton(positiveButtonTitulo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });

        alertBuilder.create().show();

    }
}