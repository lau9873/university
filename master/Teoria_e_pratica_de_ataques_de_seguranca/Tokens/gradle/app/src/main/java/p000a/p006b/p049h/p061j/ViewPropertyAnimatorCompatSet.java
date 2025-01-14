package p000a.p006b.p049h.p061j;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorCompat;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener;
import p000a.p006b.p030g.p045k.ViewPropertyAnimatorListenerAdapter;

/* renamed from: a.b.h.j.h */
/* loaded from: classes.dex */
public class ViewPropertyAnimatorCompatSet {

    /* renamed from: c */
    public Interpolator f2289c;

    /* renamed from: d */
    public ViewPropertyAnimatorListener f2290d;

    /* renamed from: e */
    public boolean f2291e;

    /* renamed from: b */
    public long f2288b = -1;

    /* renamed from: f */
    public final ViewPropertyAnimatorListenerAdapter f2292f = new C0418a();

    /* renamed from: a */
    public final ArrayList<ViewPropertyAnimatorCompat> f2287a = new ArrayList<>();

    /* compiled from: ViewPropertyAnimatorCompatSet.java */
    /* renamed from: a.b.h.j.h$a */
    /* loaded from: classes.dex */
    public class C0418a extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f2293a = false;

        /* renamed from: b */
        public int f2294b = 0;

        public C0418a() {
        }

        /* renamed from: a */
        public void m8727a() {
            this.f2294b = 0;
            this.f2293a = false;
            ViewPropertyAnimatorCompatSet.this.m8729b();
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: b */
        public void mo8184b(View view) {
            int i = this.f2294b + 1;
            this.f2294b = i;
            if (i == ViewPropertyAnimatorCompatSet.this.f2287a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f2290d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.mo8184b(null);
                }
                m8727a();
            }
        }

        @Override // p000a.p006b.p030g.p045k.ViewPropertyAnimatorListenerAdapter, p000a.p006b.p030g.p045k.ViewPropertyAnimatorListener
        /* renamed from: c */
        public void mo8183c(View view) {
            if (this.f2293a) {
                return;
            }
            this.f2293a = true;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.f2290d;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.mo8183c(null);
            }
        }
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompatSet m8732a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f2291e) {
            this.f2287a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    /* renamed from: b */
    public void m8729b() {
        this.f2291e = false;
    }

    /* renamed from: c */
    public void m8728c() {
        if (this.f2291e) {
            return;
        }
        Iterator<ViewPropertyAnimatorCompat> it = this.f2287a.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat next = it.next();
            long j = this.f2288b;
            if (j >= 0) {
                next.m9335a(j);
            }
            Interpolator interpolator = this.f2289c;
            if (interpolator != null) {
                next.m9331a(interpolator);
            }
            if (this.f2290d != null) {
                next.m9334a(this.f2292f);
            }
            next.m9327c();
        }
        this.f2291e = true;
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompatSet m8731a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f2287a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.m9328b(viewPropertyAnimatorCompat.m9330b());
        this.f2287a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    /* renamed from: a */
    public void m8735a() {
        if (this.f2291e) {
            Iterator<ViewPropertyAnimatorCompat> it = this.f2287a.iterator();
            while (it.hasNext()) {
                it.next().m9337a();
            }
            this.f2291e = false;
        }
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompatSet m8734a(long j) {
        if (!this.f2291e) {
            this.f2288b = j;
        }
        return this;
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompatSet m8730a(Interpolator interpolator) {
        if (!this.f2291e) {
            this.f2289c = interpolator;
        }
        return this;
    }

    /* renamed from: a */
    public ViewPropertyAnimatorCompatSet m8733a(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f2291e) {
            this.f2290d = viewPropertyAnimatorListener;
        }
        return this;
    }
}
