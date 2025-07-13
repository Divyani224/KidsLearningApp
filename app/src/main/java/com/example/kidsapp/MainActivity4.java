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
public class MainActivity4 extends AppCompatActivity {
    GridView gridview;
    ImageView image;
    Button next_page,previous_page;
    MediaPlayer player;

    String[] color=new String[]{"Black","Blue","Green","Orange","Pink","Purple","Red","White","Yellow"};
    Integer[] color_images = {R.drawable.black, R.drawable.blue, R.drawable.green,
                              R.drawable.orange,R.drawable.pink,R.drawable.purple,
                              R.drawable.red,R.drawable.white,R.drawable.yellow};

    Integer[] color_sounds = {R.raw.black, R.raw.blue,R.raw.green,
                              R.raw.orange,R.raw.pink, R.raw.purple,
                              R.raw.red, R.raw.white,R.raw.yellow, };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        gridview=findViewById(R.id.gridview3);
        next_page = findViewById(R.id.nextBtn);
        image = findViewById(R.id.imageView1);
        previous_page = findViewById(R.id.previousBtn1);

        ArrayAdapter adapter;
        adapter = new ArrayAdapter(this, simple_list_item_1,color);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Set the image based on the position of the clicked letter
                image.setImageResource(color_images[position]);

                //Set the sound based on the position of the clicked letter
                if (player != null) {
                    player.release();
                }
                player = MediaPlayer.create(MainActivity4.this, color_sounds[position]);
                player.start();
            }
        });
        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),MainActivity5.class);
                startActivity(intent);
            }
        });
        previous_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}