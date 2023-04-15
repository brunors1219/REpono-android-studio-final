package com.minhaempresa.projetointegrador.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.minhaempresa.projetointegrador.Domain.FoodDomain;
import com.minhaempresa.projetointegrador.Helper.ManagementCart;
import com.minhaempresa.projetointegrador.R;

public class AdicionarCarrinho extends AppCompatActivity {
private TextView addToCartBtn;
private TextView titleTxt,feeTxt, descriptionTxt, numberOrderTxt, tamanhotxt;
private ImageView picFood,minusBtn,plusBtn;
private FoodDomain object;
int numberOrder=1;
private ManagementCart managementCart;
ImageView back, button_card;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_carrinho);


        managementCart =new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object= (FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));


        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder=numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder>1){
                    numberOrder=numberOrder-1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

            addToCartBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    object.setNumberInCart(numberOrder);
                    managementCart.insertFood(object);
                }
            });

        back=(ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), telainicial.class));
                overridePendingTransition(0, 0);
            }
        });
        button_card=findViewById(R.id.button_card);
        button_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent carrinho = new Intent(getApplicationContext(), Carrinho.class);
                startActivity(carrinho);
            }
        });

    }

    private void initView() {
        addToCartBtn =findViewById(R.id.addToCartBnt);
        titleTxt=findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt =findViewById(R.id.descriptionTxt);
        numberOrderTxt =findViewById(R.id.numberOrderTxt);
        plusBtn=findViewById(R.id.plusBtn);
        minusBtn=findViewById(R.id.minusBtn);
        picFood=findViewById(R.id.picfood);


    }

}