package a.b.d.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;
/* compiled from: StateListAnimator.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<b> f392a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public b f393b = null;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f394c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Animator.AnimatorListener f395d = new a();

    /* compiled from: StateListAnimator.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p pVar = p.this;
            if (pVar.f394c == animator) {
                pVar.f394c = null;
            }
        }
    }

    /* compiled from: StateListAnimator.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f397a;

        /* renamed from: b  reason: collision with root package name */
        public final ValueAnimator f398b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.f397a = iArr;
            this.f398b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f395d);
        this.f392a.add(bVar);
    }

    public void b() {
        ValueAnimator valueAnimator = this.f394c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f394c = null;
        }
    }

    public void a(int[] iArr) {
        b bVar;
        int size = this.f392a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bVar = null;
                break;
            }
            bVar = this.f392a.get(i2);
            if (StateSet.stateSetMatches(bVar.f397a, iArr)) {
                break;
            }
            i2++;
        }
        b bVar2 = this.f393b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            a();
        }
        this.f393b = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public final void a(b bVar) {
        this.f394c = bVar.f398b;
        this.f394c.start();
    }

    public final void a() {
        ValueAnimator valueAnimator = this.f394c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f394c = null;
        }
    }
}
