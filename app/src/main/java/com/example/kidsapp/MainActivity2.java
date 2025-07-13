package com.example.kidsapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import static android.R.layout.simple_list_item_1;

public class MainActivity2 extends AppCompatActivity {
    GridView gridview;
    ImageView image;
    Button next_page,previous_page;
    MediaPlayer player;

    String[] alphabet = new String[]{"A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    Integer[] alphabet_images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
            R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j,
            R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o,
            R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t,
            R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x, R.drawable.y, R.drawable.z};

    Integer[] alphabet_sounds = {R.raw.a, R.raw.b,R.raw.c, R.raw.d,R.raw.e, R.raw.f,R.raw.g, R.raw.h,R.raw.i, R.raw.j,
                                 R.raw.k, R.raw.l,R.raw.m, R.raw.n, R.raw.o, R.raw.p, R.raw.q,R.raw.r, R.raw.s,
                                 R.raw.t, R.raw.u,R.raw.v, R.raw.w,R.raw.x, R.raw.y,R.raw.z};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gridview = findViewById(R.id.gridview1);
        next_page = findViewById(R.id.nextBtn);
        image = findViewById(R.id.imageView1);
        previous_page=findViewById(R.id.previousBtn1);

        ArrayAdapter adapter = new ArrayAdapter(this, simple_list_item_1, alphabet);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Set the image based on the position of the clicked letter
                image.setImageResource(alphabet_images[position]);

                // Set the sound based on the position of the clicked letter
                if (player != null) {
                    player.release();
                }
                    player = MediaPlayer.create(MainActivity2.this, alphabet_sounds[position]);
                    player.start();
            }
        });
        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity3.class);
                startActivity(intent);
            }
        });
        previous_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
