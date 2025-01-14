package p205h.p208b.p209a.p210d.p211b0;

import java.util.ArrayList;
import java.util.List;
import p205h.p208b.p209a.p210d.Line;
import p205h.p208b.p209a.p210d.NearbyStation;
import p205h.p208b.p209a.p210d.Operator;
import p205h.p208b.p209a.p210d.Stop;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.d.b0.e */
/* loaded from: classes.dex */
public class TipNearbyStation extends TipStop implements NearbyStation {

    /* renamed from: c */
    public final List<TipLine> f9560c;

    public TipNearbyStation(DataModels.StopInfo stopInfo) {
        super(stopInfo);
        int i = stopInfo.getLineName().length() > 0 ? 1 : 0;
        this.f9560c = new ArrayList(i);
        if (i != 0) {
            this.f9560c.add(new TipLine(stopInfo));
        }
    }

    /* renamed from: a */
    public void m1368a(DataModels.StopInfo stopInfo) {
        if (stopInfo.getLineName().length() > 0) {
            this.f9560c.add(new TipLine(stopInfo));
        }
    }

    /* renamed from: b */
    public void m1367b(List<DataModels.StopInfo> list) {
        int i = 0;
        while (i < this.f9560c.size()) {
            for (DataModels.StopInfo stopInfo : list) {
                if (this.f9560c.get(i).equals(stopInfo)) {
                    this.f9560c.remove(i);
                    i--;
                    if (i < 0) {
                        break;
                    }
                }
            }
            i++;
        }
    }

    @Override // p205h.p208b.p209a.p210d.NearbyStation
    /* renamed from: d */
    public Stop mo1304d() {
        return this;
    }

    @Override // p205h.p208b.p209a.p210d.NearbyStation
    /* renamed from: f */
    public boolean mo1303f() {
        return this.f9560c.size() > 0;
    }

    @Override // p205h.p208b.p209a.p210d.NearbyStation
    /* renamed from: g */
    public List<Line> mo1302g() {
        return new ArrayList(this.f9560c);
    }

    /* renamed from: i */
    public boolean m1366i() {
        return this.f9560c.isEmpty();
    }

    @Override // p205h.p208b.p209a.p210d.p211b0.TipStop
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        for (TipLine tipLine : this.f9560c) {
            sb.append("\n    ");
            sb.append(tipLine);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public boolean m1369a(List<DataModels.StopInfo> list) {
        for (DataModels.StopInfo stopInfo : list) {
            for (TipLine tipLine : this.f9560c) {
                if (tipLine.equals(stopInfo)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p205h.p208b.p209a.p210d.NearbyStation
    /* renamed from: b */
    public Operator mo1305b() {
        return TipOperators.m1365a(this.f9665a.getOperatorRef());
    }
}
