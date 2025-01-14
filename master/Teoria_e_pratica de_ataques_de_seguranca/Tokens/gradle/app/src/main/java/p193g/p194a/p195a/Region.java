package p193g.p194a.p195a;

import android.os.Parcel;
import android.os.Parcelable;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: g.a.a.j */
/* loaded from: classes.dex */
public class Region implements Parcelable, Serializable {

    /* renamed from: a */
    public final List<Identifier> f8529a;

    /* renamed from: b */
    public final String f8530b;

    /* renamed from: c */
    public final String f8531c;

    /* renamed from: d */
    public static final Pattern f8528d = Pattern.compile("^[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}$");
    public static final Parcelable.Creator<Region> CREATOR = new C1832a();

    /* compiled from: Region.java */
    /* renamed from: g.a.a.j$a */
    /* loaded from: classes.dex */
    public static class C1832a implements Parcelable.Creator<Region> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Region createFromParcel(Parcel parcel) {
            return new Region(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Region[] newArray(int i) {
            return new Region[i];
        }
    }

    public Region(String str, Identifier identifier, Identifier identifier2, Identifier identifier3) {
        this.f8529a = new ArrayList(3);
        this.f8529a.add(identifier);
        this.f8529a.add(identifier2);
        this.f8529a.add(identifier3);
        this.f8531c = str;
        this.f8530b = null;
        if (str == null) {
            throw new NullPointerException("uniqueId may not be null");
        }
    }

    /* renamed from: a */
    public Identifier m2471a(int i) {
        if (this.f8529a.size() > i) {
            return this.f8529a.get(i);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Region) {
            return ((Region) obj).f8531c.equals(this.f8531c);
        }
        return false;
    }

    public int hashCode() {
        return this.f8531c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Identifier> it = this.f8529a.iterator();
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
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8531c);
        parcel.writeString(this.f8530b);
        parcel.writeInt(this.f8529a.size());
        for (Identifier identifier : this.f8529a) {
            if (identifier != null) {
                parcel.writeString(identifier.toString());
            } else {
                parcel.writeString(null);
            }
        }
    }

    /* renamed from: a */
    public String m2472a() {
        return this.f8531c;
    }

    @Deprecated
    /* renamed from: clone */
    public Region m11333clone() {
        return new Region(this.f8531c, this.f8529a, this.f8530b);
    }

    /* renamed from: a */
    public boolean m2470a(Beacon beacon) {
        int size = this.f8529a.size();
        while (true) {
            size--;
            if (size >= 0) {
                Identifier identifier = this.f8529a.get(size);
                Identifier m2511a = size < beacon.f8501a.size() ? beacon.m2511a(size) : null;
                if ((m2511a != null || identifier == null) && (m2511a == null || identifier == null || identifier.equals(m2511a))) {
                }
            } else {
                String str = this.f8530b;
                return str == null || str.equalsIgnoreCase(beacon.f8507g);
            }
        }
        return false;
    }

    public Region(String str, List<Identifier> list, String str2) {
        m2468a(str2);
        this.f8529a = new ArrayList(list);
        this.f8531c = str;
        this.f8530b = str2;
        if (str == null) {
            throw new NullPointerException("uniqueId may not be null");
        }
    }

    /* renamed from: a */
    public boolean m2469a(Region region) {
        if (region.f8529a.size() == this.f8529a.size()) {
            for (int i = 0; i < region.f8529a.size(); i++) {
                if (region.m2471a(i) == null && m2471a(i) != null) {
                    return false;
                }
                if (region.m2471a(i) != null && m2471a(i) == null) {
                    return false;
                }
                if ((region.m2471a(i) != null || m2471a(i) != null) && !region.m2471a(i).equals(m2471a(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Region(Parcel parcel) {
        this.f8531c = parcel.readString();
        this.f8530b = parcel.readString();
        int readInt = parcel.readInt();
        this.f8529a = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            String readString = parcel.readString();
            if (readString == null) {
                this.f8529a.add(null);
            } else {
                this.f8529a.add(Identifier.m2483a(readString));
            }
        }
    }

    /* renamed from: a */
    public final void m2468a(String str) {
        if (str == null || f8528d.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("Invalid mac address: '" + str + "' Must be 6 hex bytes separated by colons.");
    }
}
