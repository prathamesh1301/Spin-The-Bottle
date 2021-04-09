package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView bottle;
    boolean spinning;
    int lastDir=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle=findViewById(R.id.bottle);
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinClick();
            }
        });
    }

    private void spinClick(){
        if(!spinning) {
            Random random = new Random();
            int newDir = random.nextInt(1800);
            float pivotX = bottle.getWidth() / 2;
            float pivotY = bottle.getHeight() / 2;
            Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setDuration(2500);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            lastDir=newDir;
            bottle.startAnimation(rotate);
        }
    }
}