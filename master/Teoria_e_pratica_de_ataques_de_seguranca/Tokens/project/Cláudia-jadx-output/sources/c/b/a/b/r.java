package c.b.a.b;

import c.b.a.b.w;
import java.util.HashSet;
import java.util.Set;
/* compiled from: SamplingEventFilter.java */
/* loaded from: classes.dex */
public class r implements n {

    /* renamed from: b  reason: collision with root package name */
    public static final Set<w.c> f2903b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f2904a;

    /* compiled from: SamplingEventFilter.java */
    /* loaded from: classes.dex */
    public static class a extends HashSet<w.c> {
        public a() {
            add(w.c.START);
            add(w.c.RESUME);
            add(w.c.PAUSE);
            add(w.c.STOP);
        }
    }

    public r(int i2) {
        this.f2904a = i2;
    }

    @Override // c.b.a.b.n
    public boolean a(w wVar) {
        return (f2903b.contains(wVar.f2914c) && wVar.f2912a.f2943g == null) && (Math.abs(wVar.f2912a.f2939c.hashCode() % this.f2904a) != 0);
    }
}
