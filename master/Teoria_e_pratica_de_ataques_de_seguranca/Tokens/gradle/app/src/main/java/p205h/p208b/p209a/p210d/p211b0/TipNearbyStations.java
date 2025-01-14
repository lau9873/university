package p205h.p208b.p209a.p210d.p211b0;

import java.util.ArrayList;
import java.util.List;
import p205h.p208b.p209a.p210d.AsyncResult;
import p205h.p208b.p209a.p210d.NearbyStation;

/* renamed from: h.b.a.d.b0.f */
/* loaded from: classes.dex */
public class TipNearbyStations extends AsyncResult<List<NearbyStation>> {

    /* renamed from: b */
    public final List<NearbyStation> f9561b = new ArrayList();

    @Override // p205h.p208b.p209a.p210d.AsyncResult
    /* renamed from: b */
    public boolean mo1333b() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(TipNearbyStations.class.getSimpleName());
        for (NearbyStation nearbyStation : this.f9561b) {
            sb.append('\n');
            sb.append(nearbyStation);
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override // p205h.p208b.p209a.p210d.AsyncResult
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public List<NearbyStation> mo1334a() {
        return this.f9561b;
    }
}
