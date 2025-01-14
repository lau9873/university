package pt.opt.anda.gui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import p000a.p006b.p030g.p045k.ViewPager;

/* loaded from: classes.dex */
public class NonSwipableViewPager extends ViewPager {

    /* renamed from: k0 */
    public boolean f10931k0;

    public NonSwipableViewPager(Context context) {
        super(context);
        this.f10931k0 = false;
    }

    @Override // p000a.p006b.p030g.p045k.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f10931k0 && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // p000a.p006b.p030g.p045k.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f10931k0 && super.onTouchEvent(motionEvent);
    }

    public NonSwipableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10931k0 = false;
    }
}
