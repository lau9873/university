package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import c.d.a.a.f.a;
import c.d.a.a.f.c;
import c.d.a.a.g.a.b;
import c.d.a.a.g.a.d;
import c.d.a.a.g.a.f;
import c.d.a.a.g.a.h;
import c.d.a.a.g.a.j;
import c.d.a.a.h.l;
import com.google.android.gms.common.util.DynamiteApi;
@DynamiteApi
/* loaded from: classes.dex */
public class FlagProviderImpl extends l {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4086a = false;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f4087b;

    @Override // c.d.a.a.h.k
    public boolean getBooleanFlagValue(String str, boolean z, int i2) {
        return !this.f4086a ? z : b.a(this.f4087b, str, Boolean.valueOf(z)).booleanValue();
    }

    @Override // c.d.a.a.h.k
    public int getIntFlagValue(String str, int i2, int i3) {
        return !this.f4086a ? i2 : d.a(this.f4087b, str, Integer.valueOf(i2)).intValue();
    }

    @Override // c.d.a.a.h.k
    public long getLongFlagValue(String str, long j, int i2) {
        return !this.f4086a ? j : f.a(this.f4087b, str, Long.valueOf(j)).longValue();
    }

    @Override // c.d.a.a.h.k
    public String getStringFlagValue(String str, String str2, int i2) {
        return !this.f4086a ? str2 : h.a(this.f4087b, str, str2);
    }

    @Override // c.d.a.a.h.k
    public void init(a aVar) {
        Context context = (Context) c.a(aVar);
        if (this.f4086a) {
            return;
        }
        try {
            this.f4087b = j.a(context.createPackageContext("com.google.android.gms", 0));
            this.f4086a = true;
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("FlagProviderImpl", valueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
        }
    }
}
