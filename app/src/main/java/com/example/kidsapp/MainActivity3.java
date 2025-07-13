package com.example.kidsapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import static android.R.layout.simple_list_item_1;
public class MainActivity3 extends AppCompatActivity {
    GridView gridview;
    ImageView image;
    Button next_page,previous_page;
    MediaPlayer player;

    String[] number=new String[]{ "1","2","3","4","5","6",
                                  "7","8","9","10","11","12",
                                  "13","14","15","16","17","18",
                                  "19","20"};
    Integer[] number_images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,R.drawable.five,R.drawable.six,
                               R.drawable.seven, R.drawable.eight, R.drawable.nine,R.drawable.ten,R.drawable.eleven,
                               R.drawable.twelve, R.drawable.thirteen, R.drawable.fourteen,R.drawable.fifteen,R.drawable.sixteen,
                               R.drawable.seventeen, R.drawable.eighteen, R.drawable.nineteen,R.drawable.twenty};

    Integer[] number_sounds = {R.raw.one, R.raw.two,R.raw.three, R.raw.four,R.raw.five, R.raw.six,R.raw.seven, R.raw.eight,R.raw.nine, R.raw.ten,
                               R.raw.eleven, R.raw.twelve,R.raw.thirteen, R.raw.fourteen, R.raw.fifteen, R.raw.sixteen,R.raw.seventeen,
                               R.raw.eighteen,R.raw.nineteen, R.raw.twenty};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        gridview=findViewById(R.id.gridview2);
        next_page = findViewById(R.id.nextBtn);
        image = findViewById(R.id.imageView1);
        previous_page=findViewById(R.id.previousBtn1);

        ArrayAdapter adapter;
        adapter = new ArrayAdapter(this, simple_list_item_1,number);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Set the image based on the position of the clicked letter
                image.setImageResource(number_images[position]);

                // Set the sound based on the position of the clicked letter
                if (player != null) {
                    player.release();
                }
                player = MediaPlayer.create(MainActivity3.this, number_sounds[position]);
                player.start();
            }
        });
        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),MainActivity4.class);
                startActivity(intent);
            }
        });
        previous_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}