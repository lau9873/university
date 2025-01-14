package org.altbeacon.beacon.startup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import g.a.a.m.d;
import g.a.a.n.m;
import org.altbeacon.beacon.BeaconManager;
/* loaded from: classes.dex */
public class StartupBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d.a("StartupBroadcastReceiver", "onReceive called in startup broadcast receiver", new Object[0]);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 18) {
            d.d("StartupBroadcastReceiver", "Not starting up beacon service because we do not have API version 18 (Android 4.3).  We have: %s", Integer.valueOf(i2));
            return;
        }
        BeaconManager a2 = BeaconManager.a(context.getApplicationContext());
        if (!a2.v() && !a2.u()) {
            d.a("StartupBroadcastReceiver", "No consumers are bound.  Ignoring broadcast receiver.", new Object[0]);
            return;
        }
        int intExtra = intent.getIntExtra("android.bluetooth.le.extra.CALLBACK_TYPE", -1);
        if (intExtra != -1) {
            d.a("StartupBroadcastReceiver", "Passive background scan callback type: " + intExtra, new Object[0]);
            d.a("StartupBroadcastReceiver", "got Android O background scan via intent", new Object[0]);
            int intExtra2 = intent.getIntExtra("android.bluetooth.le.extra.ERROR_CODE", -1);
            if (intExtra2 != -1) {
                d.d("StartupBroadcastReceiver", "Passive background scan failed.  Code; " + intExtra2, new Object[0]);
            }
            m.b().a(context, intent.getParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT"));
        } else if (intent.getBooleanExtra("wakeup", false)) {
            d.a("StartupBroadcastReceiver", "got wake up intent", new Object[0]);
        } else {
            d.a("StartupBroadcastReceiver", "Already started.  Ignoring intent: %s of type: %s", intent, intent.getStringExtra("wakeup"));
        }
    }
}
