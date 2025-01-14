package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p070c.p084d.p085a.p086a.p102h.ThreadFactoryC1152g;

/* renamed from: c.d.a.a.e.e.l.l1 */
/* loaded from: classes.dex */
public final class C0980l1 {

    /* renamed from: a */
    public static final ExecutorService f5242a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC1152g("GAC_Transform"));

    /* renamed from: a */
    public static ExecutorService m5439a() {
        return f5242a;
    }
}
