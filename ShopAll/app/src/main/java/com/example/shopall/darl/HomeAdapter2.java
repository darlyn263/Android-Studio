package com.example.shopall.darl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopall.R;

import java.util.List;

public class HomeAdapter2 extends RecyclerView.Adapter<HomeAdapter2.ViewHolder>{


    Context context;
    LayoutInflater layoutInflater;

    List<HomeModel> items;

    HomeInterface homeInterface;


    public HomeAdapter2(List<HomeModel> items, Context context, HomeInterface homeInterface) {
        this.items = items;
        this.context = context;
        this.homeInterface = homeInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        layoutInflater  = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.customlayout,parent,true);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder Holder, int i) {


        HomeModel homeModel = items.get(i);
        Holder.title.setText(homeModel.getName());
        Holder.desc.setText(String.valueOf(homeModel.getPrice()));
        Holder.imageView.setImageResource(homeModel.getImage());

        Holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                homeInterface.ClickListener(homeModel);
            }
        });




    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView desc,title;
        ImageView imageView;
        ConstraintLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            desc = itemView.findViewById(R.id.customdesc);
            title = itemView.findViewById(R.id.costomtittle);
            imageView = itemView.findViewById(R.id.customImage);
            layout = itemView.findViewById(R.id.contain);



        }
    }
}
