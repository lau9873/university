package c.a.a.o;

import android.os.SystemClock;
import android.text.TextUtils;
import c.a.a.a;
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
/* compiled from: DiskBasedCache.java */
/* loaded from: classes.dex */
public class e implements c.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f2821a;

    /* renamed from: b  reason: collision with root package name */
    public long f2822b;

    /* renamed from: c  reason: collision with root package name */
    public final File f2823c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2824d;

    public e(File file, int i2) {
        this.f2821a = new LinkedHashMap(16, 0.75f, true);
        this.f2822b = 0L;
        this.f2823c = file;
        this.f2824d = i2;
    }

    @Override // c.a.a.a
    public synchronized a.C0051a a(String str) {
        a aVar = this.f2821a.get(str);
        if (aVar == null) {
            return null;
        }
        File b2 = b(str);
        try {
            b bVar = new b(new BufferedInputStream(a(b2)), b2.length());
            try {
                a a2 = a.a(bVar);
                if (!TextUtils.equals(str, a2.f2826b)) {
                    c.a.a.n.b("%s: key=%s, found=%s", b2.getAbsolutePath(), str, a2.f2826b);
                    e(str);
                    return null;
                }
                return aVar.a(a(bVar, bVar.j()));
            } finally {
                bVar.close();
            }
        } catch (IOException e2) {
            c.a.a.n.b("%s: %s", b2.getAbsolutePath(), e2.toString());
            d(str);
            return null;
        }
    }

    public File b(String str) {
        return new File(this.f2823c, c(str));
    }

    public final String c(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    public synchronized void d(String str) {
        boolean delete = b(str).delete();
        e(str);
        if (!delete) {
            c.a.a.n.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }

    public final void e(String str) {
        a remove = this.f2821a.remove(str);
        if (remove != null) {
            this.f2822b -= remove.f2825a;
        }
    }

    /* compiled from: DiskBasedCache.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f2825a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2826b;

        /* renamed from: c  reason: collision with root package name */
        public final String f2827c;

        /* renamed from: d  reason: collision with root package name */
        public final long f2828d;

        /* renamed from: e  reason: collision with root package name */
        public final long f2829e;

        /* renamed from: f  reason: collision with root package name */
        public final long f2830f;

        /* renamed from: g  reason: collision with root package name */
        public final long f2831g;

        /* renamed from: h  reason: collision with root package name */
        public final List<c.a.a.e> f2832h;

        public a(String str, String str2, long j, long j2, long j3, long j4, List<c.a.a.e> list) {
            this.f2826b = str;
            this.f2827c = "".equals(str2) ? null : str2;
            this.f2828d = j;
            this.f2829e = j2;
            this.f2830f = j3;
            this.f2831g = j4;
            this.f2832h = list;
        }

        public static List<c.a.a.e> a(a.C0051a c0051a) {
            List<c.a.a.e> list = c0051a.f2741h;
            return list != null ? list : g.a(c0051a.f2740g);
        }

        public static a a(b bVar) {
            if (e.b((InputStream) bVar) == 538247942) {
                return new a(e.b(bVar), e.b(bVar), e.c(bVar), e.c(bVar), e.c(bVar), e.c(bVar), e.a(bVar));
            }
            throw new IOException();
        }

        public a(String str, a.C0051a c0051a) {
            this(str, c0051a.f2735b, c0051a.f2736c, c0051a.f2737d, c0051a.f2738e, c0051a.f2739f, a(c0051a));
            this.f2825a = c0051a.f2734a.length;
        }

        public a.C0051a a(byte[] bArr) {
            a.C0051a c0051a = new a.C0051a();
            c0051a.f2734a = bArr;
            c0051a.f2735b = this.f2827c;
            c0051a.f2736c = this.f2828d;
            c0051a.f2737d = this.f2829e;
            c0051a.f2738e = this.f2830f;
            c0051a.f2739f = this.f2831g;
            c0051a.f2740g = g.a(this.f2832h);
            c0051a.f2741h = Collections.unmodifiableList(this.f2832h);
            return c0051a;
        }

        public boolean a(OutputStream outputStream) {
            try {
                e.a(outputStream, 538247942);
                e.a(outputStream, this.f2826b);
                e.a(outputStream, this.f2827c == null ? "" : this.f2827c);
                e.a(outputStream, this.f2828d);
                e.a(outputStream, this.f2829e);
                e.a(outputStream, this.f2830f);
                e.a(outputStream, this.f2831g);
                e.a(this.f2832h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                c.a.a.n.b("%s", e2.toString());
                return false;
            }
        }
    }

    /* compiled from: DiskBasedCache.java */
    /* loaded from: classes.dex */
    public static class b extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        public final long f2833a;

        /* renamed from: b  reason: collision with root package name */
        public long f2834b;

        public b(InputStream inputStream, long j) {
            super(inputStream);
            this.f2833a = j;
        }

        public long j() {
            return this.f2833a - this.f2834b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f2834b++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int read = super.read(bArr, i2, i3);
            if (read != -1) {
                this.f2834b += read;
            }
            return read;
        }
    }

    public OutputStream b(File file) {
        return new FileOutputStream(file);
    }

    public static int b(InputStream inputStream) {
        return (a(inputStream) << 24) | (a(inputStream) << 0) | 0 | (a(inputStream) << 8) | (a(inputStream) << 16);
    }

    public static long c(InputStream inputStream) {
        return ((a(inputStream) & 255) << 0) | 0 | ((a(inputStream) & 255) << 8) | ((a(inputStream) & 255) << 16) | ((a(inputStream) & 255) << 24) | ((a(inputStream) & 255) << 32) | ((a(inputStream) & 255) << 40) | ((a(inputStream) & 255) << 48) | ((255 & a(inputStream)) << 56);
    }

    public e(File file) {
        this(file, 5242880);
    }

    public static String b(b bVar) {
        return new String(a(bVar, c(bVar)), "UTF-8");
    }

    @Override // c.a.a.a
    public synchronized void a() {
        long length;
        b bVar;
        if (!this.f2823c.exists()) {
            if (!this.f2823c.mkdirs()) {
                c.a.a.n.c("Unable to create cache dir %s", this.f2823c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f2823c.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            try {
                length = file.length();
                bVar = new b(new BufferedInputStream(a(file)), length);
            } catch (IOException unused) {
                file.delete();
            }
            try {
                a a2 = a.a(bVar);
                a2.f2825a = length;
                a(a2.f2826b, a2);
                bVar.close();
            } catch (Throwable th) {
                bVar.close();
                throw th;
                break;
            }
        }
    }

    @Override // c.a.a.a
    public synchronized void a(String str, a.C0051a c0051a) {
        a(c0051a.f2734a.length);
        File b2 = b(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(b(b2));
            a aVar = new a(str, c0051a);
            if (aVar.a(bufferedOutputStream)) {
                bufferedOutputStream.write(c0051a.f2734a);
                bufferedOutputStream.close();
                a(str, aVar);
            } else {
                bufferedOutputStream.close();
                c.a.a.n.b("Failed to write header for %s", b2.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException unused) {
            if (b2.delete()) {
                return;
            }
            c.a.a.n.b("Could not clean up file %s", b2.getAbsolutePath());
        }
    }

    public final void a(int i2) {
        long j;
        long j2 = i2;
        if (this.f2822b + j2 < this.f2824d) {
            return;
        }
        if (c.a.a.n.f2804b) {
            c.a.a.n.d("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.f2822b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f2821a.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (b(value.f2826b).delete()) {
                j = j2;
                this.f2822b -= value.f2825a;
            } else {
                j = j2;
                String str = value.f2826b;
                c.a.a.n.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
            }
            it.remove();
            i3++;
            if (((float) (this.f2822b + j)) < this.f2824d * 0.9f) {
                break;
            }
            j2 = j;
        }
        if (c.a.a.n.f2804b) {
            c.a.a.n.d("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.f2822b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    public final void a(String str, a aVar) {
        if (!this.f2821a.containsKey(str)) {
            this.f2822b += aVar.f2825a;
        } else {
            this.f2822b += aVar.f2825a - this.f2821a.get(str).f2825a;
        }
        this.f2821a.put(str, aVar);
    }

    public static byte[] a(b bVar, long j) {
        long j2 = bVar.j();
        if (j >= 0 && j <= j2) {
            int i2 = (int) j;
            if (i2 == j) {
                byte[] bArr = new byte[i2];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + j2);
    }

    public InputStream a(File file) {
        return new FileInputStream(file);
    }

    public static int a(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public static void a(OutputStream outputStream, int i2) {
        outputStream.write((i2 >> 0) & 255);
        outputStream.write((i2 >> 8) & 255);
        outputStream.write((i2 >> 16) & 255);
        outputStream.write((i2 >> 24) & 255);
    }

    public static void a(OutputStream outputStream, long j) {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    public static void a(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    public static void a(List<c.a.a.e> list, OutputStream outputStream) {
        if (list != null) {
            a(outputStream, list.size());
            for (c.a.a.e eVar : list) {
                a(outputStream, eVar.a());
                a(outputStream, eVar.b());
            }
            return;
        }
        a(outputStream, 0);
    }

    public static List<c.a.a.e> a(b bVar) {
        int b2 = b((InputStream) bVar);
        if (b2 >= 0) {
            List<c.a.a.e> emptyList = b2 == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i2 = 0; i2 < b2; i2++) {
                emptyList.add(new c.a.a.e(b(bVar).intern(), b(bVar).intern()));
            }
            return emptyList;
        }
        throw new IOException("readHeaderList size=" + b2);
    }
}
