package org.altbeacon.bluetooth;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.HandlerThread;
import g.a.a.m.d;
import g.a.b.c;
/* loaded from: classes.dex */
public class BluetoothTestJob extends JobService {

    /* renamed from: c  reason: collision with root package name */
    public static final String f7633c = BluetoothTestJob.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public Handler f7634a = null;

    /* renamed from: b  reason: collision with root package name */
    public HandlerThread f7635b = null;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JobParameters f7636a;

        public a(JobParameters jobParameters) {
            this.f7636a = jobParameters;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            d.c(BluetoothTestJob.f7633c, "Bluetooth Test Job running", new Object[0]);
            int i2 = this.f7636a.getExtras().getInt("test_type");
            boolean z2 = true;
            if (i2 == 0) {
                d.a(BluetoothTestJob.f7633c, "No test specified.  Done with job.", new Object[0]);
                z = true;
            } else {
                z = false;
            }
            if ((i2 & 1) == 1) {
                d.a(BluetoothTestJob.f7633c, "Scan test specified.", new Object[0]);
                if (!c.d().b(BluetoothTestJob.this)) {
                    d.a(BluetoothTestJob.f7633c, "scan test failed", new Object[0]);
                }
                z = true;
            }
            if ((i2 & 2) == 2) {
                if (z) {
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException unused) {
                    }
                }
                d.a(BluetoothTestJob.f7633c, "Transmit test specified.", new Object[0]);
                if (!c.d().c(BluetoothTestJob.this)) {
                    d.a(BluetoothTestJob.f7633c, "transmit test failed", new Object[0]);
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                String str = BluetoothTestJob.f7633c;
                d.d(str, "Unknown test type:" + i2 + "  Exiting.", new Object[0]);
            }
            BluetoothTestJob.this.jobFinished(this.f7636a, false);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.f7635b == null) {
            this.f7635b = new HandlerThread("BluetoothTestThread");
            this.f7635b.start();
        }
        if (this.f7634a == null) {
            this.f7634a = new Handler(this.f7635b.getLooper());
        }
        this.f7634a.post(new a(jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
