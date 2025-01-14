package h.a.a;

import android.util.Log;
import java.lang.Thread;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: CustomUncaughtExceptionHandler.java */
/* loaded from: classes.dex */
public class m implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f6683a = Thread.getDefaultUncaughtExceptionHandler();

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            v.d().a(true);
            String stackTraceString = Log.getStackTraceString(th);
            if (l.k().e() != null) {
                v.d().a(new DataModels.h(l.k().e().getId(), null, Boolean.FALSE, null, DataModels.h.k, w.d().e(), stackTraceString, null));
            }
            c.a("LIB", App.CLASSNAME, "CRASH!", stackTraceString, false);
        } catch (Throwable unused) {
        }
        this.f6683a.uncaughtException(thread, th);
    }
}
