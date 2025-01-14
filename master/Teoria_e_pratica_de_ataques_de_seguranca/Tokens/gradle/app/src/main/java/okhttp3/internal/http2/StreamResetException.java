package okhttp3.internal.http2;

import java.io.IOException;
import p181e.p182i0.p187i.ErrorCode;

/* loaded from: classes.dex */
public final class StreamResetException extends IOException {

    /* renamed from: a */
    public final ErrorCode f10570a;

    public StreamResetException(ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        this.f10570a = errorCode;
    }
}
