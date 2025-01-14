package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C1008s1;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C1035z0;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.FragmentC0939b1;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0935a1;

/* loaded from: classes.dex */
public class LifecycleCallback {

    /* renamed from: a */
    public final InterfaceC0935a1 f6131a;

    public LifecycleCallback(InterfaceC0935a1 interfaceC0935a1) {
        this.f6131a = interfaceC0935a1;
    }

    /* renamed from: a */
    public static InterfaceC0935a1 m4349a(Activity activity) {
        return m4347a(new C1035z0(activity));
    }

    /* renamed from: a */
    public static InterfaceC0935a1 m4347a(C1035z0 c1035z0) {
        if (c1035z0.m5307a()) {
            return C1008s1.m5381a(c1035z0.m5304d());
        }
        if (c1035z0.m5306b()) {
            return FragmentC0939b1.m5544a(c1035z0.m5305c());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    public static InterfaceC0935a1 getChimeraLifecycleFragmentImpl(C1035z0 c1035z0) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    /* renamed from: a */
    public final Activity m4351a() {
        return this.f6131a.mo5374c();
    }

    /* renamed from: a */
    public void mo4350a(int i, int i2, Intent intent) {
    }

    /* renamed from: a */
    public void mo4348a(Bundle bundle) {
    }

    /* renamed from: a */
    public void mo4346a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: b */
    public void m4345b() {
    }

    /* renamed from: b */
    public void mo4344b(Bundle bundle) {
    }

    /* renamed from: c */
    public void m4343c() {
    }

    /* renamed from: d */
    public void mo4342d() {
    }

    /* renamed from: e */
    public void mo4341e() {
    }
}
