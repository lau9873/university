package g.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
/* compiled from: BeaconConsumer.java */
/* loaded from: classes.dex */
public interface d {
    boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2);

    Context getApplicationContext();

    void onBeaconServiceConnect();

    void unbindService(ServiceConnection serviceConnection);
}
