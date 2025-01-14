package p205h.p206a.p207a;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p136d.p153c.p154b0.p156b.AndroidSchedulers;
import p136d.p153c.p179j0.Schedulers;
import p205h.p206a.p207a.Beacons;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.Constants;
import pt.card4b.backendbeacons.DataModels;
import pt.card4b.backendbeacons.MotionTracker;

/* renamed from: h.a.a.j */
/* loaded from: classes.dex */
public class BeaconManager {

    /* renamed from: C */
    public static volatile BeaconManager f8979C = null;

    /* renamed from: D */
    public static boolean f8980D = false;

    /* renamed from: a */
    public BackendListeners.PossibleStopListener f8983a;

    /* renamed from: b */
    public BackendListeners.StageStopListener f8984b;

    /* renamed from: c */
    public Map<String, Map<String, DataModels.C2692b>> f8985c;

    /* renamed from: d */
    public Map<String, DataModels.C2692b> f8986d;

    /* renamed from: e */
    public Map<String, DataModels.StopInfo> f8987e;

    /* renamed from: f */
    public Map<String, DataModels.C2692b> f8988f;

    /* renamed from: g */
    public Map<String, Map<String, DataModels.C2692b>> f8989g;

    /* renamed from: h */
    public Map<String, DataModels.C2692b> f8990h;

    /* renamed from: i */
    public Map<String, DataModels.StopInfo> f8991i;

    /* renamed from: k */
    public MotionTracker f8993k;

    /* renamed from: l */
    public C2004n f8994l;

    /* renamed from: n */
    public DataModels.C2707p f8996n;

    /* renamed from: o */
    public RunnableC2005o f8997o;

    /* renamed from: p */
    public Handler f8998p;

    /* renamed from: q */
    public Beacons f8999q;

    /* renamed from: s */
    public String f9001s;

    /* renamed from: v */
    public DataModels.C2692b f9004v;

    /* renamed from: x */
    public BackendListeners.BeaconObservingListener f9006x;

    /* renamed from: j */
    public boolean f8992j = false;

    /* renamed from: m */
    public boolean f8995m = false;

    /* renamed from: r */
    public boolean f9000r = false;

    /* renamed from: t */
    public int f9002t = 30;

    /* renamed from: u */
    public int f9003u = 90000;

    /* renamed from: w */
    public long f9005w = 0;

    /* renamed from: y */
    public Runnable f9007y = new RunnableC2000k();

    /* renamed from: z */
    public Runnable f9008z = new RunnableC2003m();

    /* renamed from: A */
    public Runnable f8981A = new RunnableC1984b();

    /* renamed from: B */
    public Runnable f8982B = new RunnableC1987c();

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$a */
    /* loaded from: classes.dex */
    public class C1977a implements Beacons.InterfaceC2010d {

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$a$a */
        /* loaded from: classes.dex */
        public class C1978a implements BackendListeners.InterfaceC2686n {

            /* renamed from: a */
            public final /* synthetic */ DataModels.C2692b f9010a;

            /* renamed from: b */
            public final /* synthetic */ DataModels.StopInfo f9011b;

            /* renamed from: c */
            public final /* synthetic */ DataModels.C2693c f9012c;

            /* compiled from: BeaconManager.java */
            /* renamed from: h.a.a.j$a$a$a */
            /* loaded from: classes.dex */
            public class C1979a implements BackendListeners.InterfaceC2681i {

                /* compiled from: BeaconManager.java */
                /* renamed from: h.a.a.j$a$a$a$a */
                /* loaded from: classes.dex */
                public class C1980a implements BackendListeners.InterfaceC2688p {

                    /* compiled from: BeaconManager.java */
                    /* renamed from: h.a.a.j$a$a$a$a$a */
                    /* loaded from: classes.dex */
                    public class C1981a implements BackendListeners.InterfaceC2683k {
                        public C1981a() {
                        }

                        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                        public void onError(DataModels.Error error) {
                            BeaconManager.this.f8984b.onError(error);
                        }

                        @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2683k
                        public void onSuccess() {
                            BeaconManager.this.f8992j = false;
                            BeaconManager.this.f8984b.onRestartStageStops(new ArrayList(Arrays.asList(C1978a.this.f9011b)));
                            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "onReceiveBeacon", "onRestartStageStops: " + C1978a.this.f9011b.toString());
                        }
                    }

                    public C1980a() {
                    }

                    @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2688p
                    /* renamed from: a */
                    public void mo333a(DataModels.NewStageStartInfo newStageStartInfo) {
                        BeaconManager.this.f8996n.m138b(newStageStartInfo.getId());
                        BeaconManager.this.f8996n.m147a().clear();
                        BeaconManager.this.f8996n.m147a().add(C1978a.this.f9010a);
                        BeaconManager.this.f8996n.m144a(C1978a.this.f9010a.m238f());
                        BeaconManager.this.f8996n.m145a(Boolean.valueOf(newStageStartInfo.getStartOffline()));
                        BeaconManager.this.f8996n.m134c(newStageStartInfo.getStartDate());
                        BeaconManager.this.f8996n.m142a(SysDateManager.m1497d().m1499b(), SysDateManager.m1497d().m1498c());
                        BeaconManager.this.f8996n.m128f(newStageStartInfo.getTripCounter());
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                            BeaconManager.this.m1941a(true);
                        } else {
                            BeaconManager.this.m1941a(false);
                        }
                        C1978a.this.f9010a.m245a(true);
                        C1978a c1978a = C1978a.this;
                        c1978a.f9010a.m255a(BeaconManager.this.f8996n.m121l());
                        C1978a c1978a2 = C1978a.this;
                        c1978a2.f9010a.m256a(BeaconManager.this.f8996n.m118o());
                        C1978a.this.f9011b.setOnTrip(true);
                        C1978a.this.f9011b.setStageId(newStageStartInfo.getId());
                        C1978a c1978a3 = C1978a.this;
                        c1978a3.f9011b.setStopOrder(BeaconManager.this.f8996n.m118o());
                        HashMap hashMap = new HashMap();
                        hashMap.put(C1978a.this.f9010a.m238f(), C1978a.this.f9010a);
                        BeaconManager.this.f8985c.put(C1978a.this.f9010a.m230n(), hashMap);
                        BeaconManager.this.f8987e.put(C1978a.this.f9010a.m230n(), C1978a.this.f9011b);
                        BeaconManager.this.f8986d.put(C1978a.this.f9012c.m218f(), C1978a.this.f9010a);
                        Consuela.m1790k().m1818a(BeaconManager.this.f8996n, new C1981a()).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
                    }

                    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                    public void onError(DataModels.Error error) {
                        BeaconManager.this.f8984b.onError(error);
                    }
                }

                public C1979a() {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                    BeaconManager.this.f8984b.onError(error);
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2681i
                public void onSuccess() {
                    String m230n = ((DataModels.C2692b) BeaconManager.this.f8986d.get(BeaconManager.this.f8996n.m133d())).m230n();
                    BeaconManager.this.f8987e.remove(m230n);
                    BeaconManager.this.f8985c.remove(m230n);
                    BeaconManager.this.f8986d.remove(BeaconManager.this.f8996n.m133d());
                    C1978a.this.f9010a.m252a(Consuela.m1790k().m1800f().get("START_STAGE"));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(C1978a.this.f9010a);
                    Consuela.m1790k().m1845a(arrayList, new C1980a());
                }
            }

            public C1978a(DataModels.C2692b c2692b, DataModels.StopInfo stopInfo, DataModels.C2693c c2693c) {
                this.f9010a = c2692b;
                this.f9011b = stopInfo;
                this.f9012c = c2693c;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                BeaconManager.this.f8984b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2686n
            public void onSuccess() {
                Consuela.m1790k().m1822a(new C1979a());
            }
        }

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$a$b */
        /* loaded from: classes.dex */
        public class C1982b implements BackendListeners.InterfaceC2683k {

