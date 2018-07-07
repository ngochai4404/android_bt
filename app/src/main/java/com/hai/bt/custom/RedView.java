package com.hai.bt.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.hai.bt.R;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by Hai on 05/07/2018.
 */

public class RedView extends View implements View.OnTouchListener{
    private int mColorBackground =Color.RED;
    private int mColorPress = Color.YELLOW;
    private int mColor = Color.YELLOW;

    public RedView(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    @SuppressLint("ResourceType")
    public RedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public RedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
    @SuppressLint("ResourceType")
    void init(Context context, AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RedView);
        int color = R.styleable.RedView_ColoredView;
        mColorPress = typedArray.getColor(R.styleable.RedView_ColoredView,mColorPress);
        mColorBackground = typedArray.getColor(R.styleable.RedView_BackgroundView,mColorBackground);
        mColor = mColorBackground;
        typedArray.recycle();
        invalidate();
        setOnTouchListener(this);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(mColor);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            mColor = mColorBackground;
            invalidate();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mColor = mColorPress;
            invalidate();
            return true;
        }

        return false;
    }
}
