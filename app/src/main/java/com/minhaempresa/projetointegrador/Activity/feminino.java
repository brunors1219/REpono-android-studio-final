package com.minhaempresa.projetointegrador.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationBarView;
import com.minhaempresa.projetointegrador.Adaptor.FemininoAdaptor;
import com.minhaempresa.projetointegrador.Domain.FoodDomain;
import com.minhaempresa.projetointegrador.R;

import java.util.ArrayList;

public class feminino extends AppCompatActivity {

    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerViewPopularList;
    ImageView voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feminino);

        recyclerViewfeminino();

        NavigationBarView bnv = findViewById(R.id.bottomNavigationView3);
        bnv.setSelectedItemId(R.id.home);


        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), telainicial.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.perfil:
                        startActivity(new Intent(getApplicationContext(), TelaPrincipal.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.carrinho:
                        startActivity(new Intent(getApplicationContext(), Carrinho.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    private void recyclerViewfeminino() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();

        foodList.add(new FoodDomain("Vestido Feminino", "pop_1", "Vestido branco, básico e delicado. Feito para você! Manga longa, perfeito pra usar no inverno.", 200.00));
        foodList.add(new FoodDomain("Short Feminino", "pop_2", "Short Feminino, curto jeans, perfeito para você.", 60.00));
        foodList.add(new FoodDomain("Blusa Feminino", "pop_3", "Blusa preta de manga, perfeito para usar no dia-a-dia ou em uma festa simples.", 40.00));
        foodList.add(new FoodDomain("Cropped Feminino", "pop_4", "Cropped branco brilhante perfeito para sua noite de festa. ", 50.00));
        foodList.add(new FoodDomain("Saia Feminina", "pop_5", "Saia feminina jeans para usar no dia-a-dia.", 55.00));
        foodList.add(new FoodDomain("Conjunto Femino", "pop_7", "Conjunto femino berge cropped e calça cintura alta, feito para você.", 220.00));
        foodList.add(new FoodDomain("Blusão Feminino", "pop_9", "Blusão feminino berge, para usar no dia a dia.", 40.00));
        foodList.add(new FoodDomain("Blusa Feminina", "pop_10", "Blusa feminina preta, para usar no dia a dia.", 30.00));
        foodList.add(new FoodDomain("Blusa Feminina", "pop_11", "Blusa feminino branca, para usar quando quiser.", 35.00));
        foodList.add(new FoodDomain("Blusa Feminina", "pop_12", "Blusa feminina preta, para as amantes de preto.", 40.00));
        foodList.add(new FoodDomain("Blusa Feminina", "pop_13", "Blusa feminina branca, simples e para aquelas estilosas.", 40.00));
        foodList.add(new FoodDomain("Cropped Branco", "pop_14", "Cropped feminino branco, para quem ama cropped.", 55.00));
        foodList.add(new FoodDomain("Cropped Feminino", "pop_15", "Cropped feminino preto, para usar no dia a dia.", 30.00));
        foodList.add(new FoodDomain("Cropped Branco", "pop_16", "Cropped feminino branco, feito para você.", 35.00));
        foodList.add(new FoodDomain("Cropped Prateado", "pop_17", "Cropped feminino prateado, perfeito para usar em festas.", 45.00));
        foodList.add(new FoodDomain("Cropped Preto", "pop_19", "Cropped feminino preto, para as amantes do universo.", 40.00));
        foodList.add(new FoodDomain("Calça Rasgada", "pop_22", "Calça rasgada clara , despojada para quem tem um estilo diferenciado.", 210.00));
        foodList.add(new FoodDomain("Calça Moletom", "pop_25", "Calça de moletom verde, perfeita e estilosa para usar no inverno", 190.00));
        foodList.add(new FoodDomain("Calça Jeans", "pop_23", "Calça jeans clara, perfeito para você que gosta de andar na moda.", 220.00));
        foodList.add(new FoodDomain("Calça Mom", "pop_29", "Calça Mom, para quem ama esse estilo.", 230.00));
        foodList.add(new FoodDomain("Saia Curta Preta", "pop_32", "Saia curta prete, feita para você arrasar nas festas.", 80.00));
        foodList.add(new FoodDomain("Saia Curta Branca", "pop_30", "Saia curta branca, para usar no dia a dia.", 70.00));
        foodList.add(new FoodDomain("Saia Média Estampada", "pop_33", "Saia média estampada, perfeito para o verão.", 90.00));
        foodList.add(new FoodDomain("Saia Média Preta", "pop_34", "Saia média preta, para arrasar nas festas.", 100.00));
        foodList.add(new FoodDomain("Vestido Preto", "pop_55", "Vestido Preta Brilhante, feito especialmente para você arrasar nas festas.", 210.00));
        foodList.add(new FoodDomain("Vestido Pink", "pop_53", "Vestido Pink simples, lindo e estiloso, feito para você arrasar onde for.", 160.00));



        adapter2 = new FemininoAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);

        voltar=(ImageView) findViewById(R.id.back);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


}