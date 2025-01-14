package d.a.a.a.m.d;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
/* compiled from: GZIPQueueFileEventStorage.java */
/* loaded from: classes.dex */
public class g extends h {
    public g(Context context, File file, String str, String str2) {
        super(context, file, str, str2);
    }

    @Override // d.a.a.a.m.d.h
    public OutputStream a(File file) {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
