package p000a.p006b.p049h.p063k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.p067v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.h.k.j0 */
/* loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {

    /* renamed from: s */
    public static TimeInterpolator f2662s;

    /* renamed from: h */
    public ArrayList<RecyclerView.AbstractC0708d0> f2663h = new ArrayList<>();

    /* renamed from: i */
    public ArrayList<RecyclerView.AbstractC0708d0> f2664i = new ArrayList<>();

    /* renamed from: j */
    public ArrayList<C0469j> f2665j = new ArrayList<>();

    /* renamed from: k */
    public ArrayList<C0468i> f2666k = new ArrayList<>();

    /* renamed from: l */
    public ArrayList<ArrayList<RecyclerView.AbstractC0708d0>> f2667l = new ArrayList<>();

    /* renamed from: m */
    public ArrayList<ArrayList<C0469j>> f2668m = new ArrayList<>();

    /* renamed from: n */
    public ArrayList<ArrayList<C0468i>> f2669n = new ArrayList<>();

    /* renamed from: o */
    public ArrayList<RecyclerView.AbstractC0708d0> f2670o = new ArrayList<>();

    /* renamed from: p */
    public ArrayList<RecyclerView.AbstractC0708d0> f2671p = new ArrayList<>();

    /* renamed from: q */
    public ArrayList<RecyclerView.AbstractC0708d0> f2672q = new ArrayList<>();

    /* renamed from: r */
    public ArrayList<RecyclerView.AbstractC0708d0> f2673r = new ArrayList<>();

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: a.b.h.k.j0$a */
    /* loaded from: classes.dex */
    public class RunnableC0460a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f2674a;

        public RunnableC0460a(ArrayList arrayList) {
            this.f2674a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f2674a.iterator();
            while (it.hasNext()) {
                C0469j c0469j = (C0469j) it.next();
                DefaultItemAnimator.this.m8326b(c0469j.f2708a, c0469j.f2709b, c0469j.f2710c, c0469j.f2711d, c0469j.f2712e);
            }
            this.f2674a.clear();
            DefaultItemAnimator.this.f2668m.remove(this.f2674a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: a.b.h.k.j0$b */
    /* loaded from: classes.dex */
    public class RunnableC0461b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f2676a;

        public RunnableC0461b(ArrayList arrayList) {
            this.f2676a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f2676a.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.m8333a((C0468i) it.next());
            }
            this.f2676a.clear();
            DefaultItemAnimator.this.f2669n.remove(this.f2676a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: a.b.h.k.j0$c */
    /* loaded from: classes.dex */
    public class RunnableC0462c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f2678a;

        public RunnableC0462c(ArrayList arrayList) {
            this.f2678a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f2678a.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.m8322v((RecyclerView.AbstractC0708d0) it.next());
            }
            this.f2678a.clear();
            DefaultItemAnimator.this.f2667l.remove(this.f2678a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: a.b.h.k.j0$d */
    /* loaded from: classes.dex */
    public class C0463d extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ RecyclerView.AbstractC0708d0 f2680a;

        /* renamed from: b */
        public final /* synthetic */ ViewPropertyAnimator f2681b;

        /* renamed from: c */
        public final /* synthetic */ View f2682c;

        public C0463d(RecyclerView.AbstractC0708d0 abstractC0708d0, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2680a = abstractC0708d0;
            this.f2681b = viewPropertyAnimator;
            this.f2682c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2681b.setListener(null);
            this.f2682c.setAlpha(1.0f);
            DefaultItemAnimator.this.m8432n(this.f2680a);
            DefaultItemAnimator.this.f2672q.remove(this.f2680a);
            DefaultItemAnimator.this.m8323j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.m8431o(this.f2680a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: a.b.h.k.j0$e */
    /* loaded from: classes.dex */
    public class C0464e extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ RecyclerView.AbstractC0708d0 f2684a;

        /* renamed from: b */
        public final /* synthetic */ View f2685b;

        /* renamed from: c */
        public final /* synthetic */ ViewPropertyAnimator f2686c;

        public C0464e(RecyclerView.AbstractC0708d0 abstractC0708d0, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f2684a = abstractC0708d0;
            this.f2685b = view;
            this.f2686c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2685b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2686c.setListener(null);
            DefaultItemAnimator.this.m8436j(this.f2684a);
            DefaultItemAnimator.this.f2670o.remove(this.f2684a);
            DefaultItemAnimator.this.m8323j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.m8435k(this.f2684a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: a.b.h.k.j0$f */
    /* loaded from: classes.dex */
    public class C0465f extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ RecyclerView.AbstractC0708d0 f2688a;

        /* renamed from: b */
        public final /* synthetic */ int f2689b;

        /* renamed from: c */
        public final /* synthetic */ View f2690c;

        /* renamed from: d */
        public final /* synthetic */ int f2691d;

        /* renamed from: e */
        public final /* synthetic */ ViewPropertyAnimator f2692e;

        public C0465f(RecyclerView.AbstractC0708d0 abstractC0708d0, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.f2688a = abstractC0708d0;
            this.f2689b = i;
            this.f2690c = view;
            this.f2691d = i2;
            this.f2692e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f2689b != 0) {
                this.f2690c.setTranslationX(0.0f);
            }
            if (this.f2691d != 0) {
                this.f2690c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2692e.setListener(null);
            DefaultItemAnimator.this.m8434l(this.f2688a);
            DefaultItemAnimator.this.f2671p.remove(this.f2688a);
            DefaultItemAnimator.this.m8323j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.m8433m(this.f2688a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: a.b.h.k.j0$g */
    /* loaded from: classes.dex */
    public class C0466g extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ C0468i f2694a;

        /* renamed from: b */
        public final /* synthetic */ ViewPropertyAnimator f2695b;

        /* renamed from: c */
        public final /* synthetic */ View f2696c;

        public C0466g(C0468i c0468i, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2694a = c0468i;
            this.f2695b = viewPropertyAnimator;
            this.f2696c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2695b.setListener(null);
            this.f2696c.setAlpha(1.0f);
            this.f2696c.setTranslationX(0.0f);
            this.f2696c.setTranslationY(0.0f);
            DefaultItemAnimator.this.m8440a(this.f2694a.f2702a, true);
            DefaultItemAnimator.this.f2673r.remove(this.f2694a.f2702a);
            DefaultItemAnimator.this.m8323j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.m8439b(this.f2694a.f2702a, true);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: a.b.h.k.j0$h */
    /* loaded from: classes.dex */
    public class C0467h extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ C0468i f2698a;

        /* renamed from: b */
        public final /* synthetic */ ViewPropertyAnimator f2699b;

        /* renamed from: c */
        public final /* synthetic */ View f2700c;

        public C0467h(C0468i c0468i, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2698a = c0468i;
            this.f2699b = viewPropertyAnimator;
            this.f2700c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2699b.setListener(null);
            this.f2700c.setAlpha(1.0f);
            this.f2700c.setTranslationX(0.0f);
            this.f2700c.setTranslationY(0.0f);
            DefaultItemAnimator.this.m8440a(this.f2698a.f2703b, false);
            DefaultItemAnimator.this.f2673r.remove(this.f2698a.f2703b);
            DefaultItemAnimator.this.m8323j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.m8439b(this.f2698a.f2703b, false);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: a.b.h.k.j0$j */
    /* loaded from: classes.dex */
    public static class C0469j {

        /* renamed from: a */
        public RecyclerView.AbstractC0708d0 f2708a;

        /* renamed from: b */
        public int f2709b;

        /* renamed from: c */
        public int f2710c;

        /* renamed from: d */
        public int f2711d;

        /* renamed from: e */
        public int f2712e;

        public C0469j(RecyclerView.AbstractC0708d0 abstractC0708d0, int i, int i2, int i3, int i4) {
            this.f2708a = abstractC0708d0;
            this.f2709b = i;
            this.f2710c = i2;
            this.f2711d = i3;
            this.f2712e = i4;
        }
    }

    @Override // p000a.p006b.p049h.p063k.SimpleItemAnimator
    /* renamed from: a */
    public boolean mo8331a(RecyclerView.AbstractC0708d0 abstractC0708d0, int i, int i2, int i3, int i4) {
        View view = abstractC0708d0.f4213a;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) abstractC0708d0.f4213a.getTranslationY());
        m8320x(abstractC0708d0);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            m8434l(abstractC0708d0);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.f2665j.add(new C0469j(abstractC0708d0, translationX, translationY, i3, i4));
        return true;
    }

    /* renamed from: b */
    public void m8326b(RecyclerView.AbstractC0708d0 abstractC0708d0, int i, int i2, int i3, int i4) {
        View view = abstractC0708d0.f4213a;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f2671p.add(abstractC0708d0);
        animate.setDuration(m6725e()).setListener(new C0465f(abstractC0708d0, i5, view, i6, animate)).start();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
    /* renamed from: d */
    public void mo1047d(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        View view = abstractC0708d0.f4213a;
        view.animate().cancel();
        int size = this.f2665j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f2665j.get(size).f2708a == abstractC0708d0) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                m8434l(abstractC0708d0);
                this.f2665j.remove(size);
            }
        }
        m8328a(this.f2666k, abstractC0708d0);
        if (this.f2663h.remove(abstractC0708d0)) {
            view.setAlpha(1.0f);
            m8432n(abstractC0708d0);
        }
        if (this.f2664i.remove(abstractC0708d0)) {
            view.setAlpha(1.0f);
            m8436j(abstractC0708d0);
        }
        for (int size2 = this.f2669n.size() - 1; size2 >= 0; size2--) {
            ArrayList<C0468i> arrayList = this.f2669n.get(size2);
            m8328a(arrayList, abstractC0708d0);
            if (arrayList.isEmpty()) {
                this.f2669n.remove(size2);
            }
        }
        for (int size3 = this.f2668m.size() - 1; size3 >= 0; size3--) {
            ArrayList<C0469j> arrayList2 = this.f2668m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f2708a == abstractC0708d0) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    m8434l(abstractC0708d0);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f2668m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f2667l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.AbstractC0708d0> arrayList3 = this.f2667l.get(size5);
            if (arrayList3.remove(abstractC0708d0)) {
                view.setAlpha(1.0f);
                m8436j(abstractC0708d0);
                if (arrayList3.isEmpty()) {
                    this.f2667l.remove(size5);
                }
            }
        }
        this.f2672q.remove(abstractC0708d0);
        this.f2670o.remove(abstractC0708d0);
        this.f2673r.remove(abstractC0708d0);
        this.f2671p.remove(abstractC0708d0);
        m8323j();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
    /* renamed from: g */
    public boolean mo1046g() {
        return (this.f2664i.isEmpty() && this.f2666k.isEmpty() && this.f2665j.isEmpty() && this.f2663h.isEmpty() && this.f2671p.isEmpty() && this.f2672q.isEmpty() && this.f2670o.isEmpty() && this.f2673r.isEmpty() && this.f2668m.isEmpty() && this.f2667l.isEmpty() && this.f2669n.isEmpty()) ? false : true;
    }

    @Override // p000a.p006b.p049h.p063k.SimpleItemAnimator
    /* renamed from: h */
    public boolean mo8325h(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        m8320x(abstractC0708d0);
        abstractC0708d0.f4213a.setAlpha(0.0f);
        this.f2664i.add(abstractC0708d0);
        return true;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
    /* renamed from: i */
    public void mo1044i() {
        boolean z = !this.f2663h.isEmpty();
        boolean z2 = !this.f2665j.isEmpty();
        boolean z3 = !this.f2666k.isEmpty();
        boolean z4 = !this.f2664i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.AbstractC0708d0> it = this.f2663h.iterator();
            while (it.hasNext()) {
                m8321w(it.next());
            }
            this.f2663h.clear();
            if (z2) {
                ArrayList<C0469j> arrayList = new ArrayList<>();
                arrayList.addAll(this.f2665j);
                this.f2668m.add(arrayList);
                this.f2665j.clear();
                RunnableC0460a runnableC0460a = new RunnableC0460a(arrayList);
                if (z) {
                    ViewCompat.m9444a(arrayList.get(0).f2708a.f4213a, runnableC0460a, m6723f());
                } else {
                    runnableC0460a.run();
                }
            }
            if (z3) {
                ArrayList<C0468i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f2666k);
                this.f2669n.add(arrayList2);
                this.f2666k.clear();
                RunnableC0461b runnableC0461b = new RunnableC0461b(arrayList2);
                if (z) {
                    ViewCompat.m9444a(arrayList2.get(0).f2702a.f4213a, runnableC0461b, m6723f());
                } else {
                    runnableC0461b.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.AbstractC0708d0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f2664i);
                this.f2667l.add(arrayList3);
                this.f2664i.clear();
                RunnableC0462c runnableC0462c = new RunnableC0462c(arrayList3);
                if (!z && !z2 && !z3) {
                    runnableC0462c.run();
                } else {
                    ViewCompat.m9444a(arrayList3.get(0).f4213a, runnableC0462c, (z ? m6723f() : 0L) + Math.max(z2 ? m6725e() : 0L, z3 ? m6726d() : 0L));
                }
            }
        }
    }

    /* renamed from: j */
    public void m8323j() {
        if (mo1046g()) {
            return;
        }
        m6735a();
    }

    /* renamed from: v */
    public void m8322v(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        View view = abstractC0708d0.f4213a;
        ViewPropertyAnimator animate = view.animate();
        this.f2670o.add(abstractC0708d0);
        animate.alpha(1.0f).setDuration(m6728c()).setListener(new C0464e(abstractC0708d0, view, animate)).start();
    }

    /* renamed from: w */
    public final void m8321w(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        View view = abstractC0708d0.f4213a;
        ViewPropertyAnimator animate = view.animate();
        this.f2672q.add(abstractC0708d0);
        animate.setDuration(m6723f()).alpha(0.0f).setListener(new C0463d(abstractC0708d0, animate, view)).start();
    }

    /* renamed from: x */
    public final void m8320x(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        if (f2662s == null) {
            f2662s = new ValueAnimator().getInterpolator();
        }
        abstractC0708d0.f4213a.animate().setInterpolator(f2662s);
        mo1047d(abstractC0708d0);
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: a.b.h.k.j0$i */
    /* loaded from: classes.dex */
    public static class C0468i {

        /* renamed from: a */
        public RecyclerView.AbstractC0708d0 f2702a;

        /* renamed from: b */
        public RecyclerView.AbstractC0708d0 f2703b;

        /* renamed from: c */
        public int f2704c;

        /* renamed from: d */
        public int f2705d;

        /* renamed from: e */
        public int f2706e;

        /* renamed from: f */
        public int f2707f;

        public C0468i(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0708d0 abstractC0708d02) {
            this.f2702a = abstractC0708d0;
            this.f2703b = abstractC0708d02;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2702a + ", newHolder=" + this.f2703b + ", fromX=" + this.f2704c + ", fromY=" + this.f2705d + ", toX=" + this.f2706e + ", toY=" + this.f2707f + '}';
        }

        public C0468i(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0708d0 abstractC0708d02, int i, int i2, int i3, int i4) {
            this(abstractC0708d0, abstractC0708d02);
            this.f2704c = i;
            this.f2705d = i2;
            this.f2706e = i3;
            this.f2707f = i4;
        }
    }

    /* renamed from: b */
    public final void m8327b(C0468i c0468i) {
        RecyclerView.AbstractC0708d0 abstractC0708d0 = c0468i.f2702a;
        if (abstractC0708d0 != null) {
            m8332a(c0468i, abstractC0708d0);
        }
        RecyclerView.AbstractC0708d0 abstractC0708d02 = c0468i.f2703b;
        if (abstractC0708d02 != null) {
            m8332a(c0468i, abstractC0708d02);
        }
    }

    @Override // p000a.p006b.p049h.p063k.SimpleItemAnimator
    /* renamed from: a */
    public boolean mo8330a(RecyclerView.AbstractC0708d0 abstractC0708d0, RecyclerView.AbstractC0708d0 abstractC0708d02, int i, int i2, int i3, int i4) {
        if (abstractC0708d0 == abstractC0708d02) {
            return mo8331a(abstractC0708d0, i, i2, i3, i4);
        }
        float translationX = abstractC0708d0.f4213a.getTranslationX();
        float translationY = abstractC0708d0.f4213a.getTranslationY();
        float alpha = abstractC0708d0.f4213a.getAlpha();
        m8320x(abstractC0708d0);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        abstractC0708d0.f4213a.setTranslationX(translationX);
        abstractC0708d0.f4213a.setTranslationY(translationY);
        abstractC0708d0.f4213a.setAlpha(alpha);
        if (abstractC0708d02 != null) {
            m8320x(abstractC0708d02);
            abstractC0708d02.f4213a.setTranslationX(-i5);
            abstractC0708d02.f4213a.setTranslationY(-i6);
            abstractC0708d02.f4213a.setAlpha(0.0f);
        }
        this.f2666k.add(new C0468i(abstractC0708d0, abstractC0708d02, i, i2, i3, i4));
        return true;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
    /* renamed from: b */
    public void mo1050b() {
        int size = this.f2665j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C0469j c0469j = this.f2665j.get(size);
            View view = c0469j.f2708a.f4213a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            m8434l(c0469j.f2708a);
            this.f2665j.remove(size);
        }
        for (int size2 = this.f2663h.size() - 1; size2 >= 0; size2--) {
            m8432n(this.f2663h.get(size2));
            this.f2663h.remove(size2);
        }
        int size3 = this.f2664i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.AbstractC0708d0 abstractC0708d0 = this.f2664i.get(size3);
            abstractC0708d0.f4213a.setAlpha(1.0f);
            m8436j(abstractC0708d0);
            this.f2664i.remove(size3);
        }
        for (int size4 = this.f2666k.size() - 1; size4 >= 0; size4--) {
            m8327b(this.f2666k.get(size4));
        }
        this.f2666k.clear();
        if (mo1046g()) {
            for (int size5 = this.f2668m.size() - 1; size5 >= 0; size5--) {
                ArrayList<C0469j> arrayList = this.f2668m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    C0469j c0469j2 = arrayList.get(size6);
                    View view2 = c0469j2.f2708a.f4213a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    m8434l(c0469j2.f2708a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f2668m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f2667l.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.AbstractC0708d0> arrayList2 = this.f2667l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.AbstractC0708d0 abstractC0708d02 = arrayList2.get(size8);
                    abstractC0708d02.f4213a.setAlpha(1.0f);
                    m8436j(abstractC0708d02);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f2667l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f2669n.size() - 1; size9 >= 0; size9--) {
                ArrayList<C0468i> arrayList3 = this.f2669n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m8327b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f2669n.remove(arrayList3);
                    }
                }
            }
            m8329a(this.f2672q);
            m8329a(this.f2671p);
            m8329a(this.f2670o);
            m8329a(this.f2673r);
            m6735a();
        }
    }

    /* renamed from: a */
    public void m8333a(C0468i c0468i) {
        RecyclerView.AbstractC0708d0 abstractC0708d0 = c0468i.f2702a;
        View view = abstractC0708d0 == null ? null : abstractC0708d0.f4213a;
        RecyclerView.AbstractC0708d0 abstractC0708d02 = c0468i.f2703b;
        View view2 = abstractC0708d02 != null ? abstractC0708d02.f4213a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m6726d());
            this.f2673r.add(c0468i.f2702a);
            duration.translationX(c0468i.f2706e - c0468i.f2704c);
            duration.translationY(c0468i.f2707f - c0468i.f2705d);
            duration.alpha(0.0f).setListener(new C0466g(c0468i, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f2673r.add(c0468i.f2703b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m6726d()).alpha(1.0f).setListener(new C0467h(c0468i, animate, view2)).start();
        }
    }

    @Override // p000a.p006b.p049h.p063k.SimpleItemAnimator
    /* renamed from: i */
    public boolean mo8324i(RecyclerView.AbstractC0708d0 abstractC0708d0) {
        m8320x(abstractC0708d0);
        this.f2663h.add(abstractC0708d0);
        return true;
    }

    /* renamed from: a */
    public final void m8328a(List<C0468i> list, RecyclerView.AbstractC0708d0 abstractC0708d0) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0468i c0468i = list.get(size);
            if (m8332a(c0468i, abstractC0708d0) && c0468i.f2702a == null && c0468i.f2703b == null) {
                list.remove(c0468i);
            }
        }
    }

    /* renamed from: a */
    public final boolean m8332a(C0468i c0468i, RecyclerView.AbstractC0708d0 abstractC0708d0) {
        boolean z = false;
        if (c0468i.f2703b == abstractC0708d0) {
            c0468i.f2703b = null;
        } else if (c0468i.f2702a != abstractC0708d0) {
            return false;
        } else {
            c0468i.f2702a = null;
            z = true;
        }
        abstractC0708d0.f4213a.setAlpha(1.0f);
        abstractC0708d0.f4213a.setTranslationX(0.0f);
        abstractC0708d0.f4213a.setTranslationY(0.0f);
        m8440a(abstractC0708d0, z);
        return true;
    }

    /* renamed from: a */
    public void m8329a(List<RecyclerView.AbstractC0708d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f4213a.animate().cancel();
        }
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0716l
    /* renamed from: a */
    public boolean mo6731a(RecyclerView.AbstractC0708d0 abstractC0708d0, List<Object> list) {
        return !list.isEmpty() || super.mo6731a(abstractC0708d0, list);
    }
}
