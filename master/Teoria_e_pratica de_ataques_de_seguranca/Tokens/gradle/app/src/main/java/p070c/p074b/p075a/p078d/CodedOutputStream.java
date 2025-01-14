package p070c.p074b.p075a.p078d;

import com.j256.ormlite.logger.Logger;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: c.b.a.d.e */
/* loaded from: classes.dex */
public final class CodedOutputStream implements Flushable {

    /* renamed from: a */
    public final byte[] f4803a;

    /* renamed from: b */
    public final int f4804b;

    /* renamed from: c */
    public int f4805c = 0;

    /* renamed from: d */
    public final OutputStream f4806d;

    /* compiled from: CodedOutputStream.java */
    /* renamed from: c.b.a.d.e$a */
    /* loaded from: classes.dex */
    public static class C0816a extends IOException {
        public C0816a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f4806d = outputStream;
        this.f4803a = bArr;
        this.f4804b = bArr.length;
    }

    /* renamed from: a */
    public static CodedOutputStream m5945a(OutputStream outputStream) {
        return m5944a(outputStream, 4096);
    }

    /* renamed from: b */
    public static int m5940b(float f) {
        return 4;
    }

    /* renamed from: b */
    public static int m5931b(boolean z) {
        return 1;
    }

    /* renamed from: c */
    public static int m5927c(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: c */
    public static int m5926c(ByteString byteString) {
        return m5914j(byteString.m5970b()) + byteString.m5970b();
    }

    /* renamed from: e */
    public static int m5921e(int i, int i2) {
        return m5912l(i) + m5916h(i2);
    }

    /* renamed from: h */
    public static int m5916h(int i) {
        return m5915i(i);
    }

    /* renamed from: i */
    public static int m5915i(int i) {
        if (i >= 0) {
            return m5914j(i);
        }
        return 10;
    }

    /* renamed from: j */
    public static int m5914j(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    /* renamed from: k */
    public static int m5913k(int i) {
        return m5914j(m5910n(i));
    }

    /* renamed from: l */
    public static int m5912l(int i) {
        return m5914j(WireFormat.m5747a(i, 0));
    }

    /* renamed from: m */
    public static int m5911m(int i) {
        return m5914j(i);
    }

    /* renamed from: n */
    public static int m5910n(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: b */
    public void m5937b(int i, int i2) {
        m5928c(i, 0);
        m5920f(i2);
    }

    /* renamed from: d */
    public void m5924d(int i, int i2) {
        m5928c(i, 0);
        m5918g(i2);
    }

    /* renamed from: f */
    public void m5920f(int i) {
        m5922e(m5910n(i));
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.f4806d != null) {
            m5930c();
        }
    }

    /* renamed from: g */
    public void m5918g(int i) {
        m5922e(i);
    }

    /* renamed from: a */
    public static CodedOutputStream m5944a(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    /* renamed from: f */
    public static int m5919f(int i, int i2) {
        return m5912l(i) + m5913k(i2);
    }

    /* renamed from: g */
    public static int m5917g(int i, int i2) {
        return m5912l(i) + m5911m(i2);
    }

    /* renamed from: e */
    public void m5922e(int i) {
        while ((i & (-128)) != 0) {
            m5929c((i & 127) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
            i >>>= 7;
        }
        m5929c(i);
    }

    /* renamed from: d */
    public static int m5923d(long j) {
        return m5927c(j);
    }

    /* renamed from: a */
    public void m5953a(int i, float f) {
        m5928c(i, 5);
        m5955a(f);
    }

    /* renamed from: b */
    public void m5933b(long j) {
        m5948a(j);
    }

    /* renamed from: c */
    public final void m5930c() {
        OutputStream outputStream = this.f4806d;
        if (outputStream != null) {
            outputStream.write(this.f4803a, 0, this.f4805c);
            this.f4805c = 0;
            return;
        }
        throw new C0816a();
    }

    /* renamed from: b */
    public void m5939b(int i) {
        if (i >= 0) {
            m5922e(i);
        } else {
            m5948a(i);
        }
    }

    /* renamed from: d */
    public void m5925d(int i) {
        m5929c(i & 255);
        m5929c((i >> 8) & 255);
        m5929c((i >> 16) & 255);
        m5929c((i >> 24) & 255);
    }

    /* renamed from: a */
    public void m5951a(int i, long j) {
        m5928c(i, 0);
        m5933b(j);
    }

    /* renamed from: b */
    public static int m5938b(int i, float f) {
        return m5912l(i) + m5940b(f);
    }

    /* renamed from: b */
    public static int m5936b(int i, long j) {
        return m5912l(i) + m5923d(j);
    }

    /* renamed from: a */
    public void m5949a(int i, boolean z) {
        m5928c(i, 0);
        m5943a(z);
    }

    /* renamed from: c */
    public void m5929c(int i) {
        m5956a((byte) i);
    }

    /* renamed from: b */
    public static int m5934b(int i, boolean z) {
        return m5912l(i) + m5931b(z);
    }

    /* renamed from: c */
    public void m5928c(int i, int i2) {
        m5922e(WireFormat.m5747a(i, i2));
    }

    /* renamed from: b */
    public static int m5935b(int i, ByteString byteString) {
        return m5912l(i) + m5926c(byteString);
    }

    /* renamed from: a */
    public void m5950a(int i, ByteString byteString) {
        m5928c(i, 2);
        m5947a(byteString);
    }

    /* renamed from: b */
    public void m5932b(ByteString byteString) {
        m5946a(byteString, 0, byteString.m5970b());
    }

    /* renamed from: a */
    public void m5952a(int i, int i2) {
        m5928c(i, 0);
        m5954a(i2);
    }

    /* renamed from: a */
    public void m5955a(float f) {
        m5925d(Float.floatToRawIntBits(f));
    }

    /* renamed from: a */
    public void m5943a(boolean z) {
        m5929c(z ? 1 : 0);
    }

    /* renamed from: a */
    public void m5947a(ByteString byteString) {
        m5922e(byteString.m5970b());
        m5932b(byteString);
    }

    /* renamed from: a */
    public void m5954a(int i) {
        m5939b(i);
    }

    /* renamed from: a */
    public void m5956a(byte b) {
        if (this.f4805c == this.f4804b) {
            m5930c();
        }
        byte[] bArr = this.f4803a;
        int i = this.f4805c;
        this.f4805c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void m5942a(byte[] bArr) {
        m5941a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void m5941a(byte[] bArr, int i, int i2) {
        int i3 = this.f4804b;
        int i4 = this.f4805c;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f4803a, i4, i2);
            this.f4805c += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f4803a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f4805c = this.f4804b;
        m5930c();
        if (i7 <= this.f4804b) {
            System.arraycopy(bArr, i6, this.f4803a, 0, i7);
            this.f4805c = i7;
            return;
        }
        this.f4806d.write(bArr, i6, i7);
    }

    /* renamed from: a */
    public void m5946a(ByteString byteString, int i, int i2) {
        int i3 = this.f4804b;
        int i4 = this.f4805c;
        if (i3 - i4 >= i2) {
            byteString.m5971a(this.f4803a, i, i4, i2);
            this.f4805c += i2;
            return;
        }
        int i5 = i3 - i4;
        byteString.m5971a(this.f4803a, i, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f4805c = this.f4804b;
        m5930c();
        if (i7 <= this.f4804b) {
            byteString.m5971a(this.f4803a, i6, 0, i7);
            this.f4805c = i7;
            return;
        }
        InputStream m5974a = byteString.m5974a();
        long j = i6;
        if (j != m5974a.skip(j)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i7 > 0) {
            int min = Math.min(i7, this.f4804b);
            int read = m5974a.read(this.f4803a, 0, min);
            if (read == min) {
                this.f4806d.write(this.f4803a, 0, read);
                i7 -= read;
            } else {
                throw new IllegalStateException("Read failed.");
            }
        }
    }

    /* renamed from: a */
    public void m5948a(long j) {
        while (((-128) & j) != 0) {
            m5929c((((int) j) & 127) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
            j >>>= 7;
        }
        m5929c((int) j);
    }
}
