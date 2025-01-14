package p136d.p137a.p138a.p139a.p140m.p142b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: d.a.a.a.m.b.q */
/* loaded from: classes.dex */
public class QueueFile implements Closeable {

    /* renamed from: g */
    public static final Logger f6489g = Logger.getLogger(QueueFile.class.getName());

    /* renamed from: a */
    public final RandomAccessFile f6490a;

    /* renamed from: b */
    public int f6491b;

    /* renamed from: c */
    public int f6492c;

    /* renamed from: d */
    public C1500b f6493d;

    /* renamed from: e */
    public C1500b f6494e;

    /* renamed from: f */
    public final byte[] f6495f = new byte[16];

    /* compiled from: QueueFile.java */
    /* renamed from: d.a.a.a.m.b.q$a */
    /* loaded from: classes.dex */
    public class C1499a implements InterfaceC1502d {

        /* renamed from: a */
        public boolean f6496a = true;

        /* renamed from: b */
        public final /* synthetic */ StringBuilder f6497b;

        public C1499a(QueueFile queueFile, StringBuilder sb) {
            this.f6497b = sb;
        }

        @Override // p136d.p137a.p138a.p139a.p140m.p142b.QueueFile.InterfaceC1502d
        /* renamed from: a */
        public void mo4009a(InputStream inputStream, int i) {
            if (this.f6496a) {
                this.f6496a = false;
            } else {
                this.f6497b.append(", ");
            }
            this.f6497b.append(i);
        }
    }

    /* compiled from: QueueFile.java */
    /* renamed from: d.a.a.a.m.b.q$b */
    /* loaded from: classes.dex */
    public static class C1500b {

        /* renamed from: c */
        public static final C1500b f6498c = new C1500b(0, 0);

        /* renamed from: a */
        public final int f6499a;

        /* renamed from: b */
        public final int f6500b;

        public C1500b(int i, int i2) {
            this.f6499a = i;
            this.f6500b = i2;
        }

        public String toString() {
            return C1500b.class.getSimpleName() + "[position = " + this.f6499a + ", length = " + this.f6500b + "]";
        }
    }

    /* compiled from: QueueFile.java */
    /* renamed from: d.a.a.a.m.b.q$c */
    /* loaded from: classes.dex */
    public final class C1501c extends InputStream {

        /* renamed from: a */
        public int f6501a;

        /* renamed from: b */
        public int f6502b;

