package p136d.p137a.p138a.p139a.p140m.p142b;

/* renamed from: d.a.a.a.m.b.l */
/* loaded from: classes.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: a */
    public final int f6457a;

    DeliveryMechanism(int i) {
        this.f6457a = i;
    }

    /* renamed from: a */
    public static DeliveryMechanism m4065a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }

    /* renamed from: b */
    public int m4064b() {
        return this.f6457a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f6457a);
    }
}
