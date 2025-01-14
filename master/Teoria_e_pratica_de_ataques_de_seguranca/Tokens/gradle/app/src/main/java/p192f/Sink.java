package p192f;

import java.io.Closeable;
import java.io.Flushable;

/* renamed from: f.q */
/* loaded from: classes.dex */
public interface Sink extends Closeable, Flushable {
    /* renamed from: b */
    Timeout mo2530b();

    /* renamed from: b */
    void mo2529b(Buffer buffer, long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
