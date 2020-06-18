package com.example.waiata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SongDetail extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        Intent intent = getIntent();
        String textTitle = intent.getStringExtra(Adapter.EXTRA_TITLE);
        String desc = intent.getStringExtra(Adapter.EXTRA_DESC);

        TextView textView1 = findViewById(R.id.songTitle);
        //TextView textView2 = findViewById(R.id.textView2);

        textView1.setText(textTitle);

        mainGrid = findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

    }


    private void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount() ; i++) {

            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (finalI == 0) { //opens description
                        Intent intent = new Intent(SongDetail.this, activity_description.class);
                        startActivity(intent);
                    } else if (finalI == 1) { //opens vocals
                        Intent intent = new Intent(SongDetail.this, activity_vocals.class);
                        startActivity(intent);
                    } else if (finalI == 2) { //opens non-vocals
                        Intent intent = new Intent(SongDetail.this, activity_nonVocals.class);
                        startActivity(intent);
                    } else if (finalI == 3) { //opens lyrics
                        Intent intent = new Intent(SongDetail.this, activity_lyrics.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SongDetail.this, "Please set activity for this card", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}
