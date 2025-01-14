package a.b.g.a;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.Set;
/* compiled from: RemoteInput.java */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f662a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f663b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence[] f664c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f665d;

    /* renamed from: e  reason: collision with root package name */
    public final Bundle f666e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<String> f667f;

    public boolean a() {
        return this.f665d;
    }

    public Set<String> b() {
        return this.f667f;
    }

    public CharSequence[] c() {
        return this.f664c;
    }

    public Bundle d() {
        return this.f666e;
    }

    public CharSequence e() {
        return this.f663b;
    }

    public String f() {
        return this.f662a;
    }

    public boolean g() {
        return (a() || (c() != null && c().length != 0) || b() == null || b().isEmpty()) ? false : true;
    }

    public static RemoteInput[] a(d0[] d0VarArr) {
        if (d0VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[d0VarArr.length];
        for (int i2 = 0; i2 < d0VarArr.length; i2++) {
            remoteInputArr[i2] = a(d0VarArr[i2]);
        }
        return remoteInputArr;
    }

    public static RemoteInput a(d0 d0Var) {
        return new RemoteInput.Builder(d0Var.f()).setLabel(d0Var.e()).setChoices(d0Var.c()).setAllowFreeFormInput(d0Var.a()).addExtras(d0Var.d()).build();
    }
}
