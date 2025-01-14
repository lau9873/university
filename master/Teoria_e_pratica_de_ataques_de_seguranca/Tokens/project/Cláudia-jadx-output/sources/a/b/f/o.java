package a.b.f;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static m f574a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static ThreadLocal<WeakReference<a.b.g.j.a<ViewGroup, ArrayList<m>>>> f575b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<ViewGroup> f576c = new ArrayList<>();

    /* compiled from: TransitionManager.java */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public m f577a;

        /* renamed from: b  reason: collision with root package name */
        public ViewGroup f578b;

        /* compiled from: TransitionManager.java */
        /* renamed from: a.b.f.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0013a extends n {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.b.g.j.a f579a;

            public C0013a(a.b.g.j.a aVar) {
                this.f579a = aVar;
            }

            @Override // a.b.f.m.f
            public void b(m mVar) {
                ((ArrayList) this.f579a.get(a.this.f578b)).remove(mVar);
            }
        }

        public a(m mVar, ViewGroup viewGroup) {
            this.f577a = mVar;
            this.f578b = viewGroup;
        }

        public final void a() {
            this.f578b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f578b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (o.f576c.remove(this.f578b)) {
                a.b.g.j.a<ViewGroup, ArrayList<m>> a2 = o.a();
                ArrayList<m> arrayList = a2.get(this.f578b);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    a2.put(this.f578b, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.f577a);
                this.f577a.a(new C0013a(a2));
                this.f577a.a(this.f578b, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((m) it.next()).e(this.f578b);
                    }
                }
                this.f577a.a(this.f578b);
                return true;
            }
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o.f576c.remove(this.f578b);
            ArrayList<m> arrayList = o.a().get(this.f578b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().e(this.f578b);
                }
            }
            this.f577a.a(true);
        }
    }

    public static a.b.g.j.a<ViewGroup, ArrayList<m>> a() {
        a.b.g.j.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<a.b.g.j.a<ViewGroup, ArrayList<m>>> weakReference = f575b.get();
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            a.b.g.j.a<ViewGroup, ArrayList<m>> aVar2 = new a.b.g.j.a<>();
            f575b.set(new WeakReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    public static void b(ViewGroup viewGroup, m mVar) {
        if (mVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(mVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void c(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().c(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.a(viewGroup, true);
        }
        l a2 = l.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (f576c.contains(viewGroup) || !a.b.g.k.u.x(viewGroup)) {
            return;
        }
        f576c.add(viewGroup);
        if (mVar == null) {
            mVar = f574a;
        }
        m m4clone = mVar.m4clone();
        c(viewGroup, m4clone);
        l.a(viewGroup, null);
        b(viewGroup, m4clone);
    }
}
