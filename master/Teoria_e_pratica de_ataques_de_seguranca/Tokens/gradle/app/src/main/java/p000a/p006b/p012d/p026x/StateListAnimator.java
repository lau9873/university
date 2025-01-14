package p000a.p006b.p012d.p026x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* renamed from: a.b.d.x.p */
/* loaded from: classes.dex */
public final class StateListAnimator {

    /* renamed from: a */
    public final ArrayList<C0080b> f734a = new ArrayList<>();

    /* renamed from: b */
    public C0080b f735b = null;

    /* renamed from: c */
    public ValueAnimator f736c = null;

    /* renamed from: d */
    public final Animator.AnimatorListener f737d = new C0079a();

    /* compiled from: StateListAnimator.java */
    /* renamed from: a.b.d.x.p$a */
    /* loaded from: classes.dex */
    public class C0079a extends AnimatorListenerAdapter {
        public C0079a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.f736c == animator) {
                stateListAnimator.f736c = null;
            }
        }
    }

    /* compiled from: StateListAnimator.java */
    /* renamed from: a.b.d.x.p$b */
    /* loaded from: classes.dex */
    public static class C0080b {

        /* renamed from: a */
        public final int[] f739a;

        /* renamed from: b */
        public final ValueAnimator f740b;

        public C0080b(int[] iArr, ValueAnimator valueAnimator) {
            this.f739a = iArr;
            this.f740b = valueAnimator;
        }
    }

    /* renamed from: a */
    public void m10660a(int[] iArr, ValueAnimator valueAnimator) {
        C0080b c0080b = new C0080b(iArr, valueAnimator);
        valueAnimator.addListener(this.f737d);
        this.f734a.add(c0080b);
    }

    /* renamed from: b */
    public void m10659b() {
        ValueAnimator valueAnimator = this.f736c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f736c = null;
        }
    }

    /* renamed from: a */
    public void m10661a(int[] iArr) {
        C0080b c0080b;
        int size = this.f734a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                c0080b = null;
                break;
            }
            c0080b = this.f734a.get(i);
            if (StateSet.stateSetMatches(c0080b.f739a, iArr)) {
                break;
            }
            i++;
        }
        C0080b c0080b2 = this.f735b;
        if (c0080b == c0080b2) {
            return;
        }
        if (c0080b2 != null) {
            m10663a();
        }
        this.f735b = c0080b;
        if (c0080b != null) {
            m10662a(c0080b);
        }
    }

    /* renamed from: a */
    public final void m10662a(C0080b c0080b) {
        this.f736c = c0080b.f740b;
        this.f736c.start();
    }

    /* renamed from: a */
    public final void m10663a() {
        ValueAnimator valueAnimator = this.f736c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f736c = null;
        }
    }
}
