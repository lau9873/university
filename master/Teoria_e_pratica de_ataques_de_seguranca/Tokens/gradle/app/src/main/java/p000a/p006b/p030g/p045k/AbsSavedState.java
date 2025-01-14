package p000a.p006b.p030g.p045k;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: a.b.g.k.a */
/* loaded from: classes.dex */
public abstract class AbsSavedState implements Parcelable {

    /* renamed from: a */
    public final Parcelable f1612a;

    /* renamed from: b */
    public static final AbsSavedState f1611b = new C0276a();
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new C0277b();

    /* compiled from: AbsSavedState.java */
    /* renamed from: a.b.g.k.a$a */
    /* loaded from: classes.dex */
    public static class C0276a extends AbsSavedState {
        public C0276a() {
            super((C0276a) null);
        }
    }

    /* compiled from: AbsSavedState.java */
    /* renamed from: a.b.g.k.a$b */
    /* loaded from: classes.dex */
    public static class C0277b implements Parcelable.ClassLoaderCreator<AbsSavedState> {
        @Override // android.os.Parcelable.Creator
        public AbsSavedState[] newArray(int i) {
            return new AbsSavedState[i];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.f1611b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }
    }

    public /* synthetic */ AbsSavedState(C0276a c0276a) {
        this();
    }

    /* renamed from: a */
    public final Parcelable m9588a() {
        return this.f1612a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f1612a, i);
    }

    public AbsSavedState() {
        this.f1612a = null;
    }

    public AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.f1612a = parcelable == f1611b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f1612a = readParcelable == null ? f1611b : readParcelable;
    }
}
