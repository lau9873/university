package h.b.a.d.b0;

import h.b.a.d.q;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TipPassing.java */
/* loaded from: classes.dex */
public class h implements q {

    /* renamed from: a  reason: collision with root package name */
    public final j f6960a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6961b;

    public h(j jVar, Date date) {
        this(jVar, date.getTime());
    }

    @Override // h.b.a.d.q
    public long a() {
        return this.f6961b;
    }

    public String toString() {
        return super.getClass().getSimpleName() + " [" + this.f6960a + ", " + new SimpleDateFormat("HH:mm:ss,SSS").format(Long.valueOf(this.f6961b)) + "]";
    }

    public h(j jVar, long j) {
        this.f6960a = jVar;
        this.f6961b = j;
    }

    @Override // h.b.a.d.q
    public j d() {
        return this.f6960a;
    }
}
