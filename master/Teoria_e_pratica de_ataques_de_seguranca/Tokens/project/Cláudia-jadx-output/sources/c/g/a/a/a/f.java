package c.g.a.a.a;

import android.content.Context;
import c.g.c.a.a.a;
import c.g.c.a.a.c;
import com.spirtech.android.hce.calypso.CalypsoHceNatives;
import com.spirtech.android.hce.calypso.m;
import java.util.Arrays;
/* loaded from: classes.dex */
public class f {

    /* renamed from: d  reason: collision with root package name */
    public static int f3997d;

    /* renamed from: e  reason: collision with root package name */
    public static f f3998e;

    /* renamed from: a  reason: collision with root package name */
    public final CalypsoHceNatives f3999a = new CalypsoHceNatives();

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f4000b = new byte[50000];

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f4001c = new byte[50000];

    public static f b(Context context) {
        if (f3998e == null) {
            f3998e = new f();
            f3998e.a(context.getApplicationContext());
        }
        return f3998e;
    }

    public static f l() {
        f fVar = f3998e;
        if (fVar != null) {
            return fVar;
        }
        throw new Exception("first getNativeWrapperInstance must be getNativeWrapperInstance(context)");
    }

    public synchronized int a(Context context) {
        return this.f3999a.initialize(context);
    }

    public final int a(byte[] bArr, byte[] bArr2, String str) {
        int i2 = f3997d;
        c.g.c.a.a.d.b().e("cardTime");
        c.g.c.a.a.d.b().e(str + " reqnb:" + i2);
        int transact = this.f3999a.transact(bArr, bArr2);
        c.g.c.a.a.d.b().a("cardTime");
        c.g.c.a.a.d.b().a(str + " reqnb:" + i2, "res=" + transact);
        f3997d = f3997d + 1;
        return transact;
    }

