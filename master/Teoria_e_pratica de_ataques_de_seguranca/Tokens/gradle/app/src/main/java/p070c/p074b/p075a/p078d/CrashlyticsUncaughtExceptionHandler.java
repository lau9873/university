package p070c.p074b.p075a.p078d;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import p136d.p137a.p138a.p139a.Fabric;

/* renamed from: c.b.a.d.m */
/* loaded from: classes.dex */
public class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public final InterfaceC0860a f4923a;

    /* renamed from: b */
    public final Thread.UncaughtExceptionHandler f4924b;

    /* renamed from: c */
    public final AtomicBoolean f4925c = new AtomicBoolean(false);

    /* compiled from: CrashlyticsUncaughtExceptionHandler.java */
    /* renamed from: c.b.a.d.m$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0860a {
        /* renamed from: a */
        void mo5750a(Thread thread, Throwable th);
    }

    public CrashlyticsUncaughtExceptionHandler(InterfaceC0860a interfaceC0860a, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f4923a = interfaceC0860a;
        this.f4924b = uncaughtExceptionHandler;
    }

    /* renamed from: a */
    public boolean m5751a() {
        return this.f4925c.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Thread$UncaughtExceptionHandler] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Thread$UncaughtExceptionHandler] */
    /* JADX WARN: Type inference failed for: r3v3, types: [d.a.a.a.k] */
    /* JADX WARN: Type inference failed for: r4v1, types: [d.a.a.a.k] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.concurrent.atomic.AtomicBoolean] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ?? r0 = "Crashlytics completed exception processing. Invoking default exception handler.";
        this.f4925c.set(true);
        try {
            try {
                this.f4923a.mo5750a(thread, th);
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
            }
        } finally {
            Fabric.m4197h().mo4157e("CrashlyticsCore", r0);
            this.f4924b.uncaughtException(thread, th);
            this.f4925c.set(false);
        }
    }
}
