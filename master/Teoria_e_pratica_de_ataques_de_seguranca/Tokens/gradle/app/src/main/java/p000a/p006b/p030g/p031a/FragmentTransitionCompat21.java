package p000a.p006b.p030g.p031a;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* renamed from: a.b.g.a.s */
/* loaded from: classes.dex */
public class FragmentTransitionCompat21 extends FragmentTransitionImpl {

    /* compiled from: FragmentTransitionCompat21.java */
    /* renamed from: a.b.g.a.s$a */
    /* loaded from: classes.dex */
    public class C0177a extends Transition.EpicenterCallback {

        /* renamed from: a */
        public final /* synthetic */ Rect f1259a;

        public C0177a(FragmentTransitionCompat21 fragmentTransitionCompat21, Rect rect) {
            this.f1259a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.f1259a;
        }
    }

    /* compiled from: FragmentTransitionCompat21.java */
    /* renamed from: a.b.g.a.s$b */
    /* loaded from: classes.dex */
    public class C0178b implements Transition.TransitionListener {

        /* renamed from: a */
        public final /* synthetic */ View f1260a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f1261b;

        public C0178b(FragmentTransitionCompat21 fragmentTransitionCompat21, View view, ArrayList arrayList) {
            this.f1260a = view;
            this.f1261b = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f1260a.setVisibility(8);
            int size = this.f1261b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f1261b.get(i)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    /* compiled from: FragmentTransitionCompat21.java */
    /* renamed from: a.b.g.a.s$c */
    /* loaded from: classes.dex */
    public class C0179c implements Transition.TransitionListener {

        /* renamed from: a */
        public final /* synthetic */ Object f1262a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f1263b;

        /* renamed from: c */
        public final /* synthetic */ Object f1264c;

        /* renamed from: d */
        public final /* synthetic */ ArrayList f1265d;

        /* renamed from: e */
        public final /* synthetic */ Object f1266e;

        /* renamed from: f */
        public final /* synthetic */ ArrayList f1267f;

        public C0179c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f1262a = obj;
            this.f1263b = arrayList;
            this.f1264c = obj2;
            this.f1265d = arrayList2;
            this.f1266e = obj3;
            this.f1267f = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Object obj = this.f1262a;
            if (obj != null) {
                FragmentTransitionCompat21.this.mo10095a(obj, this.f1263b, (ArrayList<View>) null);
            }
            Object obj2 = this.f1264c;
            if (obj2 != null) {
                FragmentTransitionCompat21.this.mo10095a(obj2, this.f1265d, (ArrayList<View>) null);
            }
            Object obj3 = this.f1266e;
            if (obj3 != null) {
                FragmentTransitionCompat21.this.mo10095a(obj3, this.f1267f, (ArrayList<View>) null);
            }
        }
    }

    /* compiled from: FragmentTransitionCompat21.java */
    /* renamed from: a.b.g.a.s$d */
    /* loaded from: classes.dex */
    public class C0180d extends Transition.EpicenterCallback {

        /* renamed from: a */
        public final /* synthetic */ Rect f1269a;

        public C0180d(FragmentTransitionCompat21 fragmentTransitionCompat21, Rect rect) {
            this.f1269a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f1269a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f1269a;
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
            return ((Transition) obj).clone();
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
        transitionSet.addTransition((Transition) obj);
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
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                mo10096a(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
        } else if (m10108a(transition) || !FragmentTransitionImpl.m10092a((List) transition.getTargets())) {
        } else {
            int size = arrayList.size();
            while (i < size) {
                transition.addTarget(arrayList.get(i));
                i++;
            }
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: b */
    public void mo10085b(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FragmentTransitionImpl.m10091a(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        mo10096a(transitionSet, arrayList);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: c */
    public void mo10081c(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            m10107a(view, rect);
            ((Transition) obj).setEpicenterCallback(new C0177a(this, rect));
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: b */
    public Object mo10084b(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    /* renamed from: a */
    public static boolean m10108a(Transition transition) {
        return (FragmentTransitionImpl.m10092a((List) transition.getTargetIds()) && FragmentTransitionImpl.m10092a((List) transition.getTargetNames()) && FragmentTransitionImpl.m10092a((List) transition.getTargetTypes())) ? false : true;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: b */
    public void mo10083b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            mo10095a((Object) transitionSet, arrayList, arrayList2);
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10099a(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new C0178b(this, view, arrayList));
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public Object mo10098a(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 != null) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        return transition;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: b */
    public void mo10086b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10104a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10097a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new C0179c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10095a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                mo10095a((Object) transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
        } else if (!m10108a(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                transition.addTarget(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.removeTarget(arrayList.get(size2));
            }
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10100a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentTransitionImpl
    /* renamed from: a */
    public void mo10101a(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new C0180d(this, rect));
        }
    }
}
