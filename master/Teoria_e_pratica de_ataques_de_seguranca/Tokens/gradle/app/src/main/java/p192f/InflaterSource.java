package p192f;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: f.j */
/* loaded from: classes.dex */
public final class InflaterSource implements Source {

    /* renamed from: a */
    public final BufferedSource f8465a;

    /* renamed from: b */
    public final Inflater f8466b;

    /* renamed from: c */
    public int f8467c;

    /* renamed from: d */
    public boolean f8468d;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.f8465a = bufferedSource;
            this.f8466b = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    @Override // p192f.Source
    /* renamed from: a */
    public long mo673a(Buffer buffer, long j) {
        Segment m2618b;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (this.f8468d) {
                throw new IllegalStateException("closed");
            }
            if (i == 0) {
                return 0L;
            }
            while (true) {
                boolean m2589i = m2589i();
                try {
                    m2618b = buffer.m2618b(1);
                    int inflate = this.f8466b.inflate(m2618b.f8482a, m2618b.f8484c, 8192 - m2618b.f8484c);
                    if (inflate > 0) {
                        m2618b.f8484c += inflate;
                        long j2 = inflate;
                        buffer.f8450b += j2;
                        return j2;
                    } else if (this.f8466b.finished() || this.f8466b.needsDictionary()) {
                        break;
                    } else if (m2589i) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            m2588j();
            if (m2618b.f8483b == m2618b.f8484c) {
                buffer.f8449a = m2618b.m2548b();
                SegmentPool.m2546a(m2618b);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // p192f.Source
    /* renamed from: b */
    public Timeout mo2528b() {
        return this.f8465a.mo2528b();
    }

    @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f8468d) {
            return;
        }
        this.f8466b.end();
        this.f8468d = true;
        this.f8465a.close();
    }

    /* renamed from: i */
    public boolean m2589i() {
        if (this.f8466b.needsInput()) {
            m2588j();
            if (this.f8466b.getRemaining() == 0) {
                if (this.f8465a.mo2557e()) {
                    return true;
                }
                Segment segment = this.f8465a.mo2569a().f8449a;
                int i = segment.f8484c;
                int i2 = segment.f8483b;
                this.f8467c = i - i2;
                this.f8466b.setInput(segment.f8482a, i2, this.f8467c);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    /* renamed from: j */
    public final void m2588j() {
        int i = this.f8467c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f8466b.getRemaining();
        this.f8467c -= remaining;
        this.f8465a.skip(remaining);
    }
}
