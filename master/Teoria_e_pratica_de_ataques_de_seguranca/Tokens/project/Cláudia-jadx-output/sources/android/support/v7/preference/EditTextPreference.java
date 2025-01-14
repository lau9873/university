package android.support.v7.preference;

import a.b.g.b.g.g;
import a.b.h.f.m;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    public String T;

    public EditTextPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // android.support.v7.preference.Preference
    public Parcelable D() {
        Parcelable D = super.D();
        if (v()) {
            return D;
        }
        a aVar = new a(D);
        aVar.f2433a = P();
        return aVar;
    }

    @Override // android.support.v7.preference.Preference
    public boolean G() {
        return TextUtils.isEmpty(this.T) || super.G();
    }

    public String P() {
        return this.T;
    }

    @Override // android.support.v7.preference.Preference
    public Object a(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    @Override // android.support.v7.preference.Preference
    public void b(Object obj) {
        d(b((String) obj));
    }

    public void d(String str) {
        boolean G = G();
        this.T = str;
        c(str);
        boolean G2 = G();
        if (G2 != G) {
            b(G2);
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0047a();

        /* renamed from: a  reason: collision with root package name */
        public String f2433a;

        /* renamed from: android.support.v7.preference.EditTextPreference$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0047a implements Parcelable.Creator<a> {
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
            this.f2433a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f2433a);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    @Override // android.support.v7.preference.Preference
    public void a(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(a.class)) {
            a aVar = (a) parcelable;
            super.a(aVar.getSuperState());
            d(aVar.f2433a);
            return;
        }
        super.a(parcelable);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, m.editTextPreferenceStyle, 16842898));
    }
}
