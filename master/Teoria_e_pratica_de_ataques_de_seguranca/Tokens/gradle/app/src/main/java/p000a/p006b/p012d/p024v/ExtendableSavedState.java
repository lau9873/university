package p000a.p006b.p012d.p024v;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import p000a.p006b.p030g.p044j.SimpleArrayMap;
import p000a.p006b.p030g.p045k.AbsSavedState;

/* renamed from: a.b.d.v.a */
/* loaded from: classes.dex */
public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new C0061a();

    /* renamed from: c */
    public final SimpleArrayMap<String, Bundle> f552c;

    /* compiled from: ExtendableSavedState.java */
    /* renamed from: a.b.d.v.a$a */
    /* loaded from: classes.dex */
    public static class C0061a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        @Override // android.os.Parcelable.Creator
        public ExtendableSavedState[] newArray(int i) {
            return new ExtendableSavedState[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public ExtendableSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        public ExtendableSavedState createFromParcel(Parcel parcel) {
            return new ExtendableSavedState(parcel, null, null);
        }
    }

    public /* synthetic */ ExtendableSavedState(Parcel parcel, ClassLoader classLoader, C0061a c0061a) {
        this(parcel, classLoader);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f552c + "}";
    }

    @Override // p000a.p006b.p030g.p045k.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.f552c.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.f552c.m9609c(i2);
            bundleArr[i2] = this.f552c.m9607e(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.f552c = new SimpleArrayMap<>();
    }

    public ExtendableSavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f552c = new SimpleArrayMap<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f552c.put(strArr[i], bundleArr[i]);
        }
    }
}
