package com.example.shopall.darl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopall.R;
import com.example.shopall.databinding.CustomlayoutBinding;
import com.example.shopall.databinding.FragmentItemBinding;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {


    private ArrayList<HomeModel> Items;
    HomeInterface homeInterface;
    LayoutInflater layoutInflater ;

    Context context;

    public HomeAdapter(ArrayList<HomeModel> items, HomeInterface homeInterface, Context context) {
        Items = items;
        this.homeInterface = homeInterface;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.customlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder viewHolder, int i) {

        HomeModel model = Items.get(i);
        viewHolder.desc.setText(String.valueOf(model.getPrice()));
        viewHolder.imageView.setImageResource(model.getImage());
        viewHolder.title.setText(model.getName());
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                homeInterface.ClickListener(model);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title,desc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.customImage);
            title = itemView.findViewById(R.id.costomtittle);
            desc = itemView.findViewById(R.id.customdesc);

        }
    }
}
