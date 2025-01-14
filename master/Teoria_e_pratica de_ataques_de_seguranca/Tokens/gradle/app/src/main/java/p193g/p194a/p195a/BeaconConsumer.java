package p193g.p194a.p195a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* renamed from: g.a.a.d */
/* loaded from: classes.dex */
public interface BeaconConsumer {
    boolean bindService(Intent intent, ServiceConnection serviceConnection, int i);

    Context getApplicationContext();

    void onBeaconServiceConnect();

    void unbindService(ServiceConnection serviceConnection);
}
