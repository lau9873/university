package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import c.d.a.a.e.e.l.a1;
import c.d.a.a.e.e.l.b1;
import c.d.a.a.e.e.l.s1;
import c.d.a.a.e.e.l.z0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class LifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    public final a1 f4085a;

    public LifecycleCallback(a1 a1Var) {
        this.f4085a = a1Var;
    }

    public static a1 a(Activity activity) {
        return a(new z0(activity));
    }

    public static a1 a(z0 z0Var) {
        if (z0Var.a()) {
            return s1.a(z0Var.d());
        }
        if (z0Var.b()) {
            return b1.a(z0Var.c());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    public static a1 getChimeraLifecycleFragmentImpl(z0 z0Var) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public final Activity a() {
        return this.f4085a.c();
    }

    public void a(int i2, int i3, Intent intent) {
    }

    public void a(Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void b() {
    }

    public void b(Bundle bundle) {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }
}
