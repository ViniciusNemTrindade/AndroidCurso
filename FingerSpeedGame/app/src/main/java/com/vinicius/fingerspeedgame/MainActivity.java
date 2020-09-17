package com.vinicius.fingerspeedgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtTempoView;
    TextView milTextView;
    Button btnToqueToque;

    private CountDownTimer countDownTimer;
    private long inicioContagemMseg = 60000;
    private int intervaloTemporizador = 1000;
    private int tempoRestante = 60;
    private  int mil = 1000;

    private final String TEMPO_RESTANTE_KEY = "temmpo restante key";
    private final String MIL_KEY = "mil key";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        showToast("onSaveInstanceState foi chamado", Toast.LENGTH_SHORT);

        outState.putInt(TEMPO_RESTANTE_KEY, tempoRestante);
        outState.putInt(MIL_KEY, mil);
        countDownTimer.cancel();
    }


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTempoView = findViewById(R.id.txtTempo);
        milTextView = findViewById(R.id.txtMil);
        btnToqueToque = findViewById(R.id.btnToque);

        milTextView.setText(mil + "");

        if (savedInstanceState != null) {

            tempoRestante = savedInstanceState.getInt(TEMPO_RESTANTE_KEY);
            mil = savedInstanceState.getInt(MIL_KEY);

            restaurarOJogo();
        }


        btnToqueToque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.i("TAG", "O botao foi pressionado!");

                mil--;
                milTextView.setText(mil + " ");

                if (tempoRestante > 0 && mil <= 0) {
                    Toast.makeText(MainActivity.this, "Mandou muito muleque!", Toast.LENGTH_LONG).show();
                    showAlert("Mandou bem!", "Por favor, reinicie o Jogo!");
                }

            }
        });

        if (savedInstanceState == null) {
            countDownTimer = new CountDownTimer(inicioContagemMseg, intervaloTemporizador) {
                @Override
                public void onTick(long milesegAteAcabar) {
                    tempoRestante = (int) milesegAteAcabar / 1000;
                    txtTempoView.setText(tempoRestante + "");
                }

                @Override
                public void onFinish() {
                    Toast.makeText(MainActivity.this, "O tempo acabou!", Toast.LENGTH_SHORT).show();

                    showAlert("Lamento! ): ", "Quer tentar mais uma vez?");
                }
            };
            countDownTimer.start();
        }
    }

    private void restaurarOJogo() {
        int recuperaTempoRestante = tempoRestante;
        int recuperaMil = mil;

        txtTempoView.setText(recuperaTempoRestante + "");
        milTextView.setText(recuperaMil+ "");

        countDownTimer = new CountDownTimer((long)tempoRestante * 1000, intervaloTemporizador) {
            @Override
            public void onTick(long milesegAteAcabar) {

                tempoRestante = (int)milesegAteAcabar / 1000;
                txtTempoView.setText(tempoRestante + "");

            }

            @Override
            public void onFinish() {

                showAlert("Acabou", "Você gostaria de reiniciar o Jogo?");

            }
        };

        countDownTimer.start();
    }

    private void recomecarJogo() {

            if (countDownTimer != null) {
                countDownTimer.cancel();
                countDownTimer = null;
            }

            mil =10;
            milTextView.setText(Integer.toString(mil));

            txtTempoView.setText(tempoRestante + "");
            countDownTimer = new CountDownTimer(inicioContagemMseg, intervaloTemporizador) {
                @Override
                public void onTick(long milSegParaAcabar) {

                    tempoRestante = (int)milSegParaAcabar / 1000;
                    txtTempoView.setText(tempoRestante + "");
                }

                @Override
                public void onFinish() {
                    showAlert("Acabou", "Você gostaria de reiniciar o Jogo?");
                }
            };
            countDownTimer.start();
        }

    private void showAlert(String titulo, String mensagem) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        builder.setPositiveButton(R.string.alert_botaon_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //set what would happen when positive button is clicked
                recomecarJogo();
            }
        });
        AlertDialog alertDialog = builder.show();
        alertDialog.setCancelable(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.info_id) {

            showToast("Esta é a versão atual do seu Jogo. Verifique no Google Play, e certifique-se se o Jogo esta na sua versão mais recente! "+ BuildConfig.VERSION_NAME, Toast.LENGTH_LONG);
        }
        return true;
    }

    private void showToast(String mensagem, int duracao) {
        Toast.makeText(this, mensagem, duracao).show();
    }
}