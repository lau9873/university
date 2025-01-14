package a.b.g.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<View> f1175a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f1176b = null;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f1177c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f1178d = -1;

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a0 f1179a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f1180b;

        public a(z zVar, a0 a0Var, View view) {
            this.f1179a = a0Var;
            this.f1180b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1179a.a(this.f1180b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1179a.b(this.f1180b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f1179a.c(this.f1180b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f1181a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f1182b;

        public b(z zVar, c0 c0Var, View view) {
            this.f1181a = c0Var;
            this.f1182b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f1181a.a(this.f1182b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    public static class c implements a0 {

        /* renamed from: a  reason: collision with root package name */
        public z f1183a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1184b;

        public c(z zVar) {
            this.f1183a = zVar;
        }

        @Override // a.b.g.k.a0
        public void a(View view) {
            Object tag = view.getTag(2113929216);
            a0 a0Var = tag instanceof a0 ? (a0) tag : null;
            if (a0Var != null) {
                a0Var.a(view);
            }
        }

        @Override // a.b.g.k.a0
        public void b(View view) {
            int i2 = this.f1183a.f1178d;
            if (i2 > -1) {
                view.setLayerType(i2, null);
                this.f1183a.f1178d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f1184b) {
                z zVar = this.f1183a;
                Runnable runnable = zVar.f1177c;
                if (runnable != null) {
                    zVar.f1177c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                a0 a0Var = tag instanceof a0 ? (a0) tag : null;
                if (a0Var != null) {
                    a0Var.b(view);
                }
                this.f1184b = true;
            }
        }

        @Override // a.b.g.k.a0
        public void c(View view) {
            this.f1184b = false;
            if (this.f1183a.f1178d > -1) {
                view.setLayerType(2, null);
            }
            z zVar = this.f1183a;
            Runnable runnable = zVar.f1176b;
            if (runnable != null) {
                zVar.f1176b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            a0 a0Var = tag instanceof a0 ? (a0) tag : null;
            if (a0Var != null) {
                a0Var.c(view);
            }
        }
    }

    public z(View view) {
        this.f1175a = new WeakReference<>(view);
    }

    public z a(long j) {
        View view = this.f1175a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public z b(float f2) {
        View view = this.f1175a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public void c() {
        View view = this.f1175a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public z a(float f2) {
        View view = this.f1175a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public long b() {
        View view = this.f1175a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public z a(Interpolator interpolator) {
        View view = this.f1175a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public z b(long j) {
        View view = this.f1175a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void a() {
        View view = this.f1175a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public z a(a0 a0Var) {
        View view = this.f1175a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, a0Var);
            } else {
                view.setTag(2113929216, a0Var);
                a(view, new c(this));
            }
        }
        return this;
    }

    public final void a(View view, a0 a0Var) {
        if (a0Var != null) {
            view.animate().setListener(new a(this, a0Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public z a(c0 c0Var) {
        View view = this.f1175a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(c0Var != null ? new b(this, c0Var, view) : null);
        }
        return this;
    }
}
