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

public class colecao extends AppCompatActivity {

    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerViewPopularList;
    ImageView voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colecao);

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

        foodList.add(new FoodDomain("Short masculino", "pop_73", "Short da coleção Repono com melhor preço na melhor qualidade!!", 100.00));
        foodList.add(new FoodDomain("Blusa Feminina", "pop_74", "Blusa Feminina Azul da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 50.00));
        foodList.add(new FoodDomain("Blusa Feminina", "pop_75", "Blusa Feminina Branca da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 50.00));
        foodList.add(new FoodDomain("Blusa Masculina", "pop_76", "Blusa Masculina Preta da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 50.00));
        foodList.add(new FoodDomain("Blusa Masculina", "pop_77", "Blusa Masculina Verde Escuro da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 50.00));
        foodList.add(new FoodDomain("Calça Masculina", "pop_78", "Calça Masculina Jeans da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 110.00));
        foodList.add(new FoodDomain("Calça Feminina", "pop_79", "Calça Feminina Moletom da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 120.00));
        foodList.add(new FoodDomain("Camisete Masculino", "pop_80", "Camisete Masculino Rosa da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 70.00));
        foodList.add(new FoodDomain("Camisete Masculino", "pop_81", "Camisete Masculino Branco da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 80.00));
        foodList.add(new FoodDomain("Conjunto Feminino", "pop_82", "Conjunto Feminino Verde da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 110.00));
        foodList.add(new FoodDomain("Conjunto Masculino", "pop_83", "Conjunto Masculino da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 100.00));
        foodList.add(new FoodDomain("Corta Vento Masculino", "pop_84", "Corta Vento Masculino Branco da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 130.00));

        foodList.add(new FoodDomain("Cropped Feminino", "pop_87", "Cropped Feminino da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 60.00));
        foodList.add(new FoodDomain("Conjunto Masculino", "pop_88", "Conjunto Masculino da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 200.00));
        foodList.add(new FoodDomain("Moletom Masculino", "pop_89", "Moletom Masculino da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 100.00));
        foodList.add(new FoodDomain("Saia Feminna", "pop_90", "Saia Feminina Jeans Branca da coleção Repono, com o melhor preço e na melhor qualidade para você! ", 60.00));





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