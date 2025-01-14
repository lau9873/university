package p181e.p182i0.p187i;

/* renamed from: e.i0.i.a */
/* loaded from: classes.dex */
public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: a */
    public final int f8063a;

    ErrorCode(int i) {
        this.f8063a = i;
    }

    /* renamed from: a */
    public static ErrorCode m3034a(int i) {
        ErrorCode[] values;
        for (ErrorCode errorCode : values()) {
            if (errorCode.f8063a == i) {
                return errorCode;
            }
        }
        return null;
    }
}
