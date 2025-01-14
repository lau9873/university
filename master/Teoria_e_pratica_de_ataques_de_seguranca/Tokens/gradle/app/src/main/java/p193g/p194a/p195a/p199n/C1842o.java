package p193g.p194a.p195a.p199n;

import android.content.Context;
import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.service.BeaconService;
import p193g.p194a.p195a.Beacon;
import p193g.p194a.p195a.Region;
import p193g.p194a.p195a.p198m.LogManager;

/* compiled from: SettingsData.java */
/* renamed from: g.a.a.n.o */
/* loaded from: classes.dex */
public class C1842o implements Serializable {

    /* renamed from: g */
    public static final String f8626g = C1842o.class.getSimpleName();

    /* renamed from: a */
    public ArrayList<BeaconParser> f8627a;

    /* renamed from: b */
    public Boolean f8628b;

    /* renamed from: c */
    public Boolean f8629c;

    /* renamed from: d */
    public Long f8630d;

    /* renamed from: e */
    public Boolean f8631e;

    /* renamed from: f */
    public Boolean f8632f;

    /* renamed from: a */
    public Bundle m2301a() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("SettingsData", this);
        return bundle;
    }

    /* renamed from: a */
    public static C1842o m2299a(Bundle bundle) {
        bundle.setClassLoader(Region.class.getClassLoader());
        if (bundle.get("SettingsData") != null) {
            return (C1842o) bundle.getSerializable("SettingsData");
        }
        return null;
    }

    /* renamed from: a */
    public void m2298a(BeaconService beaconService) {
        LogManager.m2432a(f8626g, "Applying settings changes to scanner in other process", new Object[0]);
        BeaconManager m477a = BeaconManager.m477a(beaconService);
        List<BeaconParser> m451h = m477a.m451h();
        boolean z = true;
        if (m451h.size() == this.f8627a.size()) {
            int i = 0;
            while (true) {
                if (i >= m451h.size()) {
                    z = false;
                    break;
                } else if (!m451h.get(i).equals(this.f8627a.get(i))) {
                    String str = f8626g;
                    LogManager.m2432a(str, "Beacon parsers have changed to: " + this.f8627a.get(i).m419d(), new Object[0]);
                    break;
                } else {
                    i++;
                }
            }
        } else {
            LogManager.m2432a(f8626g, "Beacon parsers have been added or removed.", new Object[0]);
        }
        if (z) {
            LogManager.m2432a(f8626g, "Updating beacon parsers", new Object[0]);
            m477a.m451h().clear();
            m477a.m451h().addAll(this.f8627a);
            beaconService.m406c();
        } else {
            LogManager.m2432a(f8626g, "Beacon parsers unchanged.", new Object[0]);
        }
        MonitoringStatus m2405a = MonitoringStatus.m2405a(beaconService);
        if (m2405a.m2396c() && !this.f8628b.booleanValue()) {
            m2405a.m2387j();
        } else if (!m2405a.m2396c() && this.f8628b.booleanValue()) {
            m2405a.m2388i();
        }
        BeaconManager.m456d(this.f8629c.booleanValue());
        BeaconManager.m454e(this.f8630d.longValue());
        RangeState.m2383a(this.f8631e.booleanValue());
        Beacon.m2507a(this.f8632f.booleanValue());
    }

    /* renamed from: a */
    public C1842o m2300a(Context context) {
        BeaconManager m477a = BeaconManager.m477a(context);
        this.f8627a = new ArrayList<>(m477a.m451h());
        this.f8628b = Boolean.valueOf(m477a.m433z());
        this.f8629c = Boolean.valueOf(BeaconManager.m481J());
        this.f8630d = Long.valueOf(BeaconManager.m483H());
        this.f8631e = Boolean.valueOf(RangeState.m2381c());
        this.f8632f = Boolean.valueOf(Beacon.m2489p());
        return this;
    }
}
