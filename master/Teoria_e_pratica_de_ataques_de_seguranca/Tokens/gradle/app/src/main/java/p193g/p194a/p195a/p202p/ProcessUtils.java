package p193g.p194a.p195a.p202p;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;

/* renamed from: g.a.a.p.a */
/* loaded from: classes.dex */
public class ProcessUtils {

    /* renamed from: a */
    public Context f8707a;

    public ProcessUtils(Context context) {
        this.f8707a = context;
    }

    /* renamed from: a */
    public String m2237a() {
        return this.f8707a.getApplicationContext().getPackageName();
    }

    /* renamed from: b */
    public int m2236b() {
        return Process.myPid();
    }

    /* renamed from: c */
    public String m2235c() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f8707a.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == m2236b()) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: d */
    public boolean m2234d() {
        return m2237a().equals(m2235c());
    }
}
