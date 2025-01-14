package p193g.p194a.p195a;

import android.os.Parcel;
import android.os.Parcelable;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p193g.p194a.p195a.p196k.NullBeaconDataFactory;
import p193g.p194a.p195a.p197l.DistanceCalculator;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.c */
/* loaded from: classes.dex */
public class Beacon implements Parcelable, Serializable {
    @Deprecated
    public static final Parcelable.Creator<Beacon> CREATOR;

    /* renamed from: r */
    public static final List<Long> f8498r = Collections.unmodifiableList(new ArrayList());

    /* renamed from: s */
    public static boolean f8499s;

    /* renamed from: t */
    public static DistanceCalculator f8500t;

    /* renamed from: a */
    public List<Identifier> f8501a;

    /* renamed from: b */
    public List<Long> f8502b;

    /* renamed from: c */
    public List<Long> f8503c;

    /* renamed from: d */
    public Double f8504d;

    /* renamed from: e */
    public int f8505e;

    /* renamed from: f */
    public int f8506f;

    /* renamed from: g */
    public String f8507g;

    /* renamed from: h */
    public int f8508h;

    /* renamed from: i */
    public int f8509i;

    /* renamed from: j */
    public Double f8510j;

    /* renamed from: k */
    public int f8511k;

    /* renamed from: m */
    public int f8512m;

    /* renamed from: n */
    public int f8513n;

    /* renamed from: o */
    public String f8514o;

    /* renamed from: p */
    public String f8515p;

    /* renamed from: q */
    public boolean f8516q;

    /* compiled from: Beacon.java */
    /* renamed from: g.a.a.c$a */
    /* loaded from: classes.dex */
    public static class C1830a implements Parcelable.Creator<Beacon> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Beacon createFromParcel(Parcel parcel) {
            return new Beacon(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Beacon[] newArray(int i) {
            return new Beacon[i];
        }
    }

    static {
        Collections.unmodifiableList(new ArrayList());
        f8499s = false;
        f8500t = null;
        new NullBeaconDataFactory();
        CREATOR = new C1830a();
    }

