package com.example.waiata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();



    private List<Song> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DBHelper dbHelper = new DBHelper(this);
        songList = dbHelper.getAllSongTitles();


        models = new ArrayList<>();


        for (int i = 0; i < songList.size() ; i++) {
            models.add(new Model(songList.get(i).getImgPath(), songList.get(i).getTitle(),songList.get(i).getDesc()));
        }

       /* models.add(new Model(R.drawable.brochure, "Brochure","This is the desc"));
        models.add(new Model(R.drawable.sticker, "sticker","This is the sticker"));
        models.add(new Model(R.drawable.poster, "poster","This is the poster"));
        models.add(new Model(R.drawable.namecard, "namecard","This is the namecard"));
*/
        adapter = new Adapter(models,this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if(position < (adapter.getCount() - 1) &&  position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )

                    );
                }else {
                    viewPager.setBackgroundColor(colors[colors.length -1]);

                }
            }




            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}
