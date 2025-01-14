package c.b.a.d;

import android.annotation.SuppressLint;
/* compiled from: PreferenceManager.java */
@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.a.a.m.f.c f2977a;

    public b0(d.a.a.a.m.f.c cVar) {
        this.f2977a = cVar;
    }

    public static b0 a(d.a.a.a.m.f.c cVar, i iVar) {
        if (!cVar.get().getBoolean("preferences_migration_complete", false)) {
            d.a.a.a.m.f.d dVar = new d.a.a.a.m.f.d(iVar);
            if (!cVar.get().contains("always_send_reports_opt_in") && dVar.get().contains("always_send_reports_opt_in")) {
                cVar.a(cVar.edit().putBoolean("always_send_reports_opt_in", dVar.get().getBoolean("always_send_reports_opt_in", false)));
            }
            cVar.a(cVar.edit().putBoolean("preferences_migration_complete", true));
        }
        return new b0(cVar);
    }

    public void a(boolean z) {
        d.a.a.a.m.f.c cVar = this.f2977a;
        cVar.a(cVar.edit().putBoolean("always_send_reports_opt_in", z));
    }

    public boolean a() {
        return this.f2977a.get().getBoolean("always_send_reports_opt_in", false);
    }
}
