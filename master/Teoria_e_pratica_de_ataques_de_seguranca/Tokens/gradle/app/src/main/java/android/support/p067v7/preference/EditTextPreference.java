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

/* renamed from: android.support.v7.preference.EditTextPreference */
/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    /* renamed from: T */
    public String f3838T;

    public EditTextPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: D */
    public Parcelable mo7160D() {
        Parcelable mo7160D = super.mo7160D();
        if (m7201v()) {
            return mo7160D;
        }
        C0656a c0656a = new C0656a(mo7160D);
        c0656a.f3839a = m7266P();
        return c0656a;
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: G */
    public boolean mo7159G() {
        return TextUtils.isEmpty(this.f3838T) || super.mo7159G();
    }

    /* renamed from: P */
    public String m7266P() {
        return this.f3838T;
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public Object mo7157a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: b */
    public void mo7153b(Object obj) {
        m7265d(m7230b((String) obj));
    }

    /* renamed from: d */
    public void m7265d(String str) {
        boolean mo7159G = mo7159G();
        this.f3838T = str;
        m7224c(str);
        boolean mo7159G2 = mo7159G();
        if (mo7159G2 != mo7159G) {
            mo7183b(mo7159G2);
        }
    }

    /* renamed from: android.support.v7.preference.EditTextPreference$a */
    /* loaded from: classes.dex */
    public static class C0656a extends Preference.C0661b {
        public static final Parcelable.Creator<C0656a> CREATOR = new C0657a();

        /* renamed from: a */
        public String f3839a;

        /* renamed from: android.support.v7.preference.EditTextPreference$a$a */
        /* loaded from: classes.dex */
        public static class C0657a implements Parcelable.Creator<C0656a> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0656a createFromParcel(Parcel parcel) {
                return new C0656a(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0656a[] newArray(int i) {
                return new C0656a[i];
            }
        }

        public C0656a(Parcel parcel) {
            super(parcel);
            this.f3839a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f3839a);
        }

        public C0656a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7156a(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(C0656a.class)) {
            C0656a c0656a = (C0656a) parcelable;
            super.mo7156a(c0656a.getSuperState());
            m7265d(c0656a.f3839a);
            return;
        }
        super.mo7156a(parcelable);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m9946a(context, C0399m.editTextPreferenceStyle, 16842898));
    }
}
