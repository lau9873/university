package com.spirtech.android.hce.calypso;

import android.app.job.JobParameters;
import android.app.job.JobService;
import c.g.a.a.a.b;
/* loaded from: classes.dex */
public class SyncJobService extends JobService {

    /* renamed from: a  reason: collision with root package name */
    public static JobParameters f4176a;

    /* renamed from: b  reason: collision with root package name */
    public static SyncJobService f4177b;

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters.getJobId() == 1) {
            f4176a = jobParameters;
            f4177b = this;
            b.a(getApplicationContext(), true);
        }
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
