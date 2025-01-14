package p070c.p074b.p075a.p077c;

import android.annotation.TargetApi;
import android.app.Activity;
import java.util.concurrent.ExecutorService;
import p136d.p137a.p138a.p139a.ActivityLifecycleManager;

@TargetApi(14)
/* renamed from: c.b.a.c.b */
/* loaded from: classes.dex */
public class ActivityLifecycleCheckForUpdatesController extends AbstractCheckForUpdatesController {

    /* renamed from: l */
    public final ActivityLifecycleManager.AbstractC1480b f4770l = new C0811a();

    /* renamed from: m */
    public final ExecutorService f4771m;

    /* compiled from: ActivityLifecycleCheckForUpdatesController.java */
    /* renamed from: c.b.a.c.b$a */
    /* loaded from: classes.dex */
    public class C0811a extends ActivityLifecycleManager.AbstractC1480b {

        /* compiled from: ActivityLifecycleCheckForUpdatesController.java */
        /* renamed from: c.b.a.c.b$a$a */
        /* loaded from: classes.dex */
        public class RunnableC0812a implements Runnable {
            public RunnableC0812a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ActivityLifecycleCheckForUpdatesController.this.m6001a();
            }
        }

        public C0811a() {
        }

        @Override // p136d.p137a.p138a.p139a.ActivityLifecycleManager.AbstractC1480b
        /* renamed from: d */
        public void mo4192d(Activity activity) {
            if (ActivityLifecycleCheckForUpdatesController.this.m5997d()) {
                ActivityLifecycleCheckForUpdatesController.this.f4771m.submit(new RunnableC0812a());
            }
        }
    }

    public ActivityLifecycleCheckForUpdatesController(ActivityLifecycleManager activityLifecycleManager, ExecutorService executorService) {
        this.f4771m = executorService;
        activityLifecycleManager.m4229a(this.f4770l);
    }
}
