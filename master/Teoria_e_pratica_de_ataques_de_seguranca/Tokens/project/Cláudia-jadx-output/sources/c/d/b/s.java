package c.d.b;

import com.google.gson.JsonIOException;
import java.io.IOException;
/* compiled from: TypeAdapter.java */
/* loaded from: classes.dex */
public abstract class s<T> {
    public final s<T> a() {
        return new a();
    }

    public abstract T a(c.d.b.x.a aVar);

    public abstract void a(c.d.b.x.c cVar, T t);

    /* compiled from: TypeAdapter.java */
    /* loaded from: classes.dex */
    public class a extends s<T> {
        public a() {
        }

        @Override // c.d.b.s
        public void a(c.d.b.x.c cVar, T t) {
            if (t == null) {
                cVar.t();
            } else {
                s.this.a(cVar, t);
            }
        }

        @Override // c.d.b.s
        public T a(c.d.b.x.a aVar) {
            if (aVar.C() == c.d.b.x.b.NULL) {
                aVar.z();
                return null;
            }
            return (T) s.this.a(aVar);
        }
    }

    public final l a(T t) {
        try {
            c.d.b.v.n.f fVar = new c.d.b.v.n.f();
            a(fVar, t);
            return fVar.w();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }
}
