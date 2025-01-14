package a.b.d.o.e;

import a.b.d.o.c;
import a.b.d.o.d;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
/* compiled from: CircularRevealCardView.java */
/* loaded from: classes.dex */
public class a extends CardView implements d {
    public final c j;

    @Override // a.b.d.o.d
    public void a() {
        this.j.b();
        throw null;
    }

    @Override // a.b.d.o.d
    public void b() {
        this.j.a();
        throw null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        c cVar = this.j;
        if (cVar == null) {
            super.draw(canvas);
        } else {
            cVar.a(canvas);
            throw null;
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        this.j.c();
        throw null;
    }

    @Override // a.b.d.o.d
    public int getCircularRevealScrimColor() {
        this.j.d();
        throw null;
    }

    @Override // a.b.d.o.d
    public d.e getRevealInfo() {
        this.j.e();
        throw null;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        c cVar = this.j;
        if (cVar == null) {
            return super.isOpaque();
        }
        cVar.f();
        throw null;
    }

    @Override // a.b.d.o.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.j.a(drawable);
        throw null;
    }

    @Override // a.b.d.o.d
    public void setCircularRevealScrimColor(int i2) {
        this.j.a(i2);
        throw null;
    }

    @Override // a.b.d.o.d
    public void setRevealInfo(d.e eVar) {
        this.j.a(eVar);
        throw null;
    }
}
