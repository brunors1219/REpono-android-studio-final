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

public class masculino extends AppCompatActivity {

    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerViewPopularList;
    ImageView voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masculino);

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

        foodList.add(new FoodDomain("Bermuda Branca", "pop_35", "Bermuda jeans branca ótima para festas simples.", 70.00));
        foodList.add(new FoodDomain("Bermuda Jenas", "pop_36", "Bermuda jeans clara, perfeita para usar no dia-a-dia .", 50.00));
        foodList.add(new FoodDomain("Blusa Branca", "pop_37", "Blusa branca, feita para quem ama jogos.", 30.00));
        foodList.add(new FoodDomain("Camisa Preta", "pop_38", "Camisa preta, para os amantes de preto que combina com qualquer cor.", 40.00));
        foodList.add(new FoodDomain("Camisa Preta", "pop_39", "Camisa preta, diferenciada e estilosa.", 40.00));
        foodList.add(new FoodDomain("Blusa Branca", "pop_40", "Blusa branca, feita para quem adora jogar um basquete.", 40.00));
        foodList.add(new FoodDomain("Blusa Preta", "pop_41", "Blusa preta, para usar quando quiser.", 45.00));
        foodList.add(new FoodDomain("Calça Moletom Masculina", "pop_42", "Calça de moletom preta da NASA, perfeita para usar no inverno.", 130.00));
        foodList.add(new FoodDomain("Calça Preta", "pop_43", "Calça preta, estilosa para quem ama ser estiloso.", 200.00));
        foodList.add(new FoodDomain("Calça Jeans Masculina", "pop_44", "Calça jeans clara rasgada, feita para quem ama ser estiloso.", 210.00));
        foodList.add(new FoodDomain("Calça Moletom Masculina", "pop_45", "Calça moletom berge, própria para usar no inverno e para quem gosto do time de basquete chicago.", 240.00));
        foodList.add(new FoodDomain("Calça Jeans Masculina", "pop_46", "Calça jeans clara rasgada, para quem curte esse estilo", 190.00));
        foodList.add(new FoodDomain("Camisa Preta", "pop_47", "Camisa preta, simples e básica para usar quando quiser.", 35.00));
        foodList.add(new FoodDomain("Camisa Preta", "pop_48", "Camisa preta, simples para usar quando sentir vontade.", 35.00));
        foodList.add(new FoodDomain("Bermuda Jeans", "pop_49", "Bermuda jeans rasgada, para usar no dia a dia.", 60.00));

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
