package f;
/* compiled from: BufferedSink.java */
/* loaded from: classes.dex */
public interface d extends q {
    long a(r rVar);

    c a();

    d a(f fVar);

    d a(String str);

    d e(long j);

    d f(long j);

    @Override // f.q, java.io.Flushable
    void flush();

    d i();

    d write(byte[] bArr);

    d write(byte[] bArr, int i2, int i3);

    d writeByte(int i2);

    d writeInt(int i2);

    d writeShort(int i2);
}
