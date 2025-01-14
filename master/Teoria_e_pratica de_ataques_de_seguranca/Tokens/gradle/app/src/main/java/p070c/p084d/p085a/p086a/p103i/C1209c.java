package p070c.p084d.p085a.p086a.p103i;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;

/* renamed from: c.d.a.a.i.c */
/* loaded from: classes.dex */
public class C1209c extends AbstractC1134a {
    public static final Parcelable.Creator<C1209c> CREATOR;

    /* renamed from: a */
    public int f5609a;

    /* renamed from: b */
    public int f5610b;

    static {
        new C1225q();
        CREATOR = new C1226r();
    }

    public C1209c(int i, int i2) {
        this.f5609a = i;
        this.f5610b = i2;
    }

    /* renamed from: b */
    public int m4992b() {
        return this.f5610b;
    }

    /* renamed from: c */
    public int m4991c() {
        int i = this.f5609a;
        if (i > 17) {
            return 4;
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1209c.class == obj.getClass()) {
            C1209c c1209c = (C1209c) obj;
            if (this.f5609a == c1209c.f5609a && this.f5610b == c1209c.f5610b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5609a), Integer.valueOf(this.f5610b)});
    }

    public String toString() {
        int m4991c = m4991c();
        String num = m4991c != 0 ? m4991c != 1 ? m4991c != 2 ? m4991c != 3 ? m4991c != 4 ? m4991c != 5 ? m4991c != 7 ? m4991c != 8 ? m4991c != 16 ? m4991c != 17 ? Integer.toString(m4991c) : "IN_RAIL_VEHICLE" : "IN_ROAD_VEHICLE" : "RUNNING" : "WALKING" : "TILTING" : "UNKNOWN" : "STILL" : "ON_FOOT" : "ON_BICYCLE" : "IN_VEHICLE";
        int i = this.f5610b;
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 48);
        sb.append("DetectedActivity [type=");
        sb.append(num);
        sb.append(", confidence=");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5609a);
        C1140c.m5066b(parcel, 2, this.f5610b);
        C1140c.m5065c(parcel, m5080a);
    }
}
