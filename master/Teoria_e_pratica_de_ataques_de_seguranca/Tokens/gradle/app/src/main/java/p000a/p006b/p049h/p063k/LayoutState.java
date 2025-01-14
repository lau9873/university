package p000a.p006b.p049h.p063k;

import android.support.p067v7.widget.RecyclerView;
import android.view.View;

/* renamed from: a.b.h.k.q0 */
/* loaded from: classes.dex */
public class LayoutState {

    /* renamed from: b */
    public int f2872b;

    /* renamed from: c */
    public int f2873c;

    /* renamed from: d */
    public int f2874d;

    /* renamed from: e */
    public int f2875e;

    /* renamed from: h */
    public boolean f2878h;

    /* renamed from: i */
    public boolean f2879i;

    /* renamed from: a */
    public boolean f2871a = true;

    /* renamed from: f */
    public int f2876f = 0;

    /* renamed from: g */
    public int f2877g = 0;

    /* renamed from: a */
    public boolean m8133a(RecyclerView.C0702a0 c0702a0) {
        int i = this.f2873c;
        return i >= 0 && i < c0702a0.m6846a();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2872b + ", mCurrentPosition=" + this.f2873c + ", mItemDirection=" + this.f2874d + ", mLayoutDirection=" + this.f2875e + ", mStartLine=" + this.f2876f + ", mEndLine=" + this.f2877g + '}';
    }

    /* renamed from: a */
    public View m8132a(RecyclerView.C0734v c0734v) {
        View m6555d = c0734v.m6555d(this.f2873c);
        this.f2873c += this.f2874d;
        return m6555d;
    }
}
