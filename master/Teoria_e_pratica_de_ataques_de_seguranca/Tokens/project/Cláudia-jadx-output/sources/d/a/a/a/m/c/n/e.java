package d.a.a.a.m.c.n;
/* compiled from: RetryState.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f4354a;

    /* renamed from: b  reason: collision with root package name */
    public final a f4355b;

    /* renamed from: c  reason: collision with root package name */
    public final d f4356c;

    public e(a aVar, d dVar) {
        this(0, aVar, dVar);
    }

    public long a() {
        return this.f4355b.a(this.f4354a);
    }

    public e b() {
        return new e(this.f4355b, this.f4356c);
    }

    public e c() {
        return new e(this.f4354a + 1, this.f4355b, this.f4356c);
    }

    public e(int i2, a aVar, d dVar) {
        this.f4354a = i2;
        this.f4355b = aVar;
        this.f4356c = dVar;
    }
}
