package p000a.p006b.p030g.p031a;

import android.graphics.Rect;
import android.os.Build;
import android.support.p065v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p000a.p006b.p030g.p044j.ArrayMap;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.g.a.r */
/* loaded from: classes.dex */
public class FragmentTransition {

    /* renamed from: a */
    public static final int[] f1222a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: b */
    public static final FragmentTransitionImpl f1223b;

    /* renamed from: c */
    public static final FragmentTransitionImpl f1224c;

    /* compiled from: FragmentTransition.java */
    /* renamed from: a.b.g.a.r$a */
    /* loaded from: classes.dex */
    public static class RunnableC0172a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f1225a;

        public RunnableC0172a(ArrayList arrayList) {
            this.f1225a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentTransition.m10115a(this.f1225a, 4);
        }
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: a.b.g.a.r$b */
    /* loaded from: classes.dex */
    public static class RunnableC0173b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Object f1226a;

        /* renamed from: b */
        public final /* synthetic */ FragmentTransitionImpl f1227b;

        /* renamed from: c */
        public final /* synthetic */ View f1228c;

        /* renamed from: d */
        public final /* synthetic */ Fragment f1229d;

        /* renamed from: e */
        public final /* synthetic */ ArrayList f1230e;

        /* renamed from: f */
        public final /* synthetic */ ArrayList f1231f;

        /* renamed from: g */
        public final /* synthetic */ ArrayList f1232g;

        /* renamed from: h */
        public final /* synthetic */ Object f1233h;

