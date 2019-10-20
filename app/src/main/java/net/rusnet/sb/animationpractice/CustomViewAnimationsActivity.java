package net.rusnet.sb.animationpractice;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CustomViewAnimationsActivity extends AppCompatActivity {

    private Animator mAnimator;

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


        mAnimator = configure(progressAnimator);
    }

    private Animator configure(ObjectAnimator animator) {
        animator.setDuration(2500);
        animator.setRepeatMode(ObjectAnimator.RESTART);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        return animator;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAnimator.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAnimator.end();
    }
}