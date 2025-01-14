package b.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.versionedparcelable.VersionedParcel;
/* compiled from: VersionedParcelParcel.java */
/* loaded from: classes.dex */
public class a extends VersionedParcel {

    /* renamed from: a  reason: collision with root package name */
    public final SparseIntArray f2727a;

    /* renamed from: b  reason: collision with root package name */
    public final Parcel f2728b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2729c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2730d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2731e;

    /* renamed from: f  reason: collision with root package name */
    public int f2732f;

    /* renamed from: g  reason: collision with root package name */
    public int f2733g;

    public a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean a(int i2) {
        int d2 = d(i2);
        if (d2 == -1) {
            return false;
        }
        this.f2728b.setDataPosition(d2);
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void b(int i2) {
        a();
        this.f2732f = i2;
        this.f2727a.put(i2, this.f2728b.dataPosition());
        c(0);
        c(i2);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void c(int i2) {
        this.f2728b.writeInt(i2);
    }

    public final int d(int i2) {
        int readInt;
        do {
            int i3 = this.f2733g;
            if (i3 >= this.f2730d) {
                return -1;
            }
            this.f2728b.setDataPosition(i3);
            int readInt2 = this.f2728b.readInt();
            readInt = this.f2728b.readInt();
            this.f2733g += readInt2;
        } while (readInt != i2);
        return this.f2728b.dataPosition();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int e() {
        return this.f2728b.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T f() {
        return (T) this.f2728b.readParcelable(a.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String g() {
        return this.f2728b.readString();
    }

    public a(Parcel parcel, int i2, int i3, String str) {
        this.f2727a = new SparseIntArray();
        this.f2732f = -1;
        this.f2733g = 0;
        this.f2728b = parcel;
        this.f2729c = i2;
        this.f2730d = i3;
        this.f2733g = this.f2729c;
        this.f2731e = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i2 = this.f2732f;
        if (i2 >= 0) {
            int i3 = this.f2727a.get(i2);
            int dataPosition = this.f2728b.dataPosition();
            this.f2728b.setDataPosition(i3);
            this.f2728b.writeInt(dataPosition - i3);
            this.f2728b.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel b() {
        Parcel parcel = this.f2728b;
        int dataPosition = parcel.dataPosition();
        int i2 = this.f2733g;
        if (i2 == this.f2729c) {
            i2 = this.f2730d;
        }
        return new a(parcel, dataPosition, i2, this.f2731e + "  ");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] d() {
        int readInt = this.f2728b.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f2728b.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a(byte[] bArr) {
        if (bArr != null) {
            this.f2728b.writeInt(bArr.length);
            this.f2728b.writeByteArray(bArr);
            return;
        }
        this.f2728b.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a(String str) {
        this.f2728b.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a(Parcelable parcelable) {
        this.f2728b.writeParcelable(parcelable, 0);
    }
}
