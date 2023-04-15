package com.minhaempresa.projetointegrador.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.minhaempresa.projetointegrador.R;

import java.util.HashMap;
import java.util.Map;

public class Cadastro extends AppCompatActivity {
    private EditText edit_nome , edit_email , edit_senha;
    String [] mensagens = {"Preencha todos os campos" , "Cadastro realizado com sucesso"};
    String usuarioId;

    TextView txt_tela_login;
    TextView buttoncadastro;
    ImageView voltar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        IniciarComponentes();
        buttoncadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();


                if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                } else{
                    CadastrarUsuario(v);
                }
            }
        });



        txt_tela_login=(TextView) findViewById(R.id.text_tela_cadastro);
        txt_tela_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cadastro.this,FormLogin.class);
                startActivity(intent);
            }
        });
        voltar=(ImageView) findViewById(R.id.back);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        }

     private void CadastrarUsuario(View v){

         String email = edit_email.getText().toString();
         String senha = edit_senha.getText().toString();


         FirebaseAuth.getInstance().createUserWithEmailAndPassword(email , senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if (task.isSuccessful()){


                     SavarDadosUsuario();




                     Snackbar snackbar = Snackbar.make(v,mensagens[1], Snackbar.LENGTH_SHORT);
                     snackbar.setBackgroundTint(Color.WHITE);
                     snackbar.setTextColor(Color.BLACK);
                     snackbar.show();
                 }else{
                     String erro;
                     try {
                         throw task.getException();

                     }catch(FirebaseAuthWeakPasswordException e) {
                         erro = "Digite uma senha com no minímo 6 caracteres";
                     }catch(FirebaseAuthUserCollisionException e) {
                         erro = "Essa conta ja foi cadastrada";
                     }catch(FirebaseAuthInvalidCredentialsException e){
                         erro = "E-mail inválido";
                     }catch (Exception e){
                         erro = "Erro ao cadastrar usuário";
                     }


                     Snackbar snackbar = Snackbar.make(v,erro, Snackbar.LENGTH_SHORT);
                     snackbar.setBackgroundTint(Color.WHITE);
                     snackbar.setTextColor(Color.BLACK);
                     snackbar.show();


                 }
             }
         });
     }



     private void SavarDadosUsuario(){
        String nome = edit_nome.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String , Object> usuarios = new HashMap<>();
        usuarios.put("nome" , nome);

        usuarioId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("usuarios").document(usuarioId);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("db", "Sucesso ao salvar os dados");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("db_error" , "Erro ao salvar os dados" + e.toString());

                    }
                });

     }


    private void IniciarComponentes(){
        edit_nome = findViewById(R.id.edit_nome);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        buttoncadastro = findViewById(R.id.buttoncadastro);

    }
}