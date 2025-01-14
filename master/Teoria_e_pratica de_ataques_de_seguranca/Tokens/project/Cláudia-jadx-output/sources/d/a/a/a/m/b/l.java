package d.a.a.a.m.b;
/* compiled from: DeliveryMechanism.java */
/* loaded from: classes.dex */
public enum l {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f4262a;

    l(int i2) {
        this.f4262a = i2;
    }

    public static l a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }

    public int b() {
        return this.f4262a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f4262a);
    }
}
