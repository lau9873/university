package p136d.p137a.p138a.p139a.p140m.p145d;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: d.a.a.a.m.d.g */
/* loaded from: classes.dex */
public class GZIPQueueFileEventStorage extends QueueFileEventStorage {
    public GZIPQueueFileEventStorage(Context context, File file, String str, String str2) {
        super(context, file, str, str2);
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.QueueFileEventStorage
    /* renamed from: a */
    public OutputStream mo3935a(File file) {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
