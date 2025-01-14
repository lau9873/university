package h.b.a.d.b0;

import h.b.a.d.k;
import h.b.a.d.m;
import h.b.a.d.p;
import h.b.a.d.v;
import java.util.ArrayList;
import java.util.List;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: TipNearbyStation.java */
/* loaded from: classes.dex */
public class e extends j implements m {

    /* renamed from: c  reason: collision with root package name */
    public final List<d> f6930c;

    public e(DataModels.StopInfo stopInfo) {
        super(stopInfo);
        int i2 = stopInfo.getLineName().length() > 0 ? 1 : 0;
        this.f6930c = new ArrayList(i2);
        if (i2 != 0) {
            this.f6930c.add(new d(stopInfo));
        }
    }

    public void a(DataModels.StopInfo stopInfo) {
        if (stopInfo.getLineName().length() > 0) {
            this.f6930c.add(new d(stopInfo));
        }
    }

    public void b(List<DataModels.StopInfo> list) {
        int i2 = 0;
        while (i2 < this.f6930c.size()) {
            for (DataModels.StopInfo stopInfo : list) {
                if (this.f6930c.get(i2).equals(stopInfo)) {
                    this.f6930c.remove(i2);
                    i2--;
                    if (i2 < 0) {
                        break;
                    }
                }
            }
            i2++;
        }
    }

    @Override // h.b.a.d.m
    public v d() {
        return this;
    }

    @Override // h.b.a.d.m
    public boolean f() {
        return this.f6930c.size() > 0;
    }

    @Override // h.b.a.d.m
    public List<k> g() {
        return new ArrayList(this.f6930c);
    }

    public boolean i() {
        return this.f6930c.isEmpty();
    }

    @Override // h.b.a.d.b0.j
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        for (d dVar : this.f6930c) {
            sb.append("\n    ");
            sb.append(dVar);
        }
        return sb.toString();
    }

    public boolean a(List<DataModels.StopInfo> list) {
        for (DataModels.StopInfo stopInfo : list) {
            for (d dVar : this.f6930c) {
                if (dVar.equals(stopInfo)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // h.b.a.d.m
    public p b() {
        return g.a(this.f7024a.getOperatorRef());
    }
}
