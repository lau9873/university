package p000a.p006b.p049h.p057f;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p065v4.app.Fragment;
import android.support.p067v7.preference.DialogPreference;
import android.support.p067v7.preference.EditTextPreference;
import android.support.p067v7.preference.ListPreference;
import android.support.p067v7.preference.Preference;
import android.support.p067v7.preference.PreferenceScreen;
import android.support.p067v7.preference.internal.AbstractMultiSelectListPreference;
import android.support.p067v7.widget.LinearLayoutManager;
import android.support.p067v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import p000a.p006b.p030g.p031a.DialogFragment;
import p000a.p006b.p049h.p057f.PreferenceManager;

/* renamed from: a.b.h.f.g */
/* loaded from: classes.dex */
public abstract class PreferenceFragmentCompat extends Fragment implements PreferenceManager.InterfaceC0396c, PreferenceManager.InterfaceC0394a, PreferenceManager.InterfaceC0395b, DialogPreference.InterfaceC0654a {

    /* renamed from: Z */
    public PreferenceManager f2140Z;

    /* renamed from: a0 */
    public RecyclerView f2141a0;

    /* renamed from: b0 */
    public boolean f2142b0;

    /* renamed from: c0 */
    public boolean f2143c0;

    /* renamed from: d0 */
    public Context f2144d0;

    /* renamed from: e0 */
    public int f2145e0 = C0402p.preference_list_fragment;

    /* renamed from: f0 */
    public final C0387c f2146f0 = new C0387c();

    /* renamed from: g0 */
    public Handler f2147g0 = new HandlerC0385a();

    /* renamed from: h0 */
    public final Runnable f2148h0 = new RunnableC0386b();

    /* renamed from: i0 */
    public Runnable f2149i0;

