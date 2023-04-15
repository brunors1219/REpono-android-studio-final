package com.minhaempresa.projetointegrador.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.minhaempresa.projetointegrador.R;

public class pagamento extends AppCompatActivity {

    ImageView btn_cartao,button_pix, voltar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento2);

        btn_cartao=findViewById(R.id.btn_cartao);
        btn_cartao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pagamento.this, cartao.class);
                startActivity(intent);
            }
        });
       button_pix =findViewById(R.id.button_pix);
       button_pix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(pagamento.this, PIX.class);
                startActivity(intent);
            }
        });

        voltar=findViewById(R.id.back);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });






    }
}