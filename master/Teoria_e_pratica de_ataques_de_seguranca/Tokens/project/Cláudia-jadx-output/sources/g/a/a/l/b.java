package g.a.a.l;
/* compiled from: CurveFittedDistanceCalculator.java */
/* loaded from: classes.dex */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public double f6074a;

    /* renamed from: b  reason: collision with root package name */
    public double f6075b;

    /* renamed from: c  reason: collision with root package name */
    public double f6076c;

    public b(double d2, double d3, double d4) {
        this.f6074a = d2;
        this.f6075b = d3;
        this.f6076c = d4;
    }

    @Override // g.a.a.l.c
    public double a(int i2, double d2) {
        double pow;
        if (d2 == 0.0d) {
            return -1.0d;
        }
        g.a.a.m.d.a("CurveFittedDistanceCalculator", "calculating distance based on mRssi of %s and txPower of %s", Double.valueOf(d2), Integer.valueOf(i2));
        double d3 = (d2 * 1.0d) / i2;
        if (d3 < 1.0d) {
            pow = Math.pow(d3, 10.0d);
        } else {
            pow = (this.f6074a * Math.pow(d3, this.f6075b)) + this.f6076c;
        }
        g.a.a.m.d.a("CurveFittedDistanceCalculator", "avg mRssi: %s distance: %s", Double.valueOf(d2), Double.valueOf(pow));
        return pow;
    }
}
