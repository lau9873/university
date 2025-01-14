package c.b.a.b;

import android.content.Context;
import android.os.Looper;
/* compiled from: AnswersFilesManagerProvider.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2875a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.a.m.f.a f2876b;

    public f(Context context, d.a.a.a.m.f.a aVar) {
        this.f2875a = context;
        this.f2876b = aVar;
    }

    public s a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return new s(this.f2875a, new y(), new d.a.a.a.m.b.s(), new d.a.a.a.m.d.g(this.f2875a, this.f2876b.a(), "session_analytics.tap", "session_analytics_to_send"));
        }
        throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
    }
}
