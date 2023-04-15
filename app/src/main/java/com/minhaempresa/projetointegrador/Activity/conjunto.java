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

public class conjunto extends AppCompatActivity {

    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerViewPopularList;
    ImageView voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conjunto);

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

        foodList.add(new FoodDomain("Conjunto Feminino", "pop_52", "Conjunto feminino verde, para usar no dia a dia e para também arrasar nas festas.", 100.00));
        foodList.add(new FoodDomain("Conjunto Masculino", "pop_57", "Conjunto Masculino, perfeito para usar no inverno e arrasar.", 140.00));
        foodList.add(new FoodDomain("Conjunto Feminino", "pop_54", "Conjunto feminino, feito especialmente para você arrasar nas festas.", 130.00));
        foodList.add(new FoodDomain("Conjunto Masculino", "pop_58", "Conjunto masculino, para te esquentar no frio e arrasar onde for.", 180.00));
        foodList.add(new FoodDomain("Conjunto Feminino", "pop_63", "Conjunto feminino, feito para você arrasar onde for.", 140.00));
        foodList.add(new FoodDomain("Conjunto Masculino", "pop_60", "Conjunto Masculino, para quem gosta de estar na moda.", 140.00));
        foodList.add(new FoodDomain("Conjunto Feminino", "pop_64", "Conjunto Feminino verde, feito especialmente para você arrasar onde for.", 120.00));
        foodList.add(new FoodDomain("Conjunto Masculino", "pop_59", "Conjunto Masculino, para usar no inverno e arrasar.", 150.00));
        foodList.add(new FoodDomain("Conjunto Feminino", "pop_66", "Conjunto Feminino, para quem ama vermelho e roupas curtas.", 140.00));
        foodList.add(new FoodDomain("Conjunto Masculino", "pop_72", "Conjunto Masculino, para quem ama esse estilo e adora basketball.", 150.00));
        foodList.add(new FoodDomain("Conjunto Feminino", "pop_71", "Conjunto Feminino, perfeito para quem ama roupas curtas, e arrasar por onde for.", 140.00));
        foodList.add(new FoodDomain("Conjunto Feminino", "pop_69", "Conjunto Feminino, feito especialmente para você arrasar no inverno.", 200.00));
        foodList.add(new FoodDomain("Conjunto Feminino", "pop_65", "Conjunto Feminino, para quem ama estar na moda, feito para você arrasar por onde for.", 190.00));



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