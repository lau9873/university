package android.support.v7.preference;

import a.b.h.f.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.preference.Preference;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    public CharSequence N;
    public CharSequence O;
    public boolean P;
    public boolean Q;
    public boolean R;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // android.support.v7.preference.Preference
    public void B() {
        super.B();
        boolean z = !J();
        if (a(Boolean.valueOf(z))) {
            d(z);
        }
    }

    @Override // android.support.v7.preference.Preference
    public Parcelable D() {
        Parcelable D = super.D();
        if (v()) {
            return D;
        }
        a aVar = new a(D);
        aVar.f2453a = J();
        return aVar;
    }

    @Override // android.support.v7.preference.Preference
    public boolean G() {
        return (this.R ? this.P : !this.P) || super.G();
    }

    public boolean J() {
        return this.P;
    }

    @Override // android.support.v7.preference.Preference
    public Object a(TypedArray typedArray, int i2) {
        return Boolean.valueOf(typedArray.getBoolean(i2, false));
    }

    @Override // android.support.v7.preference.Preference
    public void b(Object obj) {
        if (obj == null) {
            obj = false;
        }
        d(a(((Boolean) obj).booleanValue()));
    }

    public void c(CharSequence charSequence) {
        this.O = charSequence;
        if (J()) {
            return;
        }
        y();
    }

    public void d(boolean z) {
        boolean z2 = this.P != z;
        if (z2 || !this.Q) {
            this.P = z;
            this.Q = true;
            c(z);
            if (z2) {
                b(G());
                y();
            }
        }
    }

    public void e(boolean z) {
        this.R = z;
    }

    /* loaded from: classes.dex */
    public static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0049a();

        /* renamed from: a  reason: collision with root package name */
        public boolean f2453a;

        /* renamed from: android.support.v7.preference.TwoStatePreference$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0049a implements Parcelable.Creator<a> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public a[] newArray(int i2) {
                return new a[i2];
            }
        }

        public a(Parcel parcel) {
            super(parcel);
            this.f2453a = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2453a ? 1 : 0);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    @Override // android.support.v7.preference.Preference
    public void a(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(a.class)) {
            a aVar = (a) parcelable;
            super.a(aVar.getSuperState());
            d(aVar.f2453a);
            return;
        }
        super.a(parcelable);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void b(l lVar) {
        b(lVar.c(16908304));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0 = 1
            boolean r1 = r4.P
            r2 = 0
            if (r1 == 0) goto L1c
            java.lang.CharSequence r1 = r4.N
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1c
            java.lang.CharSequence r0 = r4.N
            r5.setText(r0)
        L1a:
            r0 = 0
            goto L2e
        L1c:
            boolean r1 = r4.P
            if (r1 != 0) goto L2e
            java.lang.CharSequence r1 = r4.O
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L2e
            java.lang.CharSequence r0 = r4.O
            r5.setText(r0)
            goto L1a
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r1 = r4.q()
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.preference.TwoStatePreference.b(android.view.View):void");
    }

    public void d(CharSequence charSequence) {
        this.N = charSequence;
        if (J()) {
            y();
        }
    }
}
