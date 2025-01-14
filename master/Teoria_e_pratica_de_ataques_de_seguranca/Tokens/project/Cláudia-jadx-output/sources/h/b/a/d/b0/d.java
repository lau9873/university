package h.b.a.d.b0;

import h.b.a.d.k;
import h.b.a.d.p;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: TipLine.java */
/* loaded from: classes.dex */
public class d implements k {

    /* renamed from: a  reason: collision with root package name */
    public final DataModels.StopInfo f6928a;

    /* renamed from: b  reason: collision with root package name */
    public final p f6929b;

    public d(DataModels.StopInfo stopInfo) {
        this.f6928a = stopInfo;
        this.f6929b = g.a(stopInfo.getOperatorRef());
    }

    @Override // h.b.a.d.k
    public String a() {
        return this.f6928a.getLineName();
    }

    @Override // h.b.a.d.k
    public p b() {
        return this.f6929b;
    }

    @Override // h.b.a.d.k
    public String c() {
        if (this.f6929b == g.p) {
            return this.f6928a.getLineName().replace("Linha ", "");
        }
        return this.f6928a.getLineName();
    }

    @Override // h.b.a.d.k
    public DataModels.StageInfo d() {
        return null;
    }

    @Override // h.b.a.d.k
    public String e() {
        return this.f6928a.getOrientation();
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataModels.StopInfo) {
            return a(this.f6928a, (DataModels.StopInfo) obj);
        }
        if (this == obj) {
            return true;
        }
        return a(this.f6928a, ((d) obj).f6928a);
    }

    public String toString() {
        return d.class.getSimpleName() + " Code: \"" + c() + "\" Direction: \"" + e() + "\" StopInfo: " + this.f6928a + " " + this.f6928a.getStopCode() + " " + this.f6928a.getLineName() + " " + this.f6928a.getOrientation() + " " + this.f6928a.getOperatorName();
    }

    public static boolean a(DataModels.StopInfo stopInfo, DataModels.StopInfo stopInfo2) {
        if (stopInfo == stopInfo2) {
            return true;
        }
        return stopInfo.getKey().equals(stopInfo2.getKey());
    }
}
