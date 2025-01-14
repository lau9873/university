package p136d.p153c.p176g0;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p175j.VolatileSizeArrayList;
import p136d.p153c.p176g0.BaseTestConsumer;

/* renamed from: d.c.g0.a */
/* loaded from: classes.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {

    /* renamed from: d */
    public long f7726d;

    /* renamed from: e */
    public boolean f7727e;

    /* renamed from: f */
    public int f7728f;

    /* renamed from: g */
    public int f7729g;

    /* renamed from: b */
    public final List<T> f7724b = new VolatileSizeArrayList();

    /* renamed from: c */
    public final List<Throwable> f7725c = new VolatileSizeArrayList();

    /* renamed from: a */
    public final CountDownLatch f7723a = new CountDownLatch(1);
}
