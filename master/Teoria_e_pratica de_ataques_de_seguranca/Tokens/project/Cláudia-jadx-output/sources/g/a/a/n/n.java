package g.a.a.n;

import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
/* compiled from: ScanState.java */
/* loaded from: classes.dex */
public class n implements Serializable {
    public static final String k = n.class.getSimpleName();
    public static int m = 300000;

    /* renamed from: b  reason: collision with root package name */
    public transient e f6151b;

    /* renamed from: e  reason: collision with root package name */
    public long f6154e;

    /* renamed from: f  reason: collision with root package name */
    public long f6155f;

    /* renamed from: g  reason: collision with root package name */
    public long f6156g;

    /* renamed from: h  reason: collision with root package name */
    public long f6157h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6158i;
    public transient Context j;

    /* renamed from: a  reason: collision with root package name */
    public Map<g.a.a.j, f> f6150a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Set<BeaconParser> f6152c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    public c f6153d = new c();

    public n(Context context) {
        this.j = context;
    }

    public Long a() {
        return Long.valueOf(this.f6155f);
    }

    public void a(long j) {
    }

    public Boolean b() {
        return Boolean.valueOf(this.f6158i);
    }

    public Long c() {
        return Long.valueOf(this.f6157h);
    }

    public Set<BeaconParser> d() {
        return this.f6152c;
    }

    public c e() {
        return this.f6153d;
    }

    public Long f() {
        return Long.valueOf(this.f6154e);
    }

    public Long g() {
        return Long.valueOf(this.f6156g);
    }

    public e h() {
        return this.f6151b;
    }

    public Map<g.a.a.j, f> i() {
        return this.f6150a;
    }

    public int j() {
        long longValue;
        long longValue2;
        if (b().booleanValue()) {
            longValue = c().longValue();
            longValue2 = a().longValue();
        } else {
            longValue = g().longValue();
            longValue2 = f().longValue();
        }
        long j = longValue + longValue2;
        int i2 = m;
        return j > ((long) i2) ? (int) j : i2;
    }

    public int k() {
        long longValue;
        String str = k;
        g.a.a.m.d.a(str, "ScanState says background mode for ScanJob is " + b(), new Object[0]);
        if (b().booleanValue()) {
            longValue = c().longValue();
        } else {
            longValue = g().longValue();
        }
        if (!b().booleanValue()) {
            int i2 = m;
            if (longValue < i2) {
                return i2;
            }
        }
        return (int) longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b8, code lost:
        if (r4 == null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l() {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.a.n.n.l():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x007f, code lost:
        if (r4 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0094, code lost:
        if (r4 == null) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x005e A[Catch: all -> 0x00e9, TryCatch #4 {all -> 0x00e9, blocks: (B:48:0x005a, B:50:0x005e, B:51:0x0068, B:59:0x0084), top: B:93:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0068 A[Catch: all -> 0x00e9, TRY_LEAVE, TryCatch #4 {all -> 0x00e9, blocks: (B:48:0x005a, B:50:0x005e, B:51:0x0068, B:59:0x0084), top: B:93:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static g.a.a.n.n a(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.a.n.n.a(android.content.Context):g.a.a.n.n");
    }

    public void a(BeaconManager beaconManager) {
        this.f6152c = new HashSet(beaconManager.h());
        this.f6156g = beaconManager.l();
        this.f6154e = beaconManager.k();
        this.f6157h = beaconManager.g();
        this.f6155f = beaconManager.e();
        this.f6158i = beaconManager.f();
        ArrayList arrayList = new ArrayList(this.f6151b.d());
        ArrayList arrayList2 = new ArrayList(this.f6150a.keySet());
        ArrayList arrayList3 = new ArrayList(beaconManager.o());
        ArrayList arrayList4 = new ArrayList(beaconManager.r());
        String str = k;
        g.a.a.m.d.a(str, "ranged regions: old=" + arrayList2.size() + " new=" + arrayList4.size(), new Object[0]);
        String str2 = k;
        g.a.a.m.d.a(str2, "monitored regions: old=" + arrayList.size() + " new=" + arrayList3.size(), new Object[0]);
        Iterator it = arrayList4.iterator();
        while (it.hasNext()) {
            g.a.a.j jVar = (g.a.a.j) it.next();
            if (!arrayList2.contains(jVar)) {
                String str3 = k;
                g.a.a.m.d.a(str3, "Starting ranging region: " + jVar, new Object[0]);
                this.f6150a.put(jVar, new f(new a(this.j.getPackageName())));
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            g.a.a.j jVar2 = (g.a.a.j) it2.next();
            if (!arrayList4.contains(jVar2)) {
                String str4 = k;
                g.a.a.m.d.a(str4, "Stopping ranging region: " + jVar2, new Object[0]);
                this.f6150a.remove(jVar2);
            }
        }
        String str5 = k;
        g.a.a.m.d.a(str5, "Updated state with " + arrayList4.size() + " ranging regions and " + arrayList3.size() + " monitoring regions.", new Object[0]);
        l();
    }
}
