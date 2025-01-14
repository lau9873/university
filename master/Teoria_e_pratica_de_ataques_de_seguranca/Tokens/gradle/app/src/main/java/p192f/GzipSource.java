package p192f;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: f.i */
/* loaded from: classes.dex */
public final class GzipSource implements Source {

    /* renamed from: b */
    public final BufferedSource f8461b;

    /* renamed from: c */
    public final Inflater f8462c;

    /* renamed from: d */
    public final InflaterSource f8463d;

    /* renamed from: a */
    public int f8460a = 0;

    /* renamed from: e */
    public final CRC32 f8464e = new CRC32();

    public GzipSource(Source source) {
        if (source != null) {
            this.f8462c = new Inflater(true);
            this.f8461b = Okio.m2586a(source);
            this.f8463d = new InflaterSource(this.f8461b, this.f8462c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // p192f.Source
    /* renamed from: a */
    public long mo673a(Buffer buffer, long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (i == 0) {
            return 0L;
        } else {
            if (this.f8460a == 0) {
                m2591i();
                this.f8460a = 1;
            }
            if (this.f8460a == 1) {
                long j2 = buffer.f8450b;
                long mo673a = this.f8463d.mo673a(buffer, j);
                if (mo673a != -1) {
                    m2593a(buffer, j2, mo673a);
                    return mo673a;
                }
                this.f8460a = 2;
            }
            if (this.f8460a == 2) {
                m2590j();
                this.f8460a = 3;
                if (!this.f8461b.mo2557e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // p192f.Source
    /* renamed from: b */
    public Timeout mo2528b() {
        return this.f8461b.mo2528b();
    }

    @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8463d.close();
    }

    /* renamed from: i */
    public final void m2591i() {
        this.f8461b.mo2558d(10L);
        byte m2616g = this.f8461b.mo2569a().m2616g(3L);
        boolean z = ((m2616g >> 1) & 1) == 1;
        if (z) {
            m2593a(this.f8461b.mo2569a(), 0L, 10L);
        }
        m2592a("ID1ID2", 8075, this.f8461b.readShort());
        this.f8461b.skip(8L);
        if (((m2616g >> 2) & 1) == 1) {
            this.f8461b.mo2558d(2L);
            if (z) {
                m2593a(this.f8461b.mo2569a(), 0L, 2L);
            }
            long mo2555f = this.f8461b.mo2569a().mo2555f();
            this.f8461b.mo2558d(mo2555f);
            if (z) {
                m2593a(this.f8461b.mo2569a(), 0L, mo2555f);
            }
            this.f8461b.skip(mo2555f);
        }
        if (((m2616g >> 3) & 1) == 1) {
            long mo2568a = this.f8461b.mo2568a((byte) 0);
            if (mo2568a != -1) {
                if (z) {
                    m2593a(this.f8461b.mo2569a(), 0L, mo2568a + 1);
                }
                this.f8461b.skip(mo2568a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((m2616g >> 4) & 1) == 1) {
            long mo2568a2 = this.f8461b.mo2568a((byte) 0);
            if (mo2568a2 != -1) {
                if (z) {
                    m2593a(this.f8461b.mo2569a(), 0L, mo2568a2 + 1);
                }
                this.f8461b.skip(mo2568a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            m2592a("FHCRC", this.f8461b.mo2555f(), (short) this.f8464e.getValue());
            this.f8464e.reset();
        }
    }

    /* renamed from: j */
    public final void m2590j() {
        m2592a("CRC", this.f8461b.mo2559d(), (int) this.f8464e.getValue());
        m2592a("ISIZE", this.f8461b.mo2559d(), (int) this.f8462c.getBytesWritten());
    }

    /* renamed from: a */
    public final void m2593a(Buffer buffer, long j, long j2) {
        int i;
        Segment segment = buffer.f8449a;
        while (true) {
            int i2 = segment.f8484c;
            int i3 = segment.f8483b;
            if (j < i2 - i3) {
                break;
            }
            j -= i2 - i3;
            segment = segment.f8487f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(segment.f8484c - i, j2);
            this.f8464e.update(segment.f8482a, (int) (segment.f8483b + j), min);
            j2 -= min;
            segment = segment.f8487f;
            j = 0;
        }
    }

    /* renamed from: a */
    public final void m2592a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
