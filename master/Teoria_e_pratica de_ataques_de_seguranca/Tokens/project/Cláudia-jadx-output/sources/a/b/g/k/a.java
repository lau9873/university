package a.b.g.k;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: AbsSavedState.java */
/* loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    public final Parcelable f1101a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f1100b = new C0032a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* compiled from: AbsSavedState.java */
    /* renamed from: a.b.g.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0032a extends a {
        public C0032a() {
            super((C0032a) null);
        }
    }

    /* compiled from: AbsSavedState.java */
    /* loaded from: classes.dex */
    public static class b implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i2) {
            return new a[i2];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f1100b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }
    }

    public /* synthetic */ a(C0032a c0032a) {
        this();
    }

    public final Parcelable a() {
        return this.f1101a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f1101a, i2);
    }

    public a() {
        this.f1101a = null;
    }

    public a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f1101a = parcelable == f1100b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f1101a = readParcelable == null ? f1100b : readParcelable;
    }
}
