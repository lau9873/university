package p070c.p115g.p116a.p117a.p118a;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.spirtech.android.hce.calypso.AlarmReceiver;
import com.spirtech.android.hce.calypso.SyncJobService;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.C1373d;
import p070c.p115g.p128c.p129a.p130a.C1423a;

/* renamed from: c.g.a.a.a.b */
/* loaded from: classes.dex */
public class C1369b {
    /* renamed from: a */
    public static void m4640a(int i, long j, Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            m4637c(i, j - System.currentTimeMillis(), context);
        } else {
            m4638b(i, j, context);
        }
    }

    /* renamed from: a */
    public static void m4639a(Context context, boolean z) {
        if (!z) {
            m4640a(1, System.currentTimeMillis() + 420000, context);
            return;
        }
        try {
            C1373d.AbstractC1382c.m4559a(C1373d.EnumC1384d.AUTOSYNCRHONIZATION).mo4560a(context, new JSONObject(), 325, -1, new Object[0]).mo4587a(C1373d.m4616a(context));
        } catch (Exception e) {
            C1423a.m4477a("tryToSync", C1369b.class, e);
        }
    }

    /* renamed from: b */
    public static void m4638b(int i, long j, Context context) {
        Intent intent = new Intent(context.getApplicationContext(), AlarmReceiver.class);
        intent.putExtra("id_alarm", i);
        AlarmManager alarmManager = (AlarmManager) context.getApplicationContext().getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(context.getApplicationContext(), i, intent, 134217728);
        if (alarmManager != null) {
            try {
                alarmManager.set(0, j, broadcast);
            } catch (Exception e) {
                C1423a.m4477a("setAlarm", C1369b.class, e);
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: c */
    public static void m4637c(int i, long j, Context context) {
        SyncJobService syncJobService;
        if (i == 1 && (syncJobService = SyncJobService.f6356b) != null) {
            syncJobService.jobFinished(SyncJobService.f6355a, false);
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        JobInfo.Builder minimumLatency = new JobInfo.Builder(i, new ComponentName(context.getPackageName(), SyncJobService.class.getName())).setPersisted(true).setMinimumLatency(j);
        if (i == 1) {
            minimumLatency.setRequiredNetworkType(1);
        }
        if (jobScheduler != null) {
            jobScheduler.schedule(minimumLatency.build());
        }
    }
}
