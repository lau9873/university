package g.a.a.n;

import android.content.Context;
import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.service.BeaconService;
/* compiled from: SettingsData.java */
/* loaded from: classes.dex */
public class o implements Serializable {

    /* renamed from: g  reason: collision with root package name */
    public static final String f6159g = o.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<BeaconParser> f6160a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f6161b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f6162c;

    /* renamed from: d  reason: collision with root package name */
    public Long f6163d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f6164e;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f6165f;

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("SettingsData", this);
        return bundle;
    }

    public static o a(Bundle bundle) {
        bundle.setClassLoader(g.a.a.j.class.getClassLoader());
        if (bundle.get("SettingsData") != null) {
            return (o) bundle.getSerializable("SettingsData");
        }
        return null;
    }

    public void a(BeaconService beaconService) {
        g.a.a.m.d.a(f6159g, "Applying settings changes to scanner in other process", new Object[0]);
        BeaconManager a2 = BeaconManager.a(beaconService);
        List<BeaconParser> h2 = a2.h();
        boolean z = true;
        if (h2.size() == this.f6160a.size()) {
            int i2 = 0;
            while (true) {
                if (i2 >= h2.size()) {
                    z = false;
                    break;
                } else if (!h2.get(i2).equals(this.f6160a.get(i2))) {
                    String str = f6159g;
                    g.a.a.m.d.a(str, "Beacon parsers have changed to: " + this.f6160a.get(i2).d(), new Object[0]);
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            g.a.a.m.d.a(f6159g, "Beacon parsers have been added or removed.", new Object[0]);
        }
        if (z) {
            g.a.a.m.d.a(f6159g, "Updating beacon parsers", new Object[0]);
            a2.h().clear();
            a2.h().addAll(this.f6160a);
            beaconService.c();
        } else {
            g.a.a.m.d.a(f6159g, "Beacon parsers unchanged.", new Object[0]);
        }
        e a3 = e.a(beaconService);
        if (a3.c() && !this.f6161b.booleanValue()) {
            a3.j();
        } else if (!a3.c() && this.f6161b.booleanValue()) {
            a3.i();
        }
        BeaconManager.d(this.f6162c.booleanValue());
        BeaconManager.e(this.f6163d.longValue());
        f.a(this.f6164e.booleanValue());
        g.a.a.c.a(this.f6165f.booleanValue());
    }

    public o a(Context context) {
        BeaconManager a2 = BeaconManager.a(context);
        this.f6160a = new ArrayList<>(a2.h());
        this.f6161b = Boolean.valueOf(a2.z());
        this.f6162c = Boolean.valueOf(BeaconManager.J());
        this.f6163d = Long.valueOf(BeaconManager.H());
        this.f6164e = Boolean.valueOf(f.c());
        this.f6165f = Boolean.valueOf(g.a.a.c.p());
        return this;
    }
}
