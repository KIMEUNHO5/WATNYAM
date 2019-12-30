package com.forif.watnyam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Round4Activity extends AppCompatActivity {

    ImageView image1;
    ImageView image2;
    int[] imgs = {R.drawable.food1, R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food6,
            R.drawable.food7,R.drawable.food8,R.drawable.food9,R.drawable.food10,R.drawable.food11,R.drawable.food12,R.drawable.food13,
            R.drawable.food14,R.drawable.food15,R.drawable.food16};

    int [] r4 = new int[4];
    public static int count3=2;
    public static int[] r2 = new int[2];
    public static int c=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round4_activity);

        Intent intent = getIntent();
        r4 = intent.getIntArrayExtra("key2");

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);

        image1.setImageResource(imgs[r4[0]]);
        image2.setImageResource(imgs[r4[1]]);

        image1.setOnClickListener(new View.OnClickListener() {
            Intent intent3 = new Intent(getApplicationContext(), Round2Activity.class);
            @Override
            public void onClick(View view) {
                if(count3 > 3){
                    r2[c]=r4[count3-2];
                    count3=0;
                    intent3.putExtra("key3", r2);
                    startActivity(intent3);
                }
                image1.setImageResource(imgs[r4[count3]]);
                image2.setImageResource(imgs[r4[count3+1]]);
                r2[c]=r4[count3-2];
                count3 +=2;
                c++;
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            Intent intent3 = new Intent(getApplicationContext(), Round2Activity.class);
            @Override
            public void onClick(View view) {
                if(count3 > 3){
                    r2[c]=r4[count3-1];
                    count3=0;
                    intent3.putExtra("key3", r2);
                    startActivity(intent3);
                }
                image1.setImageResource(imgs[r4[count3]]);
                image2.setImageResource(imgs[r4[count3+1]]);
                r2[c]=r4[count3-1];
                count3 +=2;
                c++;
            }
        });
    }
}
