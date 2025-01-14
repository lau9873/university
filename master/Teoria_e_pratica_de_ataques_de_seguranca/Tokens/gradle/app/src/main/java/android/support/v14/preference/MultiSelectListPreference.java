package android.support.v14.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p067v7.preference.Preference;
import android.support.p067v7.preference.internal.AbstractMultiSelectListPreference;
import android.util.AttributeSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p049h.p057f.C0399m;
import p000a.p006b.p049h.p057f.C0405s;

/* loaded from: classes.dex */
public class MultiSelectListPreference extends AbstractMultiSelectListPreference {

    /* renamed from: T */
    public CharSequence[] f3454T;

    /* renamed from: U */
    public CharSequence[] f3455U;

    /* renamed from: V */
    public Set<String> f3456V;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3456V = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0405s.MultiSelectListPreference, i, i2);
        this.f3454T = TypedArrayUtils.m9929d(obtainStyledAttributes, C0405s.MultiSelectListPreference_entries, C0405s.MultiSelectListPreference_android_entries);
        this.f3455U = TypedArrayUtils.m9929d(obtainStyledAttributes, C0405s.MultiSelectListPreference_entryValues, C0405s.MultiSelectListPreference_android_entryValues);
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: D */
    public Parcelable mo7160D() {
        Parcelable mo7160D = super.mo7160D();
        if (m7201v()) {
            return mo7160D;
        }
        C0597a c0597a = new C0597a(mo7160D);
        c0597a.f3457a = mo7146R();
        return c0597a;
    }

    @Override // android.support.p067v7.preference.internal.AbstractMultiSelectListPreference
    /* renamed from: P */
    public CharSequence[] mo7148P() {
        return this.f3454T;
    }

    @Override // android.support.p067v7.preference.internal.AbstractMultiSelectListPreference
    /* renamed from: Q */
    public CharSequence[] mo7147Q() {
        return this.f3455U;
    }

    @Override // android.support.p067v7.preference.internal.AbstractMultiSelectListPreference
    /* renamed from: R */
    public Set<String> mo7146R() {
        return this.f3456V;
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public Object mo7157a(TypedArray typedArray, int i) {
        CharSequence[] textArray = typedArray.getTextArray(i);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: b */
    public void mo7153b(Object obj) {
        mo7145c(m7238a((Set) obj));
    }

    @Override // android.support.p067v7.preference.internal.AbstractMultiSelectListPreference
    /* renamed from: c */
    public void mo7145c(Set<String> set) {
        this.f3456V.clear();
        this.f3456V.addAll(set);
        m7229b(set);
    }

    @Override // android.support.p067v7.preference.Preference
    /* renamed from: a */
    public void mo7156a(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(C0597a.class)) {
            C0597a c0597a = (C0597a) parcelable;
            super.mo7156a(c0597a.getSuperState());
            mo7145c(c0597a.f3457a);
            return;
        }
        super.mo7156a(parcelable);
    }

    /* renamed from: android.support.v14.preference.MultiSelectListPreference$a */
    /* loaded from: classes.dex */
    public static class C0597a extends Preference.C0661b {
        public static final Parcelable.Creator<C0597a> CREATOR = new C0598a();

        /* renamed from: a */
        public Set<String> f3457a;

        /* renamed from: android.support.v14.preference.MultiSelectListPreference$a$a */
        /* loaded from: classes.dex */
        public static class C0598a implements Parcelable.Creator<C0597a> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0597a createFromParcel(Parcel parcel) {
                return new C0597a(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public C0597a[] newArray(int i) {
                return new C0597a[i];
            }
        }

        public C0597a(Parcel parcel) {
            super(parcel);
            int readInt = parcel.readInt();
            this.f3457a = new HashSet();
            String[] strArr = new String[readInt];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f3457a, strArr);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3457a.size());
            Set<String> set = this.f3457a;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }

        public C0597a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m9946a(context, C0399m.dialogPreferenceStyle, 16842897));
    }
}
