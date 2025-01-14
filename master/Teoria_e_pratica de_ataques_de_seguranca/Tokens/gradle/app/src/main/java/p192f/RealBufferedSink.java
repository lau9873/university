package p192f;

/* renamed from: f.l */
/* loaded from: classes.dex */
public final class RealBufferedSink implements BufferedSink {

    /* renamed from: a */
    public final Buffer f8475a = new Buffer();

    /* renamed from: b */
    public final Sink f8476b;

    /* renamed from: c */
    public boolean f8477c;

    public RealBufferedSink(Sink sink) {
        if (sink != null) {
            this.f8476b = sink;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // p192f.BufferedSink
    /* renamed from: a */
    public Buffer mo2569a() {
        return this.f8475a;
    }

    @Override // p192f.Sink
    /* renamed from: b */
    public void mo2529b(Buffer buffer, long j) {
        if (!this.f8477c) {
            this.f8475a.mo2529b(buffer, j);
            mo2570i();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p192f.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f8477c) {
            return;
        }
        try {
            if (this.f8475a.f8450b > 0) {
                this.f8476b.mo2529b(this.f8475a, this.f8475a.f8450b);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f8476b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f8477c = true;
        if (th == null) {
            return;
        }
        C1828t.m2517a(th);
        throw null;
    }

    @Override // p192f.BufferedSink
    /* renamed from: e */
    public BufferedSink mo2572e(long j) {
        if (!this.f8477c) {
            this.f8475a.mo2572e(j);
            mo2570i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p192f.BufferedSink
    /* renamed from: f */
    public BufferedSink mo2571f(long j) {
        if (!this.f8477c) {
            this.f8475a.mo2571f(j);
            mo2570i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p192f.BufferedSink, p192f.Sink, java.io.Flushable
    public void flush() {
        if (!this.f8477c) {
            Buffer buffer = this.f8475a;
            long j = buffer.f8450b;
            if (j > 0) {
                this.f8476b.mo2529b(buffer, j);
            }
            this.f8476b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p192f.BufferedSink
    /* renamed from: i */
    public BufferedSink mo2570i() {
        if (!this.f8477c) {
            long m2611m = this.f8475a.m2611m();
            if (m2611m > 0) {
                this.f8476b.mo2529b(this.f8475a, m2611m);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        return "buffer(" + this.f8476b + ")";
    }

    @Override // p192f.BufferedSink
    public BufferedSink write(byte[] bArr) {
        if (!this.f8477c) {
            this.f8475a.write(bArr);
            mo2570i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p192f.BufferedSink
    public BufferedSink writeByte(int i) {
        if (!this.f8477c) {
            this.f8475a.writeByte(i);
            mo2570i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p192f.BufferedSink
    public BufferedSink writeInt(int i) {
        if (!this.f8477c) {
            this.f8475a.writeInt(i);
            mo2570i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p192f.BufferedSink
    public BufferedSink writeShort(int i) {
        if (!this.f8477c) {
            this.f8475a.writeShort(i);
            mo2570i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p192f.BufferedSink
    /* renamed from: a */
    public BufferedSink mo2575a(C1822f c1822f) {
        if (!this.f8477c) {
            this.f8475a.mo2575a(c1822f);
            mo2570i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p192f.Sink
    /* renamed from: b */
    public Timeout mo2530b() {
        return this.f8476b.mo2530b();
    }

    @Override // p192f.BufferedSink
    public BufferedSink write(byte[] bArr, int i, int i2) {
        if (!this.f8477c) {
            this.f8475a.write(bArr, i, i2);
            mo2570i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p192f.BufferedSink
    /* renamed from: a */
    public BufferedSink mo2573a(String str) {
        if (!this.f8477c) {
            this.f8475a.mo2573a(str);
            mo2570i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // p192f.BufferedSink
    /* renamed from: a */
    public long mo2574a(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long mo673a = source.mo673a(this.f8475a, 8192L);
            if (mo673a == -1) {
                return j;
            }
            j += mo673a;
            mo2570i();
        }
    }
}
