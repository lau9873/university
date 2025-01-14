package c.d.a.a.e;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import c.d.a.a.e.f.b0;
import c.d.a.a.e.f.z;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a extends c.d.a.a.h.a {

    /* renamed from: a  reason: collision with root package name */
    public int f3213a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3214b;

    /* renamed from: c  reason: collision with root package name */
    public final PendingIntent f3215c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3216d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f3212e = new a(0);
    public static final Parcelable.Creator<a> CREATOR = new j();

    public a(int i2) {
        this(i2, null, null);
    }

    public a(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.f3213a = i2;
        this.f3214b = i3;
        this.f3215c = pendingIntent;
        this.f3216d = str;
    }

    public a(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, null);
    }

    public a(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }

    public static String a(int i2) {
        if (i2 != 99) {
            if (i2 != 1500) {
                switch (i2) {
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
                        switch (i2) {
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
                                sb.append(i2);
                                sb.append(")");
                                return sb.toString();
                        }
                }
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    public final int b() {
        return this.f3214b;
    }

    public final String c() {
        return this.f3216d;
    }

    public final PendingIntent d() {
        return this.f3215c;
    }

    public final boolean e() {
        return (this.f3214b == 0 || this.f3215c == null) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f3214b == aVar.f3214b && z.a(this.f3215c, aVar.f3215c) && z.a(this.f3216d, aVar.f3216d);
        }
        return false;
    }

    public final boolean f() {
        return this.f3214b == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3214b), this.f3215c, this.f3216d});
    }

    public final String toString() {
        b0 a2 = z.a(this);
        a2.a("statusCode", a(this.f3214b));
        a2.a("resolution", this.f3215c);
        a2.a("message", this.f3216d);
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.d.a.a.h.c.a(parcel);
        c.d.a.a.h.c.b(parcel, 1, this.f3213a);
        c.d.a.a.h.c.b(parcel, 2, b());
        c.d.a.a.h.c.a(parcel, 3, (Parcelable) d(), i2, false);
        c.d.a.a.h.c.a(parcel, 4, c(), false);
        c.d.a.a.h.c.c(parcel, a2);
    }
}
