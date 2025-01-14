package a.b.h.f;

import a.b.h.f.j;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.preference.DialogPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: PreferenceFragmentCompat.java */
/* loaded from: classes.dex */
public abstract class g extends Fragment implements j.c, j.a, j.b, DialogPreference.a {
    public j Z;
    public RecyclerView a0;
    public boolean b0;
    public boolean c0;
    public Context d0;
    public int e0 = p.preference_list_fragment;
    public final c f0 = new c();
    public Handler g0 = new a();
    public final Runnable h0 = new b();
    public Runnable i0;

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            g.this.n0();
        }
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = g.this.a0;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public interface d {
        boolean a(g gVar, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public interface e {
        boolean a(g gVar, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public interface f {
        boolean a(g gVar, PreferenceScreen preferenceScreen);
    }

    @Override // android.support.v4.app.Fragment
    public void W() {
        this.g0.removeCallbacks(this.h0);
        this.g0.removeMessages(1);
        if (this.b0) {
            w0();
        }
        this.a0 = null;
        super.W();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray obtainStyledAttributes = this.d0.obtainStyledAttributes(null, s.PreferenceFragmentCompat, m.preferenceFragmentCompatStyle, 0);
        this.e0 = obtainStyledAttributes.getResourceId(s.PreferenceFragmentCompat_android_layout, this.e0);
        Drawable drawable = obtainStyledAttributes.getDrawable(s.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(s.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z = obtainStyledAttributes.getBoolean(s.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(this.d0);
        View inflate = cloneInContext.inflate(this.e0, viewGroup, false);
        View findViewById = inflate.findViewById(16908351);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById;
            RecyclerView c2 = c(cloneInContext, viewGroup2, bundle);
            if (c2 != null) {
                this.a0 = c2;
                c2.a(this.f0);
                a(drawable);
                if (dimensionPixelSize != -1) {
                    d(dimensionPixelSize);
                }
                this.f0.b(z);
                if (this.a0.getParent() == null) {
                    viewGroup2.addView(this.a0);
                }
                this.g0.post(this.h0);
                return inflate;
            }
            throw new RuntimeException("Could not create RecyclerView");
        }
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    public abstract void a(Bundle bundle, String str);

    @Override // android.support.v4.app.Fragment
    public void a0() {
        super.a0();
        this.Z.a((j.c) this);
        this.Z.a((j.a) this);
    }

    public RecyclerView.g b(PreferenceScreen preferenceScreen) {
        return new h(preferenceScreen);
    }

    @Override // android.support.v4.app.Fragment
    public void b0() {
        super.b0();
        this.Z.a((j.c) null);
        this.Z.a((j.a) null);
    }

    @Override // android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        TypedValue typedValue = new TypedValue();
        j().getTheme().resolveAttribute(m.preferenceTheme, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = r.PreferenceThemeOverlay;
        }
        this.d0 = new ContextThemeWrapper(j(), i2);
        this.Z = new j(this.d0);
        this.Z.a((j.b) this);
        a(bundle, o() != null ? o().getString("android.support.v7.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    public void d(int i2) {
        this.f0.a(i2);
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        PreferenceScreen q0 = q0();
        if (q0 != null) {
            Bundle bundle2 = new Bundle();
            q0.d(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    public void n0() {
        PreferenceScreen q0 = q0();
        if (q0 != null) {
            p0().setAdapter(b(q0));
            q0.A();
        }
        r0();
    }

    public Fragment o0() {
        return null;
    }

    public final RecyclerView p0() {
        return this.a0;
    }

    public PreferenceScreen q0() {
        return this.Z.g();
    }

    public void r0() {
    }

    public RecyclerView.o s0() {
        return new LinearLayoutManager(j());
    }

    public void t0() {
    }

    public final void u0() {
        if (this.g0.hasMessages(1)) {
            return;
        }
        this.g0.obtainMessage(1).sendToTarget();
    }

    public final void v0() {
        if (this.Z == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    public final void w0() {
        PreferenceScreen q0 = q0();
        if (q0 != null) {
            q0.C();
        }
        t0();
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* loaded from: classes.dex */
    public class c extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        public Drawable f1412a;

        /* renamed from: b  reason: collision with root package name */
        public int f1413b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1414c = true;

        public c() {
        }

        @Override // android.support.v7.widget.RecyclerView.n
        public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            if (a(view, recyclerView)) {
                rect.bottom = this.f1413b;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.n
        public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            if (this.f1412a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (a(childAt, recyclerView)) {
                    int y = ((int) childAt.getY()) + childAt.getHeight();
                    this.f1412a.setBounds(0, y, width, this.f1413b + y);
                    this.f1412a.draw(canvas);
                }
            }
        }

        public final boolean a(View view, RecyclerView recyclerView) {
            RecyclerView.d0 f2 = recyclerView.f(view);
            if ((f2 instanceof l) && ((l) f2).D()) {
                boolean z = this.f1414c;
                int indexOfChild = recyclerView.indexOfChild(view);
                if (indexOfChild < recyclerView.getChildCount() - 1) {
                    RecyclerView.d0 f3 = recyclerView.f(recyclerView.getChildAt(indexOfChild + 1));
                    return (f3 instanceof l) && ((l) f3).C();
                }
                return z;
            }
            return false;
        }

        public void b(boolean z) {
            this.f1414c = z;
        }

        public void a(Drawable drawable) {
            if (drawable != null) {
                this.f1413b = drawable.getIntrinsicHeight();
            } else {
                this.f1413b = 0;
            }
            this.f1412a = drawable;
            g.this.a0.v();
        }

        public void a(int i2) {
            this.f1413b = i2;
            g.this.a0.v();
        }
    }

    @Override // a.b.h.f.j.a
    public void b(Preference preference) {
        a.b.g.a.f b2;
        boolean a2 = o0() instanceof d ? ((d) o0()).a(this, preference) : false;
        if (!a2 && (j() instanceof d)) {
            a2 = ((d) j()).a(this, preference);
        }
        if (!a2 && v().a("android.support.v14.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                b2 = a.b.h.f.b.b(preference.j());
            } else if (preference instanceof ListPreference) {
                b2 = a.b.h.f.c.b(preference.j());
            } else if (preference instanceof AbstractMultiSelectListPreference) {
                b2 = a.b.h.f.d.b(preference.j());
            } else {
                throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
            }
            b2.a(this, 0);
            b2.a(v(), "android.support.v14.preference.PreferenceFragment.DIALOG");
        }
    }

    public void c(PreferenceScreen preferenceScreen) {
        if (!this.Z.a(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        t0();
        this.b0 = true;
        if (this.c0) {
            u0();
        }
    }

    public RecyclerView c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (!this.d0.getPackageManager().hasSystemFeature("android.hardware.type.automotive") || (recyclerView = (RecyclerView) viewGroup.findViewById(o.recycler_view)) == null) {
            RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(p.preference_recyclerview, viewGroup, false);
            recyclerView2.setLayoutManager(s0());
            recyclerView2.setAccessibilityDelegateCompat(new k(recyclerView2));
            return recyclerView2;
        }
        return recyclerView;
    }

    public void a(Drawable drawable) {
        this.f0.a(drawable);
    }

    @Override // android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen q0;
        super.a(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (q0 = q0()) != null) {
            q0.c(bundle2);
        }
        if (this.b0) {
            n0();
            Runnable runnable = this.i0;
            if (runnable != null) {
                runnable.run();
                this.i0 = null;
            }
        }
        this.c0 = true;
    }

    public void a(int i2, String str) {
        v0();
        PreferenceScreen a2 = this.Z.a(this.d0, i2, null);
        PreferenceScreen preferenceScreen = a2;
        if (str != null) {
            Preference c2 = a2.c((CharSequence) str);
            boolean z = c2 instanceof PreferenceScreen;
            preferenceScreen = c2;
            if (!z) {
                throw new IllegalArgumentException("Preference object with key " + str + " is not a PreferenceScreen");
            }
        }
        c((PreferenceScreen) preferenceScreen);
    }

    @Override // a.b.h.f.j.c
    public boolean a(Preference preference) {
        if (preference.g() != null) {
            boolean a2 = o0() instanceof e ? ((e) o0()).a(this, preference) : false;
            return (a2 || !(j() instanceof e)) ? a2 : ((e) j()).a(this, preference);
        }
        return false;
    }

    @Override // a.b.h.f.j.b
    public void a(PreferenceScreen preferenceScreen) {
        if ((o0() instanceof f ? ((f) o0()).a(this, preferenceScreen) : false) || !(j() instanceof f)) {
            return;
        }
        ((f) j()).a(this, preferenceScreen);
    }

    @Override // android.support.v7.preference.DialogPreference.a
    public Preference a(CharSequence charSequence) {
        j jVar = this.Z;
        if (jVar == null) {
            return null;
        }
        return jVar.a(charSequence);
    }
}
