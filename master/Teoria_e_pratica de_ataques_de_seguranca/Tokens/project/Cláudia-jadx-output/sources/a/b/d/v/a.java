package a.b.d.v;

import a.b.g.j.n;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ExtendableSavedState.java */
/* loaded from: classes.dex */
public class a extends a.b.g.k.a {
    public static final Parcelable.Creator<a> CREATOR = new C0006a();

    /* renamed from: c  reason: collision with root package name */
    public final n<String, Bundle> f297c;

    /* compiled from: ExtendableSavedState.java */
    /* renamed from: a.b.d.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0006a implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i2) {
            return new a[i2];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null, null);
        }
    }

    public /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0006a c0006a) {
        this(parcel, classLoader);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f297c + "}";
    }

    @Override // a.b.g.k.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        int size = this.f297c.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = this.f297c.c(i3);
            bundleArr[i3] = this.f297c.e(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f297c = new n<>();
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f297c = new n<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f297c.put(strArr[i2], bundleArr[i2]);
        }
    }
}
