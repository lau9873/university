package p192f;

import java.io.Closeable;

/* renamed from: f.r */
/* loaded from: classes.dex */
public interface Source extends Closeable {
    /* renamed from: a */
    long mo673a(Buffer buffer, long j);

    /* renamed from: b */
    Timeout mo2528b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
