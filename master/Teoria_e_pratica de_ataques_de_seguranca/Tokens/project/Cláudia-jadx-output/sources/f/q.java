package f;

import java.io.Closeable;
import java.io.Flushable;
/* compiled from: Sink.java */
/* loaded from: classes.dex */
public interface q extends Closeable, Flushable {
    s b();

    void b(c cVar, long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
