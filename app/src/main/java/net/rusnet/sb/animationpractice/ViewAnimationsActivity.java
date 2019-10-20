package net.rusnet.sb.animationpractice;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class ViewAnimationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animations);

        Animation animation = AnimationUtils.loadAnimation(
                this,
                R.anim.rotate_and_scale
        );

        View imageView = findViewById(R.id.image_view);

        imageView.setOnClickListener(v -> {
            imageView.clearAnimation();
            imageView.startAnimation(animation);
        });

    }


}