            /* renamed from: a */
            public final /* synthetic */ DataModels.C2692b f9017a;

            /* renamed from: b */
            public final /* synthetic */ DataModels.StopInfo f9018b;

            /* compiled from: BeaconManager.java */
            /* renamed from: h.a.a.j$a$b$a */
            /* loaded from: classes.dex */
            public class C1983a implements BackendListeners.InterfaceC2686n {
                public C1983a(C1982b c1982b) {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2686n
                public void onSuccess() {
                }
            }

            public C1982b(DataModels.C2692b c2692b, DataModels.StopInfo stopInfo) {
                this.f9017a = c2692b;
                this.f9018b = stopInfo;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                BeaconManager.this.f8984b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2683k
            public void onSuccess() {
                Consuela.m1790k().m1842a(BeaconManager.this.f8996n.m147a(), new C1983a(this));
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "stageRunnable", "NEW BeaconData ON TRIP and NEW StopInfo ON TRIP; stageStopListener.onReceiveStageStop: " + this.f9017a.toString());
                BeaconManager.this.f8984b.onReceiveStageStop(this.f9018b.getCopy());
            }
        }

        public C1977a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0494  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0408  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0438  */
        @Override // p205h.p206a.p207a.Beacons.InterfaceC2010d
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo1872a(pt.card4b.backendbeacons.DataModels.C2693c r17) {
            /*
                Method dump skipped, instructions count: 1333
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p205h.p206a.p207a.BeaconManager.C1977a.mo1872a(pt.card4b.backendbeacons.DataModels$c):void");
        }

        @Override // p205h.p206a.p207a.Beacons.InterfaceC2010d
        public void onError(DataModels.Error error) {
            BeaconManager.this.f8984b.onError(error);
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "stageRunnable", "onError " + error.getType() + "; " + error.getMessage());
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$b */
    /* loaded from: classes.dex */
    public class RunnableC1984b implements Runnable {

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$b$a */
        /* loaded from: classes.dex */
        public class C1985a implements BackendListeners.FinishStageRequestListener {
            public C1985a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                BeaconManager.this.m1928c().postDelayed(BeaconManager.this.f8981A, 10000L);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
            public void onSuccess() {
            }
        }

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$b$b */
        /* loaded from: classes.dex */
        public class C1986b implements BackendListeners.FinishStageRequestListener {
            public C1986b() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                BeaconManager.this.m1928c().postDelayed(BeaconManager.this.f8981A, 10000L);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
            public void onSuccess() {
            }
        }

        public RunnableC1984b() {
        }

        public void finalize() {
            AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "onTripRunnable:finalize", "entered method");
            super.finalize();
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x01d8, code lost:
            if ((r5 - p205h.p206a.p207a.GeneralUtils.m1598a(r19.f9020a.f8996n.m131e())) > ((p205h.p206a.p207a.Consuela.m1790k().m1798g().containsKey("REPEAT_FINISH_STAGE_USER_CONFIRMATION_SECS") ? java.lang.Integer.parseInt(p205h.p206a.p207a.Consuela.m1790k().m1798g().get("REPEAT_FINISH_STAGE_USER_CONFIRMATION_SECS").m187a()) : 60) * 1000)) goto L55;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 1146
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p205h.p206a.p207a.BeaconManager.RunnableC1984b.run():void");
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$c */
    /* loaded from: classes.dex */
    public class RunnableC1987c implements Runnable {
        public RunnableC1987c() {
        }

        public void finalize() {
            AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "scheduleStageStartRunnable:finalize", "entered method");
            super.finalize();
        }

        @Override // java.lang.Runnable
        public void run() {
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "scheduleStageStartRunnable", "entered runnable");
            if (BeaconManager.this.m1917f() != null) {
                BeaconManager beaconManager = BeaconManager.this;
                beaconManager.m1944a(beaconManager.m1917f(), BeaconManager.this.f8984b);
            }
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$d */
    /* loaded from: classes.dex */
    public class C1988d implements BackendListeners.InterfaceC2683k {
        public C1988d(BeaconManager beaconManager) {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "BluetoothStateChanged", "Failed to save ongoing stage");
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2683k
        public void onSuccess() {
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$e */
    /* loaded from: classes.dex */
    public class C1989e implements BackendListeners.HasOngoingStageListener {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.PossibleStopListener f9024a;

        public C1989e(BackendListeners.PossibleStopListener possibleStopListener) {
            this.f9024a = possibleStopListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f9024a.onError(error);
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "ERROR: " + error.getType().toString());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HasOngoingStageListener
        public void onSuccess(boolean z) {
            if (z) {
                this.f9024a.onError(DataModels.Error.stageOngoing());
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "ERROR: " + DataModels.Error.stageOngoing().getType().toString());
                return;
            }
            BeaconManager.this.f8983a = this.f9024a;
            BeaconManager.this.m1903m();
            BeaconManager.this.f8990h.clear();
            BeaconManager.this.f8991i.clear();
            BeaconManager.this.f8989g.clear();
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "will start discovery");
            BeaconManager.this.m1919e();
            BeaconManager.this.m1928c().post(BeaconManager.this.f9008z);
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$f */
    /* loaded from: classes.dex */
    public class C1990f implements BackendListeners.HasOngoingStageListener {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.StageStopListener f9026a;

        /* renamed from: b */
        public final /* synthetic */ DataModels.C2692b f9027b;

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$f$a */
        /* loaded from: classes.dex */
        public class C1991a implements BackendListeners.FinishStageRequestListener {
            public C1991a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                boolean unused = BeaconManager.f8980D = false;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
            public void onSuccess() {
                C1990f c1990f = C1990f.this;
                BeaconManager.this.m1943a(c1990f.f9027b, c1990f.f9026a, true);
            }
        }

        public C1990f(BackendListeners.StageStopListener stageStopListener, DataModels.C2692b c2692b) {
            this.f9026a = stageStopListener;
            this.f9027b = c2692b;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            boolean unused = BeaconManager.f8980D = false;
            this.f9026a.onError(DataModels.Error.internal("Error checking if there's an ongoing stage saved in shared preferences when starting a new stage"));
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HasOngoingStageListener
        public void onSuccess(boolean z) {
            if (BeaconManager.this.m1909j() || !z) {
                BeaconManager.this.m1903m();
                if (!BeaconManager.this.m1909j() || BeaconManager.this.f8984b == null) {
                    BeaconManager.this.m1943a(this.f9027b, this.f9026a, false);
                    return;
                }
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "Finishing previous stage");
                BeaconManager.this.m1939a(true, DataModels.C2706o.f10846o, (BackendListeners.FinishStageRequestListener) new C1991a());
                return;
            }
            this.f9026a.onError(DataModels.Error.stageOngoing());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: " + DataModels.Error.stageOngoing().getType().toString());
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$g */
    /* loaded from: classes.dex */
    public class C1992g implements BackendListeners.InterfaceC2688p {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.StageStopListener f9030a;

        /* renamed from: b */
        public final /* synthetic */ DataModels.C2692b f9031b;

        /* renamed from: c */
        public final /* synthetic */ Map f9032c;

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$g$a */
        /* loaded from: classes.dex */
        public class C1993a implements BackendListeners.InterfaceC2683k {

            /* renamed from: a */
            public final /* synthetic */ DataModels.StopInfo f9034a;

            public C1993a(DataModels.StopInfo stopInfo) {
                this.f9034a = stopInfo;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                boolean unused = BeaconManager.f8980D = false;
                C1992g.this.f9030a.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2683k
            public void onSuccess() {
                BeaconManager.this.f8984b.onSuccess();
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "proceedWithStartStage", "DataManager.saveStageState.onFinished stageStopListener.onSuccess");
                BeaconManager.this.f8984b.onReceiveStageStop(this.f9034a.getCopy());
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "proceedWithStartStage", "onReceiveStageStop: " + this.f9034a.toString());
                BeaconManager.this.f8992j = false;
                BeaconManager.this.f8987e.clear();
                BeaconManager.this.f8986d.clear();
                BeaconManager.this.f8985c.clear();
                BeaconManager.this.f8988f.clear();
                BeaconManager.this.f8987e.put(this.f9034a.getKey(), this.f9034a);
                BeaconManager.this.f8986d.putAll(C1992g.this.f9032c);
                BeaconManager.this.f8985c.put(this.f9034a.getKey(), new HashMap(BeaconManager.this.f8986d));
                BeaconManager.this.f8993k = new MotionTracker(Consuela.m1790k().m1798g().containsKey("MOTION_TIMEOUT") ? Integer.parseInt(Consuela.m1790k().m1798g().get("MOTION_TIMEOUT").m187a()) : BeaconManager.this.f9003u, 75);
                BeaconManager.this.f8993k.m55a(false, BeaconManager.this.m1937b());
                BeaconManager.this.m1907k();
                BeaconManager.this.m1928c().post(BeaconManager.this.f8981A);
                boolean unused = BeaconManager.f8980D = false;
            }
        }

        public C1992g(BackendListeners.StageStopListener stageStopListener, DataModels.C2692b c2692b, Map map) {
            this.f9030a = stageStopListener;
            this.f9031b = c2692b;
            this.f9032c = map;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2688p
        /* renamed from: a */
        public void mo333a(DataModels.NewStageStartInfo newStageStartInfo) {
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "stageStart:onSuccessentered method");
            BeaconManager.this.f8984b = this.f9030a;
            DataModels.StopInfo stopInfo = new DataModels.StopInfo(this.f9031b);
            stopInfo.setOnTrip(true);
            stopInfo.setStopOrder(0);
            stopInfo.setStageId(newStageStartInfo.getId());
            BeaconManager.this.f8996n = new DataModels.C2707p();
            BeaconManager.this.f8996n.m138b(newStageStartInfo.getId());
            BeaconManager.this.f8996n.m145a(Boolean.valueOf(newStageStartInfo.getStartOffline()));
            BeaconManager.this.f8996n.m134c(newStageStartInfo.getStartDate());
            BeaconManager.this.f8996n.m142a(SysDateManager.m1497d().m1499b(), SysDateManager.m1497d().m1498c());
            BeaconManager.this.f8996n.m128f(newStageStartInfo.getTripCounter());
            BeaconManager.this.f8996n.m130e(0);
            for (DataModels.C2692b c2692b : this.f9032c.values()) {
                BeaconManager.this.f8996n.m147a().add(c2692b);
            }
            DataModels.C2692b c2692b2 = BeaconManager.this.f8996n.m147a().get(0);
            BeaconManager.this.f8996n.m132d(c2692b2.m233k().m163b());
            BeaconManager.this.f8996n.m139b(c2692b2.m236h() == null ? 0 : c2692b2.m236h().m170e());
            BeaconManager.this.f8996n.m146a(c2692b2.m235i() == null ? 0 : c2692b2.m235i().m167c());
            if (this.f9032c.size() != 1) {
                BeaconManager.this.f8996n.m126g(-1);
                BeaconManager.this.f8996n.m135c(-1);
                BeaconManager.this.f8996n.m144a((String) null);
                BeaconManager beaconManager = BeaconManager.this;
                beaconManager.f8997o = new RunnableC2005o(stopInfo.getKey(), this.f9032c);
                BeaconManager.this.m1928c().post(BeaconManager.this.f8997o);
            } else {
                c2692b2.m255a(newStageStartInfo.getId());
                BeaconManager.this.f8996n.m126g(c2692b2.m228p());
                BeaconManager.this.f8996n.m135c(c2692b2.m234j() == null ? 0 : c2692b2.m234j().m165b());
                BeaconManager.this.f8996n.m144a(c2692b2.m238f());
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                BeaconManager.this.m1941a(true);
            } else {
                BeaconManager.this.m1941a(false);
            }
            Consuela.m1790k().m1818a(BeaconManager.this.f8996n, new C1993a(stopInfo)).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: stageStart:onError " + error.getType().toString() + ";" + error.getMessage());
            boolean unused = BeaconManager.f8980D = false;
            this.f9030a.onError(error);
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$h */
    /* loaded from: classes.dex */
    public class C1994h implements BackendListeners.HasOngoingStageListener {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.StageStopListener f9036a;

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$h$a */
        /* loaded from: classes.dex */
        public class C1995a implements BackendListeners.InterfaceC2674b {

            /* compiled from: BeaconManager.java */
            /* renamed from: h.a.a.j$h$a$a */
            /* loaded from: classes.dex */
            public class C1996a implements BackendListeners.InterfaceC2686n {
                public C1996a(C1995a c1995a) {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2686n
                public void onSuccess() {
                }
            }

            public C1995a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2674b
            /* renamed from: a */
            public void mo338a(DataModels.C2707p c2707p) {
                Iterator<DataModels.C2692b> it;
                if (BeaconManager.this.f8996n != null && BeaconManager.this.f8996n.m121l().equals(c2707p.m121l())) {
                    C1994h.this.f9036a.onError(DataModels.Error.stageAlreadyStarted());
                    AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + DataModels.Error.stageAlreadyStarted().getType().toString());
                    return;
                }
                BeaconManager.this.f8996n = c2707p;
                if (BeaconManager.this.f8996n != null && BeaconManager.this.f8996n.m147a() != null && BeaconManager.this.f8996n.m147a().size() > 0) {
                    BeaconManager.this.f8996n.m147a().get(BeaconManager.this.f8996n.m147a().size() - 1).m241c(SysDateManager.m1497d().m1496e());
                    BeaconManager.this.f8996n.m147a().get(BeaconManager.this.f8996n.m147a().size() - 1).m243b(null);
                }
                if (SystemClock.elapsedRealtime() < BeaconManager.this.f8996n.m122k()) {
                    AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "Can't use stage date reference, using now device date as reference");
                    BeaconManager.this.f8996n.m142a(SysDateManager.m1497d().m1495f(), SystemClock.elapsedRealtime());
                }
                SysDateManager.m1497d().m1500a(BeaconManager.this.f8996n.m123j(), BeaconManager.this.f8996n.m122k());
                SharedPrefsController.m1540d().m1515m();
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
                    int i = ((BeaconManager.this.f8996n.m140b() != null ? GeneralUtils.m1598a(BeaconManager.this.f8996n.m140b()) : 0L) > 0L ? 1 : ((BeaconManager.this.f8996n.m140b() != null ? GeneralUtils.m1598a(BeaconManager.this.f8996n.m140b()) : 0L) == 0L ? 0 : -1));
                    if (i > 0 && i > 0 && BeaconManager.this.f8996n.m136c() > 0) {
                        BeaconManager.this.f8996n.m141a((short) (BeaconManager.this.f8996n.m136c() - 1));
                    }
                    BeaconManager.this.m1941a(false);
                } else {
                    BeaconManager.this.m1941a(true);
                }
                List<DataModels.C2692b> m147a = BeaconManager.this.f8996n.m147a();
                ArrayList arrayList = new ArrayList();
                String str = "";
                for (DataModels.C2692b c2692b : m147a) {
                    BeaconManager.this.f8986d.put(c2692b.m238f(), c2692b);
                    DataModels.StopInfo stopInfo = new DataModels.StopInfo(c2692b);
                    arrayList.add(stopInfo);
                    str = str + stopInfo.toString() + "; ";
                    BeaconManager.this.f8987e.put(stopInfo.getKey(), stopInfo);
                    if (!BeaconManager.this.f8985c.containsKey(stopInfo.getKey())) {
                        BeaconManager.this.f8985c.put(stopInfo.getKey(), new HashMap());
                    }
                    ((Map) BeaconManager.this.f8985c.get(stopInfo.getKey())).put(c2692b.m238f(), c2692b);
                }
                BeaconManager.this.f8993k = new MotionTracker(Consuela.m1790k().m1798g().containsKey("MOTION_TIMEOUT") ? Integer.parseInt(Consuela.m1790k().m1798g().get("MOTION_TIMEOUT").m187a()) : BeaconManager.this.f9003u, 75);
                if (BeaconManager.this.f8996n.m118o() != 0) {
                    BeaconManager.this.f8995m = true;
                    BeaconManager.this.f8993k.m55a(true, BeaconManager.this.m1937b());
                } else {
                    BeaconManager.this.f8995m = false;
                    BeaconManager.this.f8993k.m55a(false, BeaconManager.this.m1937b());
                }
                String str2 = "getStageState:onSuccess - stageUpdate - stageId = " + BeaconManager.this.f8996n.m121l() + "BeaconDataList: ";
                while (BeaconManager.this.f8996n.m147a().iterator().hasNext()) {
                    str2 = str2 + it.next().toString() + "; ";
                }
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", str2);
                Consuela.m1790k().m1842a(m147a, new C1996a(this));
                BeaconManager.this.m1907k();
                BeaconManager.this.m1928c().post(BeaconManager.this.f8981A);
                C1994h.this.f9036a.onSuccess();
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "stageStopListener.onSuccess");
                C1994h.this.f9036a.onStartStageStops(arrayList);
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "stageStopListener.onStartStageStops: " + str);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1994h.this.f9036a.onError(error);
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + error.getType().toString() + " " + error.getMessage());
            }
        }

        public C1994h(BackendListeners.StageStopListener stageStopListener) {
            this.f9036a = stageStopListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f9036a.onError(error);
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + error.getType().toString());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HasOngoingStageListener
        public void onSuccess(boolean z) {
            if (z) {
                BeaconManager.this.f8986d = new HashMap();
                BeaconManager.this.f8987e = new HashMap();
                BeaconManager.this.f8985c = new HashMap();
                Consuela.m1790k().m1824a(new C1995a());
                return;
            }
            this.f9036a.onError(DataModels.Error.stageRequired());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + DataModels.Error.stageRequired().getType().toString());
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$i */
    /* loaded from: classes.dex */
    public class C1997i implements BackendListeners.InterfaceC2686n {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.FinishStageRequestListener f9039a;

        /* renamed from: b */
        public final /* synthetic */ boolean f9040b;

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$i$a */
        /* loaded from: classes.dex */
        public class C1998a implements BackendListeners.InterfaceC2681i {
            public C1998a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1997i.this.f9039a.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2681i
            public void onSuccess() {
                BeaconManager.this.f8996n = null;
                C1997i.this.f9039a.onSuccess();
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "finishStage", "sending info to UI; newStage = " + C1997i.this.f9040b);
                BeaconManager.this.f8984b.onFinish(C1997i.this.f9040b);
            }
        }

        public C1997i(BackendListeners.FinishStageRequestListener finishStageRequestListener, boolean z) {
            this.f9039a = finishStageRequestListener;
            this.f9040b = z;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f9039a.onError(error);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2686n
        public void onSuccess() {
            Consuela.m1790k().m1822a(new C1998a());
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$j */
    /* loaded from: classes.dex */
    public class C1999j implements BackendListeners.FinishStageRequestListener {
        public C1999j(BeaconManager beaconManager) {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
        public void onSuccess() {
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$k */
    /* loaded from: classes.dex */
    public class RunnableC2000k implements Runnable {

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$k$a */
        /* loaded from: classes.dex */
        public class C2001a implements Beacons.InterfaceC2010d {
            public C2001a() {
            }

            /* JADX WARN: Removed duplicated region for block: B:45:0x01b1  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x021e  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x029f  */
            @Override // p205h.p206a.p207a.Beacons.InterfaceC2010d
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void mo1872a(pt.card4b.backendbeacons.DataModels.C2693c r7) {
                /*
                    Method dump skipped, instructions count: 767
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: p205h.p206a.p207a.BeaconManager.RunnableC2000k.C2001a.mo1872a(pt.card4b.backendbeacons.DataModels$c):void");
            }

            @Override // p205h.p206a.p207a.Beacons.InterfaceC2010d
            public void onError(DataModels.Error error) {
                BeaconManager.this.f9006x.onError(error);
            }
        }

        public RunnableC2000k() {
        }

        public void finalize() {
            AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "observeBeaconsRunnable:finalize", "entered method");
            super.finalize();
        }

        @Override // java.lang.Runnable
        public void run() {
            BeaconManager.this.m1966a().m1885a((Beacons.InterfaceC2010d) new C2001a(), 0, Consuela.m1790k().m1798g().containsKey("BLUETOOTH_SCAN_PERIOD") ? Long.parseLong(Consuela.m1790k().m1798g().get("BLUETOOTH_SCAN_PERIOD").m187a()) : 3L, Consuela.m1790k().m1798g().containsKey("BLUETOOTH_WAIT_PERIOD") ? Long.parseLong(Consuela.m1790k().m1798g().get("BLUETOOTH_WAIT_PERIOD").m187a()) : 0L, Consuela.m1790k().m1798g().containsKey("ACCEPTED_BEACON_INFO") ? Short.parseShort(Consuela.m1790k().m1798g().get("ACCEPTED_BEACON_INFO").m187a()) : (short) 0, false, Consuela.m1790k().m1798g().containsKey("USE_SCAN_FILTERS") && Short.parseShort(Consuela.m1790k().m1798g().get("USE_SCAN_FILTERS").m187a()) > 0);
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$l */
    /* loaded from: classes.dex */
    public class C2002l implements Beacons.InterfaceC2010d {
        public C2002l() {
        }

        @Override // p205h.p206a.p207a.Beacons.InterfaceC2010d
        /* renamed from: a */
        public void mo1872a(DataModels.C2693c c2693c) {
            DataModels.C2692b c2692b = (DataModels.C2692b) BeaconManager.this.f8990h.get(c2693c.m218f());
            ArrayList arrayList = new ArrayList();
            DataModels.StopInfo stopInfo = null;
            if (c2692b != null) {
                c2692b.m253a(c2693c);
            } else if (BeaconManager.this.m1930b(c2693c)) {
                c2692b = BeaconManager.this.m1942a(c2693c);
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "getNearbyStopsRunnable", "got NEW BeaconData");
                BeaconManager.this.f8990h.put(c2692b.m238f(), c2692b);
                if (!BeaconManager.this.f8991i.containsKey(c2692b.m230n())) {
                    AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "getNearbyStopsRunnable", "create and SEND stop to UI");
                    stopInfo = new DataModels.StopInfo(c2692b);
                    BeaconManager.this.f8991i.put(c2692b.m230n(), stopInfo);
                }
                if (!BeaconManager.this.f8989g.containsKey(c2692b.m230n())) {
                    BeaconManager.this.f8989g.put(c2692b.m230n(), new HashMap());
                }
                ((Map) BeaconManager.this.f8989g.get(c2692b.m230n())).put(c2692b.m238f(), c2692b);
            }
            if (c2692b != null && BeaconManager.this.f8990h != null && BeaconManager.this.f8990h.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry entry : BeaconManager.this.f8990h.entrySet()) {
                    if (entry.getKey() != c2692b.m238f()) {
                        boolean z = true;
                        Iterator<String> it = ((DataModels.C2692b) entry.getValue()).m242c().keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (!c2692b.m242c().containsKey(it.next())) {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            arrayList2.add((DataModels.C2692b) entry.getValue());
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        DataModels.C2692b c2692b2 = (DataModels.C2692b) it2.next();
                        if (BeaconManager.this.f8990h.containsKey(c2692b2.m238f())) {
                            BeaconManager.this.f8990h.remove(c2692b2.m238f());
                        }
                        if (BeaconManager.this.f8989g.containsKey(c2692b2.m230n())) {
                            ((Map) BeaconManager.this.f8989g.get(c2692b2.m230n())).remove(c2692b2.m238f());
                        }
                        if (!BeaconManager.this.f8989g.containsKey(c2692b2.m230n())) {
                            BeaconManager.this.f8989g.remove(c2692b2.m230n());
                        }
                        if (BeaconManager.this.f8991i.containsKey(c2692b2.m230n())) {
                            arrayList.add((DataModels.StopInfo) BeaconManager.this.f8991i.remove(c2692b2.m230n()));
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                BeaconManager.this.f8983a.onRemoveStops(arrayList);
            }
            if (stopInfo != null) {
                BeaconManager.this.f8983a.onReceiveStop(stopInfo.getCopy());
            }
        }

        @Override // p205h.p206a.p207a.Beacons.InterfaceC2010d
        public void onError(DataModels.Error error) {
            BeaconManager.this.f8983a.onRemoveStops(new ArrayList(BeaconManager.this.f8991i.values()));
            BeaconManager.this.f8983a.onError(error);
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$m */
    /* loaded from: classes.dex */
    public class RunnableC2003m implements Runnable {
        public RunnableC2003m() {
        }

        public void finalize() {
            AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "checkNearbyStopsRunnable:finalize", "entered method");
            super.finalize();
        }

        @Override // java.lang.Runnable
        public void run() {
            DataModels.StopInfo stopInfo;
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "checkNearbyStopsRunnable", "entered runnable");
            BeaconManager beaconManager = BeaconManager.this;
            List<DataModels.C2692b> m1940a = beaconManager.m1940a(beaconManager.m1909j(), 10000);
            if (m1940a != null && m1940a.size() > 0) {
                ArrayList arrayList = new ArrayList();
                String str = "should REMOVE STOPS: ";
                for (DataModels.C2692b c2692b : m1940a) {
                    BeaconManager.this.f8990h.remove(c2692b.m238f());
                    AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "checkNearbyStopsRunnable", "nearbyBeaconDataMap.remove(" + c2692b.toString() + ")");
                    ((Map) BeaconManager.this.f8989g.get(c2692b.m230n())).remove(c2692b.m238f());
                    if (((Map) BeaconManager.this.f8989g.get(c2692b.m230n())).size() == 0) {
                        BeaconManager.this.f8989g.remove(c2692b.m230n());
                        arrayList.add((DataModels.StopInfo) BeaconManager.this.f8991i.remove(c2692b.m230n()));
                        str = str + stopInfo.getStopName() + "; ";
                    }
                }
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "checkNearbyStopsRunnable", str);
                Iterator it = arrayList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (((DataModels.StopInfo) it.next()) == null) {
                        arrayList.remove(i);
                    }
                    i++;
                }
                if (arrayList.size() > 0) {
                    BeaconManager.this.f8983a.onRemoveStops(arrayList);
                }
            }
            BeaconManager.this.m1928c().postDelayed(this, 10000L);
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$n */
    /* loaded from: classes.dex */
    public class C2004n extends BroadcastReceiver {
        public C2004n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AppLog.m2158a("LOGIC_MOTION", "LOGIC_MOTION", "ActivityDetectionBroadcastReceiver", "RECEIVED BROADCAST");
            if (!intent.hasExtra(Constants.DETECTED_ACTIVITY) || BeaconManager.this.f8996n == null || BeaconManager.this.f9000r) {
                return;
            }
            AppLog.m2158a("LOGIC_MOTION", "BeaconManager", "ActivityDetectionBroadcastReceiver.onReceive", "Motion activity detected. Finish confirmation requested");
            BeaconManager.this.f8984b.onFinishConfirmation(Consuela.m1790k().m1798g().containsKey("FINISH_STAGE_USER_CONFIRMATION_TIMEOUT") ? Integer.parseInt(Consuela.m1790k().m1798g().get("FINISH_STAGE_USER_CONFIRMATION_TIMEOUT").m187a()) : BeaconManager.this.f9002t, false);
            BeaconManager.this.f9000r = true;
            BeaconManager.this.f9001s = DataModels.C2706o.f10845n;
            BeaconManager.this.f8996n.m137b(SysDateManager.m1497d().m1496e());
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$o */
    /* loaded from: classes.dex */
    public class RunnableC2005o implements Runnable {

        /* renamed from: a */
        public Map<String, DataModels.C2692b> f9048a;

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$o$a */
        /* loaded from: classes.dex */
        public class C2006a implements BackendListeners.InterfaceC2683k {
            public C2006a(RunnableC2005o runnableC2005o) {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2683k
            public void onSuccess() {
            }
        }

        public RunnableC2005o(String str, Map<String, DataModels.C2692b> map) {
            this.f9048a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(this.f9048a.values()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DataModels.C2692b c2692b = (DataModels.C2692b) it.next();
                c2692b.m245a(false);
                this.f9048a.remove(c2692b.m238f());
                BeaconManager.this.f8996n.m147a().remove(c2692b);
            }
            if (this.f9048a.size() > 1) {
                int m165b = BeaconManager.this.f8996n.m147a().get(0).m234j().m165b();
                int m228p = BeaconManager.this.f8996n.m147a().get(0).m228p();
                for (DataModels.C2692b c2692b2 : new ArrayList(this.f9048a.values())) {
                    if (m165b != c2692b2.m234j().m165b()) {
                        m165b = -1;
                    }
                    if (m228p != c2692b2.m228p()) {
                        m228p = -1;
                    }
                }
                BeaconManager.this.f8996n.m126g(m228p);
                BeaconManager.this.f8996n.m135c(m165b);
                BeaconManager.this.m1928c().postDelayed(this, 10000L);
            } else {
                DataModels.C2692b c2692b3 = BeaconManager.this.f8996n.m147a().get(0);
                BeaconManager.this.f8996n.m144a(c2692b3.m238f());
                BeaconManager.this.f8996n.m126g(c2692b3.m228p());
                BeaconManager.this.f8996n.m135c(c2692b3.m234j() != null ? c2692b3.m236h().m170e() : 0);
                AppLog.m2158a("LOGIC_STOPS", "BeaconManager", "checkFirstStopRunnable", "first stop DECIDED " + this.f9048a.get(BeaconManager.this.f8996n.m133d()).m231m().m113c());
            }
            Consuela.m1790k().m1818a(BeaconManager.this.f8996n, new C2006a(this)).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
        }
    }

    public BeaconManager() {
        if (f8979C == null) {
            this.f8985c = new HashMap();
            this.f8986d = new HashMap();
            this.f8987e = new HashMap();
            this.f8988f = new HashMap();
            this.f8989g = new HashMap();
            this.f8990h = new HashMap();
            this.f8991i = new HashMap();
            return;
        }
        throw new RuntimeException("BeaconManager: Use getInstance() method to get the single instance of this class.");
    }

    /* renamed from: d */
    public static BeaconManager m1922d() {
        if (f8979C == null) {
            synchronized (BeaconManager.class) {
                if (f8979C == null) {
                    f8979C = new BeaconManager();
                }
            }
        }
        return f8979C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m1919e() {
        m1966a().m1885a((Beacons.InterfaceC2010d) new C2002l(), 1, Consuela.m1790k().m1798g().containsKey("BLUETOOTH_SCAN_PERIOD") ? Long.parseLong(Consuela.m1790k().m1798g().get("BLUETOOTH_SCAN_PERIOD").m187a()) : 3L, Consuela.m1790k().m1798g().containsKey("BLUETOOTH_WAIT_PERIOD") ? Long.parseLong(Consuela.m1790k().m1798g().get("BLUETOOTH_WAIT_PERIOD").m187a()) : 0L, Consuela.m1790k().m1798g().containsKey("ACCEPTED_BEACON_INFO") ? Short.parseShort(Consuela.m1790k().m1798g().get("ACCEPTED_BEACON_INFO").m187a()) : (short) 0, false, Consuela.m1790k().m1798g().containsKey("USE_SCAN_FILTERS") && Short.parseShort(Consuela.m1790k().m1798g().get("USE_SCAN_FILTERS").m187a()) > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public DataModels.C2692b m1917f() {
        return this.f9004v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public boolean m1911i() {
        DataModels.C2707p c2707p = this.f8996n;
        if (c2707p != null) {
            DataModels.C2692b c2692b = c2707p.m133d() != null ? this.f8986d.get(this.f8996n.m133d()) : null;
            if (c2692b != null) {
                boolean z = this.f8996n.m147a().size() > 0 && this.f8996n.m147a().get(0).m244b().size() > 0 && m1946a(this.f8996n.m147a().get(0).m244b().get(0));
                if ((z || this.f8996n.m118o() != 0) && (!z || c2692b.m233k().m160e().m159a() == DataModels.C2705n.f10834c || this.f8996n.m118o() != 0)) {
                    if (!z || c2692b.m233k().m160e().m159a() != DataModels.C2705n.f10834c) {
                        return false;
                    }
                    if (this.f8996n.m118o() != 0 && this.f8996n.m118o() != 1) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public boolean m1909j() {
        return this.f8996n != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m1907k() {
        boolean z = true;
        m1966a().m1885a(new C1977a(), 2, Consuela.m1790k().m1798g().containsKey("BLUETOOTH_SCAN_PERIOD") ? Long.parseLong(Consuela.m1790k().m1798g().get("BLUETOOTH_SCAN_PERIOD").m187a()) : 3L, Consuela.m1790k().m1798g().containsKey("BLUETOOTH_WAIT_PERIOD") ? Long.parseLong(Consuela.m1790k().m1798g().get("BLUETOOTH_WAIT_PERIOD").m187a()) : 0L, Consuela.m1790k().m1798g().containsKey("ACCEPTED_BEACON_INFO") ? Short.parseShort(Consuela.m1790k().m1798g().get("ACCEPTED_BEACON_INFO").m187a()) : (short) 0, Consuela.m1790k().m1798g().containsKey("SEND_STAGE_BEACON_LOCATION") && Short.parseShort(Consuela.m1790k().m1798g().get("SEND_STAGE_BEACON_LOCATION").m187a()) > 0, (!Consuela.m1790k().m1798g().containsKey("USE_SCAN_FILTERS") || Short.parseShort(Consuela.m1790k().m1798g().get("USE_SCAN_FILTERS").m187a()) <= 0) ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m1903m() {
        AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "stopCallbacksAndMotionTracker", "Stopping callbacks and motion tracker");
        Handler m1928c = m1928c();
        m1928c.removeCallbacks(this.f9008z);
        m1928c.removeCallbacks(this.f8981A);
        m1928c.removeCallbacks(this.f8997o);
        m1966a().m1876e();
        if (this.f8995m) {
            this.f8995m = false;
            MotionTracker motionTracker = this.f8993k;
            if (motionTracker != null) {
                motionTracker.m49g();
            }
        }
    }

    /* renamed from: g */
    public DataModels.C2707p m1915g() {
        return this.f8996n;
    }

    /* renamed from: h */
    public BackendListeners.StageStopListener m1913h() {
        return this.f8984b;
    }

    /* renamed from: l */
    public void m1905l() {
        AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "stopBeaconService", "entered method");
        m1903m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public Handler m1928c() {
        if (this.f8998p == null) {
            this.f8998p = new Handler();
        }
        return this.f8998p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public C2004n m1937b() {
        if (this.f8994l == null) {
            this.f8994l = new C2004n();
        }
        return this.f8994l;
    }

    /* renamed from: c */
    private void m1924c(DataModels.C2692b c2692b) {
        this.f9004v = c2692b;
    }

    /* renamed from: c */
    private boolean m1923c(DataModels.C2693c c2693c) {
        if (c2693c != null) {
            return c2693c.m219e();
        }
        return false;
    }

    /* renamed from: d */
    public void m1920d(DataModels.C2693c c2693c) {
        if (c2693c != null && m1930b(c2693c)) {
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStageFromHCE", "starting new stage from HCE. key=" + c2693c.m218f());
            m1944a(m1942a(c2693c), this.f8984b);
            return;
        }
        AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStageFromHCE", "The beacon is not a valid Andante beacon. Key=" + c2693c.m218f());
    }

    /* renamed from: b */
    public void m1932b(BackendListeners.StageStopListener stageStopListener) {
        this.f8984b = stageStopListener;
    }

    /* renamed from: b */
    public boolean m1930b(DataModels.C2693c c2693c) {
        DataModels.C2704m c2704m = Consuela.m1790k().m1776r().get(c2693c.m212l());
        if (c2704m != null) {
            Map<String, DataModels.C2701j> m1782o = Consuela.m1790k().m1782o();
            DataModels.C2701j c2701j = m1782o.get(c2693c.m216h() + "|" + c2704m.m163b());
            DataModels.C2703l c2703l = Consuela.m1790k().m1784n().get(c2693c.m200x());
            Map<String, DataModels.C2702k> m1786m = Consuela.m1790k().m1786m();
            DataModels.C2702k c2702k = m1786m.get(c2693c.m211m() + "|" + c2704m.m163b());
            Map<String, DataModels.C2708q> m1774s = Consuela.m1790k().m1774s();
            DataModels.C2708q c2708q = m1774s.get(c2693c.m207q() + "|" + c2693c.m212l());
            DataModels.C2709r c2709r = Consuela.m1790k().m1772u().get(c2693c.m225A());
            if (c2704m.m160e() != null) {
                return c2704m.m160e().m159a() == DataModels.C2705n.f10834c ? ((!m1923c(c2693c) && c2693c.m199y() == 0) || c2701j == null || c2703l == null || c2702k == null || c2709r == null || c2708q == null) ? false : true : (c2708q == null || c2709r == null) ? false : true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Beacons m1966a() {
        short s = Beacons.f9050f;
        if (Consuela.m1790k().m1798g().containsKey("BEACON_SCAN_API") && Integer.parseInt(Consuela.m1790k().m1798g().get("BEACON_SCAN_API").m187a()) > 0) {
            s = (short) Integer.parseInt(Consuela.m1790k().m1798g().get("BEACON_SCAN_API").m187a());
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("OnePlus") && Consuela.m1790k().m1798g().containsKey("ONEPLUS_BEACON_SCAN_API") && Integer.parseInt(Consuela.m1790k().m1798g().get("ONEPLUS_BEACON_SCAN_API").m187a()) > 0) {
            s = (short) Integer.parseInt(Consuela.m1790k().m1798g().get("ONEPLUS_BEACON_SCAN_API").m187a());
        }
        Beacons beacons = this.f8999q;
        if (beacons == null) {
            this.f8999q = new Beacons(s);
        } else {
            beacons.m1882a(s);
        }
        return this.f8999q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m1931b(DataModels.C2692b c2692b) {
        if (m1909j() && this.f8996n.m124i() == c2692b.m233k().m163b() && c2692b.m233k().m160e() != null) {
            if (c2692b.m233k().m160e().m159a() != DataModels.C2705n.f10834c) {
                return true;
            }
            int m228p = c2692b.m228p();
            int m170e = c2692b.m236h() == null ? 0 : c2692b.m236h().m170e();
            int m165b = c2692b.m234j() == null ? 0 : c2692b.m234j().m165b();
            boolean z = this.f8996n.m127g() == m170e && this.f8996n.m129f() == (c2692b.m235i() == null ? 0 : c2692b.m235i().m167c());
            if (z && this.f8996n.m125h() > 0) {
                z = this.f8996n.m125h() == m165b;
            }
            if (!z || this.f8996n.m116q() <= 0) {
                return z;
            }
            if (this.f8996n.m116q() == m228p) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m1949a(BackendListeners.PossibleStopListener possibleStopListener) {
        AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "entered method");
        if (!Consuela.m1790k().m1804d()) {
            possibleStopListener.onError(DataModels.Error.missingData());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "ERROR: " + DataModels.Error.missingData().getType().toString());
        } else if (Consuela.m1790k().m1802e() == null) {
            possibleStopListener.onError(DataModels.Error.loginRequired());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (m1909j()) {
            possibleStopListener.onError(DataModels.Error.stageOngoing());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "ERROR: " + DataModels.Error.stageOngoing().getType().toString());
        } else {
            Consuela.m1790k().m1829a(new C1989e(possibleStopListener));
        }
    }

    /* renamed from: a */
    public void m1947a(DataModels.StopInfo stopInfo, BackendListeners.StageStopListener stageStopListener) {
        Map<String, DataModels.C2692b> map;
        if (stopInfo != null) {
            r0 = this.f8989g.containsKey(stopInfo.getKey()) ? (DataModels.C2692b) this.f8989g.get(stopInfo.getKey()).values().toArray()[0] : null;
            if (r0 == null && (map = this.f8988f) != null) {
                Iterator<DataModels.C2692b> it = map.values().iterator();
                if (it.hasNext()) {
                    DataModels.C2692b next = it.next();
                    if (stopInfo.getKey().equals(new DataModels.StopInfo(next).getKey())) {
                        r0 = next;
                    }
                }
            }
        }
        m1944a(r0, stageStopListener);
    }

    /* renamed from: a */
    public void m1944a(DataModels.C2692b c2692b, BackendListeners.StageStopListener stageStopListener) {
        AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStage (" + String.format("Current Version is: %s-%s", "1.2.78", "staging") + ")", "entered method");
        if (c2692b == null || TextUtils.isEmpty(c2692b.m238f())) {
            stageStopListener.onError(DataModels.Error.fieldRequired(GeneralUtils.m1603a(C1863a.startinfo)));
        } else if (!Consuela.m1790k().m1804d()) {
            stageStopListener.onError(DataModels.Error.missingData());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: " + DataModels.Error.missingData().getType().toString());
        } else if (Consuela.m1790k().m1802e() == null) {
            stageStopListener.onError(DataModels.Error.loginRequired());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (f8980D) {
            stageStopListener.onError(DataModels.Error.stageAlreadyStarted());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: " + DataModels.Error.stageAlreadyStarted().getType().toString());
        } else {
            if (this.f9000r) {
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "A finish confirmation dialog is in progress, confirmation dismiss requested");
                this.f8984b.onFinishConfirmation(0, true);
                this.f9000r = false;
                this.f9001s = null;
                DataModels.C2707p c2707p = this.f8996n;
                if (c2707p != null) {
                    c2707p.m137b((Date) null);
                }
            }
            f8980D = true;
            Consuela.m1790k().m1829a(new C1990f(stageStopListener, c2692b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1943a(DataModels.C2692b c2692b, BackendListeners.StageStopListener stageStopListener, boolean z) {
        AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "proceedWithStartStage", "entered method");
        if (c2692b == null) {
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "proceedWithStartStage", "Missing start info");
            stageStopListener.onError(DataModels.Error.missingData());
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(c2692b.m238f(), c2692b);
        for (DataModels.C2692b c2692b2 : hashMap.values()) {
            c2692b2.m245a(true);
            c2692b2.m256a(0);
            c2692b2.m252a(Consuela.m1790k().m1800f().get("START_STAGE"));
        }
        Consuela.m1790k().m1845a(hashMap.values(), new C1992g(stageStopListener, c2692b, hashMap));
    }

    /* renamed from: a */
    public void m1948a(BackendListeners.StageStopListener stageStopListener) {
        AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "entered method");
        if (!Consuela.m1790k().m1804d()) {
            stageStopListener.onError(DataModels.Error.missingData());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + DataModels.Error.missingData().getType().toString());
        } else if (Consuela.m1790k().m1802e() == null) {
            stageStopListener.onError(DataModels.Error.loginRequired());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (!Consuela.m1790k().m1771v()) {
            stageStopListener.onError(DataModels.Error.initFailedDataSuspect());
            AppLog.m2158a("LOGIC_BEACONS", "Consuela", "resumeStage", "ERROR: " + DataModels.Error.initFailedDataSuspect().getType().toString());
        } else if (m1909j()) {
            stageStopListener.onError(DataModels.Error.stageOngoing());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + DataModels.Error.stageOngoing().getType().toString());
        } else {
            this.f8984b = stageStopListener;
            Consuela.m1790k().m1829a(new C1994h(stageStopListener));
        }
    }

    /* renamed from: a */
    public void m1939a(boolean z, String str, BackendListeners.FinishStageRequestListener finishStageRequestListener) {
        Iterator<DataModels.C2692b> it;
        AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "finishStage", "entered method");
        if (Consuela.m1790k().m1802e() == null) {
            finishStageRequestListener.onError(DataModels.Error.loginRequired());
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "finishStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
            return;
        }
        DataModels.C2707p c2707p = this.f8996n;
        if (c2707p != null && c2707p.m121l() != null) {
            m1903m();
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "finishStage", "currentBeaconDataKey = " + this.f8996n.m133d());
            StringBuilder sb = new StringBuilder();
            sb.append("beaconData is null ? ");
            sb.append(Boolean.toString(this.f8986d.get(this.f8996n.m133d()) == null));
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "finishStage", sb.toString());
            if (this.f8996n.m133d() != null) {
                this.f8986d.get(this.f8996n.m133d()).m252a(Consuela.m1790k().m1800f().get("END_STAGE"));
            } else {
                for (DataModels.C2692b c2692b : this.f8996n.m147a()) {
                    c2692b.m252a(Consuela.m1790k().m1800f().get("END_STAGE"));
                }
            }
            String str2 = "stageFinish - stageId = " + this.f8996n.m121l() + "BeaconDataList: ";
            while (this.f8996n.m147a().iterator().hasNext()) {
                str2 = str2 + it.next().toString() + "; ";
            }
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "finishStage", str2);
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "finishStage", "Calling Consuela.stageFinish...");
            Consuela.m1790k().m1850a(this.f8996n.m121l(), str, this.f8996n.m147a(), new C1997i(finishStageRequestListener, z));
            return;
        }
        finishStageRequestListener.onError(DataModels.Error.stageRequired());
        AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "finishStage", "ERROR: " + DataModels.Error.stageRequired().getType().toString());
    }

    /* renamed from: a */
    public void m1938a(boolean z, boolean z2, BackendListeners.FinishStageUserConfirmationListener finishStageUserConfirmationListener) {
        String str;
        DataModels.C2707p c2707p;
        if (!z && !z2) {
            AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "confirmStageFinished", "user confirmed that the stage is NOT finished");
            String str2 = this.f9001s;
            if (str2 == DataModels.C2706o.f10844m) {
                DataModels.C2707p c2707p2 = this.f8996n;
                if (c2707p2 != null) {
                    DataModels.C2692b c2692b = c2707p2.m133d() != null ? this.f8986d.get(this.f8996n.m133d()) : null;
                    if (c2692b != null) {
                        c2692b.m241c(SysDateManager.m1497d().m1496e());
                        c2692b.m243b(null);
                    }
                }
            } else if (str2 == DataModels.C2706o.f10845n) {
                this.f8993k.m51e();
            } else if (str2 == DataModels.C2706o.f10848q && (c2707p = this.f8996n) != null) {
                DataModels.C2692b c2692b2 = c2707p.m133d() != null ? this.f8986d.get(this.f8996n.m133d()) : null;
                if (c2692b2 != null) {
                    c2692b2.m254a(c2692b2.m237g());
                }
            }
        } else {
            if (z2) {
                String str3 = this.f9001s;
                str = str3 == DataModels.C2706o.f10844m ? DataModels.C2706o.f10851t : str3 == DataModels.C2706o.f10845n ? DataModels.C2706o.f10853v : str3 == DataModels.C2706o.f10848q ? DataModels.C2706o.f10855x : str3 == DataModels.C2706o.f10849r ? DataModels.C2706o.f10838B : DataModels.C2706o.f10844m;
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "confirmStageFinished", "confirmation request was dismissed by timeout");
            } else {
                String str4 = this.f9001s;
                str = str4 == DataModels.C2706o.f10844m ? DataModels.C2706o.f10850s : str4 == DataModels.C2706o.f10845n ? DataModels.C2706o.f10852u : str4 == DataModels.C2706o.f10848q ? DataModels.C2706o.f10854w : str4 == DataModels.C2706o.f10849r ? DataModels.C2706o.f10837A : DataModels.C2706o.f10844m;
                AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "confirmStageFinished", "user confirmed that the stage IS finished");
            }
            m1939a(false, str, (BackendListeners.FinishStageRequestListener) new C1999j(this));
        }
        finishStageUserConfirmationListener.onSuccess(z || z2);
        this.f9000r = false;
        this.f9001s = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public List<DataModels.C2692b> m1940a(boolean z, int i) {
        Date m1496e = SysDateManager.m1497d().m1496e();
        ArrayList<DataModels.C2692b> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            Map<String, DataModels.C2692b> map = this.f8986d;
            if (map != null) {
                arrayList.addAll(map.values());
            }
        } else {
            Map<String, DataModels.C2692b> map2 = this.f8990h;
            if (map2 != null) {
                arrayList.addAll(map2.values());
            }
        }
        int i2 = i;
        for (DataModels.C2692b c2692b : arrayList) {
            if (z) {
                i2 = c2692b.m226r() ? c2692b.m233k().m161d() * 1000 : i;
            }
            Iterator it = new ArrayList(c2692b.m244b()).iterator();
            while (it.hasNext()) {
                DataModels.C2691a c2691a = (DataModels.C2691a) it.next();
                if (GeneralUtils.m1598a(m1496e) - GeneralUtils.m1598a(c2691a.m265f()) > i) {
                    if (c2691a.m274b() == null) {
                        c2691a.m272b(m1496e);
                    } else if (GeneralUtils.m1598a(m1496e) - GeneralUtils.m1598a(c2691a.m265f()) > i2 && !c2692b.m226r()) {
                        c2692b.m242c().remove(c2691a.m261j());
                        c2692b.m244b().remove(c2691a);
                    }
                }
            }
            if (GeneralUtils.m1598a(m1496e) - GeneralUtils.m1598a(c2692b.m237g()) > i) {
                if (c2692b.m239e() == null) {
                    c2692b.m243b(m1496e);
                } else if (GeneralUtils.m1598a(m1496e) - GeneralUtils.m1598a(c2692b.m237g()) > i2) {
                    AppLog.m2158a("LOGIC_BEACONS", "BeaconManager", "checkOffRange", c2692b.m231m().m113c() + " marked as out of range");
                    arrayList2.add(c2692b);
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public DataModels.C2692b m1942a(DataModels.C2693c c2693c) {
        DataModels.C2704m c2704m = Consuela.m1790k().m1776r().get(c2693c.m212l());
        Map<String, DataModels.C2701j> m1782o = Consuela.m1790k().m1782o();
        Map<String, DataModels.C2702k> m1786m = Consuela.m1790k().m1786m();
        StringBuilder sb = new StringBuilder();
        sb.append(c2693c.m211m());
        sb.append("|");
        sb.append(c2704m.m163b());
        Map<String, DataModels.C2708q> m1774s = Consuela.m1790k().m1774s();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c2693c.m207q());
        sb2.append("|");
        sb2.append(c2693c.m212l());
        DataModels.C2692b c2692b = new DataModels.C2692b(c2693c);
        c2692b.m248a(c2704m);
        c2692b.m251a(m1782o.get(c2693c.m216h() + "|" + c2704m.m163b()));
        c2692b.m249a(Consuela.m1790k().m1784n().get(c2693c.m200x()));
        c2692b.m250a(m1786m.get(sb.toString()));
        c2692b.m247a(m1774s.get(sb2.toString()));
        c2692b.m246a(Consuela.m1790k().m1772u().get(c2693c.m225A()));
        c2692b.m253a(c2693c);
        return c2692b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m1946a(DataModels.C2691a c2691a) {
        if (c2691a != null) {
            return c2691a.m266e().booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m1945a(DataModels.C2692b c2692b) {
        DataModels.C2707p c2707p = this.f8996n;
        if (c2707p != null) {
            boolean z = c2707p.m118o() == 0 || (this.f8996n.m118o() == 1 && this.f8996n.m147a().size() > 1 && this.f8996n.m147a().get(0) != null && this.f8996n.m147a().get(0).m244b().size() == 1 && m1946a(this.f8996n.m147a().get(0).m244b().get(0)));
            DataModels.C2692b c2692b2 = this.f8986d.get(this.f8996n.m133d());
            if (c2692b2 != null && z && c2692b.m228p() == this.f8996n.m116q()) {
                if (!(c2692b.m233k() == null && this.f8996n.m124i() == 0) && (c2692b.m233k() == null || c2692b.m233k().m163b() != this.f8996n.m124i())) {
                    return false;
                }
                if (!(c2692b.m236h() == null && this.f8996n.m127g() == 0) && (c2692b.m236h() == null || c2692b.m236h().m170e() != this.f8996n.m127g())) {
                    return false;
                }
                if (!(c2692b.m227q() == null && c2692b2.m227q() == null) && (c2692b.m227q() == null || c2692b2.m227q() == null || c2692b.m227q().m110b() != c2692b2.m227q().m110b())) {
                    return false;
                }
                if (!(c2692b.m231m() == null && c2692b2.m231m() == null) && (c2692b.m231m() == null || c2692b2.m231m() == null || c2692b.m231m().m112d() != c2692b2.m231m().m112d())) {
                    return false;
                }
                if (!(c2692b.m234j() == null && c2692b2.m234j() == null) && (c2692b.m234j() == null || c2692b2.m234j() == null || c2692b.m234j().m165b() != c2692b2.m234j().m165b())) {
                    return false;
                }
                return (c2692b.m235i() == null && c2692b2.m235i() != null) || (c2692b.m235i() != null && c2692b2.m235i() == null) || !(c2692b.m235i() == null || c2692b2.m235i() == null || c2692b.m235i().m167c() == c2692b2.m235i().m167c());
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public void m1965a(int i, BackendListeners.ScheduleStageStartListener scheduleStageStartListener) {
        if (this.f8984b != null) {
            Map<String, DataModels.C2692b> map = this.f8990h;
            if (map != null && map.size() > 0) {
                m1924c((DataModels.C2692b) this.f8990h.values().toArray()[0]);
                m1928c().postDelayed(this.f8982B, i * 1000);
                scheduleStageStartListener.onSuccess();
                return;
            }
            scheduleStageStartListener.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "no beacons detected", ""));
            return;
        }
        scheduleStageStartListener.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "stageStopListener not set", ""));
    }

    /* renamed from: a */
    public void m1941a(boolean z) {
        DataModels.C2707p c2707p = this.f8996n;
        if (c2707p != null) {
            boolean z2 = true;
            if (z) {
                AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "BluetoothStateChanged", "BT sate changed to ON");
                if (this.f8996n.m140b() != null) {
                    this.f8996n.m143a((Date) null);
                } else {
                    z2 = false;
                }
            } else {
                c2707p.m141a((short) (c2707p.m136c() + 1));
                if (this.f8996n.m140b() == null) {
                    this.f8996n.m143a(SysDateManager.m1497d().m1496e());
                }
                AppLog.m2158a("LOGIC_OTHER", "BeaconManager", "BluetoothStateChanged", "BT sate changed to OFF(" + ((int) this.f8996n.m136c()) + "x)");
            }
            if (z2) {
                Consuela.m1790k().m1818a(this.f8996n, new C1988d(this)).subscribeOn(Schedulers.m3323b()).observeOn(AndroidSchedulers.m3671a()).subscribe();
            }
        }
    }
}
