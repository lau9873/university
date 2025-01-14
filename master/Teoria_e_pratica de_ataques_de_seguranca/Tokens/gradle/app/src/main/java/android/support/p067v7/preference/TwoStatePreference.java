package android.support.p067v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p067v7.preference.Preference;
import android.util.AttributeSet;
import p000a.p006b.p049h.p057f.PreferenceViewHolder;

/* renamed from: android.support.v7.preference.TwoStatePreference */
/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: N */
    public CharSequence f3915N;

    /* renamed from: O */
    public CharSequence f3916O;

    /* renamed from: P */
    public boolean f3917P;

    /* renamed from: Q */
    public boolean f3918Q;

    /* renamed from: R */
    public boolean f3919R;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: B */
    public void mo7161B() {
        super.mo7161B();
        boolean z = !m7158J();
        if (m7240a(Boolean.valueOf(z))) {
            m7150d(z);
        }
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: D */
    public Parcelable mo7160D() {
        Parcelable mo7160D = super.mo7160D();
        if (m7201v()) {
            return mo7160D;
        }
        C0676a c0676a = new C0676a(mo7160D);
        c0676a.f3920a = m7158J();
        return c0676a;
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: G */
    public boolean mo7159G() {
        return (this.f3919R ? this.f3917P : !this.f3917P) || super.mo7159G();
    }

    /* renamed from: J */
    public boolean m7158J() {
        return this.f3917P;
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public Object mo7157a(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: b */
    public void mo7153b(Object obj) {
        if (obj == null) {
            obj = false;
        }
        m7150d(m7237a(((Boolean) obj).booleanValue()));
    }

    /* renamed from: c */
    public void m7152c(CharSequence charSequence) {
        this.f3916O = charSequence;
        if (m7158J()) {
            return;
        }
        mo7198y();
    }

    /* renamed from: d */
    public void m7150d(boolean z) {
        boolean z2 = this.f3917P != z;
        if (z2 || !this.f3918Q) {
            this.f3917P = z;
            this.f3918Q = true;
            m7223c(z);
            if (z2) {
                mo7183b(mo7159G());
                mo7198y();
            }
        }
    }

    /* renamed from: e */
    public void m7149e(boolean z) {
        this.f3919R = z;
    }

    /* renamed from: android.support.v7.preference.TwoStatePreference$a */
    /* loaded from: classes.dex */
    public static class C0676a extends Preference.C0661b {
        public static final Parcelable.Creator<C0676a> CREATOR = new C0677a();

        /* renamed from: a */
        public boolean f3920a;

        /* renamed from: android.support.v7.preference.TwoStatePreference$a$a */
        /* loaded from: classes.dex */
        public static class C0677a implements Parcelable.Creator<C0676a> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0676a createFromParcel(Parcel parcel) {
                return new C0676a(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0676a[] newArray(int i) {
                return new C0676a[i];
            }
        }

        public C0676a(Parcel parcel) {
            super(parcel);
            this.f3920a = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3920a ? 1 : 0);
        }

        public C0676a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7156a(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(C0676a.class)) {
            C0676a c0676a = (C0676a) parcelable;
            super.mo7156a(c0676a.getSuperState());
            m7150d(c0676a.f3920a);
            return;
        }
        super.mo7156a(parcelable);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: b */
    public void m7155b(PreferenceViewHolder preferenceViewHolder) {
        m7154b(preferenceViewHolder.m8808c(16908304));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7154b(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0 = 1
            boolean r1 = r4.f3917P
            r2 = 0
            if (r1 == 0) goto L1c
            java.lang.CharSequence r1 = r4.f3915N
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1c
            java.lang.CharSequence r0 = r4.f3915N
            r5.setText(r0)
        L1a:
            r0 = 0
            goto L2e
        L1c:
            boolean r1 = r4.f3917P
            if (r1 != 0) goto L2e
            java.lang.CharSequence r1 = r4.f3916O
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L2e
            java.lang.CharSequence r0 = r4.f3916O
            r5.setText(r0)
            goto L1a
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r1 = r4.mo7205q()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L3e
            r5.setText(r1)
            r0 = 0
        L3e:
            r1 = 8
            if (r0 != 0) goto L43
            r1 = 0
        L43:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L4c
            r5.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p067v7.preference.TwoStatePreference.m7154b(android.view.View):void");
    }

    /* renamed from: d */
    public void m7151d(CharSequence charSequence) {
        this.f3915N = charSequence;
        if (m7158J()) {
            mo7198y();
        }
    }
}
