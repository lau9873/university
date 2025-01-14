package android.support.v14.preference;

import a.b.g.b.g.g;
import a.b.h.f.m;
import a.b.h.f.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.preference.Preference;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import android.util.AttributeSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class MultiSelectListPreference extends AbstractMultiSelectListPreference {
    public CharSequence[] T;
    public CharSequence[] U;
    public Set<String> V;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.V = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.MultiSelectListPreference, i2, i3);
        this.T = g.d(obtainStyledAttributes, s.MultiSelectListPreference_entries, s.MultiSelectListPreference_android_entries);
        this.U = g.d(obtainStyledAttributes, s.MultiSelectListPreference_entryValues, s.MultiSelectListPreference_android_entryValues);
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.v7.preference.Preference
    public Parcelable D() {
        Parcelable D = super.D();
        if (v()) {
            return D;
        }
        a aVar = new a(D);
        aVar.f2246a = R();
        return aVar;
    }

    @Override // android.support.v7.preference.internal.AbstractMultiSelectListPreference
    public CharSequence[] P() {
        return this.T;
    }

    @Override // android.support.v7.preference.internal.AbstractMultiSelectListPreference
    public CharSequence[] Q() {
        return this.U;
    }

    @Override // android.support.v7.preference.internal.AbstractMultiSelectListPreference
    public Set<String> R() {
        return this.V;
    }

    @Override // android.support.v7.preference.Preference
    public Object a(TypedArray typedArray, int i2) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // android.support.v7.preference.Preference
    public void b(Object obj) {
        c(a((Set) obj));
    }

    @Override // android.support.v7.preference.internal.AbstractMultiSelectListPreference
    public void c(Set<String> set) {
        this.V.clear();
        this.V.addAll(set);
        b(set);
    }

    @Override // android.support.v7.preference.Preference
    public void a(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(a.class)) {
            a aVar = (a) parcelable;
            super.a(aVar.getSuperState());
            c(aVar.f2246a);
            return;
        }
        super.a(parcelable);
    }

    /* loaded from: classes.dex */
    public static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0046a();

        /* renamed from: a  reason: collision with root package name */
        public Set<String> f2246a;

        /* renamed from: android.support.v14.preference.MultiSelectListPreference$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0046a implements Parcelable.Creator<a> {
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
            int readInt = parcel.readInt();
            this.f2246a = new HashSet();
            String[] strArr = new String[readInt];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f2246a, strArr);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2246a.size());
            Set<String> set = this.f2246a;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, m.dialogPreferenceStyle, 16842897));
    }
}
