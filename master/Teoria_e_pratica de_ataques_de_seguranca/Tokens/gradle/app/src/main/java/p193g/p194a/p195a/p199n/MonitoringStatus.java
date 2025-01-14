package p193g.p194a.p195a.p199n;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p193g.p194a.p195a.Beacon;
import p193g.p194a.p195a.Region;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.n.e */
/* loaded from: classes.dex */
public class MonitoringStatus {

    /* renamed from: d */
    public static volatile MonitoringStatus f8565d = null;

    /* renamed from: e */
    public static final String f8566e = "e";

    /* renamed from: f */
    public static final Object f8567f = new Object();

    /* renamed from: a */
    public Map<Region, RegionMonitoringState> f8568a;

    /* renamed from: b */
    public Context f8569b;

    /* renamed from: c */
    public boolean f8570c = true;

    public MonitoringStatus(Context context) {
        this.f8569b = context;
    }

    /* renamed from: a */
    public static MonitoringStatus m2405a(Context context) {
        MonitoringStatus monitoringStatus = f8565d;
        if (monitoringStatus == null) {
            synchronized (f8567f) {
                monitoringStatus = f8565d;
                if (monitoringStatus == null) {
                    monitoringStatus = new MonitoringStatus(context.getApplicationContext());
                    f8565d = monitoringStatus;
                }
            }
        }
        return monitoringStatus;
    }

    /* renamed from: b */
    public synchronized void m2397b(Region region, C1836a c1836a) {
        m2402a(region, c1836a);
        m2389h();
    }

    /* renamed from: c */
    public synchronized void m2395c(Region region) {
        m2398b(region);
        m2389h();
    }

    /* renamed from: d */
    public synchronized Set<Region> m2394d() {
        return m2400b().keySet();
    }

