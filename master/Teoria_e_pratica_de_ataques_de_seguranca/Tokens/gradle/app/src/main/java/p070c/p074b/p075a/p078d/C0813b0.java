package p070c.p074b.p075a.p078d;

import android.annotation.SuppressLint;
import p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStore;
import p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStoreImpl;

/* compiled from: PreferenceManager.java */
@SuppressLint({"CommitPrefEdits"})
/* renamed from: c.b.a.d.b0 */
/* loaded from: classes.dex */
public class C0813b0 {

    /* renamed from: a */
    public final PreferenceStore f4790a;

    public C0813b0(PreferenceStore preferenceStore) {
        this.f4790a = preferenceStore;
    }

    /* renamed from: a */
    public static C0813b0 m5968a(PreferenceStore preferenceStore, CrashlyticsCore crashlyticsCore) {
        if (!preferenceStore.get().getBoolean("preferences_migration_complete", false)) {
            PreferenceStoreImpl preferenceStoreImpl = new PreferenceStoreImpl(crashlyticsCore);
            if (!preferenceStore.get().contains("always_send_reports_opt_in") && preferenceStoreImpl.get().contains("always_send_reports_opt_in")) {
                preferenceStore.mo3902a(preferenceStore.edit().putBoolean("always_send_reports_opt_in", preferenceStoreImpl.get().getBoolean("always_send_reports_opt_in", false)));
            }
            preferenceStore.mo3902a(preferenceStore.edit().putBoolean("preferences_migration_complete", true));
        }
        return new C0813b0(preferenceStore);
    }

    /* renamed from: a */
    public void m5967a(boolean z) {
        PreferenceStore preferenceStore = this.f4790a;
        preferenceStore.mo3902a(preferenceStore.edit().putBoolean("always_send_reports_opt_in", z));
    }

    /* renamed from: a */
    public boolean m5969a() {
        return this.f4790a.get().getBoolean("always_send_reports_opt_in", false);
    }
}
