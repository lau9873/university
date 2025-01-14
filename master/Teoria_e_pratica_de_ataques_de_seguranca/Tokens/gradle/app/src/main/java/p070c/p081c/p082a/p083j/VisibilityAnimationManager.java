package p070c.p081c.p082a.p083j;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import p070c.p081c.p082a.C0882a;

/* renamed from: c.c.a.j.e */
/* loaded from: classes.dex */
public class VisibilityAnimationManager {

    /* renamed from: a */
    public final View f5031a;

    /* renamed from: b */
    public AnimatorSet f5032b;

    /* renamed from: c */
    public AnimatorSet f5033c;

    /* renamed from: d */
    public float f5034d;

    /* renamed from: e */
    public float f5035e;

    /* compiled from: VisibilityAnimationManager.java */
    /* renamed from: c.c.a.j.e$a */
    /* loaded from: classes.dex */
    public class C0890a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f5036a;

        /* renamed from: b */
        public final /* synthetic */ View f5037b;

        public C0890a(VisibilityAnimationManager visibilityAnimationManager, View view) {
            this.f5037b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            this.f5036a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.f5036a) {
                this.f5037b.setVisibility(4);
            }
            this.f5036a = false;
        }
    }

    /* compiled from: VisibilityAnimationManager.java */
    /* renamed from: c.c.a.j.e$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0891b<T extends VisibilityAnimationManager> {

        /* renamed from: a */
        public final View f5038a;

        /* renamed from: b */
        public int f5039b = C0882a.fastscroll__default_show;

        /* renamed from: c */
        public int f5040c = C0882a.fastscroll__default_hide;

        /* renamed from: d */
        public int f5041d = 1000;

        /* renamed from: e */
        public float f5042e = 0.5f;

        /* renamed from: f */
        public float f5043f = 0.5f;

        public AbstractC0891b(View view) {
            this.f5038a = view;
        }

        /* renamed from: a */
        public AbstractC0891b<T> m5657a(float f) {
            this.f5042e = f;
            return this;
        }

        /* renamed from: a */
        public abstract T mo5655a();

        /* renamed from: b */
        public AbstractC0891b<T> m5656b(float f) {
            this.f5043f = f;
            return this;
        }
    }

    /* compiled from: VisibilityAnimationManager.java */
    /* renamed from: c.c.a.j.e$c */
    /* loaded from: classes.dex */
    public static class C0892c extends AbstractC0891b<VisibilityAnimationManager> {
        public C0892c(View view) {
            super(view);
        }

        @Override // p070c.p081c.p082a.p083j.VisibilityAnimationManager.AbstractC0891b
        /* renamed from: a */
        public VisibilityAnimationManager mo5655a() {
            return new VisibilityAnimationManager(this.f5038a, this.f5039b, this.f5040c, this.f5042e, this.f5043f, this.f5041d);
        }
    }

    public VisibilityAnimationManager(View view, int i, int i2, float f, float f2, int i3) {
        this.f5031a = view;
        this.f5034d = f;
        this.f5035e = f2;
        this.f5032b = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(), i2);
        this.f5032b.setStartDelay(i3);
        this.f5032b.setTarget(view);
        this.f5033c = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(), i);
        this.f5033c.setTarget(view);
        this.f5032b.addListener(new C0890a(this, view));
        m5658c();
    }

    /* renamed from: a */
    public void m5660a() {
        m5658c();
        this.f5032b.start();
    }

    /* renamed from: b */
    public void m5659b() {
        this.f5032b.cancel();
        if (this.f5031a.getVisibility() == 4) {
            this.f5031a.setVisibility(0);
            m5658c();
            this.f5033c.start();
        }
    }

    /* renamed from: c */
    public void m5658c() {
        View view = this.f5031a;
        view.setPivotX(this.f5034d * view.getMeasuredWidth());
        View view2 = this.f5031a;
        view2.setPivotY(this.f5035e * view2.getMeasuredHeight());
    }
}
