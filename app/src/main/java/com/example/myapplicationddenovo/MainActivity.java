package com.example.myapplicationddenovo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity{

    Context context;
    private ListView contatoLista;
    private EditText procuraTexto;
    private Button search,add;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
     //   contatoLista = (ListView)findViewById(R.id.contato_lista);
        //  procuraTexto=(EditText)findViewById(R.id.search_text);
        //  search =(Button)findViewById(R.id.search);
        //  add =(Button)findViewById(R.id.add);

        search.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {}

        });

        add.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent intent = new Intent(context,AddContato.class);
                startActivity(intent);
            }
        });
    }

}