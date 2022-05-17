package com.example.appnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appnotas.controller.AppNotaController;
import com.example.appnotas.model.AppNotas;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nota1 = (EditText) findViewById(R.id.nota1);
        EditText nota2 = (EditText) findViewById(R.id.nota2);
        Button calcularNota = (Button) findViewById(R.id.calcularNota);
        Button substituicao = (Button) findViewById(R.id.subsituiçao);
        EditText resultado = (EditText) findViewById(R.id.resultado);


        // CALCULAR A MEDIA
        calcularNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppNotas appNotas = new AppNotas(
                        Double.parseDouble(nota1.getText().toString()),
                        Double.parseDouble(nota2.getText().toString()));

                AppNotaController appNotaController = new AppNotaController();
                resultado.setText(String.valueOf(appNotaController.media(appNotas)));
            }
        });

        // ABRIR TELA SUBSTITUIÇÃO
        substituicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent segundaTela = new Intent(getApplicationContext(), tela_substituicao.class);
                segundaTela.putExtra("valor1", nota1.getText().toString());
                segundaTela.putExtra("valor2", nota2.getText().toString());
                startActivity(segundaTela);
            }
        });
    }
}