        public /* synthetic */ C1501c(QueueFile queueFile, C1500b c1500b, C1499a c1499a) {
            this(c1500b);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            QueueFile.m4019b(bArr, "buffer");
            if ((i | i2) >= 0 && i2 <= bArr.length - i) {
                int i3 = this.f6502b;
                if (i3 > 0) {
                    if (i2 > i3) {
                        i2 = i3;
                    }
                    QueueFile.this.m4033a(this.f6501a, bArr, i, i2);
                    this.f6501a = QueueFile.this.m4016d(this.f6501a + i2);
                    this.f6502b -= i2;
                    return i2;
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        public C1501c(C1500b c1500b) {
            this.f6501a = QueueFile.this.m4016d(c1500b.f6499a + 4);
            this.f6502b = c1500b.f6500b;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f6502b == 0) {
                return -1;
            }
            QueueFile.this.f6490a.seek(this.f6501a);
            int read = QueueFile.this.f6490a.read();
            this.f6501a = QueueFile.this.m4016d(this.f6501a + 1);
            this.f6502b--;
            return read;
        }
    }

    /* compiled from: QueueFile.java */
    /* renamed from: d.a.a.a.m.b.q$d */
    /* loaded from: classes.dex */
    public interface InterfaceC1502d {
        /* renamed from: a */
        void mo4009a(InputStream inputStream, int i);
    }

    public QueueFile(File file) {
        if (!file.exists()) {
            m4028a(file);
        }
        this.f6490a = m4020b(file);
        m4013l();
    }

    /* renamed from: b */
    public static void m4018b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: c */
    public final void m4017c(int i) {
        this.f6490a.setLength(i);
        this.f6490a.getChannel().force(true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f6490a.close();
    }

    /* renamed from: d */
    public final int m4016d(int i) {
        int i2 = this.f6491b;
        return i < i2 ? i : (i + 16) - i2;
    }

    /* renamed from: j */
    public synchronized void m4015j() {
        m4034a(4096, 0, 0, 0);
        this.f6492c = 0;
        this.f6493d = C1500b.f6498c;
        this.f6494e = C1500b.f6498c;
        if (this.f6491b > 4096) {
            m4017c(4096);
        }
        this.f6491b = 4096;
    }

    /* renamed from: k */
    public synchronized boolean m4014k() {
        return this.f6492c == 0;
    }

    /* renamed from: l */
    public final void m4013l() {
        this.f6490a.seek(0L);
        this.f6490a.readFully(this.f6495f);
        this.f6491b = m4025a(this.f6495f, 0);
        if (this.f6491b <= this.f6490a.length()) {
            this.f6492c = m4025a(this.f6495f, 4);
            int m4025a = m4025a(this.f6495f, 8);
            int m4025a2 = m4025a(this.f6495f, 12);
            this.f6493d = m4022b(m4025a);
            this.f6494e = m4022b(m4025a2);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f6491b + ", Actual length: " + this.f6490a.length());
    }

    /* renamed from: m */
    public final int m4012m() {
        return this.f6491b - m4010o();
    }

    /* renamed from: n */
    public synchronized void m4011n() {
        if (!m4014k()) {
            if (this.f6492c == 1) {
                m4015j();
            } else {
                int m4016d = m4016d(this.f6493d.f6499a + 4 + this.f6493d.f6500b);
                m4033a(m4016d, this.f6495f, 0, 4);
                int m4025a = m4025a(this.f6495f, 0);
                m4034a(this.f6491b, this.f6492c - 1, m4016d, this.f6494e.f6499a);
                this.f6492c--;
                this.f6493d = new C1500b(m4016d, m4025a);
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    /* renamed from: o */
    public int m4010o() {
        if (this.f6492c == 0) {
            return 16;
        }
        C1500b c1500b = this.f6494e;
        int i = c1500b.f6499a;
        int i2 = this.f6493d.f6499a;
        if (i >= i2) {
            return (i - i2) + 4 + c1500b.f6500b + 16;
        }
        return (((i + 4) + c1500b.f6500b) + this.f6491b) - i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(QueueFile.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f6491b);
        sb.append(", size=");
        sb.append(this.f6492c);
        sb.append(", first=");
        sb.append(this.f6493d);
        sb.append(", last=");
        sb.append(this.f6494e);
        sb.append(", element lengths=[");
        try {
            m4032a(new C1499a(this, sb));
        } catch (IOException e) {
            f6489g.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    /* renamed from: a */
    public static void m4023a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            m4018b(bArr, i, i2);
            i += 4;
        }
    }

    /* renamed from: b */
    public final C1500b m4022b(int i) {
        if (i == 0) {
            return C1500b.f6498c;
        }
        this.f6490a.seek(i);
        return new C1500b(i, this.f6490a.readInt());
    }

    /* renamed from: a */
    public static int m4025a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    /* renamed from: b */
    public static RandomAccessFile m4020b(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    /* renamed from: a */
    public final void m4034a(int i, int i2, int i3, int i4) {
        m4023a(this.f6495f, i, i2, i3, i4);
        this.f6490a.seek(0L);
        this.f6490a.write(this.f6495f);
    }

    /* renamed from: b */
    public final void m4021b(int i, byte[] bArr, int i2, int i3) {
        int m4016d = m4016d(i);
        int i4 = m4016d + i3;
        int i5 = this.f6491b;
        if (i4 <= i5) {
            this.f6490a.seek(m4016d);
            this.f6490a.write(bArr, i2, i3);
            return;
        }
        int i6 = i5 - m4016d;
        this.f6490a.seek(m4016d);
        this.f6490a.write(bArr, i2, i6);
        this.f6490a.seek(16L);
        this.f6490a.write(bArr, i2 + i6, i3 - i6);
    }

    /* renamed from: a */
    public static void m4028a(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile m4020b = m4020b(file2);
        try {
            m4020b.setLength(4096L);
            m4020b.seek(0L);
            byte[] bArr = new byte[16];
            m4023a(bArr, 4096, 0, 0, 0);
            m4020b.write(bArr);
            m4020b.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            m4020b.close();
            throw th;
        }
    }

    /* renamed from: b */
    public static <T> T m4019b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public final void m4033a(int i, byte[] bArr, int i2, int i3) {
        int m4016d = m4016d(i);
        int i4 = m4016d + i3;
        int i5 = this.f6491b;
        if (i4 <= i5) {
            this.f6490a.seek(m4016d);
            this.f6490a.readFully(bArr, i2, i3);
            return;
        }
        int i6 = i5 - m4016d;
        this.f6490a.seek(m4016d);
        this.f6490a.readFully(bArr, i2, i6);
        this.f6490a.seek(16L);
        this.f6490a.readFully(bArr, i2 + i6, i3 - i6);
    }

    /* renamed from: a */
    public void m4026a(byte[] bArr) {
        m4024a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public synchronized void m4024a(byte[] bArr, int i, int i2) {
        m4019b(bArr, "buffer");
        if ((i | i2) >= 0 && i2 <= bArr.length - i) {
            m4036a(i2);
            boolean m4014k = m4014k();
            C1500b c1500b = new C1500b(m4014k ? 16 : m4016d(this.f6494e.f6499a + 4 + this.f6494e.f6500b), i2);
            m4018b(this.f6495f, 0, i2);
            m4021b(c1500b.f6499a, this.f6495f, 0, 4);
            m4021b(c1500b.f6499a + 4, bArr, i, i2);
            m4034a(this.f6491b, this.f6492c + 1, m4014k ? c1500b.f6499a : this.f6493d.f6499a, c1500b.f6499a);
            this.f6494e = c1500b;
            this.f6492c++;
            if (m4014k) {
                this.f6493d = this.f6494e;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /* renamed from: a */
    public final void m4036a(int i) {
        int i2 = i + 4;
        int m4012m = m4012m();
        if (m4012m >= i2) {
            return;
        }
        int i3 = this.f6491b;
        do {
            m4012m += i3;
            i3 <<= 1;
        } while (m4012m < i2);
        m4017c(i3);
        C1500b c1500b = this.f6494e;
        int m4016d = m4016d(c1500b.f6499a + 4 + c1500b.f6500b);
        if (m4016d < this.f6493d.f6499a) {
            FileChannel channel = this.f6490a.getChannel();
            channel.position(this.f6491b);
            long j = m4016d - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i4 = this.f6494e.f6499a;
        int i5 = this.f6493d.f6499a;
        if (i4 < i5) {
            int i6 = (this.f6491b + i4) - 16;
            m4034a(i3, this.f6492c, i5, i6);
            this.f6494e = new C1500b(i6, this.f6494e.f6500b);
        } else {
            m4034a(i3, this.f6492c, i5, i4);
        }
        this.f6491b = i3;
    }

    /* renamed from: a */
    public synchronized void m4032a(InterfaceC1502d interfaceC1502d) {
        int i = this.f6493d.f6499a;
        for (int i2 = 0; i2 < this.f6492c; i2++) {
            C1500b m4022b = m4022b(i);
            interfaceC1502d.mo4009a(new C1501c(this, m4022b, null), m4022b.f6500b);
            i = m4016d(m4022b.f6499a + 4 + m4022b.f6500b);
        }
    }

    /* renamed from: a */
    public boolean m4035a(int i, int i2) {
        return (m4010o() + 4) + i <= i2;
    }
}
