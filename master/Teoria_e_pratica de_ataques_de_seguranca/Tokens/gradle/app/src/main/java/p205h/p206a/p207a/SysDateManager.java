package p205h.p206a.p207a;

import android.os.SystemClock;
import java.util.Calendar;
import java.util.Date;

/* renamed from: h.a.a.w */
/* loaded from: classes.dex */
public class SysDateManager {

    /* renamed from: a */
    public static Date f9473a;

    /* renamed from: b */
    public static long f9474b;

    /* renamed from: c */
    public static volatile SysDateManager f9475c;

    /* renamed from: d */
    public static SysDateManager m1497d() {
        if (f9475c == null) {
            synchronized (SysDateManager.class) {
                if (f9475c == null) {
                    f9475c = new SysDateManager();
                }
            }
        }
        return f9475c;
    }

    /* renamed from: a */
    public void m1500a(Date date, long j) {
        f9473a = date;
        f9474b = j;
        StringBuilder sb = new StringBuilder();
        sb.append("New date reference set : date=");
        Date date2 = f9473a;
        sb.append(date2 != null ? GeneralUtils.m1593b(date2) : "null");
        sb.append(" elapsedRealtime=");
        sb.append(f9474b);
        AppLog.m2158a("SYS", "SysDateManager", "setDateReference", sb.toString());
    }

    /* renamed from: b */
    public Date m1499b() {
        return f9473a;
    }

    /* renamed from: c */
    public long m1498c() {
        return f9474b;
    }

    /* renamed from: e */
    public Date m1496e() {
        Date m1495f = m1495f();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Date date = f9473a;
        return (date == null || elapsedRealtime <= f9474b) ? m1495f : new Date(date.getTime() + (elapsedRealtime - f9474b));
    }

    /* renamed from: f */
    public Date m1495f() {
        return Calendar.getInstance().getTime();
    }

    /* renamed from: g */
    public long m1494g() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /* renamed from: h */
    public long m1493h() {
        return GeneralUtils.m1598a(m1496e());
    }

    /* renamed from: a */
    public void m1501a() {
        f9473a = null;
        f9474b = 0L;
        AppLog.m2158a("SYS", "SysDateManager", "clearDateReference", "Date reference cleared");
    }
}
