package d.a.a.a.m.d;

import android.content.Context;
/* compiled from: TimeBasedFileRollOverRunnable.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4371a;

    /* renamed from: b  reason: collision with root package name */
    public final e f4372b;

    public i(Context context, e eVar) {
        this.f4371a = context;
        this.f4372b = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            d.a.a.a.m.b.i.c(this.f4371a, "Performing time based file roll over.");
            if (this.f4372b.b()) {
                return;
            }
            this.f4372b.c();
        } catch (Exception e2) {
            d.a.a.a.m.b.i.a(this.f4371a, "Failed to roll over file", e2);
        }
    }
}
