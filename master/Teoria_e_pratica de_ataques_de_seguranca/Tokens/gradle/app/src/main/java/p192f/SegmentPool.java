package p192f;

/* renamed from: f.o */
/* loaded from: classes.dex */
public final class SegmentPool {

    /* renamed from: a */
    public static Segment f8489a;

    /* renamed from: b */
    public static long f8490b;

    /* renamed from: a */
    public static Segment m2547a() {
        synchronized (SegmentPool.class) {
            if (f8489a != null) {
                Segment segment = f8489a;
                f8489a = segment.f8487f;
                segment.f8487f = null;
                f8490b -= 8192;
                return segment;
            }
            return new Segment();
        }
    }

    /* renamed from: a */
    public static void m2546a(Segment segment) {
        if (segment.f8487f == null && segment.f8488g == null) {
            if (segment.f8485d) {
                return;
            }
            synchronized (SegmentPool.class) {
                if (f8490b + 8192 > 65536) {
                    return;
                }
                f8490b += 8192;
                segment.f8487f = f8489a;
                segment.f8484c = 0;
                segment.f8483b = 0;
                f8489a = segment;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
