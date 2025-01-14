package p070c.p071a.p072a.p073o;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import p070c.p071a.p072a.Header;
import p070c.p071a.p072a.InterfaceC0779a;
import p070c.p071a.p072a.NetworkResponse;
import p070c.p071a.p072a.VolleyLog;

/* renamed from: c.a.a.o.g */
/* loaded from: classes.dex */
public class HttpHeaderParser {
    /* renamed from: a */
    public static InterfaceC0779a.C0780a m6119a(NetworkResponse networkResponse) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = networkResponse.f4560b;
        String str = map.get("Date");
        long m6118a = str != null ? m6118a(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            j = 0;
            int i2 = 0;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j = 0;
            j2 = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long m6118a2 = str3 != null ? m6118a(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long m6118a3 = str4 != null ? m6118a(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j3 = currentTimeMillis + (j * 1000);
            if (i == 0) {
                Long.signum(j2);
                j4 = (j2 * 1000) + j3;
            }
            j4 = j3;
        } else if (m6118a <= 0 || m6118a2 < m6118a) {
            j3 = 0;
            j4 = j3;
        } else {
            j4 = (m6118a2 - m6118a) + currentTimeMillis;
            j3 = j4;
        }
        InterfaceC0779a.C0780a c0780a = new InterfaceC0779a.C0780a();
        c0780a.f4524a = networkResponse.f4559a;
        c0780a.f4525b = str5;
        c0780a.f4529f = j3;
        c0780a.f4528e = j4;
        c0780a.f4526c = m6118a;
        c0780a.f4527d = m6118a3;
        c0780a.f4530g = map;
        c0780a.f4531h = networkResponse.f4561c;
        return c0780a;
    }

    /* renamed from: a */
    public static long m6118a(String str) {
        try {
            return m6121a().parse(str).getTime();
        } catch (ParseException e) {
            VolleyLog.m6169a(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    /* renamed from: a */
    public static String m6120a(long j) {
        return m6121a().format(new Date(j));
    }

    /* renamed from: a */
    public static SimpleDateFormat m6121a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    /* renamed from: a */
    public static String m6115a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";", 0);
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split(SimpleComparison.EQUAL_TO_OPERATION, 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static Map<String, String> m6117a(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header header : list) {
            treeMap.put(header.m6229a(), header.m6228b());
        }
        return treeMap;
    }

    /* renamed from: a */
    public static List<Header> m6116a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
