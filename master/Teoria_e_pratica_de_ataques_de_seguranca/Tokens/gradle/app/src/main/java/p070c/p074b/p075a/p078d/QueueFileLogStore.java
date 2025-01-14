package p070c.p074b.p075a.p078d;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.QueueFile;

/* renamed from: c.b.a.d.c0 */
/* loaded from: classes.dex */
public class QueueFileLogStore implements FileLogStore {

    /* renamed from: a */
    public final File f4793a;

    /* renamed from: b */
    public final int f4794b;

    /* renamed from: c */
    public QueueFile f4795c;

    /* compiled from: QueueFileLogStore.java */
    /* renamed from: c.b.a.d.c0$a */
    /* loaded from: classes.dex */
    public class C0814a implements QueueFile.InterfaceC1502d {

        /* renamed from: a */
        public final /* synthetic */ byte[] f4796a;

        /* renamed from: b */
        public final /* synthetic */ int[] f4797b;

        public C0814a(QueueFileLogStore queueFileLogStore, byte[] bArr, int[] iArr) {
            this.f4796a = bArr;
            this.f4797b = iArr;
        }

        @Override // p136d.p137a.p138a.p139a.p140m.p142b.QueueFile.InterfaceC1502d
        /* renamed from: a */
        public void mo4009a(InputStream inputStream, int i) {
            try {
                inputStream.read(this.f4796a, this.f4797b[0], i);
                int[] iArr = this.f4797b;
                iArr[0] = iArr[0] + i;
            } finally {
                inputStream.close();
            }
        }
    }

    public QueueFileLogStore(File file, int i) {
        this.f4793a = file;
        this.f4794b = i;
    }

    @Override // p070c.p074b.p075a.p078d.FileLogStore
    /* renamed from: a */
    public void mo5716a(long j, String str) {
        m5960d();
        m5961b(j, str);
    }

    @Override // p070c.p074b.p075a.p078d.FileLogStore
    /* renamed from: b */
    public ByteString mo5715b() {
        if (this.f4793a.exists()) {
            m5960d();
            QueueFile queueFile = this.f4795c;
            if (queueFile == null) {
                return null;
            }
            int[] iArr = {0};
            byte[] bArr = new byte[queueFile.m4010o()];
            try {
                this.f4795c.m4032a(new C0814a(this, bArr, iArr));
            } catch (IOException e) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
            }
            return ByteString.m5972a(bArr, 0, iArr[0]);
        }
        return null;
    }

    @Override // p070c.p074b.p075a.p078d.FileLogStore
    /* renamed from: c */
    public void mo5714c() {
        mo5717a();
        this.f4793a.delete();
    }

    /* renamed from: d */
    public final void m5960d() {
        if (this.f4795c == null) {
            try {
                this.f4795c = new QueueFile(this.f4793a);
            } catch (IOException e) {
                Logger m4197h = Fabric.m4197h();
                m4197h.mo4159c("CrashlyticsCore", "Could not open log file: " + this.f4793a, e);
            }
        }
    }

    @Override // p070c.p074b.p075a.p078d.FileLogStore
    /* renamed from: a */
    public void mo5717a() {
        CommonUtils.m4103a(this.f4795c, "There was a problem closing the Crashlytics log file.");
        this.f4795c = null;
    }

    /* renamed from: b */
    public final void m5961b(long j, String str) {
        int i;
        if (this.f4795c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            if (str.length() > this.f4794b / 4) {
                str = "..." + str.substring(str.length() - i);
            }
            this.f4795c.m4026a(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes("UTF-8"));
            while (!this.f4795c.m4014k() && this.f4795c.m4010o() > this.f4794b) {
                this.f4795c.m4011n();
            }
        } catch (IOException e) {
            Fabric.m4197h().mo4159c("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", e);
        }
    }
}
