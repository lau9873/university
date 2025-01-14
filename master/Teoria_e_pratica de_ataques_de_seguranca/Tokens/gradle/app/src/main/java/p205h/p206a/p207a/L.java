package p205h.p206a.p207a;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

/* renamed from: h.a.a.q */
/* loaded from: classes.dex */
public class L {

    /* renamed from: a */
    public static boolean f9403a = false;

    /* renamed from: b */
    public static Method f9404b;

    /* renamed from: a */
    public static void m1582a(String str) {
        Log.e("JaaleeSDK", m1583a() + str);
        m1578c(str);
    }

    /* renamed from: b */
    public static void m1579b(String str) {
        String str2 = m1583a() + str;
        Log.i("JaaleeSDK", str2);
        m1578c(str2);
    }

    /* renamed from: c */
    public static void m1578c(String str) {
        if (f9403a) {
            try {
                Method method = f9404b;
                method.invoke(null, m1583a() + str);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: d */
    public static void m1577d(String str) {
        String str2 = m1583a() + str;
        Log.wtf("JaaleeSDK", str2);
        m1578c(str2);
    }

    /* renamed from: a */
    public static void m1581a(String str, Throwable th) {
        Log.e("JaaleeSDK", m1583a() + str, th);
        m1578c(str + " " + m1580a(th));
    }

    /* renamed from: a */
    public static String m1583a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String className = stackTrace[4].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[4].getMethodName();
        int lineNumber = stackTrace[4].getLineNumber();
        return className + "." + methodName + ":" + lineNumber + " ";
    }

    /* renamed from: a */
    public static String m1580a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