        public RunnableC0173b(Object obj, FragmentTransitionImpl fragmentTransitionImpl, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f1226a = obj;
            this.f1227b = fragmentTransitionImpl;
            this.f1228c = view;
            this.f1229d = fragment;
            this.f1230e = arrayList;
            this.f1231f = arrayList2;
            this.f1232g = arrayList3;
            this.f1233h = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f1226a;
            if (obj != null) {
                this.f1227b.mo10086b(obj, this.f1228c);
                this.f1231f.addAll(FragmentTransition.m10124a(this.f1227b, this.f1226a, this.f1229d, this.f1230e, this.f1228c));
            }
            if (this.f1232g != null) {
                if (this.f1233h != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f1228c);
                    this.f1227b.mo10095a(this.f1233h, this.f1232g, arrayList);
                }
                this.f1232g.clear();
                this.f1232g.add(this.f1228c);
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: a.b.g.a.r$c */
    /* loaded from: classes.dex */
    public static class RunnableC0174c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Fragment f1234a;

        /* renamed from: b */
        public final /* synthetic */ Fragment f1235b;

        /* renamed from: c */
        public final /* synthetic */ boolean f1236c;

        /* renamed from: d */
        public final /* synthetic */ ArrayMap f1237d;

        /* renamed from: e */
        public final /* synthetic */ View f1238e;

        /* renamed from: f */
        public final /* synthetic */ FragmentTransitionImpl f1239f;

        /* renamed from: g */
        public final /* synthetic */ Rect f1240g;

        public RunnableC0174c(Fragment fragment, Fragment fragment2, boolean z, ArrayMap arrayMap, View view, FragmentTransitionImpl fragmentTransitionImpl, Rect rect) {
            this.f1234a = fragment;
            this.f1235b = fragment2;
            this.f1236c = z;
            this.f1237d = arrayMap;
            this.f1238e = view;
            this.f1239f = fragmentTransitionImpl;
            this.f1240g = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentTransition.m10116a(this.f1234a, this.f1235b, this.f1236c, (ArrayMap<String, View>) this.f1237d, false);
            View view = this.f1238e;
            if (view != null) {
                this.f1239f.m10107a(view, this.f1240g);
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: a.b.g.a.r$d */
    /* loaded from: classes.dex */
    public static class RunnableC0175d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ FragmentTransitionImpl f1241a;

        /* renamed from: b */
        public final /* synthetic */ ArrayMap f1242b;

        /* renamed from: c */
        public final /* synthetic */ Object f1243c;

        /* renamed from: d */
        public final /* synthetic */ C0176e f1244d;

        /* renamed from: e */
        public final /* synthetic */ ArrayList f1245e;

        /* renamed from: f */
        public final /* synthetic */ View f1246f;

        /* renamed from: g */
        public final /* synthetic */ Fragment f1247g;

        /* renamed from: h */
        public final /* synthetic */ Fragment f1248h;

        /* renamed from: i */
        public final /* synthetic */ boolean f1249i;

        /* renamed from: j */
        public final /* synthetic */ ArrayList f1250j;

        /* renamed from: k */
        public final /* synthetic */ Object f1251k;

        /* renamed from: m */
        public final /* synthetic */ Rect f1252m;

        public RunnableC0175d(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap arrayMap, Object obj, C0176e c0176e, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f1241a = fragmentTransitionImpl;
            this.f1242b = arrayMap;
            this.f1243c = obj;
            this.f1244d = c0176e;
            this.f1245e = arrayList;
            this.f1246f = view;
            this.f1247g = fragment;
            this.f1248h = fragment2;
            this.f1249i = z;
            this.f1250j = arrayList2;
            this.f1251k = obj2;
            this.f1252m = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayMap<String, View> m10130a = FragmentTransition.m10130a(this.f1241a, this.f1242b, this.f1243c, this.f1244d);
            if (m10130a != null) {
                this.f1245e.addAll(m10130a.values());
                this.f1245e.add(this.f1246f);
            }
            FragmentTransition.m10116a(this.f1247g, this.f1248h, this.f1249i, m10130a, false);
            Object obj = this.f1243c;
            if (obj != null) {
                this.f1241a.mo10083b(obj, this.f1250j, this.f1245e);
                View m10120a = FragmentTransition.m10120a(m10130a, this.f1244d, this.f1251k, this.f1249i);
                if (m10120a != null) {
                    this.f1241a.m10107a(m10120a, this.f1252m);
                }
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: a.b.g.a.r$e */
    /* loaded from: classes.dex */
    public static class C0176e {

        /* renamed from: a */
        public Fragment f1253a;

        /* renamed from: b */
        public boolean f1254b;

        /* renamed from: c */
        public BackStackRecord f1255c;

        /* renamed from: d */
        public Fragment f1256d;

        /* renamed from: e */
        public boolean f1257e;

        /* renamed from: f */
        public BackStackRecord f1258f;
    }

    static {
        f1223b = Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null;
        f1224c = m10137a();
    }

    /* renamed from: a */
    public static FragmentTransitionImpl m10137a() {
        try {
            return (FragmentTransitionImpl) Class.forName("a.b.f.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static void m10112b(LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l, int i, C0176e c0176e, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl m10117a;
        Object obj;
        ViewGroup viewGroup = layoutInflater$Factory2C0152l.f1152o.mo7442a() ? (ViewGroup) layoutInflater$Factory2C0152l.f1152o.mo7441a(i) : null;
        if (viewGroup == null || (m10117a = m10117a((fragment2 = c0176e.f1256d), (fragment = c0176e.f1253a))) == null) {
            return;
        }
        boolean z = c0176e.f1254b;
        boolean z2 = c0176e.f1257e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object m10128a = m10128a(m10117a, fragment, z);
        Object m10110b = m10110b(m10117a, fragment2, z2);
        Object m10109b = m10109b(m10117a, viewGroup, view, arrayMap, c0176e, arrayList2, arrayList, m10128a, m10110b);
        if (m10128a == null && m10109b == null) {
            obj = m10110b;
            if (obj == null) {
                return;
            }
        } else {
            obj = m10110b;
        }
        ArrayList<View> m10124a = m10124a(m10117a, obj, fragment2, arrayList2, view);
        ArrayList<View> m10124a2 = m10124a(m10117a, m10128a, fragment, arrayList, view);
        m10115a(m10124a2, 4);
        Object m10122a = m10122a(m10117a, m10128a, obj, m10109b, fragment, z);
        if (m10122a != null) {
            m10125a(m10117a, obj, fragment2, m10124a);
            ArrayList<String> m10094a = m10117a.m10094a(arrayList);
            m10117a.mo10097a(m10122a, m10128a, m10124a2, obj, m10124a, m10109b, arrayList);
            m10117a.mo10104a(viewGroup, m10122a);
            m10117a.m10106a(viewGroup, arrayList2, arrayList, m10094a, arrayMap);
            m10115a(m10124a2, 0);
            m10117a.mo10083b(m10109b, arrayList2, arrayList);
        }
    }

    /* renamed from: a */
    public static void m10132a(LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (layoutInflater$Factory2C0152l.f1150m < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            BackStackRecord backStackRecord = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                m10113b(backStackRecord, sparseArray, z);
            } else {
                m10134a(backStackRecord, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(layoutInflater$Factory2C0152l.f1151n.m10291c());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                ArrayMap<String, String> m10136a = m10136a(keyAt, arrayList, arrayList2, i, i2);
                C0176e c0176e = (C0176e) sparseArray.valueAt(i4);
                if (z) {
                    m10112b(layoutInflater$Factory2C0152l, keyAt, c0176e, view, m10136a);
                } else {
                    m10133a(layoutInflater$Factory2C0152l, keyAt, c0176e, view, m10136a);
                }
            }
        }
    }

    /* renamed from: a */
    public static ArrayMap<String, String> m10136a(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (backStackRecord.m10370c(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = backStackRecord.f1065r;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.f1065r;
                        arrayList4 = backStackRecord.f1066s;
                    } else {
                        ArrayList<String> arrayList6 = backStackRecord.f1065r;
                        arrayList3 = backStackRecord.f1066s;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    /* renamed from: b */
    public static Object m10110b(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object m7449t;
        if (fragment == null) {
            return null;
        }
        if (z) {
            m7449t = fragment.m7548C();
        } else {
            m7449t = fragment.m7449t();
        }
        return fragmentTransitionImpl.mo10087b(m7449t);
    }

    /* renamed from: b */
    public static Object m10109b(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, C0176e c0176e, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = c0176e.f1253a;
        Fragment fragment2 = c0176e.f1256d;
        if (fragment != null) {
            fragment.m7543H().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = c0176e.f1254b;
        Object m10129a = arrayMap.isEmpty() ? null : m10129a(fragmentTransitionImpl, fragment, fragment2, z);
        ArrayMap<String, View> m10111b = m10111b(fragmentTransitionImpl, arrayMap, m10129a, c0176e);
        ArrayMap<String, View> m10130a = m10130a(fragmentTransitionImpl, arrayMap, m10129a, c0176e);
        if (arrayMap.isEmpty()) {
            if (m10111b != null) {
                m10111b.clear();
            }
            if (m10130a != null) {
                m10130a.clear();
            }
            obj3 = null;
        } else {
            m10114a(arrayList, m10111b, arrayMap.keySet());
            m10114a(arrayList2, m10130a, arrayMap.values());
            obj3 = m10129a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m10116a(fragment, fragment2, z, m10111b, true);
        if (obj3 != null) {
            arrayList2.add(view);
            fragmentTransitionImpl.mo10085b(obj3, view, arrayList);
            m10123a(fragmentTransitionImpl, obj3, obj2, m10111b, c0176e.f1257e, c0176e.f1258f);
            Rect rect2 = new Rect();
            View m10120a = m10120a(m10130a, c0176e, obj, z);
            if (m10120a != null) {
                fragmentTransitionImpl.mo10101a(obj, rect2);
            }
            rect = rect2;
            view2 = m10120a;
        } else {
            view2 = null;
            rect = null;
        }
        OneShotPreDrawListener.m10363a(viewGroup, new RunnableC0174c(fragment, fragment2, z, m10130a, view2, fragmentTransitionImpl, rect));
        return obj3;
    }

    /* renamed from: a */
    public static void m10125a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.f3497k && fragment.f3465B && fragment.f3479P) {
            fragment.m7478g(true);
            fragmentTransitionImpl.mo10099a(obj, fragment.m7543H(), arrayList);
            OneShotPreDrawListener.m10363a(fragment.f3472I, new RunnableC0172a(arrayList));
        }
    }

    /* renamed from: a */
    public static void m10133a(LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l, int i, C0176e c0176e, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl m10117a;
        Object obj;
        ViewGroup viewGroup = layoutInflater$Factory2C0152l.f1152o.mo7442a() ? (ViewGroup) layoutInflater$Factory2C0152l.f1152o.mo7441a(i) : null;
        if (viewGroup == null || (m10117a = m10117a((fragment2 = c0176e.f1256d), (fragment = c0176e.f1253a))) == null) {
            return;
        }
        boolean z = c0176e.f1254b;
        boolean z2 = c0176e.f1257e;
        Object m10128a = m10128a(m10117a, fragment, z);
        Object m10110b = m10110b(m10117a, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object m10126a = m10126a(m10117a, viewGroup, view, arrayMap, c0176e, arrayList, arrayList2, m10128a, m10110b);
        if (m10128a == null && m10126a == null) {
            obj = m10110b;
            if (obj == null) {
                return;
            }
        } else {
            obj = m10110b;
        }
        ArrayList<View> m10124a = m10124a(m10117a, obj, fragment2, arrayList, view);
        Object obj2 = (m10124a == null || m10124a.isEmpty()) ? null : obj;
        m10117a.mo10100a(m10128a, view);
        Object m10122a = m10122a(m10117a, m10128a, obj2, m10126a, fragment, c0176e.f1254b);
        if (m10122a != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            m10117a.mo10097a(m10122a, m10128a, arrayList3, obj2, m10124a, m10126a, arrayList2);
            m10127a(m10117a, viewGroup, fragment, view, arrayList2, m10128a, arrayList3, obj2, m10124a);
            m10117a.m10105a((View) viewGroup, arrayList2, (Map<String, String>) arrayMap);
            m10117a.mo10104a(viewGroup, m10122a);
            m10117a.m10103a(viewGroup, arrayList2, (Map<String, String>) arrayMap);
        }
    }

    /* renamed from: b */
    public static ArrayMap<String, View> m10111b(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, C0176e c0176e) {
        SharedElementCallback m7448u;
        ArrayList<String> arrayList;
        if (!arrayMap.isEmpty() && obj != null) {
            Fragment fragment = c0176e.f1256d;
            ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
            fragmentTransitionImpl.m10089a((Map<String, View>) arrayMap2, fragment.m7543H());
            BackStackRecord backStackRecord = c0176e.f1258f;
            if (c0176e.f1257e) {
                m7448u = fragment.m7450s();
                arrayList = backStackRecord.f1066s;
            } else {
                m7448u = fragment.m7448u();
                arrayList = backStackRecord.f1065r;
            }
            arrayMap2.m9683a((Collection<?>) arrayList);
            if (m7448u != null) {
                m7448u.m10349a(arrayList, arrayMap2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view = arrayMap2.get(str);
                    if (view == null) {
                        arrayMap.remove(str);
                    } else if (!str.equals(ViewCompat.m9417p(view))) {
                        arrayMap.put(ViewCompat.m9417p(view), arrayMap.remove(str));
                    }
                }
            } else {
                arrayMap.m9683a((Collection<?>) arrayMap2.keySet());
            }
            return arrayMap2;
        }
        arrayMap.clear();
        return null;
    }

    /* renamed from: a */
    public static void m10127a(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        OneShotPreDrawListener.m10363a(viewGroup, new RunnableC0173b(obj, fragmentTransitionImpl, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    /* renamed from: a */
    public static FragmentTransitionImpl m10117a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object m7449t = fragment.m7449t();
            if (m7449t != null) {
                arrayList.add(m7449t);
            }
            Object m7548C = fragment.m7548C();
            if (m7548C != null) {
                arrayList.add(m7548C);
            }
            Object m7546E = fragment.m7546E();
            if (m7546E != null) {
                arrayList.add(m7546E);
            }
        }
        if (fragment2 != null) {
            Object m7451r = fragment2.m7451r();
            if (m7451r != null) {
                arrayList.add(m7451r);
            }
            Object m7550A = fragment2.m7550A();
            if (m7550A != null) {
                arrayList.add(m7550A);
            }
            Object m7547D = fragment2.m7547D();
            if (m7547D != null) {
                arrayList.add(m7547D);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = f1223b;
        if (fragmentTransitionImpl != null && m10121a(fragmentTransitionImpl, arrayList)) {
            return f1223b;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = f1224c;
        if (fragmentTransitionImpl2 != null && m10121a(fragmentTransitionImpl2, arrayList)) {
            return f1224c;
        }
        if (f1223b == null && f1224c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* renamed from: b */
    public static void m10113b(BackStackRecord backStackRecord, SparseArray<C0176e> sparseArray, boolean z) {
        if (backStackRecord.f1048a.f1152o.mo7442a()) {
            for (int size = backStackRecord.f1049b.size() - 1; size >= 0; size--) {
                m10135a(backStackRecord, backStackRecord.f1049b.get(size), sparseArray, true, z);
            }
        }
    }

    /* renamed from: a */
    public static boolean m10121a(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.mo10102a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static Object m10129a(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        Object m7547D;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            m7547D = fragment2.m7546E();
        } else {
            m7547D = fragment.m7547D();
        }
        return fragmentTransitionImpl.mo10082c(fragmentTransitionImpl.mo10087b(m7547D));
    }

    /* renamed from: a */
    public static Object m10128a(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object m7451r;
        if (fragment == null) {
            return null;
        }
        if (z) {
            m7451r = fragment.m7550A();
        } else {
            m7451r = fragment.m7451r();
        }
        return fragmentTransitionImpl.mo10087b(m7451r);
    }

    /* renamed from: a */
    public static void m10114a(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View m9607e = arrayMap.m9607e(size);
            if (collection.contains(ViewCompat.m9417p(m9607e))) {
                arrayList.add(m9607e);
            }
        }
    }

    /* renamed from: a */
    public static Object m10126a(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, C0176e c0176e, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object m10129a;
        ArrayMap<String, String> arrayMap2;
        Object obj3;
        Rect rect;
        Fragment fragment = c0176e.f1253a;
        Fragment fragment2 = c0176e.f1256d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = c0176e.f1254b;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            m10129a = null;
        } else {
            m10129a = m10129a(fragmentTransitionImpl, fragment, fragment2, z);
            arrayMap2 = arrayMap;
        }
        ArrayMap<String, View> m10111b = m10111b(fragmentTransitionImpl, arrayMap2, m10129a, c0176e);
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(m10111b.values());
            obj3 = m10129a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m10116a(fragment, fragment2, z, m10111b, true);
        if (obj3 != null) {
            rect = new Rect();
            fragmentTransitionImpl.mo10085b(obj3, view, arrayList);
            m10123a(fragmentTransitionImpl, obj3, obj2, m10111b, c0176e.f1257e, c0176e.f1258f);
            if (obj != null) {
                fragmentTransitionImpl.mo10101a(obj, rect);
            }
        } else {
            rect = null;
        }
        OneShotPreDrawListener.m10363a(viewGroup, new RunnableC0175d(fragmentTransitionImpl, arrayMap, obj3, c0176e, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    /* renamed from: a */
    public static ArrayMap<String, View> m10130a(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, C0176e c0176e) {
        SharedElementCallback m7450s;
        ArrayList<String> arrayList;
        String m10118a;
        Fragment fragment = c0176e.f1253a;
        View m7543H = fragment.m7543H();
        if (!arrayMap.isEmpty() && obj != null && m7543H != null) {
            ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
            fragmentTransitionImpl.m10089a((Map<String, View>) arrayMap2, m7543H);
            BackStackRecord backStackRecord = c0176e.f1255c;
            if (c0176e.f1254b) {
                m7450s = fragment.m7448u();
                arrayList = backStackRecord.f1065r;
            } else {
                m7450s = fragment.m7450s();
                arrayList = backStackRecord.f1066s;
            }
            if (arrayList != null) {
                arrayMap2.m9683a((Collection<?>) arrayList);
                arrayMap2.m9683a((Collection<?>) arrayMap.values());
            }
            if (m7450s != null) {
                m7450s.m10349a(arrayList, arrayMap2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view = arrayMap2.get(str);
                    if (view == null) {
                        String m10118a2 = m10118a(arrayMap, str);
                        if (m10118a2 != null) {
                            arrayMap.remove(m10118a2);
                        }
                    } else if (!str.equals(ViewCompat.m9417p(view)) && (m10118a = m10118a(arrayMap, str)) != null) {
                        arrayMap.put(m10118a, ViewCompat.m9417p(view));
                    }
                }
            } else {
                m10119a(arrayMap, arrayMap2);
            }
            return arrayMap2;
        }
        arrayMap.clear();
        return null;
    }

    /* renamed from: a */
    public static String m10118a(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.m9607e(i))) {
                return arrayMap.m9609c(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static View m10120a(ArrayMap<String, View> arrayMap, C0176e c0176e, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        BackStackRecord backStackRecord = c0176e.f1255c;
        if (obj == null || arrayMap == null || (arrayList = backStackRecord.f1065r) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = backStackRecord.f1065r.get(0);
        } else {
            str = backStackRecord.f1066s.get(0);
        }
        return arrayMap.get(str);
    }

    /* renamed from: a */
    public static void m10123a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        String str;
        ArrayList<String> arrayList = backStackRecord.f1065r;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            str = backStackRecord.f1066s.get(0);
        } else {
            str = backStackRecord.f1065r.get(0);
        }
        View view = arrayMap.get(str);
        fragmentTransitionImpl.mo10081c(obj, view);
        if (obj2 != null) {
            fragmentTransitionImpl.mo10081c(obj2, view);
        }
    }

    /* renamed from: a */
    public static void m10119a(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.m9607e(size))) {
                arrayMap.m9608d(size);
            }
        }
    }

    /* renamed from: a */
    public static void m10116a(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback m7450s;
        if (z) {
            m7450s = fragment2.m7450s();
        } else {
            m7450s = fragment.m7450s();
        }
        if (m7450s != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(arrayMap.m9609c(i));
                arrayList.add(arrayMap.m9607e(i));
            }
            if (z2) {
                m7450s.m10348b(arrayList2, arrayList, null);
            } else {
                m7450s.m10350a(arrayList2, arrayList, null);
            }
        }
    }

    /* renamed from: a */
    public static ArrayList<View> m10124a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View m7543H = fragment.m7543H();
            if (m7543H != null) {
                fragmentTransitionImpl.m10093a(arrayList2, m7543H);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            fragmentTransitionImpl.mo10096a(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    /* renamed from: a */
    public static void m10115a(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    /* renamed from: a */
    public static Object m10122a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.m7461l();
        } else {
            z2 = fragment.m7464k();
        }
        if (z2) {
            return fragmentTransitionImpl.mo10084b(obj2, obj, obj3);
        }
        return fragmentTransitionImpl.mo10098a(obj2, obj, obj3);
    }

    /* renamed from: a */
    public static void m10134a(BackStackRecord backStackRecord, SparseArray<C0176e> sparseArray, boolean z) {
        int size = backStackRecord.f1049b.size();
        for (int i = 0; i < size; i++) {
            m10135a(backStackRecord, backStackRecord.f1049b.get(i), sparseArray, false, z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0041, code lost:
        if (r10.f3497k != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0092, code lost:
        if (r10.f3465B == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0094, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00e7 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m10135a(p000a.p006b.p030g.p031a.BackStackRecord r16, p000a.p006b.p030g.p031a.BackStackRecord.C0141a r17, android.util.SparseArray<p000a.p006b.p030g.p031a.FragmentTransition.C0176e> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p030g.p031a.FragmentTransition.m10135a(a.b.g.a.c, a.b.g.a.c$a, android.util.SparseArray, boolean, boolean):void");
    }

    /* renamed from: a */
    public static C0176e m10131a(C0176e c0176e, SparseArray<C0176e> sparseArray, int i) {
        if (c0176e == null) {
            C0176e c0176e2 = new C0176e();
            sparseArray.put(i, c0176e2);
            return c0176e2;
        }
        return c0176e;
    }
}
