package p070c.p084d.p085a.p086a.p093e;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import p070c.p084d.p085a.p086a.p093e.p096f.C1046b0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1095z;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;

/* renamed from: c.d.a.a.e.a */
/* loaded from: classes.dex */
public final class C0900a extends AbstractC1134a {

    /* renamed from: a */
    public int f5051a;

    /* renamed from: b */
    public final int f5052b;

    /* renamed from: c */
    public final PendingIntent f5053c;

    /* renamed from: d */
    public final String f5054d;

    /* renamed from: e */
    public static final C0900a f5050e = new C0900a(0);
    public static final Parcelable.Creator<C0900a> CREATOR = new C1106j();

    public C0900a(int i) {
        this(i, null, null);
    }

    public C0900a(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f5051a = i;
        this.f5052b = i2;
        this.f5053c = pendingIntent;
        this.f5054d = str;
    }

    public C0900a(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public C0900a(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    /* renamed from: a */
    public static String m5646a(int i) {
        if (i != 99) {
            if (i != 1500) {
                switch (i) {
                    case -1:
                        return "UNKNOWN";
                    case 0:
                        return "SUCCESS";
                    case 1:
                        return "SERVICE_MISSING";
                    case 2:
                        return "SERVICE_VERSION_UPDATE_REQUIRED";
                    case 3:
                        return "SERVICE_DISABLED";
                    case 4:
                        return "SIGN_IN_REQUIRED";
                    case 5:
                        return "INVALID_ACCOUNT";
                    case 6:
                        return "RESOLUTION_REQUIRED";
                    case 7:
                        return "NETWORK_ERROR";
                    case 8:
                        return "INTERNAL_ERROR";
                    case 9:
                        return "SERVICE_INVALID";
                    case 10:
                        return "DEVELOPER_ERROR";
                    case 11:
                        return "LICENSE_CHECK_FAILED";
                    default:
                        switch (i) {
                            case 13:
                                return "CANCELED";
                            case 14:
                                return "TIMEOUT";
                            case 15:
                                return "INTERRUPTED";
                            case 16:
                                return "API_UNAVAILABLE";
                            case 17:
                                return "SIGN_IN_FAILED";
                            case 18:
                                return "SERVICE_UPDATING";
                            case 19:
                                return "SERVICE_MISSING_PERMISSION";
                            case 20:
                                return "RESTRICTED_PROFILE";
                            case 21:
                                return "API_VERSION_UPDATE_REQUIRED";
                            default:
                                StringBuilder sb = new StringBuilder(31);
                                sb.append("UNKNOWN_ERROR_CODE(");
                                sb.append(i);
                                sb.append(")");
                                return sb.toString();
                        }
                }
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    /* renamed from: b */
    public final int m5645b() {
        return this.f5052b;
    }

    /* renamed from: c */
    public final String m5644c() {
        return this.f5054d;
    }

    /* renamed from: d */
    public final PendingIntent m5643d() {
        return this.f5053c;
    }

    /* renamed from: e */
    public final boolean m5642e() {
        return (this.f5052b == 0 || this.f5053c == null) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0900a) {
            C0900a c0900a = (C0900a) obj;
            return this.f5052b == c0900a.f5052b && C1095z.m5149a(this.f5053c, c0900a.f5053c) && C1095z.m5149a(this.f5054d, c0900a.f5054d);
        }
        return false;
    }

    /* renamed from: f */
    public final boolean m5641f() {
        return this.f5052b == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5052b), this.f5053c, this.f5054d});
    }

    public final String toString() {
        C1046b0 m5150a = C1095z.m5150a(this);
        m5150a.m5298a("statusCode", m5646a(this.f5052b));
        m5150a.m5298a("resolution", this.f5053c);
        m5150a.m5298a("message", this.f5054d);
        return m5150a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5051a);
        C1140c.m5066b(parcel, 2, m5645b());
        C1140c.m5073a(parcel, 3, (Parcelable) m5643d(), i, false);
        C1140c.m5072a(parcel, 4, m5644c(), false);
        C1140c.m5065c(parcel, m5080a);
    }
}
