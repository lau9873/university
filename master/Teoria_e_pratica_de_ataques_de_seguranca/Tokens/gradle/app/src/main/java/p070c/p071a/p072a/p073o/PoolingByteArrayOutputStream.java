package p070c.p071a.p072a.p073o;

import java.io.ByteArrayOutputStream;

/* renamed from: c.a.a.o.m */
/* loaded from: classes.dex */
public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {

    /* renamed from: a */
    public final ByteArrayPool f4644a;

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool, int i) {
        this.f4644a = byteArrayPool;
        ((ByteArrayOutputStream) this).buf = this.f4644a.m6154a(Math.max(i, 256));
    }

    /* renamed from: a */
    public final void m6091a(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] m6154a = this.f4644a.m6154a((i2 + i) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, m6154a, 0, ((ByteArrayOutputStream) this).count);
        this.f4644a.m6153a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = m6154a;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4644a.m6153a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f4644a.m6153a(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        m6091a(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        m6091a(1);
        super.write(i);
    }
}
