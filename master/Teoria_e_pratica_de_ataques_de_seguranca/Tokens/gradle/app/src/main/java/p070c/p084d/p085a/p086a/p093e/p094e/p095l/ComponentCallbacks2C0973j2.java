package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import p070c.p084d.p085a.p086a.p093e.p098h.C1102e;

/* renamed from: c.d.a.a.e.e.l.j2 */
/* loaded from: classes.dex */
public final class ComponentCallbacks2C0973j2 implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e */
    public static final ComponentCallbacks2C0973j2 f5219e = new ComponentCallbacks2C0973j2();

    /* renamed from: a */
    public final AtomicBoolean f5220a = new AtomicBoolean();

    /* renamed from: b */
    public final AtomicBoolean f5221b = new AtomicBoolean();

    /* renamed from: c */
    public final ArrayList<InterfaceC0977k2> f5222c = new ArrayList<>();

    /* renamed from: d */
    public boolean f5223d = false;

    /* renamed from: a */
    public static ComponentCallbacks2C0973j2 m5474a() {
        return f5219e;
    }

    /* renamed from: a */
    public static void m5473a(Application application) {
        synchronized (f5219e) {
            if (!f5219e.f5223d) {
                application.registerActivityLifecycleCallbacks(f5219e);
                application.registerComponentCallbacks(f5219e);
                f5219e.f5223d = true;
            }
        }
    }

    /* renamed from: a */
    public final void m5472a(InterfaceC0977k2 interfaceC0977k2) {
        synchronized (f5219e) {
            this.f5222c.add(interfaceC0977k2);
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    public final boolean m5471a(boolean z) {
        if (!this.f5221b.get()) {
            if (!C1102e.m5134d()) {
                return true;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f5221b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f5220a.set(true);
            }
        }
        return this.f5220a.get();
    }

    /* renamed from: b */
    public final void m5470b(boolean z) {
        synchronized (f5219e) {
            ArrayList<InterfaceC0977k2> arrayList = this.f5222c;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                InterfaceC0977k2 interfaceC0977k2 = arrayList.get(i);
                i++;
                interfaceC0977k2.mo5467a(z);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f5220a.compareAndSet(true, false);
        this.f5221b.set(true);
        if (compareAndSet) {
            m5470b(false);
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
        boolean compareAndSet = this.f5220a.compareAndSet(true, false);
        this.f5221b.set(true);
        if (compareAndSet) {
            m5470b(false);
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
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f5220a.compareAndSet(false, true)) {
            this.f5221b.set(true);
            m5470b(true);
        }
    }
}
