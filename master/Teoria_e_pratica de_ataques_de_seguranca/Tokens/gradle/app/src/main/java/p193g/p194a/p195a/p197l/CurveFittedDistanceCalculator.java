package p193g.p194a.p195a.p197l;

import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.a.l.b */
/* loaded from: classes.dex */
public class CurveFittedDistanceCalculator implements DistanceCalculator {

    /* renamed from: a */
    public double f8536a;

    /* renamed from: b */
    public double f8537b;

    /* renamed from: c */
    public double f8538c;

    public CurveFittedDistanceCalculator(double d, double d2, double d3) {
        this.f8536a = d;
        this.f8537b = d2;
        this.f8538c = d3;
    }

    @Override // p193g.p194a.p195a.p197l.DistanceCalculator
    /* renamed from: a */
    public double mo2456a(int i, double d) {
        double pow;
        if (d == 0.0d) {
            return -1.0d;
        }
        LogManager.m2432a("CurveFittedDistanceCalculator", "calculating distance based on mRssi of %s and txPower of %s", Double.valueOf(d), Integer.valueOf(i));
        double d2 = (d * 1.0d) / i;
        if (d2 < 1.0d) {
            pow = Math.pow(d2, 10.0d);
        } else {
            pow = (this.f8536a * Math.pow(d2, this.f8537b)) + this.f8538c;
        }
        LogManager.m2432a("CurveFittedDistanceCalculator", "avg mRssi: %s distance: %s", Double.valueOf(d), Double.valueOf(pow));
        return pow;
    }
}
