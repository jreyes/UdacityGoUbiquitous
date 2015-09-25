package com.example.android.sunshine.app.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.CallSuper;

import static com.example.android.sunshine.app.util.Utilities.applyPointValueFromSpec;

public abstract class BaseFaceItem {
// ------------------------------ FIELDS ------------------------------

    protected boolean mInteractive;
    protected Paint mPaint;
    protected PointF mPointF;
    protected PointF mPosition;

// --------------------------- CONSTRUCTORS ---------------------------

    public BaseFaceItem() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);

        mPointF = new PointF(0f, 0f);
    }

// -------------------------- OTHER METHODS --------------------------

    @CallSuper
    public void ambientState() {
        lowBitState();
    }

    @CallSuper
    public void interactiveState() {
        mInteractive = true;
    }

    @CallSuper
    public void lowBitState() {
        mInteractive = false;
    }

    public abstract void onDraw(Canvas canvas, int positionX, int positionY);

    @CallSuper
    public void onLayout(float renderSize) {
        applyPointValueFromSpec(mPointF, mPosition, renderSize);
    }
}
