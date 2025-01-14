package pt.opt.anda;

import p070c.p074b.p075a.Crashlytics;
import p136d.p137a.p138a.p139a.Fabric;
import pt.card4b.backendbeacons.App;

/* loaded from: classes.dex */
public class AndaApplication extends App {
    @Override // pt.card4b.backendbeacons.App, android.app.Application
    public void onCreate() {
        super.onCreate();
        Fabric.m4214a(this, new Crashlytics());
    }
}
