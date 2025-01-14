package p000a.p006b.p012d.p016o.p017e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.p067v7.widget.CardView;
import p000a.p006b.p012d.p016o.CircularRevealHelper;
import p000a.p006b.p012d.p016o.CircularRevealWidget;

/* renamed from: a.b.d.o.e.a */
/* loaded from: classes.dex */
public class CircularRevealCardView extends CardView implements CircularRevealWidget {

    /* renamed from: j */
    public final CircularRevealHelper f484j;

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    /* renamed from: a */
    public void mo10891a() {
        this.f484j.m10902b();
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    /* renamed from: b */
    public void mo10890b() {
        this.f484j.m10907a();
        throw null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.f484j;
        if (circularRevealHelper == null) {
            super.draw(canvas);
        } else {
            circularRevealHelper.m10904a(canvas);
            throw null;
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        this.f484j.m10901c();
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    public int getCircularRevealScrimColor() {
        this.f484j.m10900d();
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    public CircularRevealWidget.C0056e getRevealInfo() {
        this.f484j.m10899e();
        throw null;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.f484j;
        if (circularRevealHelper == null) {
            return super.isOpaque();
        }
        circularRevealHelper.m10898f();
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f484j.m10903a(drawable);
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    public void setCircularRevealScrimColor(int i) {
        this.f484j.m10906a(i);
        throw null;
    }

    @Override // p000a.p006b.p012d.p016o.CircularRevealWidget
    public void setRevealInfo(CircularRevealWidget.C0056e c0056e) {
        this.f484j.m10905a(c0056e);
        throw null;
    }
}
