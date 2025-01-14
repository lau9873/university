package g.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
/* compiled from: BeaconLocalBroadcastProcessor.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static int f6055d;

    /* renamed from: a  reason: collision with root package name */
    public Context f6056a;

    /* renamed from: b  reason: collision with root package name */
    public int f6057b = 0;

    /* renamed from: c  reason: collision with root package name */
    public BroadcastReceiver f6058c = new a(this);

    /* compiled from: BeaconLocalBroadcastProcessor.java */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a(e eVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            new g().a(context, intent);
        }
    }

    public e(Context context) {
        this.f6056a = context;
    }

    public void a() {
        f6055d++;
        this.f6057b++;
        g.a.a.m.d.a("BeaconLocalBroadcastProcessor", "Register calls: global=" + f6055d + " instance=" + this.f6057b, new Object[0]);
        b();
        a.b.g.b.d.a(this.f6056a).a(this.f6058c, new IntentFilter("org.altbeacon.beacon.range_notification"));
        a.b.g.b.d.a(this.f6056a).a(this.f6058c, new IntentFilter("org.altbeacon.beacon.monitor_notification"));
    }

    public void b() {
        a.b.g.b.d.a(this.f6056a).a(this.f6058c);
    }
}
