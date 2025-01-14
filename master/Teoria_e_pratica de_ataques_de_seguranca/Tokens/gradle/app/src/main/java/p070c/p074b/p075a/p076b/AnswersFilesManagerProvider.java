package p070c.p074b.p075a.p076b;

import android.content.Context;
import android.os.Looper;
import p136d.p137a.p138a.p139a.p140m.p142b.SystemCurrentTimeProvider;
import p136d.p137a.p138a.p139a.p140m.p145d.GZIPQueueFileEventStorage;
import p136d.p137a.p138a.p139a.p140m.p147f.FileStore;

/* renamed from: c.b.a.b.f */
/* loaded from: classes.dex */
public class AnswersFilesManagerProvider {

    /* renamed from: a */
    public final Context f4676a;

    /* renamed from: b */
    public final FileStore f4677b;

    public AnswersFilesManagerProvider(Context context, FileStore fileStore) {
        this.f4676a = context;
        this.f4677b = fileStore;
    }

    /* renamed from: a */
    public SessionAnalyticsFilesManager m6048a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return new SessionAnalyticsFilesManager(this.f4676a, new SessionEventTransform(), new SystemCurrentTimeProvider(), new GZIPQueueFileEventStorage(this.f4676a, this.f4677b.mo3904a(), "session_analytics.tap", "session_analytics_to_send"));
        }
        throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
    }
}
