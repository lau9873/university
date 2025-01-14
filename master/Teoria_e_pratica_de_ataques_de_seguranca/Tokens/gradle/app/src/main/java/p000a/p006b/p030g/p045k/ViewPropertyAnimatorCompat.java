package p000a.p006b.p030g.p045k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* renamed from: a.b.g.k.z */
/* loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {

    /* renamed from: a */
    public WeakReference<View> f1735a;

    /* renamed from: b */
    public Runnable f1736b = null;

    /* renamed from: c */
    public Runnable f1737c = null;

    /* renamed from: d */
    public int f1738d = -1;

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: a.b.g.k.z$a */
    /* loaded from: classes.dex */
    public class C0305a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ ViewPropertyAnimatorListener f1739a;

        /* renamed from: b */
        public final /* synthetic */ View f1740b;

        public C0305a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
            this.f1739a = viewPropertyAnimatorListener;
            this.f1740b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1739a.mo8185a(this.f1740b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1739a.mo8184b(this.f1740b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f1739a.mo8183c(this.f1740b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: a.b.g.k.z$b */
    /* loaded from: classes.dex */
    public class C0306b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ ViewPropertyAnimatorUpdateListener f1741a;

        /* renamed from: b */
        public final /* synthetic */ View f1742b;

        public C0306b(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
            this.f1741a = viewPropertyAnimatorUpdateListener;
            this.f1742b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f1741a.mo8973a(this.f1742b);
        }
    }

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* renamed from: a.b.g.k.z$c */
    /* loaded from: classes.dex */
    public static class C0307c implements ViewPropertyAnimatorListener {

        /* renamed from: a */
        public ViewPropertyAnimatorCompat f1743a;

        /* renamed from: b */
        public boolean f1744b;

        public C0307c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.f1743a = viewPropertyAnimatorCompat;
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: a */
        public void mo8185a(View view) {
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.mo8185a(view);
            }
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: b */
        public void mo8184b(View view) {
            int i = this.f1743a.f1738d;
            if (i > -1) {
                view.setLayerType(i, null);
                this.f1743a.f1738d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f1744b) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1743a;
                Runnable runnable = viewPropertyAnimatorCompat.f1737c;
                if (runnable != null) {
                    viewPropertyAnimatorCompat.f1737c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.mo8184b(view);
                }
                this.f1744b = true;
            }
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: c */
        public void mo8183c(View view) {
            this.f1744b = false;
            if (this.f1743a.f1738d > -1) {
                view.setLayerType(2, null);
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1743a;
            Runnable runnable = viewPropertyAnimatorCompat.f1736b;
            if (runnable != null) {
                viewPropertyAnimatorCompat.f1736b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.mo8183c(view);
            }
        }
    }

    public ViewPropertyAnimatorCompat(View view) {
        this.f1735a = new WeakReference<>(view);
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompat m9335a(long j) {
        View view = this.f1735a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* renamed from: b */
    public ViewPropertyAnimatorCompat m9329b(float f) {
        View view = this.f1735a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    /* renamed from: c */
    public void m9327c() {
        View view = this.f1735a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompat m9336a(float f) {
        View view = this.f1735a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    /* renamed from: b */
    public long m9330b() {
        View view = this.f1735a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompat m9331a(Interpolator interpolator) {
        View view = this.f1735a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* renamed from: b */
    public ViewPropertyAnimatorCompat m9328b(long j) {
        View view = this.f1735a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    /* renamed from: a */
    public void m9337a() {
        View view = this.f1735a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompat m9334a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.f1735a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                m9332a(view, viewPropertyAnimatorListener);
            } else {
                view.setTag(2113929216, viewPropertyAnimatorListener);
                m9332a(view, new C0307c(this));
            }
        }
        return this;
    }

    /* renamed from: a */
    public final void m9332a(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new C0305a(this, viewPropertyAnimatorListener, view));
        } else {
            view.animate().setListener(null);
        }
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompat m9333a(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view = this.f1735a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new C0306b(this, viewPropertyAnimatorUpdateListener, view) : null);
        }
        return this;
    }
}
