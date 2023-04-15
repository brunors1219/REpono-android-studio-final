package com.minhaempresa.projetointegrador.Adaptor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.minhaempresa.projetointegrador.Activity.AdicionarCarrinho;
import com.minhaempresa.projetointegrador.Domain.FoodDomain;
import com.minhaempresa.projetointegrador.R;

import java.util.ArrayList;

public class FemininoAdaptor extends RecyclerView.Adapter<FemininoAdaptor.ViewHolder> {
    ArrayList<FoodDomain> femininoAdaptor;


    public FemininoAdaptor(ArrayList<FoodDomain> categoryDomains) {
        this.femininoAdaptor = categoryDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_feminino,parent,false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FemininoAdaptor.ViewHolder holder, int position) {
        holder.title.setText(femininoAdaptor.get(position).getTitle());
        holder.fee.setText(String.valueOf(femininoAdaptor.get(position).getFee()));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(femininoAdaptor.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);


        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), AdicionarCarrinho.class);
                intent.putExtra("object", femininoAdaptor.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), AdicionarCarrinho.class);
                intent.putExtra("object", femininoAdaptor.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return femininoAdaptor.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, fee;
        ImageView pic;
        TextView addBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            fee=itemView.findViewById(R.id.fee);
            pic=itemView.findViewById(R.id.pic);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }
}