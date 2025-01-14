package com.spirtech.android.hce.calypso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p070c.p115g.p116a.p117a.p118a.C1369b;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* loaded from: classes.dex */
public class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1429f.m4444b(context.getApplicationContext()).m4441b("lastSuccessfulSync", System.currentTimeMillis());
        C1369b.m4639a(context, false);
    }
}
