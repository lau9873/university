package p068b.p069a;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.versionedparcelable.VersionedParcel;

/* renamed from: b.a.a */
/* loaded from: classes.dex */
public class VersionedParcelParcel extends VersionedParcel {

    /* renamed from: a */
    public final SparseIntArray f4517a;

    /* renamed from: b */
    public final Parcel f4518b;

    /* renamed from: c */
    public final int f4519c;

    /* renamed from: d */
    public final int f4520d;

    /* renamed from: e */
    public final String f4521e;

    /* renamed from: f */
    public int f4522f;

    /* renamed from: g */
    public int f4523g;

    public VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: a */
    public boolean mo6251a(int i) {
        int m6243d = m6243d(i);
        if (m6243d == -1) {
            return false;
        }
        this.f4518b.setDataPosition(m6243d);
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: b */
    public void mo6246b(int i) {
        mo6252a();
        this.f4522f = i;
        this.f4517a.put(i, this.f4518b.dataPosition());
        mo6245c(0);
        mo6245c(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: c */
    public void mo6245c(int i) {
        this.f4518b.writeInt(i);
    }

    /* renamed from: d */
    public final int m6243d(int i) {
        int readInt;
        do {
            int i2 = this.f4523g;
            if (i2 >= this.f4520d) {
                return -1;
            }
            this.f4518b.setDataPosition(i2);
            int readInt2 = this.f4518b.readInt();
            readInt = this.f4518b.readInt();
            this.f4523g += readInt2;
        } while (readInt != i);
        return this.f4518b.dataPosition();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: e */
    public int mo6242e() {
        return this.f4518b.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: f */
    public <T extends Parcelable> T mo6241f() {
        return (T) this.f4518b.readParcelable(VersionedParcelParcel.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: g */
    public String mo6240g() {
        return this.f4518b.readString();
    }

    public VersionedParcelParcel(Parcel parcel, int i, int i2, String str) {
        this.f4517a = new SparseIntArray();
        this.f4522f = -1;
        this.f4523g = 0;
        this.f4518b = parcel;
        this.f4519c = i;
        this.f4520d = i2;
        this.f4523g = this.f4519c;
        this.f4521e = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: a */
    public void mo6252a() {
        int i = this.f4522f;
        if (i >= 0) {
            int i2 = this.f4517a.get(i);
            int dataPosition = this.f4518b.dataPosition();
            this.f4518b.setDataPosition(i2);
            this.f4518b.writeInt(dataPosition - i2);
            this.f4518b.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: b */
    public VersionedParcel mo6247b() {
        Parcel parcel = this.f4518b;
        int dataPosition = parcel.dataPosition();
        int i = this.f4523g;
        if (i == this.f4519c) {
            i = this.f4520d;
        }
        return new VersionedParcelParcel(parcel, dataPosition, i, this.f4521e + "  ");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: d */
    public byte[] mo6244d() {
        int readInt = this.f4518b.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f4518b.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: a */
    public void mo6248a(byte[] bArr) {
        if (bArr != null) {
            this.f4518b.writeInt(bArr.length);
            this.f4518b.writeByteArray(bArr);
            return;
        }
        this.f4518b.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: a */
    public void mo6249a(String str) {
        this.f4518b.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    /* renamed from: a */
    public void mo6250a(Parcelable parcelable) {
        this.f4518b.writeParcelable(parcelable, 0);
    }
}
