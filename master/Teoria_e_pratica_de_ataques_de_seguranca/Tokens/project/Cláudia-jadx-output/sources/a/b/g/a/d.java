package a.b.g.a;

import a.b.g.a.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public final class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f653a;

    /* renamed from: b  reason: collision with root package name */
    public final int f654b;

    /* renamed from: c  reason: collision with root package name */
    public final int f655c;

    /* renamed from: d  reason: collision with root package name */
    public final String f656d;

    /* renamed from: e  reason: collision with root package name */
    public final int f657e;

    /* renamed from: f  reason: collision with root package name */
    public final int f658f;

    /* renamed from: g  reason: collision with root package name */
    public final CharSequence f659g;

    /* renamed from: h  reason: collision with root package name */
    public final int f660h;

    /* renamed from: i  reason: collision with root package name */
    public final CharSequence f661i;
    public final ArrayList<String> j;
    public final ArrayList<String> k;
    public final boolean m;

    /* compiled from: BackStackRecord.java */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<d> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public d[] newArray(int i2) {
            return new d[i2];
        }
    }

    public d(c cVar) {
        int size = cVar.f636b.size();
        this.f653a = new int[size * 6];
        if (cVar.f643i) {
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                c.a aVar = cVar.f636b.get(i3);
                int[] iArr = this.f653a;
                int i4 = i2 + 1;
                iArr[i2] = aVar.f644a;
                int i5 = i4 + 1;
                Fragment fragment = aVar.f645b;
                iArr[i4] = fragment != null ? fragment.f2252e : -1;
                int[] iArr2 = this.f653a;
                int i6 = i5 + 1;
                iArr2[i5] = aVar.f646c;
                int i7 = i6 + 1;
                iArr2[i6] = aVar.f647d;
                int i8 = i7 + 1;
                iArr2[i7] = aVar.f648e;
                i2 = i8 + 1;
                iArr2[i8] = aVar.f649f;
            }
            this.f654b = cVar.f641g;
            this.f655c = cVar.f642h;
            this.f656d = cVar.k;
            this.f657e = cVar.m;
            this.f658f = cVar.n;
            this.f659g = cVar.o;
            this.f660h = cVar.p;
            this.f661i = cVar.q;
            this.j = cVar.r;
            this.k = cVar.s;
            this.m = cVar.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public c a(l lVar) {
        c cVar = new c(lVar);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f653a.length) {
            c.a aVar = new c.a();
            int i4 = i2 + 1;
            aVar.f644a = this.f653a[i2];
            if (l.F) {
                Log.v("FragmentManager", "Instantiate " + cVar + " op #" + i3 + " base fragment #" + this.f653a[i4]);
            }
            int i5 = i4 + 1;
            int i6 = this.f653a[i4];
            if (i6 >= 0) {
                aVar.f645b = lVar.f694e.get(i6);
            } else {
                aVar.f645b = null;
            }
            int[] iArr = this.f653a;
            int i7 = i5 + 1;
            aVar.f646c = iArr[i5];
            int i8 = i7 + 1;
            aVar.f647d = iArr[i7];
            int i9 = i8 + 1;
            aVar.f648e = iArr[i8];
            aVar.f649f = iArr[i9];
            cVar.f637c = aVar.f646c;
            cVar.f638d = aVar.f647d;
            cVar.f639e = aVar.f648e;
            cVar.f640f = aVar.f649f;
            cVar.a(aVar);
            i3++;
            i2 = i9 + 1;
        }
        cVar.f641g = this.f654b;
        cVar.f642h = this.f655c;
        cVar.k = this.f656d;
        cVar.m = this.f657e;
        cVar.f643i = true;
        cVar.n = this.f658f;
        cVar.o = this.f659g;
        cVar.p = this.f660h;
        cVar.q = this.f661i;
        cVar.r = this.j;
        cVar.s = this.k;
        cVar.t = this.m;
        cVar.b(1);
        return cVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f653a);
        parcel.writeInt(this.f654b);
        parcel.writeInt(this.f655c);
        parcel.writeString(this.f656d);
        parcel.writeInt(this.f657e);
        parcel.writeInt(this.f658f);
        TextUtils.writeToParcel(this.f659g, parcel, 0);
        parcel.writeInt(this.f660h);
        TextUtils.writeToParcel(this.f661i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeInt(this.m ? 1 : 0);
    }

    public d(Parcel parcel) {
        this.f653a = parcel.createIntArray();
        this.f654b = parcel.readInt();
        this.f655c = parcel.readInt();
        this.f656d = parcel.readString();
        this.f657e = parcel.readInt();
        this.f658f = parcel.readInt();
        this.f659g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f660h = parcel.readInt();
        this.f661i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.m = parcel.readInt() != 0;
    }
}
