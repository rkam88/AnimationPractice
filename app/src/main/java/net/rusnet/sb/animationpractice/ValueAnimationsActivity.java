package net.rusnet.sb.animationpractice;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ValueAnimationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animations);


        ImageView imageView = findViewById(R.id.image_view);

        ValueAnimator alphaAnimator = ValueAnimator.ofFloat(0f, 1f);
        configureAnimation(alphaAnimator);
        alphaAnimator.addUpdateListener(
                animation -> imageView.setAlpha((Float) animation.getAnimatedValue())
        );
        alphaAnimator.start();

        float length = (-1f) * getResources().getDimension(R.dimen.y_length);
        ValueAnimator translationYAnimator = ValueAnimator.ofFloat(0f, length);
        configureAnimation(translationYAnimator);
        translationYAnimator.addUpdateListener(
                animation -> imageView.setTranslationY((Float) translationYAnimator.getAnimatedValue())
        );
        translationYAnimator.start();

    }

    private void configureAnimation(ValueAnimator animator) {
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(20);
        animator.setDuration(800);
    }
}
