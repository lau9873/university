package a.b.g.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* compiled from: FragmentStatePagerAdapter.java */
/* loaded from: classes.dex */
public abstract class p extends a.b.g.k.q {

    /* renamed from: a  reason: collision with root package name */
    public final k f749a;

    /* renamed from: b  reason: collision with root package name */
    public q f750b = null;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Fragment.f> f751c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f752d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public Fragment f753e = null;

    public p(k kVar) {
        this.f749a = kVar;
    }

    @Override // a.b.g.k.q
    public Object a(ViewGroup viewGroup, int i2) {
        Fragment.f fVar;
        Fragment fragment;
        if (this.f752d.size() <= i2 || (fragment = this.f752d.get(i2)) == null) {
            if (this.f750b == null) {
                this.f750b = this.f749a.a();
            }
            Fragment b2 = b(i2);
            if (this.f751c.size() > i2 && (fVar = this.f751c.get(i2)) != null) {
                b2.a(fVar);
            }
            while (this.f752d.size() <= i2) {
                this.f752d.add(null);
            }
            b2.h(false);
            b2.j(false);
            this.f752d.set(i2, b2);
            this.f750b.a(viewGroup.getId(), b2);
            return b2;
        }
        return fragment;
    }

    public abstract Fragment b(int i2);

    @Override // a.b.g.k.q
    public void b(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    @Override // a.b.g.k.q
    public void b(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f753e;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.h(false);
                this.f753e.j(false);
            }
            fragment.h(true);
            fragment.j(true);
            this.f753e = fragment;
        }
    }

    @Override // a.b.g.k.q
    public Parcelable b() {
        Bundle bundle;
        if (this.f751c.size() > 0) {
            bundle = new Bundle();
            Fragment.f[] fVarArr = new Fragment.f[this.f751c.size()];
            this.f751c.toArray(fVarArr);
            bundle.putParcelableArray("states", fVarArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f752d.size(); i2++) {
            Fragment fragment = this.f752d.get(i2);
            if (fragment != null && fragment.K()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f749a.a(bundle, "f" + i2, fragment);
            }
        }
        return bundle;
    }

    @Override // a.b.g.k.q
    public void a(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f750b == null) {
            this.f750b = this.f749a.a();
        }
        while (this.f751c.size() <= i2) {
            this.f751c.add(null);
        }
        this.f751c.set(i2, fragment.K() ? this.f749a.a(fragment) : null);
        this.f752d.set(i2, null);
        this.f750b.a(fragment);
    }

    @Override // a.b.g.k.q
    public void a(ViewGroup viewGroup) {
        q qVar = this.f750b;
        if (qVar != null) {
            qVar.c();
            this.f750b = null;
        }
    }

    @Override // a.b.g.k.q
    public boolean a(View view, Object obj) {
        return ((Fragment) obj).H() == view;
    }

    @Override // a.b.g.k.q
    public void a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f751c.clear();
            this.f752d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f751c.add((Fragment.f) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a2 = this.f749a.a(bundle, str);
                    if (a2 != null) {
                        while (this.f752d.size() <= parseInt) {
                            this.f752d.add(null);
                        }
                        a2.h(false);
                        this.f752d.set(parseInt, a2);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
