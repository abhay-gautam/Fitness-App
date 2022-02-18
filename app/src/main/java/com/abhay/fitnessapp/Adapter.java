package com.abhay.fitnessapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;


    ArrayList<Example.Record> user_list;

    public Adapter(Context mcontext, ArrayList<Example.Record> user_list){
        this.context=mcontext;
        this.user_list=user_list;}


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        final Example.Record record=user_list.get(position);
        holder.textView1.setText(record.getDescription());
        holder.textView.setText(record.getTitle());
        Glide.with(context).load(record.getImagesurl()).centerCrop()
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(),Next_Activity.class);
                intent.putExtra("my images",record.getImagesurl());
                intent.putExtra("my date",record.getTitle());
                intent.putExtra("my time",record.getDescription());
                v.getContext().startActivity(intent);

            }
        });

//        int resource =user_list.get(position).image;
//        String name=user_list.get(position).text1;
//        String time=user_list.get(position).text2;
//        holder.setData(resource,name,time);



    }

    @Override
    public int getItemCount() {
        return user_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        TextView textView1;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.text1);
            textView1=itemView.findViewById(R.id.text2);
        }

        public void setData(int resource, String name, String time) {

            imageView.setImageResource(resource);
            textView.setText(name);
            textView1.setText(time);
        }
    }
}
