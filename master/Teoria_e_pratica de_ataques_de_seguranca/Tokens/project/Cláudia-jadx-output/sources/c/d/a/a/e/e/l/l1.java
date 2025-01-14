package c.d.a.a.e.e.l;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class l1 {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f3351a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c.d.a.a.h.g("GAC_Transform"));

    public static ExecutorService a() {
        return f3351a;
    }
}
