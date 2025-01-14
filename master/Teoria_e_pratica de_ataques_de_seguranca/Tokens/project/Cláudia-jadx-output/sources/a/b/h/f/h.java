package a.b.h.f;

import a.b.g.k.u;
import a.b.h.f.j;
import a.b.h.i.c;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* compiled from: PreferenceGroupAdapter.java */
/* loaded from: classes.dex */
public class h extends RecyclerView.g<l> implements Preference.c, PreferenceGroup.c {

    /* renamed from: c  reason: collision with root package name */
    public PreferenceGroup f1416c;

    /* renamed from: d  reason: collision with root package name */
    public List<Preference> f1417d;

    /* renamed from: e  reason: collision with root package name */
    public List<Preference> f1418e;

    /* renamed from: f  reason: collision with root package name */
    public List<c> f1419f;

    /* renamed from: g  reason: collision with root package name */
    public c f1420g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f1421h;

    /* renamed from: i  reason: collision with root package name */
    public a.b.h.f.a f1422i;
    public Runnable j;

    /* compiled from: PreferenceGroupAdapter.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.e();
        }
    }

    /* compiled from: PreferenceGroupAdapter.java */
    /* loaded from: classes.dex */
    public class b extends c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f1424a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f1425b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j.d f1426c;

        public b(h hVar, List list, List list2, j.d dVar) {
            this.f1424a = list;
            this.f1425b = list2;
            this.f1426c = dVar;
        }

        @Override // a.b.h.i.c.b
        public int a() {
            return this.f1425b.size();
        }

        @Override // a.b.h.i.c.b
        public int b() {
            return this.f1424a.size();
        }

        @Override // a.b.h.i.c.b
        public boolean a(int i2, int i3) {
            return this.f1426c.a((Preference) this.f1424a.get(i2), (Preference) this.f1425b.get(i3));
        }

        @Override // a.b.h.i.c.b
        public boolean b(int i2, int i3) {
            return this.f1426c.b((Preference) this.f1424a.get(i2), (Preference) this.f1425b.get(i3));
        }
    }

    /* compiled from: PreferenceGroupAdapter.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f1427a;

        /* renamed from: b  reason: collision with root package name */
        public int f1428b;

        /* renamed from: c  reason: collision with root package name */
        public String f1429c;

        public c() {
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f1427a == cVar.f1427a && this.f1428b == cVar.f1428b && TextUtils.equals(this.f1429c, cVar.f1429c);
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f1427a) * 31) + this.f1428b) * 31) + this.f1429c.hashCode();
        }

        public c(c cVar) {
            this.f1427a = cVar.f1427a;
            this.f1428b = cVar.f1428b;
            this.f1429c = cVar.f1429c;
        }
    }

    public h(PreferenceGroup preferenceGroup) {
        this(preferenceGroup, new Handler());
    }

    public final void a(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.N();
        int L = preferenceGroup.L();
        for (int i2 = 0; i2 < L; i2++) {
            Preference g2 = preferenceGroup.g(i2);
            list.add(g2);
            c(g2);
            if (g2 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) g2;
                if (preferenceGroup2.M()) {
                    a(list, preferenceGroup2);
                }
            }
            g2.a((Preference.c) this);
        }
    }

    public final void c(Preference preference) {
        c a2 = a(preference, (c) null);
        if (this.f1419f.contains(a2)) {
            return;
        }
        this.f1419f.add(a2);
    }

    public void e() {
        for (Preference preference : this.f1418e) {
            preference.a((Preference.c) null);
        }
        ArrayList<Preference> arrayList = new ArrayList(this.f1418e.size());
        a(arrayList, this.f1416c);
        List<Preference> b2 = this.f1422i.b(this.f1416c);
        List<Preference> list = this.f1417d;
        this.f1417d = b2;
        this.f1418e = arrayList;
        j o = this.f1416c.o();
        if (o != null && o.e() != null) {
            a.b.h.i.c.a(new b(this, list, b2, o.e())).a(this);
        } else {
            d();
        }
        for (Preference preference2 : arrayList) {
            preference2.b();
        }
    }

    public Preference g(int i2) {
        if (i2 < 0 || i2 >= a()) {
            return null;
        }
        return this.f1417d.get(i2);
    }

    public h(PreferenceGroup preferenceGroup, Handler handler) {
        this.f1420g = new c();
        this.j = new a();
        this.f1416c = preferenceGroup;
        this.f1421h = handler;
        this.f1422i = new a.b.h.f.a(preferenceGroup, this);
        this.f1416c.a((Preference.c) this);
        this.f1417d = new ArrayList();
        this.f1418e = new ArrayList();
        this.f1419f = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.f1416c;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            a(((PreferenceScreen) preferenceGroup2).O());
        } else {
            a(true);
        }
        e();
    }

    @Override // android.support.v7.widget.RecyclerView.g
    public long b(int i2) {
        if (c()) {
            return g(i2).h();
        }
        return -1L;
    }

    @Override // android.support.v7.widget.RecyclerView.g
    public int c(int i2) {
        this.f1420g = a(g(i2), this.f1420g);
        int indexOf = this.f1419f.indexOf(this.f1420g);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.f1419f.size();
        this.f1419f.add(new c(this.f1420g));
        return size;
    }

    @Override // android.support.v7.preference.Preference.c
    public void b(Preference preference) {
        int indexOf = this.f1417d.indexOf(preference);
        if (indexOf != -1) {
            a(indexOf, preference);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.support.v7.widget.RecyclerView.g
    public l b(ViewGroup viewGroup, int i2) {
        c cVar = this.f1419f.get(i2);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, s.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(s.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = a.b.g.b.b.c(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(cVar.f1427a, viewGroup, false);
        if (inflate.getBackground() == null) {
            u.a(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            int i3 = cVar.f1428b;
            if (i3 != 0) {
                from.inflate(i3, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new l(inflate);
    }

    public final c a(Preference preference, c cVar) {
        if (cVar == null) {
            cVar = new c();
        }
        cVar.f1429c = preference.getClass().getName();
        cVar.f1427a = preference.k();
        cVar.f1428b = preference.s();
        return cVar;
    }

    @Override // android.support.v7.widget.RecyclerView.g
    public int a() {
        return this.f1417d.size();
    }

    @Override // android.support.v7.preference.Preference.c
    public void a(Preference preference) {
        this.f1421h.removeCallbacks(this.j);
        this.f1421h.post(this.j);
    }

    @Override // android.support.v7.widget.RecyclerView.g
    /* renamed from: a */
    public void b(l lVar, int i2) {
        g(i2).a(lVar);
    }
}
