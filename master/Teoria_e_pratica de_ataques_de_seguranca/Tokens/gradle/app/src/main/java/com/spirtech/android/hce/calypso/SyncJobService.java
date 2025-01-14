package com.spirtech.android.hce.calypso;

import android.app.job.JobParameters;
import android.app.job.JobService;
import p070c.p115g.p116a.p117a.p118a.C1369b;

/* loaded from: classes.dex */
public class SyncJobService extends JobService {

    /* renamed from: a */
    public static JobParameters f6355a;

    /* renamed from: b */
    public static SyncJobService f6356b;

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters.getJobId() == 1) {
            f6355a = jobParameters;
            f6356b = this;
            C1369b.m4639a(getApplicationContext(), true);
        }
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
