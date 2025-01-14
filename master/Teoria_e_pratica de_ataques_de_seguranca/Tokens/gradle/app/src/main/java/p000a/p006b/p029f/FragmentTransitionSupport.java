package p000a.p006b.p029f;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import p000a.p006b.p029f.Transition;
import p000a.p006b.p030g.p031a.FragmentTransitionImpl;

/* renamed from: a.b.f.e */
/* loaded from: classes.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: a.b.f.e$a */
    /* loaded from: classes.dex */
    public class C0112a extends Transition.AbstractC0124e {
        public C0112a(FragmentTransitionSupport fragmentTransitionSupport, Rect rect) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: a.b.f.e$b */
    /* loaded from: classes.dex */
    public class C0113b implements Transition.InterfaceC0125f {

        /* renamed from: a */
        public final /* synthetic */ View f893a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f894b;

        public C0113b(FragmentTransitionSupport fragmentTransitionSupport, View view, ArrayList arrayList) {
            this.f893a = view;
            this.f894b = arrayList;
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: a */
        public void mo10466a(Transition transition) {
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: b */
        public void mo10433b(Transition transition) {
            transition.mo10442b(this);
            this.f893a.setVisibility(8);
            int size = this.f894b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f894b.get(i)).setVisibility(0);
            }
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: c */
        public void mo10432c(Transition transition) {
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: d */
        public void mo10465d(Transition transition) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: a.b.f.e$c */
    /* loaded from: classes.dex */
    public class C0114c implements Transition.InterfaceC0125f {

        /* renamed from: a */
        public final /* synthetic */ Object f895a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f896b;

        /* renamed from: c */
        public final /* synthetic */ Object f897c;

        /* renamed from: d */
        public final /* synthetic */ ArrayList f898d;

        /* renamed from: e */
        public final /* synthetic */ Object f899e;

        /* renamed from: f */
        public final /* synthetic */ ArrayList f900f;

        public C0114c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f895a = obj;
            this.f896b = arrayList;
            this.f897c = obj2;
            this.f898d = arrayList2;
            this.f899e = obj3;
            this.f900f = arrayList3;
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: a */
        public void mo10466a(Transition transition) {
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: b */
        public void mo10433b(Transition transition) {
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: c */
        public void mo10432c(Transition transition) {
            Object obj = this.f895a;
            if (obj != null) {
                FragmentTransitionSupport.this.mo10095a(obj, this.f896b, (ArrayList<View>) null);
            }
            Object obj2 = this.f897c;
            if (obj2 != null) {
                FragmentTransitionSupport.this.mo10095a(obj2, this.f898d, (ArrayList<View>) null);
            }
            Object obj3 = this.f899e;
            if (obj3 != null) {
                FragmentTransitionSupport.this.mo10095a(obj3, this.f900f, (ArrayList<View>) null);
            }
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: d */
        public void mo10465d(Transition transition) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: a.b.f.e$d */
    /* loaded from: classes.dex */
    public class C0115d extends Transition.AbstractC0124e {
        public C0115d(FragmentTransitionSupport fragmentTransitionSupport, Rect rect) {
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public boolean mo10102a(Object obj) {
        return obj instanceof Transition;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: b */
    public Object mo10087b(Object obj) {
        if (obj != null) {
            return ((Transition) obj).m11327clone();
        }
        return null;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: c */
    public Object mo10082c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.m10451a((Transition) obj);
        return transitionSet;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10096a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int m10435s = transitionSet.m10435s();
            while (i < m10435s) {
                mo10096a(transitionSet.m10456a(i), arrayList);
                i++;
            }
        } else if (m10530a(transition) || !FragmentTransitionImpl.m10092a((List) transition.m10471n())) {
        } else {
            int size = arrayList.size();
            while (i < size) {
                transition.mo10447a(arrayList.get(i));
                i++;
            }
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: b */
    public void mo10085b(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> m10471n = transitionSet.m10471n();
        m10471n.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FragmentTransitionImpl.m10091a(m10471n, arrayList.get(i));
        }
        m10471n.add(view);
        arrayList.add(view);
        mo10096a(transitionSet, arrayList);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: c */
    public void mo10081c(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            m10107a(view, rect);
            ((Transition) obj).mo10453a(new C0112a(this, rect));
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: b */
    public Object mo10084b(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.m10451a((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.m10451a((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.m10451a((Transition) obj3);
        }
        return transitionSet;
    }

    /* renamed from: a */
    public static boolean m10530a(Transition transition) {
        return (FragmentTransitionImpl.m10092a((List) transition.m10474i()) && FragmentTransitionImpl.m10092a((List) transition.m10473l()) && FragmentTransitionImpl.m10092a((List) transition.m10472m())) ? false : true;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: b */
    public void mo10083b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.m10471n().clear();
            transitionSet.m10471n().addAll(arrayList2);
            mo10095a((Object) transitionSet, arrayList, arrayList2);
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10099a(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).mo10452a(new C0113b(this, view, arrayList));
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public Object mo10098a(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.m10451a(transition);
            transitionSet.m10451a(transition2);
            transitionSet.m10444b(1);
            transition = transitionSet;
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 != null) {
            TransitionSet transitionSet2 = new TransitionSet();
            if (transition != null) {
                transitionSet2.m10451a(transition);
            }
            transitionSet2.m10451a(transition3);
            return transitionSet2;
        }
        return transition;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: b */
    public void mo10086b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).mo10438d(view);
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10104a(ViewGroup viewGroup, Object obj) {
        TransitionManager.m10463a(viewGroup, (Transition) obj);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10097a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).mo10452a(new C0114c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10095a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int m10435s = transitionSet.m10435s();
            while (i < m10435s) {
                mo10095a((Object) transitionSet.m10456a(i), arrayList, arrayList2);
                i++;
            }
        } else if (!m10530a(transition)) {
            List<View> m10471n = transition.m10471n();
            if (m10471n.size() == arrayList.size() && m10471n.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size) {
                    transition.mo10447a(arrayList2.get(i));
                    i++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    transition.mo10438d(arrayList.get(size2));
                }
            }
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10100a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).mo10447a(view);
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10101a(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).mo10453a(new C0115d(this, rect));
        }
    }
}
