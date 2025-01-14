package h.a.a;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
/* compiled from: L.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6848a = false;

    /* renamed from: b  reason: collision with root package name */
    public static Method f6849b;

    public static void a(String str) {
        Log.e("JaaleeSDK", a() + str);
        c(str);
    }

    public static void b(String str) {
        String str2 = a() + str;
        Log.i("JaaleeSDK", str2);
        c(str2);
    }

    public static void c(String str) {
        if (f6848a) {
            try {
                Method method = f6849b;
                method.invoke(null, a() + str);
            } catch (Exception unused) {
            }
        }
    }

    public static void d(String str) {
        String str2 = a() + str;
        Log.wtf("JaaleeSDK", str2);
        c(str2);
    }

    public static void a(String str, Throwable th) {
        Log.e("JaaleeSDK", a() + str, th);
        c(str + " " + a(th));
    }

    public static String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String className = stackTrace[4].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[4].getMethodName();
        int lineNumber = stackTrace[4].getLineNumber();
        return className + "." + methodName + ":" + lineNumber + " ";
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
