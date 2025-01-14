package a.b.h.a;
/* compiled from: TwilightCalculator.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: d  reason: collision with root package name */
    public static k f1339d;

    /* renamed from: a  reason: collision with root package name */
    public long f1340a;

    /* renamed from: b  reason: collision with root package name */
    public long f1341b;

    /* renamed from: c  reason: collision with root package name */
    public int f1342c;

    public static k a() {
        if (f1339d == null) {
            f1339d = new k();
        }
        return f1339d;
    }

    public void a(long j, double d2, double d3) {
        float f2;
        float f3;
        double d4;
        double d5 = (0.01720197f * (((float) (j - 946728000000L)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(d5) * 0.03341960161924362d) + d5 + (Math.sin(2.0f * f3) * 3.4906598739326E-4d) + (Math.sin(f3 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double round = ((float) Math.round((f2 - 9.0E-4f) - d4)) + 9.0E-4f + ((-d3) / 360.0d) + (Math.sin(d5) * 0.0053d) + (Math.sin(2.0d * sin) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d6 = 0.01745329238474369d * d2;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d6) * Math.sin(asin))) / (Math.cos(d6) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f1342c = 1;
            this.f1340a = -1L;
            this.f1341b = -1L;
        } else if (sin2 <= -1.0d) {
            this.f1342c = 0;
            this.f1340a = -1L;
            this.f1341b = -1L;
        } else {
            double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
            this.f1340a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            this.f1341b = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            if (this.f1341b < j && this.f1340a > j) {
                this.f1342c = 0;
            } else {
                this.f1342c = 1;
            }
        }
    }
}
