package com.minhaempresa.projetointegrador.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationBarView;
import com.minhaempresa.projetointegrador.Adaptor.CartListAdapter;
import com.minhaempresa.projetointegrador.Helper.ManagementCart;
import com.minhaempresa.projetointegrador.Interface.ChangeNumberItemsListener;
import com.minhaempresa.projetointegrador.R;

public class Carrinho extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    TextView totaluniTxt, totalFeeTxt, Texttotal, emptytxt, freteTxt;
    private double txt;
    private ScrollView scrollView;

    TextView btn_compra;
    ImageView voltar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);


        NavigationBarView bnv = findViewById(R.id.bottomNavigationView3);
        bnv.setSelectedItemId(R.id.carrinho);

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), telainicial.class));
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.carrinho:
                        break;

                    case R.id.perfil:
                        startActivity(new Intent(getApplicationContext(), FormLogin.class));
                        overridePendingTransition(0, 0);
                        break;


                }
                return false;
            }

        });

        btn_compra=(TextView) findViewById(R.id.btn_compra);
        btn_compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Carrinho.this, pagamento.class);
                startActivity(intent);
            }
        });

        voltar=findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });





        managementCart = new ManagementCart(this);

        initView();
        initlist();
        CalculateCart();
    }


            private void initView() {
                totaluniTxt = findViewById(R.id.totaluniTxt);
                totalFeeTxt = findViewById(R.id.totalFeeTxt);
                Texttotal = findViewById(R.id.totalTxt);
                emptytxt = findViewById(R.id.empetyTxt);
                scrollView = findViewById(R.id.scrollView);
                freteTxt= findViewById(R.id.totalFreteTxt);
                recyclerViewList=findViewById(R.id.cartView);

            }

            private void initlist() {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                recyclerViewList.setLayoutManager(linearLayoutManager);
                adapter = new CartListAdapter(managementCart.getListCart(),this,  new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        CalculateCart();
                    }
                });

                recyclerViewList.setAdapter(adapter);
                if (managementCart.getListCart().isEmpty()){
                    emptytxt.setVisibility(View.VISIBLE);
                    scrollView.setVisibility(View.GONE);

                }else{
                    emptytxt.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                }
            }
            private void CalculateCart() {
                double frete = 10;

                double total = Math.round((managementCart.getTotalFee() + frete)* 100) / 100;
                double itemTotal= Math.round(managementCart.getTotalFee()*100)/100;


                totalFeeTxt.setText("$"+itemTotal);
                freteTxt.setText("$"+frete);
                Texttotal.setText("$"+total);


            }
        }


