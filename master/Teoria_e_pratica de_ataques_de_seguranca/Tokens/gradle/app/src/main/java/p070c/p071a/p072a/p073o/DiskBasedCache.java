package p070c.p071a.p072a.p073o;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p070c.p071a.p072a.Header;
import p070c.p071a.p072a.InterfaceC0779a;
import p070c.p071a.p072a.VolleyLog;

/* renamed from: c.a.a.o.e */
/* loaded from: classes.dex */
public class DiskBasedCache implements InterfaceC0779a {

    /* renamed from: a */
    public final Map<String, C0794a> f4618a;

    /* renamed from: b */
    public long f4619b;

    /* renamed from: c */
    public final File f4620c;

    /* renamed from: d */
    public final int f4621d;

    public DiskBasedCache(File file, int i) {
        this.f4618a = new LinkedHashMap(16, 0.75f, true);
        this.f4619b = 0L;
        this.f4620c = file;
        this.f4621d = i;
    }

    @Override // p070c.p071a.p072a.InterfaceC0779a
    /* renamed from: a */
    public synchronized InterfaceC0779a.C0780a mo6142a(String str) {
        C0794a c0794a = this.f4618a.get(str);
        if (c0794a == null) {
            return null;
        }
        File m6135b = m6135b(str);
        try {
            C0795b c0795b = new C0795b(new BufferedInputStream(m6147a(m6135b)), m6135b.length());
            try {
                C0794a m6129a = C0794a.m6129a(c0795b);
                if (!TextUtils.equals(str, m6129a.f4623b)) {
                    VolleyLog.m6168b("%s: key=%s, found=%s", m6135b.getAbsolutePath(), str, m6129a.f4623b);
                    m6131e(str);
                    return null;
                }
                return c0794a.m6127a(m6148a(c0795b, c0795b.m6126j()));
            } finally {
                c0795b.close();
            }
        } catch (IOException e) {
            VolleyLog.m6168b("%s: %s", m6135b.getAbsolutePath(), e.toString());
            m6132d(str);
            return null;
        }
    }

    /* renamed from: b */
    public File m6135b(String str) {
        return new File(this.f4620c, m6133c(str));
    }

