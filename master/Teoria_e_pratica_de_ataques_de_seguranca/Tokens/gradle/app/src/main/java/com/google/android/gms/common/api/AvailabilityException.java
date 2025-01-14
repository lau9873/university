package com.google.android.gms.common.api;

import android.text.TextUtils;
import java.util.ArrayList;
import p000a.p006b.p030g.p044j.ArrayMap;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0919c;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C0960g2;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* loaded from: classes.dex */
public class AvailabilityException extends Exception {

    /* renamed from: a */
    public final ArrayMap<C0960g2<?>, C0900a> f6102a;

    public AvailabilityException(ArrayMap<C0960g2<?>, C0900a> arrayMap) {
        this.f6102a = arrayMap;
    }

    /* renamed from: a */
    public final ArrayMap<C0960g2<?>, C0900a> m4378a() {
        return this.f6102a;
    }

    /* renamed from: a */
    public C0900a m4377a(C0919c<? extends C0905a.InterfaceC0906a> c0919c) {
        C0960g2<? extends C0905a.InterfaceC0906a> m5595d = c0919c.m5595d();
        C1049c0.m5289a(this.f6102a.get(m5595d) != null, "The given API was not part of the availability request.");
        return this.f6102a.get(m5595d);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (C0960g2<?> c0960g2 : this.f6102a.keySet()) {
            C0900a c0900a = this.f6102a.get(c0960g2);
            if (c0900a.m5641f()) {
                z = false;
            }
            String m5520a = c0960g2.m5520a();
            String valueOf = String.valueOf(c0900a);
            StringBuilder sb = new StringBuilder(String.valueOf(m5520a).length() + 2 + String.valueOf(valueOf).length());
            sb.append(m5520a);
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
