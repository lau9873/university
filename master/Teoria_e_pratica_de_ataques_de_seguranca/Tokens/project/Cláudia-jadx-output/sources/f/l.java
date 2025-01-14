package f;
/* compiled from: RealBufferedSink.java */
/* loaded from: classes.dex */
public final class l implements d {

    /* renamed from: a  reason: collision with root package name */
    public final c f6023a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final q f6024b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6025c;

    public l(q qVar) {
        if (qVar != null) {
            this.f6024b = qVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    @Override // f.d
    public c a() {
        return this.f6023a;
    }

    @Override // f.q
    public void b(c cVar, long j) {
        if (!this.f6025c) {
            this.f6023a.b(cVar, j);
            i();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.q, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f6025c) {
            return;
        }
        try {
            if (this.f6023a.f5999b > 0) {
                this.f6024b.b(this.f6023a, this.f6023a.f5999b);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f6024b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f6025c = true;
        if (th == null) {
            return;
        }
        t.a(th);
        throw null;
    }

    @Override // f.d
    public d e(long j) {
        if (!this.f6025c) {
            this.f6023a.e(j);
            i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d f(long j) {
        if (!this.f6025c) {
            this.f6023a.f(j);
            i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d, f.q, java.io.Flushable
    public void flush() {
        if (!this.f6025c) {
            c cVar = this.f6023a;
            long j = cVar.f5999b;
            if (j > 0) {
                this.f6024b.b(cVar, j);
            }
            this.f6024b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d i() {
        if (!this.f6025c) {
            long m = this.f6023a.m();
            if (m > 0) {
                this.f6024b.b(this.f6023a, m);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        return "buffer(" + this.f6024b + ")";
    }

    @Override // f.d
    public d write(byte[] bArr) {
        if (!this.f6025c) {
            this.f6023a.write(bArr);
            i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d writeByte(int i2) {
        if (!this.f6025c) {
            this.f6023a.writeByte(i2);
            i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d writeInt(int i2) {
        if (!this.f6025c) {
            this.f6023a.writeInt(i2);
            i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d writeShort(int i2) {
        if (!this.f6025c) {
            this.f6023a.writeShort(i2);
            i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d a(f fVar) {
        if (!this.f6025c) {
            this.f6023a.a(fVar);
            i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.q
    public s b() {
        return this.f6024b.b();
    }

    @Override // f.d
    public d write(byte[] bArr, int i2, int i3) {
        if (!this.f6025c) {
            this.f6023a.write(bArr, i2, i3);
            i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public d a(String str) {
        if (!this.f6025c) {
            this.f6023a.a(str);
            i();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // f.d
    public long a(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a2 = rVar.a(this.f6023a, 8192L);
            if (a2 == -1) {
                return j;
            }
            j += a2;
            i();
        }
    }
}
