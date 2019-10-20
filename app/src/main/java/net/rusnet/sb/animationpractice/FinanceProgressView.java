package net.rusnet.sb.animationpractice;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FinanceProgressView extends View {

    public static final int DEFAULT_COLOR = Color.RED;
    public static final int MAX_PROGRESS = 100;
    public static final int MAX_ANGLE = 360;

    private float mStrokeWidth = 64f;

    private int mProgress;
    private int mColor;
    private int mTextSize;

    private Paint mCircePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mProgressRect = new RectF();

    private Rect mTextBounds = new Rect();


    public FinanceProgressView(Context context) {
        super(context);
        init(context, null);
    }

    public FinanceProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mStrokeWidth / 2, mStrokeWidth / 2);

        canvas.drawArc(mProgressRect,
                270,
                mProgress * MAX_ANGLE / MAX_PROGRESS,
                false,
                mCircePaint);

        final String progressString = formatString(mProgress);

        getTextBounds(progressString);
        float x = mProgressRect.width() / 2f - mTextBounds.width() / 2f - mTextBounds.left;
        float y = mProgressRect.height() / 2f + mTextBounds.height() / 2f - mTextBounds.bottom;

        canvas.drawText(progressString,
                x,
                y,
                mTextPaint);

    }

    private void getTextBounds(@NonNull String progressString) {
        mTextPaint.getTextBounds(progressString, 0, progressString.length(), mTextBounds);
    }

    private String formatString(int progress) {
        return String.format(
                getResources().getString(R.string.progress_template),
                progress);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs) {
        extractAttributes(context, attrs);

        configureCirclePaint();

        configureTextPaint();
    }

    private void configureTextPaint() {
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setColor(mColor);
    }

    private void configureCirclePaint() {
        mCircePaint.setStrokeWidth(mStrokeWidth);
        mCircePaint.setStyle(Paint.Style.STROKE);
        mCircePaint.setColor(mColor);
    }

    private void extractAttributes(@NonNull Context context, @Nullable AttributeSet attrs) {
        final Resources.Theme theme = context.getTheme();
        final TypedArray typedArray = theme.obtainStyledAttributes(
                attrs,
                R.styleable.FinanceProgressView,
                R.attr.financeProgressStyle,
                0);

        try {
            mProgress = typedArray.getInteger(R.styleable.FinanceProgressView_progress, 0);
            mColor = typedArray.getColor(R.styleable.FinanceProgressView_color, DEFAULT_COLOR);
            mTextSize = typedArray.getDimensionPixelSize(
                    R.styleable.FinanceProgressView_textSize,
                    getResources().getDimensionPixelSize(R.dimen.defaultTextSize));

        } finally {
            typedArray.recycle();
        }
    }

    public int getProgress() {
        return mProgress;
    }

    public int getColor() {
        return mColor;
    }

    public int getTextSize() {
        return mTextSize;
    }

    public void setProgress(int mProgress) {
        this.mProgress = mProgress;
        invalidate();
    }

    public void setColor(int mColor) {
        this.mColor = mColor;
    }

    public void setTextSize(int mTextSize) {
        this.mTextSize = mTextSize;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        getTextBounds(formatString(MAX_PROGRESS));

        mStrokeWidth = mTextBounds.height();
        mCircePaint.setStrokeWidth(mStrokeWidth);

        int size = (int) (Math.max(mTextBounds.width(), mTextBounds.height()) + Math.PI * mStrokeWidth);

        final int width = resolveSize(size, widthMeasureSpec);
        final int height = resolveSize(size, heightMeasureSpec);
        mProgressRect.right = size - mStrokeWidth;
        mProgressRect.bottom = size - mStrokeWidth;

        setMeasuredDimension(width, height);
    }

}
