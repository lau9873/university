package a.b.g.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
/* compiled from: FragmentState.java */
/* loaded from: classes.dex */
public final class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f740a;

    /* renamed from: b  reason: collision with root package name */
    public final int f741b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f742c;

    /* renamed from: d  reason: collision with root package name */
    public final int f743d;

    /* renamed from: e  reason: collision with root package name */
    public final int f744e;

    /* renamed from: f  reason: collision with root package name */
    public final String f745f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f746g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f747h;

    /* renamed from: i  reason: collision with root package name */
    public final Bundle f748i;
    public final boolean j;
    public Bundle k;
    public Fragment m;

    /* compiled from: FragmentState.java */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<o> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public o[] newArray(int i2) {
            return new o[i2];
        }
    }

    public o(Fragment fragment) {
        this.f740a = fragment.getClass().getName();
        this.f741b = fragment.f2252e;
        this.f742c = fragment.n;
        this.f743d = fragment.y;
        this.f744e = fragment.z;
        this.f745f = fragment.A;
        this.f746g = fragment.D;
        this.f747h = fragment.C;
        this.f748i = fragment.f2254g;
        this.j = fragment.B;
    }

    public Fragment a(j jVar, h hVar, Fragment fragment, m mVar, a.a.b.p pVar) {
        if (this.m == null) {
            Context c2 = jVar.c();
            Bundle bundle = this.f748i;
            if (bundle != null) {
                bundle.setClassLoader(c2.getClassLoader());
            }
            if (hVar != null) {
                this.m = hVar.a(c2, this.f740a, this.f748i);
            } else {
                this.m = Fragment.a(c2, this.f740a, this.f748i);
            }
            Bundle bundle2 = this.k;
            if (bundle2 != null) {
                bundle2.setClassLoader(c2.getClassLoader());
                this.m.f2249b = this.k;
            }
            this.m.a(this.f741b, fragment);
            Fragment fragment2 = this.m;
            fragment2.n = this.f742c;
            fragment2.p = true;
            fragment2.y = this.f743d;
            fragment2.z = this.f744e;
            fragment2.A = this.f745f;
            fragment2.D = this.f746g;
            fragment2.C = this.f747h;
            fragment2.B = this.j;
            fragment2.s = jVar.f689d;
            if (l.F) {
                Log.v("FragmentManager", "Instantiated fragment " + this.m);
            }
        }
        Fragment fragment3 = this.m;
        fragment3.v = mVar;
        fragment3.w = pVar;
        return fragment3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f740a);
        parcel.writeInt(this.f741b);
        parcel.writeInt(this.f742c ? 1 : 0);
        parcel.writeInt(this.f743d);
        parcel.writeInt(this.f744e);
        parcel.writeString(this.f745f);
        parcel.writeInt(this.f746g ? 1 : 0);
        parcel.writeInt(this.f747h ? 1 : 0);
        parcel.writeBundle(this.f748i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
    }

    public o(Parcel parcel) {
        this.f740a = parcel.readString();
        this.f741b = parcel.readInt();
        this.f742c = parcel.readInt() != 0;
        this.f743d = parcel.readInt();
        this.f744e = parcel.readInt();
        this.f745f = parcel.readString();
        this.f746g = parcel.readInt() != 0;
        this.f747h = parcel.readInt() != 0;
        this.f748i = parcel.readBundle();
        this.j = parcel.readInt() != 0;
        this.k = parcel.readBundle();
    }
}
