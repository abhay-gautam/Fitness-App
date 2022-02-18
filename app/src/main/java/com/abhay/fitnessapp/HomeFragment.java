package com.abhay.fitnessapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.abhay.fitnessapp.cardview_exercises.Abs;
import com.abhay.fitnessapp.cardview_exercises.Arms;
import com.abhay.fitnessapp.cardview_exercises.Chest;
import com.abhay.fitnessapp.cardview_exercises.Full_body;
import com.abhay.fitnessapp.cardview_exercises.Legs;
import com.abhay.fitnessapp.cardview_exercises.Lower_body;
import com.abhay.fitnessapp.cardview_exercises.Shoulders;


public class HomeFragment extends Fragment implements View.OnClickListener {


    CardView arms,chest,legs,shoulder,abs,full_body,lower_body;



    @Nullable

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.home_menu_fragment,container,false);



        chest=view.findViewById(R.id.chest_id);
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getContext(),Chest.class);
                startActivity(intent);
            }
        });
        arms=view.findViewById(R.id.arms_id);
        arms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getContext(),Arms.class);
                startActivity(intent);


            }
        });

        legs=view.findViewById(R.id.legs_id);
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Legs.class);
                startActivity(intent);

            }
        });
        shoulder=view.findViewById(R.id.shoulder_id);
        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Shoulders.class);
                startActivity(intent);

            }
        });



        abs=view.findViewById(R.id.abs_id);
        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Abs.class);
                startActivity(intent);

            }
        });

        full_body=view.findViewById(R.id.fullbody_id);
        full_body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Full_body.class);
                startActivity(intent);

            }
        });


        lower_body=view.findViewById(R.id.lowerbody_id);
        lower_body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),Lower_body.class);
                startActivity(intent);

            }
        });


        return view;

    }


    @Override
    public void onClick(View v) {

    }
}