package com.forif.watnyam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Round8Activity extends AppCompatActivity {

    private static final String TAG = "Round8Activity";
    ImageView image1;
    ImageView image2;
    int[] imgs = {R.drawable.food1, R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food6,
            R.drawable.food7,R.drawable.food8,R.drawable.food9,R.drawable.food10,R.drawable.food11,R.drawable.food12,R.drawable.food13,
            R.drawable.food14,R.drawable.food15,R.drawable.food16};

    public static int count2=2;
    public static int[] r4 = new int[4];
    public static int b=0;
    int [] r8 = new int[8];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round8_activity);

        Intent intent = getIntent();
        r8 = intent.getIntArrayExtra("key");
        Log.d(TAG, "onCreate: " + r8[7]);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);

        image1.setImageResource(imgs[r8[0]]);
        image2.setImageResource(imgs[r8[1]]);




        image1.setOnClickListener(new View.OnClickListener() {
            Intent intent2 = new Intent(getApplicationContext(), Round4Activity.class);
            @Override
            public void onClick(View view) {
                if(count2>7){
                    r4[b]=r8[count2-2];
                    count2=0;
                    intent2.putExtra("key2", r4);
                    startActivity(intent2);
                }
                image1.setImageResource(imgs[r8[count2]]);
                image2.setImageResource(imgs[r8[count2+1]]);
                r4[b]=r8[count2-2];
                count2 +=2;
                b++;
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            Intent intent2 = new Intent(getApplicationContext(), Round4Activity.class);
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: " + r8[7]);
                if(count2>7){
                    r4[b]=r8[count2-1];
                    count2=0;
                    intent2.putExtra("key2", r4);
                    startActivity(intent2);
                }
                image1.setImageResource(imgs[r8[count2]]);
                image2.setImageResource(imgs[r8[count2+1]]);
                r4[b]=r8[count2-1];
                count2 +=2;
                b++;
            }
        });
    }
}
