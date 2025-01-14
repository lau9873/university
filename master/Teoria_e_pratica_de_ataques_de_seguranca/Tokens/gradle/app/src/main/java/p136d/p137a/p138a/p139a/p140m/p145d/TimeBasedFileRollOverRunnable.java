package p136d.p137a.p138a.p139a.p140m.p145d;

import android.content.Context;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;

/* renamed from: d.a.a.a.m.d.i */
/* loaded from: classes.dex */
public class TimeBasedFileRollOverRunnable implements Runnable {

    /* renamed from: a */
    public final Context f6575a;

    /* renamed from: b */
    public final FileRollOverManager f6576b;

    public TimeBasedFileRollOverRunnable(Context context, FileRollOverManager fileRollOverManager) {
        this.f6575a = context;
        this.f6576b = fileRollOverManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            CommonUtils.m4082c(this.f6575a, "Performing time based file roll over.");
            if (this.f6576b.mo3941b()) {
                return;
            }
            this.f6576b.mo3940c();
        } catch (Exception e) {
            CommonUtils.m4107a(this.f6575a, "Failed to roll over file", e);
        }
    }
}
