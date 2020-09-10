package com.vinicius.lyricsfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText editeNomeArtista, editeNomeMusica;
    Button btnBuscaLetrasMusica;
    TextView textoLetras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editeNomeArtista = findViewById(R.id.edtNomeArtista);
        editeNomeMusica = findViewById(R.id.edtNomeMusica);
        btnBuscaLetrasMusica = findViewById(R.id.btnGetLetras);
        textoLetras = findViewById(R.id.txtLetras);

        btnBuscaLetrasMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(), "Este botão foi pressionado!", Toast.LENGTH_SHORT).show();
                String url = "https://api.lyrics.ovh/v1/" + editeNomeArtista.getText().toString() + "/" + editeNomeMusica.getText().toString();
                url.replace(" ", "%20");
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                textoLetras.setText(response.getString("lyrics"));
                            } catch(JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }
}