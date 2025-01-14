package p000a.p006b.p008b.p009h.p010j;

import java.util.HashSet;
import java.util.Iterator;

/* renamed from: a.b.b.h.j.o */
/* loaded from: classes.dex */
public class ResolutionNode {

    /* renamed from: a */
    public HashSet<ResolutionNode> f405a = new HashSet<>(2);

    /* renamed from: b */
    public int f406b = 0;

    /* renamed from: a */
    public void m10991a(ResolutionNode resolutionNode) {
        this.f405a.add(resolutionNode);
    }

    /* renamed from: b */
    public void m10990b() {
        this.f406b = 0;
        Iterator<ResolutionNode> it = this.f405a.iterator();
        while (it.hasNext()) {
            it.next().m10990b();
        }
    }

    /* renamed from: c */
    public boolean m10989c() {
        return this.f406b == 1;
    }

    /* renamed from: d */
    public void mo10988d() {
        this.f406b = 0;
        this.f405a.clear();
    }

    /* renamed from: e */
    public void mo10987e() {
    }

    /* renamed from: a */
    public void m10992a() {
        this.f406b = 1;
        Iterator<ResolutionNode> it = this.f405a.iterator();
        while (it.hasNext()) {
            it.next().mo10987e();
        }
    }
}
