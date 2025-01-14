package e.i0.i;
/* compiled from: ErrorCode.java */
/* loaded from: classes.dex */
public enum a {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f5674a;

    a(int i2) {
        this.f5674a = i2;
    }

    public static a a(int i2) {
        a[] values;
        for (a aVar : values()) {
            if (aVar.f5674a == i2) {
                return aVar;
            }
        }
        return null;
    }
}
