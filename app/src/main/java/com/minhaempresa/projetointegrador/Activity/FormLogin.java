package com.minhaempresa.projetointegrador.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.minhaempresa.projetointegrador.R;

public class FormLogin extends AppCompatActivity {

    private TextView txt_tela_cadastro;
    private EditText edit_email , edit_senha;
    private Button bt_entrar;
    private ImageView ic_exit;
    private ProgressBar progressBar;
    String [] mensagens = {"Preencha todos os campos" , "Login Efetuado com sucesso"};


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        IniciarComponentes();

        NavigationBarView bnv = findViewById(R.id.bottomNavigationView3);
        bnv.setSelectedItemId(R.id.perfil);

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), telainicial.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.perfil:
                        return true;

                    case R.id.carrinho:
                        startActivity(new Intent(getApplicationContext(), Carrinho.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }

        });

        txt_tela_cadastro=(TextView) findViewById(R.id.text_tela_cadastro);
        txt_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(FormLogin.this,Cadastro.class);
                    startActivity(intent);
                }
        });
        ic_exit=(ImageView) findViewById(R.id.ic_exit);
        ic_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String email = edit_email.getText().toString();
               String senha = edit_senha.getText().toString();

               if (email.isEmpty() || senha.isEmpty() ){
                   Snackbar snackbar = Snackbar.make(v,mensagens [0], Snackbar.LENGTH_SHORT);
                   snackbar.setBackgroundTint(Color.WHITE);
                   snackbar.setTextColor(Color.BLACK);
                   snackbar.show();
               }else{
                   AutenticarUsuario(v);
               }

            }

        });
    }
        private void AutenticarUsuario(View view){
            String email = edit_email.getText().toString();
            String senha = edit_senha.getText().toString();

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email , senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        progressBar.setVisibility(View.VISIBLE);


                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                TelaPrincipal();

                            }
                        }, 3000);
                    }else{
                        String erro;

                        try {
                            throw task.getException();
                        }catch (Exception e){
                            erro = "Erro ao logar usuário";
                        }
                        Snackbar snackbar = Snackbar.make(view,erro, Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.WHITE);
                        snackbar.setTextColor(Color.BLACK);
                        snackbar.show();
                    }
                }
            });
        }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser usuarioAtual = FirebaseAuth.getInstance().getCurrentUser();

        if (usuarioAtual != null){
            TelaPrincipal();
        }
    }

    private void TelaPrincipal(){
        Intent intent = new Intent(FormLogin.this,TelaPrincipal.class);
        startActivity(intent);
        finish();
        }

        private void IniciarComponentes(){
           txt_tela_cadastro = findViewById(R.id.text_tela_cadastro);
           edit_email = findViewById(R.id.edit_email);
           edit_senha = findViewById(R.id.edit_senha);
           bt_entrar = findViewById(R.id.bt_entrar);
           progressBar = findViewById(R.id.progressbar);
        }
}
