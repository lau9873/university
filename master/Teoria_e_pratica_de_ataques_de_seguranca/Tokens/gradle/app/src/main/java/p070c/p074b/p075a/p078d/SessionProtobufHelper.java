package p070c.p074b.p075a.p078d;

import android.app.ActivityManager;
import android.os.Build;
import java.util.List;
import java.util.Map;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;

/* renamed from: c.b.a.d.g0 */
/* loaded from: classes.dex */
public class SessionProtobufHelper {

    /* renamed from: a */
    public static final ByteString f4829a = ByteString.m5973a("0");

    /* renamed from: b */
    public static final ByteString f4830b = ByteString.m5973a("Unity");

    /* renamed from: a */
    public static void m5875a(CodedOutputStream codedOutputStream, String str, String str2, long j) {
        codedOutputStream.m5950a(1, ByteString.m5973a(str2));
        codedOutputStream.m5950a(2, ByteString.m5973a(str));
        codedOutputStream.m5951a(3, j);
    }

    /* renamed from: b */
    public static int m5860b(ByteString byteString) {
        return CodedOutputStream.m5935b(1, byteString) + 0;
    }

    /* renamed from: a */
    public static void m5873a(CodedOutputStream codedOutputStream, String str, String str2, String str3, String str4, String str5, int i, String str6) {
        ByteString m5973a = ByteString.m5973a(str);
        ByteString m5973a2 = ByteString.m5973a(str2);
        ByteString m5973a3 = ByteString.m5973a(str3);
        ByteString m5973a4 = ByteString.m5973a(str4);
        ByteString m5973a5 = ByteString.m5973a(str5);
        ByteString m5973a6 = str6 != null ? ByteString.m5973a(str6) : null;
        codedOutputStream.m5928c(7, 2);
        codedOutputStream.m5922e(m5885a(m5973a, m5973a2, m5973a3, m5973a4, m5973a5, i, m5973a6));
        codedOutputStream.m5950a(1, m5973a);
        codedOutputStream.m5950a(2, m5973a3);
        codedOutputStream.m5950a(3, m5973a4);
        codedOutputStream.m5928c(5, 2);
        codedOutputStream.m5922e(m5860b(m5973a2));
        codedOutputStream.m5950a(1, m5973a2);
        codedOutputStream.m5950a(6, m5973a5);
        if (m5973a6 != null) {
            codedOutputStream.m5950a(8, f4830b);
            codedOutputStream.m5950a(9, m5973a6);
        }
        codedOutputStream.m5952a(10, i);
    }

    /* renamed from: a */
    public static void m5870a(CodedOutputStream codedOutputStream, boolean z) {
        ByteString m5973a = ByteString.m5973a(Build.VERSION.RELEASE);
        ByteString m5973a2 = ByteString.m5973a(Build.VERSION.CODENAME);
        codedOutputStream.m5928c(8, 2);
        codedOutputStream.m5922e(m5884a(m5973a, m5973a2, z));
        codedOutputStream.m5952a(1, 3);
        codedOutputStream.m5950a(2, m5973a);
        codedOutputStream.m5950a(3, m5973a2);
        codedOutputStream.m5949a(4, z);
    }

    /* renamed from: a */
    public static void m5876a(CodedOutputStream codedOutputStream, String str, int i, String str2, int i2, long j, long j2, boolean z, Map<IdManager.EnumC1497a, String> map, int i3, String str3, String str4) {
        ByteString m5973a = ByteString.m5973a(str);
        ByteString m5863a = m5863a(str2);
        ByteString m5863a2 = m5863a(str4);
        ByteString m5863a3 = m5863a(str3);
        codedOutputStream.m5928c(9, 2);
        codedOutputStream.m5922e(m5889a(i, m5973a, m5863a, i2, j, j2, z, map, i3, m5863a3, m5863a2));
        codedOutputStream.m5950a(1, m5973a);
        codedOutputStream.m5952a(3, i);
        codedOutputStream.m5950a(4, m5863a);
        codedOutputStream.m5924d(5, i2);
        codedOutputStream.m5951a(6, j);
        codedOutputStream.m5951a(7, j2);
        codedOutputStream.m5949a(10, z);
        for (Map.Entry<IdManager.EnumC1497a, String> entry : map.entrySet()) {
            codedOutputStream.m5928c(11, 2);
            codedOutputStream.m5922e(m5866a(entry.getKey(), entry.getValue()));
            codedOutputStream.m5952a(1, entry.getKey().f6486a);
            codedOutputStream.m5950a(2, ByteString.m5973a(entry.getValue()));
        }
        codedOutputStream.m5924d(12, i3);
        if (m5863a3 != null) {
            codedOutputStream.m5950a(13, m5863a3);
        }
        if (m5863a2 != null) {
            codedOutputStream.m5950a(14, m5863a2);
        }
    }

