package p000a.p006b.p029f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.p006b.p030g.p044j.ArrayMap;
import p000a.p006b.p030g.p044j.LongSparseArray;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.f.m */
/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {

    /* renamed from: H */
    public static final int[] f939H = {2, 1, 3, 4};

    /* renamed from: I */
    public static final PathMotion f940I = new C0120a();

    /* renamed from: J */
    public static ThreadLocal<ArrayMap<Animator, C0123d>> f941J = new ThreadLocal<>();

    /* renamed from: D */
    public TransitionPropagation f945D;

    /* renamed from: E */
    public AbstractC0124e f946E;

    /* renamed from: F */
    public ArrayMap<String, String> f947F;

    /* renamed from: u */
    public ArrayList<TransitionValues> f968u;

    /* renamed from: v */
    public ArrayList<TransitionValues> f969v;

    /* renamed from: a */
    public String f949a = getClass().getName();

    /* renamed from: b */
    public long f950b = -1;

    /* renamed from: c */
    public long f951c = -1;

    /* renamed from: d */
    public TimeInterpolator f952d = null;

    /* renamed from: e */
    public ArrayList<Integer> f953e = new ArrayList<>();

    /* renamed from: f */
    public ArrayList<View> f954f = new ArrayList<>();

    /* renamed from: g */
    public ArrayList<String> f955g = null;

    /* renamed from: h */
    public ArrayList<Class> f956h = null;

    /* renamed from: i */
    public ArrayList<Integer> f957i = null;

    /* renamed from: j */
    public ArrayList<View> f958j = null;

    /* renamed from: k */
    public ArrayList<Class> f959k = null;

    /* renamed from: m */
    public ArrayList<String> f960m = null;

    /* renamed from: n */
    public ArrayList<Integer> f961n = null;

    /* renamed from: o */
    public ArrayList<View> f962o = null;

    /* renamed from: p */
    public ArrayList<Class> f963p = null;

    /* renamed from: q */
    public TransitionValuesMaps f964q = new TransitionValuesMaps();

    /* renamed from: r */
    public TransitionValuesMaps f965r = new TransitionValuesMaps();

    /* renamed from: s */
    public TransitionSet f966s = null;

    /* renamed from: t */
    public int[] f967t = f939H;

    /* renamed from: w */
    public boolean f970w = false;

    /* renamed from: x */
    public ArrayList<Animator> f971x = new ArrayList<>();

    /* renamed from: y */
    public int f972y = 0;

    /* renamed from: z */
    public boolean f973z = false;

    /* renamed from: A */
    public boolean f942A = false;

    /* renamed from: B */
    public ArrayList<InterfaceC0125f> f943B = null;

    /* renamed from: C */
    public ArrayList<Animator> f944C = new ArrayList<>();

    /* renamed from: G */
    public PathMotion f948G = f940I;

    /* compiled from: Transition.java */
    /* renamed from: a.b.f.m$a */
    /* loaded from: classes.dex */
    public static class C0120a extends PathMotion {
        @Override // p000a.p006b.p029f.PathMotion
        /* renamed from: a */
        public Path mo10467a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* compiled from: Transition.java */
    /* renamed from: a.b.f.m$b */
    /* loaded from: classes.dex */
    public class C0121b extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ ArrayMap f974a;

        public C0121b(ArrayMap arrayMap) {
            this.f974a = arrayMap;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f974a.remove(animator);
            Transition.this.f971x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Transition.this.f971x.add(animator);
        }
    }

    /* compiled from: Transition.java */
    /* renamed from: a.b.f.m$c */
    /* loaded from: classes.dex */
    public class C0122c extends AnimatorListenerAdapter {
        public C0122c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Transition.this.m10501a();
            animator.removeListener(this);
        }
    }

    /* compiled from: Transition.java */
    /* renamed from: a.b.f.m$d */
    /* loaded from: classes.dex */
    public static class C0123d {

        /* renamed from: a */
        public View f977a;

        /* renamed from: b */
        public String f978b;

        /* renamed from: c */
        public TransitionValues f979c;

        /* renamed from: d */
        public WindowIdImpl f980d;

        /* renamed from: e */
        public Transition f981e;

        public C0123d(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.f977a = view;
            this.f978b = str;
            this.f979c = transitionValues;
            this.f980d = windowIdImpl;
            this.f981e = transition;
        }
    }

    /* compiled from: Transition.java */
    /* renamed from: a.b.f.m$e */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0124e {
    }

    /* compiled from: Transition.java */
    /* renamed from: a.b.f.m$f */
    /* loaded from: classes.dex */
    public interface InterfaceC0125f {
        /* renamed from: a */
        void mo10466a(Transition transition);

        /* renamed from: b */
        void mo10433b(Transition transition);

        /* renamed from: c */
        void mo10432c(Transition transition);

        /* renamed from: d */
        void mo10465d(Transition transition);
    }

    /* renamed from: r */
    public static ArrayMap<Animator, C0123d> m10468r() {
        ArrayMap<Animator, C0123d> arrayMap = f941J.get();
        if (arrayMap == null) {
            ArrayMap<Animator, C0123d> arrayMap2 = new ArrayMap<>();
            f941J.set(arrayMap2);
            return arrayMap2;
        }
        return arrayMap;
    }

    /* renamed from: a */
    public Transition mo10455a(long j) {
        this.f951c = j;
        return this;
    }

    /* renamed from: a */
    public Animator mo10488a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* renamed from: a */
    public abstract void mo10449a(TransitionValues transitionValues);

    /* renamed from: b */
    public long m10485b() {
        return this.f951c;
    }

    /* renamed from: c */
    public TransitionValues m10480c(View view, boolean z) {
        TransitionSet transitionSet = this.f966s;
        if (transitionSet != null) {
            return transitionSet.m10480c(view, z);
        }
        return (z ? this.f964q : this.f965r).f1002a.get(view);
    }

    /* renamed from: c */
    public abstract void mo10440c(TransitionValues transitionValues);

    /* renamed from: d */
    public TimeInterpolator m10479d() {
        return this.f952d;
    }

    /* renamed from: e */
    public void mo10437e(View view) {
        if (this.f973z) {
            if (!this.f942A) {
                ArrayMap<Animator, C0123d> m10468r = m10468r();
                int size = m10468r.size();
                WindowIdImpl m10536d = C0109d0.m10536d(view);
                for (int i = size - 1; i >= 0; i--) {
                    C0123d m9607e = m10468r.m9607e(i);
                    if (m9607e.f977a != null && m10536d.equals(m9607e.f980d)) {
                        AnimatorUtils.m10574b(m10468r.m9609c(i));
                    }
                }
                ArrayList<InterfaceC0125f> arrayList = this.f943B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f943B.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((InterfaceC0125f) arrayList2.get(i2)).mo10465d(this);
                    }
                }
            }
            this.f973z = false;
        }
    }

    /* renamed from: f */
    public PathMotion m10477f() {
        return this.f948G;
    }

    /* renamed from: g */
    public TransitionPropagation m10476g() {
        return this.f945D;
    }

    /* renamed from: h */
    public long m10475h() {
        return this.f950b;
    }

    /* renamed from: i */
    public List<Integer> m10474i() {
        return this.f953e;
    }

    /* renamed from: l */
    public List<String> m10473l() {
        return this.f955g;
    }

    /* renamed from: m */
    public List<Class> m10472m() {
        return this.f956h;
    }

    /* renamed from: n */
    public List<View> m10471n() {
        return this.f954f;
    }

    /* renamed from: o */
    public String[] mo10470o() {
        return null;
    }

    /* renamed from: p */
    public void mo10436p() {
        m10469q();
        ArrayMap<Animator, C0123d> m10468r = m10468r();
        Iterator<Animator> it = this.f944C.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (m10468r.containsKey(next)) {
                m10469q();
                m10491a(next, m10468r);
            }
        }
        this.f944C.clear();
        m10501a();
    }

    /* renamed from: q */
    public void m10469q() {
        if (this.f972y == 0) {
            ArrayList<InterfaceC0125f> arrayList = this.f943B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f943B.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((InterfaceC0125f) arrayList2.get(i)).mo10432c(this);
                }
            }
            this.f942A = false;
        }
        this.f972y++;
    }

    public String toString() {
        return mo10445a("");
    }

    /* renamed from: a */
    public Transition mo10448a(TimeInterpolator timeInterpolator) {
        this.f952d = timeInterpolator;
        return this;
    }

    /* renamed from: b */
    public Transition mo10443b(long j) {
        this.f950b = j;
        return this;
    }

    /* renamed from: clone */
    public Transition m11327clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.f944C = new ArrayList<>();
            transition.f964q = new TransitionValuesMaps();
            transition.f965r = new TransitionValuesMaps();
            transition.f968u = null;
            transition.f969v = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* renamed from: d */
    public Transition mo10438d(View view) {
        this.f954f.remove(view);
        return this;
    }

    /* renamed from: a */
    public final void m10494a(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View m9659b;
        int m9657c = longSparseArray.m9657c();
        for (int i = 0; i < m9657c; i++) {
            View m9656c = longSparseArray.m9656c(i);
            if (m9656c != null && m10483b(m9656c) && (m9659b = longSparseArray2.m9659b(longSparseArray.m9664a(i))) != null && m10483b(m9659b)) {
                TransitionValues transitionValues = arrayMap.get(m9656c);
                TransitionValues transitionValues2 = arrayMap2.get(m9659b);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f968u.add(transitionValues);
                    this.f969v.add(transitionValues2);
                    arrayMap.remove(m9656c);
                    arrayMap2.remove(m9659b);
                }
            }
        }
    }

    /* renamed from: b */
    public final void m10484b(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        View view;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View m9609c = arrayMap.m9609c(size);
            if (m9609c != null && m10483b(m9609c) && (remove = arrayMap2.remove(m9609c)) != null && (view = remove.f1000b) != null && m10483b(view)) {
                this.f968u.add(arrayMap.m9608d(size));
                this.f969v.add(remove);
            }
        }
    }

    /* renamed from: c */
    public void mo10439c(View view) {
        if (this.f942A) {
            return;
        }
        ArrayMap<Animator, C0123d> m10468r = m10468r();
        int size = m10468r.size();
        WindowIdImpl m10536d = C0109d0.m10536d(view);
        for (int i = size - 1; i >= 0; i--) {
            C0123d m9607e = m10468r.m9607e(i);
            if (m9607e.f977a != null && m10536d.equals(m9607e.f980d)) {
                AnimatorUtils.m10576a(m10468r.m9609c(i));
            }
        }
        ArrayList<InterfaceC0125f> arrayList = this.f943B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f943B.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((InterfaceC0125f) arrayList2.get(i2)).mo10466a(this);
            }
        }
        this.f973z = true;
    }

    /* renamed from: b */
    public boolean m10483b(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f957i;
        if (arrayList3 == null || !arrayList3.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList4 = this.f958j;
            if (arrayList4 == null || !arrayList4.contains(view)) {
                ArrayList<Class> arrayList5 = this.f959k;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f959k.get(i).isInstance(view)) {
                            return false;
                        }
                    }
                }
                if (this.f960m == null || ViewCompat.m9417p(view) == null || !this.f960m.contains(ViewCompat.m9417p(view))) {
                    if ((this.f953e.size() == 0 && this.f954f.size() == 0 && (((arrayList = this.f956h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f955g) == null || arrayList2.isEmpty()))) || this.f953e.contains(Integer.valueOf(id)) || this.f954f.contains(view)) {
                        return true;
                    }
                    ArrayList<String> arrayList6 = this.f955g;
                    if (arrayList6 == null || !arrayList6.contains(ViewCompat.m9417p(view))) {
                        if (this.f956h != null) {
                            for (int i2 = 0; i2 < this.f956h.size(); i2++) {
                                if (this.f956h.get(i2).isInstance(view)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public final void m10493a(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && m10483b(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && m10483b(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f968u.add(transitionValues);
                    this.f969v.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    /* renamed from: e */
    public String m10478e() {
        return this.f949a;
    }

    /* renamed from: c */
    public AbstractC0124e m10481c() {
        return this.f946E;
    }

    /* renamed from: a */
    public final void m10495a(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i = 0; i < size; i++) {
            View m9607e = arrayMap3.m9607e(i);
            if (m9607e != null && m10483b(m9607e) && (view = arrayMap4.get(arrayMap3.m9609c(i))) != null && m10483b(view)) {
                TransitionValues transitionValues = arrayMap.get(m9607e);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.f968u.add(transitionValues);
                    this.f969v.add(transitionValues2);
                    arrayMap.remove(m9607e);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    /* renamed from: b */
    public TransitionValues m10482b(View view, boolean z) {
        TransitionSet transitionSet = this.f966s;
        if (transitionSet != null) {
            return transitionSet.m10482b(view, z);
        }
        ArrayList<TransitionValues> arrayList = z ? this.f968u : this.f969v;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            TransitionValues transitionValues = arrayList.get(i2);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.f1000b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            return (z ? this.f969v : this.f968u).get(i);
        }
        return null;
    }

    /* renamed from: a */
    public final void m10496a(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i = 0; i < arrayMap.size(); i++) {
            TransitionValues m9607e = arrayMap.m9607e(i);
            if (m10483b(m9607e.f1000b)) {
                this.f968u.add(m9607e);
                this.f969v.add(null);
            }
        }
        for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
            TransitionValues m9607e2 = arrayMap2.m9607e(i2);
            if (m10483b(m9607e2.f1000b)) {
                this.f969v.add(m9607e2);
                this.f968u.add(null);
            }
        }
    }

    /* renamed from: b */
    public Transition mo10442b(InterfaceC0125f interfaceC0125f) {
        ArrayList<InterfaceC0125f> arrayList = this.f943B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(interfaceC0125f);
        if (this.f943B.size() == 0) {
            this.f943B = null;
        }
        return this;
    }

    /* renamed from: b */
    public void mo10441b(TransitionValues transitionValues) {
        String[] m10459a;
        if (this.f945D == null || transitionValues.f999a.isEmpty() || (m10459a = this.f945D.m10459a()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= m10459a.length) {
                z = true;
                break;
            } else if (!transitionValues.f999a.containsKey(m10459a[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.f945D.m10458a(transitionValues);
    }

    /* renamed from: a */
    public final void m10498a(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<>(transitionValuesMaps.f1002a);
        ArrayMap<View, TransitionValues> arrayMap2 = new ArrayMap<>(transitionValuesMaps2.f1002a);
        int i = 0;
        while (true) {
            int[] iArr = this.f967t;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    m10484b(arrayMap, arrayMap2);
                } else if (i2 == 2) {
                    m10495a(arrayMap, arrayMap2, transitionValuesMaps.f1005d, transitionValuesMaps2.f1005d);
                } else if (i2 == 3) {
                    m10493a(arrayMap, arrayMap2, transitionValuesMaps.f1003b, transitionValuesMaps2.f1003b);
                } else if (i2 == 4) {
                    m10494a(arrayMap, arrayMap2, transitionValuesMaps.f1004c, transitionValuesMaps2.f1004c);
                }
                i++;
            } else {
                m10496a(arrayMap, arrayMap2);
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo10446a(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        Animator mo10488a;
        int i;
        int i2;
        View view;
        Animator animator;
        TransitionValues transitionValues;
        Animator animator2;
        TransitionValues transitionValues2;
        ArrayMap<Animator, C0123d> m10468r = m10468r();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            TransitionValues transitionValues3 = arrayList.get(i3);
            TransitionValues transitionValues4 = arrayList2.get(i3);
            if (transitionValues3 != null && !transitionValues3.f1001c.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.f1001c.contains(this)) {
                transitionValues4 = null;
            }
            if (transitionValues3 != null || transitionValues4 != null) {
                if ((transitionValues3 == null || transitionValues4 == null || mo10500a(transitionValues3, transitionValues4)) && (mo10488a = mo10488a(viewGroup, transitionValues3, transitionValues4)) != null) {
                    if (transitionValues4 != null) {
                        view = transitionValues4.f1000b;
                        String[] mo10470o = mo10470o();
                        if (view == null || mo10470o == null || mo10470o.length <= 0) {
                            i = size;
                            i2 = i3;
                            animator2 = mo10488a;
                            transitionValues2 = null;
                        } else {
                            transitionValues2 = new TransitionValues();
                            transitionValues2.f1000b = view;
                            i = size;
                            TransitionValues transitionValues5 = transitionValuesMaps2.f1002a.get(view);
                            if (transitionValues5 != null) {
                                int i4 = 0;
                                while (i4 < mo10470o.length) {
                                    transitionValues2.f999a.put(mo10470o[i4], transitionValues5.f999a.get(mo10470o[i4]));
                                    i4++;
                                    i3 = i3;
                                    transitionValues5 = transitionValues5;
                                }
                            }
                            i2 = i3;
                            int size2 = m10468r.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = mo10488a;
                                    break;
                                }
                                C0123d c0123d = m10468r.get(m10468r.m9609c(i5));
                                if (c0123d.f979c != null && c0123d.f977a == view && c0123d.f978b.equals(m10478e()) && c0123d.f979c.equals(transitionValues2)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        }
                        animator = animator2;
                        transitionValues = transitionValues2;
                    } else {
                        i = size;
                        i2 = i3;
                        view = transitionValues3.f1000b;
                        animator = mo10488a;
                        transitionValues = null;
                    }
                    if (animator != null) {
                        TransitionPropagation transitionPropagation = this.f945D;
                        if (transitionPropagation != null) {
                            long m10457a = transitionPropagation.m10457a(viewGroup, this, transitionValues3, transitionValues4);
                            sparseIntArray.put(this.f944C.size(), (int) m10457a);
                            j = Math.min(m10457a, j);
                        }
                        m10468r.put(animator, new C0123d(view, m10478e(), this, C0109d0.m10536d(viewGroup), transitionValues));
                        this.f944C.add(animator);
                        j = j;
                    }
                    i3 = i2 + 1;
                    size = i;
                }
            }
            i = size;
            i2 = i3;
            i3 = i2 + 1;
            size = i;
        }
        if (j != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator3 = this.f944C.get(sparseIntArray.keyAt(i6));
                animator3.setStartDelay((sparseIntArray.valueAt(i6) - j) + animator3.getStartDelay());
            }
        }
    }

    /* renamed from: a */
    public final void m10491a(Animator animator, ArrayMap<Animator, C0123d> arrayMap) {
        if (animator != null) {
            animator.addListener(new C0121b(arrayMap));
            m10492a(animator);
        }
    }

    /* renamed from: a */
    public Transition mo10447a(View view) {
        this.f954f.add(view);
        return this;
    }

    /* renamed from: a */
    public void m10487a(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        ArrayMap<String, String> arrayMap;
        m10486a(z);
        if ((this.f953e.size() <= 0 && this.f954f.size() <= 0) || (((arrayList = this.f955g) != null && !arrayList.isEmpty()) || ((arrayList2 = this.f956h) != null && !arrayList2.isEmpty()))) {
            m10490a((View) viewGroup, z);
        } else {
            for (int i = 0; i < this.f953e.size(); i++) {
                View findViewById = viewGroup.findViewById(this.f953e.get(i).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.f1000b = findViewById;
                    if (z) {
                        mo10440c(transitionValues);
                    } else {
                        mo10449a(transitionValues);
                    }
                    transitionValues.f1001c.add(this);
                    mo10441b(transitionValues);
                    if (z) {
                        m10497a(this.f964q, findViewById, transitionValues);
                    } else {
                        m10497a(this.f965r, findViewById, transitionValues);
                    }
                }
            }
            for (int i2 = 0; i2 < this.f954f.size(); i2++) {
                View view = this.f954f.get(i2);
                TransitionValues transitionValues2 = new TransitionValues();
                transitionValues2.f1000b = view;
                if (z) {
                    mo10440c(transitionValues2);
                } else {
                    mo10449a(transitionValues2);
                }
                transitionValues2.f1001c.add(this);
                mo10441b(transitionValues2);
                if (z) {
                    m10497a(this.f964q, view, transitionValues2);
                } else {
                    m10497a(this.f965r, view, transitionValues2);
                }
            }
        }
        if (z || (arrayMap = this.f947F) == null) {
            return;
        }
        int size = arrayMap.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.f964q.f1005d.remove(this.f947F.m9609c(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.f964q.f1005d.put(this.f947F.m9607e(i4), view2);
            }
        }
    }

    /* renamed from: a */
    public static void m10497a(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f1002a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.f1003b.indexOfKey(id) >= 0) {
                transitionValuesMaps.f1003b.put(id, null);
            } else {
                transitionValuesMaps.f1003b.put(id, view);
            }
        }
        String m9417p = ViewCompat.m9417p(view);
        if (m9417p != null) {
            if (transitionValuesMaps.f1005d.containsKey(m9417p)) {
                transitionValuesMaps.f1005d.put(m9417p, null);
            } else {
                transitionValuesMaps.f1005d.put(m9417p, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.f1004c.m9655c(itemIdAtPosition) >= 0) {
                    View m9659b = transitionValuesMaps.f1004c.m9659b(itemIdAtPosition);
                    if (m9659b != null) {
                        ViewCompat.m9437b(m9659b, false);
                        transitionValuesMaps.f1004c.m9654c(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.m9437b(view, true);
                transitionValuesMaps.f1004c.m9654c(itemIdAtPosition, view);
            }
        }
    }

    /* renamed from: a */
    public void m10486a(boolean z) {
        if (z) {
            this.f964q.f1002a.clear();
            this.f964q.f1003b.clear();
            this.f964q.f1004c.m9665a();
            return;
        }
        this.f965r.f1002a.clear();
        this.f965r.f1003b.clear();
        this.f965r.f1004c.m9665a();
    }

    /* renamed from: a */
    public final void m10490a(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f957i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.f958j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class> arrayList3 = this.f959k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f959k.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.f1000b = view;
                    if (z) {
                        mo10440c(transitionValues);
                    } else {
                        mo10449a(transitionValues);
                    }
                    transitionValues.f1001c.add(this);
                    mo10441b(transitionValues);
                    if (z) {
                        m10497a(this.f964q, view, transitionValues);
                    } else {
                        m10497a(this.f965r, view, transitionValues);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.f961n;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.f962o;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class> arrayList6 = this.f963p;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.f963p.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                m10490a(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m10489a(ViewGroup viewGroup) {
        C0123d c0123d;
        this.f968u = new ArrayList<>();
        this.f969v = new ArrayList<>();
        m10498a(this.f964q, this.f965r);
        ArrayMap<Animator, C0123d> m10468r = m10468r();
        int size = m10468r.size();
        WindowIdImpl m10536d = C0109d0.m10536d(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator m9609c = m10468r.m9609c(i);
            if (m9609c != null && (c0123d = m10468r.get(m9609c)) != null && c0123d.f977a != null && m10536d.equals(c0123d.f980d)) {
                TransitionValues transitionValues = c0123d.f979c;
                View view = c0123d.f977a;
                TransitionValues m10480c = m10480c(view, true);
                TransitionValues m10482b = m10482b(view, true);
                if (!(m10480c == null && m10482b == null) && c0123d.f981e.mo10500a(transitionValues, m10482b)) {
                    if (!m9609c.isRunning() && !m9609c.isStarted()) {
                        m10468r.remove(m9609c);
                    } else {
                        m9609c.cancel();
                    }
                }
            }
        }
        mo10446a(viewGroup, this.f964q, this.f965r, this.f968u, this.f969v);
        mo10436p();
    }

    /* renamed from: a */
    public boolean mo10500a(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] mo10470o = mo10470o();
        if (mo10470o != null) {
            for (String str : mo10470o) {
                if (!m10499a(transitionValues, transitionValues2, str)) {
                }
            }
            return false;
        }
        for (String str2 : transitionValues.f999a.keySet()) {
            if (m10499a(transitionValues, transitionValues2, str2)) {
            }
        }
        return false;
        return true;
    }

    /* renamed from: a */
    public static boolean m10499a(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.f999a.get(str);
        Object obj2 = transitionValues2.f999a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    /* renamed from: a */
    public void m10492a(Animator animator) {
        if (animator == null) {
            m10501a();
            return;
        }
        if (m10485b() >= 0) {
            animator.setDuration(m10485b());
        }
        if (m10475h() >= 0) {
            animator.setStartDelay(m10475h());
        }
        if (m10479d() != null) {
            animator.setInterpolator(m10479d());
        }
        animator.addListener(new C0122c());
        animator.start();
    }

    /* renamed from: a */
    public void m10501a() {
        this.f972y--;
        if (this.f972y == 0) {
            ArrayList<InterfaceC0125f> arrayList = this.f943B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f943B.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((InterfaceC0125f) arrayList2.get(i)).mo10433b(this);
                }
            }
            for (int i2 = 0; i2 < this.f964q.f1004c.m9657c(); i2++) {
                View m9656c = this.f964q.f1004c.m9656c(i2);
                if (m9656c != null) {
                    ViewCompat.m9437b(m9656c, false);
                }
            }
            for (int i3 = 0; i3 < this.f965r.f1004c.m9657c(); i3++) {
                View m9656c2 = this.f965r.f1004c.m9656c(i3);
                if (m9656c2 != null) {
                    ViewCompat.m9437b(m9656c2, false);
                }
            }
            this.f942A = true;
        }
    }

    /* renamed from: a */
    public Transition mo10452a(InterfaceC0125f interfaceC0125f) {
        if (this.f943B == null) {
            this.f943B = new ArrayList<>();
        }
        this.f943B.add(interfaceC0125f);
        return this;
    }

    /* renamed from: a */
    public void mo10454a(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.f948G = f940I;
        } else {
            this.f948G = pathMotion;
        }
    }

    /* renamed from: a */
    public void mo10453a(AbstractC0124e abstractC0124e) {
        this.f946E = abstractC0124e;
    }

    /* renamed from: a */
    public void mo10450a(TransitionPropagation transitionPropagation) {
        this.f945D = transitionPropagation;
    }

    /* renamed from: a */
    public String mo10445a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f951c != -1) {
            str2 = str2 + "dur(" + this.f951c + ") ";
        }
        if (this.f950b != -1) {
            str2 = str2 + "dly(" + this.f950b + ") ";
        }
        if (this.f952d != null) {
            str2 = str2 + "interp(" + this.f952d + ") ";
        }
        if (this.f953e.size() > 0 || this.f954f.size() > 0) {
            String str3 = str2 + "tgts(";
            if (this.f953e.size() > 0) {
                String str4 = str3;
                for (int i = 0; i < this.f953e.size(); i++) {
                    if (i > 0) {
                        str4 = str4 + ", ";
                    }
                    str4 = str4 + this.f953e.get(i);
                }
                str3 = str4;
            }
            if (this.f954f.size() > 0) {
                for (int i2 = 0; i2 < this.f954f.size(); i2++) {
                    if (i2 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.f954f.get(i2);
                }
            }
            return str3 + ")";
        }
        return str2;
    }
}
