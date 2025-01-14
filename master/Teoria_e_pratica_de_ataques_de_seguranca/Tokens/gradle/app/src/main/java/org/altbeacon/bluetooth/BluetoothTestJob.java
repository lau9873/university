package org.altbeacon.bluetooth;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.HandlerThread;
import p193g.p194a.p195a.p198m.LogManager;
import p193g.p194a.p203b.BluetoothMedic;

/* loaded from: classes.dex */
public class BluetoothTestJob extends JobService {

    /* renamed from: c */
    public static final String f10650c = BluetoothTestJob.class.getSimpleName();

    /* renamed from: a */
    public Handler f10651a = null;

    /* renamed from: b */
    public HandlerThread f10652b = null;

    /* renamed from: org.altbeacon.bluetooth.BluetoothTestJob$a */
    /* loaded from: classes.dex */
    public class RunnableC2664a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ JobParameters f10653a;

        public RunnableC2664a(JobParameters jobParameters) {
            this.f10653a = jobParameters;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            LogManager.m2428c(BluetoothTestJob.f10650c, "Bluetooth Test Job running", new Object[0]);
            int i = this.f10653a.getExtras().getInt("test_type");
            boolean z2 = true;
            if (i == 0) {
                LogManager.m2432a(BluetoothTestJob.f10650c, "No test specified.  Done with job.", new Object[0]);
                z = true;
            } else {
                z = false;
            }
            if ((i & 1) == 1) {
                LogManager.m2432a(BluetoothTestJob.f10650c, "Scan test specified.", new Object[0]);
                if (!BluetoothMedic.m2197d().m2203b(BluetoothTestJob.this)) {
                    LogManager.m2432a(BluetoothTestJob.f10650c, "scan test failed", new Object[0]);
                }
                z = true;
            }
            if ((i & 2) == 2) {
                if (z) {
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException unused) {
                    }
                }
                LogManager.m2432a(BluetoothTestJob.f10650c, "Transmit test specified.", new Object[0]);
                if (!BluetoothMedic.m2197d().m2199c(BluetoothTestJob.this)) {
                    LogManager.m2432a(BluetoothTestJob.f10650c, "transmit test failed", new Object[0]);
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                String str = BluetoothTestJob.f10650c;
                LogManager.m2427d(str, "Unknown test type:" + i + "  Exiting.", new Object[0]);
            }
            BluetoothTestJob.this.jobFinished(this.f10653a, false);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.f10652b == null) {
            this.f10652b = new HandlerThread("BluetoothTestThread");
            this.f10652b.start();
        }
        if (this.f10651a == null) {
            this.f10651a = new Handler(this.f10652b.getLooper());
        }
        this.f10651a.post(new RunnableC2664a(jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
