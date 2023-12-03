package com.example.myapplicationddenovo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    Context context;
    private BDh bdh;
    private ListView ContatoLista;
    private EditText procuraTexto;
    private Button procurar,AdicionarContato;

    private List<Contato> contatos;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        bdh = new BDh(context);

        ContatoLista = (ListView)findViewById(R.id.contato_lista);
        procuraTexto=(EditText)findViewById(R.id.procurar_texto);
        procurar =(Button)findViewById(R.id.procurar);
        AdicionarContato =(Button)findViewById(R.id.adicionar);

        contatos = new ArrayList<>();
        contatos = bdh.getTodosContatos();

        String[] nomesArray = new String[contatos.size()];
        for ( int x = 0 ; x < contatos.size(); x++){
            nomesArray[x] = contatos.get(x).getNome();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,nomesArray);
        ContatoLista.setAdapter(adapter);

        procurar.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {}

        });

        AdicionarContato.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent intent = new Intent(context,AddContato.class);
                startActivity(intent);
            }
        });
    }

}