package c.g.a.a.a;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import c.g.a.a.a.d;
import c.g.c.a.a.a;
import com.spirtech.android.hce.calypso.AlarmReceiver;
import com.spirtech.android.hce.calypso.SyncJobService;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static void a(int i2, long j, Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            c(i2, j - System.currentTimeMillis(), context);
        } else {
            b(i2, j, context);
        }
    }

    public static void a(Context context, boolean z) {
        if (!z) {
            a(1, System.currentTimeMillis() + 420000, context);
            return;
        }
        try {
            d.c.a(d.EnumC0077d.AUTOSYNCRHONIZATION).a(context, new JSONObject(), 325, -1, new Object[0]).a(d.a(context));
        } catch (Exception e2) {
            a.a("tryToSync", b.class, e2);
        }
    }

    public static void b(int i2, long j, Context context) {
        Intent intent = new Intent(context.getApplicationContext(), AlarmReceiver.class);
        intent.putExtra("id_alarm", i2);
        AlarmManager alarmManager = (AlarmManager) context.getApplicationContext().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(context.getApplicationContext(), i2, intent, 134217728);
        if (alarmManager != null) {
            try {
                alarmManager.set(0, j, broadcast);
            } catch (Exception e2) {
                a.a("setAlarm", b.class, e2);
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    public static void c(int i2, long j, Context context) {
        SyncJobService syncJobService;
        if (i2 == 1 && (syncJobService = SyncJobService.f4177b) != null) {
            syncJobService.jobFinished(SyncJobService.f4176a, false);
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        JobInfo.Builder minimumLatency = new JobInfo.Builder(i2, new ComponentName(context.getPackageName(), SyncJobService.class.getName())).setPersisted(true).setMinimumLatency(j);
        if (i2 == 1) {
            minimumLatency.setRequiredNetworkType(1);
        }
        if (jobScheduler != null) {
            jobScheduler.schedule(minimumLatency.build());
        }
    }
}
