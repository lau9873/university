package p000a.p006b.p012d.p016o;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import p000a.p006b.p012d.p016o.CircularRevealWidget;

/* renamed from: a.b.d.o.b */
/* loaded from: classes.dex */
public class CircularRevealFrameLayout extends FrameLayout implements CircularRevealWidget {

    /* renamed from: a */
    public final CircularRevealHelper f475a;

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    /* renamed from: a */
    public void mo10891a() {
        this.f475a.m10902b();
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    /* renamed from: b */
    public void mo10890b() {
        this.f475a.m10907a();
        throw null;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.f475a;
        if (circularRevealHelper == null) {
            super.draw(canvas);
        } else {
            circularRevealHelper.m10904a(canvas);
            throw null;
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        this.f475a.m10901c();
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    public int getCircularRevealScrimColor() {
        this.f475a.m10900d();
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    public CircularRevealWidget.C0056e getRevealInfo() {
        this.f475a.m10899e();
        throw null;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.f475a;
        if (circularRevealHelper == null) {
            return super.isOpaque();
        }
        circularRevealHelper.m10898f();
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f475a.m10903a(drawable);
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    public void setCircularRevealScrimColor(int i) {
        this.f475a.m10906a(i);
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    public void setRevealInfo(CircularRevealWidget.C0056e c0056e) {
        this.f475a.m10905a(c0056e);
        throw null;
    }
}
