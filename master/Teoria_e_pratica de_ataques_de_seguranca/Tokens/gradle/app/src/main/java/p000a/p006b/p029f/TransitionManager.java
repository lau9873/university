package p000a.p006b.p029f;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p000a.p006b.p030g.p044j.ArrayMap;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.f.o */
/* loaded from: classes.dex */
public class TransitionManager {

    /* renamed from: a */
    public static Transition f982a = new AutoTransition();

    /* renamed from: b */
    public static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> f983b = new ThreadLocal<>();

    /* renamed from: c */
    public static ArrayList<ViewGroup> f984c = new ArrayList<>();

    /* compiled from: TransitionManager.java */
    /* renamed from: a.b.f.o$a */
    /* loaded from: classes.dex */
    public static class ViewTreeObserver$OnPreDrawListenerC0126a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a */
        public Transition f985a;

        /* renamed from: b */
        public ViewGroup f986b;

        /* compiled from: TransitionManager.java */
        /* renamed from: a.b.f.o$a$a */
        /* loaded from: classes.dex */
        public class C0127a extends TransitionListenerAdapter {

            /* renamed from: a */
            public final /* synthetic */ ArrayMap f987a;

            public C0127a(ArrayMap arrayMap) {
                this.f987a = arrayMap;
            }

            @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
            /* renamed from: b */
            public void mo10433b(Transition transition) {
                ((ArrayList) this.f987a.get(ViewTreeObserver$OnPreDrawListenerC0126a.this.f986b)).remove(transition);
            }
        }

        public ViewTreeObserver$OnPreDrawListenerC0126a(Transition transition, ViewGroup viewGroup) {
            this.f985a = transition;
            this.f986b = viewGroup;
        }

        /* renamed from: a */
        public final void m10460a() {
            this.f986b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f986b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            m10460a();
            if (TransitionManager.f984c.remove(this.f986b)) {
                ArrayMap<ViewGroup, ArrayList<Transition>> m10464a = TransitionManager.m10464a();
                ArrayList<Transition> arrayList = m10464a.get(this.f986b);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    m10464a.put(this.f986b, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.f985a);
                this.f985a.mo10452a(new C0127a(m10464a));
                this.f985a.m10487a(this.f986b, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).mo10437e(this.f986b);
                    }
                }
                this.f985a.m10489a(this.f986b);
                return true;
            }
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            m10460a();
            TransitionManager.f984c.remove(this.f986b);
            ArrayList<Transition> arrayList = TransitionManager.m10464a().get(this.f986b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().mo10437e(this.f986b);
                }
            }
            this.f985a.m10486a(true);
        }
    }

    /* renamed from: a */
    public static ArrayMap<ViewGroup, ArrayList<Transition>> m10464a() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = f983b.get();
        if (weakReference == null || (arrayMap = weakReference.get()) == null) {
            ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
            f983b.set(new WeakReference<>(arrayMap2));
            return arrayMap2;
        }
        return arrayMap;
    }

    /* renamed from: b */
    public static void m10462b(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        ViewTreeObserver$OnPreDrawListenerC0126a viewTreeObserver$OnPreDrawListenerC0126a = new ViewTreeObserver$OnPreDrawListenerC0126a(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(viewTreeObserver$OnPreDrawListenerC0126a);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC0126a);
    }

    /* renamed from: c */
    public static void m10461c(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = m10464a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().mo10439c(viewGroup);
            }
        }
        if (transition != null) {
            transition.m10487a(viewGroup, true);
        }
        Scene m10503a = Scene.m10503a(viewGroup);
        if (m10503a != null) {
            m10503a.m10504a();
        }
    }

    /* renamed from: a */
    public static void m10463a(ViewGroup viewGroup, Transition transition) {
        if (f984c.contains(viewGroup) || !ViewCompat.m9409x(viewGroup)) {
            return;
        }
        f984c.add(viewGroup);
        if (transition == null) {
            transition = f982a;
        }
        Transition m11327clone = transition.m11327clone();
        m10461c(viewGroup, m11327clone);
        Scene.m10502a(viewGroup, null);
        m10462b(viewGroup, m11327clone);
    }
}
