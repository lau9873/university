package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import p070c.p084d.p085a.p086a.p099f.BinderC1122c;
import p070c.p084d.p085a.p086a.p099f.InterfaceC1119a;
import p070c.p084d.p085a.p086a.p100g.p101a.C1124b;
import p070c.p084d.p085a.p086a.p100g.p101a.C1126d;
import p070c.p084d.p085a.p086a.p100g.p101a.C1128f;
import p070c.p084d.p085a.p086a.p100g.p101a.C1130h;
import p070c.p084d.p085a.p086a.p100g.p101a.C1132j;
import p070c.p084d.p085a.p086a.p102h.AbstractBinderC1167l;

@DynamiteApi
/* loaded from: classes.dex */
public class FlagProviderImpl extends AbstractBinderC1167l {

    /* renamed from: a */
    public boolean f6132a = false;

    /* renamed from: b */
    public SharedPreferences f6133b;

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1164k
    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.f6132a ? z : C1124b.m5100a(this.f6133b, str, Boolean.valueOf(z)).booleanValue();
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1164k
    public int getIntFlagValue(String str, int i, int i2) {
        return !this.f6132a ? i : C1126d.m5099a(this.f6133b, str, Integer.valueOf(i)).intValue();
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1164k
    public long getLongFlagValue(String str, long j, int i) {
        return !this.f6132a ? j : C1128f.m5098a(this.f6133b, str, Long.valueOf(j)).longValue();
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1164k
    public String getStringFlagValue(String str, String str2, int i) {
        return !this.f6132a ? str2 : C1130h.m5097a(this.f6133b, str, str2);
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1164k
    public void init(InterfaceC1119a interfaceC1119a) {
        Context context = (Context) BinderC1122c.m5102a(interfaceC1119a);
        if (this.f6132a) {
            return;
        }
        try {
            this.f6133b = C1132j.m5096a(context.createPackageContext("com.google.android.gms", 0));
            this.f6132a = true;
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FlagProviderImpl", valueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
        }
    }
}
