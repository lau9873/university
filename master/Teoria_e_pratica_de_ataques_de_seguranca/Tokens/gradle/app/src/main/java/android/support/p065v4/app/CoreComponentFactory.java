package android.support.p065v4.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* renamed from: android.support.v4.app.CoreComponentFactory */
/* loaded from: classes.dex */
public class CoreComponentFactory extends AppComponentFactory {

    /* renamed from: android.support.v4.app.CoreComponentFactory$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0600a {
        /* renamed from: a */
        Object m7551a();
    }

    /* renamed from: a */
    public static <T> T m7552a(T t) {
        T t2;
        return (!(t instanceof InterfaceC0600a) || (t2 = (T) ((InterfaceC0600a) t).m7551a()) == null) ? t : t2;
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) {
        return (Activity) m7552a(super.instantiateActivity(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader classLoader, String str) {
        return (Application) m7552a(super.instantiateApplication(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(ClassLoader classLoader, String str) {
        return (ContentProvider) m7552a(super.instantiateProvider(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String str, Intent intent) {
        return (BroadcastReceiver) m7552a(super.instantiateReceiver(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader classLoader, String str, Intent intent) {
        return (Service) m7552a(super.instantiateService(classLoader, str, intent));
    }
}
