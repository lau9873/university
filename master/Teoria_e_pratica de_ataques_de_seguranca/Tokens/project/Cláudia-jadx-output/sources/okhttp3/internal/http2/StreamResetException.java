package okhttp3.internal.http2;

import e.i0.i.a;
import java.io.IOException;
/* loaded from: classes.dex */
public final class StreamResetException extends IOException {

    /* renamed from: a  reason: collision with root package name */
    public final a f7593a;

    public StreamResetException(a aVar) {
        super("stream was reset: " + aVar);
        this.f7593a = aVar;
    }
}
