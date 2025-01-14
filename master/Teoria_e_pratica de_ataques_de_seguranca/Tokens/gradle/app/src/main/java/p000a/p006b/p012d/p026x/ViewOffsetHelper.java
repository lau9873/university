package p000a.p006b.p012d.p026x;

import android.view.View;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.d.x.r */
/* loaded from: classes.dex */
public class ViewOffsetHelper {

    /* renamed from: a */
    public final View f744a;

    /* renamed from: b */
    public int f745b;

    /* renamed from: c */
    public int f746c;

    /* renamed from: d */
    public int f747d;

    /* renamed from: e */
    public int f748e;

    public ViewOffsetHelper(View view) {
        this.f744a = view;
    }

    /* renamed from: a */
    public boolean m10654a(int i) {
        if (this.f748e != i) {
            this.f748e = i;
            m10651c();
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public void m10653b() {
        this.f745b = this.f744a.getTop();
        this.f746c = this.f744a.getLeft();
        m10651c();
    }

    /* renamed from: c */
    public final void m10651c() {
        View view = this.f744a;
        ViewCompat.m9433d(view, this.f747d - (view.getTop() - this.f745b));
        View view2 = this.f744a;
        ViewCompat.m9435c(view2, this.f748e - (view2.getLeft() - this.f746c));
    }

    /* renamed from: a */
    public int m10655a() {
        return this.f747d;
    }

    /* renamed from: b */
    public boolean m10652b(int i) {
        if (this.f747d != i) {
            this.f747d = i;
            m10651c();
            return true;
        }
        return false;
    }
}
