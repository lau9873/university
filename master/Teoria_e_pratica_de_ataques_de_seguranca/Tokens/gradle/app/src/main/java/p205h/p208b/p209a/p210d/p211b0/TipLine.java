package p205h.p208b.p209a.p210d.p211b0;

import p205h.p208b.p209a.p210d.Line;
import p205h.p208b.p209a.p210d.Operator;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.d.b0.d */
/* loaded from: classes.dex */
public class TipLine implements Line {

    /* renamed from: a */
    public final DataModels.StopInfo f9558a;

    /* renamed from: b */
    public final Operator f9559b;

    public TipLine(DataModels.StopInfo stopInfo) {
        this.f9558a = stopInfo;
        this.f9559b = TipOperators.m1365a(stopInfo.getOperatorRef());
    }

    @Override // p205h.p208b.p209a.p210d.Line
    /* renamed from: a */
    public String mo1313a() {
        return this.f9558a.getLineName();
    }

    @Override // p205h.p208b.p209a.p210d.Line
    /* renamed from: b */
    public Operator mo1312b() {
        return this.f9559b;
    }

    @Override // p205h.p208b.p209a.p210d.Line
    /* renamed from: c */
    public String mo1311c() {
        if (this.f9559b == TipOperators.f9577p) {
            return this.f9558a.getLineName().replace("Linha ", "");
        }
        return this.f9558a.getLineName();
    }

    @Override // p205h.p208b.p209a.p210d.Line
    /* renamed from: d */
    public DataModels.StageInfo mo1310d() {
        return null;
    }

    @Override // p205h.p208b.p209a.p210d.Line
    /* renamed from: e */
    public String mo1309e() {
        return this.f9558a.getOrientation();
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataModels.StopInfo) {
            return m1370a(this.f9558a, (DataModels.StopInfo) obj);
        }
        if (this == obj) {
            return true;
        }
        return m1370a(this.f9558a, ((TipLine) obj).f9558a);
    }

    public String toString() {
        return TipLine.class.getSimpleName() + " Code: \"" + mo1311c() + "\" Direction: \"" + mo1309e() + "\" StopInfo: " + this.f9558a + " " + this.f9558a.getStopCode() + " " + this.f9558a.getLineName() + " " + this.f9558a.getOrientation() + " " + this.f9558a.getOperatorName();
    }

    /* renamed from: a */
    public static boolean m1370a(DataModels.StopInfo stopInfo, DataModels.StopInfo stopInfo2) {
        if (stopInfo == stopInfo2) {
            return true;
        }
        return stopInfo.getKey().equals(stopInfo2.getKey());
    }
}
