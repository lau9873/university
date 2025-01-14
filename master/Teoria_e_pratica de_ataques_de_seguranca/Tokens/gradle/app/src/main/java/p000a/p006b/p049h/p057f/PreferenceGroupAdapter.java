package p000a.p006b.p049h.p057f;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.p067v7.preference.Preference;
import android.support.p067v7.preference.PreferenceGroup;
import android.support.p067v7.preference.PreferenceScreen;
import android.support.p067v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p057f.PreferenceManager;
import p000a.p006b.p049h.p060i.DiffUtil;

/* renamed from: a.b.h.f.h */
/* loaded from: classes.dex */
public class PreferenceGroupAdapter extends RecyclerView.AbstractC0711g<PreferenceViewHolder> implements Preference.InterfaceC0663c, PreferenceGroup.InterfaceC0668c {

    /* renamed from: c */
    public PreferenceGroup f2156c;

    /* renamed from: d */
    public List<Preference> f2157d;

    /* renamed from: e */
    public List<Preference> f2158e;

    /* renamed from: f */
    public List<C0393c> f2159f;

    /* renamed from: g */
    public C0393c f2160g;

    /* renamed from: h */
    public Handler f2161h;

    /* renamed from: i */
    public CollapsiblePreferenceGroupController f2162i;

    /* renamed from: j */
    public Runnable f2163j;

