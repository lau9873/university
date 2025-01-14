package d.a.a.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;
/* compiled from: ActivityLifecycleManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Application f4179a;

    /* renamed from: b  reason: collision with root package name */
    public C0084a f4180b;

    /* compiled from: ActivityLifecycleManager.java */
    /* renamed from: d.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0084a {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Application.ActivityLifecycleCallbacks> f4181a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        public final Application f4182b;

        /* compiled from: ActivityLifecycleManager.java */
        /* renamed from: d.a.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0085a implements Application.ActivityLifecycleCallbacks {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f4183a;

            public C0085a(C0084a c0084a, b bVar) {
                this.f4183a = bVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                this.f4183a.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                this.f4183a.a(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                this.f4183a.b(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                this.f4183a.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                this.f4183a.b(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                this.f4183a.d(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                this.f4183a.e(activity);
            }
        }

        public C0084a(Application application) {
            this.f4182b = application;
        }

        @TargetApi(14)
        public final void a() {
            for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.f4181a) {
                this.f4182b.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }

        @TargetApi(14)
        public final boolean a(b bVar) {
            if (this.f4182b != null) {
                C0085a c0085a = new C0085a(this, bVar);
                this.f4182b.registerActivityLifecycleCallbacks(c0085a);
                this.f4181a.add(c0085a);
                return true;
            }
            return false;
        }
    }

    /* compiled from: ActivityLifecycleManager.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public void a(Activity activity) {
        }

        public void a(Activity activity, Bundle bundle) {
        }

        public void b(Activity activity) {
        }

        public void b(Activity activity, Bundle bundle) {
        }

        public void c(Activity activity) {
        }

        public abstract void d(Activity activity);

        public void e(Activity activity) {
        }
    }

    public a(Context context) {
        this.f4179a = (Application) context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.f4180b = new C0084a(this.f4179a);
        }
    }

    public boolean a(b bVar) {
        C0084a c0084a = this.f4180b;
        return c0084a != null && c0084a.a(bVar);
    }

    public void a() {
        C0084a c0084a = this.f4180b;
        if (c0084a != null) {
            c0084a.a();
        }
    }
}
