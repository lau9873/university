package p070c.p074b.p075a.p078d;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;

/* renamed from: c.b.a.d.c */
/* loaded from: classes.dex */
public class CLSUUID {

    /* renamed from: a */
    public static final AtomicLong f4791a = new AtomicLong(0);

    /* renamed from: b */
    public static String f4792b;

    public CLSUUID(IdManager idManager) {
        byte[] bArr = new byte[10];
        m5962c(bArr);
        m5963b(bArr);
        m5965a(bArr);
        String m4081c = CommonUtils.m4081c(idManager.m4047f());
        String m4093a = CommonUtils.m4093a(bArr);
        f4792b = String.format(Locale.US, "%s-%s-%s-%s", m4093a.substring(0, 12), m4093a.substring(12, 16), m4093a.subSequence(16, 20), m4081c.substring(0, 12)).toUpperCase(Locale.US);
    }

    /* renamed from: a */
    public final void m5965a(byte[] bArr) {
        byte[] m5964b = m5964b(Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = m5964b[0];
        bArr[9] = m5964b[1];
    }

    /* renamed from: b */
    public final void m5963b(byte[] bArr) {
        byte[] m5964b = m5964b(f4791a.incrementAndGet());
        bArr[6] = m5964b[0];
        bArr[7] = m5964b[1];
    }

    /* renamed from: c */
    public final void m5962c(byte[] bArr) {
        long time = new Date().getTime();
        byte[] m5966a = m5966a(time / 1000);
        bArr[0] = m5966a[0];
        bArr[1] = m5966a[1];
        bArr[2] = m5966a[2];
        bArr[3] = m5966a[3];
        byte[] m5964b = m5964b(time % 1000);
        bArr[4] = m5964b[0];
        bArr[5] = m5964b[1];
    }

    public String toString() {
        return f4792b;
    }

    /* renamed from: b */
    public static byte[] m5964b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    /* renamed from: a */
    public static byte[] m5966a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }
}