    /* compiled from: PreferenceGroupAdapter.java */
    /* renamed from: a.b.h.f.h$a */
    /* loaded from: classes.dex */
    public class RunnableC0391a implements Runnable {
        public RunnableC0391a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PreferenceGroupAdapter.this.m8848e();
        }
    }

    /* compiled from: PreferenceGroupAdapter.java */
    /* renamed from: a.b.h.f.h$b */
    /* loaded from: classes.dex */
    public class C0392b extends DiffUtil.AbstractC0409b {

        /* renamed from: a */
        public final /* synthetic */ List f2165a;

        /* renamed from: b */
        public final /* synthetic */ List f2166b;

        /* renamed from: c */
        public final /* synthetic */ PreferenceManager.AbstractC0397d f2167c;

        public C0392b(PreferenceGroupAdapter preferenceGroupAdapter, List list, List list2, PreferenceManager.AbstractC0397d abstractC0397d) {
            this.f2165a = list;
            this.f2166b = list2;
            this.f2167c = abstractC0397d;
        }

        @Override // p000a.p006b.p049h.p060i.DiffUtil.AbstractC0409b
        /* renamed from: a */
        public int mo8801a() {
            return this.f2166b.size();
        }

        @Override // p000a.p006b.p049h.p060i.DiffUtil.AbstractC0409b
        /* renamed from: b */
        public int mo8799b() {
            return this.f2165a.size();
        }

        @Override // p000a.p006b.p049h.p060i.DiffUtil.AbstractC0409b
        /* renamed from: a */
        public boolean mo8800a(int i, int i2) {
            return this.f2167c.m8813a((Preference) this.f2165a.get(i), (Preference) this.f2166b.get(i2));
        }

        @Override // p000a.p006b.p049h.p060i.DiffUtil.AbstractC0409b
        /* renamed from: b */
        public boolean mo8798b(int i, int i2) {
            return this.f2167c.m8812b((Preference) this.f2165a.get(i), (Preference) this.f2166b.get(i2));
        }
    }

    /* compiled from: PreferenceGroupAdapter.java */
    /* renamed from: a.b.h.f.h$c */
    /* loaded from: classes.dex */
    public static class C0393c {

        /* renamed from: a */
        public int f2168a;

        /* renamed from: b */
        public int f2169b;

        /* renamed from: c */
        public String f2170c;

        public C0393c() {
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0393c) {
                C0393c c0393c = (C0393c) obj;
                return this.f2168a == c0393c.f2168a && this.f2169b == c0393c.f2169b && TextUtils.equals(this.f2170c, c0393c.f2170c);
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f2168a) * 31) + this.f2169b) * 31) + this.f2170c.hashCode();
        }

        public C0393c(C0393c c0393c) {
            this.f2168a = c0393c.f2168a;
            this.f2169b = c0393c.f2169b;
            this.f2170c = c0393c.f2170c;
        }
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this(preferenceGroup, new Handler());
    }

    /* renamed from: a */
    public final void m8850a(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.m7186N();
        int m7187L = preferenceGroup.m7187L();
        for (int i = 0; i < m7187L; i++) {
            Preference m7177g = preferenceGroup.m7177g(i);
            list.add(m7177g);
            m8849c(m7177g);
            if (m7177g instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) m7177g;
                if (preferenceGroup2.mo7174M()) {
                    m8850a(list, preferenceGroup2);
                }
            }
            m7177g.m7247a((Preference.InterfaceC0663c) this);
        }
    }

    /* renamed from: c */
    public final void m8849c(Preference preference) {
        C0393c m8851a = m8851a(preference, (C0393c) null);
        if (this.f2159f.contains(m8851a)) {
            return;
        }
        this.f2159f.add(m8851a);
    }

    /* renamed from: e */
    public void m8848e() {
        for (Preference preference : this.f2158e) {
            preference.m7247a((Preference.InterfaceC0663c) null);
        }
        ArrayList<Preference> arrayList = new ArrayList(this.f2158e.size());
        m8850a(arrayList, this.f2156c);
        List<Preference> m8899b = this.f2162i.m8899b(this.f2156c);
        List<Preference> list = this.f2157d;
        this.f2157d = m8899b;
        this.f2158e = arrayList;
        PreferenceManager m7207o = this.f2156c.m7207o();
        if (m7207o != null && m7207o.m8821e() != null) {
            DiffUtil.m8805a(new C0392b(this, list, m8899b, m7207o.m8821e())).m8792a(this);
        } else {
            m6750d();
        }
        for (Preference preference2 : arrayList) {
            preference2.m7235b();
        }
    }

    /* renamed from: g */
    public Preference m8847g(int i) {
        if (i < 0 || i >= mo747a()) {
            return null;
        }
        return this.f2157d.get(i);
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup, Handler handler) {
        this.f2160g = new C0393c();
        this.f2163j = new RunnableC0391a();
        this.f2156c = preferenceGroup;
        this.f2161h = handler;
        this.f2162i = new CollapsiblePreferenceGroupController(preferenceGroup, this);
        this.f2156c.m7247a((Preference.InterfaceC0663c) this);
        this.f2157d = new ArrayList();
        this.f2158e = new ArrayList();
        this.f2159f = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.f2156c;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            m6759a(((PreferenceScreen) preferenceGroup2).m7173O());
        } else {
            m6759a(true);
        }
        m8848e();
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
    /* renamed from: b */
    public long mo6757b(int i) {
        if (m6753c()) {
            return m8847g(i).mo7214h();
        }
        return -1L;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
    /* renamed from: c */
    public int mo739c(int i) {
        this.f2160g = m8851a(m8847g(i), this.f2160g);
        int indexOf = this.f2159f.indexOf(this.f2160g);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.f2159f.size();
        this.f2159f.add(new C0393c(this.f2160g));
        return size;
    }

    @Override // android.support.p067v7.preference.Preference.InterfaceC0663c
    /* renamed from: b */
    public void mo7195b(Preference preference) {
        int indexOf = this.f2157d.indexOf(preference);
        if (indexOf != -1) {
            m6766a(indexOf, preference);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
    /* renamed from: b */
    public PreferenceViewHolder mo742b(ViewGroup viewGroup, int i) {
        C0393c c0393c = this.f2159f.get(i);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, C0405s.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0405s.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = ContextCompat.m10016c(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(c0393c.f2168a, viewGroup, false);
        if (inflate.getBackground() == null) {
            ViewCompat.m9447a(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            int i2 = c0393c.f2169b;
            if (i2 != 0) {
                from.inflate(i2, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(inflate);
    }

    /* renamed from: a */
    public final C0393c m8851a(Preference preference, C0393c c0393c) {
        if (c0393c == null) {
            c0393c = new C0393c();
        }
        c0393c.f2170c = preference.getClass().getName();
        c0393c.f2168a = preference.m7211k();
        c0393c.f2169b = preference.m7203s();
        return c0393c;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
    /* renamed from: a */
    public int mo747a() {
        return this.f2157d.size();
    }

    @Override // android.support.p067v7.preference.Preference.InterfaceC0663c
    /* renamed from: a */
    public void mo7196a(Preference preference) {
        this.f2161h.removeCallbacks(this.f2163j);
        this.f2161h.post(this.f2163j);
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0711g
    /* renamed from: a */
    public void mo743b(PreferenceViewHolder preferenceViewHolder, int i) {
        m8847g(i).mo7167a(preferenceViewHolder);
    }
}
