package p070c.p074b.p075a.p078d;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* renamed from: c.b.a.d.d */
/* loaded from: classes.dex */
public class ClsFileOutputStream extends FileOutputStream {

    /* renamed from: d */
    public static final FilenameFilter f4798d = new C0815a();

    /* renamed from: a */
    public final String f4799a;

    /* renamed from: b */
    public File f4800b;

    /* renamed from: c */
    public boolean f4801c;

    /* compiled from: ClsFileOutputStream.java */
    /* renamed from: c.b.a.d.d$a */
    /* loaded from: classes.dex */
    public static class C0815a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public ClsFileOutputStream(File file, String str) {
        super(new File(file, str + ".cls_temp"));
        this.f4801c = false;
        this.f4799a = file + File.separator + str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4799a);
        sb.append(".cls_temp");
        this.f4800b = new File(sb.toString());
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f4801c) {
            return;
        }
        this.f4801c = true;
        super.flush();
        super.close();
        File file = new File(this.f4799a + ".cls");
        if (this.f4800b.renameTo(file)) {
            this.f4800b = null;
            return;
        }
        String str = "";
        if (file.exists()) {
            str = " (target already exists)";
        } else if (!this.f4800b.exists()) {
            str = " (source does not exist)";
        }
        throw new IOException("Could not rename temp file: " + this.f4800b + " -> " + file + str);
    }

    /* renamed from: j */
    public void m5959j() {
        if (this.f4801c) {
            return;
        }
        this.f4801c = true;
        super.flush();
        super.close();
    }
}
