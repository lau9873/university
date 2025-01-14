package android.support.v7.preference;

import a.b.g.b.g.g;
import a.b.g.j.n;
import a.b.h.f.j;
import a.b.h.f.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    public List<Preference> N;
    public boolean O;
    public int P;
    public boolean Q;
    public int R;
    public b S;
    public final n<String, Long> T;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.T.clear();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.O = true;
        this.P = 0;
        this.Q = false;
        this.R = Integer.MAX_VALUE;
        this.S = null;
        this.T = new n<>();
        new Handler();
        new a();
        this.N = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.PreferenceGroup, i2, i3);
        int i4 = s.PreferenceGroup_orderingFromXml;
        this.O = g.a(obtainStyledAttributes, i4, i4, true);
        if (obtainStyledAttributes.hasValue(s.PreferenceGroup_initialExpandedChildrenCount)) {
            int i5 = s.PreferenceGroup_initialExpandedChildrenCount;
            h(g.a(obtainStyledAttributes, i5, i5, Integer.MAX_VALUE));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.v7.preference.Preference
    public void A() {
        super.A();
        this.Q = true;
        int L = L();
        for (int i2 = 0; i2 < L; i2++) {
            g(i2).A();
        }
    }

    @Override // android.support.v7.preference.Preference
    public void C() {
        super.C();
        this.Q = false;
        int L = L();
        for (int i2 = 0; i2 < L; i2++) {
            g(i2).C();
        }
    }

    @Override // android.support.v7.preference.Preference
    public Parcelable D() {
        return new d(super.D(), this.R);
    }

    public int J() {
        return this.R;
    }

    public b K() {
        return this.S;
    }

    public int L() {
        return this.N.size();
    }

    public boolean M() {
        return true;
    }

    public void N() {
        synchronized (this) {
            Collections.sort(this.N);
        }
    }

    @Override // android.support.v7.preference.Preference
    public void a(Bundle bundle) {
        super.a(bundle);
        int L = L();
        for (int i2 = 0; i2 < L; i2++) {
            g(i2).a(bundle);
        }
    }

    @Override // android.support.v7.preference.Preference
    public void b(boolean z) {
        super.b(z);
        int L = L();
        for (int i2 = 0; i2 < L; i2++) {
            g(i2).b(this, z);
        }
    }

    public Preference c(CharSequence charSequence) {
        Preference c2;
        if (TextUtils.equals(j(), charSequence)) {
            return this;
        }
        int L = L();
        for (int i2 = 0; i2 < L; i2++) {
            Preference g2 = g(i2);
            String j = g2.j();
            if (j != null && j.equals(charSequence)) {
                return g2;
            }
            if ((g2 instanceof PreferenceGroup) && (c2 = ((PreferenceGroup) g2).c(charSequence)) != null) {
                return c2;
            }
        }
        return null;
    }

    public void d(boolean z) {
        this.O = z;
    }

    public boolean e(Preference preference) {
        long b2;
        if (this.N.contains(preference)) {
            return true;
        }
        if (preference.j() != null) {
            PreferenceGroup preferenceGroup = this;
            while (preferenceGroup.m() != null) {
                preferenceGroup = preferenceGroup.m();
            }
            String j = preference.j();
            if (preferenceGroup.c((CharSequence) j) != null) {
                Log.e("PreferenceGroup", "Found duplicated key: \"" + j + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.l() == Integer.MAX_VALUE) {
            if (this.O) {
                int i2 = this.P;
                this.P = i2 + 1;
                preference.e(i2);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).d(this.O);
            }
        }
        int binarySearch = Collections.binarySearch(this.N, preference);
        if (binarySearch < 0) {
            binarySearch = (binarySearch * (-1)) - 1;
        }
        if (f(preference)) {
            synchronized (this) {
                this.N.add(binarySearch, preference);
            }
            j o = o();
            String j2 = preference.j();
            if (j2 != null && this.T.containsKey(j2)) {
                b2 = this.T.get(j2).longValue();
                this.T.remove(j2);
            } else {
                b2 = o.b();
            }
            preference.a(o, b2);
            preference.a(this);
            if (this.Q) {
                preference.A();
            }
            z();
            return true;
        }
        return false;
    }

    public boolean f(Preference preference) {
        preference.b(this, G());
        return true;
    }

    public Preference g(int i2) {
        return this.N.get(i2);
    }

    public void h(int i2) {
        if (i2 != Integer.MAX_VALUE && !t()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.R = i2;
    }

    /* loaded from: classes.dex */
    public static class d extends Preference.b {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f2446a;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<d> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f2446a = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2446a);
        }

        public d(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f2446a = i2;
        }
    }

    public void d(Preference preference) {
        e(preference);
    }

    @Override // android.support.v7.preference.Preference
    public void a(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(d.class)) {
            d dVar = (d) parcelable;
            this.R = dVar.f2446a;
            super.a(dVar.getSuperState());
            return;
        }
        super.a(parcelable);
    }

    @Override // android.support.v7.preference.Preference
    public void b(Bundle bundle) {
        super.b(bundle);
        int L = L();
        for (int i2 = 0; i2 < L; i2++) {
            g(i2).b(bundle);
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
