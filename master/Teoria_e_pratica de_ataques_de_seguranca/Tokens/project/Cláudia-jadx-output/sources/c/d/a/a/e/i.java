package c.d.a.a.e;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.d.a.a.e.f.c0;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class i implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3566a = false;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<IBinder> f3567b = new LinkedBlockingQueue();

    public final IBinder a(long j, TimeUnit timeUnit) {
        c0.b("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f3566a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f3566a = true;
        IBinder poll = this.f3567b.poll(10000L, timeUnit);
        if (poll != null) {
            return poll;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3567b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
