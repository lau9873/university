package c.b.a.d;

import android.app.ActivityManager;
import android.os.Build;
import d.a.a.a.m.b.o;
import java.util.List;
import java.util.Map;
/* compiled from: SessionProtobufHelper.java */
/* loaded from: classes.dex */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final b f3016a = b.a("0");

    /* renamed from: b  reason: collision with root package name */
    public static final b f3017b = b.a("Unity");

    public static void a(e eVar, String str, String str2, long j) {
        eVar.a(1, b.a(str2));
        eVar.a(2, b.a(str));
        eVar.a(3, j);
    }

    public static int b(b bVar) {
        return e.b(1, bVar) + 0;
    }

    public static void a(e eVar, String str, String str2, String str3, String str4, String str5, int i2, String str6) {
        b a2 = b.a(str);
        b a3 = b.a(str2);
        b a4 = b.a(str3);
        b a5 = b.a(str4);
        b a6 = b.a(str5);
        b a7 = str6 != null ? b.a(str6) : null;
        eVar.c(7, 2);
        eVar.e(a(a2, a3, a4, a5, a6, i2, a7));
        eVar.a(1, a2);
        eVar.a(2, a4);
        eVar.a(3, a5);
        eVar.c(5, 2);
        eVar.e(b(a3));
        eVar.a(1, a3);
        eVar.a(6, a6);
        if (a7 != null) {
            eVar.a(8, f3017b);
            eVar.a(9, a7);
        }
        eVar.a(10, i2);
    }

    public static void a(e eVar, boolean z) {
        b a2 = b.a(Build.VERSION.RELEASE);
        b a3 = b.a(Build.VERSION.CODENAME);
        eVar.c(8, 2);
        eVar.e(a(a2, a3, z));
        eVar.a(1, 3);
        eVar.a(2, a2);
        eVar.a(3, a3);
        eVar.a(4, z);
    }

    public static void a(e eVar, String str, int i2, String str2, int i3, long j, long j2, boolean z, Map<o.a, String> map, int i4, String str3, String str4) {
        b a2 = b.a(str);
        b a3 = a(str2);
        b a4 = a(str4);
        b a5 = a(str3);
        eVar.c(9, 2);
        eVar.e(a(i2, a2, a3, i3, j, j2, z, map, i4, a5, a4));
        eVar.a(1, a2);
        eVar.a(3, i2);
        eVar.a(4, a3);
        eVar.d(5, i3);
        eVar.a(6, j);
        eVar.a(7, j2);
        eVar.a(10, z);
        for (Map.Entry<o.a, String> entry : map.entrySet()) {
            eVar.c(11, 2);
            eVar.e(a(entry.getKey(), entry.getValue()));
            eVar.a(1, entry.getKey().f4287a);
            eVar.a(2, b.a(entry.getValue()));
        }
        eVar.d(12, i4);
        if (a5 != null) {
            eVar.a(13, a5);
        }
        if (a4 != null) {
            eVar.a(14, a4);
        }
    }

    public static void a(e eVar, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        b a2 = b.a(str);
        b a3 = a(str2);
        b a4 = a(str3);
        int b2 = e.b(1, a2) + 0;
        if (str2 != null) {
            b2 += e.b(2, a3);
        }
        if (str3 != null) {
            b2 += e.b(3, a4);
        }
        eVar.c(6, 2);
        eVar.e(b2);
        eVar.a(1, a2);
        if (str2 != null) {
            eVar.a(2, a3);
        }
        if (str3 != null) {
            eVar.a(3, a4);
        }
    }

    public static void a(e eVar, long j, String str, j0 j0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, u uVar, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, String str2, String str3, Float f2, int i3, boolean z, long j2, long j3) {
        b a2 = b.a(str2);
        b a3 = str3 == null ? null : b.a(str3.replace("-", ""));
        b b2 = uVar.b();
        if (b2 == null) {
            d.a.a.a.c.h().e("CrashlyticsCore", "No log data to include with this event.");
        }
        uVar.a();
        eVar.c(10, 2);
        eVar.e(a(j, str, j0Var, thread, stackTraceElementArr, threadArr, list, 8, map, runningAppProcessInfo, i2, a2, a3, f2, i3, z, j2, j3, b2));
        eVar.a(1, j);
        eVar.a(2, b.a(str));
        a(eVar, j0Var, thread, stackTraceElementArr, threadArr, list, 8, a2, a3, map, runningAppProcessInfo, i2);
        a(eVar, f2, i3, z, i2, j2, j3);
        a(eVar, b2);
    }

    public static void a(e eVar, j0 j0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i2, b bVar, b bVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i3) {
        eVar.c(3, 2);
        eVar.e(a(j0Var, thread, stackTraceElementArr, threadArr, list, i2, bVar, bVar2, map, runningAppProcessInfo, i3));
        a(eVar, j0Var, thread, stackTraceElementArr, threadArr, list, i2, bVar, bVar2);
        if (map != null && !map.isEmpty()) {
            a(eVar, map);
        }
        if (runningAppProcessInfo != null) {
            eVar.a(3, runningAppProcessInfo.importance != 100);
        }
        eVar.d(4, i3);
    }

    public static void a(e eVar, j0 j0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i2, b bVar, b bVar2) {
        eVar.c(1, 2);
        eVar.e(a(j0Var, thread, stackTraceElementArr, threadArr, list, i2, bVar, bVar2));
        a(eVar, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            a(eVar, threadArr[i3], list.get(i3), 0, false);
        }
        a(eVar, j0Var, 1, i2, 2);
        eVar.c(3, 2);
        eVar.e(a());
        eVar.a(1, f3016a);
        eVar.a(2, f3016a);
        eVar.a(3, 0L);
        eVar.c(4, 2);
        eVar.e(a(bVar, bVar2));
        eVar.a(1, 0L);
        eVar.a(2, 0L);
        eVar.a(3, bVar);
        if (bVar2 != null) {
            eVar.a(4, bVar2);
        }
    }

    public static void a(e eVar, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            eVar.c(2, 2);
            eVar.e(a(entry.getKey(), entry.getValue()));
            eVar.a(1, b.a(entry.getKey()));
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            eVar.a(2, b.a(value));
        }
    }

    public static void a(e eVar, j0 j0Var, int i2, int i3, int i4) {
        eVar.c(i4, 2);
        eVar.e(a(j0Var, 1, i3));
        eVar.a(1, b.a(j0Var.f3077b));
        String str = j0Var.f3076a;
        if (str != null) {
            eVar.a(3, b.a(str));
        }
        int i5 = 0;
        for (StackTraceElement stackTraceElement : j0Var.f3078c) {
            a(eVar, 4, stackTraceElement, true);
        }
        j0 j0Var2 = j0Var.f3079d;
        if (j0Var2 != null) {
            if (i2 < i3) {
                a(eVar, j0Var2, i2 + 1, i3, 6);
                return;
            }
            while (j0Var2 != null) {
                j0Var2 = j0Var2.f3079d;
                i5++;
            }
            eVar.d(7, i5);
        }
    }

    public static void a(e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, int i2, boolean z) {
        eVar.c(1, 2);
        eVar.e(a(thread, stackTraceElementArr, i2, z));
        eVar.a(1, b.a(thread.getName()));
        eVar.d(2, i2);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            a(eVar, 3, stackTraceElement, z);
        }
    }

    public static void a(e eVar, int i2, StackTraceElement stackTraceElement, boolean z) {
        eVar.c(i2, 2);
        eVar.e(a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            eVar.a(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            eVar.a(1, 0L);
        }
        eVar.a(2, b.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            eVar.a(3, b.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            eVar.a(4, stackTraceElement.getLineNumber());
        }
        eVar.d(5, z ? 4 : 0);
    }

    public static void a(e eVar, Float f2, int i2, boolean z, int i3, long j, long j2) {
        eVar.c(5, 2);
        eVar.e(a(f2, i2, z, i3, j, j2));
        if (f2 != null) {
            eVar.a(1, f2.floatValue());
        }
        eVar.b(2, i2);
        eVar.a(3, z);
        eVar.d(4, i3);
        eVar.a(5, j);
        eVar.a(6, j2);
    }

    public static void a(e eVar, b bVar) {
        if (bVar != null) {
            eVar.c(6, 2);
            eVar.e(a(bVar));
            eVar.a(1, bVar);
        }
    }

    public static int a(b bVar, b bVar2, b bVar3, b bVar4, b bVar5, int i2, b bVar6) {
        int b2 = b(bVar2);
        int b3 = e.b(1, bVar) + 0 + e.b(2, bVar3) + e.b(3, bVar4) + e.l(5) + e.j(b2) + b2 + e.b(6, bVar5);
        if (bVar6 != null) {
            b3 = b3 + e.b(8, f3017b) + e.b(9, bVar6);
        }
        return b3 + e.e(10, i2);
    }

    public static int a(b bVar, b bVar2, boolean z) {
        return e.e(1, 3) + 0 + e.b(2, bVar) + e.b(3, bVar2) + e.b(4, z);
    }

    public static int a(o.a aVar, String str) {
        return e.e(1, aVar.f4287a) + e.b(2, b.a(str));
    }

    public static int a(int i2, b bVar, b bVar2, int i3, long j, long j2, boolean z, Map<o.a, String> map, int i4, b bVar3, b bVar4) {
        int b2 = e.b(1, bVar) + 0 + e.e(3, i2) + (bVar2 == null ? 0 : e.b(4, bVar2)) + e.g(5, i3) + e.b(6, j) + e.b(7, j2) + e.b(10, z);
        if (map != null) {
            for (Map.Entry<o.a, String> entry : map.entrySet()) {
                int a2 = a(entry.getKey(), entry.getValue());
                b2 += e.l(11) + e.j(a2) + a2;
            }
        }
        return b2 + e.g(12, i4) + (bVar3 == null ? 0 : e.b(13, bVar3)) + (bVar4 != null ? e.b(14, bVar4) : 0);
    }

    public static int a(b bVar, b bVar2) {
        int b2 = e.b(1, 0L) + 0 + e.b(2, 0L) + e.b(3, bVar);
        return bVar2 != null ? b2 + e.b(4, bVar2) : b2;
    }

    public static int a(long j, String str, j0 j0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i3, b bVar, b bVar2, Float f2, int i4, boolean z, long j2, long j3, b bVar3) {
        int b2 = e.b(1, j) + 0 + e.b(2, b.a(str));
        int a2 = a(j0Var, thread, stackTraceElementArr, threadArr, list, i2, bVar, bVar2, map, runningAppProcessInfo, i3);
        int a3 = a(f2, i4, z, i3, j2, j3);
        int l = b2 + e.l(3) + e.j(a2) + a2 + e.l(5) + e.j(a3) + a3;
        if (bVar3 != null) {
            int a4 = a(bVar3);
            return l + e.l(6) + e.j(a4) + a4;
        }
        return l;
    }

    public static int a(j0 j0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i2, b bVar, b bVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i3) {
        int a2 = a(j0Var, thread, stackTraceElementArr, threadArr, list, i2, bVar, bVar2);
        int l = e.l(1) + e.j(a2) + a2 + 0;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int a3 = a(entry.getKey(), entry.getValue());
                l += e.l(2) + e.j(a3) + a3;
            }
        }
        if (runningAppProcessInfo != null) {
            l += e.b(3, runningAppProcessInfo.importance != 100);
        }
        return l + e.g(4, i3);
    }

    public static int a(j0 j0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i2, b bVar, b bVar2) {
        int a2 = a(thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        int l = e.l(1) + e.j(a2) + a2 + 0;
        for (int i3 = 0; i3 < length; i3++) {
            int a3 = a(threadArr[i3], list.get(i3), 0, false);
            l += e.l(1) + e.j(a3) + a3;
        }
        int a4 = a(j0Var, 1, i2);
        int a5 = a();
        int a6 = a(bVar, bVar2);
        return l + e.l(2) + e.j(a4) + a4 + e.l(3) + e.j(a5) + a5 + e.l(3) + e.j(a6) + a6;
    }

    public static int a(String str, String str2) {
        int b2 = e.b(1, b.a(str));
        if (str2 == null) {
            str2 = "";
        }
        return b2 + e.b(2, b.a(str2));
    }

    public static int a(Float f2, int i2, boolean z, int i3, long j, long j2) {
        return (f2 != null ? 0 + e.b(1, f2.floatValue()) : 0) + e.f(2, i2) + e.b(3, z) + e.g(4, i3) + e.b(5, j) + e.b(6, j2);
    }

    public static int a(b bVar) {
        return e.b(1, bVar);
    }

    public static int a(j0 j0Var, int i2, int i3) {
        int i4 = 0;
        int b2 = e.b(1, b.a(j0Var.f3077b)) + 0;
        String str = j0Var.f3076a;
        if (str != null) {
            b2 += e.b(3, b.a(str));
        }
        int i5 = b2;
        for (StackTraceElement stackTraceElement : j0Var.f3078c) {
            int a2 = a(stackTraceElement, true);
            i5 += e.l(4) + e.j(a2) + a2;
        }
        j0 j0Var2 = j0Var.f3079d;
        if (j0Var2 != null) {
            if (i2 < i3) {
                int a3 = a(j0Var2, i2 + 1, i3);
                return i5 + e.l(6) + e.j(a3) + a3;
            }
            while (j0Var2 != null) {
                j0Var2 = j0Var2.f3079d;
                i4++;
            }
            return i5 + e.g(7, i4);
        }
        return i5;
    }

    public static int a() {
        return e.b(1, f3016a) + 0 + e.b(2, f3016a) + e.b(3, 0L);
    }

    public static int a(StackTraceElement stackTraceElement, boolean z) {
        int b2;
        if (stackTraceElement.isNativeMethod()) {
            b2 = e.b(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            b2 = e.b(1, 0L);
        }
        int b3 = b2 + 0 + e.b(2, b.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            b3 += e.b(3, b.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            b3 += e.b(4, stackTraceElement.getLineNumber());
        }
        return b3 + e.g(5, z ? 2 : 0);
    }

    public static int a(Thread thread, StackTraceElement[] stackTraceElementArr, int i2, boolean z) {
        int b2 = e.b(1, b.a(thread.getName())) + e.g(2, i2);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int a2 = a(stackTraceElement, z);
            b2 += e.l(3) + e.j(a2) + a2;
        }
        return b2;
    }

    public static b a(String str) {
        if (str == null) {
            return null;
        }
        return b.a(str);
    }
}
