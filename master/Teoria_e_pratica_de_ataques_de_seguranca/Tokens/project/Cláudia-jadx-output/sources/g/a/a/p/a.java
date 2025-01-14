package g.a.a.p;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;
/* compiled from: ProcessUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f6216a;

    public a(Context context) {
        this.f6216a = context;
    }

    public String a() {
        return this.f6216a.getApplicationContext().getPackageName();
    }

    public int b() {
        return Process.myPid();
    }

    public String c() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f6216a.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == b()) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return null;
    }

    public boolean d() {
        return a().equals(c());
    }
}
