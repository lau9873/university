package android.support.p067v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p067v7.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p049h.p057f.C0399m;
import p000a.p006b.p049h.p057f.C0405s;

/* renamed from: android.support.v7.preference.ListPreference */
/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: T */
    public CharSequence[] f3840T;

    /* renamed from: U */
    public CharSequence[] f3841U;

    /* renamed from: V */
    public String f3842V;

    /* renamed from: W */
    public String f3843W;

    /* renamed from: X */
    public boolean f3844X;

    public ListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0405s.ListPreference, i, i2);
        this.f3840T = TypedArrayUtils.m9929d(obtainStyledAttributes, C0405s.ListPreference_entries, C0405s.ListPreference_android_entries);
        this.f3841U = TypedArrayUtils.m9929d(obtainStyledAttributes, C0405s.ListPreference_entryValues, C0405s.ListPreference_android_entryValues);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C0405s.Preference, i, i2);
        this.f3843W = TypedArrayUtils.m9935b(obtainStyledAttributes2, C0405s.Preference_summary, C0405s.Preference_android_summary);
        obtainStyledAttributes2.recycle();
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: D */
    public Parcelable mo7160D() {
        Parcelable mo7160D = super.mo7160D();
        if (m7201v()) {
            return mo7160D;
        }
        C0658a c0658a = new C0658a(mo7160D);
        c0658a.f3845a = m7261S();
        return c0658a;
    }

    /* renamed from: P */
    public CharSequence[] m7264P() {
        return this.f3840T;
    }

    /* renamed from: Q */
    public CharSequence m7263Q() {
        CharSequence[] charSequenceArr;
        int m7260T = m7260T();
        if (m7260T < 0 || (charSequenceArr = this.f3840T) == null) {
            return null;
        }
        return charSequenceArr[m7260T];
    }

    /* renamed from: R */
    public CharSequence[] m7262R() {
        return this.f3841U;
    }

    /* renamed from: S */
    public String m7261S() {
        return this.f3842V;
    }

    /* renamed from: T */
    public final int m7260T() {
        return m7259d(this.f3842V);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7241a(CharSequence charSequence) {
        super.mo7241a(charSequence);
        if (charSequence == null && this.f3843W != null) {
            this.f3843W = null;
        } else if (charSequence == null || charSequence.equals(this.f3843W)) {
        } else {
            this.f3843W = charSequence.toString();
        }
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: b */
    public void mo7153b(Object obj) {
        m7258e(m7230b((String) obj));
    }

    /* renamed from: d */
    public int m7259d(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f3841U) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.f3841U[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    /* renamed from: e */
    public void m7258e(String str) {
        boolean z = !TextUtils.equals(this.f3842V, str);
        if (z || !this.f3844X) {
            this.f3842V = str;
            this.f3844X = true;
            m7224c(str);
            if (z) {
                mo7198y();
            }
        }
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: q */
    public CharSequence mo7205q() {
        CharSequence m7263Q = m7263Q();
        String str = this.f3843W;
        if (str == null) {
            return super.mo7205q();
        }
        Object[] objArr = new Object[1];
        if (m7263Q == null) {
            m7263Q = "";
        }
        objArr[0] = m7263Q;
        return String.format(str, objArr);
    }

    /* renamed from: android.support.v7.preference.ListPreference$a */
    /* loaded from: classes.dex */
    public static class C0658a extends Preference.C0661b {
        public static final Parcelable.Creator<C0658a> CREATOR = new C0659a();

        /* renamed from: a */
        public String f3845a;

        /* renamed from: android.support.v7.preference.ListPreference$a$a */
        /* loaded from: classes.dex */
        public static class C0659a implements Parcelable.Creator<C0658a> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0658a createFromParcel(Parcel parcel) {
                return new C0658a(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0658a[] newArray(int i) {
                return new C0658a[i];
            }
        }

        public C0658a(Parcel parcel) {
            super(parcel);
            this.f3845a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f3845a);
        }

        public C0658a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public Object mo7157a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7156a(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(C0658a.class)) {
            C0658a c0658a = (C0658a) parcelable;
            super.mo7156a(c0658a.getSuperState());
            m7258e(c0658a.f3845a);
            return;
        }
        super.mo7156a(parcelable);
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m9946a(context, C0399m.dialogPreferenceStyle, 16842897));
    }
}
