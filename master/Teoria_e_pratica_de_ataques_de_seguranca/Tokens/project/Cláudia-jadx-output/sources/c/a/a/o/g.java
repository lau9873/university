package c.a.a.o;

import c.a.a.a;
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
/* compiled from: HttpHeaderParser.java */
/* loaded from: classes.dex */
public class g {
    public static a.C0051a a(c.a.a.h hVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = hVar.f2770b;
        String str = map.get("Date");
        long a2 = str != null ? a(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i2 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            j = 0;
            int i3 = 0;
            j2 = 0;
            while (i2 < split.length) {
                String trim = split[i2].trim();
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
                    i3 = 1;
                }
                i2++;
            }
            i2 = i3;
            z = true;
        } else {
            j = 0;
            j2 = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long a3 = str3 != null ? a(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long a4 = str4 != null ? a(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j3 = currentTimeMillis + (j * 1000);
            if (i2 == 0) {
                Long.signum(j2);
                j4 = (j2 * 1000) + j3;
            }
            j4 = j3;
        } else if (a2 <= 0 || a3 < a2) {
            j3 = 0;
            j4 = j3;
        } else {
            j4 = (a3 - a2) + currentTimeMillis;
            j3 = j4;
        }
        a.C0051a c0051a = new a.C0051a();
        c0051a.f2734a = hVar.f2769a;
        c0051a.f2735b = str5;
        c0051a.f2739f = j3;
        c0051a.f2738e = j4;
        c0051a.f2736c = a2;
        c0051a.f2737d = a4;
        c0051a.f2740g = map;
        c0051a.f2741h = hVar.f2771c;
        return c0051a;
    }

    public static long a(String str) {
        try {
            return a().parse(str).getTime();
        } catch (ParseException e2) {
            c.a.a.n.a(e2, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static String a(long j) {
        return a().format(new Date(j));
    }

    public static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";", 0);
            for (int i2 = 1; i2 < split.length; i2++) {
                String[] split2 = split[i2].trim().split(SimpleComparison.EQUAL_TO_OPERATION, 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static Map<String, String> a(List<c.a.a.e> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (c.a.a.e eVar : list) {
            treeMap.put(eVar.a(), eVar.b());
        }
        return treeMap;
    }

    public static List<c.a.a.e> a(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new c.a.a.e(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
