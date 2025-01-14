package android.support.p067v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;
import p000a.p006b.p049h.p057f.C0399m;
import p000a.p006b.p049h.p057f.C0401o;
import p000a.p006b.p049h.p057f.C0402p;
import p000a.p006b.p049h.p057f.C0405s;
import p000a.p006b.p049h.p057f.PreferenceDataStore;
import p000a.p006b.p049h.p057f.PreferenceManager;
import p000a.p006b.p049h.p057f.PreferenceViewHolder;

/* renamed from: android.support.v7.preference.Preference */
/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: A */
    public boolean f3846A;

    /* renamed from: B */
    public boolean f3847B;

    /* renamed from: C */
    public boolean f3848C;

    /* renamed from: D */
    public boolean f3849D;

    /* renamed from: E */
    public boolean f3850E;

    /* renamed from: F */
    public boolean f3851F;

    /* renamed from: G */
    public int f3852G;

    /* renamed from: H */
    public int f3853H;

    /* renamed from: I */
    public InterfaceC0663c f3854I;

    /* renamed from: J */
    public List<Preference> f3855J;

    /* renamed from: K */
    public PreferenceGroup f3856K;

    /* renamed from: L */
    public boolean f3857L;

    /* renamed from: M */
    public final View.OnClickListener f3858M;

    /* renamed from: a */
    public Context f3859a;

    /* renamed from: b */
    public PreferenceManager f3860b;

    /* renamed from: c */
    public PreferenceDataStore f3861c;

    /* renamed from: d */
    public long f3862d;

    /* renamed from: e */
    public boolean f3863e;

    /* renamed from: f */
    public InterfaceC0664d f3864f;

    /* renamed from: g */
    public InterfaceC0665e f3865g;

    /* renamed from: h */
    public int f3866h;

    /* renamed from: i */
    public int f3867i;

    /* renamed from: j */
    public CharSequence f3868j;

    /* renamed from: k */
    public CharSequence f3869k;

    /* renamed from: m */
    public int f3870m;

    /* renamed from: n */
    public Drawable f3871n;

    /* renamed from: o */
    public String f3872o;

    /* renamed from: p */
    public Intent f3873p;

    /* renamed from: q */
    public String f3874q;

    /* renamed from: r */
    public Bundle f3875r;

    /* renamed from: s */
    public boolean f3876s;

    /* renamed from: t */
    public boolean f3877t;

    /* renamed from: u */
    public boolean f3878u;

    /* renamed from: v */
    public String f3879v;

    /* renamed from: w */
    public Object f3880w;

    /* renamed from: x */
    public boolean f3881x;

    /* renamed from: y */
    public boolean f3882y;

    /* renamed from: z */
    public boolean f3883z;

    /* renamed from: android.support.v7.preference.Preference$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0660a implements View.OnClickListener {
        public View$OnClickListenerC0660a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.mo7166a(view);
        }
    }

    /* renamed from: android.support.v7.preference.Preference$b */
    /* loaded from: classes.dex */
    public static class C0661b extends AbsSavedState {
        public static final Parcelable.Creator<C0661b> CREATOR = new C0662a();

        /* renamed from: android.support.v7.preference.Preference$b$a */
        /* loaded from: classes.dex */
        public static class C0662a implements Parcelable.Creator<C0661b> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0661b createFromParcel(Parcel parcel) {
                return new C0661b(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0661b[] newArray(int i) {
                return new C0661b[i];
            }
        }

        public C0661b(Parcel parcel) {
            super(parcel);
        }

        public C0661b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: android.support.v7.preference.Preference$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0663c {
        /* renamed from: a */
        void mo7196a(Preference preference);

        /* renamed from: b */
        void mo7195b(Preference preference);
    }

    /* renamed from: android.support.v7.preference.Preference$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0664d {
        /* renamed from: a */
        boolean m7194a(Preference preference, Object obj);
    }

    /* renamed from: android.support.v7.preference.Preference$e */
    /* loaded from: classes.dex */
    public interface InterfaceC0665e {
        /* renamed from: a */
        boolean mo764a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f3866h = Integer.MAX_VALUE;
        this.f3867i = 0;
        this.f3876s = true;
        this.f3877t = true;
        this.f3878u = true;
        this.f3881x = true;
        this.f3882y = true;
        this.f3883z = true;
        this.f3846A = true;
        this.f3847B = true;
        this.f3849D = true;
        this.f3851F = true;
        this.f3852G = C0402p.preference;
        this.f3858M = new View$OnClickListenerC0660a();
        this.f3859a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0405s.Preference, i, i2);
        this.f3870m = TypedArrayUtils.m9934b(obtainStyledAttributes, C0405s.Preference_icon, C0405s.Preference_android_icon, 0);
        this.f3872o = TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.Preference_key, C0405s.Preference_android_key);
        this.f3868j = TypedArrayUtils.m9931c(obtainStyledAttributes, C0405s.Preference_title, C0405s.Preference_android_title);
        this.f3869k = TypedArrayUtils.m9931c(obtainStyledAttributes, C0405s.Preference_summary, C0405s.Preference_android_summary);
        this.f3866h = TypedArrayUtils.m9943a(obtainStyledAttributes, C0405s.Preference_order, C0405s.Preference_android_order, Integer.MAX_VALUE);
        this.f3874q = TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.Preference_fragment, C0405s.Preference_android_fragment);
        this.f3852G = TypedArrayUtils.m9934b(obtainStyledAttributes, C0405s.Preference_layout, C0405s.Preference_android_layout, C0402p.preference);
        this.f3853H = TypedArrayUtils.m9934b(obtainStyledAttributes, C0405s.Preference_widgetLayout, C0405s.Preference_android_widgetLayout, 0);
        this.f3876s = TypedArrayUtils.m9942a(obtainStyledAttributes, C0405s.Preference_enabled, C0405s.Preference_android_enabled, true);
        this.f3877t = TypedArrayUtils.m9942a(obtainStyledAttributes, C0405s.Preference_selectable, C0405s.Preference_android_selectable, true);
        this.f3878u = TypedArrayUtils.m9942a(obtainStyledAttributes, C0405s.Preference_persistent, C0405s.Preference_android_persistent, true);
        this.f3879v = TypedArrayUtils.m9935b(obtainStyledAttributes, C0405s.Preference_dependency, C0405s.Preference_android_dependency);
        int i3 = C0405s.Preference_allowDividerAbove;
        this.f3846A = TypedArrayUtils.m9942a(obtainStyledAttributes, i3, i3, this.f3877t);
        int i4 = C0405s.Preference_allowDividerBelow;
        this.f3847B = TypedArrayUtils.m9942a(obtainStyledAttributes, i4, i4, this.f3877t);
        if (obtainStyledAttributes.hasValue(C0405s.Preference_defaultValue)) {
            this.f3880w = mo7157a(obtainStyledAttributes, C0405s.Preference_defaultValue);
        } else if (obtainStyledAttributes.hasValue(C0405s.Preference_android_defaultValue)) {
            this.f3880w = mo7157a(obtainStyledAttributes, C0405s.Preference_android_defaultValue);
        }
        this.f3851F = TypedArrayUtils.m9942a(obtainStyledAttributes, C0405s.Preference_shouldDisableView, C0405s.Preference_android_shouldDisableView, true);
        this.f3848C = obtainStyledAttributes.hasValue(C0405s.Preference_singleLineTitle);
        if (this.f3848C) {
            this.f3849D = TypedArrayUtils.m9942a(obtainStyledAttributes, C0405s.Preference_singleLineTitle, C0405s.Preference_android_singleLineTitle, true);
        }
        this.f3850E = TypedArrayUtils.m9942a(obtainStyledAttributes, C0405s.Preference_iconSpaceReserved, C0405s.Preference_android_iconSpaceReserved, false);
        int i5 = C0405s.Preference_isPreferenceVisible;
        this.f3883z = TypedArrayUtils.m9942a(obtainStyledAttributes, i5, i5, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: A */
    public void mo7191A() {
        m7256F();
    }

    /* renamed from: B */
    public void mo7161B() {
    }

    /* renamed from: C */
    public void mo7190C() {
        m7254I();
    }

    /* renamed from: D */
    public Parcelable mo7160D() {
        this.f3857L = true;
        return AbsSavedState.EMPTY_STATE;
    }

    /* renamed from: E */
    public void m7257E() {
        PreferenceManager.InterfaceC0396c m8822d;
        if (mo7192u()) {
            mo7161B();
            InterfaceC0665e interfaceC0665e = this.f3865g;
            if (interfaceC0665e == null || !interfaceC0665e.mo764a(this)) {
                PreferenceManager m7207o = m7207o();
                if ((m7207o == null || (m8822d = m7207o.m8822d()) == null || !m8822d.mo8814a(this)) && this.f3873p != null) {
                    m7222d().startActivity(this.f3873p);
                }
            }
        }
    }

    /* renamed from: F */
    public final void m7256F() {
        if (TextUtils.isEmpty(this.f3879v)) {
            return;
        }
        Preference m7239a = m7239a(this.f3879v);
        if (m7239a != null) {
            m7239a.m7233b(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.f3879v + "\" not found for preference \"" + this.f3872o + "\" (title: \"" + ((Object) this.f3868j) + "\"");
    }

    /* renamed from: G */
    public boolean mo7159G() {
        return !mo7192u();
    }

    /* renamed from: H */
    public boolean m7255H() {
        return this.f3860b != null && m7201v() && m7202t();
    }

    /* renamed from: I */
    public final void m7254I() {
        Preference m7239a;
        String str = this.f3879v;
        if (str == null || (m7239a = m7239a(str)) == null) {
            return;
        }
        m7239a.m7225c(this);
    }

    /* renamed from: a */
    public Object mo7157a(TypedArray typedArray, int i) {
        return null;
    }

    /* renamed from: a */
    public void mo7193a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    /* renamed from: a */
    public void m7250a(Intent intent) {
        this.f3873p = intent;
    }

    /* renamed from: b */
    public final void m7235b() {
    }

    /* renamed from: b */
    public void m7231b(CharSequence charSequence) {
        if ((charSequence != null || this.f3868j == null) && (charSequence == null || charSequence.equals(this.f3868j))) {
            return;
        }
        this.f3868j = charSequence;
        mo7198y();
    }

    /* renamed from: b */
    public void mo7153b(Object obj) {
    }

    /* renamed from: c */
    public void m7227c(int i) {
        m7248a(ContextCompat.m10016c(this.f3859a, i));
        this.f3870m = i;
    }

    /* renamed from: d */
    public void m7221d(int i) {
        this.f3852G = i;
    }

    /* renamed from: e */
    public Bundle m7219e() {
        if (this.f3875r == null) {
            this.f3875r = new Bundle();
        }
        return this.f3875r;
    }

    /* renamed from: f */
    public void m7216f(int i) {
        m7231b((CharSequence) this.f3859a.getString(i));
    }

    /* renamed from: g */
    public String m7215g() {
        return this.f3874q;
    }

    /* renamed from: h */
    public long mo7214h() {
        return this.f3862d;
    }

    /* renamed from: i */
    public Intent m7213i() {
        return this.f3873p;
    }

    /* renamed from: j */
    public String m7212j() {
        return this.f3872o;
    }

    /* renamed from: k */
    public final int m7211k() {
        return this.f3852G;
    }

    /* renamed from: l */
    public int m7210l() {
        return this.f3866h;
    }

    /* renamed from: m */
    public PreferenceGroup m7209m() {
        return this.f3856K;
    }

    /* renamed from: n */
    public PreferenceDataStore m7208n() {
        PreferenceDataStore preferenceDataStore = this.f3861c;
        if (preferenceDataStore != null) {
            return preferenceDataStore;
        }
        PreferenceManager preferenceManager = this.f3860b;
        if (preferenceManager != null) {
            return preferenceManager.m8820f();
        }
        return null;
    }

    /* renamed from: o */
    public PreferenceManager m7207o() {
        return this.f3860b;
    }

    /* renamed from: p */
    public SharedPreferences m7206p() {
        if (this.f3860b == null || m7208n() != null) {
            return null;
        }
        return this.f3860b.m8818h();
    }

    /* renamed from: q */
    public CharSequence mo7205q() {
        return this.f3869k;
    }

    /* renamed from: r */
    public CharSequence m7204r() {
        return this.f3868j;
    }

    /* renamed from: s */
    public final int m7203s() {
        return this.f3853H;
    }

    /* renamed from: t */
    public boolean m7202t() {
        return !TextUtils.isEmpty(this.f3872o);
    }

    public String toString() {
        return m7217f().toString();
    }

    /* renamed from: u */
    public boolean mo7192u() {
        return this.f3876s && this.f3881x && this.f3882y;
    }

    /* renamed from: v */
    public boolean m7201v() {
        return this.f3878u;
    }

    /* renamed from: w */
    public boolean m7200w() {
        return this.f3877t;
    }

    /* renamed from: x */
    public final boolean m7199x() {
        return this.f3883z;
    }

    /* renamed from: y */
    public void mo7198y() {
        InterfaceC0663c interfaceC0663c = this.f3854I;
        if (interfaceC0663c != null) {
            interfaceC0663c.mo7195b(this);
        }
    }

    /* renamed from: z */
    public void m7197z() {
        InterfaceC0663c interfaceC0663c = this.f3854I;
        if (interfaceC0663c != null) {
            interfaceC0663c.mo7196a(this);
        }
    }

    /* renamed from: a */
    public void mo7167a(PreferenceViewHolder preferenceViewHolder) {
        preferenceViewHolder.f4213a.setOnClickListener(this.f3858M);
        preferenceViewHolder.f4213a.setId(this.f3867i);
        TextView textView = (TextView) preferenceViewHolder.m8808c(16908310);
        if (textView != null) {
            CharSequence m7204r = m7204r();
            if (!TextUtils.isEmpty(m7204r)) {
                textView.setText(m7204r);
                textView.setVisibility(0);
                if (this.f3848C) {
                    textView.setSingleLine(this.f3849D);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) preferenceViewHolder.m8808c(16908304);
        if (textView2 != null) {
            CharSequence mo7205q = mo7205q();
            if (!TextUtils.isEmpty(mo7205q)) {
                textView2.setText(mo7205q);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) preferenceViewHolder.m8808c(16908294);
        if (imageView != null) {
            if (this.f3870m != 0 || this.f3871n != null) {
                if (this.f3871n == null) {
                    this.f3871n = ContextCompat.m10016c(m7222d(), this.f3870m);
                }
                Drawable drawable = this.f3871n;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.f3871n != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.f3850E ? 4 : 8);
            }
        }
        View m8808c = preferenceViewHolder.m8808c(C0401o.icon_frame);
        if (m8808c == null) {
            m8808c = preferenceViewHolder.m8808c(16908350);
        }
        if (m8808c != null) {
            if (this.f3871n != null) {
                m8808c.setVisibility(0);
            } else {
                m8808c.setVisibility(this.f3850E ? 4 : 8);
            }
        }
        if (this.f3851F) {
            m7242a(preferenceViewHolder.f4213a, mo7192u());
        } else {
            m7242a(preferenceViewHolder.f4213a, true);
        }
        boolean m7200w = m7200w();
        preferenceViewHolder.f4213a.setFocusable(m7200w);
        preferenceViewHolder.f4213a.setClickable(m7200w);
        preferenceViewHolder.m8809b(this.f3846A);
        preferenceViewHolder.m8807c(this.f3847B);
    }

    /* renamed from: d */
    public Context m7222d() {
        return this.f3859a;
    }

    /* renamed from: f */
    public StringBuilder m7217f() {
        StringBuilder sb = new StringBuilder();
        CharSequence m7204r = m7204r();
        if (!TextUtils.isEmpty(m7204r)) {
            sb.append(m7204r);
            sb.append(' ');
        }
        CharSequence mo7205q = mo7205q();
        if (!TextUtils.isEmpty(mo7205q)) {
            sb.append(mo7205q);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    /* renamed from: c */
    public final void m7225c(Preference preference) {
        List<Preference> list = this.f3855J;
        if (list != null) {
            list.remove(preference);
        }
    }

    /* renamed from: d */
    public void m7220d(Bundle bundle) {
        mo7184b(bundle);
    }

    /* renamed from: b */
    public final void m7233b(Preference preference) {
        if (this.f3855J == null) {
            this.f3855J = new ArrayList();
        }
        this.f3855J.add(preference);
        preference.m7244a(this, mo7159G());
    }

    /* renamed from: e */
    public void m7218e(int i) {
        if (i != this.f3866h) {
            this.f3866h = i;
            m7197z();
        }
    }

    /* renamed from: c */
    public final void m7228c() {
        if (m7208n() != null) {
            m7236a(true, this.f3880w);
        } else if (m7255H() && m7206p().contains(this.f3872o)) {
            m7236a(true, (Object) null);
        } else {
            Object obj = this.f3880w;
            if (obj != null) {
                m7236a(false, obj);
            }
        }
    }

    /* renamed from: b */
    public void mo7183b(boolean z) {
        List<Preference> list = this.f3855J;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).m7244a(this, z);
        }
    }

    /* renamed from: b */
    public void m7232b(Preference preference, boolean z) {
        if (this.f3882y == z) {
            this.f3882y = !z;
            mo7183b(mo7159G());
            mo7198y();
        }
    }

    /* renamed from: c */
    public boolean m7224c(String str) {
        if (m7255H()) {
            if (TextUtils.equals(str, m7230b((String) null))) {
                return true;
            }
            PreferenceDataStore m7208n = m7208n();
            if (m7208n != null) {
                m7208n.m8885b(this.f3872o, str);
            } else {
                SharedPreferences.Editor m8835a = this.f3860b.m8835a();
                m8835a.putString(this.f3872o, str);
                m7249a(m8835a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public String m7230b(String str) {
        if (m7255H()) {
            PreferenceDataStore m7208n = m7208n();
            if (m7208n != null) {
                return m7208n.m8889a(this.f3872o, str);
            }
            return this.f3860b.m8818h().getString(this.f3872o, str);
        }
        return str;
    }

    /* renamed from: b */
    public boolean m7229b(Set<String> set) {
        if (m7255H()) {
            if (set.equals(m7238a((Set<String>) null))) {
                return true;
            }
            PreferenceDataStore m7208n = m7208n();
            if (m7208n != null) {
                m7208n.m8884b(this.f3872o, set);
            } else {
                SharedPreferences.Editor m8835a = this.f3860b.m8835a();
                m8835a.putStringSet(this.f3872o, set);
                m7249a(m8835a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public boolean m7223c(boolean z) {
        if (m7255H()) {
            if (z == m7237a(!z)) {
                return true;
            }
            PreferenceDataStore m7208n = m7208n();
            if (m7208n != null) {
                m7208n.m8883b(this.f3872o, z);
            } else {
                SharedPreferences.Editor m8835a = this.f3860b.m8835a();
                m8835a.putBoolean(this.f3872o, z);
                m7249a(m8835a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean m7234b(int i) {
        if (m7255H()) {
            if (i == m7253a(~i)) {
                return true;
            }
            PreferenceDataStore m7208n = m7208n();
            if (m7208n != null) {
                m7208n.m8886b(this.f3872o, i);
            } else {
                SharedPreferences.Editor m8835a = this.f3860b.m8835a();
                m8835a.putInt(this.f3872o, i);
                m7249a(m8835a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void m7226c(Bundle bundle) {
        mo7185a(bundle);
    }

    /* renamed from: b */
    public void mo7184b(Bundle bundle) {
        if (m7202t()) {
            this.f3857L = false;
            Parcelable mo7160D = mo7160D();
            if (!this.f3857L) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (mo7160D != null) {
                bundle.putParcelable(this.f3872o, mo7160D);
            }
        }
    }

    /* renamed from: a */
    public final void m7242a(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                m7242a(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m9946a(context, C0399m.preferenceStyle, 16842894));
    }

    /* renamed from: a */
    public void m7248a(Drawable drawable) {
        if ((drawable != null || this.f3871n == null) && (drawable == null || this.f3871n == drawable)) {
            return;
        }
        this.f3871n = drawable;
        this.f3870m = 0;
        mo7198y();
    }

    public Preference(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public void mo7241a(CharSequence charSequence) {
        if ((charSequence != null || this.f3869k == null) && (charSequence == null || charSequence.equals(this.f3869k))) {
            return;
        }
        this.f3869k = charSequence;
        mo7198y();
    }

    /* renamed from: a */
    public boolean m7240a(Object obj) {
        InterfaceC0664d interfaceC0664d = this.f3864f;
        return interfaceC0664d == null || interfaceC0664d.m7194a(this, obj);
    }

    /* renamed from: a */
    public void m7246a(InterfaceC0665e interfaceC0665e) {
        this.f3865g = interfaceC0665e;
    }

    /* renamed from: a */
    public void mo7166a(View view) {
        m7257E();
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Preference preference) {
        int i = this.f3866h;
        int i2 = preference.f3866h;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.f3868j;
        CharSequence charSequence2 = preference.f3868j;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f3868j.toString());
    }

    /* renamed from: a */
    public final void m7247a(InterfaceC0663c interfaceC0663c) {
        this.f3854I = interfaceC0663c;
    }

    /* renamed from: a */
    public void m7252a(PreferenceManager preferenceManager) {
        this.f3860b = preferenceManager;
        if (!this.f3863e) {
            this.f3862d = preferenceManager.m8824b();
        }
        m7228c();
    }

    /* renamed from: a */
    public void m7251a(PreferenceManager preferenceManager, long j) {
        this.f3862d = j;
        this.f3863e = true;
        try {
            m7252a(preferenceManager);
        } finally {
            this.f3863e = false;
        }
    }

    /* renamed from: a */
    public void m7243a(PreferenceGroup preferenceGroup) {
        this.f3856K = preferenceGroup;
    }

    /* renamed from: a */
    public Preference m7239a(String str) {
        PreferenceManager preferenceManager;
        if (TextUtils.isEmpty(str) || (preferenceManager = this.f3860b) == null) {
            return null;
        }
        return preferenceManager.m8827a((CharSequence) str);
    }

    /* renamed from: a */
    public void m7244a(Preference preference, boolean z) {
        if (this.f3881x == z) {
            this.f3881x = !z;
            mo7183b(mo7159G());
            mo7198y();
        }
    }

    @Deprecated
    /* renamed from: a */
    public void m7236a(boolean z, Object obj) {
        mo7153b(obj);
    }

    /* renamed from: a */
    public final void m7249a(SharedPreferences.Editor editor) {
        if (this.f3860b.m8817i()) {
            editor.apply();
        }
    }

    /* renamed from: a */
    public Set<String> m7238a(Set<String> set) {
        if (m7255H()) {
            PreferenceDataStore m7208n = m7208n();
            if (m7208n != null) {
                return m7208n.m8888a(this.f3872o, set);
            }
            return this.f3860b.m8818h().getStringSet(this.f3872o, set);
        }
        return set;
    }

    /* renamed from: a */
    public int m7253a(int i) {
        if (m7255H()) {
            PreferenceDataStore m7208n = m7208n();
            if (m7208n != null) {
                return m7208n.m8890a(this.f3872o, i);
            }
            return this.f3860b.m8818h().getInt(this.f3872o, i);
        }
        return i;
    }

    /* renamed from: a */
    public boolean m7237a(boolean z) {
        if (m7255H()) {
            PreferenceDataStore m7208n = m7208n();
            if (m7208n != null) {
                return m7208n.m8887a(this.f3872o, z);
            }
            return this.f3860b.m8818h().getBoolean(this.f3872o, z);
        }
        return z;
    }

    /* renamed from: a */
    public void mo7185a(Bundle bundle) {
        Parcelable parcelable;
        if (!m7202t() || (parcelable = bundle.getParcelable(this.f3872o)) == null) {
            return;
        }
        this.f3857L = false;
        mo7156a(parcelable);
        if (!this.f3857L) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    /* renamed from: a */
    public void mo7156a(Parcelable parcelable) {
        this.f3857L = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }
}