    @Deprecated
    public Beacon(Parcel parcel) {
        this.f8508h = 0;
        this.f8509i = 0;
        this.f8510j = null;
        this.f8513n = -1;
        this.f8516q = false;
        int readInt = parcel.readInt();
        this.f8501a = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f8501a.add(Identifier.m2483a(parcel.readString()));
        }
        this.f8504d = Double.valueOf(parcel.readDouble());
        this.f8505e = parcel.readInt();
        this.f8506f = parcel.readInt();
        this.f8507g = parcel.readString();
        this.f8511k = parcel.readInt();
        this.f8513n = parcel.readInt();
        int readInt2 = parcel.readInt();
        this.f8502b = new ArrayList(readInt2);
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.f8502b.add(Long.valueOf(parcel.readLong()));
        }
        int readInt3 = parcel.readInt();
        this.f8503c = new ArrayList(readInt3);
        for (int i3 = 0; i3 < readInt3; i3++) {
            this.f8503c.add(Long.valueOf(parcel.readLong()));
        }
        this.f8512m = parcel.readInt();
        this.f8514o = parcel.readString();
        this.f8515p = parcel.readString();
        this.f8516q = parcel.readByte() != 0;
        this.f8510j = (Double) parcel.readValue(null);
        this.f8508h = parcel.readInt();
        this.f8509i = parcel.readInt();
    }

    /* renamed from: a */
    public static void m2509a(DistanceCalculator distanceCalculator) {
        f8500t = distanceCalculator;
    }

    /* renamed from: o */
    public static DistanceCalculator m2490o() {
        return f8500t;
    }

    /* renamed from: p */
    public static boolean m2489p() {
        return f8499s;
    }

    /* renamed from: b */
    public void m2505b(int i) {
        this.f8509i = i;
    }

    /* renamed from: c */
    public void m2503c(int i) {
        this.f8505e = i;
    }

    /* renamed from: d */
    public void m2501d(int i) {
        this.f8508h = i;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public double m2500e() {
        if (this.f8504d == null) {
            double d = this.f8505e;
            Double d2 = this.f8510j;
            if (d2 != null) {
                d = d2.doubleValue();
            } else {
                LogManager.m2432a("Beacon", "Not using running average RSSI because it is null", new Object[0]);
            }
            this.f8504d = m2510a(this.f8506f, d);
        }
        return this.f8504d.doubleValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Beacon) {
            Beacon beacon = (Beacon) obj;
            if (this.f8501a.equals(beacon.f8501a)) {
                if (f8499s) {
                    return m2506b().equals(beacon.m2506b());
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: f */
    public List<Long> m2499f() {
        if (this.f8503c.getClass().isInstance(f8498r)) {
            return this.f8503c;
        }
        return Collections.unmodifiableList(this.f8503c);
    }

    /* renamed from: g */
    public Identifier m2498g() {
        return this.f8501a.get(0);
    }

    /* renamed from: h */
    public Identifier m2497h() {
        return this.f8501a.get(1);
    }

    public int hashCode() {
        StringBuilder m2491n = m2491n();
        if (f8499s) {
            m2491n.append(this.f8507g);
        }
        return m2491n.toString().hashCode();
    }

    /* renamed from: i */
    public int m2496i() {
        return this.f8505e;
    }

    /* renamed from: j */
    public int m2495j() {
        return this.f8513n;
    }

    /* renamed from: k */
    public int m2494k() {
        return this.f8506f;
    }

    /* renamed from: l */
    public boolean m2493l() {
        return this.f8501a.size() == 0 && this.f8502b.size() != 0;
    }

    /* renamed from: m */
    public boolean m2492m() {
        return this.f8516q;
    }

    /* renamed from: n */
    public final StringBuilder m2491n() {
        StringBuilder sb = new StringBuilder();
        Iterator<Identifier> it = this.f8501a.iterator();
        int i = 1;
        while (it.hasNext()) {
            Identifier next = it.next();
            if (i > 1) {
                sb.append(" ");
            }
            sb.append(DatabaseFieldConfigLoader.FIELD_NAME_ID);
            sb.append(i);
            sb.append(": ");
            sb.append(next == null ? "null" : next.toString());
            i++;
        }
        if (this.f8515p != null) {
            sb.append(" type " + this.f8515p);
        }
        return sb;
    }

    public String toString() {
        return m2491n().toString();
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8501a.size());
        Iterator<Identifier> it = this.f8501a.iterator();
        while (it.hasNext()) {
            Identifier next = it.next();
            parcel.writeString(next == null ? null : next.toString());
        }
        parcel.writeDouble(m2500e());
        parcel.writeInt(this.f8505e);
        parcel.writeInt(this.f8506f);
        parcel.writeString(this.f8507g);
        parcel.writeInt(this.f8511k);
        parcel.writeInt(this.f8513n);
        parcel.writeInt(this.f8502b.size());
        for (Long l : this.f8502b) {
            parcel.writeLong(l.longValue());
        }
        parcel.writeInt(this.f8503c.size());
        for (Long l2 : this.f8503c) {
            parcel.writeLong(l2.longValue());
        }
        parcel.writeInt(this.f8512m);
        parcel.writeString(this.f8514o);
        parcel.writeString(this.f8515p);
        parcel.writeByte(this.f8516q ? (byte) 1 : (byte) 0);
        parcel.writeValue(this.f8510j);
        parcel.writeInt(this.f8508h);
        parcel.writeInt(this.f8509i);
    }

    /* renamed from: a */
    public static void m2507a(boolean z) {
        f8499s = z;
    }

    /* renamed from: b */
    public String m2506b() {
        return this.f8507g;
    }

    /* renamed from: c */
    public String m2504c() {
        return this.f8514o;
    }

    /* renamed from: d */
    public List<Long> m2502d() {
        if (this.f8502b.getClass().isInstance(f8498r)) {
            return this.f8502b;
        }
        return Collections.unmodifiableList(this.f8502b);
    }

    /* renamed from: a */
    public void m2512a(double d) {
        this.f8510j = Double.valueOf(d);
        this.f8504d = null;
    }

    /* renamed from: a */
    public Identifier m2511a(int i) {
        return this.f8501a.get(i);
    }

    /* renamed from: a */
    public void m2508a(List<Long> list) {
        this.f8503c = list;
    }

    /* renamed from: a */
    public int m2513a() {
        return this.f8511k;
    }

    /* renamed from: a */
    public static Double m2510a(int i, double d) {
        if (m2490o() != null) {
            return Double.valueOf(m2490o().mo2456a(i, d));
        }
        LogManager.m2430b("Beacon", "Distance calculator not set.  Distance will bet set to -1", new Object[0]);
        return Double.valueOf(-1.0d);
    }

    public Beacon() {
        this.f8508h = 0;
        this.f8509i = 0;
        this.f8510j = null;
        this.f8513n = -1;
        this.f8516q = false;
        this.f8501a = new ArrayList(1);
        this.f8502b = new ArrayList(1);
        this.f8503c = new ArrayList(1);
    }
}
