package a.b.b.h.j;
/* compiled from: ResolutionDimension.java */
/* loaded from: classes.dex */
public class n extends o {

    /* renamed from: c  reason: collision with root package name */
    public float f197c = 0.0f;

    public void a(int i2) {
        if (this.f199b == 0 || this.f197c != i2) {
            this.f197c = i2;
            if (this.f199b == 1) {
                b();
            }
            a();
        }
    }

    @Override // a.b.b.h.j.o
    public void d() {
        super.d();
        this.f197c = 0.0f;
    }

    public void f() {
        this.f199b = 2;
    }
}
