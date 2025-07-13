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
public class MainActivity5 extends AppCompatActivity {
    GridView gridview;
    ImageView image;
    Button main_page,previous_page;
    MediaPlayer player;

    String[] shape=new String[]{"Circle","Cone","Kite","Oval","Square","Star","Triangle","Rectangle"};
    Integer[] shape_images = {R.drawable.circle, R.drawable.cone, R.drawable.kite,
                              R.drawable.oval,R.drawable.square,R.drawable.star,
                              R.drawable.triangle,R.drawable.rectangle};
    Integer[] shape_sounds = {R.raw.circle, R.raw.cone,R.raw.kite,
                              R.raw.oval,R.raw.square, R.raw.star,
                              R.raw.triangle, R.raw.rectangle};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        gridview=findViewById(R.id.gridview4);
        main_page = findViewById(R.id.mainBtn);
        image = findViewById(R.id.imageView1);
        previous_page = findViewById(R.id.previousBtn1);
        ArrayAdapter adapter;
        adapter = new ArrayAdapter(this, simple_list_item_1,shape);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Set the image based on the position of the clicked letter
                image.setImageResource(shape_images[position]);

                //Set the sound based on the position of the clicked letter
                if (player != null) {
                    player.release();
                }
                player = MediaPlayer.create(MainActivity5.this, shape_sounds[position]);
                player.start();
            }
        });
        main_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        previous_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}