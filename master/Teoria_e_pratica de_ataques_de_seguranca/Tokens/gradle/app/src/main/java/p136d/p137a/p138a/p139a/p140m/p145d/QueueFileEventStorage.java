package p136d.p137a.p138a.p139a.p140m.p145d;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.QueueFile;

/* renamed from: d.a.a.a.m.d.h */
/* loaded from: classes.dex */
public class QueueFileEventStorage implements EventsStorage {

    /* renamed from: a */
    public final Context f6569a;

    /* renamed from: b */
    public final File f6570b;

    /* renamed from: c */
    public final String f6571c;

    /* renamed from: d */
    public final File f6572d;

    /* renamed from: e */
    public QueueFile f6573e;

    /* renamed from: f */
    public File f6574f;

    public QueueFileEventStorage(Context context, File file, String str, String str2) {
        this.f6569a = context;
        this.f6570b = file;
        this.f6571c = str2;
        this.f6572d = new File(this.f6570b, str);
        this.f6573e = new QueueFile(this.f6572d);
        m3927e();
    }

    /* renamed from: a */
    public OutputStream mo3935a(File file) {
        throw null;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsStorage
    /* renamed from: a */
    public void mo3931a(byte[] bArr) {
        this.f6573e.m4026a(bArr);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsStorage
    /* renamed from: b */
    public boolean mo3930b() {
        return this.f6573e.m4014k();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsStorage
    /* renamed from: c */
    public List<File> mo3929c() {
        return Arrays.asList(this.f6574f.listFiles());
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsStorage
    /* renamed from: d */
    public void mo3928d() {
        try {
            this.f6573e.close();
        } catch (IOException unused) {
        }
        this.f6572d.delete();
    }

    /* renamed from: e */
    public final void m3927e() {
        this.f6574f = new File(this.f6570b, this.f6571c);
        if (this.f6574f.exists()) {
            return;
        }
        this.f6574f.mkdirs();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsStorage
    /* renamed from: a */
    public int mo3938a() {
        return this.f6573e.m4010o();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsStorage
    /* renamed from: a */
    public void mo3933a(String str) {
        this.f6573e.close();
        m3934a(this.f6572d, new File(this.f6574f, str));
        this.f6573e = new QueueFile(this.f6572d);
    }

    /* renamed from: a */
    public final void m3934a(File file, File file2) {
        FileInputStream fileInputStream;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                outputStream = mo3935a(file2);
                CommonUtils.m4099a(fileInputStream, outputStream, new byte[1024]);
                CommonUtils.m4103a((Closeable) fileInputStream, "Failed to close file input stream");
                CommonUtils.m4103a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
            } catch (Throwable th) {
                th = th;
                CommonUtils.m4103a((Closeable) fileInputStream, "Failed to close file input stream");
                CommonUtils.m4103a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsStorage
    /* renamed from: a */
    public List<File> mo3937a(int i) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f6574f.listFiles()) {
            arrayList.add(file);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsStorage
    /* renamed from: a */
    public void mo3932a(List<File> list) {
        for (File file : list) {
            CommonUtils.m4082c(this.f6569a, String.format("deleting sent analytics file %s", file.getName()));
            file.delete();
        }
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventsStorage
    /* renamed from: a */
    public boolean mo3936a(int i, int i2) {
        return this.f6573e.m4035a(i, i2);
    }
}