    /* renamed from: a */
    public static void m5874a(CodedOutputStream codedOutputStream, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        ByteString m5973a = ByteString.m5973a(str);
        ByteString m5863a = m5863a(str2);
        ByteString m5863a2 = m5863a(str3);
        int m5935b = CodedOutputStream.m5935b(1, m5973a) + 0;
        if (str2 != null) {
            m5935b += CodedOutputStream.m5935b(2, m5863a);
        }
        if (str3 != null) {
            m5935b += CodedOutputStream.m5935b(3, m5863a2);
        }
        codedOutputStream.m5928c(6, 2);
        codedOutputStream.m5922e(m5935b);
        codedOutputStream.m5950a(1, m5973a);
        if (str2 != null) {
            codedOutputStream.m5950a(2, m5863a);
        }
        if (str3 != null) {
            codedOutputStream.m5950a(3, m5863a2);
        }
    }

    /* renamed from: a */
    public static void m5882a(CodedOutputStream codedOutputStream, long j, String str, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, LogFileManager logFileManager, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, Float f, int i2, boolean z, long j2, long j3) {
        ByteString m5973a = ByteString.m5973a(str2);
        ByteString m5973a2 = str3 == null ? null : ByteString.m5973a(str3.replace("-", ""));
        ByteString m5720b = logFileManager.m5720b();
        if (m5720b == null) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "No log data to include with this event.");
        }
        logFileManager.m5726a();
        codedOutputStream.m5928c(10, 2);
        codedOutputStream.m5922e(m5888a(j, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, 8, map, runningAppProcessInfo, i, m5973a, m5973a2, f, i2, z, j2, j3, m5720b));
        codedOutputStream.m5951a(1, j);
        codedOutputStream.m5950a(2, ByteString.m5973a(str));
        m5878a(codedOutputStream, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, 8, m5973a, m5973a2, map, runningAppProcessInfo, i);
        m5877a(codedOutputStream, f, i2, z, i, j2, j3);
        m5881a(codedOutputStream, m5720b);
    }

    /* renamed from: a */
    public static void m5878a(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        codedOutputStream.m5928c(3, 2);
        codedOutputStream.m5922e(m5867a(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2, map, runningAppProcessInfo, i2));
        m5879a(codedOutputStream, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2);
        if (map != null && !map.isEmpty()) {
            m5871a(codedOutputStream, map);
        }
        if (runningAppProcessInfo != null) {
            codedOutputStream.m5949a(3, runningAppProcessInfo.importance != 100);
        }
        codedOutputStream.m5924d(4, i2);
    }

    /* renamed from: a */
    public static void m5879a(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2) {
        codedOutputStream.m5928c(1, 2);
        codedOutputStream.m5922e(m5868a(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2));
        m5872a(codedOutputStream, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            m5872a(codedOutputStream, threadArr[i2], list.get(i2), 0, false);
        }
        m5880a(codedOutputStream, trimmedThrowableData, 1, i, 2);
        codedOutputStream.m5928c(3, 2);
        codedOutputStream.m5922e(m5890a());
        codedOutputStream.m5950a(1, f4829a);
        codedOutputStream.m5950a(2, f4829a);
        codedOutputStream.m5951a(3, 0L);
        codedOutputStream.m5928c(4, 2);
        codedOutputStream.m5922e(m5886a(byteString, byteString2));
        codedOutputStream.m5951a(1, 0L);
        codedOutputStream.m5951a(2, 0L);
        codedOutputStream.m5950a(3, byteString);
        if (byteString2 != null) {
            codedOutputStream.m5950a(4, byteString2);
        }
    }

    /* renamed from: a */
    public static void m5871a(CodedOutputStream codedOutputStream, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            codedOutputStream.m5928c(2, 2);
            codedOutputStream.m5922e(m5862a(entry.getKey(), entry.getValue()));
            codedOutputStream.m5950a(1, ByteString.m5973a(entry.getKey()));
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            codedOutputStream.m5950a(2, ByteString.m5973a(value));
        }
    }

    /* renamed from: a */
    public static void m5880a(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) {
        codedOutputStream.m5928c(i3, 2);
        codedOutputStream.m5922e(m5869a(trimmedThrowableData, 1, i2));
        codedOutputStream.m5950a(1, ByteString.m5973a(trimmedThrowableData.f4915b));
        String str = trimmedThrowableData.f4914a;
        if (str != null) {
            codedOutputStream.m5950a(3, ByteString.m5973a(str));
        }
        int i4 = 0;
        for (StackTraceElement stackTraceElement : trimmedThrowableData.f4916c) {
            m5883a(codedOutputStream, 4, stackTraceElement, true);
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.f4917d;
        if (trimmedThrowableData2 != null) {
            if (i < i2) {
                m5880a(codedOutputStream, trimmedThrowableData2, i + 1, i2, 6);
                return;
            }
            while (trimmedThrowableData2 != null) {
                trimmedThrowableData2 = trimmedThrowableData2.f4917d;
                i4++;
            }
            codedOutputStream.m5924d(7, i4);
        }
    }

    /* renamed from: a */
    public static void m5872a(CodedOutputStream codedOutputStream, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        codedOutputStream.m5928c(1, 2);
        codedOutputStream.m5922e(m5861a(thread, stackTraceElementArr, i, z));
        codedOutputStream.m5950a(1, ByteString.m5973a(thread.getName()));
        codedOutputStream.m5924d(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            m5883a(codedOutputStream, 3, stackTraceElement, z);
        }
    }

    /* renamed from: a */
    public static void m5883a(CodedOutputStream codedOutputStream, int i, StackTraceElement stackTraceElement, boolean z) {
        codedOutputStream.m5928c(i, 2);
        codedOutputStream.m5922e(m5864a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream.m5951a(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            codedOutputStream.m5951a(1, 0L);
        }
        codedOutputStream.m5950a(2, ByteString.m5973a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream.m5950a(3, ByteString.m5973a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream.m5951a(4, stackTraceElement.getLineNumber());
        }
        codedOutputStream.m5924d(5, z ? 4 : 0);
    }

    /* renamed from: a */
    public static void m5877a(CodedOutputStream codedOutputStream, Float f, int i, boolean z, int i2, long j, long j2) {
        codedOutputStream.m5928c(5, 2);
        codedOutputStream.m5922e(m5865a(f, i, z, i2, j, j2));
        if (f != null) {
            codedOutputStream.m5953a(1, f.floatValue());
        }
        codedOutputStream.m5937b(2, i);
        codedOutputStream.m5949a(3, z);
        codedOutputStream.m5924d(4, i2);
        codedOutputStream.m5951a(5, j);
        codedOutputStream.m5951a(6, j2);
    }

    /* renamed from: a */
    public static void m5881a(CodedOutputStream codedOutputStream, ByteString byteString) {
        if (byteString != null) {
            codedOutputStream.m5928c(6, 2);
            codedOutputStream.m5922e(m5887a(byteString));
            codedOutputStream.m5950a(1, byteString);
        }
    }

    /* renamed from: a */
    public static int m5885a(ByteString byteString, ByteString byteString2, ByteString byteString3, ByteString byteString4, ByteString byteString5, int i, ByteString byteString6) {
        int m5860b = m5860b(byteString2);
        int m5935b = CodedOutputStream.m5935b(1, byteString) + 0 + CodedOutputStream.m5935b(2, byteString3) + CodedOutputStream.m5935b(3, byteString4) + CodedOutputStream.m5912l(5) + CodedOutputStream.m5914j(m5860b) + m5860b + CodedOutputStream.m5935b(6, byteString5);
        if (byteString6 != null) {
            m5935b = m5935b + CodedOutputStream.m5935b(8, f4830b) + CodedOutputStream.m5935b(9, byteString6);
        }
        return m5935b + CodedOutputStream.m5921e(10, i);
    }

    /* renamed from: a */
    public static int m5884a(ByteString byteString, ByteString byteString2, boolean z) {
        return CodedOutputStream.m5921e(1, 3) + 0 + CodedOutputStream.m5935b(2, byteString) + CodedOutputStream.m5935b(3, byteString2) + CodedOutputStream.m5934b(4, z);
    }

    /* renamed from: a */
    public static int m5866a(IdManager.EnumC1497a enumC1497a, String str) {
        return CodedOutputStream.m5921e(1, enumC1497a.f6486a) + CodedOutputStream.m5935b(2, ByteString.m5973a(str));
    }

    /* renamed from: a */
    public static int m5889a(int i, ByteString byteString, ByteString byteString2, int i2, long j, long j2, boolean z, Map<IdManager.EnumC1497a, String> map, int i3, ByteString byteString3, ByteString byteString4) {
        int m5935b = CodedOutputStream.m5935b(1, byteString) + 0 + CodedOutputStream.m5921e(3, i) + (byteString2 == null ? 0 : CodedOutputStream.m5935b(4, byteString2)) + CodedOutputStream.m5917g(5, i2) + CodedOutputStream.m5936b(6, j) + CodedOutputStream.m5936b(7, j2) + CodedOutputStream.m5934b(10, z);
        if (map != null) {
            for (Map.Entry<IdManager.EnumC1497a, String> entry : map.entrySet()) {
                int m5866a = m5866a(entry.getKey(), entry.getValue());
                m5935b += CodedOutputStream.m5912l(11) + CodedOutputStream.m5914j(m5866a) + m5866a;
            }
        }
        return m5935b + CodedOutputStream.m5917g(12, i3) + (byteString3 == null ? 0 : CodedOutputStream.m5935b(13, byteString3)) + (byteString4 != null ? CodedOutputStream.m5935b(14, byteString4) : 0);
    }

    /* renamed from: a */
    public static int m5886a(ByteString byteString, ByteString byteString2) {
        int m5936b = CodedOutputStream.m5936b(1, 0L) + 0 + CodedOutputStream.m5936b(2, 0L) + CodedOutputStream.m5935b(3, byteString);
        return byteString2 != null ? m5936b + CodedOutputStream.m5935b(4, byteString2) : m5936b;
    }

    /* renamed from: a */
    public static int m5888a(long j, String str, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, ByteString byteString, ByteString byteString2, Float f, int i3, boolean z, long j2, long j3, ByteString byteString3) {
        int m5936b = CodedOutputStream.m5936b(1, j) + 0 + CodedOutputStream.m5935b(2, ByteString.m5973a(str));
        int m5867a = m5867a(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2, map, runningAppProcessInfo, i2);
        int m5865a = m5865a(f, i3, z, i2, j2, j3);
        int m5912l = m5936b + CodedOutputStream.m5912l(3) + CodedOutputStream.m5914j(m5867a) + m5867a + CodedOutputStream.m5912l(5) + CodedOutputStream.m5914j(m5865a) + m5865a;
        if (byteString3 != null) {
            int m5887a = m5887a(byteString3);
            return m5912l + CodedOutputStream.m5912l(6) + CodedOutputStream.m5914j(m5887a) + m5887a;
        }
        return m5912l;
    }

    /* renamed from: a */
    public static int m5867a(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int m5868a = m5868a(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2);
        int m5912l = CodedOutputStream.m5912l(1) + CodedOutputStream.m5914j(m5868a) + m5868a + 0;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int m5862a = m5862a(entry.getKey(), entry.getValue());
                m5912l += CodedOutputStream.m5912l(2) + CodedOutputStream.m5914j(m5862a) + m5862a;
            }
        }
        if (runningAppProcessInfo != null) {
            m5912l += CodedOutputStream.m5934b(3, runningAppProcessInfo.importance != 100);
        }
        return m5912l + CodedOutputStream.m5917g(4, i2);
    }

    /* renamed from: a */
    public static int m5868a(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2) {
        int m5861a = m5861a(thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        int m5912l = CodedOutputStream.m5912l(1) + CodedOutputStream.m5914j(m5861a) + m5861a + 0;
        for (int i2 = 0; i2 < length; i2++) {
            int m5861a2 = m5861a(threadArr[i2], list.get(i2), 0, false);
            m5912l += CodedOutputStream.m5912l(1) + CodedOutputStream.m5914j(m5861a2) + m5861a2;
        }
        int m5869a = m5869a(trimmedThrowableData, 1, i);
        int m5890a = m5890a();
        int m5886a = m5886a(byteString, byteString2);
        return m5912l + CodedOutputStream.m5912l(2) + CodedOutputStream.m5914j(m5869a) + m5869a + CodedOutputStream.m5912l(3) + CodedOutputStream.m5914j(m5890a) + m5890a + CodedOutputStream.m5912l(3) + CodedOutputStream.m5914j(m5886a) + m5886a;
    }

    /* renamed from: a */
    public static int m5862a(String str, String str2) {
        int m5935b = CodedOutputStream.m5935b(1, ByteString.m5973a(str));
        if (str2 == null) {
            str2 = "";
        }
        return m5935b + CodedOutputStream.m5935b(2, ByteString.m5973a(str2));
    }

    /* renamed from: a */
    public static int m5865a(Float f, int i, boolean z, int i2, long j, long j2) {
        return (f != null ? 0 + CodedOutputStream.m5938b(1, f.floatValue()) : 0) + CodedOutputStream.m5919f(2, i) + CodedOutputStream.m5934b(3, z) + CodedOutputStream.m5917g(4, i2) + CodedOutputStream.m5936b(5, j) + CodedOutputStream.m5936b(6, j2);
    }

    /* renamed from: a */
    public static int m5887a(ByteString byteString) {
        return CodedOutputStream.m5935b(1, byteString);
    }

    /* renamed from: a */
    public static int m5869a(TrimmedThrowableData trimmedThrowableData, int i, int i2) {
        int i3 = 0;
        int m5935b = CodedOutputStream.m5935b(1, ByteString.m5973a(trimmedThrowableData.f4915b)) + 0;
        String str = trimmedThrowableData.f4914a;
        if (str != null) {
            m5935b += CodedOutputStream.m5935b(3, ByteString.m5973a(str));
        }
        int i4 = m5935b;
        for (StackTraceElement stackTraceElement : trimmedThrowableData.f4916c) {
            int m5864a = m5864a(stackTraceElement, true);
            i4 += CodedOutputStream.m5912l(4) + CodedOutputStream.m5914j(m5864a) + m5864a;
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.f4917d;
        if (trimmedThrowableData2 != null) {
            if (i < i2) {
                int m5869a = m5869a(trimmedThrowableData2, i + 1, i2);
                return i4 + CodedOutputStream.m5912l(6) + CodedOutputStream.m5914j(m5869a) + m5869a;
            }
            while (trimmedThrowableData2 != null) {
                trimmedThrowableData2 = trimmedThrowableData2.f4917d;
                i3++;
            }
            return i4 + CodedOutputStream.m5917g(7, i3);
        }
        return i4;
    }

    /* renamed from: a */
    public static int m5890a() {
        return CodedOutputStream.m5935b(1, f4829a) + 0 + CodedOutputStream.m5935b(2, f4829a) + CodedOutputStream.m5936b(3, 0L);
    }

    /* renamed from: a */
    public static int m5864a(StackTraceElement stackTraceElement, boolean z) {
        int m5936b;
        if (stackTraceElement.isNativeMethod()) {
            m5936b = CodedOutputStream.m5936b(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            m5936b = CodedOutputStream.m5936b(1, 0L);
        }
        int m5935b = m5936b + 0 + CodedOutputStream.m5935b(2, ByteString.m5973a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            m5935b += CodedOutputStream.m5935b(3, ByteString.m5973a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            m5935b += CodedOutputStream.m5936b(4, stackTraceElement.getLineNumber());
        }
        return m5935b + CodedOutputStream.m5917g(5, z ? 2 : 0);
    }

    /* renamed from: a */
    public static int m5861a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int m5935b = CodedOutputStream.m5935b(1, ByteString.m5973a(thread.getName())) + CodedOutputStream.m5917g(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int m5864a = m5864a(stackTraceElement, z);
            m5935b += CodedOutputStream.m5912l(3) + CodedOutputStream.m5914j(m5864a) + m5864a;
        }
        return m5935b;
    }

    /* renamed from: a */
    public static ByteString m5863a(String str) {
        if (str == null) {
            return null;
        }
        return ByteString.m5973a(str);
    }
}
