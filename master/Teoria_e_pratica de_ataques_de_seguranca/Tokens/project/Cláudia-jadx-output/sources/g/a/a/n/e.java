package g.a.a.n;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: MonitoringStatus.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f6103d = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f6104e = "e";

    /* renamed from: f  reason: collision with root package name */
    public static final Object f6105f = new Object();

    /* renamed from: a  reason: collision with root package name */
    public Map<g.a.a.j, i> f6106a;

    /* renamed from: b  reason: collision with root package name */
    public Context f6107b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6108c = true;

    public e(Context context) {
        this.f6107b = context;
    }

    public static e a(Context context) {
        e eVar = f6103d;
        if (eVar == null) {
            synchronized (f6105f) {
                eVar = f6103d;
                if (eVar == null) {
                    eVar = new e(context.getApplicationContext());
                    f6103d = eVar;
                }
            }
        }
        return eVar;
    }

    public synchronized void b(g.a.a.j jVar, a aVar) {
        a(jVar, aVar);
        h();
    }

    public synchronized void c(g.a.a.j jVar) {
        b(jVar);
        h();
    }

    public synchronized Set<g.a.a.j> d() {
        return b().keySet();
    }

    public synchronized int e() {
        return d().size();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ca A[Catch: all -> 0x00ef, TryCatch #8 {all -> 0x00ef, blocks: (B:5:0x000f, B:6:0x003e, B:8:0x0044, B:9:0x007b, B:10:0x0083, B:12:0x0089, B:14:0x0095, B:15:0x0099, B:43:0x00c6, B:45:0x00ca, B:46:0x00d4), top: B:69:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d4 A[Catch: all -> 0x00ef, TRY_LEAVE, TryCatch #8 {all -> 0x00ef, blocks: (B:5:0x000f, B:6:0x003e, B:8:0x0044, B:9:0x007b, B:10:0x0083, B:12:0x0089, B:14:0x0095, B:15:0x0099, B:43:0x00c6, B:45:0x00ca, B:46:0x00d4), top: B:69:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ee A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.a.n.e.f():void");
    }

    public final void g() {
        long currentTimeMillis = System.currentTimeMillis() - a();
        this.f6106a = new ConcurrentHashMap();
        if (!this.f6108c) {
            g.a.a.m.d.a(f6104e, "Not restoring monitoring state because persistence is disabled", new Object[0]);
        } else if (currentTimeMillis > 900000) {
            String str = f6104e;
            g.a.a.m.d.a(str, "Not restoring monitoring state because it was recorded too many milliseconds ago: " + currentTimeMillis, new Object[0]);
        } else {
            f();
            g.a.a.m.d.a(f6104e, "Done restoring monitoring status", new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h() {
        /*
            r9 = this;
            boolean r0 = r9.f6108c
            if (r0 != 0) goto L5
            return
        L5:
            java.lang.String r0 = g.a.a.n.e.f6104e
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "saveMonitoringStatusIfOn()"
            g.a.a.m.d.a(r0, r3, r2)
            java.util.Map r0 = r9.b()
            int r0 = r0.size()
            r2 = 50
            java.lang.String r3 = "org.altbeacon.beacon.service.monitoring_status_state"
            if (r0 <= r2) goto L2d
            java.lang.String r0 = g.a.a.n.e.f6104e
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Too many regions being monitored.  Will not persist region state"
            g.a.a.m.d.d(r0, r2, r1)
            android.content.Context r0 = r9.f6107b
            r0.deleteFile(r3)
            goto L98
        L2d:
            r0 = 0
            android.content.Context r2 = r9.f6107b     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L79
            java.io.FileOutputStream r2 = r2.openFileOutput(r3, r1)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L79
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            java.util.Map r0 = r9.b()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            r4.<init>()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            java.util.Set r5 = r0.keySet()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            java.util.Iterator r5 = r5.iterator()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
        L4a:
            boolean r6 = r5.hasNext()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            if (r6 == 0) goto L5e
            java.lang.Object r6 = r5.next()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
            g.a.a.j r6 = (g.a.a.j) r6     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L99
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
            java.lang.String r4 = g.a.a.n.e.f6104e     // Catch: java.lang.Throwable -> L99
            java.lang.String r5 = "Error while saving monitored region states to file "
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L99
            r6[r1] = r0     // Catch: java.lang.Throwable -> L99
            g.a.a.m.d.b(r4, r5, r6)     // Catch: java.lang.Throwable -> L99
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
        throw new UnsupportedOperationException("Method not decompiled: g.a.a.n.e.h():void");
    }

    public synchronized void i() {
        if (!this.f6108c) {
            this.f6108c = true;
            h();
        }
    }

    public synchronized void j() {
        this.f6107b.deleteFile("org.altbeacon.beacon.service.monitoring_status_state");
        this.f6108c = false;
    }

    public synchronized void k() {
        boolean z = false;
        for (g.a.a.j jVar : d()) {
            i d2 = d(jVar);
            if (d2.e()) {
                g.a.a.m.d.a(f6104e, "found a monitor that expired: %s", jVar);
                d2.a().a(this.f6107b, "monitoringData", new d(d2.b(), jVar).c());
                z = true;
            }
        }
        if (z) {
            h();
        } else {
            a(System.currentTimeMillis());
        }
    }

    public synchronized i d(g.a.a.j jVar) {
        return b().get(jVar);
    }

    public synchronized void b(g.a.a.c cVar) {
        boolean z = false;
        for (g.a.a.j jVar : a(cVar)) {
            i iVar = b().get(jVar);
            if (iVar != null && iVar.c()) {
                z = true;
                iVar.a().a(this.f6107b, "monitoringData", new d(iVar.b(), jVar).c());
            }
        }
        if (z) {
            h();
        } else {
            a(System.currentTimeMillis());
        }
    }

    public boolean c() {
        return this.f6108c;
    }

    public final List<g.a.a.j> a(g.a.a.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (g.a.a.j jVar : d()) {
            if (jVar.a(cVar)) {
                arrayList.add(jVar);
            } else {
                g.a.a.m.d.a(f6104e, "This region (%s) does not match beacon: %s", jVar, cVar);
            }
        }
        return arrayList;
    }

    public void a(long j) {
        this.f6107b.getFileStreamPath("org.altbeacon.beacon.service.monitoring_status_state").setLastModified(j);
    }

    public long a() {
        return this.f6107b.getFileStreamPath("org.altbeacon.beacon.service.monitoring_status_state").lastModified();
    }

    public final Map<g.a.a.j, i> b() {
        if (this.f6106a == null) {
            g();
        }
        return this.f6106a;
    }

    public void a(g.a.a.j jVar, Integer num) {
        i iVar = b().get(jVar);
        if (iVar == null) {
            iVar = a(jVar);
        }
        if (num != null) {
            if (num.intValue() == 0) {
                iVar.d();
            }
            if (num.intValue() == 1) {
                iVar.c();
            }
        }
    }

    public void b(g.a.a.j jVar) {
        b().remove(jVar);
    }

    public i a(g.a.a.j jVar) {
        return a(jVar, new a(null));
    }

    public final i a(g.a.a.j jVar, a aVar) {
        if (b().containsKey(jVar)) {
            Iterator<g.a.a.j> it = b().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g.a.a.j next = it.next();
                if (next.equals(jVar)) {
                    if (next.a(jVar)) {
                        return b().get(next);
                    }
                    String str = f6104e;
                    g.a.a.m.d.a(str, "Replacing region with unique identifier " + jVar.a(), new Object[0]);
                    String str2 = f6104e;
                    g.a.a.m.d.a(str2, "Old definition: " + next, new Object[0]);
                    String str3 = f6104e;
                    g.a.a.m.d.a(str3, "New definition: " + jVar, new Object[0]);
                    g.a.a.m.d.a(f6104e, "clearing state", new Object[0]);
                    b().remove(jVar);
                }
            }
        }
        i iVar = new i(aVar);
        b().put(jVar, iVar);
        return iVar;
    }
}
