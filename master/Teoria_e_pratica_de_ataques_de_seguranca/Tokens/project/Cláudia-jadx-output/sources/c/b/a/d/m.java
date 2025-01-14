package c.b.a.d;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: CrashlyticsUncaughtExceptionHandler.java */
/* loaded from: classes.dex */
public class m implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final a f3085a;

    /* renamed from: b  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f3086b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f3087c = new AtomicBoolean(false);

    /* compiled from: CrashlyticsUncaughtExceptionHandler.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Thread thread, Throwable th);
    }

    public m(a aVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f3085a = aVar;
        this.f3086b = uncaughtExceptionHandler;
    }

    public boolean a() {
        return this.f3087c.get();
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
        this.f3087c.set(true);
        try {
            try {
                this.f3085a.a(thread, th);
            } catch (Exception e2) {
                d.a.a.a.c.h().c("CrashlyticsCore", "An error occurred in the uncaught exception handler", e2);
            }
        } finally {
            d.a.a.a.c.h().e("CrashlyticsCore", r0);
            this.f3086b.uncaughtException(thread, th);
            this.f3087c.set(false);
        }
    }
}
