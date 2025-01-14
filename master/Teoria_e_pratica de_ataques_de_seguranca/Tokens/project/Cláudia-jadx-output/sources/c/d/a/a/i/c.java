package c.d.a.a.i;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public class c extends c.d.a.a.h.a {
    public static final Parcelable.Creator<c> CREATOR;

    /* renamed from: a  reason: collision with root package name */
    public int f3666a;

    /* renamed from: b  reason: collision with root package name */
    public int f3667b;

    static {
        new q();
        CREATOR = new r();
    }

    public c(int i2, int i3) {
        this.f3666a = i2;
        this.f3667b = i3;
    }

    public int b() {
        return this.f3667b;
    }

    public int c() {
        int i2 = this.f3666a;
        if (i2 > 17) {
            return 4;
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f3666a == cVar.f3666a && this.f3667b == cVar.f3667b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3666a), Integer.valueOf(this.f3667b)});
    }

    public String toString() {
        int c2 = c();
        String num = c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? c2 != 4 ? c2 != 5 ? c2 != 7 ? c2 != 8 ? c2 != 16 ? c2 != 17 ? Integer.toString(c2) : "IN_RAIL_VEHICLE" : "IN_ROAD_VEHICLE" : "RUNNING" : "WALKING" : "TILTING" : "UNKNOWN" : "STILL" : "ON_FOOT" : "ON_BICYCLE" : "IN_VEHICLE";
        int i2 = this.f3667b;
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 48);
        sb.append("DetectedActivity [type=");
        sb.append(num);
        sb.append(", confidence=");
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.d.a.a.h.c.a(parcel);
        c.d.a.a.h.c.b(parcel, 1, this.f3666a);
        c.d.a.a.h.c.b(parcel, 2, this.f3667b);
        c.d.a.a.h.c.c(parcel, a2);
    }
}
