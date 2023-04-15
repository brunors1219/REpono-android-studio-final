package com.minhaempresa.projetointegrador.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.minhaempresa.projetointegrador.R;

public class cartao extends AppCompatActivity {
    ImageView voltar;
    Button button_finalizar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao);
        voltar=findViewById(R.id.back);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        button_finalizar= findViewById(R.id.button_finalizar);
        button_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confimarcao= new Intent(getApplicationContext(), confirmacaopag.class);
                startActivity(confimarcao);
            }
        });
    }
}