package p070c.p074b.p075a.p078d;

import java.util.Map;
import java.util.TreeMap;
import p070c.p074b.p075a.p078d.p079o0.p080b.BinaryImageData;
import p070c.p074b.p075a.p078d.p079o0.p080b.CustomAttributeData;
import p070c.p074b.p075a.p078d.p079o0.p080b.DeviceData;
import p070c.p074b.p075a.p078d.p079o0.p080b.SessionEventData;
import p070c.p074b.p075a.p078d.p079o0.p080b.SignalData;
import p070c.p074b.p075a.p078d.p079o0.p080b.ThreadData;
import p136d.p137a.p138a.p139a.Fabric;

/* renamed from: c.b.a.d.z */
/* loaded from: classes.dex */
public class NativeCrashWriter {

    /* renamed from: a */
    public static final SignalData f4988a = new SignalData("", "", 0);

    /* renamed from: b */
    public static final AbstractC0878j[] f4989b = new AbstractC0878j[0];

    /* renamed from: c */
    public static final C0881m[] f4990c = new C0881m[0];

    /* renamed from: d */
    public static final C0875g[] f4991d = new C0875g[0];

    /* renamed from: e */
    public static final C0870b[] f4992e = new C0870b[0];

    /* renamed from: f */
    public static final C0871c[] f4993f = new C0871c[0];

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$a */
    /* loaded from: classes.dex */
    public static final class C0869a extends AbstractC0878j {
        public C0869a(C0874f c0874f, C0879k c0879k) {
            super(3, c0874f, c0879k);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$b */
    /* loaded from: classes.dex */
    public static final class C0870b extends AbstractC0878j {

        /* renamed from: c */
        public final long f4994c;

        /* renamed from: d */
        public final long f4995d;

        /* renamed from: e */
        public final String f4996e;

        /* renamed from: f */
        public final String f4997f;

        public C0870b(BinaryImageData binaryImageData) {
            super(4, new AbstractC0878j[0]);
            this.f4994c = binaryImageData.f4929a;
            this.f4995d = binaryImageData.f4930b;
            this.f4996e = binaryImageData.f4931c;
            this.f4997f = binaryImageData.f4932d;
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: a */
        public int mo5690a() {
            int m5936b = CodedOutputStream.m5936b(1, this.f4994c);
            return CodedOutputStream.m5935b(3, ByteString.m5973a(this.f4996e)) + m5936b + CodedOutputStream.m5936b(2, this.f4995d) + CodedOutputStream.m5935b(4, ByteString.m5973a(this.f4997f));
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: b */
        public void mo5689b(CodedOutputStream codedOutputStream) {
            codedOutputStream.m5951a(1, this.f4994c);
            codedOutputStream.m5951a(2, this.f4995d);
            codedOutputStream.m5950a(3, ByteString.m5973a(this.f4996e));
            codedOutputStream.m5950a(4, ByteString.m5973a(this.f4997f));
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$c */
    /* loaded from: classes.dex */
    public static final class C0871c extends AbstractC0878j {

        /* renamed from: c */
        public final String f4998c;

        /* renamed from: d */
        public final String f4999d;

        public C0871c(CustomAttributeData customAttributeData) {
            super(2, new AbstractC0878j[0]);
            this.f4998c = customAttributeData.f4933a;
            this.f4999d = customAttributeData.f4934b;
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: a */
        public int mo5690a() {
            int m5935b = CodedOutputStream.m5935b(1, ByteString.m5973a(this.f4998c));
            String str = this.f4999d;
            if (str == null) {
                str = "";
            }
            return m5935b + CodedOutputStream.m5935b(2, ByteString.m5973a(str));
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: b */
        public void mo5689b(CodedOutputStream codedOutputStream) {
            codedOutputStream.m5950a(1, ByteString.m5973a(this.f4998c));
            String str = this.f4999d;
            if (str == null) {
                str = "";
            }
            codedOutputStream.m5950a(2, ByteString.m5973a(str));
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$d */
    /* loaded from: classes.dex */
    public static final class C0872d extends AbstractC0878j {

        /* renamed from: c */
        public final float f5000c;

        /* renamed from: d */
        public final int f5001d;

        /* renamed from: e */
        public final boolean f5002e;

        /* renamed from: f */
        public final int f5003f;

        /* renamed from: g */
        public final long f5004g;

        /* renamed from: h */
        public final long f5005h;

        public C0872d(float f, int i, boolean z, int i2, long j, long j2) {
            super(5, new AbstractC0878j[0]);
            this.f5000c = f;
            this.f5001d = i;
            this.f5002e = z;
            this.f5003f = i2;
            this.f5004g = j;
            this.f5005h = j2;
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: a */
        public int mo5690a() {
            return CodedOutputStream.m5938b(1, this.f5000c) + 0 + CodedOutputStream.m5919f(2, this.f5001d) + CodedOutputStream.m5934b(3, this.f5002e) + CodedOutputStream.m5917g(4, this.f5003f) + CodedOutputStream.m5936b(5, this.f5004g) + CodedOutputStream.m5936b(6, this.f5005h);
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: b */
        public void mo5689b(CodedOutputStream codedOutputStream) {
            codedOutputStream.m5953a(1, this.f5000c);
            codedOutputStream.m5937b(2, this.f5001d);
            codedOutputStream.m5949a(3, this.f5002e);
            codedOutputStream.m5924d(4, this.f5003f);
            codedOutputStream.m5951a(5, this.f5004g);
            codedOutputStream.m5951a(6, this.f5005h);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$e */
    /* loaded from: classes.dex */
    public static final class C0873e extends AbstractC0878j {

        /* renamed from: c */
        public final long f5006c;

        /* renamed from: d */
        public final String f5007d;

        public C0873e(long j, String str, AbstractC0878j... abstractC0878jArr) {
            super(10, abstractC0878jArr);
            this.f5006c = j;
            this.f5007d = str;
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: a */
        public int mo5690a() {
            return CodedOutputStream.m5936b(1, this.f5006c) + CodedOutputStream.m5935b(2, ByteString.m5973a(this.f5007d));
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: b */
        public void mo5689b(CodedOutputStream codedOutputStream) {
            codedOutputStream.m5951a(1, this.f5006c);
            codedOutputStream.m5950a(2, ByteString.m5973a(this.f5007d));
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$f */
    /* loaded from: classes.dex */
    public static final class C0874f extends AbstractC0878j {
        public C0874f(C0880l c0880l, C0879k c0879k, C0879k c0879k2) {
            super(1, c0879k, c0880l, c0879k2);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$g */
    /* loaded from: classes.dex */
    public static final class C0875g extends AbstractC0878j {

        /* renamed from: c */
        public final long f5008c;

        /* renamed from: d */
        public final String f5009d;

        /* renamed from: e */
        public final String f5010e;

        /* renamed from: f */
        public final long f5011f;

        /* renamed from: g */
        public final int f5012g;

        public C0875g(ThreadData.C0862a c0862a) {
            super(3, new AbstractC0878j[0]);
            this.f5008c = c0862a.f4955a;
            this.f5009d = c0862a.f4956b;
            this.f5010e = c0862a.f4957c;
            this.f5011f = c0862a.f4958d;
            this.f5012g = c0862a.f4959e;
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: a */
        public int mo5690a() {
            return CodedOutputStream.m5936b(1, this.f5008c) + CodedOutputStream.m5935b(2, ByteString.m5973a(this.f5009d)) + CodedOutputStream.m5935b(3, ByteString.m5973a(this.f5010e)) + CodedOutputStream.m5936b(4, this.f5011f) + CodedOutputStream.m5917g(5, this.f5012g);
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: b */
        public void mo5689b(CodedOutputStream codedOutputStream) {
            codedOutputStream.m5951a(1, this.f5008c);
            codedOutputStream.m5950a(2, ByteString.m5973a(this.f5009d));
            codedOutputStream.m5950a(3, ByteString.m5973a(this.f5010e));
            codedOutputStream.m5951a(4, this.f5011f);
            codedOutputStream.m5924d(5, this.f5012g);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$h */
    /* loaded from: classes.dex */
    public static final class C0876h extends AbstractC0878j {

        /* renamed from: c */
        public ByteString f5013c;

        public C0876h(ByteString byteString) {
            super(6, new AbstractC0878j[0]);
            this.f5013c = byteString;
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: a */
        public int mo5690a() {
            return CodedOutputStream.m5935b(1, this.f5013c);
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: b */
        public void mo5689b(CodedOutputStream codedOutputStream) {
            codedOutputStream.m5950a(1, this.f5013c);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$i */
    /* loaded from: classes.dex */
    public static final class C0877i extends AbstractC0878j {
        public C0877i() {
            super(0, new AbstractC0878j[0]);
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: a */
        public void mo5692a(CodedOutputStream codedOutputStream) {
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: b */
        public int mo5691b() {
            return 0;
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$j */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0878j {

        /* renamed from: a */
        public final int f5014a;

        /* renamed from: b */
        public final AbstractC0878j[] f5015b;

        public AbstractC0878j(int i, AbstractC0878j... abstractC0878jArr) {
            this.f5014a = i;
            this.f5015b = abstractC0878jArr == null ? NativeCrashWriter.f4989b : abstractC0878jArr;
        }

        /* renamed from: a */
        public int mo5690a() {
            return 0;
        }

        /* renamed from: a */
        public void mo5692a(CodedOutputStream codedOutputStream) {
            codedOutputStream.m5928c(this.f5014a, 2);
            codedOutputStream.m5922e(m5693c());
            mo5689b(codedOutputStream);
            for (AbstractC0878j abstractC0878j : this.f5015b) {
                abstractC0878j.mo5692a(codedOutputStream);
            }
        }

        /* renamed from: b */
        public int mo5691b() {
            int m5693c = m5693c();
            return m5693c + CodedOutputStream.m5914j(m5693c) + CodedOutputStream.m5912l(this.f5014a);
        }

        /* renamed from: b */
        public void mo5689b(CodedOutputStream codedOutputStream) {
        }

        /* renamed from: c */
        public int m5693c() {
            int mo5690a = mo5690a();
            for (AbstractC0878j abstractC0878j : this.f5015b) {
                mo5690a += abstractC0878j.mo5691b();
            }
            return mo5690a;
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$k */
    /* loaded from: classes.dex */
    public static final class C0879k extends AbstractC0878j {

        /* renamed from: c */
        public final AbstractC0878j[] f5016c;

        public C0879k(AbstractC0878j... abstractC0878jArr) {
            super(0, new AbstractC0878j[0]);
            this.f5016c = abstractC0878jArr;
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: a */
        public void mo5692a(CodedOutputStream codedOutputStream) {
            for (AbstractC0878j abstractC0878j : this.f5016c) {
                abstractC0878j.mo5692a(codedOutputStream);
            }
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: b */
        public int mo5691b() {
            int i = 0;
            for (AbstractC0878j abstractC0878j : this.f5016c) {
                i += abstractC0878j.mo5691b();
            }
            return i;
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$l */
    /* loaded from: classes.dex */
    public static final class C0880l extends AbstractC0878j {

        /* renamed from: c */
        public final String f5017c;

        /* renamed from: d */
        public final String f5018d;

        /* renamed from: e */
        public final long f5019e;

        public C0880l(SignalData signalData) {
            super(3, new AbstractC0878j[0]);
            this.f5017c = signalData.f4949a;
            this.f5018d = signalData.f4950b;
            this.f5019e = signalData.f4951c;
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: a */
        public int mo5690a() {
            return CodedOutputStream.m5935b(1, ByteString.m5973a(this.f5017c)) + CodedOutputStream.m5935b(2, ByteString.m5973a(this.f5018d)) + CodedOutputStream.m5936b(3, this.f5019e);
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: b */
        public void mo5689b(CodedOutputStream codedOutputStream) {
            codedOutputStream.m5950a(1, ByteString.m5973a(this.f5017c));
            codedOutputStream.m5950a(2, ByteString.m5973a(this.f5018d));
            codedOutputStream.m5951a(3, this.f5019e);
        }
    }

    /* compiled from: NativeCrashWriter.java */
    /* renamed from: c.b.a.d.z$m */
    /* loaded from: classes.dex */
    public static final class C0881m extends AbstractC0878j {

        /* renamed from: c */
        public final String f5020c;

        /* renamed from: d */
        public final int f5021d;

        public C0881m(ThreadData threadData, C0879k c0879k) {
            super(1, c0879k);
            this.f5020c = threadData.f4952a;
            this.f5021d = threadData.f4953b;
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: a */
        public int mo5690a() {
            return CodedOutputStream.m5917g(2, this.f5021d) + (m5688d() ? CodedOutputStream.m5935b(1, ByteString.m5973a(this.f5020c)) : 0);
        }

        @Override // p070c.p074b.p075a.p078d.NativeCrashWriter.AbstractC0878j
        /* renamed from: b */
        public void mo5689b(CodedOutputStream codedOutputStream) {
            if (m5688d()) {
                codedOutputStream.m5950a(1, ByteString.m5973a(this.f5020c));
            }
            codedOutputStream.m5924d(2, this.f5021d);
        }

        /* renamed from: d */
        public final boolean m5688d() {
            String str = this.f5020c;
            return str != null && str.length() > 0;
        }
    }

    /* renamed from: a */
    public static C0873e m5700a(SessionEventData sessionEventData, LogFileManager logFileManager, Map<String, String> map) {
        SignalData signalData = sessionEventData.f4944b;
        if (signalData == null) {
            signalData = f4988a;
        }
        C0869a c0869a = new C0869a(new C0874f(new C0880l(signalData), m5694a(sessionEventData.f4945c), m5698a(sessionEventData.f4946d)), m5697a(m5696a(sessionEventData.f4947e, map)));
        AbstractC0878j m5701a = m5701a(sessionEventData.f4948f);
        ByteString m5720b = logFileManager.m5720b();
        if (m5720b == null) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "No log data to include with this event.");
        }
        logFileManager.m5726a();
        return new C0873e(sessionEventData.f4943a, "ndk-crash", c0869a, m5701a, m5720b != null ? new C0876h(m5720b) : new C0877i());
    }

    /* renamed from: a */
    public static CustomAttributeData[] m5696a(CustomAttributeData[] customAttributeDataArr, Map<String, String> map) {
        TreeMap treeMap = new TreeMap(map);
        if (customAttributeDataArr != null) {
            for (CustomAttributeData customAttributeData : customAttributeDataArr) {
                treeMap.put(customAttributeData.f4933a, customAttributeData.f4934b);
            }
        }
        Map.Entry[] entryArr = (Map.Entry[]) treeMap.entrySet().toArray(new Map.Entry[treeMap.size()]);
        CustomAttributeData[] customAttributeDataArr2 = new CustomAttributeData[entryArr.length];
        for (int i = 0; i < customAttributeDataArr2.length; i++) {
            customAttributeDataArr2[i] = new CustomAttributeData((String) entryArr[i].getKey(), (String) entryArr[i].getValue());
        }
        return customAttributeDataArr2;
    }

    /* renamed from: a */
    public static AbstractC0878j m5701a(DeviceData deviceData) {
        if (deviceData == null) {
            return new C0877i();
        }
        return new C0872d(deviceData.f4940f / 100.0f, deviceData.f4941g, deviceData.f4942h, deviceData.f4935a, deviceData.f4936b - deviceData.f4938d, deviceData.f4937c - deviceData.f4939e);
    }

    /* renamed from: a */
    public static C0879k m5694a(ThreadData[] threadDataArr) {
        C0881m[] c0881mArr = threadDataArr != null ? new C0881m[threadDataArr.length] : f4990c;
        for (int i = 0; i < c0881mArr.length; i++) {
            ThreadData threadData = threadDataArr[i];
            c0881mArr[i] = new C0881m(threadData, m5695a(threadData.f4954c));
        }
        return new C0879k(c0881mArr);
    }

    /* renamed from: a */
    public static C0879k m5695a(ThreadData.C0862a[] c0862aArr) {
        C0875g[] c0875gArr = c0862aArr != null ? new C0875g[c0862aArr.length] : f4991d;
        for (int i = 0; i < c0875gArr.length; i++) {
            c0875gArr[i] = new C0875g(c0862aArr[i]);
        }
        return new C0879k(c0875gArr);
    }

    /* renamed from: a */
    public static C0879k m5698a(BinaryImageData[] binaryImageDataArr) {
        C0870b[] c0870bArr = binaryImageDataArr != null ? new C0870b[binaryImageDataArr.length] : f4992e;
        for (int i = 0; i < c0870bArr.length; i++) {
            c0870bArr[i] = new C0870b(binaryImageDataArr[i]);
        }
        return new C0879k(c0870bArr);
    }

    /* renamed from: a */
    public static C0879k m5697a(CustomAttributeData[] customAttributeDataArr) {
        C0871c[] c0871cArr = customAttributeDataArr != null ? new C0871c[customAttributeDataArr.length] : f4993f;
        for (int i = 0; i < c0871cArr.length; i++) {
            c0871cArr[i] = new C0871c(customAttributeDataArr[i]);
        }
        return new C0879k(c0871cArr);
    }

    /* renamed from: a */
    public static void m5699a(SessionEventData sessionEventData, LogFileManager logFileManager, Map<String, String> map, CodedOutputStream codedOutputStream) {
        m5700a(sessionEventData, logFileManager, map).mo5692a(codedOutputStream);
    }
}