    public synchronized int a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int a2;
        this.f4000b[0] = 7;
        byte[] a3 = c.a(c.a(String.format("%04x", Integer.valueOf(bArr.length))), bArr, c.a(String.format("%04x", Integer.valueOf(bArr2.length))), bArr2, c.a(String.format("%04x", Integer.valueOf(bArr3.length))), bArr3);
        System.arraycopy(a3, 0, this.f4000b, 1, a3.length);
        a2 = a(this.f4000b, this.f4001c, "CMD_ACTIVATE 0x07");
        if (a2 < 0) {
            throw new m(a2, "CMD_ACTIVATE 0x07 params: " + c.a(a3) + " ");
        }
        return a2;
    }

    public synchronized void a(int i2) {
        byte[] bArr = this.f4000b;
        bArr[0] = 2;
        bArr[1] = (byte) i2;
        int transact = this.f3999a.transact(bArr, this.f4001c);
        if (transact < 0) {
            throw new m(transact, "CMD_CARD_EVENT (0x02) fieldDeactivated");
        }
    }

    public synchronized boolean a() {
        byte[] bArr = this.f4000b;
        bArr[0] = 3;
        bArr[1] = 5;
        int a2 = a(bArr, this.f4001c, "CMD_GET_INFO (0x05)");
        if (a2 == 384) {
            return true;
        }
        if (a2 < 0) {
            a.a("MANDATORYDIAGNOSTIC", 4, "checkPOCertCMD_GET_INFO vRet" + a2 + " ");
            return false;
        }
        throw new m(a2, "CMD_GET_INFO (0x05) checkPOCert");
    }

    public synchronized byte[] a(String str) {
        int a2;
        this.f4000b[0] = 5;
        byte[] a3 = c.a(c.a(String.format("%02x", Integer.valueOf(str.getBytes().length))), str.getBytes());
        System.arraycopy(a3, 0, this.f4000b, 1, a3.length);
        a2 = a(this.f4000b, this.f4001c, "CMD_REG_START 0x05");
        if (a2 < 0) {
            throw new m(a2, "CMD_REG_START 0x05 getPOPubKeyAndSignature  params: " + c.a(a3) + "  ");
        }
        return Arrays.copyOf(this.f4001c, a2);
    }

    public synchronized byte[] a(byte[] bArr) {
        int transact;
        if (bArr.length > 255) {
            throw new m(-3, "contactless errlength");
        }
        byte[] bArr2 = this.f4000b;
        bArr2[0] = 1;
        bArr2[1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        transact = this.f3999a.transact(this.f4000b, this.f4001c);
        if (transact < 0) {
            throw new m(transact, "contactless apdu: " + c.a(bArr) + " ");
        }
        return Arrays.copyOf(this.f4001c, transact);
    }

    public synchronized byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        this.f4000b[0] = 6;
        byte[] a2 = c.a(bArr, bArr2);
        System.arraycopy(a2, 0, this.f4000b, 1, a2.length);
        int a3 = a(this.f4000b, this.f4001c, "CMD_REG_FINISH 0x06");
        if (a3 < 0) {
            throw new m(a3, "CMD_REG_FINISH 0x06 logRamCertAndPoCert params: " + c.a(a2) + " ");
        }
        byte[] bArr4 = this.f4001c;
        bArr3 = new byte[]{bArr4[0], bArr4[1]};
        c.b(bArr3);
        return Arrays.copyOfRange(this.f4001c, 2, Integer.parseInt(c.a(bArr3), 16) + 2);
    }

    public synchronized int b(int i2) {
        byte[] bArr;
        bArr = this.f4000b;
        bArr[0] = 3;
        bArr[1] = 15;
        bArr[2] = (byte) (i2 & 255);
        return a(bArr, this.f4001c, "CMD_GET_INFO (0x0F)");
    }

    public synchronized int b(String str) {
        int a2;
        byte[] bArr = this.f4000b;
        bArr[0] = 4;
        bArr[1] = 2;
        byte[] bytes = str.getBytes("UTF-8");
        byte[] a3 = c.a(c.a(String.format("%04x", Integer.valueOf(bytes.length))), bytes);
        System.arraycopy(a3, 0, this.f4000b, 2, a3.length);
        a2 = a(this.f4000b, this.f4001c, "PUT_INFO 0x04 (0x02)");
        if (a2 < 0) {
            throw new m(a2, "PUT_INFO 0x04 (0x02) logString params: " + c.a(a3) + " ");
        }
        return a2;
    }

    public synchronized boolean b() {
        byte[] bArr = this.f4000b;
        bArr[0] = 3;
        bArr[1] = 2;
        int a2 = a(bArr, this.f4001c, "CMD_GET_INFO (0x02)");
        if (a2 >= 0) {
            if (a2 == 8) {
                return !c.a(Arrays.copyOf(this.f4001c, a2)).replace(" ", "").equals("0000000000000000");
            }
            throw new m(a2, "CMD_GET_INFO (0x02) check SN");
        }
        a.a("MANDATORYDIAGNOSTIC", 4, "checkSerialNumberCMD_GET_INFO vRet" + a2 + " ");
        return false;
    }

    public synchronized byte[] b(byte[] bArr) {
        byte[] bArr2;
        this.f4000b[0] = 9;
        byte[] a2 = bArr != null ? c.a(String.format("%04x", Integer.valueOf(bArr.length))) : new byte[]{0, 0};
        if (bArr != null) {
            a2 = c.a(a2, bArr);
        }
        System.arraycopy(a2, 0, this.f4000b, 1, a2.length);
        int a3 = a(this.f4000b, this.f4001c, "CMD_START_SEQ 0x09");
        if (a3 < 0) {
            throw new m(a3, "CMD_START_SEQ 0x09 getPOAuth params: " + c.a(a2) + " ");
        }
        byte[] bArr3 = this.f4001c;
        bArr2 = new byte[]{bArr3[0], bArr3[1]};
        c.b(bArr2);
        return Arrays.copyOfRange(this.f4001c, 2, Integer.parseInt(c.a(bArr2), 16) + 2);
    }

    public synchronized byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int a2;
        this.f4000b[0] = 8;
        byte[] a3 = c.a(c.a(String.format("%04x", Integer.valueOf(bArr.length))), bArr, c.a(String.format("%04x", Integer.valueOf(bArr2.length))), bArr2, c.a(String.format("%04x", Integer.valueOf(bArr3.length))), bArr3);
        System.arraycopy(a3, 0, this.f4000b, 1, a3.length);
        a2 = a(this.f4000b, this.f4001c, "CMD_UPDATE 0x08 sendApdu");
        if (a2 < 0) {
            throw new m(a2, "CMD_UPDATE 0x08 sendApdu params : " + c.a(a3) + " ");
        }
        return Arrays.copyOf(this.f4001c, a2);
    }

    public synchronized byte[] c() {
        byte[] bArr = this.f4000b;
        bArr[0] = 3;
        bArr[1] = 11;
        int a2 = a(bArr, this.f4001c, "CMD_GET_INFO (0x0B)");
        if (a2 < 0) {
            throw new m(a2, "CMD_GET_INFO (0x0B) getAppId");
        }
        return Arrays.copyOf(this.f4001c, 8);
    }

    public synchronized byte[] d() {
        int a2;
        byte[] bArr = this.f4000b;
        bArr[0] = 12;
        a2 = a(bArr, this.f4001c, "CMD_GET_CONTENTS 0x0C");
        if (a2 < 0) {
            throw new m(a2, "CMD_GET_CONTENTS 0x0C getContents");
        }
        return Arrays.copyOf(this.f4001c, a2);
    }

    public synchronized byte[] e() {
        int a2;
        byte[] bArr = this.f4000b;
        bArr[0] = 3;
        bArr[1] = 1;
        a2 = a(bArr, this.f4001c, "CMD_GET_INFO (0x01)");
        if (a2 < 0) {
            throw new m(a2, "CMD_GET_INFO (0x01) getInternalVersion");
        }
        return Arrays.copyOf(this.f4001c, a2);
    }

    public synchronized byte[] f() {
        byte[] bArr = this.f4000b;
        bArr[0] = 3;
        bArr[1] = 5;
        int a2 = a(bArr, this.f4001c, "CMD_GET_INFO (0x05)");
        if (a2 < 0) {
            throw new m(a2, "CMD_GET_INFO (0x05) getPOcert");
        }
        return Arrays.copyOf(this.f4001c, 384);
    }

    public synchronized byte[] g() {
        byte[] bArr = this.f4000b;
        bArr[0] = 3;
        bArr[1] = 6;
        int a2 = a(bArr, this.f4001c, "CMD_GET_INFO (0x06)");
        if (a2 < 0) {
            throw new m(a2, "CMD_GET_INFO (0x06) ramcert");
        }
        return Arrays.copyOf(this.f4001c, 384);
    }

    public synchronized byte[] h() {
        int a2;
        byte[] bArr = this.f4000b;
        bArr[0] = 3;
        bArr[1] = 2;
        a2 = a(bArr, this.f4001c, "CMD_GET_INFO (0x02)");
        if (a2 < 0) {
            throw new m(a2, "CMD_GET_INFO (0x02) get SN");
        }
        return Arrays.copyOf(this.f4001c, a2);
    }

    public synchronized byte[] i() {
        int i2;
        i2 = -4;
        for (int i3 = 0; i2 == -4 && i3 < 4; i3++) {
            i2 = b(i3);
        }
        if (i2 < 0) {
            throw new m(i2, "CMD_GET_INFO (0x0F) getStoredValue");
        }
        return Arrays.copyOf(this.f4001c, i2);
    }

    public synchronized void j() {
        byte[] bArr = this.f4000b;
        bArr[0] = 11;
        int a2 = a(bArr, this.f4001c, "CMD_LOG_CLEAR 0x0B");
        if (a2 < 0) {
            throw new m(a2, "CMD_LOG_CLEAR 0x0B logClear");
        }
    }

    public synchronized byte[] k() {
        int a2;
        byte[] bArr = this.f4000b;
        bArr[0] = 10;
        a2 = a(bArr, this.f4001c, "CMD_LOG_READ 0x0A");
        if (a2 < 0) {
            throw new m(a2, "CMD_LOG_READ 0x0A logRead");
        }
        return Arrays.copyOf(this.f4001c, a2);
    }
}
