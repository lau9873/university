package p070c.p074b.p075a.p076b;

import android.annotation.SuppressLint;
import android.content.Context;
import p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStore;
import p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStoreImpl;

/* renamed from: c.b.a.b.h */
/* loaded from: classes.dex */
public class AnswersPreferenceManager {

    /* renamed from: a */
    public final PreferenceStore f4680a;

    public AnswersPreferenceManager(PreferenceStore preferenceStore) {
        this.f4680a = preferenceStore;
    }

    /* renamed from: a */
    public static AnswersPreferenceManager m6046a(Context context) {
        return new AnswersPreferenceManager(new PreferenceStoreImpl(context, "settings"));
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    public void m6045b() {
        PreferenceStore preferenceStore = this.f4680a;
        preferenceStore.mo3902a(preferenceStore.edit().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public boolean m6047a() {
        return this.f4680a.get().getBoolean("analytics_launched", false);
    }
}
