package c.c.a.j;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
/* compiled from: VisibilityAnimationManager.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final View f3193a;

    /* renamed from: b  reason: collision with root package name */
    public AnimatorSet f3194b;

    /* renamed from: c  reason: collision with root package name */
    public AnimatorSet f3195c;

    /* renamed from: d  reason: collision with root package name */
    public float f3196d;

    /* renamed from: e  reason: collision with root package name */
    public float f3197e;

    /* compiled from: VisibilityAnimationManager.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3198a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f3199b;

        public a(e eVar, View view) {
            this.f3199b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f3198a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.f3198a) {
                this.f3199b.setVisibility(4);
            }
            this.f3198a = false;
        }
    }

    /* compiled from: VisibilityAnimationManager.java */
    /* loaded from: classes.dex */
    public static abstract class b<T extends e> {

        /* renamed from: a  reason: collision with root package name */
        public final View f3200a;

        /* renamed from: b  reason: collision with root package name */
        public int f3201b = c.c.a.a.fastscroll__default_show;

        /* renamed from: c  reason: collision with root package name */
        public int f3202c = c.c.a.a.fastscroll__default_hide;

        /* renamed from: d  reason: collision with root package name */
        public int f3203d = 1000;

        /* renamed from: e  reason: collision with root package name */
        public float f3204e = 0.5f;

        /* renamed from: f  reason: collision with root package name */
        public float f3205f = 0.5f;

        public b(View view) {
            this.f3200a = view;
        }

        public b<T> a(float f2) {
            this.f3204e = f2;
            return this;
        }

        public abstract T a();

        public b<T> b(float f2) {
            this.f3205f = f2;
            return this;
        }
    }

    /* compiled from: VisibilityAnimationManager.java */
    /* loaded from: classes.dex */
    public static class c extends b<e> {
        public c(View view) {
            super(view);
        }

        @Override // c.c.a.j.e.b
        public e a() {
            return new e(this.f3200a, this.f3201b, this.f3202c, this.f3204e, this.f3205f, this.f3203d);
        }
    }

    public e(View view, int i2, int i3, float f2, float f3, int i4) {
        this.f3193a = view;
        this.f3196d = f2;
        this.f3197e = f3;
        this.f3194b = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(), i3);
        this.f3194b.setStartDelay(i4);
        this.f3194b.setTarget(view);
        this.f3195c = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(), i2);
        this.f3195c.setTarget(view);
        this.f3194b.addListener(new a(this, view));
        c();
    }

    public void a() {
        c();
        this.f3194b.start();
    }

    public void b() {
        this.f3194b.cancel();
        if (this.f3193a.getVisibility() == 4) {
            this.f3193a.setVisibility(0);
            c();
            this.f3195c.start();
        }
    }

    public void c() {
        View view = this.f3193a;
        view.setPivotX(this.f3196d * view.getMeasuredWidth());
        View view2 = this.f3193a;
        view2.setPivotY(this.f3197e * view2.getMeasuredHeight());
    }
}
