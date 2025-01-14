package f;
/* compiled from: ForwardingSource.java */
/* loaded from: classes.dex */
public abstract class g implements r {

    /* renamed from: a  reason: collision with root package name */
    public final r f6007a;

    public g(r rVar) {
        if (rVar != null) {
            this.f6007a = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // f.r
    public long a(c cVar, long j) {
        return this.f6007a.a(cVar, j);
    }

    @Override // f.r
    public s b() {
        return this.f6007a.b();
    }

    @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6007a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f6007a.toString() + ")";
    }
}
