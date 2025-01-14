package p193g.p194a.p195a.p199n;

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
import p193g.p194a.p195a.Region;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.n.n */
/* loaded from: classes.dex */
public class ScanState implements Serializable {

    /* renamed from: k */
    public static final String f8614k = ScanState.class.getSimpleName();

    /* renamed from: m */
    public static int f8615m = 300000;

    /* renamed from: b */
    public transient MonitoringStatus f8617b;

    /* renamed from: e */
    public long f8620e;

    /* renamed from: f */
    public long f8621f;

    /* renamed from: g */
    public long f8622g;

    /* renamed from: h */
    public long f8623h;

    /* renamed from: i */
    public boolean f8624i;

    /* renamed from: j */
    public transient Context f8625j;

    /* renamed from: a */
    public Map<Region, RangeState> f8616a = new HashMap();

    /* renamed from: c */
    public Set<BeaconParser> f8618c = new HashSet();

    /* renamed from: d */
    public ExtraDataBeaconTracker f8619d = new ExtraDataBeaconTracker();

    public ScanState(Context context) {
        this.f8625j = context;
    }

    /* renamed from: a */
    public Long m2316a() {
        return Long.valueOf(this.f8621f);
    }

    /* renamed from: a */
    public void m2315a(long j) {
    }

    /* renamed from: b */
    public Boolean m2312b() {
        return Boolean.valueOf(this.f8624i);
    }

    /* renamed from: c */
    public Long m2311c() {
        return Long.valueOf(this.f8623h);
    }

    /* renamed from: d */
    public Set<BeaconParser> m2310d() {
        return this.f8618c;
    }

    /* renamed from: e */
    public ExtraDataBeaconTracker m2309e() {
        return this.f8619d;
    }

    /* renamed from: f */
    public Long m2308f() {
        return Long.valueOf(this.f8620e);
    }

    /* renamed from: g */
    public Long m2307g() {
        return Long.valueOf(this.f8622g);
    }

    /* renamed from: h */
    public MonitoringStatus m2306h() {
        return this.f8617b;
    }

    /* renamed from: i */
    public Map<Region, RangeState> m2305i() {
        return this.f8616a;
    }

    /* renamed from: j */
    public int m2304j() {
        long longValue;
        long longValue2;
        if (m2312b().booleanValue()) {
            longValue = m2311c().longValue();
            longValue2 = m2316a().longValue();
        } else {
            longValue = m2307g().longValue();
            longValue2 = m2308f().longValue();
        }
        long j = longValue + longValue2;
        int i = f8615m;
        return j > ((long) i) ? (int) j : i;
    }

    /* renamed from: k */
    public int m2303k() {
        long longValue;
        String str = f8614k;
        LogManager.m2432a(str, "ScanState says background mode for ScanJob is " + m2312b(), new Object[0]);
        if (m2312b().booleanValue()) {
            longValue = m2311c().longValue();
        } else {
            longValue = m2307g().longValue();
        }
        if (!m2312b().booleanValue()) {
            int i = f8615m;
            if (longValue < i) {
                return i;
            }
        }
        return (int) longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b8, code lost:
        if (r4 == null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2302l() {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p193g.p194a.p195a.p199n.ScanState.m2302l():void");
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p193g.p194a.p195a.p199n.ScanState m2314a(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p193g.p194a.p195a.p199n.ScanState.m2314a(android.content.Context):g.a.a.n.n");
    }

    /* renamed from: a */
    public void m2313a(BeaconManager beaconManager) {
        this.f8618c = new HashSet(beaconManager.m451h());
        this.f8622g = beaconManager.m447l();
        this.f8620e = beaconManager.m448k();
        this.f8623h = beaconManager.m452g();
        this.f8621f = beaconManager.m455e();
        this.f8624i = beaconManager.m453f();
        ArrayList arrayList = new ArrayList(this.f8617b.m2394d());
        ArrayList arrayList2 = new ArrayList(this.f8616a.keySet());
        ArrayList arrayList3 = new ArrayList(beaconManager.m444o());
        ArrayList arrayList4 = new ArrayList(beaconManager.m441r());
        String str = f8614k;
        LogManager.m2432a(str, "ranged regions: old=" + arrayList2.size() + " new=" + arrayList4.size(), new Object[0]);
        String str2 = f8614k;
        LogManager.m2432a(str2, "monitored regions: old=" + arrayList.size() + " new=" + arrayList3.size(), new Object[0]);
        Iterator it = arrayList4.iterator();
        while (it.hasNext()) {
            Region region = (Region) it.next();
            if (!arrayList2.contains(region)) {
                String str3 = f8614k;
                LogManager.m2432a(str3, "Starting ranging region: " + region, new Object[0]);
                this.f8616a.put(region, new RangeState(new C1836a(this.f8625j.getPackageName())));
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Region region2 = (Region) it2.next();
            if (!arrayList4.contains(region2)) {
                String str4 = f8614k;
                LogManager.m2432a(str4, "Stopping ranging region: " + region2, new Object[0]);
                this.f8616a.remove(region2);
            }
        }
        String str5 = f8614k;
        LogManager.m2432a(str5, "Updated state with " + arrayList4.size() + " ranging regions and " + arrayList3.size() + " monitoring regions.", new Object[0]);
        m2302l();
    }
}
