package p070c.p084d.p085a.p086a.p093e;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.e.i */
/* loaded from: classes.dex */
public final class ServiceConnectionC1105i implements ServiceConnection {

    /* renamed from: a */
    public boolean f5499a = false;

    /* renamed from: b */
    public final BlockingQueue<IBinder> f5500b = new LinkedBlockingQueue();

    /* renamed from: a */
    public final IBinder m5126a(long j, TimeUnit timeUnit) {
        C1049c0.m5287b("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f5499a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f5499a = true;
        IBinder poll = this.f5500b.poll(10000L, timeUnit);
        if (poll != null) {
            return poll;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f5500b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
