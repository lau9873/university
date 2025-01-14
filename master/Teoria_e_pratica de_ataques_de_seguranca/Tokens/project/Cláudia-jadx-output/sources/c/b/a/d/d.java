package c.b.a.d;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
/* compiled from: ClsFileOutputStream.java */
/* loaded from: classes.dex */
public class d extends FileOutputStream {

    /* renamed from: d  reason: collision with root package name */
    public static final FilenameFilter f2985d = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f2986a;

    /* renamed from: b  reason: collision with root package name */
    public File f2987b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2988c;

    /* compiled from: ClsFileOutputStream.java */
    /* loaded from: classes.dex */
    public static class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public d(File file, String str) {
        super(new File(file, str + ".cls_temp"));
        this.f2988c = false;
        this.f2986a = file + File.separator + str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2986a);
        sb.append(".cls_temp");
        this.f2987b = new File(sb.toString());
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f2988c) {
            return;
        }
        this.f2988c = true;
        super.flush();
        super.close();
        File file = new File(this.f2986a + ".cls");
        if (this.f2987b.renameTo(file)) {
            this.f2987b = null;
            return;
        }
        String str = "";
        if (file.exists()) {
            str = " (target already exists)";
        } else if (!this.f2987b.exists()) {
            str = " (source does not exist)";
        }
        throw new IOException("Could not rename temp file: " + this.f2987b + " -> " + file + str);
    }

    public void j() {
        if (this.f2988c) {
            return;
        }
        this.f2988c = true;
        super.flush();
        super.close();
    }
}
