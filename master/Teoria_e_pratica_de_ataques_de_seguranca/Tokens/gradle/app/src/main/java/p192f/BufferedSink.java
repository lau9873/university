package p192f;

/* renamed from: f.d */
/* loaded from: classes.dex */
public interface BufferedSink extends Sink {
    /* renamed from: a */
    long mo2574a(Source source);

    /* renamed from: a */
    Buffer mo2569a();

    /* renamed from: a */
    BufferedSink mo2575a(C1822f c1822f);

    /* renamed from: a */
    BufferedSink mo2573a(String str);

    /* renamed from: e */
    BufferedSink mo2572e(long j);

    /* renamed from: f */
    BufferedSink mo2571f(long j);

    @Override // p192f.Sink, java.io.Flushable
    void flush();

    /* renamed from: i */
    BufferedSink mo2570i();

    BufferedSink write(byte[] bArr);

    BufferedSink write(byte[] bArr, int i, int i2);

    BufferedSink writeByte(int i);

    BufferedSink writeInt(int i);

    BufferedSink writeShort(int i);
}
