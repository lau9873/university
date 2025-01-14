package p205h.p206a.p207a;

import android.util.Log;
import java.lang.Thread;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.a.a.m */
/* loaded from: classes.dex */
public class CustomUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public Thread.UncaughtExceptionHandler f9234a = Thread.getDefaultUncaughtExceptionHandler();

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            SharedPrefsController.m1540d().m1547a(true);
            String stackTraceString = Log.getStackTraceString(th);
            if (Consuela.m1790k().m1802e() != null) {
                SharedPrefsController.m1540d().m1549a(new DataModels.C2699h(Consuela.m1790k().m1802e().getId(), null, Boolean.FALSE, null, DataModels.C2699h.f10802k, SysDateManager.m1497d().m1496e(), stackTraceString, null));
            }
            AppLog.m2157a("LIB", App.CLASSNAME, "CRASH!", stackTraceString, false);
        } catch (Throwable unused) {
        }
        this.f9234a.uncaughtException(thread, th);
    }
}
