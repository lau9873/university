package d.c.g0;

import d.c.f0.j.k;
import d.c.g0.a;
import java.util.List;
import java.util.concurrent.CountDownLatch;
/* compiled from: BaseTestConsumer.java */
/* loaded from: classes.dex */
public abstract class a<T, U extends a<T, U>> implements d.c.c0.b {

    /* renamed from: d  reason: collision with root package name */
    public long f5390d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5391e;

    /* renamed from: f  reason: collision with root package name */
    public int f5392f;

    /* renamed from: g  reason: collision with root package name */
    public int f5393g;

    /* renamed from: b  reason: collision with root package name */
    public final List<T> f5388b = new k();

    /* renamed from: c  reason: collision with root package name */
    public final List<Throwable> f5389c = new k();

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f5387a = new CountDownLatch(1);
}
