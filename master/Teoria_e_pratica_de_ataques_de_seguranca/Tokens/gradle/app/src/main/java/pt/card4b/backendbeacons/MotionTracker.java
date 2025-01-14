package pt.card4b.backendbeacons;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import p000a.p006b.p030g.p032b.LocalBroadcastManager;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0929h;
import p070c.p084d.p085a.p086a.p103i.C1204a;
import p070c.p084d.p085a.p086a.p103i.C1209c;
import p205h.p206a.p207a.AppLog;
import p205h.p206a.p207a.GeneralUtils;
import p205h.p206a.p207a.SysDateManager;

/* loaded from: classes.dex */
public class MotionTracker implements AbstractC0921d.InterfaceC0923b, AbstractC0921d.InterfaceC0924c, InterfaceC0929h<Status> {

    /* renamed from: a */
    public int f10908a;

    /* renamed from: b */
    public int f10909b;

    /* renamed from: c */
    public boolean f10910c;

    /* renamed from: d */
    public AbstractC0921d f10911d;

    /* loaded from: classes.dex */
    public static class MotionTrackerService extends IntentService {

        /* renamed from: a */
        public static long f10912a = SysDateManager.m1497d().m1493h();

        /* renamed from: b */
        public static List<C2710a> f10913b = new ArrayList();

        /* renamed from: pt.card4b.backendbeacons.MotionTracker$MotionTrackerService$a */
        /* loaded from: classes.dex */
        public class C2710a {

            /* renamed from: a */
            public int f10914a;

            /* renamed from: b */
            public long f10915b;

            public C2710a(MotionTrackerService motionTrackerService, int i, long j) {
                this.f10914a = i;
                this.f10915b = j;
            }

            /* renamed from: a */
            public int m47a() {
                return this.f10914a;
            }

            /* renamed from: b */
            public long m46b() {
                return this.f10915b;
            }
        }

        public MotionTrackerService() {
            super("MotionTrackerService");
        }

        /* renamed from: a */
        public static void m48a() {
            f10912a = SysDateManager.m1497d().m1493h();
            f10913b = new ArrayList();
        }

        @Override // android.app.IntentService, android.app.Service
        public void onCreate() {
            super.onCreate();
            new Handler();
        }

