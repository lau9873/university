package a.b.f;

import a.b.f.m;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* compiled from: FragmentTransitionSupport.java */
/* loaded from: classes.dex */
public class e extends a.b.g.a.t {

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    public class a extends m.e {
        public a(e eVar, Rect rect) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    public class b implements m.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f514a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f515b;

        public b(e eVar, View view, ArrayList arrayList) {
            this.f514a = view;
            this.f515b = arrayList;
        }

        @Override // a.b.f.m.f
        public void a(m mVar) {
        }

        @Override // a.b.f.m.f
        public void b(m mVar) {
            mVar.b(this);
            this.f514a.setVisibility(8);
            int size = this.f515b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.f515b.get(i2)).setVisibility(0);
            }
        }

        @Override // a.b.f.m.f
        public void c(m mVar) {
        }

        @Override // a.b.f.m.f
        public void d(m mVar) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    public class c implements m.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f516a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f517b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f518c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f519d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f520e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f521f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f516a = obj;
            this.f517b = arrayList;
            this.f518c = obj2;
            this.f519d = arrayList2;
            this.f520e = obj3;
            this.f521f = arrayList3;
        }

        @Override // a.b.f.m.f
        public void a(m mVar) {
        }

        @Override // a.b.f.m.f
        public void b(m mVar) {
        }

        @Override // a.b.f.m.f
        public void c(m mVar) {
            Object obj = this.f516a;
            if (obj != null) {
                e.this.a(obj, this.f517b, (ArrayList<View>) null);
            }
            Object obj2 = this.f518c;
            if (obj2 != null) {
                e.this.a(obj2, this.f519d, (ArrayList<View>) null);
            }
            Object obj3 = this.f520e;
            if (obj3 != null) {
                e.this.a(obj3, this.f521f, (ArrayList<View>) null);
            }
        }

        @Override // a.b.f.m.f
        public void d(m mVar) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* loaded from: classes.dex */
    public class d extends m.e {
        public d(e eVar, Rect rect) {
        }
    }

    @Override // a.b.g.a.t
    public boolean a(Object obj) {
        return obj instanceof m;
    }

    @Override // a.b.g.a.t
    public Object b(Object obj) {
        if (obj != null) {
            return ((m) obj).m4clone();
        }
        return null;
    }

    @Override // a.b.g.a.t
    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.a((m) obj);
        return qVar;
    }

    @Override // a.b.g.a.t
    public void a(Object obj, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        if (mVar == null) {
            return;
        }
        int i2 = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int s = qVar.s();
            while (i2 < s) {
                a(qVar.a(i2), arrayList);
                i2++;
            }
        } else if (a(mVar) || !a.b.g.a.t.a((List) mVar.n())) {
        } else {
            int size = arrayList.size();
            while (i2 < size) {
                mVar.a(arrayList.get(i2));
                i2++;
            }
        }
    }

    @Override // a.b.g.a.t
    public void b(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        List<View> n = qVar.n();
        n.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.b.g.a.t.a(n, arrayList.get(i2));
        }
        n.add(view);
        arrayList.add(view);
        a(qVar, arrayList);
    }

    @Override // a.b.g.a.t
    public void c(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            a(view, rect);
            ((m) obj).a(new a(this, rect));
        }
    }

    @Override // a.b.g.a.t
    public Object b(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.a((m) obj);
        }
        if (obj2 != null) {
            qVar.a((m) obj2);
        }
        if (obj3 != null) {
            qVar.a((m) obj3);
        }
        return qVar;
    }

    public static boolean a(m mVar) {
        return (a.b.g.a.t.a((List) mVar.i()) && a.b.g.a.t.a((List) mVar.l()) && a.b.g.a.t.a((List) mVar.m())) ? false : true;
    }

    @Override // a.b.g.a.t
    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.n().clear();
            qVar.n().addAll(arrayList2);
            a((Object) qVar, arrayList, arrayList2);
        }
    }

    @Override // a.b.g.a.t
    public void a(Object obj, View view, ArrayList<View> arrayList) {
        ((m) obj).a(new b(this, view, arrayList));
    }

    @Override // a.b.g.a.t
    public Object a(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        m mVar3 = (m) obj3;
        if (mVar != null && mVar2 != null) {
            q qVar = new q();
            qVar.a(mVar);
            qVar.a(mVar2);
            qVar.b(1);
            mVar = qVar;
        } else if (mVar == null) {
            mVar = mVar2 != null ? mVar2 : null;
        }
        if (mVar3 != null) {
            q qVar2 = new q();
            if (mVar != null) {
                qVar2.a(mVar);
            }
            qVar2.a(mVar3);
            return qVar2;
        }
        return mVar;
    }

    @Override // a.b.g.a.t
    public void b(Object obj, View view) {
        if (obj != null) {
            ((m) obj).d(view);
        }
    }

    @Override // a.b.g.a.t
    public void a(ViewGroup viewGroup, Object obj) {
        o.a(viewGroup, (m) obj);
    }

    @Override // a.b.g.a.t
    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((m) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // a.b.g.a.t
    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        m mVar = (m) obj;
        int i2 = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int s = qVar.s();
            while (i2 < s) {
                a((Object) qVar.a(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!a(mVar)) {
            List<View> n = mVar.n();
            if (n.size() == arrayList.size() && n.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i2 < size) {
                    mVar.a(arrayList2.get(i2));
                    i2++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    mVar.d(arrayList.get(size2));
                }
            }
        }
    }

    @Override // a.b.g.a.t
    public void a(Object obj, View view) {
        if (obj != null) {
            ((m) obj).a(view);
        }
    }

    @Override // a.b.g.a.t
    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((m) obj).a(new d(this, rect));
        }
    }
}