    /* renamed from: c */
    public final String m6133c(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    /* renamed from: d */
    public synchronized void m6132d(String str) {
        boolean delete = m6135b(str).delete();
        m6131e(str);
        if (!delete) {
            VolleyLog.m6168b("Could not delete cache entry for key=%s, filename=%s", str, m6133c(str));
        }
    }

    /* renamed from: e */
    public final void m6131e(String str) {
        C0794a remove = this.f4618a.remove(str);
        if (remove != null) {
            this.f4619b -= remove.f4622a;
        }
    }

    /* compiled from: DiskBasedCache.java */
    /* renamed from: c.a.a.o.e$a */
    /* loaded from: classes.dex */
    public static class C0794a {

        /* renamed from: a */
        public long f4622a;

        /* renamed from: b */
        public final String f4623b;

        /* renamed from: c */
        public final String f4624c;

        /* renamed from: d */
        public final long f4625d;

        /* renamed from: e */
        public final long f4626e;

        /* renamed from: f */
        public final long f4627f;

        /* renamed from: g */
        public final long f4628g;

        /* renamed from: h */
        public final List<Header> f4629h;

        public C0794a(String str, String str2, long j, long j2, long j3, long j4, List<Header> list) {
            this.f4623b = str;
            this.f4624c = "".equals(str2) ? null : str2;
            this.f4625d = j;
            this.f4626e = j2;
            this.f4627f = j3;
            this.f4628g = j4;
            this.f4629h = list;
        }

        /* renamed from: a */
        public static List<Header> m6130a(InterfaceC0779a.C0780a c0780a) {
            List<Header> list = c0780a.f4531h;
            return list != null ? list : HttpHeaderParser.m6116a(c0780a.f4530g);
        }

        /* renamed from: a */
        public static C0794a m6129a(C0795b c0795b) {
            if (DiskBasedCache.m6136b((InputStream) c0795b) == 538247942) {
                return new C0794a(DiskBasedCache.m6138b(c0795b), DiskBasedCache.m6138b(c0795b), DiskBasedCache.m6134c(c0795b), DiskBasedCache.m6134c(c0795b), DiskBasedCache.m6134c(c0795b), DiskBasedCache.m6134c(c0795b), DiskBasedCache.m6149a(c0795b));
            }
            throw new IOException();
        }

        public C0794a(String str, InterfaceC0779a.C0780a c0780a) {
            this(str, c0780a.f4525b, c0780a.f4526c, c0780a.f4527d, c0780a.f4528e, c0780a.f4529f, m6130a(c0780a));
            this.f4622a = c0780a.f4524a.length;
        }

        /* renamed from: a */
        public InterfaceC0779a.C0780a m6127a(byte[] bArr) {
            InterfaceC0779a.C0780a c0780a = new InterfaceC0779a.C0780a();
            c0780a.f4524a = bArr;
            c0780a.f4525b = this.f4624c;
            c0780a.f4526c = this.f4625d;
            c0780a.f4527d = this.f4626e;
            c0780a.f4528e = this.f4627f;
            c0780a.f4529f = this.f4628g;
            c0780a.f4530g = HttpHeaderParser.m6117a(this.f4629h);
            c0780a.f4531h = Collections.unmodifiableList(this.f4629h);
            return c0780a;
        }

        /* renamed from: a */
        public boolean m6128a(OutputStream outputStream) {
            try {
                DiskBasedCache.m6145a(outputStream, 538247942);
                DiskBasedCache.m6143a(outputStream, this.f4623b);
                DiskBasedCache.m6143a(outputStream, this.f4624c == null ? "" : this.f4624c);
                DiskBasedCache.m6144a(outputStream, this.f4625d);
                DiskBasedCache.m6144a(outputStream, this.f4626e);
                DiskBasedCache.m6144a(outputStream, this.f4627f);
                DiskBasedCache.m6144a(outputStream, this.f4628g);
                DiskBasedCache.m6139a(this.f4629h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                VolleyLog.m6168b("%s", e.toString());
                return false;
            }
        }
    }

    /* compiled from: DiskBasedCache.java */
    /* renamed from: c.a.a.o.e$b */
    /* loaded from: classes.dex */
    public static class C0795b extends FilterInputStream {

        /* renamed from: a */
        public final long f4630a;

        /* renamed from: b */
        public long f4631b;

        public C0795b(InputStream inputStream, long j) {
            super(inputStream);
            this.f4630a = j;
        }

        /* renamed from: j */
        public long m6126j() {
            return this.f4630a - this.f4631b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f4631b++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f4631b += read;
            }
            return read;
        }
    }

    /* renamed from: b */
    public OutputStream m6137b(File file) {
        return new FileOutputStream(file);
    }

    /* renamed from: b */
    public static int m6136b(InputStream inputStream) {
        return (m6146a(inputStream) << 24) | (m6146a(inputStream) << 0) | 0 | (m6146a(inputStream) << 8) | (m6146a(inputStream) << 16);
    }

    /* renamed from: c */
    public static long m6134c(InputStream inputStream) {
        return ((m6146a(inputStream) & 255) << 0) | 0 | ((m6146a(inputStream) & 255) << 8) | ((m6146a(inputStream) & 255) << 16) | ((m6146a(inputStream) & 255) << 24) | ((m6146a(inputStream) & 255) << 32) | ((m6146a(inputStream) & 255) << 40) | ((m6146a(inputStream) & 255) << 48) | ((255 & m6146a(inputStream)) << 56);
    }

    public DiskBasedCache(File file) {
        this(file, 5242880);
    }

    /* renamed from: b */
    public static String m6138b(C0795b c0795b) {
        return new String(m6148a(c0795b, m6134c(c0795b)), "UTF-8");
    }

    @Override // p070c.p071a.p072a.InterfaceC0779a
    /* renamed from: a */
    public synchronized void mo6151a() {
        if (!this.f4620c.exists()) {
            if (!this.f4620c.mkdirs()) {
                VolleyLog.m6167c("Unable to create cache dir %s", this.f4620c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f4620c.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            try {
                long length = file.length();
                C0795b c0795b = new C0795b(new BufferedInputStream(m6147a(file)), length);
                try {
                    C0794a m6129a = C0794a.m6129a(c0795b);
                    m6129a.f4622a = length;
                    m6140a(m6129a.f4623b, m6129a);
                    c0795b.close();
                } catch (Throwable th) {
                    c0795b.close();
                    throw th;
                    break;
                }
            } catch (IOException unused) {
                file.delete();
            }
        }
    }

    @Override // p070c.p071a.p072a.InterfaceC0779a
    /* renamed from: a */
    public synchronized void mo6141a(String str, InterfaceC0779a.C0780a c0780a) {
        m6150a(c0780a.f4524a.length);
        File m6135b = m6135b(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(m6137b(m6135b));
            C0794a c0794a = new C0794a(str, c0780a);
            if (c0794a.m6128a(bufferedOutputStream)) {
                bufferedOutputStream.write(c0780a.f4524a);
                bufferedOutputStream.close();
                m6140a(str, c0794a);
            } else {
                bufferedOutputStream.close();
                VolleyLog.m6168b("Failed to write header for %s", m6135b.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException unused) {
            if (m6135b.delete()) {
                return;
            }
            VolleyLog.m6168b("Could not clean up file %s", m6135b.getAbsolutePath());
        }
    }

    /* renamed from: a */
    public final void m6150a(int i) {
        long j;
        long j2 = i;
        if (this.f4619b + j2 < this.f4621d) {
            return;
        }
        if (VolleyLog.f4601b) {
            VolleyLog.m6166d("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.f4619b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, C0794a>> it = this.f4618a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C0794a value = it.next().getValue();
            if (m6135b(value.f4623b).delete()) {
                j = j2;
                this.f4619b -= value.f4622a;
            } else {
                j = j2;
                String str = value.f4623b;
                VolleyLog.m6168b("Could not delete cache entry for key=%s, filename=%s", str, m6133c(str));
            }
            it.remove();
            i2++;
            if (((float) (this.f4619b + j)) < this.f4621d * 0.9f) {
                break;
            }
            j2 = j;
        }
        if (VolleyLog.f4601b) {
            VolleyLog.m6166d("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f4619b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    /* renamed from: a */
    public final void m6140a(String str, C0794a c0794a) {
        if (!this.f4618a.containsKey(str)) {
            this.f4619b += c0794a.f4622a;
        } else {
            this.f4619b += c0794a.f4622a - this.f4618a.get(str).f4622a;
        }
        this.f4618a.put(str, c0794a);
    }

    /* renamed from: a */
    public static byte[] m6148a(C0795b c0795b, long j) {
        long m6126j = c0795b.m6126j();
        if (j >= 0 && j <= m6126j) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(c0795b).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + m6126j);
    }

    /* renamed from: a */
    public InputStream m6147a(File file) {
        return new FileInputStream(file);
    }

    /* renamed from: a */
    public static int m6146a(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public static void m6145a(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    /* renamed from: a */
    public static void m6144a(OutputStream outputStream, long j) {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    /* renamed from: a */
    public static void m6143a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m6144a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* renamed from: a */
    public static void m6139a(List<Header> list, OutputStream outputStream) {
        if (list != null) {
            m6145a(outputStream, list.size());
            for (Header header : list) {
                m6143a(outputStream, header.m6229a());
                m6143a(outputStream, header.m6228b());
            }
            return;
        }
        m6145a(outputStream, 0);
    }

    /* renamed from: a */
    public static List<Header> m6149a(C0795b c0795b) {
        int m6136b = m6136b((InputStream) c0795b);
        if (m6136b >= 0) {
            List<Header> emptyList = m6136b == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < m6136b; i++) {
                emptyList.add(new Header(m6138b(c0795b).intern(), m6138b(c0795b).intern()));
            }
            return emptyList;
        }
        throw new IOException("readHeaderList size=" + m6136b);
    }
}
