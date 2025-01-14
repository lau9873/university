package c.b.a.c;

import android.annotation.TargetApi;
import android.app.Activity;
import d.a.a.a.a;
import java.util.concurrent.ExecutorService;
/* compiled from: ActivityLifecycleCheckForUpdatesController.java */
@TargetApi(14)
/* loaded from: classes.dex */
public class b extends c.b.a.c.a {
    public final a.b l = new a();
    public final ExecutorService m;

    /* compiled from: ActivityLifecycleCheckForUpdatesController.java */
    /* loaded from: classes.dex */
    public class a extends a.b {

        /* compiled from: ActivityLifecycleCheckForUpdatesController.java */
        /* renamed from: c.b.a.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0055a implements Runnable {
            public RunnableC0055a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a();
            }
        }

        public a() {
        }

        @Override // d.a.a.a.a.b
        public void d(Activity activity) {
            if (b.this.d()) {
                b.this.m.submit(new RunnableC0055a());
            }
        }
    }

    public b(d.a.a.a.a aVar, ExecutorService executorService) {
        this.m = executorService;
        aVar.a(this.l);
    }
}
