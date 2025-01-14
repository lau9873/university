package org.altbeacon.beacon;

import android.app.IntentService;
import android.content.Intent;
import g.a.a.g;
/* loaded from: classes.dex */
public class BeaconIntentProcessor extends IntentService {
    public BeaconIntentProcessor() {
        super("BeaconIntentProcessor");
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        new g().a(getApplicationContext(), intent);
    }
}
