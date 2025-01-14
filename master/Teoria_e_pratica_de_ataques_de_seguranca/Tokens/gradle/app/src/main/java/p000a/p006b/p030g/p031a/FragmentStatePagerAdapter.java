package p000a.p006b.p030g.p031a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p065v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import p000a.p006b.p030g.p045k.PagerAdapter;

/* renamed from: a.b.g.a.p */
/* loaded from: classes.dex */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {

    /* renamed from: a */
    public final FragmentManager f1217a;

    /* renamed from: b */
    public FragmentTransaction f1218b = null;

    /* renamed from: c */
    public ArrayList<Fragment.C0606f> f1219c = new ArrayList<>();

    /* renamed from: d */
    public ArrayList<Fragment> f1220d = new ArrayList<>();

    /* renamed from: e */
    public Fragment f1221e = null;

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f1217a = fragmentManager;
    }

    @Override // p000a.p006b.p030g.p045k.PagerAdapter
    /* renamed from: a */
    public Object mo9472a(ViewGroup viewGroup, int i) {
        Fragment.C0606f c0606f;
        Fragment fragment;
        if (this.f1220d.size() <= i || (fragment = this.f1220d.get(i)) == null) {
            if (this.f1218b == null) {
                this.f1218b = this.f1217a.mo10264a();
            }
            Fragment mo1192b = mo1192b(i);
            if (this.f1219c.size() > i && (c0606f = this.f1219c.get(i)) != null) {
                mo1192b.m7512a(c0606f);
            }
            while (this.f1220d.size() <= i) {
                this.f1220d.add(null);
            }
            mo1192b.m7474h(false);
            mo1192b.m7466j(false);
            this.f1220d.set(i, mo1192b);
            this.f1218b.mo10144a(viewGroup.getId(), mo1192b);
            return mo1192b;
        }
        return fragment;
    }

    /* renamed from: b */
    public abstract Fragment mo1192b(int i);

    @Override // p000a.p006b.p030g.p045k.PagerAdapter
    /* renamed from: b */
    public void mo9468b(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    @Override // p000a.p006b.p030g.p045k.PagerAdapter
    /* renamed from: b */
    public void mo9467b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f1221e;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.m7474h(false);
                this.f1221e.m7466j(false);
            }
            fragment.m7474h(true);
            fragment.m7466j(true);
            this.f1221e = fragment;
        }
    }

    @Override // p000a.p006b.p030g.p045k.PagerAdapter
    /* renamed from: b */
    public Parcelable mo9469b() {
        Bundle bundle;
        if (this.f1219c.size() > 0) {
            bundle = new Bundle();
            Fragment.C0606f[] c0606fArr = new Fragment.C0606f[this.f1219c.size()];
            this.f1219c.toArray(c0606fArr);
            bundle.putParcelableArray("states", c0606fArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.f1220d.size(); i++) {
            Fragment fragment = this.f1220d.get(i);
            if (fragment != null && fragment.m7540K()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f1217a.mo10247a(bundle, "f" + i, fragment);
            }
        }
        return bundle;
    }

    @Override // p000a.p006b.p030g.p045k.PagerAdapter
    /* renamed from: a */
    public void mo9471a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f1218b == null) {
            this.f1218b = this.f1217a.mo10264a();
        }
        while (this.f1219c.size() <= i) {
            this.f1219c.add(null);
        }
        this.f1219c.set(i, fragment.m7540K() ? this.f1217a.mo10245a(fragment) : null);
        this.f1220d.set(i, null);
        this.f1218b.mo10143a(fragment);
    }

    @Override // p000a.p006b.p030g.p045k.PagerAdapter
    /* renamed from: a */
    public void mo9473a(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f1218b;
        if (fragmentTransaction != null) {
            fragmentTransaction.mo10138c();
            this.f1218b = null;
        }
    }

    @Override // p000a.p006b.p030g.p045k.PagerAdapter
    /* renamed from: a */
    public boolean mo9474a(View view, Object obj) {
        return ((Fragment) obj).m7543H() == view;
    }

    @Override // p000a.p006b.p030g.p045k.PagerAdapter
    /* renamed from: a */
    public void mo9475a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f1219c.clear();
            this.f1220d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f1219c.add((Fragment.C0606f) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment mo10248a = this.f1217a.mo10248a(bundle, str);
                    if (mo10248a != null) {
                        while (this.f1220d.size() <= parseInt) {
                            this.f1220d.add(null);
                        }
                        mo10248a.m7474h(false);
                        this.f1220d.set(parseInt, mo10248a);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
