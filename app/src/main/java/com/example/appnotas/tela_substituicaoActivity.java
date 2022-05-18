package com.example.appnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appnotas.controller.AppNotaController;
import com.example.appnotas.model.AppNotas;

public class tela_substituicaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_substituicao);

        EditText subs_nota1 = (EditText) findViewById(R.id.subs_nota1);
        EditText subs_nota2 = (EditText) findViewById(R.id.subs_nota2);
        Button recalcularNota = (Button) findViewById(R.id.recalcularNota);
        EditText resultadoSubst = (EditText) findViewById(R.id.resultadoSubst);

        Intent telaAnterior = getIntent();
        if (telaAnterior != null) {
            Bundle params = telaAnterior.getExtras();
            if (params != null) {
                String valor1 = params.getString("valor1");
                String valor2 = params.getString("valor2");

                subs_nota1.setText(valor1);
                subs_nota2.setText(valor2);
            }
        }

        // CALCULAR A MEDIA
        recalcularNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppNotas appNotas = new AppNotas(
                        Double.parseDouble(subs_nota1.getText().toString()),
                        Double.parseDouble(subs_nota2.getText().toString()));

                AppNotaController appNotaController = new AppNotaController();
                resultadoSubst.setText(String.valueOf(appNotaController.media(appNotas)));
            }
        });


    }
}