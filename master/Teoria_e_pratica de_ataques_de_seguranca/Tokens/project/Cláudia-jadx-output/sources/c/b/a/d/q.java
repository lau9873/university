package c.b.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: DevicePowerStateListener.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: f  reason: collision with root package name */
    public static final IntentFilter f3122f = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: g  reason: collision with root package name */
    public static final IntentFilter f3123g = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");

    /* renamed from: h  reason: collision with root package name */
    public static final IntentFilter f3124h = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f3125a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f3126b;

    /* renamed from: c  reason: collision with root package name */
    public final BroadcastReceiver f3127c;

    /* renamed from: d  reason: collision with root package name */
    public final BroadcastReceiver f3128d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3129e;

    /* compiled from: DevicePowerStateListener.java */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            q.this.f3129e = true;
        }
    }

    /* compiled from: DevicePowerStateListener.java */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            q.this.f3129e = false;
        }
    }

    public q(Context context) {
        this.f3126b = context;
        Intent registerReceiver = context.registerReceiver(null, f3122f);
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("status", -1) : -1;
        this.f3129e = intExtra == 2 || intExtra == 5;
        this.f3128d = new a();
        this.f3127c = new b();
        context.registerReceiver(this.f3128d, f3123g);
        context.registerReceiver(this.f3127c, f3124h);
        this.f3125a = new AtomicBoolean(true);
    }

    public boolean b() {
        return this.f3129e;
    }

    public void a() {
        if (this.f3125a.getAndSet(false)) {
            this.f3126b.unregisterReceiver(this.f3128d);
            this.f3126b.unregisterReceiver(this.f3127c);
        }
    }
}
