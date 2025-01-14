package com.spirtech.android.hce.calypso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import p070c.p115g.p116a.p117a.p118a.C1369b;
import p070c.p115g.p128c.p129a.p130a.C1423a;

/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            if (extras != null && Integer.valueOf(extras.getInt("id_alarm")).intValue() == 1) {
                C1369b.m4639a(context, true);
            }
        } catch (Exception e) {
            C1423a.m4477a("onReceive", AlarmReceiver.class, e);
        }
    }
}
