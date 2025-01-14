package com.google.android.gms.common.api;

import a.b.g.j.a;
import android.text.TextUtils;
import c.d.a.a.e.e.a;
import c.d.a.a.e.e.c;
import c.d.a.a.e.e.l.g2;
import c.d.a.a.e.f.c0;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AvailabilityException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final a<g2<?>, c.d.a.a.e.a> f4063a;

    public AvailabilityException(a<g2<?>, c.d.a.a.e.a> aVar) {
        this.f4063a = aVar;
    }

    public final a<g2<?>, c.d.a.a.e.a> a() {
        return this.f4063a;
    }

    public c.d.a.a.e.a a(c<? extends a.InterfaceC0057a> cVar) {
        g2<? extends a.InterfaceC0057a> d2 = cVar.d();
        c0.a(this.f4063a.get(d2) != null, "The given API was not part of the availability request.");
        return this.f4063a.get(d2);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (g2<?> g2Var : this.f4063a.keySet()) {
            c.d.a.a.e.a aVar = this.f4063a.get(g2Var);
            if (aVar.f()) {
                z = false;
            }
            String a2 = g2Var.a();
            String valueOf = String.valueOf(aVar);
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 2 + String.valueOf(valueOf).length());
            sb.append(a2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
