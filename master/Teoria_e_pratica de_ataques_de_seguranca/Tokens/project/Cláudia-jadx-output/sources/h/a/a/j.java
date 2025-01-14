package h.a.a;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import h.a.a.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.Constants;
import pt.card4b.backendbeacons.DataModels;
import pt.card4b.backendbeacons.MotionTracker;
/* compiled from: BeaconManager.java */
/* loaded from: classes.dex */
public class j {
    public static volatile j C = null;
    public static boolean D = false;

    /* renamed from: a  reason: collision with root package name */
    public BackendListeners.PossibleStopListener f6472a;

    /* renamed from: b  reason: collision with root package name */
    public BackendListeners.StageStopListener f6473b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Map<String, DataModels.b>> f6474c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, DataModels.b> f6475d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, DataModels.StopInfo> f6476e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, DataModels.b> f6477f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Map<String, DataModels.b>> f6478g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, DataModels.b> f6479h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, DataModels.StopInfo> f6480i;
    public MotionTracker k;
    public n l;
    public DataModels.p n;
    public o o;
    public Handler p;
    public h.a.a.k q;
    public String s;
    public DataModels.b v;
    public BackendListeners.BeaconObservingListener x;
    public boolean j = false;
    public boolean m = false;
    public boolean r = false;
    public int t = 30;
    public int u = 90000;
    public long w = 0;
    public Runnable y = new k();
    public Runnable z = new m();
    public Runnable A = new b();
    public Runnable B = new c();

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class a implements k.d {

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0132a implements BackendListeners.n {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DataModels.b f6482a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DataModels.StopInfo f6483b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ DataModels.c f6484c;

            /* compiled from: BeaconManager.java */
            /* renamed from: h.a.a.j$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0133a implements BackendListeners.i {

                /* compiled from: BeaconManager.java */
                /* renamed from: h.a.a.j$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class C0134a implements BackendListeners.p {

                    /* compiled from: BeaconManager.java */
                    /* renamed from: h.a.a.j$a$a$a$a$a  reason: collision with other inner class name */
                    /* loaded from: classes.dex */
                    public class C0135a implements BackendListeners.k {
                        public C0135a() {
                        }

                        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                        public void onError(DataModels.Error error) {
                            j.this.f6473b.onError(error);
                        }

                        @Override // pt.card4b.backendbeacons.BackendListeners.k
                        public void onSuccess() {
                            j.this.j = false;
                            j.this.f6473b.onRestartStageStops(new ArrayList(Arrays.asList(C0132a.this.f6483b)));
                            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "onReceiveBeacon", "onRestartStageStops: " + C0132a.this.f6483b.toString());
                        }
                    }

                    public C0134a() {
                    }

                    @Override // pt.card4b.backendbeacons.BackendListeners.p
                    public void a(DataModels.NewStageStartInfo newStageStartInfo) {
                        j.this.n.b(newStageStartInfo.getId());
                        j.this.n.a().clear();
                        j.this.n.a().add(C0132a.this.f6482a);
                        j.this.n.a(C0132a.this.f6482a.f());
                        j.this.n.a(Boolean.valueOf(newStageStartInfo.getStartOffline()));
                        j.this.n.c(newStageStartInfo.getStartDate());
                        j.this.n.a(w.d().b(), w.d().c());
                        j.this.n.f(newStageStartInfo.getTripCounter());
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                            j.this.a(true);
                        } else {
                            j.this.a(false);
                        }
                        C0132a.this.f6482a.a(true);
                        C0132a c0132a = C0132a.this;
                        c0132a.f6482a.a(j.this.n.l());
                        C0132a c0132a2 = C0132a.this;
                        c0132a2.f6482a.a(j.this.n.o());
                        C0132a.this.f6483b.setOnTrip(true);
                        C0132a.this.f6483b.setStageId(newStageStartInfo.getId());
                        C0132a c0132a3 = C0132a.this;
                        c0132a3.f6483b.setStopOrder(j.this.n.o());
                        HashMap hashMap = new HashMap();
                        hashMap.put(C0132a.this.f6482a.f(), C0132a.this.f6482a);
                        j.this.f6474c.put(C0132a.this.f6482a.n(), hashMap);
                        j.this.f6476e.put(C0132a.this.f6482a.n(), C0132a.this.f6483b);
                        j.this.f6475d.put(C0132a.this.f6484c.f(), C0132a.this.f6482a);
                        h.a.a.l.k().a(j.this.n, new C0135a()).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
                    }

                    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                    public void onError(DataModels.Error error) {
                        j.this.f6473b.onError(error);
                    }
                }

                public C0133a() {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                    j.this.f6473b.onError(error);
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.i
                public void onSuccess() {
                    String n = ((DataModels.b) j.this.f6475d.get(j.this.n.d())).n();
                    j.this.f6476e.remove(n);
                    j.this.f6474c.remove(n);
                    j.this.f6475d.remove(j.this.n.d());
                    C0132a.this.f6482a.a(h.a.a.l.k().f().get("START_STAGE"));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(C0132a.this.f6482a);
                    h.a.a.l.k().a(arrayList, new C0134a());
                }
            }

            public C0132a(DataModels.b bVar, DataModels.StopInfo stopInfo, DataModels.c cVar) {
                this.f6482a = bVar;
                this.f6483b = stopInfo;
                this.f6484c = cVar;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                j.this.f6473b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.n
            public void onSuccess() {
                h.a.a.l.k().a(new C0133a());
            }
        }

        /* compiled from: BeaconManager.java */
        /* loaded from: classes.dex */
        public class b implements BackendListeners.k {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DataModels.b f6489a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DataModels.StopInfo f6490b;

            /* compiled from: BeaconManager.java */
            /* renamed from: h.a.a.j$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0136a implements BackendListeners.n {
                public C0136a(b bVar) {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.n
                public void onSuccess() {
                }
            }

            public b(DataModels.b bVar, DataModels.StopInfo stopInfo) {
                this.f6489a = bVar;
                this.f6490b = stopInfo;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                j.this.f6473b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.k
            public void onSuccess() {
                h.a.a.l.k().a(j.this.n.a(), new C0136a(this));
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "stageRunnable", "NEW BeaconData ON TRIP and NEW StopInfo ON TRIP; stageStopListener.onReceiveStageStop: " + this.f6489a.toString());
                j.this.f6473b.onReceiveStageStop(this.f6490b.getCopy());
            }
        }

        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0494  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0408  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0438  */
        @Override // h.a.a.k.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(pt.card4b.backendbeacons.DataModels.c r17) {
            /*
                Method dump skipped, instructions count: 1333
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: h.a.a.j.a.a(pt.card4b.backendbeacons.DataModels$c):void");
        }

        @Override // h.a.a.k.d
        public void onError(DataModels.Error error) {
            j.this.f6473b.onError(error);
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "stageRunnable", "onError " + error.getType() + "; " + error.getMessage());
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* compiled from: BeaconManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.FinishStageRequestListener {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                j.this.c().postDelayed(j.this.A, 10000L);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
            public void onSuccess() {
            }
        }

        /* compiled from: BeaconManager.java */
        /* renamed from: h.a.a.j$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0137b implements BackendListeners.FinishStageRequestListener {
            public C0137b() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                j.this.c().postDelayed(j.this.A, 10000L);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
            public void onSuccess() {
            }
        }

        public b() {
        }

        public void finalize() {
            h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "onTripRunnable:finalize", "entered method");
            super.finalize();
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x01d8, code lost:
            if ((r5 - h.a.a.p.a(r19.f6492a.n.e())) > ((h.a.a.l.k().g().containsKey("REPEAT_FINISH_STAGE_USER_CONFIRMATION_SECS") ? java.lang.Integer.parseInt(h.a.a.l.k().g().get("REPEAT_FINISH_STAGE_USER_CONFIRMATION_SECS").a()) : 60) * 1000)) goto L55;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 1146
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: h.a.a.j.b.run():void");
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        public void finalize() {
            h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "scheduleStageStartRunnable:finalize", "entered method");
            super.finalize();
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "scheduleStageStartRunnable", "entered runnable");
            if (j.this.f() != null) {
                j jVar = j.this;
                jVar.a(jVar.f(), j.this.f6473b);
            }
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class d implements BackendListeners.k {
        public d(j jVar) {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "BluetoothStateChanged", "Failed to save ongoing stage");
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.k
        public void onSuccess() {
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class e implements BackendListeners.HasOngoingStageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.PossibleStopListener f6496a;

        public e(BackendListeners.PossibleStopListener possibleStopListener) {
            this.f6496a = possibleStopListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f6496a.onError(error);
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "ERROR: " + error.getType().toString());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HasOngoingStageListener
        public void onSuccess(boolean z) {
            if (z) {
                this.f6496a.onError(DataModels.Error.stageOngoing());
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "ERROR: " + DataModels.Error.stageOngoing().getType().toString());
                return;
            }
            j.this.f6472a = this.f6496a;
            j.this.m();
            j.this.f6479h.clear();
            j.this.f6480i.clear();
            j.this.f6478g.clear();
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "will start discovery");
            j.this.e();
            j.this.c().post(j.this.z);
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class f implements BackendListeners.HasOngoingStageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.StageStopListener f6498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DataModels.b f6499b;

        /* compiled from: BeaconManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.FinishStageRequestListener {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                boolean unused = j.D = false;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
            public void onSuccess() {
                f fVar = f.this;
                j.this.a(fVar.f6499b, fVar.f6498a, true);
            }
        }

        public f(BackendListeners.StageStopListener stageStopListener, DataModels.b bVar) {
            this.f6498a = stageStopListener;
            this.f6499b = bVar;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            boolean unused = j.D = false;
            this.f6498a.onError(DataModels.Error.internal("Error checking if there's an ongoing stage saved in shared preferences when starting a new stage"));
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HasOngoingStageListener
        public void onSuccess(boolean z) {
            if (j.this.j() || !z) {
                j.this.m();
                if (!j.this.j() || j.this.f6473b == null) {
                    j.this.a(this.f6499b, this.f6498a, false);
                    return;
                }
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "Finishing previous stage");
                j.this.a(true, DataModels.o.o, (BackendListeners.FinishStageRequestListener) new a());
                return;
            }
            this.f6498a.onError(DataModels.Error.stageOngoing());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: " + DataModels.Error.stageOngoing().getType().toString());
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class g implements BackendListeners.p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.StageStopListener f6502a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DataModels.b f6503b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f6504c;

        /* compiled from: BeaconManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.k {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DataModels.StopInfo f6506a;

            public a(DataModels.StopInfo stopInfo) {
                this.f6506a = stopInfo;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                boolean unused = j.D = false;
                g.this.f6502a.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.k
            public void onSuccess() {
                j.this.f6473b.onSuccess();
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "proceedWithStartStage", "DataManager.saveStageState.onFinished stageStopListener.onSuccess");
                j.this.f6473b.onReceiveStageStop(this.f6506a.getCopy());
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "proceedWithStartStage", "onReceiveStageStop: " + this.f6506a.toString());
                j.this.j = false;
                j.this.f6476e.clear();
                j.this.f6475d.clear();
                j.this.f6474c.clear();
                j.this.f6477f.clear();
                j.this.f6476e.put(this.f6506a.getKey(), this.f6506a);
                j.this.f6475d.putAll(g.this.f6504c);
                j.this.f6474c.put(this.f6506a.getKey(), new HashMap(j.this.f6475d));
                j.this.k = new MotionTracker(h.a.a.l.k().g().containsKey("MOTION_TIMEOUT") ? Integer.parseInt(h.a.a.l.k().g().get("MOTION_TIMEOUT").a()) : j.this.u, 75);
                j.this.k.a(false, j.this.b());
                j.this.k();
                j.this.c().post(j.this.A);
                boolean unused = j.D = false;
            }
        }

        public g(BackendListeners.StageStopListener stageStopListener, DataModels.b bVar, Map map) {
            this.f6502a = stageStopListener;
            this.f6503b = bVar;
            this.f6504c = map;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.p
        public void a(DataModels.NewStageStartInfo newStageStartInfo) {
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "stageStart:onSuccessentered method");
            j.this.f6473b = this.f6502a;
            DataModels.StopInfo stopInfo = new DataModels.StopInfo(this.f6503b);
            stopInfo.setOnTrip(true);
            stopInfo.setStopOrder(0);
            stopInfo.setStageId(newStageStartInfo.getId());
            j.this.n = new DataModels.p();
            j.this.n.b(newStageStartInfo.getId());
            j.this.n.a(Boolean.valueOf(newStageStartInfo.getStartOffline()));
            j.this.n.c(newStageStartInfo.getStartDate());
            j.this.n.a(w.d().b(), w.d().c());
            j.this.n.f(newStageStartInfo.getTripCounter());
            j.this.n.e(0);
            for (DataModels.b bVar : this.f6504c.values()) {
                j.this.n.a().add(bVar);
            }
            DataModels.b bVar2 = j.this.n.a().get(0);
            j.this.n.d(bVar2.k().b());
            j.this.n.b(bVar2.h() == null ? 0 : bVar2.h().e());
            j.this.n.a(bVar2.i() == null ? 0 : bVar2.i().c());
            if (this.f6504c.size() != 1) {
                j.this.n.g(-1);
                j.this.n.c(-1);
                j.this.n.a((String) null);
                j jVar = j.this;
                jVar.o = new o(stopInfo.getKey(), this.f6504c);
                j.this.c().post(j.this.o);
            } else {
                bVar2.a(newStageStartInfo.getId());
                j.this.n.g(bVar2.p());
                j.this.n.c(bVar2.j() == null ? 0 : bVar2.j().b());
                j.this.n.a(bVar2.f());
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                j.this.a(true);
            } else {
                j.this.a(false);
            }
            h.a.a.l.k().a(j.this.n, new a(stopInfo)).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: stageStart:onError " + error.getType().toString() + ";" + error.getMessage());
            boolean unused = j.D = false;
            this.f6502a.onError(error);
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class h implements BackendListeners.HasOngoingStageListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.StageStopListener f6508a;

        /* compiled from: BeaconManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.b {

            /* compiled from: BeaconManager.java */
            /* renamed from: h.a.a.j$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0138a implements BackendListeners.n {
                public C0138a(a aVar) {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.n
                public void onSuccess() {
                }
            }

            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.b
            public void a(DataModels.p pVar) {
                Iterator<DataModels.b> it;
                if (j.this.n != null && j.this.n.l().equals(pVar.l())) {
                    h.this.f6508a.onError(DataModels.Error.stageAlreadyStarted());
                    h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + DataModels.Error.stageAlreadyStarted().getType().toString());
                    return;
                }
                j.this.n = pVar;
                if (j.this.n != null && j.this.n.a() != null && j.this.n.a().size() > 0) {
                    j.this.n.a().get(j.this.n.a().size() - 1).c(w.d().e());
                    j.this.n.a().get(j.this.n.a().size() - 1).b(null);
                }
                if (SystemClock.elapsedRealtime() < j.this.n.k()) {
                    h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "Can't use stage date reference, using now device date as reference");
                    j.this.n.a(w.d().f(), SystemClock.elapsedRealtime());
                }
                w.d().a(j.this.n.j(), j.this.n.k());
                v.d().m();
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
                    int i2 = ((j.this.n.b() != null ? p.a(j.this.n.b()) : 0L) > 0L ? 1 : ((j.this.n.b() != null ? p.a(j.this.n.b()) : 0L) == 0L ? 0 : -1));
                    if (i2 > 0 && i2 > 0 && j.this.n.c() > 0) {
                        j.this.n.a((short) (j.this.n.c() - 1));
                    }
                    j.this.a(false);
                } else {
                    j.this.a(true);
                }
                List<DataModels.b> a2 = j.this.n.a();
                ArrayList arrayList = new ArrayList();
                String str = "";
                for (DataModels.b bVar : a2) {
                    j.this.f6475d.put(bVar.f(), bVar);
                    DataModels.StopInfo stopInfo = new DataModels.StopInfo(bVar);
                    arrayList.add(stopInfo);
                    str = str + stopInfo.toString() + "; ";
                    j.this.f6476e.put(stopInfo.getKey(), stopInfo);
                    if (!j.this.f6474c.containsKey(stopInfo.getKey())) {
                        j.this.f6474c.put(stopInfo.getKey(), new HashMap());
                    }
                    ((Map) j.this.f6474c.get(stopInfo.getKey())).put(bVar.f(), bVar);
                }
                j.this.k = new MotionTracker(h.a.a.l.k().g().containsKey("MOTION_TIMEOUT") ? Integer.parseInt(h.a.a.l.k().g().get("MOTION_TIMEOUT").a()) : j.this.u, 75);
                if (j.this.n.o() != 0) {
                    j.this.m = true;
                    j.this.k.a(true, j.this.b());
                } else {
                    j.this.m = false;
                    j.this.k.a(false, j.this.b());
                }
                String str2 = "getStageState:onSuccess - stageUpdate - stageId = " + j.this.n.l() + "BeaconDataList: ";
                while (j.this.n.a().iterator().hasNext()) {
                    str2 = str2 + it.next().toString() + "; ";
                }
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", str2);
                h.a.a.l.k().a(a2, new C0138a(this));
                j.this.k();
                j.this.c().post(j.this.A);
                h.this.f6508a.onSuccess();
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "stageStopListener.onSuccess");
                h.this.f6508a.onStartStageStops(arrayList);
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "stageStopListener.onStartStageStops: " + str);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                h.this.f6508a.onError(error);
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + error.getType().toString() + " " + error.getMessage());
            }
        }

        public h(BackendListeners.StageStopListener stageStopListener) {
            this.f6508a = stageStopListener;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f6508a.onError(error);
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + error.getType().toString());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.HasOngoingStageListener
        public void onSuccess(boolean z) {
            if (z) {
                j.this.f6475d = new HashMap();
                j.this.f6476e = new HashMap();
                j.this.f6474c = new HashMap();
                h.a.a.l.k().a(new a());
                return;
            }
            this.f6508a.onError(DataModels.Error.stageRequired());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + DataModels.Error.stageRequired().getType().toString());
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class i implements BackendListeners.n {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.FinishStageRequestListener f6511a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f6512b;

        /* compiled from: BeaconManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.i {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                i.this.f6511a.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.i
            public void onSuccess() {
                j.this.n = null;
                i.this.f6511a.onSuccess();
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "finishStage", "sending info to UI; newStage = " + i.this.f6512b);
                j.this.f6473b.onFinish(i.this.f6512b);
            }
        }

        public i(BackendListeners.FinishStageRequestListener finishStageRequestListener, boolean z) {
            this.f6511a = finishStageRequestListener;
            this.f6512b = z;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f6511a.onError(error);
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.n
        public void onSuccess() {
            h.a.a.l.k().a(new a());
        }
    }

    /* compiled from: BeaconManager.java */
    /* renamed from: h.a.a.j$j  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0139j implements BackendListeners.FinishStageRequestListener {
        public C0139j(j jVar) {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.FinishStageRequestListener
        public void onSuccess() {
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class k implements Runnable {

        /* compiled from: BeaconManager.java */
        /* loaded from: classes.dex */
        public class a implements k.d {
            public a() {
            }

            /* JADX WARN: Removed duplicated region for block: B:45:0x01b1  */
            /* JADX WARN: Removed duplicated region for block: B:52:0x021e  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x029f  */
            @Override // h.a.a.k.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a(pt.card4b.backendbeacons.DataModels.c r7) {
                /*
                    Method dump skipped, instructions count: 767
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: h.a.a.j.k.a.a(pt.card4b.backendbeacons.DataModels$c):void");
            }

            @Override // h.a.a.k.d
            public void onError(DataModels.Error error) {
                j.this.x.onError(error);
            }
        }

        public k() {
        }

        public void finalize() {
            h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "observeBeaconsRunnable:finalize", "entered method");
            super.finalize();
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.a().a((k.d) new a(), 0, h.a.a.l.k().g().containsKey("BLUETOOTH_SCAN_PERIOD") ? Long.parseLong(h.a.a.l.k().g().get("BLUETOOTH_SCAN_PERIOD").a()) : 3L, h.a.a.l.k().g().containsKey("BLUETOOTH_WAIT_PERIOD") ? Long.parseLong(h.a.a.l.k().g().get("BLUETOOTH_WAIT_PERIOD").a()) : 0L, h.a.a.l.k().g().containsKey("ACCEPTED_BEACON_INFO") ? Short.parseShort(h.a.a.l.k().g().get("ACCEPTED_BEACON_INFO").a()) : (short) 0, false, h.a.a.l.k().g().containsKey("USE_SCAN_FILTERS") && Short.parseShort(h.a.a.l.k().g().get("USE_SCAN_FILTERS").a()) > 0);
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class l implements k.d {
        public l() {
        }

        @Override // h.a.a.k.d
        public void a(DataModels.c cVar) {
            DataModels.b bVar = (DataModels.b) j.this.f6479h.get(cVar.f());
            ArrayList arrayList = new ArrayList();
            DataModels.StopInfo stopInfo = null;
            if (bVar != null) {
                bVar.a(cVar);
            } else if (j.this.b(cVar)) {
                bVar = j.this.a(cVar);
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "getNearbyStopsRunnable", "got NEW BeaconData");
                j.this.f6479h.put(bVar.f(), bVar);
                if (!j.this.f6480i.containsKey(bVar.n())) {
                    h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "getNearbyStopsRunnable", "create and SEND stop to UI");
                    stopInfo = new DataModels.StopInfo(bVar);
                    j.this.f6480i.put(bVar.n(), stopInfo);
                }
                if (!j.this.f6478g.containsKey(bVar.n())) {
                    j.this.f6478g.put(bVar.n(), new HashMap());
                }
                ((Map) j.this.f6478g.get(bVar.n())).put(bVar.f(), bVar);
            }
            if (bVar != null && j.this.f6479h != null && j.this.f6479h.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry entry : j.this.f6479h.entrySet()) {
                    if (entry.getKey() != bVar.f()) {
                        boolean z = true;
                        Iterator<String> it = ((DataModels.b) entry.getValue()).c().keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (!bVar.c().containsKey(it.next())) {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            arrayList2.add((DataModels.b) entry.getValue());
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        DataModels.b bVar2 = (DataModels.b) it2.next();
                        if (j.this.f6479h.containsKey(bVar2.f())) {
                            j.this.f6479h.remove(bVar2.f());
                        }
                        if (j.this.f6478g.containsKey(bVar2.n())) {
                            ((Map) j.this.f6478g.get(bVar2.n())).remove(bVar2.f());
                        }
                        if (!j.this.f6478g.containsKey(bVar2.n())) {
                            j.this.f6478g.remove(bVar2.n());
                        }
                        if (j.this.f6480i.containsKey(bVar2.n())) {
                            arrayList.add((DataModels.StopInfo) j.this.f6480i.remove(bVar2.n()));
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                j.this.f6472a.onRemoveStops(arrayList);
            }
            if (stopInfo != null) {
                j.this.f6472a.onReceiveStop(stopInfo.getCopy());
            }
        }

        @Override // h.a.a.k.d
        public void onError(DataModels.Error error) {
            j.this.f6472a.onRemoveStops(new ArrayList(j.this.f6480i.values()));
            j.this.f6472a.onError(error);
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class m implements Runnable {
        public m() {
        }

        public void finalize() {
            h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "checkNearbyStopsRunnable:finalize", "entered method");
            super.finalize();
        }

        @Override // java.lang.Runnable
        public void run() {
            DataModels.StopInfo stopInfo;
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "checkNearbyStopsRunnable", "entered runnable");
            j jVar = j.this;
            List<DataModels.b> a2 = jVar.a(jVar.j(), 10000);
            if (a2 != null && a2.size() > 0) {
                ArrayList arrayList = new ArrayList();
                String str = "should REMOVE STOPS: ";
                for (DataModels.b bVar : a2) {
                    j.this.f6479h.remove(bVar.f());
                    h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "checkNearbyStopsRunnable", "nearbyBeaconDataMap.remove(" + bVar.toString() + ")");
                    ((Map) j.this.f6478g.get(bVar.n())).remove(bVar.f());
                    if (((Map) j.this.f6478g.get(bVar.n())).size() == 0) {
                        j.this.f6478g.remove(bVar.n());
                        arrayList.add((DataModels.StopInfo) j.this.f6480i.remove(bVar.n()));
                        str = str + stopInfo.getStopName() + "; ";
                    }
                }
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "checkNearbyStopsRunnable", str);
                Iterator it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (((DataModels.StopInfo) it.next()) == null) {
                        arrayList.remove(i2);
                    }
                    i2++;
                }
                if (arrayList.size() > 0) {
                    j.this.f6472a.onRemoveStops(arrayList);
                }
            }
            j.this.c().postDelayed(this, 10000L);
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class n extends BroadcastReceiver {
        public n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            h.a.a.c.a("LOGIC_MOTION", "LOGIC_MOTION", "ActivityDetectionBroadcastReceiver", "RECEIVED BROADCAST");
            if (!intent.hasExtra(Constants.DETECTED_ACTIVITY) || j.this.n == null || j.this.r) {
                return;
            }
            h.a.a.c.a("LOGIC_MOTION", "BeaconManager", "ActivityDetectionBroadcastReceiver.onReceive", "Motion activity detected. Finish confirmation requested");
            j.this.f6473b.onFinishConfirmation(h.a.a.l.k().g().containsKey("FINISH_STAGE_USER_CONFIRMATION_TIMEOUT") ? Integer.parseInt(h.a.a.l.k().g().get("FINISH_STAGE_USER_CONFIRMATION_TIMEOUT").a()) : j.this.t, false);
            j.this.r = true;
            j.this.s = DataModels.o.n;
            j.this.n.b(w.d().e());
        }
    }

    /* compiled from: BeaconManager.java */
    /* loaded from: classes.dex */
    public class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, DataModels.b> f6520a;

        /* compiled from: BeaconManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.k {
            public a(o oVar) {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.k
            public void onSuccess() {
            }
        }

        public o(String str, Map<String, DataModels.b> map) {
            this.f6520a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(this.f6520a.values()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DataModels.b bVar = (DataModels.b) it.next();
                bVar.a(false);
                this.f6520a.remove(bVar.f());
                j.this.n.a().remove(bVar);
            }
            if (this.f6520a.size() > 1) {
                int b2 = j.this.n.a().get(0).j().b();
                int p = j.this.n.a().get(0).p();
                for (DataModels.b bVar2 : new ArrayList(this.f6520a.values())) {
                    if (b2 != bVar2.j().b()) {
                        b2 = -1;
                    }
                    if (p != bVar2.p()) {
                        p = -1;
                    }
                }
                j.this.n.g(p);
                j.this.n.c(b2);
                j.this.c().postDelayed(this, 10000L);
            } else {
                DataModels.b bVar3 = j.this.n.a().get(0);
                j.this.n.a(bVar3.f());
                j.this.n.g(bVar3.p());
                j.this.n.c(bVar3.j() != null ? bVar3.h().e() : 0);
                h.a.a.c.a("LOGIC_STOPS", "BeaconManager", "checkFirstStopRunnable", "first stop DECIDED " + this.f6520a.get(j.this.n.d()).m().c());
            }
            h.a.a.l.k().a(j.this.n, new a(this)).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
        }
    }

    public j() {
        if (C == null) {
            this.f6474c = new HashMap();
            this.f6475d = new HashMap();
            this.f6476e = new HashMap();
            this.f6477f = new HashMap();
            this.f6478g = new HashMap();
            this.f6479h = new HashMap();
            this.f6480i = new HashMap();
            return;
        }
        throw new RuntimeException("BeaconManager: Use getInstance() method to get the single instance of this class.");
    }

    public static j d() {
        if (C == null) {
            synchronized (j.class) {
                if (C == null) {
                    C = new j();
                }
            }
        }
        return C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a().a((k.d) new l(), 1, h.a.a.l.k().g().containsKey("BLUETOOTH_SCAN_PERIOD") ? Long.parseLong(h.a.a.l.k().g().get("BLUETOOTH_SCAN_PERIOD").a()) : 3L, h.a.a.l.k().g().containsKey("BLUETOOTH_WAIT_PERIOD") ? Long.parseLong(h.a.a.l.k().g().get("BLUETOOTH_WAIT_PERIOD").a()) : 0L, h.a.a.l.k().g().containsKey("ACCEPTED_BEACON_INFO") ? Short.parseShort(h.a.a.l.k().g().get("ACCEPTED_BEACON_INFO").a()) : (short) 0, false, h.a.a.l.k().g().containsKey("USE_SCAN_FILTERS") && Short.parseShort(h.a.a.l.k().g().get("USE_SCAN_FILTERS").a()) > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DataModels.b f() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        DataModels.p pVar = this.n;
        if (pVar != null) {
            DataModels.b bVar = pVar.d() != null ? this.f6475d.get(this.n.d()) : null;
            if (bVar != null) {
                boolean z = this.n.a().size() > 0 && this.n.a().get(0).b().size() > 0 && a(this.n.a().get(0).b().get(0));
                if ((z || this.n.o() != 0) && (!z || bVar.k().e().a() == DataModels.n.f7735c || this.n.o() != 0)) {
                    if (!z || bVar.k().e().a() != DataModels.n.f7735c) {
                        return false;
                    }
                    if (this.n.o() != 0 && this.n.o() != 1) {
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
    public boolean j() {
        return this.n != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        boolean z = true;
        a().a(new a(), 2, h.a.a.l.k().g().containsKey("BLUETOOTH_SCAN_PERIOD") ? Long.parseLong(h.a.a.l.k().g().get("BLUETOOTH_SCAN_PERIOD").a()) : 3L, h.a.a.l.k().g().containsKey("BLUETOOTH_WAIT_PERIOD") ? Long.parseLong(h.a.a.l.k().g().get("BLUETOOTH_WAIT_PERIOD").a()) : 0L, h.a.a.l.k().g().containsKey("ACCEPTED_BEACON_INFO") ? Short.parseShort(h.a.a.l.k().g().get("ACCEPTED_BEACON_INFO").a()) : (short) 0, h.a.a.l.k().g().containsKey("SEND_STAGE_BEACON_LOCATION") && Short.parseShort(h.a.a.l.k().g().get("SEND_STAGE_BEACON_LOCATION").a()) > 0, (!h.a.a.l.k().g().containsKey("USE_SCAN_FILTERS") || Short.parseShort(h.a.a.l.k().g().get("USE_SCAN_FILTERS").a()) <= 0) ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "stopCallbacksAndMotionTracker", "Stopping callbacks and motion tracker");
        Handler c2 = c();
        c2.removeCallbacks(this.z);
        c2.removeCallbacks(this.A);
        c2.removeCallbacks(this.o);
        a().e();
        if (this.m) {
            this.m = false;
            MotionTracker motionTracker = this.k;
            if (motionTracker != null) {
                motionTracker.g();
            }
        }
    }

    public DataModels.p g() {
        return this.n;
    }

    public BackendListeners.StageStopListener h() {
        return this.f6473b;
    }

    public void l() {
        h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "stopBeaconService", "entered method");
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler c() {
        if (this.p == null) {
            this.p = new Handler();
        }
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n b() {
        if (this.l == null) {
            this.l = new n();
        }
        return this.l;
    }

    private void c(DataModels.b bVar) {
        this.v = bVar;
    }

    private boolean c(DataModels.c cVar) {
        if (cVar != null) {
            return cVar.e();
        }
        return false;
    }

    public void d(DataModels.c cVar) {
        if (cVar != null && b(cVar)) {
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStageFromHCE", "starting new stage from HCE. key=" + cVar.f());
            a(a(cVar), this.f6473b);
            return;
        }
        h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStageFromHCE", "The beacon is not a valid Andante beacon. Key=" + cVar.f());
    }

    public void b(BackendListeners.StageStopListener stageStopListener) {
        this.f6473b = stageStopListener;
    }

    public boolean b(DataModels.c cVar) {
        DataModels.m mVar = h.a.a.l.k().r().get(cVar.l());
        if (mVar != null) {
            Map<String, DataModels.j> o2 = h.a.a.l.k().o();
            DataModels.j jVar = o2.get(cVar.h() + "|" + mVar.b());
            DataModels.l lVar = h.a.a.l.k().n().get(cVar.x());
            Map<String, DataModels.k> m2 = h.a.a.l.k().m();
            DataModels.k kVar = m2.get(cVar.m() + "|" + mVar.b());
            Map<String, DataModels.q> s = h.a.a.l.k().s();
            DataModels.q qVar = s.get(cVar.q() + "|" + cVar.l());
            DataModels.r rVar = h.a.a.l.k().u().get(cVar.A());
            if (mVar.e() != null) {
                return mVar.e().a() == DataModels.n.f7735c ? ((!c(cVar) && cVar.y() == 0) || jVar == null || lVar == null || kVar == null || rVar == null || qVar == null) ? false : true : (qVar == null || rVar == null) ? false : true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h.a.a.k a() {
        short s = h.a.a.k.f6522f;
        if (h.a.a.l.k().g().containsKey("BEACON_SCAN_API") && Integer.parseInt(h.a.a.l.k().g().get("BEACON_SCAN_API").a()) > 0) {
            s = (short) Integer.parseInt(h.a.a.l.k().g().get("BEACON_SCAN_API").a());
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("OnePlus") && h.a.a.l.k().g().containsKey("ONEPLUS_BEACON_SCAN_API") && Integer.parseInt(h.a.a.l.k().g().get("ONEPLUS_BEACON_SCAN_API").a()) > 0) {
            s = (short) Integer.parseInt(h.a.a.l.k().g().get("ONEPLUS_BEACON_SCAN_API").a());
        }
        h.a.a.k kVar = this.q;
        if (kVar == null) {
            this.q = new h.a.a.k(s);
        } else {
            kVar.a(s);
        }
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(DataModels.b bVar) {
        if (j() && this.n.i() == bVar.k().b() && bVar.k().e() != null) {
            if (bVar.k().e().a() != DataModels.n.f7735c) {
                return true;
            }
            int p = bVar.p();
            int e2 = bVar.h() == null ? 0 : bVar.h().e();
            int b2 = bVar.j() == null ? 0 : bVar.j().b();
            boolean z = this.n.g() == e2 && this.n.f() == (bVar.i() == null ? 0 : bVar.i().c());
            if (z && this.n.h() > 0) {
                z = this.n.h() == b2;
            }
            if (!z || this.n.q() <= 0) {
                return z;
            }
            if (this.n.q() == p) {
                return true;
            }
        }
        return false;
    }

    public void a(BackendListeners.PossibleStopListener possibleStopListener) {
        h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "entered method");
        if (!h.a.a.l.k().d()) {
            possibleStopListener.onError(DataModels.Error.missingData());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "ERROR: " + DataModels.Error.missingData().getType().toString());
        } else if (h.a.a.l.k().e() == null) {
            possibleStopListener.onError(DataModels.Error.loginRequired());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (j()) {
            possibleStopListener.onError(DataModels.Error.stageOngoing());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "getNearbyStops", "ERROR: " + DataModels.Error.stageOngoing().getType().toString());
        } else {
            h.a.a.l.k().a(new e(possibleStopListener));
        }
    }

    public void a(DataModels.StopInfo stopInfo, BackendListeners.StageStopListener stageStopListener) {
        Map<String, DataModels.b> map;
        if (stopInfo != null) {
            r0 = this.f6478g.containsKey(stopInfo.getKey()) ? (DataModels.b) this.f6478g.get(stopInfo.getKey()).values().toArray()[0] : null;
            if (r0 == null && (map = this.f6477f) != null) {
                Iterator<DataModels.b> it = map.values().iterator();
                if (it.hasNext()) {
                    DataModels.b next = it.next();
                    if (stopInfo.getKey().equals(new DataModels.StopInfo(next).getKey())) {
                        r0 = next;
                    }
                }
            }
        }
        a(r0, stageStopListener);
    }

    public void a(DataModels.b bVar, BackendListeners.StageStopListener stageStopListener) {
        h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStage (" + String.format("Current Version is: %s-%s", "1.2.78", "staging") + ")", "entered method");
        if (bVar == null || TextUtils.isEmpty(bVar.f())) {
            stageStopListener.onError(DataModels.Error.fieldRequired(p.a(h.a.a.a.startinfo)));
        } else if (!h.a.a.l.k().d()) {
            stageStopListener.onError(DataModels.Error.missingData());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: " + DataModels.Error.missingData().getType().toString());
        } else if (h.a.a.l.k().e() == null) {
            stageStopListener.onError(DataModels.Error.loginRequired());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (D) {
            stageStopListener.onError(DataModels.Error.stageAlreadyStarted());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "ERROR: " + DataModels.Error.stageAlreadyStarted().getType().toString());
        } else {
            if (this.r) {
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "startNewStage", "A finish confirmation dialog is in progress, confirmation dismiss requested");
                this.f6473b.onFinishConfirmation(0, true);
                this.r = false;
                this.s = null;
                DataModels.p pVar = this.n;
                if (pVar != null) {
                    pVar.b((Date) null);
                }
            }
            D = true;
            h.a.a.l.k().a(new f(stageStopListener, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataModels.b bVar, BackendListeners.StageStopListener stageStopListener, boolean z) {
        h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "proceedWithStartStage", "entered method");
        if (bVar == null) {
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "proceedWithStartStage", "Missing start info");
            stageStopListener.onError(DataModels.Error.missingData());
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(bVar.f(), bVar);
        for (DataModels.b bVar2 : hashMap.values()) {
            bVar2.a(true);
            bVar2.a(0);
            bVar2.a(h.a.a.l.k().f().get("START_STAGE"));
        }
        h.a.a.l.k().a(hashMap.values(), new g(stageStopListener, bVar, hashMap));
    }

    public void a(BackendListeners.StageStopListener stageStopListener) {
        h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "entered method");
        if (!h.a.a.l.k().d()) {
            stageStopListener.onError(DataModels.Error.missingData());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + DataModels.Error.missingData().getType().toString());
        } else if (h.a.a.l.k().e() == null) {
            stageStopListener.onError(DataModels.Error.loginRequired());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
        } else if (!h.a.a.l.k().v()) {
            stageStopListener.onError(DataModels.Error.initFailedDataSuspect());
            h.a.a.c.a("LOGIC_BEACONS", "Consuela", "resumeStage", "ERROR: " + DataModels.Error.initFailedDataSuspect().getType().toString());
        } else if (j()) {
            stageStopListener.onError(DataModels.Error.stageOngoing());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "resumeStage", "ERROR: " + DataModels.Error.stageOngoing().getType().toString());
        } else {
            this.f6473b = stageStopListener;
            h.a.a.l.k().a(new h(stageStopListener));
        }
    }

    public void a(boolean z, String str, BackendListeners.FinishStageRequestListener finishStageRequestListener) {
        Iterator<DataModels.b> it;
        h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "finishStage", "entered method");
        if (h.a.a.l.k().e() == null) {
            finishStageRequestListener.onError(DataModels.Error.loginRequired());
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "finishStage", "ERROR: " + DataModels.Error.loginRequired().getType().toString());
            return;
        }
        DataModels.p pVar = this.n;
        if (pVar != null && pVar.l() != null) {
            m();
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "finishStage", "currentBeaconDataKey = " + this.n.d());
            StringBuilder sb = new StringBuilder();
            sb.append("beaconData is null ? ");
            sb.append(Boolean.toString(this.f6475d.get(this.n.d()) == null));
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "finishStage", sb.toString());
            if (this.n.d() != null) {
                this.f6475d.get(this.n.d()).a(h.a.a.l.k().f().get("END_STAGE"));
            } else {
                for (DataModels.b bVar : this.n.a()) {
                    bVar.a(h.a.a.l.k().f().get("END_STAGE"));
                }
            }
            String str2 = "stageFinish - stageId = " + this.n.l() + "BeaconDataList: ";
            while (this.n.a().iterator().hasNext()) {
                str2 = str2 + it.next().toString() + "; ";
            }
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "finishStage", str2);
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "finishStage", "Calling Consuela.stageFinish...");
            h.a.a.l.k().a(this.n.l(), str, this.n.a(), new i(finishStageRequestListener, z));
            return;
        }
        finishStageRequestListener.onError(DataModels.Error.stageRequired());
        h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "finishStage", "ERROR: " + DataModels.Error.stageRequired().getType().toString());
    }

    public void a(boolean z, boolean z2, BackendListeners.FinishStageUserConfirmationListener finishStageUserConfirmationListener) {
        String str;
        DataModels.p pVar;
        if (!z && !z2) {
            h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "confirmStageFinished", "user confirmed that the stage is NOT finished");
            String str2 = this.s;
            if (str2 == DataModels.o.m) {
                DataModels.p pVar2 = this.n;
                if (pVar2 != null) {
                    DataModels.b bVar = pVar2.d() != null ? this.f6475d.get(this.n.d()) : null;
                    if (bVar != null) {
                        bVar.c(w.d().e());
                        bVar.b(null);
                    }
                }
            } else if (str2 == DataModels.o.n) {
                this.k.e();
            } else if (str2 == DataModels.o.q && (pVar = this.n) != null) {
                DataModels.b bVar2 = pVar.d() != null ? this.f6475d.get(this.n.d()) : null;
                if (bVar2 != null) {
                    bVar2.a(bVar2.g());
                }
            }
        } else {
            if (z2) {
                String str3 = this.s;
                str = str3 == DataModels.o.m ? DataModels.o.t : str3 == DataModels.o.n ? DataModels.o.v : str3 == DataModels.o.q ? DataModels.o.x : str3 == DataModels.o.r ? DataModels.o.B : DataModels.o.m;
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "confirmStageFinished", "confirmation request was dismissed by timeout");
            } else {
                String str4 = this.s;
                str = str4 == DataModels.o.m ? DataModels.o.s : str4 == DataModels.o.n ? DataModels.o.u : str4 == DataModels.o.q ? DataModels.o.w : str4 == DataModels.o.r ? DataModels.o.A : DataModels.o.m;
                h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "confirmStageFinished", "user confirmed that the stage IS finished");
            }
            a(false, str, (BackendListeners.FinishStageRequestListener) new C0139j(this));
        }
        finishStageUserConfirmationListener.onSuccess(z || z2);
        this.r = false;
        this.s = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DataModels.b> a(boolean z, int i2) {
        Date e2 = w.d().e();
        ArrayList<DataModels.b> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            Map<String, DataModels.b> map = this.f6475d;
            if (map != null) {
                arrayList.addAll(map.values());
            }
        } else {
            Map<String, DataModels.b> map2 = this.f6479h;
            if (map2 != null) {
                arrayList.addAll(map2.values());
            }
        }
        int i3 = i2;
        for (DataModels.b bVar : arrayList) {
            if (z) {
                i3 = bVar.r() ? bVar.k().d() * 1000 : i2;
            }
            Iterator it = new ArrayList(bVar.b()).iterator();
            while (it.hasNext()) {
                DataModels.a aVar = (DataModels.a) it.next();
                if (p.a(e2) - p.a(aVar.f()) > i2) {
                    if (aVar.b() == null) {
                        aVar.b(e2);
                    } else if (p.a(e2) - p.a(aVar.f()) > i3 && !bVar.r()) {
                        bVar.c().remove(aVar.j());
                        bVar.b().remove(aVar);
                    }
                }
            }
            if (p.a(e2) - p.a(bVar.g()) > i2) {
                if (bVar.e() == null) {
                    bVar.b(e2);
                } else if (p.a(e2) - p.a(bVar.g()) > i3) {
                    h.a.a.c.a("LOGIC_BEACONS", "BeaconManager", "checkOffRange", bVar.m().c() + " marked as out of range");
                    arrayList2.add(bVar);
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DataModels.b a(DataModels.c cVar) {
        DataModels.m mVar = h.a.a.l.k().r().get(cVar.l());
        Map<String, DataModels.j> o2 = h.a.a.l.k().o();
        Map<String, DataModels.k> m2 = h.a.a.l.k().m();
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.m());
        sb.append("|");
        sb.append(mVar.b());
        Map<String, DataModels.q> s = h.a.a.l.k().s();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cVar.q());
        sb2.append("|");
        sb2.append(cVar.l());
        DataModels.b bVar = new DataModels.b(cVar);
        bVar.a(mVar);
        bVar.a(o2.get(cVar.h() + "|" + mVar.b()));
        bVar.a(h.a.a.l.k().n().get(cVar.x()));
        bVar.a(m2.get(sb.toString()));
        bVar.a(s.get(sb2.toString()));
        bVar.a(h.a.a.l.k().u().get(cVar.A()));
        bVar.a(cVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(DataModels.a aVar) {
        if (aVar != null) {
            return aVar.e().booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(DataModels.b bVar) {
        DataModels.p pVar = this.n;
        if (pVar != null) {
            boolean z = pVar.o() == 0 || (this.n.o() == 1 && this.n.a().size() > 1 && this.n.a().get(0) != null && this.n.a().get(0).b().size() == 1 && a(this.n.a().get(0).b().get(0)));
            DataModels.b bVar2 = this.f6475d.get(this.n.d());
            if (bVar2 != null && z && bVar.p() == this.n.q()) {
                if (!(bVar.k() == null && this.n.i() == 0) && (bVar.k() == null || bVar.k().b() != this.n.i())) {
                    return false;
                }
                if (!(bVar.h() == null && this.n.g() == 0) && (bVar.h() == null || bVar.h().e() != this.n.g())) {
                    return false;
                }
                if (!(bVar.q() == null && bVar2.q() == null) && (bVar.q() == null || bVar2.q() == null || bVar.q().b() != bVar2.q().b())) {
                    return false;
                }
                if (!(bVar.m() == null && bVar2.m() == null) && (bVar.m() == null || bVar2.m() == null || bVar.m().d() != bVar2.m().d())) {
                    return false;
                }
                if (!(bVar.j() == null && bVar2.j() == null) && (bVar.j() == null || bVar2.j() == null || bVar.j().b() != bVar2.j().b())) {
                    return false;
                }
                return (bVar.i() == null && bVar2.i() != null) || (bVar.i() != null && bVar2.i() == null) || !(bVar.i() == null || bVar2.i() == null || bVar.i().c() == bVar2.i().c());
            }
            return false;
        }
        return false;
    }

    public void a(int i2, BackendListeners.ScheduleStageStartListener scheduleStageStartListener) {
        if (this.f6473b != null) {
            Map<String, DataModels.b> map = this.f6479h;
            if (map != null && map.size() > 0) {
                c((DataModels.b) this.f6479h.values().toArray()[0]);
                c().postDelayed(this.B, i2 * 1000);
                scheduleStageStartListener.onSuccess();
                return;
            }
            scheduleStageStartListener.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "no beacons detected", ""));
            return;
        }
        scheduleStageStartListener.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "stageStopListener not set", ""));
    }

    public void a(boolean z) {
        DataModels.p pVar = this.n;
        if (pVar != null) {
            boolean z2 = true;
            if (z) {
                h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "BluetoothStateChanged", "BT sate changed to ON");
                if (this.n.b() != null) {
                    this.n.a((Date) null);
                } else {
                    z2 = false;
                }
            } else {
                pVar.a((short) (pVar.c() + 1));
                if (this.n.b() == null) {
                    this.n.a(w.d().e());
                }
                h.a.a.c.a("LOGIC_OTHER", "BeaconManager", "BluetoothStateChanged", "BT sate changed to OFF(" + ((int) this.n.c()) + "x)");
            }
            if (z2) {
                h.a.a.l.k().a(this.n, new d(this)).subscribeOn(d.c.j0.a.b()).observeOn(d.c.b0.b.a.a()).subscribe();
            }
        }
    }
}
