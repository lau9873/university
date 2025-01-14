package p136d.p137a.p138a.p139a.p140m.p147f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import p136d.p137a.p138a.p139a.Kit;

/* renamed from: d.a.a.a.m.f.d */
/* loaded from: classes.dex */
public class PreferenceStoreImpl implements PreferenceStore {

    /* renamed from: a */
    public final SharedPreferences f6596a;

    /* renamed from: b */
    public final String f6597b;

    /* renamed from: c */
    public final Context f6598c;

    public PreferenceStoreImpl(Context context, String str) {
        if (context != null) {
            this.f6598c = context;
            this.f6597b = str;
            this.f6596a = this.f6598c.getSharedPreferences(this.f6597b, 0);
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStore
    @TargetApi(9)
    /* renamed from: a */
    public boolean mo3902a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
            return true;
        }
        return editor.commit();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStore
    public SharedPreferences.Editor edit() {
        return this.f6596a.edit();
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStore
    public SharedPreferences get() {
        return this.f6596a;
    }

    @Deprecated
    public PreferenceStoreImpl(Kit kit) {
        this(kit.m4178e(), kit.getClass().getName());
    }
}
