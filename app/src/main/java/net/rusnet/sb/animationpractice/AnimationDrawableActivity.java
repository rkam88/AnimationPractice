package net.rusnet.sb.animationpractice;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AnimationDrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animation_drawable);

        ImageView imageView = findViewById(R.id.image_view);
        ((AnimationDrawable) imageView.getDrawable()).start();
    }
}
