package f;
/* compiled from: SegmentPool.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static n f6037a;

    /* renamed from: b  reason: collision with root package name */
    public static long f6038b;

    public static n a() {
        synchronized (o.class) {
            if (f6037a != null) {
                n nVar = f6037a;
                f6037a = nVar.f6035f;
                nVar.f6035f = null;
                f6038b -= 8192;
                return nVar;
            }
            return new n();
        }
    }

    public static void a(n nVar) {
        if (nVar.f6035f == null && nVar.f6036g == null) {
            if (nVar.f6033d) {
                return;
            }
            synchronized (o.class) {
                if (f6038b + 8192 > 65536) {
                    return;
                }
                f6038b += 8192;
                nVar.f6035f = f6037a;
                nVar.f6032c = 0;
                nVar.f6031b = 0;
                f6037a = nVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
