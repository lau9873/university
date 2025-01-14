package android.support.v7.preference;

import a.b.g.b.g.g;
import a.b.h.f.j;
import a.b.h.f.l;
import a.b.h.f.m;
import a.b.h.f.o;
import a.b.h.f.p;
import a.b.h.f.s;
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
/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public c I;
    public List<Preference> J;
    public PreferenceGroup K;
    public boolean L;
    public final View.OnClickListener M;

    /* renamed from: a  reason: collision with root package name */
    public Context f2435a;

    /* renamed from: b  reason: collision with root package name */
    public j f2436b;

    /* renamed from: c  reason: collision with root package name */
    public a.b.h.f.e f2437c;

    /* renamed from: d  reason: collision with root package name */
    public long f2438d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2439e;

    /* renamed from: f  reason: collision with root package name */
    public d f2440f;

    /* renamed from: g  reason: collision with root package name */
    public e f2441g;

    /* renamed from: h  reason: collision with root package name */
    public int f2442h;

    /* renamed from: i  reason: collision with root package name */
    public int f2443i;
    public CharSequence j;
    public CharSequence k;
    public int m;
    public Drawable n;
    public String o;
    public Intent p;
    public String q;
    public Bundle r;
    public boolean s;
    public boolean t;
    public boolean u;
    public String v;
    public Object w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.a(view);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<b> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public b[] newArray(int i2) {
                return new b[i2];
            }
        }

        public b(Parcel parcel) {
            super(parcel);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(Preference preference);

        void b(Preference preference);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean a(Preference preference, Object obj);
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f2442h = Integer.MAX_VALUE;
        this.f2443i = 0;
        this.s = true;
        this.t = true;
        this.u = true;
        this.x = true;
        this.y = true;
        this.z = true;
        this.A = true;
        this.B = true;
        this.D = true;
        this.F = true;
        this.G = p.preference;
        this.M = new a();
        this.f2435a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.Preference, i2, i3);
        this.m = g.b(obtainStyledAttributes, s.Preference_icon, s.Preference_android_icon, 0);
        this.o = g.b(obtainStyledAttributes, s.Preference_key, s.Preference_android_key);
        this.j = g.c(obtainStyledAttributes, s.Preference_title, s.Preference_android_title);
        this.k = g.c(obtainStyledAttributes, s.Preference_summary, s.Preference_android_summary);
        this.f2442h = g.a(obtainStyledAttributes, s.Preference_order, s.Preference_android_order, Integer.MAX_VALUE);
        this.q = g.b(obtainStyledAttributes, s.Preference_fragment, s.Preference_android_fragment);
        this.G = g.b(obtainStyledAttributes, s.Preference_layout, s.Preference_android_layout, p.preference);
        this.H = g.b(obtainStyledAttributes, s.Preference_widgetLayout, s.Preference_android_widgetLayout, 0);
        this.s = g.a(obtainStyledAttributes, s.Preference_enabled, s.Preference_android_enabled, true);
        this.t = g.a(obtainStyledAttributes, s.Preference_selectable, s.Preference_android_selectable, true);
        this.u = g.a(obtainStyledAttributes, s.Preference_persistent, s.Preference_android_persistent, true);
        this.v = g.b(obtainStyledAttributes, s.Preference_dependency, s.Preference_android_dependency);
        int i4 = s.Preference_allowDividerAbove;
        this.A = g.a(obtainStyledAttributes, i4, i4, this.t);
        int i5 = s.Preference_allowDividerBelow;
        this.B = g.a(obtainStyledAttributes, i5, i5, this.t);
        if (obtainStyledAttributes.hasValue(s.Preference_defaultValue)) {
            this.w = a(obtainStyledAttributes, s.Preference_defaultValue);
        } else if (obtainStyledAttributes.hasValue(s.Preference_android_defaultValue)) {
            this.w = a(obtainStyledAttributes, s.Preference_android_defaultValue);
        }
        this.F = g.a(obtainStyledAttributes, s.Preference_shouldDisableView, s.Preference_android_shouldDisableView, true);
        this.C = obtainStyledAttributes.hasValue(s.Preference_singleLineTitle);
        if (this.C) {
            this.D = g.a(obtainStyledAttributes, s.Preference_singleLineTitle, s.Preference_android_singleLineTitle, true);
        }
        this.E = g.a(obtainStyledAttributes, s.Preference_iconSpaceReserved, s.Preference_android_iconSpaceReserved, false);
        int i6 = s.Preference_isPreferenceVisible;
        this.z = g.a(obtainStyledAttributes, i6, i6, true);
        obtainStyledAttributes.recycle();
    }

    public void A() {
        F();
    }

    public void B() {
    }

    public void C() {
        I();
    }

    public Parcelable D() {
        this.L = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void E() {
        j.c d2;
        if (u()) {
            B();
            e eVar = this.f2441g;
            if (eVar == null || !eVar.a(this)) {
                j o = o();
                if ((o == null || (d2 = o.d()) == null || !d2.a(this)) && this.p != null) {
                    d().startActivity(this.p);
                }
            }
        }
    }

    public final void F() {
        if (TextUtils.isEmpty(this.v)) {
            return;
        }
        Preference a2 = a(this.v);
        if (a2 != null) {
            a2.b(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.v + "\" not found for preference \"" + this.o + "\" (title: \"" + ((Object) this.j) + "\"");
    }

    public boolean G() {
        return !u();
    }

    public boolean H() {
        return this.f2436b != null && v() && t();
    }

    public final void I() {
        Preference a2;
        String str = this.v;
        if (str == null || (a2 = a(str)) == null) {
            return;
        }
        a2.c(this);
    }

    public Object a(TypedArray typedArray, int i2) {
        return null;
    }

    public void a(a.b.g.k.e0.c cVar) {
    }

    public void a(Intent intent) {
        this.p = intent;
    }

    public final void b() {
    }

    public void b(CharSequence charSequence) {
        if ((charSequence != null || this.j == null) && (charSequence == null || charSequence.equals(this.j))) {
            return;
        }
        this.j = charSequence;
        y();
    }

    public void b(Object obj) {
    }

    public void c(int i2) {
        a(a.b.g.b.b.c(this.f2435a, i2));
        this.m = i2;
    }

    public void d(int i2) {
        this.G = i2;
    }

    public Bundle e() {
        if (this.r == null) {
            this.r = new Bundle();
        }
        return this.r;
    }

    public void f(int i2) {
        b((CharSequence) this.f2435a.getString(i2));
    }

    public String g() {
        return this.q;
    }

    public long h() {
        return this.f2438d;
    }

    public Intent i() {
        return this.p;
    }

    public String j() {
        return this.o;
    }

    public final int k() {
        return this.G;
    }

    public int l() {
        return this.f2442h;
    }

    public PreferenceGroup m() {
        return this.K;
    }

    public a.b.h.f.e n() {
        a.b.h.f.e eVar = this.f2437c;
        if (eVar != null) {
            return eVar;
        }
        j jVar = this.f2436b;
        if (jVar != null) {
            return jVar.f();
        }
        return null;
    }

    public j o() {
        return this.f2436b;
    }

    public SharedPreferences p() {
        if (this.f2436b == null || n() != null) {
            return null;
        }
        return this.f2436b.h();
    }

    public CharSequence q() {
        return this.k;
    }

    public CharSequence r() {
        return this.j;
    }

    public final int s() {
        return this.H;
    }

    public boolean t() {
        return !TextUtils.isEmpty(this.o);
    }

    public String toString() {
        return f().toString();
    }

    public boolean u() {
        return this.s && this.x && this.y;
    }

    public boolean v() {
        return this.u;
    }

    public boolean w() {
        return this.t;
    }

    public final boolean x() {
        return this.z;
    }

    public void y() {
        c cVar = this.I;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public void z() {
        c cVar = this.I;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    public void a(l lVar) {
        lVar.f2580a.setOnClickListener(this.M);
        lVar.f2580a.setId(this.f2443i);
        TextView textView = (TextView) lVar.c(16908310);
        if (textView != null) {
            CharSequence r = r();
            if (!TextUtils.isEmpty(r)) {
                textView.setText(r);
                textView.setVisibility(0);
                if (this.C) {
                    textView.setSingleLine(this.D);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) lVar.c(16908304);
        if (textView2 != null) {
            CharSequence q = q();
            if (!TextUtils.isEmpty(q)) {
                textView2.setText(q);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) lVar.c(16908294);
        if (imageView != null) {
            if (this.m != 0 || this.n != null) {
                if (this.n == null) {
                    this.n = a.b.g.b.b.c(d(), this.m);
                }
                Drawable drawable = this.n;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.n != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.E ? 4 : 8);
            }
        }
        View c2 = lVar.c(o.icon_frame);
        if (c2 == null) {
            c2 = lVar.c(16908350);
        }
        if (c2 != null) {
            if (this.n != null) {
                c2.setVisibility(0);
            } else {
                c2.setVisibility(this.E ? 4 : 8);
            }
        }
        if (this.F) {
            a(lVar.f2580a, u());
        } else {
            a(lVar.f2580a, true);
        }
        boolean w = w();
        lVar.f2580a.setFocusable(w);
        lVar.f2580a.setClickable(w);
        lVar.b(this.A);
        lVar.c(this.B);
    }

    public Context d() {
        return this.f2435a;
    }

    public StringBuilder f() {
        StringBuilder sb = new StringBuilder();
        CharSequence r = r();
        if (!TextUtils.isEmpty(r)) {
            sb.append(r);
            sb.append(' ');
        }
        CharSequence q = q();
        if (!TextUtils.isEmpty(q)) {
            sb.append(q);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public final void c(Preference preference) {
        List<Preference> list = this.J;
        if (list != null) {
            list.remove(preference);
        }
    }

    public void d(Bundle bundle) {
        b(bundle);
    }

    public final void b(Preference preference) {
        if (this.J == null) {
            this.J = new ArrayList();
        }
        this.J.add(preference);
        preference.a(this, G());
    }

    public void e(int i2) {
        if (i2 != this.f2442h) {
            this.f2442h = i2;
            z();
        }
    }

    public final void c() {
        if (n() != null) {
            a(true, this.w);
        } else if (H() && p().contains(this.o)) {
            a(true, (Object) null);
        } else {
            Object obj = this.w;
            if (obj != null) {
                a(false, obj);
            }
        }
    }

    public void b(boolean z) {
        List<Preference> list = this.J;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2).a(this, z);
        }
    }

    public void b(Preference preference, boolean z) {
        if (this.y == z) {
            this.y = !z;
            b(G());
            y();
        }
    }

    public boolean c(String str) {
        if (H()) {
            if (TextUtils.equals(str, b((String) null))) {
                return true;
            }
            a.b.h.f.e n = n();
            if (n != null) {
                n.b(this.o, str);
            } else {
                SharedPreferences.Editor a2 = this.f2436b.a();
                a2.putString(this.o, str);
                a(a2);
            }
            return true;
        }
        return false;
    }

    public String b(String str) {
        if (H()) {
            a.b.h.f.e n = n();
            if (n != null) {
                return n.a(this.o, str);
            }
            return this.f2436b.h().getString(this.o, str);
        }
        return str;
    }

    public boolean b(Set<String> set) {
        if (H()) {
            if (set.equals(a((Set<String>) null))) {
                return true;
            }
            a.b.h.f.e n = n();
            if (n != null) {
                n.b(this.o, set);
            } else {
                SharedPreferences.Editor a2 = this.f2436b.a();
                a2.putStringSet(this.o, set);
                a(a2);
            }
            return true;
        }
        return false;
    }

    public boolean c(boolean z) {
        if (H()) {
            if (z == a(!z)) {
                return true;
            }
            a.b.h.f.e n = n();
            if (n != null) {
                n.b(this.o, z);
            } else {
                SharedPreferences.Editor a2 = this.f2436b.a();
                a2.putBoolean(this.o, z);
                a(a2);
            }
            return true;
        }
        return false;
    }

    public boolean b(int i2) {
        if (H()) {
            if (i2 == a(~i2)) {
                return true;
            }
            a.b.h.f.e n = n();
            if (n != null) {
                n.b(this.o, i2);
            } else {
                SharedPreferences.Editor a2 = this.f2436b.a();
                a2.putInt(this.o, i2);
                a(a2);
            }
            return true;
        }
        return false;
    }

    public void c(Bundle bundle) {
        a(bundle);
    }

    public void b(Bundle bundle) {
        if (t()) {
            this.L = false;
            Parcelable D = D();
            if (!this.L) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (D != null) {
                bundle.putParcelable(this.o, D);
            }
        }
    }

    public final void a(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                a(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, m.preferenceStyle, 16842894));
    }

    public void a(Drawable drawable) {
        if ((drawable != null || this.n == null) && (drawable == null || this.n == drawable)) {
            return;
        }
        this.n = drawable;
        this.m = 0;
        y();
    }

    public Preference(Context context) {
        this(context, null);
    }

    public void a(CharSequence charSequence) {
        if ((charSequence != null || this.k == null) && (charSequence == null || charSequence.equals(this.k))) {
            return;
        }
        this.k = charSequence;
        y();
    }

    public boolean a(Object obj) {
        d dVar = this.f2440f;
        return dVar == null || dVar.a(this, obj);
    }

    public void a(e eVar) {
        this.f2441g = eVar;
    }

    public void a(View view) {
        E();
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Preference preference) {
        int i2 = this.f2442h;
        int i3 = preference.f2442h;
        if (i2 != i3) {
            return i2 - i3;
        }
        CharSequence charSequence = this.j;
        CharSequence charSequence2 = preference.j;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.j.toString());
    }

    public final void a(c cVar) {
        this.I = cVar;
    }

    public void a(j jVar) {
        this.f2436b = jVar;
        if (!this.f2439e) {
            this.f2438d = jVar.b();
        }
        c();
    }

    public void a(j jVar, long j) {
        this.f2438d = j;
        this.f2439e = true;
        try {
            a(jVar);
        } finally {
            this.f2439e = false;
        }
    }

    public void a(PreferenceGroup preferenceGroup) {
        this.K = preferenceGroup;
    }

    public Preference a(String str) {
        j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f2436b) == null) {
            return null;
        }
        return jVar.a((CharSequence) str);
    }

    public void a(Preference preference, boolean z) {
        if (this.x == z) {
            this.x = !z;
            b(G());
            y();
        }
    }

    @Deprecated
    public void a(boolean z, Object obj) {
        b(obj);
    }

    public final void a(SharedPreferences.Editor editor) {
        if (this.f2436b.i()) {
            editor.apply();
        }
    }

    public Set<String> a(Set<String> set) {
        if (H()) {
            a.b.h.f.e n = n();
            if (n != null) {
                return n.a(this.o, set);
            }
            return this.f2436b.h().getStringSet(this.o, set);
        }
        return set;
    }

    public int a(int i2) {
        if (H()) {
            a.b.h.f.e n = n();
            if (n != null) {
                return n.a(this.o, i2);
            }
            return this.f2436b.h().getInt(this.o, i2);
        }
        return i2;
    }

    public boolean a(boolean z) {
        if (H()) {
            a.b.h.f.e n = n();
            if (n != null) {
                return n.a(this.o, z);
            }
            return this.f2436b.h().getBoolean(this.o, z);
        }
        return z;
    }

    public void a(Bundle bundle) {
        Parcelable parcelable;
        if (!t() || (parcelable = bundle.getParcelable(this.o)) == null) {
            return;
        }
        this.L = false;
        a(parcelable);
        if (!this.L) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    public void a(Parcelable parcelable) {
        this.L = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }
}
