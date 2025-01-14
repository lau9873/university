package p000a.p006b.p030g.p044j;

import android.util.Log;
import com.j256.ormlite.logger.Logger;
import java.io.Writer;

/* renamed from: a.b.g.j.e */
/* loaded from: classes.dex */
public class LogWriter extends Writer {

    /* renamed from: a */
    public final String f1564a;

    /* renamed from: b */
    public StringBuilder f1565b = new StringBuilder((int) Logger.DEFAULT_FULL_MESSAGE_LENGTH);

    public LogWriter(String str) {
        this.f1564a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m9666j();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m9666j();
    }

    /* renamed from: j */
    public final void m9666j() {
        if (this.f1565b.length() > 0) {
            Log.d(this.f1564a, this.f1565b.toString());
            StringBuilder sb = this.f1565b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m9666j();
            } else {
                this.f1565b.append(c);
            }
        }
    }
}
