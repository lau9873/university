package a.b.h.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public class j0 extends e1 {
    public static TimeInterpolator s;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<RecyclerView.d0> f1751h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<RecyclerView.d0> f1752i = new ArrayList<>();
    public ArrayList<j> j = new ArrayList<>();
    public ArrayList<i> k = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.d0>> l = new ArrayList<>();
    public ArrayList<ArrayList<j>> m = new ArrayList<>();
    public ArrayList<ArrayList<i>> n = new ArrayList<>();
    public ArrayList<RecyclerView.d0> o = new ArrayList<>();
    public ArrayList<RecyclerView.d0> p = new ArrayList<>();
    public ArrayList<RecyclerView.d0> q = new ArrayList<>();
    public ArrayList<RecyclerView.d0> r = new ArrayList<>();

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1753a;

        public a(ArrayList arrayList) {
            this.f1753a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1753a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                j0.this.b(jVar.f1787a, jVar.f1788b, jVar.f1789c, jVar.f1790d, jVar.f1791e);
            }
            this.f1753a.clear();
            j0.this.m.remove(this.f1753a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1755a;

        public b(ArrayList arrayList) {
            this.f1755a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1755a.iterator();
            while (it.hasNext()) {
                j0.this.a((i) it.next());
            }
            this.f1755a.clear();
            j0.this.n.remove(this.f1755a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1757a;

        public c(ArrayList arrayList) {
            this.f1757a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1757a.iterator();
            while (it.hasNext()) {
                j0.this.v((RecyclerView.d0) it.next());
            }
            this.f1757a.clear();
            j0.this.l.remove(this.f1757a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f1759a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1760b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f1761c;

        public d(RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1759a = d0Var;
            this.f1760b = viewPropertyAnimator;
            this.f1761c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1760b.setListener(null);
            this.f1761c.setAlpha(1.0f);
            j0.this.n(this.f1759a);
            j0.this.q.remove(this.f1759a);
            j0.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j0.this.o(this.f1759a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f1763a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f1764b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1765c;

        public e(RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1763a = d0Var;
            this.f1764b = view;
            this.f1765c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1764b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1765c.setListener(null);
            j0.this.j(this.f1763a);
            j0.this.o.remove(this.f1763a);
            j0.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j0.this.k(this.f1763a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f1767a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f1768b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f1769c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f1770d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1771e;

        public f(RecyclerView.d0 d0Var, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1767a = d0Var;
            this.f1768b = i2;
            this.f1769c = view;
            this.f1770d = i3;
            this.f1771e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f1768b != 0) {
                this.f1769c.setTranslationX(0.0f);
            }
            if (this.f1770d != 0) {
                this.f1769c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1771e.setListener(null);
            j0.this.l(this.f1767a);
            j0.this.p.remove(this.f1767a);
            j0.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j0.this.m(this.f1767a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f1773a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1774b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f1775c;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1773a = iVar;
            this.f1774b = viewPropertyAnimator;
            this.f1775c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1774b.setListener(null);
            this.f1775c.setAlpha(1.0f);
            this.f1775c.setTranslationX(0.0f);
            this.f1775c.setTranslationY(0.0f);
            j0.this.a(this.f1773a.f1781a, true);
            j0.this.r.remove(this.f1773a.f1781a);
            j0.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j0.this.b(this.f1773a.f1781a, true);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f1777a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1778b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f1779c;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1777a = iVar;
            this.f1778b = viewPropertyAnimator;
            this.f1779c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1778b.setListener(null);
            this.f1779c.setAlpha(1.0f);
            this.f1779c.setTranslationX(0.0f);
            this.f1779c.setTranslationY(0.0f);
            j0.this.a(this.f1777a.f1782b, false);
            j0.this.r.remove(this.f1777a.f1782b);
            j0.this.j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            j0.this.b(this.f1777a.f1782b, false);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.d0 f1787a;

        /* renamed from: b  reason: collision with root package name */
        public int f1788b;

        /* renamed from: c  reason: collision with root package name */
        public int f1789c;

        /* renamed from: d  reason: collision with root package name */
        public int f1790d;

        /* renamed from: e  reason: collision with root package name */
        public int f1791e;

        public j(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5) {
            this.f1787a = d0Var;
            this.f1788b = i2;
            this.f1789c = i3;
            this.f1790d = i4;
            this.f1791e = i5;
        }
    }

    @Override // a.b.h.k.e1
    public boolean a(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5) {
        View view = d0Var.f2580a;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) d0Var.f2580a.getTranslationY());
        x(d0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            l(d0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.j.add(new j(d0Var, translationX, translationY, i4, i5));
        return true;
    }

    public void b(RecyclerView.d0 d0Var, int i2, int i3, int i4, int i5) {
        View view = d0Var.f2580a;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.p.add(d0Var);
        animate.setDuration(e()).setListener(new f(d0Var, i6, view, i7, animate)).start();
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public void d(RecyclerView.d0 d0Var) {
        View view = d0Var.f2580a;
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.j.get(size).f1787a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                l(d0Var);
                this.j.remove(size);
            }
        }
        a(this.k, d0Var);
        if (this.f1751h.remove(d0Var)) {
            view.setAlpha(1.0f);
            n(d0Var);
        }
        if (this.f1752i.remove(d0Var)) {
            view.setAlpha(1.0f);
            j(d0Var);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.n.get(size2);
            a(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        for (int size3 = this.m.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f1787a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    l(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.d0> arrayList3 = this.l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                j(d0Var);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        this.q.remove(d0Var);
        this.o.remove(d0Var);
        this.r.remove(d0Var);
        this.p.remove(d0Var);
        j();
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public boolean g() {
        return (this.f1752i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.f1751h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    @Override // a.b.h.k.e1
    public boolean h(RecyclerView.d0 d0Var) {
        x(d0Var);
        d0Var.f2580a.setAlpha(0.0f);
        this.f1752i.add(d0Var);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public void i() {
        boolean z = !this.f1751h.isEmpty();
        boolean z2 = !this.j.isEmpty();
        boolean z3 = !this.k.isEmpty();
        boolean z4 = !this.f1752i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.d0> it = this.f1751h.iterator();
            while (it.hasNext()) {
                w(it.next());
            }
            this.f1751h.clear();
            if (z2) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.j);
                this.m.add(arrayList);
                this.j.clear();
                a aVar = new a(arrayList);
                if (z) {
                    a.b.g.k.u.a(arrayList.get(0).f1787a.f2580a, aVar, f());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.k);
                this.n.add(arrayList2);
                this.k.clear();
                b bVar = new b(arrayList2);
                if (z) {
                    a.b.g.k.u.a(arrayList2.get(0).f1781a.f2580a, bVar, f());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.d0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f1752i);
                this.l.add(arrayList3);
                this.f1752i.clear();
                c cVar = new c(arrayList3);
                if (!z && !z2 && !z3) {
                    cVar.run();
                } else {
                    a.b.g.k.u.a(arrayList3.get(0).f2580a, cVar, (z ? f() : 0L) + Math.max(z2 ? e() : 0L, z3 ? d() : 0L));
                }
            }
        }
    }

    public void j() {
        if (g()) {
            return;
        }
        a();
    }

    public void v(RecyclerView.d0 d0Var) {
        View view = d0Var.f2580a;
        ViewPropertyAnimator animate = view.animate();
        this.o.add(d0Var);
        animate.alpha(1.0f).setDuration(c()).setListener(new e(d0Var, view, animate)).start();
    }

    public final void w(RecyclerView.d0 d0Var) {
        View view = d0Var.f2580a;
        ViewPropertyAnimator animate = view.animate();
        this.q.add(d0Var);
        animate.setDuration(f()).alpha(0.0f).setListener(new d(d0Var, animate, view)).start();
    }

    public final void x(RecyclerView.d0 d0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        d0Var.f2580a.animate().setInterpolator(s);
        d(d0Var);
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.d0 f1781a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.d0 f1782b;

        /* renamed from: c  reason: collision with root package name */
        public int f1783c;

        /* renamed from: d  reason: collision with root package name */
        public int f1784d;

        /* renamed from: e  reason: collision with root package name */
        public int f1785e;

        /* renamed from: f  reason: collision with root package name */
        public int f1786f;

        public i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            this.f1781a = d0Var;
            this.f1782b = d0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1781a + ", newHolder=" + this.f1782b + ", fromX=" + this.f1783c + ", fromY=" + this.f1784d + ", toX=" + this.f1785e + ", toY=" + this.f1786f + '}';
        }

        public i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i2, int i3, int i4, int i5) {
            this(d0Var, d0Var2);
            this.f1783c = i2;
            this.f1784d = i3;
            this.f1785e = i4;
            this.f1786f = i5;
        }
    }

    public final void b(i iVar) {
        RecyclerView.d0 d0Var = iVar.f1781a;
        if (d0Var != null) {
            a(iVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = iVar.f1782b;
        if (d0Var2 != null) {
            a(iVar, d0Var2);
        }
    }

    @Override // a.b.h.k.e1
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i2, int i3, int i4, int i5) {
        if (d0Var == d0Var2) {
            return a(d0Var, i2, i3, i4, i5);
        }
        float translationX = d0Var.f2580a.getTranslationX();
        float translationY = d0Var.f2580a.getTranslationY();
        float alpha = d0Var.f2580a.getAlpha();
        x(d0Var);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        d0Var.f2580a.setTranslationX(translationX);
        d0Var.f2580a.setTranslationY(translationY);
        d0Var.f2580a.setAlpha(alpha);
        if (d0Var2 != null) {
            x(d0Var2);
            d0Var2.f2580a.setTranslationX(-i6);
            d0Var2.f2580a.setTranslationY(-i7);
            d0Var2.f2580a.setAlpha(0.0f);
        }
        this.k.add(new i(d0Var, d0Var2, i2, i3, i4, i5));
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public void b() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.j.get(size);
            View view = jVar.f1787a.f2580a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            l(jVar.f1787a);
            this.j.remove(size);
        }
        for (int size2 = this.f1751h.size() - 1; size2 >= 0; size2--) {
            n(this.f1751h.get(size2));
            this.f1751h.remove(size2);
        }
        int size3 = this.f1752i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = this.f1752i.get(size3);
            d0Var.f2580a.setAlpha(1.0f);
            j(d0Var);
            this.f1752i.remove(size3);
        }
        for (int size4 = this.k.size() - 1; size4 >= 0; size4--) {
            b(this.k.get(size4));
        }
        this.k.clear();
        if (g()) {
            for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f1787a.f2580a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    l(jVar2.f1787a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.l.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.d0> arrayList2 = this.l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = arrayList2.get(size8);
                    d0Var2.f2580a.setAlpha(1.0f);
                    j(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.n.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.n.remove(arrayList3);
                    }
                }
            }
            a(this.q);
            a(this.p);
            a(this.o);
            a(this.r);
            a();
        }
    }

    public void a(i iVar) {
        RecyclerView.d0 d0Var = iVar.f1781a;
        View view = d0Var == null ? null : d0Var.f2580a;
        RecyclerView.d0 d0Var2 = iVar.f1782b;
        View view2 = d0Var2 != null ? d0Var2.f2580a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(d());
            this.r.add(iVar.f1781a);
            duration.translationX(iVar.f1785e - iVar.f1783c);
            duration.translationY(iVar.f1786f - iVar.f1784d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.r.add(iVar.f1782b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(d()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    @Override // a.b.h.k.e1
    public boolean i(RecyclerView.d0 d0Var) {
        x(d0Var);
        this.f1751h.add(d0Var);
        return true;
    }

    public final void a(List<i> list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (a(iVar, d0Var) && iVar.f1781a == null && iVar.f1782b == null) {
                list.remove(iVar);
            }
        }
    }

    public final boolean a(i iVar, RecyclerView.d0 d0Var) {
        boolean z = false;
        if (iVar.f1782b == d0Var) {
            iVar.f1782b = null;
        } else if (iVar.f1781a != d0Var) {
            return false;
        } else {
            iVar.f1781a = null;
            z = true;
        }
        d0Var.f2580a.setAlpha(1.0f);
        d0Var.f2580a.setTranslationX(0.0f);
        d0Var.f2580a.setTranslationY(0.0f);
        a(d0Var, z);
        return true;
    }

    public void a(List<RecyclerView.d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f2580a.animate().cancel();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, List<Object> list) {
        return !list.isEmpty() || super.a(d0Var, list);
    }
}
