package c.b.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
/* compiled from: AnswersPreferenceManager.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.a.a.m.f.c f2879a;

    public h(d.a.a.a.m.f.c cVar) {
        this.f2879a = cVar;
    }

    public static h a(Context context) {
        return new h(new d.a.a.a.m.f.d(context, "settings"));
    }

    @SuppressLint({"CommitPrefEdits"})
    public void b() {
        d.a.a.a.m.f.c cVar = this.f2879a;
        cVar.a(cVar.edit().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean a() {
        return this.f2879a.get().getBoolean("analytics_launched", false);
    }
}