    /* renamed from: e */
    public synchronized int m2392e() {
        return m2394d().size();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ca A[Catch: all -> 0x00ef, TryCatch #8 {all -> 0x00ef, blocks: (B:5:0x000f, B:6:0x003e, B:8:0x0044, B:9:0x007b, B:10:0x0083, B:12:0x0089, B:14:0x0095, B:15:0x0099, B:43:0x00c6, B:45:0x00ca, B:46:0x00d4), top: B:69:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d4 A[Catch: all -> 0x00ef, TRY_LEAVE, TryCatch #8 {all -> 0x00ef, blocks: (B:5:0x000f, B:6:0x003e, B:8:0x0044, B:9:0x007b, B:10:0x0083, B:12:0x0089, B:14:0x0095, B:15:0x0099, B:43:0x00c6, B:45:0x00ca, B:46:0x00d4), top: B:69:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ee A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2391f() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p193g.p194a.p195a.p199n.MonitoringStatus.m2391f():void");
    }

    /* renamed from: g */
    public final void m2390g() {
        long currentTimeMillis = System.currentTimeMillis() - m2407a();
        this.f8568a = new ConcurrentHashMap();
        if (!this.f8570c) {
            LogManager.m2432a(f8566e, "Not restoring monitoring state because persistence is disabled", new Object[0]);
        } else if (currentTimeMillis > 900000) {
            String str = f8566e;
            LogManager.m2432a(str, "Not restoring monitoring state because it was recorded too many milliseconds ago: " + currentTimeMillis, new Object[0]);
        } else {
            m2391f();
            LogManager.m2432a(f8566e, "Done restoring monitoring status", new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2389h() {
        /*
            r9 = this;
            boolean r0 = r9.f8570c
            if (r0 != 0) goto L5
            return
        L5:
            java.lang.String r0 = p193g.p194a.p195a.p199n.MonitoringStatus.f8566e
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "saveMonitoringStatusIfOn()"
            p193g.p194a.p195a.p198m.LogManager.m2432a(r0, r3, r2)
            java.util.Map r0 = r9.m2400b()
            int r0 = r0.size()
            r2 = 50
            java.lang.String r3 = "org.altbeacon.beacon.service.monitoring_status_state"
            if (r0 <= r2) goto L2d
            java.lang.String r0 = p193g.p194a.p195a.p199n.MonitoringStatus.f8566e
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Too many regions being monitored.  Will not persist region state"
            p193g.p194a.p195a.p198m.LogManager.m2427d(r0, r2, r1)
            android.content.Context r0 = r9.f8569b
            r0.deleteFile(r3)
            goto L98
        L2d:
            r0 = 0
            android.content.Context r2 = r9.f8569b     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L79
            java.io.FileOutputStream r2 = r2.openFileOutput(r3, r1)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L79
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            java.util.Map r0 = r9.m2400b()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            r4.<init>()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            java.util.Set r5 = r0.keySet()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            java.util.Iterator r5 = r5.iterator()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
        L4a:
            boolean r6 = r5.hasNext()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            if (r6 == 0) goto L5e
            java.lang.Object r6 = r5.next()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            g.a.a.j r6 = (p193g.p194a.p195a.Region) r6     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            java.lang.Object r7 = r0.get(r6)     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            r4.put(r6, r7)     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            goto L4a
        L5e:
            r3.writeObject(r4)     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.io.IOException -> L66
        L66:
            r3.close()     // Catch: java.io.IOException -> L98
            goto L98
        L6a:
            r0 = move-exception
            goto L7d
        L6c:
            r1 = move-exception
            r3 = r0
            goto L77
        L6f:
            r3 = move-exception
            r8 = r3
            r3 = r0
            r0 = r8
            goto L7d
        L74:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L77:
            r0 = r1
            goto L9a
        L79:
            r2 = move-exception
            r3 = r0
            r0 = r2
            r2 = r3
        L7d:
            java.lang.String r4 = p193g.p194a.p195a.p199n.MonitoringStatus.f8566e     // Catch: java.lang.Throwable -> L99
            java.lang.String r5 = "Error while saving monitored region states to file "
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L99
            r6[r1] = r0     // Catch: java.lang.Throwable -> L99
            p193g.p194a.p195a.p198m.LogManager.m2430b(r4, r5, r6)     // Catch: java.lang.Throwable -> L99
            java.io.PrintStream r1 = java.lang.System.err     // Catch: java.lang.Throwable -> L99
            r0.printStackTrace(r1)     // Catch: java.lang.Throwable -> L99
            if (r2 == 0) goto L95
            r2.close()     // Catch: java.io.IOException -> L94
            goto L95
        L94:
        L95:
            if (r3 == 0) goto L98
            goto L66
        L98:
            return
        L99:
            r0 = move-exception
        L9a:
            if (r2 == 0) goto La1
            r2.close()     // Catch: java.io.IOException -> La0
            goto La1
        La0:
        La1:
            if (r3 == 0) goto La6
            r3.close()     // Catch: java.io.IOException -> La6
        La6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p193g.p194a.p195a.p199n.MonitoringStatus.m2389h():void");
    }

    /* renamed from: i */
    public synchronized void m2388i() {
        if (!this.f8570c) {
            this.f8570c = true;
            m2389h();
        }
    }

    /* renamed from: j */
    public synchronized void m2387j() {
        this.f8569b.deleteFile("org.altbeacon.beacon.service.monitoring_status_state");
        this.f8570c = false;
    }

    /* renamed from: k */
    public synchronized void m2386k() {
        boolean z = false;
        for (Region region : m2394d()) {
            RegionMonitoringState m2393d = m2393d(region);
            if (m2393d.m2362e()) {
                LogManager.m2432a(f8566e, "found a monitor that expired: %s", region);
                m2393d.m2366a().m2419a(this.f8569b, "monitoringData", new MonitoringData(m2393d.m2365b(), region).m2408c());
                z = true;
            }
        }
        if (z) {
            m2389h();
        } else {
            m2406a(System.currentTimeMillis());
        }
    }

    /* renamed from: d */
    public synchronized RegionMonitoringState m2393d(Region region) {
        return m2400b().get(region);
    }

    /* renamed from: b */
    public synchronized void m2399b(Beacon beacon) {
        boolean z = false;
        for (Region region : m2404a(beacon)) {
            RegionMonitoringState regionMonitoringState = m2400b().get(region);
            if (regionMonitoringState != null && regionMonitoringState.m2364c()) {
                z = true;
                regionMonitoringState.m2366a().m2419a(this.f8569b, "monitoringData", new MonitoringData(regionMonitoringState.m2365b(), region).m2408c());
            }
        }
        if (z) {
            m2389h();
        } else {
            m2406a(System.currentTimeMillis());
        }
    }

    /* renamed from: c */
    public boolean m2396c() {
        return this.f8570c;
    }

    /* renamed from: a */
    public final List<Region> m2404a(Beacon beacon) {
        ArrayList arrayList = new ArrayList();
        for (Region region : m2394d()) {
            if (region.m2470a(beacon)) {
                arrayList.add(region);
            } else {
                LogManager.m2432a(f8566e, "This region (%s) does not match beacon: %s", region, beacon);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m2406a(long j) {
        this.f8569b.getFileStreamPath("org.altbeacon.beacon.service.monitoring_status_state").setLastModified(j);
    }

    /* renamed from: a */
    public long m2407a() {
        return this.f8569b.getFileStreamPath("org.altbeacon.beacon.service.monitoring_status_state").lastModified();
    }

    /* renamed from: b */
    public final Map<Region, RegionMonitoringState> m2400b() {
        if (this.f8568a == null) {
            m2390g();
        }
        return this.f8568a;
    }

    /* renamed from: a */
    public void m2401a(Region region, Integer num) {
        RegionMonitoringState regionMonitoringState = m2400b().get(region);
        if (regionMonitoringState == null) {
            regionMonitoringState = m2403a(region);
        }
        if (num != null) {
            if (num.intValue() == 0) {
                regionMonitoringState.m2363d();
            }
            if (num.intValue() == 1) {
                regionMonitoringState.m2364c();
            }
        }
    }

    /* renamed from: b */
    public void m2398b(Region region) {
        m2400b().remove(region);
    }

    /* renamed from: a */
    public RegionMonitoringState m2403a(Region region) {
        return m2402a(region, new C1836a(null));
    }

    /* renamed from: a */
    public final RegionMonitoringState m2402a(Region region, C1836a c1836a) {
        if (m2400b().containsKey(region)) {
            Iterator<Region> it = m2400b().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Region next = it.next();
                if (next.equals(region)) {
                    if (next.m2469a(region)) {
                        return m2400b().get(next);
                    }
                    String str = f8566e;
                    LogManager.m2432a(str, "Replacing region with unique identifier " + region.m2472a(), new Object[0]);
                    String str2 = f8566e;
                    LogManager.m2432a(str2, "Old definition: " + next, new Object[0]);
                    String str3 = f8566e;
                    LogManager.m2432a(str3, "New definition: " + region, new Object[0]);
                    LogManager.m2432a(f8566e, "clearing state", new Object[0]);
                    m2400b().remove(region);
                }
            }
        }
        RegionMonitoringState regionMonitoringState = new RegionMonitoringState(c1836a);
        m2400b().put(region, regionMonitoringState);
        return regionMonitoringState;
    }
}
