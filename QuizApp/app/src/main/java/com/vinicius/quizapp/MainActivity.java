package com.vinicius.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtPergunta;
    private Button botaoVerdade;
    private Button botaoFalso;

    private int mPerguntaIndex;
    private int mPerguntaQuiz;

    private ProgressBar mBarraDeProgresso;
    private TextView mEstatiscasDoQuizTextView;

    private int mPontosDoUsuario;


    private ModelQuiz[] colecaoPergunta = new ModelQuiz[]{

            new ModelQuiz(R.string.p1, false),
            new ModelQuiz(R.string.p2, true),
            new ModelQuiz(R.string.p3, true),
            new ModelQuiz(R.string.p4, false),
            new ModelQuiz(R.string.p5, true),
            new ModelQuiz(R.string.p6, false),
            new ModelQuiz(R.string.p7, true),
            new ModelQuiz(R.string.p8, true),
            new ModelQuiz(R.string.p9, false),
            new ModelQuiz(R.string.p10, true)
    };

    final int PROGRESSO_USARIO = (int) Math.ceil(100.00 / colecaoPergunta.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtPergunta = findViewById(R.id.txtPergunta);
        ModelQuiz q1 = colecaoPergunta[mPerguntaIndex];
        mPerguntaQuiz = q1.getPergunta();
        mTxtPergunta.setText(mPerguntaQuiz);

        mBarraDeProgresso = findViewById(R.id.quizPB);
        mEstatiscasDoQuizTextView = findViewById(R.id.txtQuizEstatisticas);

        botaoVerdade = findViewById(R.id.btnVerdade);
        botaoVerdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avaliaRespostaDoUsuario(true);
                mudaPerguntaAoClicarNoBotao();

            }
        });

        botaoFalso = findViewById(R.id.btnFalso);
        botaoFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                avaliaRespostaDoUsuario(false);
                mudaPerguntaAoClicarNoBotao();

            }
        });
    }

    private void mudaPerguntaAoClicarNoBotao() {

        mPerguntaIndex =  (mPerguntaIndex + 1) % 10;

        if(mPerguntaIndex == 0){
            AlertDialog.Builder quizAlert = new AlertDialog.Builder(this);
            quizAlert.setCancelable(false);
            quizAlert.setTitle("O Quiz acabou!");
            quizAlert.setMessage("Você fez: "+ mPontosDoUsuario + " ponto(s)!");
            quizAlert.setPositiveButton("Encerre o quiz!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            quizAlert.show();

        }

        mPerguntaQuiz = colecaoPergunta[mPerguntaIndex].getPergunta();
        mTxtPergunta.setText(mPerguntaQuiz);
        mEstatiscasDoQuizTextView.setText(mPontosDoUsuario + " ");
    }

    private void avaliaRespostaDoUsuario(boolean escolhaDoUsuario) {

        boolean respostaDestaPergunta = colecaoPergunta[mPerguntaIndex].isResposta();
        if(respostaDestaPergunta == escolhaDoUsuario) {
            Toast.makeText(getApplicationContext(), R.string.toast_mensagem_correta, Toast.LENGTH_SHORT).show();
            mBarraDeProgresso.incrementProgressBy(PROGRESSO_USARIO);
            mPontosDoUsuario = mPontosDoUsuario + 1;
        }
        if (respostaDestaPergunta != escolhaDoUsuario) {
            Toast.makeText(getApplicationContext(), R.string.toast_mensagem_incorreta, Toast.LENGTH_SHORT).show();
        }
    }
}