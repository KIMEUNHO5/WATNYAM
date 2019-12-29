package com.forif.watnyam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class round2 extends AppCompatActivity {
    ImageView image1;
    ImageView image2;
    int [] r2= new int[2];
    public static int[] finalfood = new int[1];
    int[] imgs = {R.drawable.food1, R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food6,
            R.drawable.food7,R.drawable.food8,R.drawable.food9,R.drawable.food10,R.drawable.food11,R.drawable.food12,R.drawable.food13,
            R.drawable.food14,R.drawable.food15,R.drawable.food16};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round2);

        Intent intent = getIntent();
        r2 = intent.getIntArrayExtra("key3");


        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);

        image1.setImageResource(imgs[r2[0]]);
        image2.setImageResource(imgs[r2[1]]);

        image1.setOnClickListener(new View.OnClickListener() {
            Intent intent4 = new Intent(getApplicationContext(), finalround.class);
            @Override
            public void onClick(View view) {
                finalfood[0]=r2[0];
                intent4.putExtra("key4", finalfood);
                startActivity(intent4);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            Intent intent4 = new Intent(getApplicationContext(), finalround.class);
            @Override
            public void onClick(View view) {
                finalfood[0]=r2[1];
                intent4.putExtra("key4", finalfood);
                startActivity(intent4);
            }
        });
    }
}
