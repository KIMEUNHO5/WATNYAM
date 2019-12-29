package com.forif.watnyam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class finalround extends AppCompatActivity {

    int[] finalfood=new int[1];

    ImageView image1;

    int[] imgs = {R.drawable.food1, R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food6,
            R.drawable.food7,R.drawable.food8,R.drawable.food9,R.drawable.food10,R.drawable.food11,R.drawable.food12,R.drawable.food13,
            R.drawable.food14,R.drawable.food15,R.drawable.food16};



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalround);
        image1 = findViewById(R.id.image1);
        Intent intent = getIntent();
        finalfood = intent.getIntArrayExtra("key4");

        image1.setImageResource(imgs[finalfood[0]]);

    }
}
