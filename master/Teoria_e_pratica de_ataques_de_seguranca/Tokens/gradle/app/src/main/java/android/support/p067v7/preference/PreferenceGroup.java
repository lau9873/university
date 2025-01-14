package android.support.p067v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p067v7.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p030g.p044j.SimpleArrayMap;
import p000a.p006b.p049h.p057f.C0405s;
import p000a.p006b.p049h.p057f.PreferenceManager;

/* renamed from: android.support.v7.preference.PreferenceGroup */
/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: N */
    public List<Preference> f3885N;

    /* renamed from: O */
    public boolean f3886O;

    /* renamed from: P */
    public int f3887P;

    /* renamed from: Q */
    public boolean f3888Q;

    /* renamed from: R */
    public int f3889R;

    /* renamed from: S */
    public InterfaceC0667b f3890S;

    /* renamed from: T */
    public final SimpleArrayMap<String, Long> f3891T;

    /* renamed from: android.support.v7.preference.PreferenceGroup$a */
    /* loaded from: classes.dex */
    public class RunnableC0666a implements Runnable {
        public RunnableC0666a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.f3891T.clear();
            }
        }
    }

    /* renamed from: android.support.v7.preference.PreferenceGroup$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0667b {
        /* renamed from: a */
        void m7175a();
    }

    /* renamed from: android.support.v7.preference.PreferenceGroup$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0668c {
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3886O = true;
        this.f3887P = 0;
        this.f3888Q = false;
        this.f3889R = Integer.MAX_VALUE;
        this.f3890S = null;
        this.f3891T = new SimpleArrayMap<>();
        new Handler();
        new RunnableC0666a();
        this.f3885N = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0405s.PreferenceGroup, i, i2);
        int i3 = C0405s.PreferenceGroup_orderingFromXml;
        this.f3886O = TypedArrayUtils.m9942a(obtainStyledAttributes, i3, i3, true);
        if (obtainStyledAttributes.hasValue(C0405s.PreferenceGroup_initialExpandedChildrenCount)) {
            int i4 = C0405s.PreferenceGroup_initialExpandedChildrenCount;
            m7176h(TypedArrayUtils.m9943a(obtainStyledAttributes, i4, i4, Integer.MAX_VALUE));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: A */
    public void mo7191A() {
        super.mo7191A();
        this.f3888Q = true;
        int m7187L = m7187L();
        for (int i = 0; i < m7187L; i++) {
            m7177g(i).mo7191A();
        }
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: C */
    public void mo7190C() {
        super.mo7190C();
        this.f3888Q = false;
        int m7187L = m7187L();
        for (int i = 0; i < m7187L; i++) {
            m7177g(i).mo7190C();
        }
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: D */
    public Parcelable mo7160D() {
        return new C0669d(super.mo7160D(), this.f3889R);
    }

    /* renamed from: J */
    public int m7189J() {
        return this.f3889R;
    }

    /* renamed from: K */
    public InterfaceC0667b m7188K() {
        return this.f3890S;
    }

    /* renamed from: L */
    public int m7187L() {
        return this.f3885N.size();
    }

    /* renamed from: M */
    public boolean mo7174M() {
        return true;
    }

    /* renamed from: N */
    public void m7186N() {
        synchronized (this) {
            Collections.sort(this.f3885N);
        }
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7185a(Bundle bundle) {
        super.mo7185a(bundle);
        int m7187L = m7187L();
        for (int i = 0; i < m7187L; i++) {
            m7177g(i).mo7185a(bundle);
        }
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: b */
    public void mo7183b(boolean z) {
        super.mo7183b(z);
        int m7187L = m7187L();
        for (int i = 0; i < m7187L; i++) {
            m7177g(i).m7232b(this, z);
        }
    }

    /* renamed from: c */
    public Preference m7182c(CharSequence charSequence) {
        Preference m7182c;
        if (TextUtils.equals(m7212j(), charSequence)) {
            return this;
        }
        int m7187L = m7187L();
        for (int i = 0; i < m7187L; i++) {
            Preference m7177g = m7177g(i);
            String m7212j = m7177g.m7212j();
            if (m7212j != null && m7212j.equals(charSequence)) {
                return m7177g;
            }
            if ((m7177g instanceof PreferenceGroup) && (m7182c = ((PreferenceGroup) m7177g).m7182c(charSequence)) != null) {
                return m7182c;
            }
        }
        return null;
    }

    /* renamed from: d */
    public void m7180d(boolean z) {
        this.f3886O = z;
    }

    /* renamed from: e */
    public boolean m7179e(Preference preference) {
        long m8824b;
        if (this.f3885N.contains(preference)) {
            return true;
        }
        if (preference.m7212j() != null) {
            PreferenceGroup preferenceGroup = this;
            while (preferenceGroup.m7209m() != null) {
                preferenceGroup = preferenceGroup.m7209m();
            }
            String m7212j = preference.m7212j();
            if (preferenceGroup.m7182c((CharSequence) m7212j) != null) {
                Log.e("PreferenceGroup", "Found duplicated key: \"" + m7212j + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.m7210l() == Integer.MAX_VALUE) {
            if (this.f3886O) {
                int i = this.f3887P;
                this.f3887P = i + 1;
                preference.m7218e(i);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).m7180d(this.f3886O);
            }
        }
        int binarySearch = Collections.binarySearch(this.f3885N, preference);
        if (binarySearch < 0) {
            binarySearch = (binarySearch * (-1)) - 1;
        }
        if (m7178f(preference)) {
            synchronized (this) {
                this.f3885N.add(binarySearch, preference);
            }
            PreferenceManager m7207o = m7207o();
            String m7212j2 = preference.m7212j();
            if (m7212j2 != null && this.f3891T.containsKey(m7212j2)) {
                m8824b = this.f3891T.get(m7212j2).longValue();
                this.f3891T.remove(m7212j2);
            } else {
                m8824b = m7207o.m8824b();
            }
            preference.m7251a(m7207o, m8824b);
            preference.m7243a(this);
            if (this.f3888Q) {
                preference.mo7191A();
            }
            m7197z();
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public boolean m7178f(Preference preference) {
        preference.m7232b(this, mo7159G());
        return true;
    }

    /* renamed from: g */
    public Preference m7177g(int i) {
        return this.f3885N.get(i);
    }

    /* renamed from: h */
    public void m7176h(int i) {
        if (i != Integer.MAX_VALUE && !m7202t()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.f3889R = i;
    }

    /* renamed from: android.support.v7.preference.PreferenceGroup$d */
    /* loaded from: classes.dex */
    public static class C0669d extends Preference.C0661b {
        public static final Parcelable.Creator<C0669d> CREATOR = new C0670a();

        /* renamed from: a */
        public int f3893a;

        /* renamed from: android.support.v7.preference.PreferenceGroup$d$a */
        /* loaded from: classes.dex */
        public static class C0670a implements Parcelable.Creator<C0669d> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0669d createFromParcel(Parcel parcel) {
                return new C0669d(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0669d[] newArray(int i) {
                return new C0669d[i];
            }
        }

        public C0669d(Parcel parcel) {
            super(parcel);
            this.f3893a = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3893a);
        }

        public C0669d(Parcelable parcelable, int i) {
            super(parcelable);
            this.f3893a = i;
        }
    }

    /* renamed from: d */
    public void m7181d(Preference preference) {
        m7179e(preference);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7156a(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(C0669d.class)) {
            C0669d c0669d = (C0669d) parcelable;
            this.f3889R = c0669d.f3893a;
            super.mo7156a(c0669d.getSuperState());
            return;
        }
        super.mo7156a(parcelable);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: b */
    public void mo7184b(Bundle bundle) {
        super.mo7184b(bundle);
        int m7187L = m7187L();
        for (int i = 0; i < m7187L; i++) {
            m7177g(i).mo7184b(bundle);
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
