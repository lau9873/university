package a.b.h.k;

import android.support.v7.widget.RecyclerView;
import android.view.View;
/* compiled from: LayoutState.java */
/* loaded from: classes.dex */
public class q0 {

    /* renamed from: b  reason: collision with root package name */
    public int f1908b;

    /* renamed from: c  reason: collision with root package name */
    public int f1909c;

    /* renamed from: d  reason: collision with root package name */
    public int f1910d;

    /* renamed from: e  reason: collision with root package name */
    public int f1911e;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1914h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1915i;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1907a = true;

    /* renamed from: f  reason: collision with root package name */
    public int f1912f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f1913g = 0;

    public boolean a(RecyclerView.a0 a0Var) {
        int i2 = this.f1909c;
        return i2 >= 0 && i2 < a0Var.a();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1908b + ", mCurrentPosition=" + this.f1909c + ", mItemDirection=" + this.f1910d + ", mLayoutDirection=" + this.f1911e + ", mStartLine=" + this.f1912f + ", mEndLine=" + this.f1913g + '}';
    }

    public View a(RecyclerView.v vVar) {
        View d2 = vVar.d(this.f1909c);
        this.f1909c += this.f1910d;
        return d2;
    }
}
