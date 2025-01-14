package g.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* compiled from: Beacon.java */
/* loaded from: classes.dex */
public class c implements Parcelable, Serializable {
    @Deprecated
    public static final Parcelable.Creator<c> CREATOR;
    public static final List<Long> r = Collections.unmodifiableList(new ArrayList());
    public static boolean s;
    public static g.a.a.l.c t;

    /* renamed from: a  reason: collision with root package name */
    public List<f> f6046a;

    /* renamed from: b  reason: collision with root package name */
    public List<Long> f6047b;

    /* renamed from: c  reason: collision with root package name */
    public List<Long> f6048c;

    /* renamed from: d  reason: collision with root package name */
    public Double f6049d;

    /* renamed from: e  reason: collision with root package name */
    public int f6050e;

    /* renamed from: f  reason: collision with root package name */
    public int f6051f;

    /* renamed from: g  reason: collision with root package name */
    public String f6052g;

    /* renamed from: h  reason: collision with root package name */
    public int f6053h;

    /* renamed from: i  reason: collision with root package name */
    public int f6054i;
    public Double j;
    public int k;
    public int m;
    public int n;
    public String o;
    public String p;
    public boolean q;

    /* compiled from: Beacon.java */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<c> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public c[] newArray(int i2) {
            return new c[i2];
        }
    }

    static {
        Collections.unmodifiableList(new ArrayList());
        s = false;
        t = null;
        new g.a.a.k.b();
        CREATOR = new a();
    }

    @Deprecated
    public c(Parcel parcel) {
        this.f6053h = 0;
        this.f6054i = 0;
        this.j = null;
        this.n = -1;
        this.q = false;
        int readInt = parcel.readInt();
        this.f6046a = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f6046a.add(f.a(parcel.readString()));
        }
        this.f6049d = Double.valueOf(parcel.readDouble());
        this.f6050e = parcel.readInt();
        this.f6051f = parcel.readInt();
        this.f6052g = parcel.readString();
        this.k = parcel.readInt();
        this.n = parcel.readInt();
        int readInt2 = parcel.readInt();
        this.f6047b = new ArrayList(readInt2);
        for (int i3 = 0; i3 < readInt2; i3++) {
            this.f6047b.add(Long.valueOf(parcel.readLong()));
        }
        int readInt3 = parcel.readInt();
        this.f6048c = new ArrayList(readInt3);
        for (int i4 = 0; i4 < readInt3; i4++) {
            this.f6048c.add(Long.valueOf(parcel.readLong()));
        }
        this.m = parcel.readInt();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readByte() != 0;
        this.j = (Double) parcel.readValue(null);
        this.f6053h = parcel.readInt();
        this.f6054i = parcel.readInt();
    }

    public static void a(g.a.a.l.c cVar) {
        t = cVar;
    }

    public static g.a.a.l.c o() {
        return t;
    }

    public static boolean p() {
        return s;
    }

    public void b(int i2) {
        this.f6054i = i2;
    }

    public void c(int i2) {
        this.f6050e = i2;
    }

    public void d(int i2) {
        this.f6053h = i2;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    public double e() {
        if (this.f6049d == null) {
            double d2 = this.f6050e;
            Double d3 = this.j;
            if (d3 != null) {
                d2 = d3.doubleValue();
            } else {
                g.a.a.m.d.a("Beacon", "Not using running average RSSI because it is null", new Object[0]);
            }
            this.f6049d = a(this.f6051f, d2);
        }
        return this.f6049d.doubleValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f6046a.equals(cVar.f6046a)) {
                if (s) {
                    return b().equals(cVar.b());
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public List<Long> f() {
        if (this.f6048c.getClass().isInstance(r)) {
            return this.f6048c;
        }
        return Collections.unmodifiableList(this.f6048c);
    }

    public f g() {
        return this.f6046a.get(0);
    }

    public f h() {
        return this.f6046a.get(1);
    }

    public int hashCode() {
        StringBuilder n = n();
        if (s) {
            n.append(this.f6052g);
        }
        return n.toString().hashCode();
    }

    public int i() {
        return this.f6050e;
    }

    public int j() {
        return this.n;
    }

    public int k() {
        return this.f6051f;
    }

    public boolean l() {
        return this.f6046a.size() == 0 && this.f6047b.size() != 0;
    }

    public boolean m() {
        return this.q;
    }

    public final StringBuilder n() {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = this.f6046a.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            f next = it.next();
            if (i2 > 1) {
                sb.append(" ");
            }
            sb.append(DatabaseFieldConfigLoader.FIELD_NAME_ID);
            sb.append(i2);
            sb.append(": ");
            sb.append(next == null ? "null" : next.toString());
            i2++;
        }
        if (this.p != null) {
            sb.append(" type " + this.p);
        }
        return sb;
    }

    public String toString() {
        return n().toString();
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6046a.size());
        Iterator<f> it = this.f6046a.iterator();
        while (it.hasNext()) {
            f next = it.next();
            parcel.writeString(next == null ? null : next.toString());
        }
        parcel.writeDouble(e());
        parcel.writeInt(this.f6050e);
        parcel.writeInt(this.f6051f);
        parcel.writeString(this.f6052g);
        parcel.writeInt(this.k);
        parcel.writeInt(this.n);
        parcel.writeInt(this.f6047b.size());
        for (Long l : this.f6047b) {
            parcel.writeLong(l.longValue());
        }
        parcel.writeInt(this.f6048c.size());
        for (Long l2 : this.f6048c) {
            parcel.writeLong(l2.longValue());
        }
        parcel.writeInt(this.m);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeByte(this.q ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.j);
        parcel.writeInt(this.f6053h);
        parcel.writeInt(this.f6054i);
    }

    public static void a(boolean z) {
        s = z;
    }

    public String b() {
        return this.f6052g;
    }

    public String c() {
        return this.o;
    }

    public List<Long> d() {
        if (this.f6047b.getClass().isInstance(r)) {
            return this.f6047b;
        }
        return Collections.unmodifiableList(this.f6047b);
    }

    public void a(double d2) {
        this.j = Double.valueOf(d2);
        this.f6049d = null;
    }

    public f a(int i2) {
        return this.f6046a.get(i2);
    }

    public void a(List<Long> list) {
        this.f6048c = list;
    }

    public int a() {
        return this.k;
    }

    public static Double a(int i2, double d2) {
        if (o() != null) {
            return Double.valueOf(o().a(i2, d2));
        }
        g.a.a.m.d.b("Beacon", "Distance calculator not set.  Distance will bet set to -1", new Object[0]);
        return Double.valueOf(-1.0d);
    }

    public c() {
        this.f6053h = 0;
        this.f6054i = 0;
        this.j = null;
        this.n = -1;
        this.q = false;
        this.f6046a = new ArrayList(1);
        this.f6047b = new ArrayList(1);
        this.f6048c = new ArrayList(1);
    }
}
