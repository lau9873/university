package p070c.p115g.p116a.p117a.p118a;

import android.content.Context;
import com.spirtech.android.hce.calypso.C1477m;
import com.spirtech.android.hce.calypso.CalypsoHceNatives;
import java.util.Arrays;
import p070c.p115g.p128c.p129a.p130a.C1423a;
import p070c.p115g.p128c.p129a.p130a.C1425c;
import p070c.p115g.p128c.p129a.p130a.C1426d;

/* renamed from: c.g.a.a.a.f */
/* loaded from: classes.dex */
public class C1415f {

    /* renamed from: d */
    public static int f6026d;

    /* renamed from: e */
    public static C1415f f6027e;

    /* renamed from: a */
    public final CalypsoHceNatives f6028a = new CalypsoHceNatives();

    /* renamed from: b */
    public final byte[] f6029b = new byte[50000];

    /* renamed from: c */
    public final byte[] f6030c = new byte[50000];

    /* renamed from: b */
    public static C1415f m4532b(Context context) {
        if (f6027e == null) {
            f6027e = new C1415f();
            f6027e.m4540a(context.getApplicationContext());
        }
        return f6027e;
    }

    /* renamed from: l */
    public static C1415f m4519l() {
        C1415f c1415f = f6027e;
        if (c1415f != null) {
            return c1415f;
        }
        throw new Exception("first getNativeWrapperInstance must be getNativeWrapperInstance(context)");
    }

    /* renamed from: a */
    public synchronized int m4540a(Context context) {
        return this.f6028a.initialize(context);
    }

    /* renamed from: a */
    public final int m4536a(byte[] bArr, byte[] bArr2, String str) {
        int i = f6026d;
        C1426d.m4461b().m4457e("cardTime");
        C1426d.m4461b().m4457e(str + " reqnb:" + i);
        int transact = this.f6028a.transact(bArr, bArr2);
        C1426d.m4461b().m4463a("cardTime");
        C1426d.m4461b().m4462a(str + " reqnb:" + i, "res=" + transact);
        f6026d = f6026d + 1;
        return transact;
    }

