package c.d.a.a.e.e.l;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class j2 implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e  reason: collision with root package name */
    public static final j2 f3331e = new j2();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f3332a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f3333b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<k2> f3334c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f3335d = false;

    public static j2 a() {
        return f3331e;
    }

    public static void a(Application application) {
        synchronized (f3331e) {
            if (!f3331e.f3335d) {
                application.registerActivityLifecycleCallbacks(f3331e);
                application.registerComponentCallbacks(f3331e);
                f3331e.f3335d = true;
            }
        }
    }

    public final void a(k2 k2Var) {
        synchronized (f3331e) {
            this.f3334c.add(k2Var);
        }
    }

    @TargetApi(16)
    public final boolean a(boolean z) {
        if (!this.f3333b.get()) {
            if (!c.d.a.a.e.h.e.d()) {
                return true;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f3333b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f3332a.set(true);
            }
        }
        return this.f3332a.get();
    }

    public final void b(boolean z) {
        synchronized (f3331e) {
            ArrayList<k2> arrayList = this.f3334c;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                k2 k2Var = arrayList.get(i2);
                i2++;
                k2Var.a(z);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f3332a.compareAndSet(true, false);
        this.f3333b.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f3332a.compareAndSet(true, false);
        this.f3333b.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.f3332a.compareAndSet(false, true)) {
            this.f3333b.set(true);
            b(true);
        }
    }
}
