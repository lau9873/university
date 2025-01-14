package com.spirtech.android.hce.calypso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import c.g.a.a.a.b;
import c.g.c.a.a.a;
/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            if (extras != null && Integer.valueOf(extras.getInt("id_alarm")).intValue() == 1) {
                b.a(context, true);
            }
        } catch (Exception e2) {
            a.a("onReceive", AlarmReceiver.class, e2);
        }
    }
}
