package d.c.b0.b;

import android.os.Handler;
import android.os.Looper;
import d.c.t;
import java.util.concurrent.Callable;
/* compiled from: AndroidSchedulers.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final t f4569a = d.c.b0.a.a.b(new CallableC0093a());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: d.c.b0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class CallableC0093a implements Callable<t> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public t call() {
            return b.f4570a;
        }
    }

    /* compiled from: AndroidSchedulers.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final t f4570a = new d.c.b0.b.b(new Handler(Looper.getMainLooper()));
    }

    public static t a() {
        return d.c.b0.a.a.a(f4569a);
    }
}
