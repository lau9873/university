package p193g.p194a.p195a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import p000a.p006b.p030g.p032b.LocalBroadcastManager;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.e */
/* loaded from: classes.dex */
public class BeaconLocalBroadcastProcessor {

    /* renamed from: d */
    public static int f8517d;

    /* renamed from: a */
    public Context f8518a;

    /* renamed from: b */
    public int f8519b = 0;

    /* renamed from: c */
    public BroadcastReceiver f8520c = new C1831a(this);

    /* compiled from: BeaconLocalBroadcastProcessor.java */
    /* renamed from: g.a.a.e$a */
    /* loaded from: classes.dex */
    public class C1831a extends BroadcastReceiver {
        public C1831a(BeaconLocalBroadcastProcessor beaconLocalBroadcastProcessor) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            new IntentHandler().m2473a(context, intent);
        }
    }

    public BeaconLocalBroadcastProcessor(Context context) {
        this.f8518a = context;
    }

    /* renamed from: a */
    public void m2488a() {
        f8517d++;
        this.f8519b++;
        LogManager.m2432a("BeaconLocalBroadcastProcessor", "Register calls: global=" + f8517d + " instance=" + this.f8519b, new Object[0]);
        m2487b();
        LocalBroadcastManager.m10011a(this.f8518a).m10012a(this.f8520c, new IntentFilter("org.altbeacon.beacon.range_notification"));
        LocalBroadcastManager.m10011a(this.f8518a).m10012a(this.f8520c, new IntentFilter("org.altbeacon.beacon.monitor_notification"));
    }

    /* renamed from: b */
    public void m2487b() {
        LocalBroadcastManager.m10011a(this.f8518a).m10013a(this.f8520c);
    }
}
