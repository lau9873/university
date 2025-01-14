package p136d.p137a.p138a.p139a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* renamed from: d.a.a.a.a */
/* loaded from: classes.dex */
public class ActivityLifecycleManager {

    /* renamed from: a */
    public final Application f6358a;

    /* renamed from: b */
    public C1478a f6359b;

    /* compiled from: ActivityLifecycleManager.java */
    /* renamed from: d.a.a.a.a$a */
    /* loaded from: classes.dex */
    public static class C1478a {

        /* renamed from: a */
        public final Set<Application.ActivityLifecycleCallbacks> f6360a = new HashSet();

        /* renamed from: b */
        public final Application f6361b;

        /* compiled from: ActivityLifecycleManager.java */
        /* renamed from: d.a.a.a.a$a$a */
        /* loaded from: classes.dex */
        public class C1479a implements Application.ActivityLifecycleCallbacks {

            /* renamed from: a */
            public final /* synthetic */ AbstractC1480b f6362a;

            public C1479a(C1478a c1478a, AbstractC1480b abstractC1480b) {
                this.f6362a = abstractC1480b;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                this.f6362a.mo4194a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                this.f6362a.mo4224a(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                this.f6362a.mo4223b(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                this.f6362a.mo4193c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                this.f6362a.mo4222b(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                this.f6362a.mo4192d(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                this.f6362a.mo4221e(activity);
            }
        }

        public C1478a(Application application) {
            this.f6361b = application;
        }

        @TargetApi(14)
        /* renamed from: a */
        public final void m4228a() {
            for (Application.ActivityLifecycleCallbacks activityLifecycleCallbacks : this.f6360a) {
                this.f6361b.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }

        @TargetApi(14)
        /* renamed from: a */
        public final boolean m4225a(AbstractC1480b abstractC1480b) {
            if (this.f6361b != null) {
                C1479a c1479a = new C1479a(this, abstractC1480b);
                this.f6361b.registerActivityLifecycleCallbacks(c1479a);
                this.f6360a.add(c1479a);
                return true;
            }
            return false;
        }
    }

    /* compiled from: ActivityLifecycleManager.java */
    /* renamed from: d.a.a.a.a$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1480b {
        /* renamed from: a */
        public void mo4224a(Activity activity) {
        }

        /* renamed from: a */
        public void mo4194a(Activity activity, Bundle bundle) {
        }

        /* renamed from: b */
        public void mo4223b(Activity activity) {
        }

        /* renamed from: b */
        public void mo4222b(Activity activity, Bundle bundle) {
        }

        /* renamed from: c */
        public void mo4193c(Activity activity) {
        }

        /* renamed from: d */
        public abstract void mo4192d(Activity activity);

        /* renamed from: e */
        public void mo4221e(Activity activity) {
        }
    }

    public ActivityLifecycleManager(Context context) {
        this.f6358a = (Application) context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.f6359b = new C1478a(this.f6358a);
        }
    }

    /* renamed from: a */
    public boolean m4229a(AbstractC1480b abstractC1480b) {
        C1478a c1478a = this.f6359b;
        return c1478a != null && c1478a.m4225a(abstractC1480b);
    }

    /* renamed from: a */
    public void m4230a() {
        C1478a c1478a = this.f6359b;
        if (c1478a != null) {
            c1478a.m4228a();
        }
    }
}
