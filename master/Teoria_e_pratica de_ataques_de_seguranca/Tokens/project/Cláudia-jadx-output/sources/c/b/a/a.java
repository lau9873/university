package c.b.a;

import c.b.a.c.c;
import d.a.a.a.h;
import d.a.a.a.i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
/* compiled from: Crashlytics.java */
/* loaded from: classes.dex */
public class a extends h<Void> implements i {

    /* renamed from: g  reason: collision with root package name */
    public final c.b.a.d.i f2848g;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<? extends h> f2849h;

    public a() {
        this(new c.b.a.b.a(), new c(), new c.b.a.d.i());
    }

    public static void a(Throwable th) {
        o();
        p().f2848g.a(th);
    }

    public static void o() {
        if (p() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }

    public static a p() {
        return (a) d.a.a.a.c.a(a.class);
    }

    @Override // d.a.a.a.i
    public Collection<? extends h> b() {
        return this.f2849h;
    }

    @Override // d.a.a.a.h
    public Void d() {
        return null;
    }

    @Override // d.a.a.a.h
    public String i() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    @Override // d.a.a.a.h
    public String k() {
        return "2.6.7.dev";
    }

    public a(c.b.a.b.a aVar, c cVar, c.b.a.d.i iVar) {
        this.f2848g = iVar;
        this.f2849h = Collections.unmodifiableCollection(Arrays.asList(aVar, cVar, iVar));
    }

    public static void a(int i2, String str, String str2) {
        o();
        p().f2848g.b(i2, str, str2);
    }

    public static void a(String str) {
        o();
        p().f2848g.a(str);
    }
}
