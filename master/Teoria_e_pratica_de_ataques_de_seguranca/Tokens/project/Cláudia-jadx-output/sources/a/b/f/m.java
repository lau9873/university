package a.b.f;

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
/* compiled from: Transition.java */
/* loaded from: classes.dex */
public abstract class m implements Cloneable {
    public static final int[] H = {2, 1, 3, 4};
    public static final g I = new a();
    public static ThreadLocal<a.b.g.j.a<Animator, d>> J = new ThreadLocal<>();
    public p D;
    public e E;
    public a.b.g.j.a<String, String> F;
    public ArrayList<s> u;
    public ArrayList<s> v;

    /* renamed from: a  reason: collision with root package name */
    public String f557a = getClass().getName();

    /* renamed from: b  reason: collision with root package name */
    public long f558b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f559c = -1;

    /* renamed from: d  reason: collision with root package name */
    public TimeInterpolator f560d = null;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Integer> f561e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<View> f562f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f563g = null;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Class> f564h = null;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<Integer> f565i = null;
    public ArrayList<View> j = null;
    public ArrayList<Class> k = null;
    public ArrayList<String> m = null;
    public ArrayList<Integer> n = null;
    public ArrayList<View> o = null;
    public ArrayList<Class> p = null;
    public t q = new t();
    public t r = new t();
    public q s = null;
    public int[] t = H;
    public boolean w = false;
    public ArrayList<Animator> x = new ArrayList<>();
    public int y = 0;
    public boolean z = false;
    public boolean A = false;
    public ArrayList<f> B = null;
    public ArrayList<Animator> C = new ArrayList<>();
    public g G = I;

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static class a extends g {
        @Override // a.b.f.g
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.b.g.j.a f566a;

        public b(a.b.g.j.a aVar) {
            this.f566a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f566a.remove(animator);
            m.this.x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            m.this.x.add(animator);
        }
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m.this.a();
            animator.removeListener(this);
        }
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public View f569a;

        /* renamed from: b  reason: collision with root package name */
        public String f570b;

        /* renamed from: c  reason: collision with root package name */
        public s f571c;

        /* renamed from: d  reason: collision with root package name */
        public l0 f572d;

        /* renamed from: e  reason: collision with root package name */
        public m f573e;

        public d(View view, String str, m mVar, l0 l0Var, s sVar) {
            this.f569a = view;
            this.f570b = str;
            this.f571c = sVar;
            this.f572d = l0Var;
            this.f573e = mVar;
        }
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static abstract class e {
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public interface f {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);
    }

    public static a.b.g.j.a<Animator, d> r() {
        a.b.g.j.a<Animator, d> aVar = J.get();
        if (aVar == null) {
            a.b.g.j.a<Animator, d> aVar2 = new a.b.g.j.a<>();
            J.set(aVar2);
            return aVar2;
        }
        return aVar;
    }

    public m a(long j) {
        this.f559c = j;
        return this;
    }

