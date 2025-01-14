package pt.card4b.backendbeacons;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import c.d.a.a.e.e.d;
import c.d.a.a.e.e.h;
import c.d.a.a.i.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionResult;
import h.a.a.p;
import h.a.a.w;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class MotionTracker implements d.b, d.c, h<Status> {

    /* renamed from: a  reason: collision with root package name */
    public int f7771a;

    /* renamed from: b  reason: collision with root package name */
    public int f7772b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7773c;

    /* renamed from: d  reason: collision with root package name */
    public d f7774d;

    /* loaded from: classes.dex */
    public static class MotionTrackerService extends IntentService {

        /* renamed from: a  reason: collision with root package name */
        public static long f7775a = w.d().h();

        /* renamed from: b  reason: collision with root package name */
        public static List<a> f7776b = new ArrayList();

        /* loaded from: classes.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public int f7777a;

            /* renamed from: b  reason: collision with root package name */
            public long f7778b;

            public a(MotionTrackerService motionTrackerService, int i2, long j) {
                this.f7777a = i2;
                this.f7778b = j;
            }

            public int a() {
                return this.f7777a;
            }

            public long b() {
                return this.f7778b;
            }
        }

        public MotionTrackerService() {
            super("MotionTrackerService");
        }

        public static void a() {
            f7775a = w.d().h();
            f7776b = new ArrayList();
        }

        @Override // android.app.IntentService, android.app.Service
        public void onCreate() {
            super.onCreate();
            new Handler();
        }

        @Override // android.app.IntentService
        public void onHandleIntent(Intent intent) {
            ActivityRecognitionResult a2 = ActivityRecognitionResult.a(intent);
            int intExtra = intent.getIntExtra("interval", 1000);
            int intExtra2 = intent.getIntExtra("confidence", 75);
            String str = "";
            String str2 = "";
            for (c cVar : a2.d()) {
                str2 = str2 + String.format("%s: %d%n", Constants.getActivityString(cVar.c()), Integer.valueOf(cVar.b()));
            }
            h.a.a.c.a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "message: " + str2);
            int max = Math.max(Math.max(Math.max(a2.a(1), a2.a(2)), a2.a(8)), a2.a(7));
            if (max > 0 && a2.c().c() != 5) {
                f7776b.add(new a(this, max, a2.e()));
                long h2 = w.d().h();
                String str3 = ("interval = " + intExtra + "\n") + "dt = " + (h2 - f7775a) + "\n";
                h.a.a.c.a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "walkDetectionStart = " + f7775a);
                h.a.a.c.a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "dt = " + (h2 - f7775a));
                long j = (long) intExtra;
                if (h2 - f7775a >= j) {
                    Iterator<a> it = f7776b.iterator();
                    while (it.hasNext() && it.next().b() < h2 - j) {
                        it.remove();
                    }
                    ArrayList arrayList = new ArrayList();
                    for (a aVar : f7776b) {
                        arrayList.add(Integer.valueOf(aVar.a()));
                    }
                    double a3 = p.a(arrayList);
                    str = str3 + "WALK confidence = " + a3 + "\n";
                    h.a.a.c.a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "WALK confidence = " + a3);
                    if (p.a(arrayList) >= intExtra2) {
                        h.a.a.c.a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "walking for " + intExtra + " ms - WILL FINISH STAGE");
                        Intent intent2 = new Intent(Constants.BROADCAST_ACTION);
                        intent2.putExtra(Constants.DETECTED_ACTIVITY, a2);
                        a.b.g.b.d.a(this).a(intent2);
                        stopSelf();
                    }
                } else {
                    str = str3;
                }
            }
            List<c> d2 = a2.d();
            h.a.a.c.a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "current time = " + w.d().e());
            h.a.a.c.a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "real time = " + new Date(a2.e()));
            h.a.a.c.a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", "elapsed time = " + (a2.b() / 1000) + "seconds");
            for (c cVar2 : d2) {
                h.a.a.c.a("LOGIC_MOTION", "MotionTrackerService", "onHandleIntent", Constants.getActivityString(cVar2.c()) + " " + cVar2.b() + "%");
            }
            for (c cVar3 : a2.d()) {
                str = str + cVar3.b() + " " + Constants.getActivityString(cVar3.c()) + "\n";
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a(MotionTracker motionTracker) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    }

    public MotionTracker(int i2, int i3) {
        this.f7771a = i2;
        this.f7772b = i3;
        new ArrayList();
    }

    private PendingIntent b() {
        Intent intent = new Intent(App.getContext(), MotionTrackerService.class);
        intent.putExtra("interval", this.f7771a);
        intent.putExtra("confidence", this.f7772b);
        h.a.a.c.a("LOGIC_MOTION", "MotionTracker", "getActivityDetectionPendingIntent", "start MotionTrackerService");
        return PendingIntent.getService(App.getContext(), 0, intent, 134217728);
    }

    private void c() {
        if (!this.f7774d.d()) {
            h.a.a.c.a("LOGIC_MOTION", "MotionTracker", "removeActivityUpdatesHandler", "mGoogleApiClient NOT connected");
        } else {
            c.d.a.a.i.a.f3665d.a(this.f7774d, b()).a(this);
        }
    }

    private void d() {
        if (!this.f7774d.d()) {
            h.a.a.c.a("LOGIC_MOTION", "MotionTracker", "requestActivityUpdatesHandler", "mGoogleApiClient NOT connected");
            return;
        }
        c.d.a.a.i.a.f3665d.a(this.f7774d, 500L, b()).a(this);
        h.a.a.c.a("LOGIC_MOTION", "MotionTracker", "requestActivityUpdatesHandler", "MotionTracker service STARTED");
    }

    public void a(boolean z, BroadcastReceiver broadcastReceiver) {
        this.f7773c = z;
        if (broadcastReceiver == null) {
            broadcastReceiver = new a(this);
        }
        a();
        this.f7774d.a();
        a.b.g.b.d.a(App.getInstance()).a(broadcastReceiver, new IntentFilter(Constants.BROADCAST_ACTION));
    }

    public void e() {
        MotionTrackerService.a();
    }

    public void f() {
        this.f7773c = true;
        e();
        d();
    }

    public void g() {
        e();
        c();
    }

    @Override // c.d.a.a.e.e.d.b
    public void onConnected(Bundle bundle) {
        h.a.a.c.a("LOGIC_MOTION", "MotionTracker", "onConnected", "Connected to GoogleApiClient");
        if (this.f7773c) {
            d();
        }
    }

    @Override // c.d.a.a.e.e.d.c
    public void onConnectionFailed(c.d.a.a.e.a aVar) {
        h.a.a.c.a("LOGIC_MOTION", "MotionTracker", "onConnectionFailed", "Connection to GoogleApiClient failed: ConnectionResult.getErrorCode() = " + aVar.b());
    }

    @Override // c.d.a.a.e.e.d.b
    public void onConnectionSuspended(int i2) {
        h.a.a.c.a("LOGIC_MOTION", "MotionTracker", "onConnectionSuspended", "Connection suspended");
        this.f7774d.a();
    }

    private synchronized void a() {
        if (this.f7774d == null) {
            d.a aVar = new d.a(App.getInstance());
            aVar.a((d.b) this);
            aVar.a((d.c) this);
            aVar.a(c.d.a.a.i.a.f3664c);
            this.f7774d = aVar.a();
        }
    }

    @Override // c.d.a.a.e.e.h
    /* renamed from: a */
    public void onResult(Status status) {
        if (status.e()) {
            h.a.a.c.a("LOGIC_MOTION", "MotionTracker", "onResult", "Success adding or removing activity detection: " + status.c());
            return;
        }
        h.a.a.c.a("LOGIC_MOTION", "MotionTracker", "onResult", "Error adding or removing activity detection: " + status.c());
    }
}
