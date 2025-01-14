package p192f;

/* renamed from: f.g */
/* loaded from: classes.dex */
public abstract class ForwardingSource implements Source {

    /* renamed from: a */
    public final Source f8458a;

    public ForwardingSource(Source source) {
        if (source != null) {
            this.f8458a = source;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // p192f.Source
    /* renamed from: a */
    public long mo673a(Buffer buffer, long j) {
        return this.f8458a.mo673a(buffer, j);
    }

    @Override // p192f.Source
    /* renamed from: b */
    public Timeout mo2528b() {
        return this.f8458a.mo2528b();
    }

    @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8458a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f8458a.toString() + ")";
    }
}
