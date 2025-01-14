package p070c.p074b.p075a.p078d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: c.b.a.d.q */
/* loaded from: classes.dex */
public class DevicePowerStateListener {

    /* renamed from: f */
    public static final IntentFilter f4960f = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: g */
    public static final IntentFilter f4961g = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");

    /* renamed from: h */
    public static final IntentFilter f4962h = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");

    /* renamed from: a */
    public final AtomicBoolean f4963a;

    /* renamed from: b */
    public final Context f4964b;

    /* renamed from: c */
    public final BroadcastReceiver f4965c;

    /* renamed from: d */
    public final BroadcastReceiver f4966d;

    /* renamed from: e */
    public boolean f4967e;

    /* compiled from: DevicePowerStateListener.java */
    /* renamed from: c.b.a.d.q$a */
    /* loaded from: classes.dex */
    public class C0863a extends BroadcastReceiver {
        public C0863a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DevicePowerStateListener.this.f4967e = true;
        }
    }

    /* compiled from: DevicePowerStateListener.java */
    /* renamed from: c.b.a.d.q$b */
    /* loaded from: classes.dex */
    public class C0864b extends BroadcastReceiver {
        public C0864b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DevicePowerStateListener.this.f4967e = false;
        }
    }

    public DevicePowerStateListener(Context context) {
        this.f4964b = context;
        Intent registerReceiver = context.registerReceiver(null, f4960f);
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("status", -1) : -1;
        this.f4967e = intExtra == 2 || intExtra == 5;
        this.f4966d = new C0863a();
        this.f4965c = new C0864b();
        context.registerReceiver(this.f4966d, f4961g);
        context.registerReceiver(this.f4965c, f4962h);
        this.f4963a = new AtomicBoolean(true);
    }

    /* renamed from: b */
    public boolean m5740b() {
        return this.f4967e;
    }

    /* renamed from: a */
    public void m5742a() {
        if (this.f4963a.getAndSet(false)) {
            this.f4964b.unregisterReceiver(this.f4966d);
            this.f4964b.unregisterReceiver(this.f4965c);
        }
    }
}
