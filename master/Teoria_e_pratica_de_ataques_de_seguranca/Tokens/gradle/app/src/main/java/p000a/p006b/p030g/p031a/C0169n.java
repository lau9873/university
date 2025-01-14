package p000a.p006b.p030g.p031a;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FragmentManager.java */
/* renamed from: a.b.g.a.n */
/* loaded from: classes.dex */
public final class C0169n implements Parcelable {
    public static final Parcelable.Creator<C0169n> CREATOR = new C0170a();

    /* renamed from: a */
    public FragmentState[] f1200a;

    /* renamed from: b */
    public int[] f1201b;

    /* renamed from: c */
    public C0142d[] f1202c;

    /* renamed from: d */
    public int f1203d;

    /* renamed from: e */
    public int f1204e;

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.n$a */
    /* loaded from: classes.dex */
    public static class C0170a implements Parcelable.Creator<C0169n> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public C0169n createFromParcel(Parcel parcel) {
            return new C0169n(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public C0169n[] newArray(int i) {
            return new C0169n[i];
        }
    }

    public C0169n() {
        this.f1203d = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f1200a, i);
        parcel.writeIntArray(this.f1201b);
        parcel.writeTypedArray(this.f1202c, i);
        parcel.writeInt(this.f1203d);
        parcel.writeInt(this.f1204e);
    }

    public C0169n(Parcel parcel) {
        this.f1203d = -1;
        this.f1200a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f1201b = parcel.createIntArray();
        this.f1202c = (C0142d[]) parcel.createTypedArray(C0142d.CREATOR);
        this.f1203d = parcel.readInt();
        this.f1204e = parcel.readInt();
    }
}