    /* renamed from: a */
    public synchronized int m4535a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int m4536a;
        this.f6029b[0] = 7;
        byte[] m4467a = C1425c.m4467a(C1425c.m4470a(String.format("%04x", Integer.valueOf(bArr.length))), bArr, C1425c.m4470a(String.format("%04x", Integer.valueOf(bArr2.length))), bArr2, C1425c.m4470a(String.format("%04x", Integer.valueOf(bArr3.length))), bArr3);
        System.arraycopy(m4467a, 0, this.f6029b, 1, m4467a.length);
        m4536a = m4536a(this.f6029b, this.f6030c, "CMD_ACTIVATE 0x07");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_ACTIVATE 0x07 params: " + C1425c.m4469a(m4467a) + " ");
        }
        return m4536a;
    }

    /* renamed from: a */
    public synchronized void m4541a(int i) {
        byte[] bArr = this.f6029b;
        bArr[0] = 2;
        bArr[1] = (byte) i;
        int transact = this.f6028a.transact(bArr, this.f6030c);
        if (transact < 0) {
            throw new C1477m(transact, "CMD_CARD_EVENT (0x02) fieldDeactivated");
        }
    }

    /* renamed from: a */
    public synchronized boolean m4542a() {
        byte[] bArr = this.f6029b;
        bArr[0] = 3;
        bArr[1] = 5;
        int m4536a = m4536a(bArr, this.f6030c, "CMD_GET_INFO (0x05)");
        if (m4536a == 384) {
            return true;
        }
        if (m4536a < 0) {
            C1423a.m4478a("MANDATORYDIAGNOSTIC", 4, "checkPOCertCMD_GET_INFO vRet" + m4536a + " ");
            return false;
        }
        throw new C1477m(m4536a, "CMD_GET_INFO (0x05) checkPOCert");
    }

    /* renamed from: a */
    public synchronized byte[] m4539a(String str) {
        int m4536a;
        this.f6029b[0] = 5;
        byte[] m4468a = C1425c.m4468a(C1425c.m4470a(String.format("%02x", Integer.valueOf(str.getBytes().length))), str.getBytes());
        System.arraycopy(m4468a, 0, this.f6029b, 1, m4468a.length);
        m4536a = m4536a(this.f6029b, this.f6030c, "CMD_REG_START 0x05");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_REG_START 0x05 getPOPubKeyAndSignature  params: " + C1425c.m4469a(m4468a) + "  ");
        }
        return Arrays.copyOf(this.f6030c, m4536a);
    }

    /* renamed from: a */
    public synchronized byte[] m4538a(byte[] bArr) {
        int transact;
        if (bArr.length > 255) {
            throw new C1477m(-3, "contactless errlength");
        }
        byte[] bArr2 = this.f6029b;
        bArr2[0] = 1;
        bArr2[1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        transact = this.f6028a.transact(this.f6029b, this.f6030c);
        if (transact < 0) {
            throw new C1477m(transact, "contactless apdu: " + C1425c.m4469a(bArr) + " ");
        }
        return Arrays.copyOf(this.f6030c, transact);
    }

    /* renamed from: a */
    public synchronized byte[] m4537a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        this.f6029b[0] = 6;
        byte[] m4468a = C1425c.m4468a(bArr, bArr2);
        System.arraycopy(m4468a, 0, this.f6029b, 1, m4468a.length);
        int m4536a = m4536a(this.f6029b, this.f6030c, "CMD_REG_FINISH 0x06");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_REG_FINISH 0x06 logRamCertAndPoCert params: " + C1425c.m4469a(m4468a) + " ");
        }
        byte[] bArr4 = this.f6030c;
        bArr3 = new byte[]{bArr4[0], bArr4[1]};
        C1425c.m4465b(bArr3);
        return Arrays.copyOfRange(this.f6030c, 2, Integer.parseInt(C1425c.m4469a(bArr3), 16) + 2);
    }

    /* renamed from: b */
    public synchronized int m4533b(int i) {
        byte[] bArr;
        bArr = this.f6029b;
        bArr[0] = 3;
        bArr[1] = 15;
        bArr[2] = (byte) (i & 255);
        return m4536a(bArr, this.f6030c, "CMD_GET_INFO (0x0F)");
    }

    /* renamed from: b */
    public synchronized int m4531b(String str) {
        int m4536a;
        byte[] bArr = this.f6029b;
        bArr[0] = 4;
        bArr[1] = 2;
        byte[] bytes = str.getBytes("UTF-8");
        byte[] m4468a = C1425c.m4468a(C1425c.m4470a(String.format("%04x", Integer.valueOf(bytes.length))), bytes);
        System.arraycopy(m4468a, 0, this.f6029b, 2, m4468a.length);
        m4536a = m4536a(this.f6029b, this.f6030c, "PUT_INFO 0x04 (0x02)");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "PUT_INFO 0x04 (0x02) logString params: " + C1425c.m4469a(m4468a) + " ");
        }
        return m4536a;
    }

    /* renamed from: b */
    public synchronized boolean m4534b() {
        byte[] bArr = this.f6029b;
        bArr[0] = 3;
        bArr[1] = 2;
        int m4536a = m4536a(bArr, this.f6030c, "CMD_GET_INFO (0x02)");
        if (m4536a >= 0) {
            if (m4536a == 8) {
                return !C1425c.m4469a(Arrays.copyOf(this.f6030c, m4536a)).replace(" ", "").equals("0000000000000000");
            }
            throw new C1477m(m4536a, "CMD_GET_INFO (0x02) check SN");
        }
        C1423a.m4478a("MANDATORYDIAGNOSTIC", 4, "checkSerialNumberCMD_GET_INFO vRet" + m4536a + " ");
        return false;
    }

    /* renamed from: b */
    public synchronized byte[] m4530b(byte[] bArr) {
        byte[] bArr2;
        this.f6029b[0] = 9;
        byte[] m4470a = bArr != null ? C1425c.m4470a(String.format("%04x", Integer.valueOf(bArr.length))) : new byte[]{0, 0};
        if (bArr != null) {
            m4470a = C1425c.m4468a(m4470a, bArr);
        }
        System.arraycopy(m4470a, 0, this.f6029b, 1, m4470a.length);
        int m4536a = m4536a(this.f6029b, this.f6030c, "CMD_START_SEQ 0x09");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_START_SEQ 0x09 getPOAuth params: " + C1425c.m4469a(m4470a) + " ");
        }
        byte[] bArr3 = this.f6030c;
        bArr2 = new byte[]{bArr3[0], bArr3[1]};
        C1425c.m4465b(bArr2);
        return Arrays.copyOfRange(this.f6030c, 2, Integer.parseInt(C1425c.m4469a(bArr2), 16) + 2);
    }

    /* renamed from: b */
    public synchronized byte[] m4529b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int m4536a;
        this.f6029b[0] = 8;
        byte[] m4467a = C1425c.m4467a(C1425c.m4470a(String.format("%04x", Integer.valueOf(bArr.length))), bArr, C1425c.m4470a(String.format("%04x", Integer.valueOf(bArr2.length))), bArr2, C1425c.m4470a(String.format("%04x", Integer.valueOf(bArr3.length))), bArr3);
        System.arraycopy(m4467a, 0, this.f6029b, 1, m4467a.length);
        m4536a = m4536a(this.f6029b, this.f6030c, "CMD_UPDATE 0x08 sendApdu");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_UPDATE 0x08 sendApdu params : " + C1425c.m4469a(m4467a) + " ");
        }
        return Arrays.copyOf(this.f6030c, m4536a);
    }

    /* renamed from: c */
    public synchronized byte[] m4528c() {
        byte[] bArr = this.f6029b;
        bArr[0] = 3;
        bArr[1] = 11;
        int m4536a = m4536a(bArr, this.f6030c, "CMD_GET_INFO (0x0B)");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_GET_INFO (0x0B) getAppId");
        }
        return Arrays.copyOf(this.f6030c, 8);
    }

    /* renamed from: d */
    public synchronized byte[] m4527d() {
        int m4536a;
        byte[] bArr = this.f6029b;
        bArr[0] = 12;
        m4536a = m4536a(bArr, this.f6030c, "CMD_GET_CONTENTS 0x0C");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_GET_CONTENTS 0x0C getContents");
        }
        return Arrays.copyOf(this.f6030c, m4536a);
    }

    /* renamed from: e */
    public synchronized byte[] m4526e() {
        int m4536a;
        byte[] bArr = this.f6029b;
        bArr[0] = 3;
        bArr[1] = 1;
        m4536a = m4536a(bArr, this.f6030c, "CMD_GET_INFO (0x01)");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_GET_INFO (0x01) getInternalVersion");
        }
        return Arrays.copyOf(this.f6030c, m4536a);
    }

    /* renamed from: f */
    public synchronized byte[] m4525f() {
        byte[] bArr = this.f6029b;
        bArr[0] = 3;
        bArr[1] = 5;
        int m4536a = m4536a(bArr, this.f6030c, "CMD_GET_INFO (0x05)");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_GET_INFO (0x05) getPOcert");
        }
        return Arrays.copyOf(this.f6030c, 384);
    }

    /* renamed from: g */
    public synchronized byte[] m4524g() {
        byte[] bArr = this.f6029b;
        bArr[0] = 3;
        bArr[1] = 6;
        int m4536a = m4536a(bArr, this.f6030c, "CMD_GET_INFO (0x06)");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_GET_INFO (0x06) ramcert");
        }
        return Arrays.copyOf(this.f6030c, 384);
    }

    /* renamed from: h */
    public synchronized byte[] m4523h() {
        int m4536a;
        byte[] bArr = this.f6029b;
        bArr[0] = 3;
        bArr[1] = 2;
        m4536a = m4536a(bArr, this.f6030c, "CMD_GET_INFO (0x02)");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_GET_INFO (0x02) get SN");
        }
        return Arrays.copyOf(this.f6030c, m4536a);
    }

    /* renamed from: i */
    public synchronized byte[] m4522i() {
        int i;
        i = -4;
        for (int i2 = 0; i == -4 && i2 < 4; i2++) {
            i = m4533b(i2);
        }
        if (i < 0) {
            throw new C1477m(i, "CMD_GET_INFO (0x0F) getStoredValue");
        }
        return Arrays.copyOf(this.f6030c, i);
    }

    /* renamed from: j */
    public synchronized void m4521j() {
        byte[] bArr = this.f6029b;
        bArr[0] = 11;
        int m4536a = m4536a(bArr, this.f6030c, "CMD_LOG_CLEAR 0x0B");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_LOG_CLEAR 0x0B logClear");
        }
    }

    /* renamed from: k */
    public synchronized byte[] m4520k() {
        int m4536a;
        byte[] bArr = this.f6029b;
        bArr[0] = 10;
        m4536a = m4536a(bArr, this.f6030c, "CMD_LOG_READ 0x0A");
        if (m4536a < 0) {
            throw new C1477m(m4536a, "CMD_LOG_READ 0x0A logRead");
        }
        return Arrays.copyOf(this.f6030c, m4536a);
    }
}
