package p000a.p006b.p008b.p009h.p010j;

/* renamed from: a.b.b.h.j.n */
/* loaded from: classes.dex */
public class ResolutionDimension extends ResolutionNode {

    /* renamed from: c */
    public float f404c = 0.0f;

    /* renamed from: a */
    public void m10994a(int i) {
        if (this.f406b == 0 || this.f404c != i) {
            this.f404c = i;
            if (this.f406b == 1) {
                m10990b();
            }
            m10992a();
        }
    }

    @Override // p000a.p006b.p008b.p009h.p010j.ResolutionNode
    /* renamed from: d */
    public void mo10988d() {
        super.mo10988d();
        this.f404c = 0.0f;
    }

    /* renamed from: f */
    public void m10993f() {
        this.f406b = 2;
    }
}
