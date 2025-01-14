package org.altbeacon.beacon;

import android.app.IntentService;
import android.content.Intent;
import p193g.p194a.p195a.IntentHandler;

/* loaded from: classes.dex */
public class BeaconIntentProcessor extends IntentService {
    public BeaconIntentProcessor() {
        super("BeaconIntentProcessor");
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        new IntentHandler().m2473a(getApplicationContext(), intent);
    }
}
