package net.rusnet.sb.animationpractice;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ObjectAnimationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animations);


        ImageView imageView = findViewById(R.id.image_view);

        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(
                imageView,
                "scaleX",
                0.5f,
                1f
        );

        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(
                imageView,
                "scaleY",
                0.5f,
                1f
        );

        configure(scaleXAnimator).start();
        configure(scaleYAnimator).start();
    }

    private Animator configure(ObjectAnimator animator) {
        animator.setDuration(1000);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        return animator;
    }
}
