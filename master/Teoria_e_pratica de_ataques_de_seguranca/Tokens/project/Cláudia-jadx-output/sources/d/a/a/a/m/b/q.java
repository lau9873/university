package d.a.a.a.m.b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: QueueFile.java */
/* loaded from: classes.dex */
public class q implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    public static final Logger f4290g = Logger.getLogger(q.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final RandomAccessFile f4291a;

    /* renamed from: b  reason: collision with root package name */
    public int f4292b;

    /* renamed from: c  reason: collision with root package name */
    public int f4293c;

    /* renamed from: d  reason: collision with root package name */
    public b f4294d;

    /* renamed from: e  reason: collision with root package name */
    public b f4295e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f4296f = new byte[16];

    /* compiled from: QueueFile.java */
    /* loaded from: classes.dex */
    public class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4297a = true;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f4298b;

        public a(q qVar, StringBuilder sb) {
            this.f4298b = sb;
        }

        @Override // d.a.a.a.m.b.q.d
        public void a(InputStream inputStream, int i2) {
            if (this.f4297a) {
                this.f4297a = false;
            } else {
                this.f4298b.append(", ");
            }
            this.f4298b.append(i2);
        }
    }

    /* compiled from: QueueFile.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: c  reason: collision with root package name */
        public static final b f4299c = new b(0, 0);

        /* renamed from: a  reason: collision with root package name */
        public final int f4300a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4301b;

        public b(int i2, int i3) {
            this.f4300a = i2;
            this.f4301b = i3;
        }

        public String toString() {
            return b.class.getSimpleName() + "[position = " + this.f4300a + ", length = " + this.f4301b + "]";
        }
    }

    /* compiled from: QueueFile.java */
    /* loaded from: classes.dex */
    public final class c extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        public int f4302a;

        /* renamed from: b  reason: collision with root package name */
        public int f4303b;

        public /* synthetic */ c(q qVar, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            q.b(bArr, "buffer");
            if ((i2 | i3) >= 0 && i3 <= bArr.length - i2) {
                int i4 = this.f4303b;
                if (i4 > 0) {
                    if (i3 > i4) {
                        i3 = i4;
                    }
                    q.this.a(this.f4302a, bArr, i2, i3);
                    this.f4302a = q.this.d(this.f4302a + i3);
                    this.f4303b -= i3;
                    return i3;
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        public c(b bVar) {
            this.f4302a = q.this.d(bVar.f4300a + 4);
            this.f4303b = bVar.f4301b;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f4303b == 0) {
                return -1;
            }
            q.this.f4291a.seek(this.f4302a);
            int read = q.this.f4291a.read();
            this.f4302a = q.this.d(this.f4302a + 1);
            this.f4303b--;
            return read;
        }
    }

    /* compiled from: QueueFile.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(InputStream inputStream, int i2);
    }

    public q(File file) {
        if (!file.exists()) {
            a(file);
        }
        this.f4291a = b(file);
        l();
    }

    public static void b(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >> 24);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    public final void c(int i2) {
        this.f4291a.setLength(i2);
        this.f4291a.getChannel().force(true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f4291a.close();
    }

    public final int d(int i2) {
        int i3 = this.f4292b;
        return i2 < i3 ? i2 : (i2 + 16) - i3;
    }

    public synchronized void j() {
        a(4096, 0, 0, 0);
        this.f4293c = 0;
        this.f4294d = b.f4299c;
        this.f4295e = b.f4299c;
        if (this.f4292b > 4096) {
            c(4096);
        }
        this.f4292b = 4096;
    }

    public synchronized boolean k() {
        return this.f4293c == 0;
    }

    public final void l() {
        this.f4291a.seek(0L);
        this.f4291a.readFully(this.f4296f);
        this.f4292b = a(this.f4296f, 0);
        if (this.f4292b <= this.f4291a.length()) {
            this.f4293c = a(this.f4296f, 4);
            int a2 = a(this.f4296f, 8);
            int a3 = a(this.f4296f, 12);
            this.f4294d = b(a2);
            this.f4295e = b(a3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f4292b + ", Actual length: " + this.f4291a.length());
    }

    public final int m() {
        return this.f4292b - o();
    }

    public synchronized void n() {
        if (!k()) {
            if (this.f4293c == 1) {
                j();
            } else {
                int d2 = d(this.f4294d.f4300a + 4 + this.f4294d.f4301b);
                a(d2, this.f4296f, 0, 4);
                int a2 = a(this.f4296f, 0);
                a(this.f4292b, this.f4293c - 1, d2, this.f4295e.f4300a);
                this.f4293c--;
                this.f4294d = new b(d2, a2);
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    public int o() {
        if (this.f4293c == 0) {
            return 16;
        }
        b bVar = this.f4295e;
        int i2 = bVar.f4300a;
        int i3 = this.f4294d.f4300a;
        if (i2 >= i3) {
            return (i2 - i3) + 4 + bVar.f4301b + 16;
        }
        return (((i2 + 4) + bVar.f4301b) + this.f4292b) - i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(q.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f4292b);
        sb.append(", size=");
        sb.append(this.f4293c);
        sb.append(", first=");
        sb.append(this.f4294d);
        sb.append(", last=");
        sb.append(this.f4295e);
        sb.append(", element lengths=[");
        try {
            a(new a(this, sb));
        } catch (IOException e2) {
            f4290g.log(Level.WARNING, "read error", (Throwable) e2);
        }
        sb.append("]]");
        return sb.toString();
    }

    public static void a(byte[] bArr, int... iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            b(bArr, i2, i3);
            i2 += 4;
        }
    }

    public final b b(int i2) {
        if (i2 == 0) {
            return b.f4299c;
        }
        this.f4291a.seek(i2);
        return new b(i2, this.f4291a.readInt());
    }

    public static int a(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i2 + 3] & 255);
    }

    public static RandomAccessFile b(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    public final void a(int i2, int i3, int i4, int i5) {
        a(this.f4296f, i2, i3, i4, i5);
        this.f4291a.seek(0L);
        this.f4291a.write(this.f4296f);
    }

    public final void b(int i2, byte[] bArr, int i3, int i4) {
        int d2 = d(i2);
        int i5 = d2 + i4;
        int i6 = this.f4292b;
        if (i5 <= i6) {
            this.f4291a.seek(d2);
            this.f4291a.write(bArr, i3, i4);
            return;
        }
        int i7 = i6 - d2;
        this.f4291a.seek(d2);
        this.f4291a.write(bArr, i3, i7);
        this.f4291a.seek(16L);
        this.f4291a.write(bArr, i3 + i7, i4 - i7);
    }

    public static void a(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b2 = b(file2);
        try {
            b2.setLength(4096L);
            b2.seek(0L);
            byte[] bArr = new byte[16];
            a(bArr, 4096, 0, 0, 0);
            b2.write(bArr);
            b2.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public final void a(int i2, byte[] bArr, int i3, int i4) {
        int d2 = d(i2);
        int i5 = d2 + i4;
        int i6 = this.f4292b;
        if (i5 <= i6) {
            this.f4291a.seek(d2);
            this.f4291a.readFully(bArr, i3, i4);
            return;
        }
        int i7 = i6 - d2;
        this.f4291a.seek(d2);
        this.f4291a.readFully(bArr, i3, i7);
        this.f4291a.seek(16L);
        this.f4291a.readFully(bArr, i3 + i7, i4 - i7);
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public synchronized void a(byte[] bArr, int i2, int i3) {
        b(bArr, "buffer");
        if ((i2 | i3) >= 0 && i3 <= bArr.length - i2) {
            a(i3);
            boolean k = k();
            b bVar = new b(k ? 16 : d(this.f4295e.f4300a + 4 + this.f4295e.f4301b), i3);
            b(this.f4296f, 0, i3);
            b(bVar.f4300a, this.f4296f, 0, 4);
            b(bVar.f4300a + 4, bArr, i2, i3);
            a(this.f4292b, this.f4293c + 1, k ? bVar.f4300a : this.f4294d.f4300a, bVar.f4300a);
            this.f4295e = bVar;
            this.f4293c++;
            if (k) {
                this.f4294d = this.f4295e;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public final void a(int i2) {
        int i3 = i2 + 4;
        int m = m();
        if (m >= i3) {
            return;
        }
        int i4 = this.f4292b;
        do {
            m += i4;
            i4 <<= 1;
        } while (m < i3);
        c(i4);
        b bVar = this.f4295e;
        int d2 = d(bVar.f4300a + 4 + bVar.f4301b);
        if (d2 < this.f4294d.f4300a) {
            FileChannel channel = this.f4291a.getChannel();
            channel.position(this.f4292b);
            long j = d2 - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i5 = this.f4295e.f4300a;
        int i6 = this.f4294d.f4300a;
        if (i5 < i6) {
            int i7 = (this.f4292b + i5) - 16;
            a(i4, this.f4293c, i6, i7);
            this.f4295e = new b(i7, this.f4295e.f4301b);
        } else {
            a(i4, this.f4293c, i6, i5);
        }
        this.f4292b = i4;
    }

    public synchronized void a(d dVar) {
        int i2 = this.f4294d.f4300a;
        for (int i3 = 0; i3 < this.f4293c; i3++) {
            b b2 = b(i2);
            dVar.a(new c(this, b2, null), b2.f4301b);
            i2 = d(b2.f4300a + 4 + b2.f4301b);
        }
    }

    public boolean a(int i2, int i3) {
        return (o() + 4) + i2 <= i3;
    }
}
