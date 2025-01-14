package d.a.a.a.m.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import d.a.a.a.h;
/* compiled from: PreferenceStoreImpl.java */
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f4392a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4393b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f4394c;

    public d(Context context, String str) {
        if (context != null) {
            this.f4394c = context;
            this.f4393b = str;
            this.f4392a = this.f4394c.getSharedPreferences(this.f4393b, 0);
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    @Override // d.a.a.a.m.f.c
    @TargetApi(9)
    public boolean a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
            return true;
        }
        return editor.commit();
    }

    @Override // d.a.a.a.m.f.c
    public SharedPreferences.Editor edit() {
        return this.f4392a.edit();
    }

    @Override // d.a.a.a.m.f.c
    public SharedPreferences get() {
        return this.f4392a;
    }

    @Deprecated
    public d(h hVar) {
        this(hVar.e(), hVar.getClass().getName());
    }
}
