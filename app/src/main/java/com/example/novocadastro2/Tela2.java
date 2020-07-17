package com.example.novocadastro2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        Bundle extras = getIntent().getExtras();

        TextView nome = findViewById(R.id.txtNome);
        TextView logradouro = findViewById(R.id.txtLogradouro);
        TextView CPF = findViewById(R.id.txtCPF);
        /*TextView profissao = findViewById(R.id.txtProfissao);*/

        String n = extras.getString(MainActivity.EXTRA_MESSAGE_NOME);
        String l = extras.getString(MainActivity.EXTRA_MESSAGE_LOGRADOURO);
        String c = extras.getString(MainActivity.EXTRA_MESSAGE_CPF);
        /*String s = extras.getString(MainActivity.EXTRA_MESSAGE_PROFISSAO);*/
        nome.setText(n);
        logradouro.setText(l);
        CPF.setText(c);
        /*profissao.setText(s);
        Tentativa falha de demonstrar a informação da profissão e do sexo escolhidos*/

    }
}