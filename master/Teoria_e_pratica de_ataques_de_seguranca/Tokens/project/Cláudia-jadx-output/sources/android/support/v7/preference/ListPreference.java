package android.support.v7.preference;

import a.b.g.b.g.g;
import a.b.h.f.m;
import a.b.h.f.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    public CharSequence[] T;
    public CharSequence[] U;
    public String V;
    public String W;
    public boolean X;

    public ListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.ListPreference, i2, i3);
        this.T = g.d(obtainStyledAttributes, s.ListPreference_entries, s.ListPreference_android_entries);
        this.U = g.d(obtainStyledAttributes, s.ListPreference_entryValues, s.ListPreference_android_entryValues);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, s.Preference, i2, i3);
        this.W = g.b(obtainStyledAttributes2, s.Preference_summary, s.Preference_android_summary);
        obtainStyledAttributes2.recycle();
    }

    @Override // android.support.v7.preference.Preference
    public Parcelable D() {
        Parcelable D = super.D();
        if (v()) {
            return D;
        }
        a aVar = new a(D);
        aVar.f2434a = S();
        return aVar;
    }

    public CharSequence[] P() {
        return this.T;
    }

    public CharSequence Q() {
        CharSequence[] charSequenceArr;
        int T = T();
        if (T < 0 || (charSequenceArr = this.T) == null) {
            return null;
        }
        return charSequenceArr[T];
    }

    public CharSequence[] R() {
        return this.U;
    }

    public String S() {
        return this.V;
    }

    public final int T() {
        return d(this.V);
    }

    @Override // android.support.v7.preference.Preference
    public void a(CharSequence charSequence) {
        super.a(charSequence);
        if (charSequence == null && this.W != null) {
            this.W = null;
        } else if (charSequence == null || charSequence.equals(this.W)) {
        } else {
            this.W = charSequence.toString();
        }
    }

    @Override // android.support.v7.preference.Preference
    public void b(Object obj) {
        e(b((String) obj));
    }

    public int d(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.U) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.U[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public void e(String str) {
        boolean z = !TextUtils.equals(this.V, str);
        if (z || !this.X) {
            this.V = str;
            this.X = true;
            c(str);
            if (z) {
                y();
            }
        }
    }

    @Override // android.support.v7.preference.Preference
    public CharSequence q() {
        CharSequence Q = Q();
        String str = this.W;
        if (str == null) {
            return super.q();
        }
        Object[] objArr = new Object[1];
        if (Q == null) {
            Q = "";
        }
        objArr[0] = Q;
        return String.format(str, objArr);
    }

    /* loaded from: classes.dex */
    public static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0048a();

        /* renamed from: a  reason: collision with root package name */
        public String f2434a;

        /* renamed from: android.support.v7.preference.ListPreference$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0048a implements Parcelable.Creator<a> {
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
            this.f2434a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f2434a);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.support.v7.preference.Preference
    public Object a(TypedArray typedArray, int i2) {
        return typedArray.getString(i2);
    }

    @Override // android.support.v7.preference.Preference
    public void a(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(a.class)) {
            a aVar = (a) parcelable;
            super.a(aVar.getSuperState());
            e(aVar.f2434a);
            return;
        }
        super.a(parcelable);
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, m.dialogPreferenceStyle, 16842897));
    }
}
