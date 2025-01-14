package c.b.a.b;

import java.io.File;
import java.util.List;
/* compiled from: AnswersRetryFilesSender.java */
/* loaded from: classes.dex */
public class i implements d.a.a.a.m.d.f {

    /* renamed from: a  reason: collision with root package name */
    public final t f2880a;

    /* renamed from: b  reason: collision with root package name */
    public final q f2881b;

    public i(t tVar, q qVar) {
        this.f2880a = tVar;
        this.f2881b = qVar;
    }

    public static i a(t tVar) {
        return new i(tVar, new q(new d.a.a.a.m.c.n.e(new p(new d.a.a.a.m.c.n.c(1000L, 8), 0.1d), new d.a.a.a.m.c.n.b(5))));
    }

    @Override // d.a.a.a.m.d.f
    public boolean a(List<File> list) {
        long nanoTime = System.nanoTime();
        if (this.f2881b.a(nanoTime)) {
            if (this.f2880a.a(list)) {
                this.f2881b.a();
                return true;
            }
            this.f2881b.b(nanoTime);
        }
        return false;
    }
}
