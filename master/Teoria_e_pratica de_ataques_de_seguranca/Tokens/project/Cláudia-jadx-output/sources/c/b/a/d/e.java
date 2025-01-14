package c.b.a.d;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: CodedOutputStream.java */
/* loaded from: classes.dex */
public final class e implements Flushable {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2990a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2991b;

    /* renamed from: c  reason: collision with root package name */
    public int f2992c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final OutputStream f2993d;

    /* compiled from: CodedOutputStream.java */
    /* loaded from: classes.dex */
    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public e(OutputStream outputStream, byte[] bArr) {
        this.f2993d = outputStream;
        this.f2990a = bArr;
        this.f2991b = bArr.length;
    }

    public static e a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static int b(float f2) {
        return 4;
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int c(long j) {
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

    public static int c(b bVar) {
        return j(bVar.b()) + bVar.b();
    }

    public static int e(int i2, int i3) {
        return l(i2) + h(i3);
    }

    public static int h(int i2) {
        return i(i2);
    }

    public static int i(int i2) {
        if (i2 >= 0) {
            return j(i2);
        }
        return 10;
    }

    public static int j(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int k(int i2) {
        return j(n(i2));
    }

    public static int l(int i2) {
        return j(n0.a(i2, 0));
    }

    public static int m(int i2) {
        return j(i2);
    }

    public static int n(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public void b(int i2, int i3) {
        c(i2, 0);
        f(i3);
    }

    public void d(int i2, int i3) {
        c(i2, 0);
        g(i3);
    }

    public void f(int i2) {
        e(n(i2));
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.f2993d != null) {
            c();
        }
    }

    public void g(int i2) {
        e(i2);
    }

    public static e a(OutputStream outputStream, int i2) {
        return new e(outputStream, new byte[i2]);
    }

    public static int f(int i2, int i3) {
        return l(i2) + k(i3);
    }

    public static int g(int i2, int i3) {
        return l(i2) + m(i3);
    }

    public void e(int i2) {
        while ((i2 & (-128)) != 0) {
            c((i2 & 127) | 128);
            i2 >>>= 7;
        }
        c(i2);
    }

    public static int d(long j) {
        return c(j);
    }

    public void a(int i2, float f2) {
        c(i2, 5);
        a(f2);
    }

    public void b(long j) {
        a(j);
    }

    public final void c() {
        OutputStream outputStream = this.f2993d;
        if (outputStream != null) {
            outputStream.write(this.f2990a, 0, this.f2992c);
            this.f2992c = 0;
            return;
        }
        throw new a();
    }

    public void b(int i2) {
        if (i2 >= 0) {
            e(i2);
        } else {
            a(i2);
        }
    }

    public void d(int i2) {
        c(i2 & 255);
        c((i2 >> 8) & 255);
        c((i2 >> 16) & 255);
        c((i2 >> 24) & 255);
    }

    public void a(int i2, long j) {
        c(i2, 0);
        b(j);
    }

    public static int b(int i2, float f2) {
        return l(i2) + b(f2);
    }

    public static int b(int i2, long j) {
        return l(i2) + d(j);
    }

    public void a(int i2, boolean z) {
        c(i2, 0);
        a(z);
    }

    public void c(int i2) {
        a((byte) i2);
    }

    public static int b(int i2, boolean z) {
        return l(i2) + b(z);
    }

    public void c(int i2, int i3) {
        e(n0.a(i2, i3));
    }

    public static int b(int i2, b bVar) {
        return l(i2) + c(bVar);
    }

    public void a(int i2, b bVar) {
        c(i2, 2);
        a(bVar);
    }

    public void b(b bVar) {
        a(bVar, 0, bVar.b());
    }

    public void a(int i2, int i3) {
        c(i2, 0);
        a(i3);
    }

    public void a(float f2) {
        d(Float.floatToRawIntBits(f2));
    }

    public void a(boolean z) {
        c(z ? 1 : 0);
    }

    public void a(b bVar) {
        e(bVar.b());
        b(bVar);
    }

    public void a(int i2) {
        b(i2);
    }

    public void a(byte b2) {
        if (this.f2992c == this.f2991b) {
            c();
        }
        byte[] bArr = this.f2990a;
        int i2 = this.f2992c;
        this.f2992c = i2 + 1;
        bArr[i2] = b2;
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public void a(byte[] bArr, int i2, int i3) {
        int i4 = this.f2991b;
        int i5 = this.f2992c;
        if (i4 - i5 >= i3) {
            System.arraycopy(bArr, i2, this.f2990a, i5, i3);
            this.f2992c += i3;
            return;
        }
        int i6 = i4 - i5;
        System.arraycopy(bArr, i2, this.f2990a, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.f2992c = this.f2991b;
        c();
        if (i8 <= this.f2991b) {
            System.arraycopy(bArr, i7, this.f2990a, 0, i8);
            this.f2992c = i8;
            return;
        }
        this.f2993d.write(bArr, i7, i8);
    }

    public void a(b bVar, int i2, int i3) {
        int i4 = this.f2991b;
        int i5 = this.f2992c;
        if (i4 - i5 >= i3) {
            bVar.a(this.f2990a, i2, i5, i3);
            this.f2992c += i3;
            return;
        }
        int i6 = i4 - i5;
        bVar.a(this.f2990a, i2, i5, i6);
        int i7 = i2 + i6;
        int i8 = i3 - i6;
        this.f2992c = this.f2991b;
        c();
        if (i8 <= this.f2991b) {
            bVar.a(this.f2990a, i7, 0, i8);
            this.f2992c = i8;
            return;
        }
        InputStream a2 = bVar.a();
        long j = i7;
        if (j != a2.skip(j)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i8 > 0) {
            int min = Math.min(i8, this.f2991b);
            int read = a2.read(this.f2990a, 0, min);
            if (read == min) {
                this.f2993d.write(this.f2990a, 0, read);
                i8 -= read;
            } else {
                throw new IllegalStateException("Read failed.");
            }
        }
    }

    public void a(long j) {
        while (((-128) & j) != 0) {
            c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        c((int) j);
    }
}
