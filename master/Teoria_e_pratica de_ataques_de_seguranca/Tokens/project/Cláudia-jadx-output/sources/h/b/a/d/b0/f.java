package h.b.a.d.b0;

import h.b.a.d.m;
import java.util.ArrayList;
import java.util.List;
/* compiled from: TipNearbyStations.java */
/* loaded from: classes.dex */
public class f extends h.b.a.d.b<List<m>> {

    /* renamed from: b  reason: collision with root package name */
    public final List<m> f6931b = new ArrayList();

    @Override // h.b.a.d.b
    public boolean b() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(f.class.getSimpleName());
        for (m mVar : this.f6931b) {
            sb.append('\n');
            sb.append(mVar);
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override // h.b.a.d.b
    public List<m> a() {
        return this.f6931b;
    }
}
