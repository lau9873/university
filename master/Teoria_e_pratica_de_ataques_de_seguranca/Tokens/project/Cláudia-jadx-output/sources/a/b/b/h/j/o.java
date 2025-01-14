package a.b.b.h.j;

import java.util.HashSet;
import java.util.Iterator;
/* compiled from: ResolutionNode.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public HashSet<o> f198a = new HashSet<>(2);

    /* renamed from: b  reason: collision with root package name */
    public int f199b = 0;

    public void a(o oVar) {
        this.f198a.add(oVar);
    }

    public void b() {
        this.f199b = 0;
        Iterator<o> it = this.f198a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public boolean c() {
        return this.f199b == 1;
    }

    public void d() {
        this.f199b = 0;
        this.f198a.clear();
    }

    public void e() {
    }

    public void a() {
        this.f199b = 1;
        Iterator<o> it = this.f198a.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }
}
