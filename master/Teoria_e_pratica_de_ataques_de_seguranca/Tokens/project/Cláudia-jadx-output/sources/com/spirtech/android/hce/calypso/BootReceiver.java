package com.spirtech.android.hce.calypso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import c.g.a.a.a.b;
import c.g.c.a.a.f;
/* loaded from: classes.dex */
public class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f.b(context.getApplicationContext()).b("lastSuccessfulSync", System.currentTimeMillis());
        b.a(context, false);
    }
}