    /* compiled from: PreferenceFragmentCompat.java */
    /* renamed from: a.b.h.f.g$a */
    /* loaded from: classes.dex */
    public class HandlerC0385a extends Handler {
        public HandlerC0385a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            PreferenceFragmentCompat.this.m8869n0();
        }
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* renamed from: a.b.h.f.g$b */
    /* loaded from: classes.dex */
    public class RunnableC0386b implements Runnable {
        public RunnableC0386b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = PreferenceFragmentCompat.this.f2141a0;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* renamed from: a.b.h.f.g$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0388d {
        /* renamed from: a */
        boolean m8855a(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* renamed from: a.b.h.f.g$e */
    /* loaded from: classes.dex */
    public interface InterfaceC0389e {
        /* renamed from: a */
        boolean m8854a(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* renamed from: a.b.h.f.g$f */
    /* loaded from: classes.dex */
    public interface InterfaceC0390f {
        /* renamed from: a */
        boolean m8853a(PreferenceFragmentCompat preferenceFragmentCompat, PreferenceScreen preferenceScreen);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: W */
    public void mo7529W() {
        this.f2147g0.removeCallbacks(this.f2148h0);
        this.f2147g0.removeMessages(1);
        if (this.f2142b0) {
            m8860w0();
        }
        this.f2141a0 = null;
        super.mo7529W();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public View mo717a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray obtainStyledAttributes = this.f2144d0.obtainStyledAttributes(null, C0405s.PreferenceFragmentCompat, C0399m.preferenceFragmentCompatStyle, 0);
        this.f2145e0 = obtainStyledAttributes.getResourceId(C0405s.PreferenceFragmentCompat_android_layout, this.f2145e0);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0405s.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0405s.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z = obtainStyledAttributes.getBoolean(C0405s.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(this.f2144d0);
        View inflate = cloneInContext.inflate(this.f2145e0, viewGroup, false);
        View findViewById = inflate.findViewById(16908351);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById;
            RecyclerView m8871c = m8871c(cloneInContext, viewGroup2, bundle);
            if (m8871c != null) {
                this.f2141a0 = m8871c;
                m8871c.m6929a(this.f2146f0);
                m8874a(drawable);
                if (dimensionPixelSize != -1) {
                    m8870d(dimensionPixelSize);
                }
                this.f2146f0.m8856b(z);
                if (this.f2141a0.getParent() == null) {
                    viewGroup2.addView(this.f2141a0);
                }
                this.f2147g0.post(this.f2148h0);
                return inflate;
            }
            throw new RuntimeException("Could not create RecyclerView");
        }
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    /* renamed from: a */
    public abstract void mo1171a(Bundle bundle, String str);

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a0 */
    public void mo5376a0() {
        super.mo5376a0();
        this.f2140Z.m8832a((PreferenceManager.InterfaceC0396c) this);
        this.f2140Z.m8834a((PreferenceManager.InterfaceC0394a) this);
    }

    /* renamed from: b */
    public RecyclerView.AbstractC0711g m8873b(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: b0 */
    public void mo883b0() {
        super.mo883b0();
        this.f2140Z.m8832a((PreferenceManager.InterfaceC0396c) null);
        this.f2140Z.m8834a((PreferenceManager.InterfaceC0394a) null);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        TypedValue typedValue = new TypedValue();
        m7468j().getTheme().resolveAttribute(C0399m.preferenceTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i == 0) {
            i = C0404r.PreferenceThemeOverlay;
        }
        this.f2144d0 = new ContextThemeWrapper(m7468j(), i);
        this.f2140Z = new PreferenceManager(this.f2144d0);
        this.f2140Z.m8833a((PreferenceManager.InterfaceC0395b) this);
        mo1171a(bundle, m7454o() != null ? m7454o().getString("android.support.v7.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    /* renamed from: d */
    public void m8870d(int i) {
        this.f2146f0.m8859a(i);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: e */
    public void mo924e(Bundle bundle) {
        super.mo924e(bundle);
        PreferenceScreen m8866q0 = m8866q0();
        if (m8866q0 != null) {
            Bundle bundle2 = new Bundle();
            m8866q0.m7220d(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    /* renamed from: n0 */
    public void m8869n0() {
        PreferenceScreen m8866q0 = m8866q0();
        if (m8866q0 != null) {
            m8867p0().setAdapter(m8873b(m8866q0));
            m8866q0.mo7191A();
        }
        m8865r0();
    }

    /* renamed from: o0 */
    public Fragment m8868o0() {
        return null;
    }

    /* renamed from: p0 */
    public final RecyclerView m8867p0() {
        return this.f2141a0;
    }

    /* renamed from: q0 */
    public PreferenceScreen m8866q0() {
        return this.f2140Z.m8819g();
    }

    /* renamed from: r0 */
    public void m8865r0() {
    }

    /* renamed from: s0 */
    public RecyclerView.AbstractC0722o m8864s0() {
        return new LinearLayoutManager(m7468j());
    }

    /* renamed from: t0 */
    public void m8863t0() {
    }

    /* renamed from: u0 */
    public final void m8862u0() {
        if (this.f2147g0.hasMessages(1)) {
            return;
        }
        this.f2147g0.obtainMessage(1).sendToTarget();
    }

    /* renamed from: v0 */
    public final void m8861v0() {
        if (this.f2140Z == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    /* renamed from: w0 */
    public final void m8860w0() {
        PreferenceScreen m8866q0 = m8866q0();
        if (m8866q0 != null) {
            m8866q0.mo7190C();
        }
        m8863t0();
    }

    /* compiled from: PreferenceFragmentCompat.java */
    /* renamed from: a.b.h.f.g$c */
    /* loaded from: classes.dex */
    public class C0387c extends RecyclerView.AbstractC0721n {

        /* renamed from: a */
        public Drawable f2152a;

        /* renamed from: b */
        public int f2153b;

        /* renamed from: c */
        public boolean f2154c = true;

        public C0387c() {
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0721n
        /* renamed from: a */
        public void mo6712a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0702a0 c0702a0) {
            if (m8857a(view, recyclerView)) {
                rect.bottom = this.f2153b;
            }
        }

        @Override // android.support.p067v7.widget.RecyclerView.AbstractC0721n
        /* renamed from: b */
        public void mo6710b(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0702a0 c0702a0) {
            if (this.f2152a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (m8857a(childAt, recyclerView)) {
                    int y = ((int) childAt.getY()) + childAt.getHeight();
                    this.f2152a.setBounds(0, y, width, this.f2153b + y);
                    this.f2152a.draw(canvas);
                }
            }
        }

        /* renamed from: a */
        public final boolean m8857a(View view, RecyclerView recyclerView) {
            RecyclerView.AbstractC0708d0 m6881f = recyclerView.m6881f(view);
            if ((m6881f instanceof PreferenceViewHolder) && ((PreferenceViewHolder) m6881f).m8810D()) {
                boolean z = this.f2154c;
                int indexOfChild = recyclerView.indexOfChild(view);
                if (indexOfChild < recyclerView.getChildCount() - 1) {
                    RecyclerView.AbstractC0708d0 m6881f2 = recyclerView.m6881f(recyclerView.getChildAt(indexOfChild + 1));
                    return (m6881f2 instanceof PreferenceViewHolder) && ((PreferenceViewHolder) m6881f2).m8811C();
                }
                return z;
            }
            return false;
        }

        /* renamed from: b */
        public void m8856b(boolean z) {
            this.f2154c = z;
        }

        /* renamed from: a */
        public void m8858a(Drawable drawable) {
            if (drawable != null) {
                this.f2153b = drawable.getIntrinsicHeight();
            } else {
                this.f2153b = 0;
            }
            this.f2152a = drawable;
            PreferenceFragmentCompat.this.f2141a0.m6851v();
        }

        /* renamed from: a */
        public void m8859a(int i) {
            this.f2153b = i;
            PreferenceFragmentCompat.this.f2141a0.m6851v();
        }
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceManager.InterfaceC0394a
    /* renamed from: b */
    public void mo8816b(Preference preference) {
        DialogFragment m8892b;
        boolean m8855a = m8868o0() instanceof InterfaceC0388d ? ((InterfaceC0388d) m8868o0()).m8855a(this, preference) : false;
        if (!m8855a && (m7468j() instanceof InterfaceC0388d)) {
            m8855a = ((InterfaceC0388d) m7468j()).m8855a(this, preference);
        }
        if (!m8855a && m7447v().mo10231a("android.support.v14.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                m8892b = EditTextPreferenceDialogFragmentCompat.m8896b(preference.m7212j());
            } else if (preference instanceof ListPreference) {
                m8892b = ListPreferenceDialogFragmentCompat.m8894b(preference.m7212j());
            } else if (preference instanceof AbstractMultiSelectListPreference) {
                m8892b = MultiSelectListPreferenceDialogFragmentCompat.m8892b(preference.m7212j());
            } else {
                throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
            }
            m8892b.m7511a(this, 0);
            m8892b.mo5624a(m7447v(), "android.support.v14.preference.PreferenceFragment.DIALOG");
        }
    }

    /* renamed from: c */
    public void m8872c(PreferenceScreen preferenceScreen) {
        if (!this.f2140Z.m8828a(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        m8863t0();
        this.f2142b0 = true;
        if (this.f2143c0) {
            m8862u0();
        }
    }

    /* renamed from: c */
    public RecyclerView m8871c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (!this.f2144d0.getPackageManager().hasSystemFeature("android.hardware.type.automotive") || (recyclerView = (RecyclerView) viewGroup.findViewById(C0401o.recycler_view)) == null) {
            RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(C0402p.preference_recyclerview, viewGroup, false);
            recyclerView2.setLayoutManager(m8864s0());
            recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
            return recyclerView2;
        }
        return recyclerView;
    }

    /* renamed from: a */
    public void m8874a(Drawable drawable) {
        this.f2146f0.m8858a(drawable);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo715a(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen m8866q0;
        super.mo715a(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (m8866q0 = m8866q0()) != null) {
            m8866q0.m7226c(bundle2);
        }
        if (this.f2142b0) {
            m8869n0();
            Runnable runnable = this.f2149i0;
            if (runnable != null) {
                runnable.run();
                this.f2149i0 = null;
            }
        }
        this.f2143c0 = true;
    }

    /* renamed from: a */
    public void m8875a(int i, String str) {
        m8861v0();
        PreferenceScreen m8830a = this.f2140Z.m8830a(this.f2144d0, i, null);
        PreferenceScreen preferenceScreen = m8830a;
        if (str != null) {
            Preference m7182c = m8830a.m7182c((CharSequence) str);
            boolean z = m7182c instanceof PreferenceScreen;
            preferenceScreen = m7182c;
            if (!z) {
                throw new IllegalArgumentException("Preference object with key " + str + " is not a PreferenceScreen");
            }
        }
        m8872c((PreferenceScreen) preferenceScreen);
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceManager.InterfaceC0396c
    /* renamed from: a */
    public boolean mo8814a(Preference preference) {
        if (preference.m7215g() != null) {
            boolean m8854a = m8868o0() instanceof InterfaceC0389e ? ((InterfaceC0389e) m8868o0()).m8854a(this, preference) : false;
            return (m8854a || !(m7468j() instanceof InterfaceC0389e)) ? m8854a : ((InterfaceC0389e) m7468j()).m8854a(this, preference);
        }
        return false;
    }

    @Override // p000a.p006b.p049h.p057f.PreferenceManager.InterfaceC0395b
    /* renamed from: a */
    public void mo8815a(PreferenceScreen preferenceScreen) {
        if ((m8868o0() instanceof InterfaceC0390f ? ((InterfaceC0390f) m8868o0()).m8853a(this, preferenceScreen) : false) || !(m7468j() instanceof InterfaceC0390f)) {
            return;
        }
        ((InterfaceC0390f) m7468j()).m8853a(this, preferenceScreen);
    }

    @Override // android.support.p067v7.preference.DialogPreference.InterfaceC0654a
    /* renamed from: a */
    public Preference mo7270a(CharSequence charSequence) {
        PreferenceManager preferenceManager = this.f2140Z;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.m8827a(charSequence);
    }
}
