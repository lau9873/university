package c.b.a.d;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: CLSUUID.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicLong f2978a = new AtomicLong(0);

    /* renamed from: b  reason: collision with root package name */
    public static String f2979b;

    public c(d.a.a.a.m.b.o oVar) {
        byte[] bArr = new byte[10];
        c(bArr);
        b(bArr);
        a(bArr);
        String c2 = d.a.a.a.m.b.i.c(oVar.f());
        String a2 = d.a.a.a.m.b.i.a(bArr);
        f2979b = String.format(Locale.US, "%s-%s-%s-%s", a2.substring(0, 12), a2.substring(12, 16), a2.subSequence(16, 20), c2.substring(0, 12)).toUpperCase(Locale.US);
    }

    public final void a(byte[] bArr) {
        byte[] b2 = b(Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b2[0];
        bArr[9] = b2[1];
    }

    public final void b(byte[] bArr) {
        byte[] b2 = b(f2978a.incrementAndGet());
        bArr[6] = b2[0];
        bArr[7] = b2[1];
    }

    public final void c(byte[] bArr) {
        long time = new Date().getTime();
        byte[] a2 = a(time / 1000);
        bArr[0] = a2[0];
        bArr[1] = a2[1];
        bArr[2] = a2[2];
        bArr[3] = a2[3];
        byte[] b2 = b(time % 1000);
        bArr[4] = b2[0];
        bArr[5] = b2[1];
    }

    public String toString() {
        return f2979b;
    }

    public static byte[] b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public static byte[] a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }
}
