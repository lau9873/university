package p192f;

import java.io.InputStream;

/* renamed from: f.e */
/* loaded from: classes.dex */
public interface BufferedSource extends Source {
    /* renamed from: a */
    long mo2568a(byte b);

    /* renamed from: a */
    long mo2563a(Sink sink);

    /* renamed from: a */
    Buffer mo2569a();

    /* renamed from: a */
    boolean mo2566a(long j);

    /* renamed from: a */
    boolean mo2565a(long j, C1822f c1822f);

    /* renamed from: b */
    C1822f mo2562b(long j);

    /* renamed from: c */
    String mo2561c();

    /* renamed from: c */
    byte[] mo2560c(long j);

    /* renamed from: d */
    int mo2559d();

    /* renamed from: d */
    void mo2558d(long j);

    /* renamed from: e */
    boolean mo2557e();

    /* renamed from: f */
    short mo2555f();

    /* renamed from: g */
    long mo2554g();

    /* renamed from: h */
    InputStream mo2553h();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    short readShort();

    void skip(long j);
}
