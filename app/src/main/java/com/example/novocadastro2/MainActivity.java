package com.example.novocadastro2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public final static String EXTRA_MESSAGE_NOME = "com.example.intent.Nome";
    public final static String EXTRA_MESSAGE_LOGRADOURO = "com.example.intent.Logradouro";
    public final static String EXTRA_MESSAGE_CPF = "com.example.intent.CPF";
    /*public final static String EXTRA_MESSAGE_PROFISSAO = "com.example.intent.Profissao";*/

    Switch aSwitch;
    EditText nome;
    EditText logradouro;
    EditText cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch = (Switch) findViewById(R.id.switchSexo);
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Profissao, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked == true){

                    Toast.makeText(getBaseContext(),"Masculino", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getBaseContext(),"Feminino", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Cadastrar(View view) {

        nome = (EditText) findViewById(R.id.txtNome);
        logradouro = (EditText) findViewById(R.id.txtLogradouro);
        cpf = (EditText) findViewById(R.id.txtCPF);
        /*Spinner spinner = findViewById(R.id.spinner);*/


        String n = nome.getText().toString();
        String l = logradouro.getText().toString();
        String c = cpf.getText().toString();
        /*String s = spinner.getSelectedItem().toString();*/

        Intent intent = new Intent(MainActivity.this, Tela2.class);
        intent.putExtra(EXTRA_MESSAGE_NOME, "Seu nome: " + n);
        intent.putExtra(EXTRA_MESSAGE_LOGRADOURO, "Seu endereço: " + l);
        intent.putExtra(EXTRA_MESSAGE_CPF, "Seu CPF: " + c);
        /*intent.putExtra(EXTRA_MESSAGE_LOGRADOURO, "Profissão escolhida:" + s);
        Tentativa falha de demonstrar a informação da profissão e do sexo escolhidos*/
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}