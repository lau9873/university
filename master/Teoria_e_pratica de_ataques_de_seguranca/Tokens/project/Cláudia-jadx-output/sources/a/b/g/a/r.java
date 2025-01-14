package a.b.g.a;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f754a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: b  reason: collision with root package name */
    public static final t f755b;

    /* renamed from: c  reason: collision with root package name */
    public static final t f756c;

    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f757a;

        public a(ArrayList arrayList) {
            this.f757a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.a(this.f757a, 4);
        }
    }

    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f758a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t f759b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f760c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Fragment f761d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f762e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f763f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ArrayList f764g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f765h;

        public b(Object obj, t tVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f758a = obj;
            this.f759b = tVar;
            this.f760c = view;
            this.f761d = fragment;
            this.f762e = arrayList;
            this.f763f = arrayList2;
            this.f764g = arrayList3;
            this.f765h = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f758a;
            if (obj != null) {
                this.f759b.b(obj, this.f760c);
                this.f763f.addAll(r.a(this.f759b, this.f758a, this.f761d, this.f762e, this.f760c));
            }
            if (this.f764g != null) {
                if (this.f765h != null) {
                    ArrayList<View> arrayList = new ArrayList<>();
                    arrayList.add(this.f760c);
                    this.f759b.a(this.f765h, this.f764g, arrayList);
                }
                this.f764g.clear();
                this.f764g.add(this.f760c);
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f766a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Fragment f767b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f768c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a.b.g.j.a f769d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f770e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ t f771f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Rect f772g;

        public c(Fragment fragment, Fragment fragment2, boolean z, a.b.g.j.a aVar, View view, t tVar, Rect rect) {
            this.f766a = fragment;
            this.f767b = fragment2;
            this.f768c = z;
            this.f769d = aVar;
            this.f770e = view;
            this.f771f = tVar;
            this.f772g = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.a(this.f766a, this.f767b, this.f768c, (a.b.g.j.a<String, View>) this.f769d, false);
            View view = this.f770e;
            if (view != null) {
                this.f771f.a(view, this.f772g);
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f773a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a.b.g.j.a f774b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f775c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f776d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f777e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f778f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Fragment f779g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Fragment f780h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f781i;
        public final /* synthetic */ ArrayList j;
        public final /* synthetic */ Object k;
        public final /* synthetic */ Rect m;

        public d(t tVar, a.b.g.j.a aVar, Object obj, e eVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f773a = tVar;
            this.f774b = aVar;
            this.f775c = obj;
            this.f776d = eVar;
            this.f777e = arrayList;
            this.f778f = view;
            this.f779g = fragment;
            this.f780h = fragment2;
            this.f781i = z;
            this.j = arrayList2;
            this.k = obj2;
            this.m = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b.g.j.a<String, View> a2 = r.a(this.f773a, this.f774b, this.f775c, this.f776d);
            if (a2 != null) {
                this.f777e.addAll(a2.values());
                this.f777e.add(this.f778f);
            }
            r.a(this.f779g, this.f780h, this.f781i, a2, false);
            Object obj = this.f775c;
            if (obj != null) {
                this.f773a.b(obj, this.j, this.f777e);
                View a3 = r.a(a2, this.f776d, this.k, this.f781i);
                if (a3 != null) {
                    this.f773a.a(a3, this.m);
                }
            }
        }
    }

    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f782a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f783b;

        /* renamed from: c  reason: collision with root package name */
        public a.b.g.a.c f784c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f785d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f786e;

        /* renamed from: f  reason: collision with root package name */
        public a.b.g.a.c f787f;
    }

    static {
        f755b = Build.VERSION.SDK_INT >= 21 ? new s() : null;
        f756c = a();
    }

    public static t a() {
        try {
            return (t) Class.forName("a.b.f.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void b(l lVar, int i2, e eVar, View view, a.b.g.j.a<String, String> aVar) {
        Fragment fragment;
        Fragment fragment2;
        t a2;
        Object obj;
        ViewGroup viewGroup = lVar.o.a() ? (ViewGroup) lVar.o.a(i2) : null;
        if (viewGroup == null || (a2 = a((fragment2 = eVar.f785d), (fragment = eVar.f782a))) == null) {
            return;
        }
        boolean z = eVar.f783b;
        boolean z2 = eVar.f786e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        Object b3 = b(a2, viewGroup, view, aVar, eVar, arrayList2, arrayList, a3, b2);
        if (a3 == null && b3 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a4 = a(a2, obj, fragment2, arrayList2, view);
        ArrayList<View> a5 = a(a2, a3, fragment, arrayList, view);
        a(a5, 4);
        Object a6 = a(a2, a3, obj, b3, fragment, z);
        if (a6 != null) {
            a(a2, obj, fragment2, a4);
            ArrayList<String> a7 = a2.a(arrayList);
            a2.a(a6, a3, a5, obj, a4, b3, arrayList);
            a2.a(viewGroup, a6);
            a2.a(viewGroup, arrayList2, arrayList, a7, aVar);
            a(a5, 0);
            a2.b(b3, arrayList2, arrayList);
        }
    }

    public static void a(l lVar, ArrayList<a.b.g.a.c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z) {
        if (lVar.m < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i4 = i2; i4 < i3; i4++) {
            a.b.g.a.c cVar = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                b(cVar, sparseArray, z);
            } else {
                a(cVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(lVar.n.c());
            int size = sparseArray.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = sparseArray.keyAt(i5);
                a.b.g.j.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i2, i3);
                e eVar = (e) sparseArray.valueAt(i5);
                if (z) {
                    b(lVar, keyAt, eVar, view, a2);
                } else {
                    a(lVar, keyAt, eVar, view, a2);
                }
            }
        }
    }

    public static a.b.g.j.a<String, String> a(int i2, ArrayList<a.b.g.a.c> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        a.b.g.j.a<String, String> aVar = new a.b.g.j.a<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            a.b.g.a.c cVar = arrayList.get(i5);
            if (cVar.c(i2)) {
                boolean booleanValue = arrayList2.get(i5).booleanValue();
                ArrayList<String> arrayList5 = cVar.r;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = cVar.r;
                        arrayList4 = cVar.s;
                    } else {
                        ArrayList<String> arrayList6 = cVar.r;
                        arrayList3 = cVar.s;
                        arrayList4 = arrayList6;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = arrayList4.get(i6);
                        String str2 = arrayList3.get(i6);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static Object b(t tVar, Fragment fragment, boolean z) {
        Object t;
        if (fragment == null) {
            return null;
        }
        if (z) {
            t = fragment.C();
        } else {
            t = fragment.t();
        }
        return tVar.b(t);
    }

    public static Object b(t tVar, ViewGroup viewGroup, View view, a.b.g.j.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = eVar.f782a;
        Fragment fragment2 = eVar.f785d;
        if (fragment != null) {
            fragment.H().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = eVar.f783b;
        Object a2 = aVar.isEmpty() ? null : a(tVar, fragment, fragment2, z);
        a.b.g.j.a<String, View> b2 = b(tVar, aVar, a2, eVar);
        a.b.g.j.a<String, View> a3 = a(tVar, aVar, a2, eVar);
        if (aVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a3 != null) {
                a3.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, b2, aVar.keySet());
            a(arrayList2, a3, aVar.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            tVar.b(obj3, view, arrayList);
            a(tVar, obj3, obj2, b2, eVar.f786e, eVar.f787f);
            Rect rect2 = new Rect();
            View a4 = a(a3, eVar, obj, z);
            if (a4 != null) {
                tVar.a(obj, rect2);
            }
            rect = rect2;
            view2 = a4;
        } else {
            view2 = null;
            rect = null;
        }
        c0.a(viewGroup, new c(fragment, fragment2, z, a3, view2, tVar, rect));
        return obj3;
    }

    public static void a(t tVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.k && fragment.B && fragment.P) {
            fragment.g(true);
            tVar.a(obj, fragment.H(), arrayList);
            c0.a(fragment.I, new a(arrayList));
        }
    }

    public static void a(l lVar, int i2, e eVar, View view, a.b.g.j.a<String, String> aVar) {
        Fragment fragment;
        Fragment fragment2;
        t a2;
        Object obj;
        ViewGroup viewGroup = lVar.o.a() ? (ViewGroup) lVar.o.a(i2) : null;
        if (viewGroup == null || (a2 = a((fragment2 = eVar.f785d), (fragment = eVar.f782a))) == null) {
            return;
        }
        boolean z = eVar.f783b;
        boolean z2 = eVar.f786e;
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a4 = a(a2, viewGroup, view, aVar, eVar, arrayList, arrayList2, a3, b2);
        if (a3 == null && a4 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a5 = a(a2, obj, fragment2, arrayList, view);
        Object obj2 = (a5 == null || a5.isEmpty()) ? null : obj;
        a2.a(a3, view);
        Object a6 = a(a2, a3, obj2, a4, fragment, eVar.f783b);
        if (a6 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            a2.a(a6, a3, arrayList3, obj2, a5, a4, arrayList2);
            a(a2, viewGroup, fragment, view, arrayList2, a3, arrayList3, obj2, a5);
            a2.a((View) viewGroup, arrayList2, (Map<String, String>) aVar);
            a2.a(viewGroup, a6);
            a2.a(viewGroup, arrayList2, (Map<String, String>) aVar);
        }
    }

    public static a.b.g.j.a<String, View> b(t tVar, a.b.g.j.a<String, String> aVar, Object obj, e eVar) {
        e0 u;
        ArrayList<String> arrayList;
        if (!aVar.isEmpty() && obj != null) {
            Fragment fragment = eVar.f785d;
            a.b.g.j.a<String, View> aVar2 = new a.b.g.j.a<>();
            tVar.a((Map<String, View>) aVar2, fragment.H());
            a.b.g.a.c cVar = eVar.f787f;
            if (eVar.f786e) {
                u = fragment.s();
                arrayList = cVar.s;
            } else {
                u = fragment.u();
                arrayList = cVar.r;
            }
            aVar2.a((Collection<?>) arrayList);
            if (u != null) {
                u.a(arrayList, aVar2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view = aVar2.get(str);
                    if (view == null) {
                        aVar.remove(str);
                    } else if (!str.equals(a.b.g.k.u.p(view))) {
                        aVar.put(a.b.g.k.u.p(view), aVar.remove(str));
                    }
                }
            } else {
                aVar.a((Collection<?>) aVar2.keySet());
            }
            return aVar2;
        }
        aVar.clear();
        return null;
    }

    public static void a(t tVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        c0.a(viewGroup, new b(obj, tVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    public static t a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object t = fragment.t();
            if (t != null) {
                arrayList.add(t);
            }
            Object C = fragment.C();
            if (C != null) {
                arrayList.add(C);
            }
            Object E = fragment.E();
            if (E != null) {
                arrayList.add(E);
            }
        }
        if (fragment2 != null) {
            Object r = fragment2.r();
            if (r != null) {
                arrayList.add(r);
            }
            Object A = fragment2.A();
            if (A != null) {
                arrayList.add(A);
            }
            Object D = fragment2.D();
            if (D != null) {
                arrayList.add(D);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        t tVar = f755b;
        if (tVar != null && a(tVar, arrayList)) {
            return f755b;
        }
        t tVar2 = f756c;
        if (tVar2 != null && a(tVar2, arrayList)) {
            return f756c;
        }
        if (f755b == null && f756c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static void b(a.b.g.a.c cVar, SparseArray<e> sparseArray, boolean z) {
        if (cVar.f635a.o.a()) {
            for (int size = cVar.f636b.size() - 1; size >= 0; size--) {
                a(cVar, cVar.f636b.get(size), sparseArray, true, z);
            }
        }
    }

    public static boolean a(t tVar, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!tVar.a(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static Object a(t tVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object D;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            D = fragment2.E();
        } else {
            D = fragment.D();
        }
        return tVar.c(tVar.b(D));
    }

    public static Object a(t tVar, Fragment fragment, boolean z) {
        Object r;
        if (fragment == null) {
            return null;
        }
        if (z) {
            r = fragment.A();
        } else {
            r = fragment.r();
        }
        return tVar.b(r);
    }

    public static void a(ArrayList<View> arrayList, a.b.g.j.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View e2 = aVar.e(size);
            if (collection.contains(a.b.g.k.u.p(e2))) {
                arrayList.add(e2);
            }
        }
    }

    public static Object a(t tVar, ViewGroup viewGroup, View view, a.b.g.j.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object a2;
        a.b.g.j.a<String, String> aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = eVar.f782a;
        Fragment fragment2 = eVar.f785d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = eVar.f783b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            a2 = null;
        } else {
            a2 = a(tVar, fragment, fragment2, z);
            aVar2 = aVar;
        }
        a.b.g.j.a<String, View> b2 = b(tVar, aVar2, a2, eVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(b2.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj3 != null) {
            rect = new Rect();
            tVar.b(obj3, view, arrayList);
            a(tVar, obj3, obj2, b2, eVar.f786e, eVar.f787f);
            if (obj != null) {
                tVar.a(obj, rect);
            }
        } else {
            rect = null;
        }
        c0.a(viewGroup, new d(tVar, aVar, obj3, eVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    public static a.b.g.j.a<String, View> a(t tVar, a.b.g.j.a<String, String> aVar, Object obj, e eVar) {
        e0 s;
        ArrayList<String> arrayList;
        String a2;
        Fragment fragment = eVar.f782a;
        View H = fragment.H();
        if (!aVar.isEmpty() && obj != null && H != null) {
            a.b.g.j.a<String, View> aVar2 = new a.b.g.j.a<>();
            tVar.a((Map<String, View>) aVar2, H);
            a.b.g.a.c cVar = eVar.f784c;
            if (eVar.f783b) {
                s = fragment.u();
                arrayList = cVar.r;
            } else {
                s = fragment.s();
                arrayList = cVar.s;
            }
            if (arrayList != null) {
                aVar2.a((Collection<?>) arrayList);
                aVar2.a((Collection<?>) aVar.values());
            }
            if (s != null) {
                s.a(arrayList, aVar2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view = aVar2.get(str);
                    if (view == null) {
                        String a3 = a(aVar, str);
                        if (a3 != null) {
                            aVar.remove(a3);
                        }
                    } else if (!str.equals(a.b.g.k.u.p(view)) && (a2 = a(aVar, str)) != null) {
                        aVar.put(a2, a.b.g.k.u.p(view));
                    }
                }
            } else {
                a(aVar, aVar2);
            }
            return aVar2;
        }
        aVar.clear();
        return null;
    }

    public static String a(a.b.g.j.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(aVar.e(i2))) {
                return aVar.c(i2);
            }
        }
        return null;
    }

    public static View a(a.b.g.j.a<String, View> aVar, e eVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        a.b.g.a.c cVar = eVar.f784c;
        if (obj == null || aVar == null || (arrayList = cVar.r) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = cVar.r.get(0);
        } else {
            str = cVar.s.get(0);
        }
        return aVar.get(str);
    }

    public static void a(t tVar, Object obj, Object obj2, a.b.g.j.a<String, View> aVar, boolean z, a.b.g.a.c cVar) {
        String str;
        ArrayList<String> arrayList = cVar.r;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            str = cVar.s.get(0);
        } else {
            str = cVar.r.get(0);
        }
        View view = aVar.get(str);
        tVar.c(obj, view);
        if (obj2 != null) {
            tVar.c(obj2, view);
        }
    }

    public static void a(a.b.g.j.a<String, String> aVar, a.b.g.j.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.e(size))) {
                aVar.d(size);
            }
        }
    }

    public static void a(Fragment fragment, Fragment fragment2, boolean z, a.b.g.j.a<String, View> aVar, boolean z2) {
        e0 s;
        if (z) {
            s = fragment2.s();
        } else {
            s = fragment.s();
        }
        if (s != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(aVar.c(i2));
                arrayList.add(aVar.e(i2));
            }
            if (z2) {
                s.b(arrayList2, arrayList, null);
            } else {
                s.a(arrayList2, arrayList, null);
            }
        }
    }

    public static ArrayList<View> a(t tVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View H = fragment.H();
            if (H != null) {
                tVar.a(arrayList2, H);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            tVar.a(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    public static void a(ArrayList<View> arrayList, int i2) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i2);
        }
    }

    public static Object a(t tVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.l();
        } else {
            z2 = fragment.k();
        }
        if (z2) {
            return tVar.b(obj2, obj, obj3);
        }
        return tVar.a(obj2, obj, obj3);
    }

    public static void a(a.b.g.a.c cVar, SparseArray<e> sparseArray, boolean z) {
        int size = cVar.f636b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(cVar, cVar.f636b.get(i2), sparseArray, false, z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0041, code lost:
        if (r10.k != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0092, code lost:
        if (r10.B == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0094, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00e7 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(a.b.g.a.c r16, a.b.g.a.c.a r17, android.util.SparseArray<a.b.g.a.r.e> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.g.a.r.a(a.b.g.a.c, a.b.g.a.c$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static e a(e eVar, SparseArray<e> sparseArray, int i2) {
        if (eVar == null) {
            e eVar2 = new e();
            sparseArray.put(i2, eVar2);
            return eVar2;
        }
        return eVar;
    }
}
