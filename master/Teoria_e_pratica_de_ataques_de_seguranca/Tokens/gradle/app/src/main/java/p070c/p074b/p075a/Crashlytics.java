package p070c.p074b.p075a;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import p070c.p074b.p075a.p076b.Answers;
import p070c.p074b.p075a.p077c.Beta;
import p070c.p074b.p075a.p078d.CrashlyticsCore;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Kit;
import p136d.p137a.p138a.p139a.KitGroup;

/* renamed from: c.b.a.a */
/* loaded from: classes.dex */
public class Crashlytics extends Kit<Void> implements KitGroup {

    /* renamed from: g */
    public final CrashlyticsCore f4649g;

    /* renamed from: h */
    public final Collection<? extends Kit> f4650h;

    public Crashlytics() {
        this(new Answers(), new Beta(), new CrashlyticsCore());
    }

    /* renamed from: a */
    public static void m6081a(Throwable th) {
        m6080o();
        m6079p().f4649g.m5774a(th);
    }

    /* renamed from: o */
    public static void m6080o() {
        if (m6079p() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }

    /* renamed from: p */
    public static Crashlytics m6079p() {
        return (Crashlytics) Fabric.m4212a(Crashlytics.class);
    }

    @Override // p136d.p137a.p138a.p139a.KitGroup
    /* renamed from: b */
    public Collection<? extends Kit> mo4171b() {
        return this.f4650h;
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: d  reason: avoid collision after fix types in other method */
    public Void mo4150d() {
        return null;
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: i */
    public String mo4149i() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    @Override // p136d.p137a.p138a.p139a.Kit
    /* renamed from: k */
    public String mo4148k() {
        return "2.6.7.dev";
    }

    public Crashlytics(Answers answers, Beta beta, CrashlyticsCore crashlyticsCore) {
        this.f4649g = crashlyticsCore;
        this.f4650h = Collections.unmodifiableCollection(Arrays.asList(answers, beta, crashlyticsCore));
    }

    /* renamed from: a */
    public static void m6083a(int i, String str, String str2) {
        m6080o();
        m6079p().f4649g.m5773b(i, str, str2);
    }

    /* renamed from: a */
    public static void m6082a(String str) {
        m6080o();
        m6079p().f4649g.m5776a(str);
    }
}
