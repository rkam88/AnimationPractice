package net.rusnet.sb.animationpractice;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat;

public class ValueAnimationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animations);

        ImageView imageView = findViewById(R.id.image_view);

        ValueAnimator animatorXmlAlpha = (ValueAnimator) AnimatorInflaterCompat.
                loadAnimator(this, R.animator.value_animator_alpha);
        animatorXmlAlpha.addUpdateListener(
                animator -> imageView.setAlpha((Float) animator.getAnimatedValue())
        );

        ValueAnimator animatorXmlTranslation = (ValueAnimator) AnimatorInflaterCompat.
                loadAnimator(this, R.animator.value_animator_translation);
        animatorXmlTranslation.addUpdateListener(
                animator -> imageView.setTranslationY((-1f) * ((float) animatorXmlTranslation.getAnimatedValue()))
        );

        AnimatorSet set = new AnimatorSet();
        set.playTogether(animatorXmlAlpha, animatorXmlTranslation);
        set.start();

    }
}
