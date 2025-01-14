package org.altbeacon.beacon.startup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import org.altbeacon.beacon.BeaconManager;
import p193g.p194a.p195a.p198m.LogManager;
import p193g.p194a.p195a.p199n.ScanJobScheduler;

/* loaded from: classes.dex */
public class StartupBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogManager.m2432a("StartupBroadcastReceiver", "onReceive called in startup broadcast receiver", new Object[0]);
        int i = Build.VERSION.SDK_INT;
        if (i < 18) {
            LogManager.m2427d("StartupBroadcastReceiver", "Not starting up beacon service because we do not have API version 18 (Android 4.3).  We have: %s", Integer.valueOf(i));
            return;
        }
        BeaconManager m477a = BeaconManager.m477a(context.getApplicationContext());
        if (!m477a.m437v() && !m477a.m438u()) {
            LogManager.m2432a("StartupBroadcastReceiver", "No consumers are bound.  Ignoring broadcast receiver.", new Object[0]);
            return;
        }
        int intExtra = intent.getIntExtra("android.bluetooth.le.extra.CALLBACK_TYPE", -1);
        if (intExtra != -1) {
            LogManager.m2432a("StartupBroadcastReceiver", "Passive background scan callback type: " + intExtra, new Object[0]);
            LogManager.m2432a("StartupBroadcastReceiver", "got Android O background scan via intent", new Object[0]);
            int intExtra2 = intent.getIntExtra("android.bluetooth.le.extra.ERROR_CODE", -1);
            if (intExtra2 != -1) {
                LogManager.m2427d("StartupBroadcastReceiver", "Passive background scan failed.  Code; " + intExtra2, new Object[0]);
            }
            ScanJobScheduler.m2319b().m2322a(context, intent.getParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT"));
        } else if (intent.getBooleanExtra("wakeup", false)) {
            LogManager.m2432a("StartupBroadcastReceiver", "got wake up intent", new Object[0]);
        } else {
            LogManager.m2432a("StartupBroadcastReceiver", "Already started.  Ignoring intent: %s of type: %s", intent, intent.getStringExtra("wakeup"));
        }
    }
}
