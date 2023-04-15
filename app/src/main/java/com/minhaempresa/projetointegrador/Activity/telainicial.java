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
import com.minhaempresa.projetointegrador.Adaptor.CategoryAdaptor;
import com.minhaempresa.projetointegrador.Adaptor.PopularAdaptor;
import com.minhaempresa.projetointegrador.Domain.CategoryDomain;
import com.minhaempresa.projetointegrador.Domain.FoodDomain;
import com.minhaempresa.projetointegrador.R;

import java.util.ArrayList;

public class telainicial extends AppCompatActivity {

    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    ImageView banner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telainicial);
        
        recyclerViewCategory();
        recyclerViewPopular();

        NavigationBarView bnv = findViewById(R.id.bottomNavigationView3);
        bnv.setSelectedItemId(R.id.home);

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:

                        return true;

                    case R.id.perfil:
                        Intent intent=new Intent(telainicial.this,FormLogin.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.carrinho:
                        startActivity(new Intent(telainicial.this,Carrinho.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Feminino", "cate_1"));
        category.add(new CategoryDomain("Masculino" , "cate_2"));
        category.add(new CategoryDomain("Conjunto" , "cate_3"));
        category.add(new CategoryDomain("Coleção" , "cate_4"));

        adapter=new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList=new ArrayList<>();

        foodList.add(new FoodDomain("Vestido Feminino", "pop_1","Vestido branco, básico e delicado. Feito para você! Manga longa, perfeito pra usar no inverno.", 40.00));
        foodList.add(new FoodDomain("Calça Jeans Masculina", "pop_44", "Calça jeans clara rasgada, feita para quem ama ser estiloso.", 210.00));
        foodList.add(new FoodDomain("Vestido Pink", "pop_53", "Vestido Pink simples, lindo e estiloso, feito para você arrasar onde for.", 160.00));
        foodList.add(new FoodDomain("Bermuda Branca", "pop_35", "Bermuda jeans branca ótima para festas simples.", 70.00));
        foodList.add(new FoodDomain("Conjunto Feminino", "pop_63", "Conjunto feminino, feito para você arrasar onde for.", 140.00));
        foodList.add(new FoodDomain("Conjunto Masculino", "pop_58", "Conjunto masculino, para te esquentar no frio e arrasar onde for.", 180.00));
        foodList.add(new FoodDomain("Vestido Preto", "pop_55", "Vestido Preta Brilhante, feito especialmente para você arrasar nas festas.", 210.00));
        foodList.add(new FoodDomain("Conjunto Masculino", "pop_60", "Conjunto Masculino, para quem gosta de estar na moda.", 140.00));
        foodList.add(new FoodDomain("Conjunto Feminino", "pop_54", "Conjunto feminino, feito especialmente para você arrasar nas festas.", 130.00));


        adapter2=new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);

        banner= (ImageView) findViewById(R.id.banner);
        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),colecao.class));
                overridePendingTransition(0,0);
            }
        });
    }


}