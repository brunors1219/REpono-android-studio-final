package com.minhaempresa.projetointegrador.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.minhaempresa.projetointegrador.R;

public class confirmacaopag extends AppCompatActivity {
    Button button_sair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacaopag);

        button_sair=findViewById(R.id.button_sair);
        button_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sair= new Intent(getApplicationContext(), telainicial.class);
                startActivity(sair);
            }
        });


    }
}