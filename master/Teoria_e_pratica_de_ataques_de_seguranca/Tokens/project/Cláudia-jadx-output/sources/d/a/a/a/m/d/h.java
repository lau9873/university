package d.a.a.a.m.d;

import android.content.Context;
import d.a.a.a.m.b.q;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* compiled from: QueueFileEventStorage.java */
/* loaded from: classes.dex */
public class h implements c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4365a;

    /* renamed from: b  reason: collision with root package name */
    public final File f4366b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4367c;

    /* renamed from: d  reason: collision with root package name */
    public final File f4368d;

    /* renamed from: e  reason: collision with root package name */
    public q f4369e;

    /* renamed from: f  reason: collision with root package name */
    public File f4370f;

    public h(Context context, File file, String str, String str2) {
        this.f4365a = context;
        this.f4366b = file;
        this.f4367c = str2;
        this.f4368d = new File(this.f4366b, str);
        this.f4369e = new q(this.f4368d);
        e();
    }

    public OutputStream a(File file) {
        throw null;
    }

    @Override // d.a.a.a.m.d.c
    public void a(byte[] bArr) {
        this.f4369e.a(bArr);
    }

    @Override // d.a.a.a.m.d.c
    public boolean b() {
        return this.f4369e.k();
    }

    @Override // d.a.a.a.m.d.c
    public List<File> c() {
        return Arrays.asList(this.f4370f.listFiles());
    }

    @Override // d.a.a.a.m.d.c
    public void d() {
        try {
            this.f4369e.close();
        } catch (IOException unused) {
        }
        this.f4368d.delete();
    }

    public final void e() {
        this.f4370f = new File(this.f4366b, this.f4367c);
        if (this.f4370f.exists()) {
            return;
        }
        this.f4370f.mkdirs();
    }

    @Override // d.a.a.a.m.d.c
    public int a() {
        return this.f4369e.o();
    }

    @Override // d.a.a.a.m.d.c
    public void a(String str) {
        this.f4369e.close();
        a(this.f4368d, new File(this.f4370f, str));
        this.f4369e = new q(this.f4368d);
    }

    public final void a(File file, File file2) {
        FileInputStream fileInputStream;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            outputStream = a(file2);
            d.a.a.a.m.b.i.a(fileInputStream, outputStream, new byte[1024]);
            d.a.a.a.m.b.i.a((Closeable) fileInputStream, "Failed to close file input stream");
            d.a.a.a.m.b.i.a((Closeable) outputStream, "Failed to close output stream");
            file.delete();
        } catch (Throwable th2) {
            th = th2;
            d.a.a.a.m.b.i.a((Closeable) fileInputStream, "Failed to close file input stream");
            d.a.a.a.m.b.i.a((Closeable) outputStream, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    @Override // d.a.a.a.m.d.c
    public List<File> a(int i2) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f4370f.listFiles()) {
            arrayList.add(file);
            if (arrayList.size() >= i2) {
                break;
            }
        }
        return arrayList;
    }

    @Override // d.a.a.a.m.d.c
    public void a(List<File> list) {
        for (File file : list) {
            d.a.a.a.m.b.i.c(this.f4365a, String.format("deleting sent analytics file %s", file.getName()));
            file.delete();
        }
    }

    @Override // d.a.a.a.m.d.c
    public boolean a(int i2, int i3) {
        return this.f4369e.a(i2, i3);
    }
}