    public Animator a(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    public abstract void a(s sVar);

    public long b() {
        return this.f559c;
    }

    public s c(View view, boolean z) {
        q qVar = this.s;
        if (qVar != null) {
            return qVar.c(view, z);
        }
        return (z ? this.q : this.r).f589a.get(view);
    }

    public abstract void c(s sVar);

    public TimeInterpolator d() {
        return this.f560d;
    }

    public void e(View view) {
        if (this.z) {
            if (!this.A) {
                a.b.g.j.a<Animator, d> r = r();
                int size = r.size();
                l0 d2 = d0.d(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    d e2 = r.e(i2);
                    if (e2.f569a != null && d2.equals(e2.f572d)) {
                        a.b.f.a.b(r.c(i2));
                    }
                }
                ArrayList<f> arrayList = this.B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.B.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((f) arrayList2.get(i3)).d(this);
                    }
                }
            }
            this.z = false;
        }
    }

    public g f() {
        return this.G;
    }

    public p g() {
        return this.D;
    }

    public long h() {
        return this.f558b;
    }

    public List<Integer> i() {
        return this.f561e;
    }

    public List<String> l() {
        return this.f563g;
    }

    public List<Class> m() {
        return this.f564h;
    }

    public List<View> n() {
        return this.f562f;
    }

    public String[] o() {
        return null;
    }

    public void p() {
        q();
        a.b.g.j.a<Animator, d> r = r();
        Iterator<Animator> it = this.C.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (r.containsKey(next)) {
                q();
                a(next, r);
            }
        }
        this.C.clear();
        a();
    }

    public void q() {
        if (this.y == 0) {
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).c(this);
                }
            }
            this.A = false;
        }
        this.y++;
    }

    public String toString() {
        return a("");
    }

    public m a(TimeInterpolator timeInterpolator) {
        this.f560d = timeInterpolator;
        return this;
    }

    public m b(long j) {
        this.f558b = j;
        return this;
    }

    /* renamed from: clone */
    public m m4clone() {
        try {
            m mVar = (m) super.clone();
            mVar.C = new ArrayList<>();
            mVar.q = new t();
            mVar.r = new t();
            mVar.u = null;
            mVar.v = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public m d(View view) {
        this.f562f.remove(view);
        return this;
    }

    public final void a(a.b.g.j.a<View, s> aVar, a.b.g.j.a<View, s> aVar2, a.b.g.j.f<View> fVar, a.b.g.j.f<View> fVar2) {
        View b2;
        int c2 = fVar.c();
        for (int i2 = 0; i2 < c2; i2++) {
            View c3 = fVar.c(i2);
            if (c3 != null && b(c3) && (b2 = fVar2.b(fVar.a(i2))) != null && b(b2)) {
                s sVar = aVar.get(c3);
                s sVar2 = aVar2.get(b2);
                if (sVar != null && sVar2 != null) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(c3);
                    aVar2.remove(b2);
                }
            }
        }
    }

    public final void b(a.b.g.j.a<View, s> aVar, a.b.g.j.a<View, s> aVar2) {
        s remove;
        View view;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c2 = aVar.c(size);
            if (c2 != null && b(c2) && (remove = aVar2.remove(c2)) != null && (view = remove.f587b) != null && b(view)) {
                this.u.add(aVar.d(size));
                this.v.add(remove);
            }
        }
    }

    public void c(View view) {
        if (this.A) {
            return;
        }
        a.b.g.j.a<Animator, d> r = r();
        int size = r.size();
        l0 d2 = d0.d(view);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            d e2 = r.e(i2);
            if (e2.f569a != null && d2.equals(e2.f572d)) {
                a.b.f.a.a(r.c(i2));
            }
        }
        ArrayList<f> arrayList = this.B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.B.clone();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ((f) arrayList2.get(i3)).a(this);
            }
        }
        this.z = true;
    }

    public boolean b(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f565i;
        if (arrayList3 == null || !arrayList3.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList4 = this.j;
            if (arrayList4 == null || !arrayList4.contains(view)) {
                ArrayList<Class> arrayList5 = this.k;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.k.get(i2).isInstance(view)) {
                            return false;
                        }
                    }
                }
                if (this.m == null || a.b.g.k.u.p(view) == null || !this.m.contains(a.b.g.k.u.p(view))) {
                    if ((this.f561e.size() == 0 && this.f562f.size() == 0 && (((arrayList = this.f564h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f563g) == null || arrayList2.isEmpty()))) || this.f561e.contains(Integer.valueOf(id)) || this.f562f.contains(view)) {
                        return true;
                    }
                    ArrayList<String> arrayList6 = this.f563g;
                    if (arrayList6 == null || !arrayList6.contains(a.b.g.k.u.p(view))) {
                        if (this.f564h != null) {
                            for (int i3 = 0; i3 < this.f564h.size(); i3++) {
                                if (this.f564h.get(i3).isInstance(view)) {
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

    public final void a(a.b.g.j.a<View, s> aVar, a.b.g.j.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && b(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && b(view)) {
                s sVar = aVar.get(valueAt);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    public String e() {
        return this.f557a;
    }

    public e c() {
        return this.E;
    }

    public final void a(a.b.g.j.a<View, s> aVar, a.b.g.j.a<View, s> aVar2, a.b.g.j.a<String, View> aVar3, a.b.g.j.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View e2 = aVar3.e(i2);
            if (e2 != null && b(e2) && (view = aVar4.get(aVar3.c(i2))) != null && b(view)) {
                s sVar = aVar.get(e2);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.u.add(sVar);
                    this.v.add(sVar2);
                    aVar.remove(e2);
                    aVar2.remove(view);
                }
            }
        }
    }

    public s b(View view, boolean z) {
        q qVar = this.s;
        if (qVar != null) {
            return qVar.b(view, z);
        }
        ArrayList<s> arrayList = z ? this.u : this.v;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            s sVar = arrayList.get(i3);
            if (sVar == null) {
                return null;
            }
            if (sVar.f587b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            return (z ? this.v : this.u).get(i2);
        }
        return null;
    }

    public final void a(a.b.g.j.a<View, s> aVar, a.b.g.j.a<View, s> aVar2) {
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            s e2 = aVar.e(i2);
            if (b(e2.f587b)) {
                this.u.add(e2);
                this.v.add(null);
            }
        }
        for (int i3 = 0; i3 < aVar2.size(); i3++) {
            s e3 = aVar2.e(i3);
            if (b(e3.f587b)) {
                this.v.add(e3);
                this.u.add(null);
            }
        }
    }

    public m b(f fVar) {
        ArrayList<f> arrayList = this.B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.B.size() == 0) {
            this.B = null;
        }
        return this;
    }

    public void b(s sVar) {
        String[] a2;
        if (this.D == null || sVar.f586a.isEmpty() || (a2 = this.D.a()) == null) {
            return;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= a2.length) {
                z = true;
                break;
            } else if (!sVar.f586a.containsKey(a2[i2])) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            return;
        }
        this.D.a(sVar);
    }

    public final void a(t tVar, t tVar2) {
        a.b.g.j.a<View, s> aVar = new a.b.g.j.a<>(tVar.f589a);
        a.b.g.j.a<View, s> aVar2 = new a.b.g.j.a<>(tVar2.f589a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.t;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 == 1) {
                    b(aVar, aVar2);
                } else if (i3 == 2) {
                    a(aVar, aVar2, tVar.f592d, tVar2.f592d);
                } else if (i3 == 3) {
                    a(aVar, aVar2, tVar.f590b, tVar2.f590b);
                } else if (i3 == 4) {
                    a(aVar, aVar2, tVar.f591c, tVar2.f591c);
                }
                i2++;
            } else {
                a(aVar, aVar2);
                return;
            }
        }
    }

    public void a(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        Animator a2;
        int i2;
        int i3;
        View view;
        Animator animator;
        s sVar;
        Animator animator2;
        s sVar2;
        a.b.g.j.a<Animator, d> r = r();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            s sVar3 = arrayList.get(i4);
            s sVar4 = arrayList2.get(i4);
            if (sVar3 != null && !sVar3.f588c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f588c.contains(this)) {
                sVar4 = null;
            }
            if (sVar3 != null || sVar4 != null) {
                if ((sVar3 == null || sVar4 == null || a(sVar3, sVar4)) && (a2 = a(viewGroup, sVar3, sVar4)) != null) {
                    if (sVar4 != null) {
                        view = sVar4.f587b;
                        String[] o = o();
                        if (view == null || o == null || o.length <= 0) {
                            i2 = size;
                            i3 = i4;
                            animator2 = a2;
                            sVar2 = null;
                        } else {
                            sVar2 = new s();
                            sVar2.f587b = view;
                            i2 = size;
                            s sVar5 = tVar2.f589a.get(view);
                            if (sVar5 != null) {
                                int i5 = 0;
                                while (i5 < o.length) {
                                    sVar2.f586a.put(o[i5], sVar5.f586a.get(o[i5]));
                                    i5++;
                                    i4 = i4;
                                    sVar5 = sVar5;
                                }
                            }
                            i3 = i4;
                            int size2 = r.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    animator2 = a2;
                                    break;
                                }
                                d dVar = r.get(r.c(i6));
                                if (dVar.f571c != null && dVar.f569a == view && dVar.f570b.equals(e()) && dVar.f571c.equals(sVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        }
                        animator = animator2;
                        sVar = sVar2;
                    } else {
                        i2 = size;
                        i3 = i4;
                        view = sVar3.f587b;
                        animator = a2;
                        sVar = null;
                    }
                    if (animator != null) {
                        p pVar = this.D;
                        if (pVar != null) {
                            long a3 = pVar.a(viewGroup, this, sVar3, sVar4);
                            sparseIntArray.put(this.C.size(), (int) a3);
                            j = Math.min(a3, j);
                        }
                        r.put(animator, new d(view, e(), this, d0.d(viewGroup), sVar));
                        this.C.add(animator);
                        j = j;
                    }
                    i4 = i3 + 1;
                    size = i2;
                }
            }
            i2 = size;
            i3 = i4;
            i4 = i3 + 1;
            size = i2;
        }
        if (j != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator3 = this.C.get(sparseIntArray.keyAt(i7));
                animator3.setStartDelay((sparseIntArray.valueAt(i7) - j) + animator3.getStartDelay());
            }
        }
    }

    public final void a(Animator animator, a.b.g.j.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            a(animator);
        }
    }

    public m a(View view) {
        this.f562f.add(view);
        return this;
    }

    public void a(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        a.b.g.j.a<String, String> aVar;
        a(z);
        if ((this.f561e.size() <= 0 && this.f562f.size() <= 0) || (((arrayList = this.f563g) != null && !arrayList.isEmpty()) || ((arrayList2 = this.f564h) != null && !arrayList2.isEmpty()))) {
            a((View) viewGroup, z);
        } else {
            for (int i2 = 0; i2 < this.f561e.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.f561e.get(i2).intValue());
                if (findViewById != null) {
                    s sVar = new s();
                    sVar.f587b = findViewById;
                    if (z) {
                        c(sVar);
                    } else {
                        a(sVar);
                    }
                    sVar.f588c.add(this);
                    b(sVar);
                    if (z) {
                        a(this.q, findViewById, sVar);
                    } else {
                        a(this.r, findViewById, sVar);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f562f.size(); i3++) {
                View view = this.f562f.get(i3);
                s sVar2 = new s();
                sVar2.f587b = view;
                if (z) {
                    c(sVar2);
                } else {
                    a(sVar2);
                }
                sVar2.f588c.add(this);
                b(sVar2);
                if (z) {
                    a(this.q, view, sVar2);
                } else {
                    a(this.r, view, sVar2);
                }
            }
        }
        if (z || (aVar = this.F) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList3.add(this.q.f592d.remove(this.F.c(i4)));
        }
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = (View) arrayList3.get(i5);
            if (view2 != null) {
                this.q.f592d.put(this.F.e(i5), view2);
            }
        }
    }

    public static void a(t tVar, View view, s sVar) {
        tVar.f589a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f590b.indexOfKey(id) >= 0) {
                tVar.f590b.put(id, null);
            } else {
                tVar.f590b.put(id, view);
            }
        }
        String p = a.b.g.k.u.p(view);
        if (p != null) {
            if (tVar.f592d.containsKey(p)) {
                tVar.f592d.put(p, null);
            } else {
                tVar.f592d.put(p, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f591c.c(itemIdAtPosition) >= 0) {
                    View b2 = tVar.f591c.b(itemIdAtPosition);
                    if (b2 != null) {
                        a.b.g.k.u.b(b2, false);
                        tVar.f591c.c(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                a.b.g.k.u.b(view, true);
                tVar.f591c.c(itemIdAtPosition, view);
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            this.q.f589a.clear();
            this.q.f590b.clear();
            this.q.f591c.a();
            return;
        }
        this.r.f589a.clear();
        this.r.f590b.clear();
        this.r.f591c.a();
    }

    public final void a(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f565i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class> arrayList3 = this.k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.k.get(i2).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s();
                    sVar.f587b = view;
                    if (z) {
                        c(sVar);
                    } else {
                        a(sVar);
                    }
                    sVar.f588c.add(this);
                    b(sVar);
                    if (z) {
                        a(this.q, view, sVar);
                    } else {
                        a(this.r, view, sVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.n;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.o;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class> arrayList6 = this.p;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    if (this.p.get(i3).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                a(viewGroup.getChildAt(i4), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(ViewGroup viewGroup) {
        d dVar;
        this.u = new ArrayList<>();
        this.v = new ArrayList<>();
        a(this.q, this.r);
        a.b.g.j.a<Animator, d> r = r();
        int size = r.size();
        l0 d2 = d0.d(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator c2 = r.c(i2);
            if (c2 != null && (dVar = r.get(c2)) != null && dVar.f569a != null && d2.equals(dVar.f572d)) {
                s sVar = dVar.f571c;
                View view = dVar.f569a;
                s c3 = c(view, true);
                s b2 = b(view, true);
                if (!(c3 == null && b2 == null) && dVar.f573e.a(sVar, b2)) {
                    if (!c2.isRunning() && !c2.isStarted()) {
                        r.remove(c2);
                    } else {
                        c2.cancel();
                    }
                }
            }
        }
        a(viewGroup, this.q, this.r, this.u, this.v);
        p();
    }

    public boolean a(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] o = o();
        if (o != null) {
            for (String str : o) {
                if (!a(sVar, sVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : sVar.f586a.keySet()) {
            if (a(sVar, sVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    public static boolean a(s sVar, s sVar2, String str) {
        Object obj = sVar.f586a.get(str);
        Object obj2 = sVar2.f586a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public void a(Animator animator) {
        if (animator == null) {
            a();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (h() >= 0) {
            animator.setStartDelay(h());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new c());
        animator.start();
    }

    public void a() {
        this.y--;
        if (this.y == 0) {
            ArrayList<f> arrayList = this.B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.B.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((f) arrayList2.get(i2)).b(this);
                }
            }
            for (int i3 = 0; i3 < this.q.f591c.c(); i3++) {
                View c2 = this.q.f591c.c(i3);
                if (c2 != null) {
                    a.b.g.k.u.b(c2, false);
                }
            }
            for (int i4 = 0; i4 < this.r.f591c.c(); i4++) {
                View c3 = this.r.f591c.c(i4);
                if (c3 != null) {
                    a.b.g.k.u.b(c3, false);
                }
            }
            this.A = true;
        }
    }

    public m a(f fVar) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(fVar);
        return this;
    }

    public void a(g gVar) {
        if (gVar == null) {
            this.G = I;
        } else {
            this.G = gVar;
        }
    }

    public void a(e eVar) {
        this.E = eVar;
    }

    public void a(p pVar) {
        this.D = pVar;
    }

    public String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f559c != -1) {
            str2 = str2 + "dur(" + this.f559c + ") ";
        }
        if (this.f558b != -1) {
            str2 = str2 + "dly(" + this.f558b + ") ";
        }
        if (this.f560d != null) {
            str2 = str2 + "interp(" + this.f560d + ") ";
        }
        if (this.f561e.size() > 0 || this.f562f.size() > 0) {
            String str3 = str2 + "tgts(";
            if (this.f561e.size() > 0) {
                String str4 = str3;
                for (int i2 = 0; i2 < this.f561e.size(); i2++) {
                    if (i2 > 0) {
                        str4 = str4 + ", ";
                    }
                    str4 = str4 + this.f561e.get(i2);
                }
                str3 = str4;
            }
            if (this.f562f.size() > 0) {
                for (int i3 = 0; i3 < this.f562f.size(); i3++) {
                    if (i3 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.f562f.get(i3);
                }
            }
            return str3 + ")";
        }
        return str2;
    }
}
