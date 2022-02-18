package com.abhay.fitnessapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;


    public SliderAdapter(Context context) {
        this.context = context;
    }

    int images[]={
            R.drawable.gym_a,
            R.drawable.gym_b,
            R.drawable.gym_c


    };
    int heading[]={
            R.string.improvehealth_heading,
            R.string.stayfit_heading,
            R.string.healthylifestyle_heading

    };
    int desc[]={
            R.string.improvehealth_description,
            R.string.stayfit_description,
            R.string.healthylifestyle_description
    };

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject( View view,  Object object) {
        return view==(ConstraintLayout)object;
    }

    @NonNull

    @Override
    public Object instantiateItem(@NonNull  ViewGroup container, int position) {
        inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.slide_layout,container,false);

        ImageView imageView=view.findViewById(R.id.slide_images);
        TextView textViewheading=view.findViewById(R.id.slide_heading);
        TextView textViewdesc=view.findViewById(R.id.slide_desc);

        imageView.setImageResource(images[position]);
        textViewheading.setText(heading[position]);
        textViewdesc.setText(desc[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull
            Object object) {
        container.removeView((ConstraintLayout)object);

    }
}
