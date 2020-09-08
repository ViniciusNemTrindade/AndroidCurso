package com.vinicius.quizapp;

public class ModelQuiz {

    private int mPergunta;
    private boolean mResposta;

    public ModelQuiz(int pergunta, boolean resposta) {
        mPergunta = pergunta;
        mResposta = resposta;
    }

    public int getPergunta() {
        return mPergunta;
    }

    public void setPergunta(int pergunta) {
        mPergunta = pergunta;
    }

    public boolean isResposta() {
        return mResposta;
    }

    public void setResposta(boolean resposta) {
        mResposta = resposta;
    }
}
