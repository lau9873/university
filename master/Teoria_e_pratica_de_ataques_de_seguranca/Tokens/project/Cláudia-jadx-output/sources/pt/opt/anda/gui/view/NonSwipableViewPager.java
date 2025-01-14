package pt.opt.anda.gui.view;

import a.b.g.k.x;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class NonSwipableViewPager extends x {
    public boolean k0;

    public NonSwipableViewPager(Context context) {
        super(context);
        this.k0 = false;
    }

    @Override // a.b.g.k.x, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.k0 && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // a.b.g.k.x, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.k0 && super.onTouchEvent(motionEvent);
    }

    public NonSwipableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k0 = false;
    }
}
