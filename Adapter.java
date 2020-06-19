package com.example.waiata;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import java.util.List;

public class Adapter extends PagerAdapter {

    public static final String EXTRA_TITLE = "test1";//"com.example.waiata.EXTRA_TITLE";
    public static final String EXTRA_IMG = "test2";//"com.example.waiata.EXTRA_IMG";


    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item,container,false);

        ImageView imageView;
        TextView title;
                //, desc;

        int title_src = models.get(position).getTitle();
        int imgView_src = models.get(position).getImage();


        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        //desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        //desc.setText(models.get(position).getDesc());


        //addition

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SongDetail.class);
                intent.putExtra(EXTRA_TITLE, models.get(position).getTitle());
                intent.putExtra(EXTRA_IMG,models.get(position).getImage());
                context.startActivity(intent);
            }
        }
        );


        container.addView(view,0);



        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);

    }
}
