package a.b.g.j;

import android.util.Log;
import java.io.Writer;
/* compiled from: LogWriter.java */
/* loaded from: classes.dex */
public class e extends Writer {

    /* renamed from: a  reason: collision with root package name */
    public final String f1053a;

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f1054b = new StringBuilder(128);

    public e(String str) {
        this.f1053a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        j();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        j();
    }

    public final void j() {
        if (this.f1054b.length() > 0) {
            Log.d(this.f1053a, this.f1054b.toString());
            StringBuilder sb = this.f1054b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = cArr[i2 + i4];
            if (c2 == '\n') {
                j();
            } else {
                this.f1054b.append(c2);
            }
        }
    }
}
