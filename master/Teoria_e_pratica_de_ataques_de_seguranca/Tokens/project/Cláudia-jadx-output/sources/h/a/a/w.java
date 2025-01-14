package h.a.a;

import android.os.SystemClock;
import java.util.Calendar;
import java.util.Date;
/* compiled from: SysDateManager.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public static Date f6872a;

    /* renamed from: b  reason: collision with root package name */
    public static long f6873b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile w f6874c;

    public static w d() {
        if (f6874c == null) {
            synchronized (w.class) {
                if (f6874c == null) {
                    f6874c = new w();
                }
            }
        }
        return f6874c;
    }

    public void a(Date date, long j) {
        f6872a = date;
        f6873b = j;
        StringBuilder sb = new StringBuilder();
        sb.append("New date reference set : date=");
        Date date2 = f6872a;
        sb.append(date2 != null ? p.b(date2) : "null");
        sb.append(" elapsedRealtime=");
        sb.append(f6873b);
        c.a("SYS", "SysDateManager", "setDateReference", sb.toString());
    }

    public Date b() {
        return f6872a;
    }

    public long c() {
        return f6873b;
    }

    public Date e() {
        Date f2 = f();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Date date = f6872a;
        return (date == null || elapsedRealtime <= f6873b) ? f2 : new Date(date.getTime() + (elapsedRealtime - f6873b));
    }

    public Date f() {
        return Calendar.getInstance().getTime();
    }

    public long g() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public long h() {
        return p.a(e());
    }

    public void a() {
        f6872a = null;
        f6873b = 0L;
        c.a("SYS", "SysDateManager", "clearDateReference", "Date reference cleared");
    }
}
