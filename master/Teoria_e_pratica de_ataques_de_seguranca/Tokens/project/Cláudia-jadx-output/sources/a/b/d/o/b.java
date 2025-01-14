package a.b.d.o;

import a.b.d.o.d;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
/* compiled from: CircularRevealFrameLayout.java */
/* loaded from: classes.dex */
public class b extends FrameLayout implements d {

    /* renamed from: a  reason: collision with root package name */
    public final c f249a;

    @Override // a.b.d.o.d
    public void a() {
        this.f249a.b();
        throw null;
    }

    @Override // a.b.d.o.d
    public void b() {
        this.f249a.a();
        throw null;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        c cVar = this.f249a;
        if (cVar == null) {
            super.draw(canvas);
        } else {
            cVar.a(canvas);
            throw null;
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        this.f249a.c();
        throw null;
    }

    @Override // a.b.d.o.d
    public int getCircularRevealScrimColor() {
        this.f249a.d();
        throw null;
    }

    @Override // a.b.d.o.d
    public d.e getRevealInfo() {
        this.f249a.e();
        throw null;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.f249a;
        if (cVar == null) {
            return super.isOpaque();
        }
        cVar.f();
        throw null;
    }

    @Override // a.b.d.o.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f249a.a(drawable);
        throw null;
    }

    @Override // a.b.d.o.d
    public void setCircularRevealScrimColor(int i2) {
        this.f249a.a(i2);
        throw null;
    }

    @Override // a.b.d.o.d
    public void setRevealInfo(d.e eVar) {
        this.f249a.a(eVar);
        throw null;
    }
}