        @Override // android.app.IntentService
        public void onHandleIntent(Intent intent) {
            ActivityRecognitionResult m4339a = ActivityRecognitionResult.m4339a(intent);
            int intExtra = intent.getIntExtra("interval", 1000);
            int intExtra2 = intent.getIntExtra("confidence", 75);
            String str = "";
            String str2 = "";
            for (C1209c c1209c : m4339a.m4333d()) {
                str2 = str2 + String.format("%s: %d%n", Constants.getActivityString(c1209c.m4991c()), Integer.valueOf(c1209c.m4992b()));
            }
            AppLog.m2158a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "message: " + str2);
            int max = Math.max(Math.max(Math.max(m4339a.m4340a(1), m4339a.m4340a(2)), m4339a.m4340a(8)), m4339a.m4340a(7));
            if (max > 0 && m4339a.m4335c().m4991c() != 5) {
                f10913b.add(new C2710a(this, max, m4339a.m4332e()));
                long m1493h = SysDateManager.m1497d().m1493h();
                String str3 = ("interval = " + intExtra + "\n") + "dt = " + (m1493h - f10912a) + "\n";
                AppLog.m2158a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "walkDetectionStart = " + f10912a);
                AppLog.m2158a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "dt = " + (m1493h - f10912a));
                long j = (long) intExtra;
                if (m1493h - f10912a >= j) {
                    Iterator<C2710a> it = f10913b.iterator();
                    while (it.hasNext() && it.next().m46b() < m1493h - j) {
                        it.remove();
                    }
                    ArrayList arrayList = new ArrayList();
                    for (C2710a c2710a : f10913b) {
                        arrayList.add(Integer.valueOf(c2710a.m47a()));
                    }
                    double m1596a = GeneralUtils.m1596a(arrayList);
                    str = str3 + "WALK confidence = " + m1596a + "\n";
                    AppLog.m2158a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "WALK confidence = " + m1596a);
                    if (GeneralUtils.m1596a(arrayList) >= intExtra2) {
                        AppLog.m2158a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "walking for " + intExtra + " ms - WILL FINISH STAGE");
                        Intent intent2 = new Intent(Constants.BROADCAST_ACTION);
                        intent2.putExtra(Constants.DETECTED_ACTIVITY, m4339a);
                        LocalBroadcastManager.m10011a(this).m10010a(intent2);
                        stopSelf();
                    }
                } else {
                    str = str3;
                }
            }
            List<C1209c> m4333d = m4339a.m4333d();
            AppLog.m2158a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "current time = " + SysDateManager.m1497d().m1496e());
            AppLog.m2158a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "real time = " + new Date(m4339a.m4332e()));
            AppLog.m2158a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "elapsed time = " + (m4339a.m4337b() / 1000) + "seconds");
            for (C1209c c1209c2 : m4333d) {
                AppLog.m2158a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", Constants.getActivityString(c1209c2.m4991c()) + " " + c1209c2.m4992b() + "%");
            }
            for (C1209c c1209c3 : m4339a.m4333d()) {
                str = str + c1209c3.m4992b() + " " + Constants.getActivityString(c1209c3.m4991c()) + "\n";
            }
        }
    }

    /* renamed from: pt.card4b.backendbeacons.MotionTracker$a */
    /* loaded from: classes.dex */
    public class C2711a extends BroadcastReceiver {
        public C2711a(MotionTracker motionTracker) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    }

    public MotionTracker(int i, int i2) {
        this.f10908a = i;
        this.f10909b = i2;
        new ArrayList();
    }

    /* renamed from: b */
    private PendingIntent m54b() {
        Intent intent = new Intent(App.getContext(), MotionTrackerService.class);
        intent.putExtra("interval", this.f10908a);
        intent.putExtra("confidence", this.f10909b);
        AppLog.m2158a("LOGIC_MOTION", "MotionTracker", "getActivityDetectionPendingIntent", "start MotionTrackerService");
        return PendingIntent.getService(App.getContext(), 0, intent, 134217728);
    }

    /* renamed from: c */
    private void m53c() {
        if (!this.f10911d.mo5503d()) {
            AppLog.m2158a("LOGIC_MOTION", "MotionTracker", "removeActivityUpdatesHandler", "mGoogleApiClient NOT connected");
        } else {
            C1204a.f5608d.mo4993a(this.f10911d, m54b()).mo4365a(this);
        }
    }

    /* renamed from: d */
    private void m52d() {
        if (!this.f10911d.mo5503d()) {
            AppLog.m2158a("LOGIC_MOTION", "MotionTracker", "requestActivityUpdatesHandler", "mGoogleApiClient NOT connected");
            return;
        }
        C1204a.f5608d.mo4994a(this.f10911d, 500L, m54b()).mo4365a(this);
        AppLog.m2158a("LOGIC_MOTION", "MotionTracker", "requestActivityUpdatesHandler", "MotionTracker service STARTED");
    }

    /* renamed from: a */
    public void m55a(boolean z, BroadcastReceiver broadcastReceiver) {
        this.f10910c = z;
        if (broadcastReceiver == null) {
            broadcastReceiver = new C2711a(this);
        }
        m57a();
        this.f10911d.mo5508a();
        LocalBroadcastManager.m10011a(App.getInstance()).m10012a(broadcastReceiver, new IntentFilter(Constants.BROADCAST_ACTION));
    }

    /* renamed from: e */
    public void m51e() {
        MotionTrackerService.m48a();
    }

    /* renamed from: f */
    public void m50f() {
        this.f10910c = true;
        m51e();
        m52d();
    }

    /* renamed from: g */
    public void m49g() {
        m51e();
        m53c();
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public void onConnected(Bundle bundle) {
        AppLog.m2158a("LOGIC_MOTION", "MotionTracker", "onConnected", "Connected to GoogleApiClient");
        if (this.f10910c) {
            m52d();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0924c
    public void onConnectionFailed(C0900a c0900a) {
        AppLog.m2158a("LOGIC_MOTION", "MotionTracker", "onConnectionFailed", "Connection to GoogleApiClient failed: ConnectionResult.getErrorCode() = " + c0900a.m5645b());
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public void onConnectionSuspended(int i) {
        AppLog.m2158a("LOGIC_MOTION", "MotionTracker", "onConnectionSuspended", "Connection suspended");
        this.f10911d.mo5508a();
    }

    /* renamed from: a */
    private synchronized void m57a() {
        if (this.f10911d == null) {
            AbstractC0921d.C0922a c0922a = new AbstractC0921d.C0922a(App.getInstance());
            c0922a.m5590a((AbstractC0921d.InterfaceC0923b) this);
            c0922a.m5589a((AbstractC0921d.InterfaceC0924c) this);
            c0922a.m5591a(C1204a.f5607c);
            this.f10911d = c0922a.m5592a();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0929h
    /* renamed from: a */
    public void onResult(Status status) {
        if (status.m4370e()) {
            AppLog.m2158a("LOGIC_MOTION", "MotionTracker", "onResult", "Success adding or removing activity detection: " + status.m4372c());
            return;
        }
        AppLog.m2158a("LOGIC_MOTION", "MotionTracker", "onResult", "Error adding or removing activity detection: " + status.m4372c());
    }
}
