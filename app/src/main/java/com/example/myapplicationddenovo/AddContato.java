package com.example.myapplicationddenovo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AddContato extends AppCompatActivity {

    Context context;
    BDh bdh;
    EditText et_nome, et_numero, et_email, et_empresa;
    Button relacionamento, adicionar;
    String relacionamentoString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contato);

        context = this;
        bdh = new BDh(context);

        et_nome = findViewById(R.id.nome);
        et_numero = findViewById(R.id.numero);
        et_email = findViewById(R.id.email);
        et_empresa = findViewById(R.id.empresa);

        relacionamento = findViewById(R.id.relacionamento);
        adicionar = findViewById(R.id.adicionar);

        String nome = et_nome.getText().toString();
        String numero = et_numero.getText().toString();
        String email = et_email.getText().toString();
        String empresa = et_empresa.getText().toString();


        relacionamentoString = "Não especificado";

        relacionamento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CharSequence options[] = {"Negócios", "Amigo", "Conhecimento", "Outro"};
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Escolher o tipo de relacionamento")
                        .setItems(options, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (i == 0) {
                                    relacionamentoString = "Negócios";
                                } else if (i == 1) {
                                    relacionamentoString = "Amigo";
                                } else if (i == 2) {
                                    relacionamentoString = "Conhecimento";
                                } else if (i == 3) {
                                    relacionamentoString = "Outro";
                                }
                            }
                        })
                        .show(); // Moveu a chamada .show() para dentro do método setItems()
            }
        });


        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = et_nome.getText().toString();
                String numero = et_numero.getText().toString();
                String email = et_email.getText().toString();
                String empresa = et_empresa.getText().toString();

                if (!TextUtils.isEmpty(nome) || !TextUtils.isEmpty(numero) || !TextUtils.isEmpty(email) || !TextUtils.isEmpty(empresa)) {
                    Contato contato = new Contato(nome, numero, email, empresa, relacionamentoString);
                    bdh.addContato(contato);
                    startActivity(new Intent(context,MainActivity.class));
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Por favor, preencha todos os campos")
                            .setNegativeButton("OK", null)
                            .show();
                }
            }
        });


    }
}
