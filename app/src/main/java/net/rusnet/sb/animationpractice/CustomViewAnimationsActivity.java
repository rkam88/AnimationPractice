package net.rusnet.sb.animationpractice;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CustomViewAnimationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom_view_animations);


        FinanceProgressView progressView = findViewById(R.id.financeProgress);

        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(
                progressView,
                "progress",
                5, 55, 5
        );


        configure(progressAnimator).start();
    }

    private Animator configure(ObjectAnimator animator) {
        animator.setDuration(2500);
        animator.setRepeatMode(ObjectAnimator.RESTART);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        return animator;
    }
}