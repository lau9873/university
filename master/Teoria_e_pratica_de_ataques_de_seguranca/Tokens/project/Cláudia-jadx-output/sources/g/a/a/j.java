package g.a.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
/* compiled from: Region.java */
/* loaded from: classes.dex */
public class j implements Parcelable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final List<f> f6067a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6068b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6069c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f6066d = Pattern.compile("^[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}\\:[0-9A-Fa-f]{2}$");
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* compiled from: Region.java */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<j> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public j[] newArray(int i2) {
            return new j[i2];
        }
    }

    public j(String str, f fVar, f fVar2, f fVar3) {
        this.f6067a = new ArrayList(3);
        this.f6067a.add(fVar);
        this.f6067a.add(fVar2);
        this.f6067a.add(fVar3);
        this.f6069c = str;
        this.f6068b = null;
        if (str == null) {
            throw new NullPointerException("uniqueId may not be null");
        }
    }

    public f a(int i2) {
        if (this.f6067a.size() > i2) {
            return this.f6067a.get(i2);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return ((j) obj).f6069c.equals(this.f6069c);
        }
        return false;
    }

    public int hashCode() {
        return this.f6069c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = this.f6067a.iterator();
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
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f6069c);
        parcel.writeString(this.f6068b);
        parcel.writeInt(this.f6067a.size());
        for (f fVar : this.f6067a) {
            if (fVar != null) {
                parcel.writeString(fVar.toString());
            } else {
                parcel.writeString(null);
            }
        }
    }

    public String a() {
        return this.f6069c;
    }

    @Deprecated
    /* renamed from: clone */
    public j m10clone() {
        return new j(this.f6069c, this.f6067a, this.f6068b);
    }

    public boolean a(c cVar) {
        int size = this.f6067a.size();
        while (true) {
            size--;
            if (size >= 0) {
                f fVar = this.f6067a.get(size);
                f a2 = size < cVar.f6046a.size() ? cVar.a(size) : null;
                if ((a2 != null || fVar == null) && (a2 == null || fVar == null || fVar.equals(a2))) {
                }
            } else {
                String str = this.f6068b;
                return str == null || str.equalsIgnoreCase(cVar.f6052g);
            }
        }
        return false;
    }

    public j(String str, List<f> list, String str2) {
        a(str2);
        this.f6067a = new ArrayList(list);
        this.f6069c = str;
        this.f6068b = str2;
        if (str == null) {
            throw new NullPointerException("uniqueId may not be null");
        }
    }

    public boolean a(j jVar) {
        if (jVar.f6067a.size() == this.f6067a.size()) {
            for (int i2 = 0; i2 < jVar.f6067a.size(); i2++) {
                if (jVar.a(i2) == null && a(i2) != null) {
                    return false;
                }
                if (jVar.a(i2) != null && a(i2) == null) {
                    return false;
                }
                if ((jVar.a(i2) != null || a(i2) != null) && !jVar.a(i2).equals(a(i2))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public j(Parcel parcel) {
        this.f6069c = parcel.readString();
        this.f6068b = parcel.readString();
        int readInt = parcel.readInt();
        this.f6067a = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            String readString = parcel.readString();
            if (readString == null) {
                this.f6067a.add(null);
            } else {
                this.f6067a.add(f.a(readString));
            }
        }
    }

    public final void a(String str) {
        if (str == null || f6066d.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("Invalid mac address: '" + str + "' Must be 6 hex bytes separated by colons.");
    }
}
