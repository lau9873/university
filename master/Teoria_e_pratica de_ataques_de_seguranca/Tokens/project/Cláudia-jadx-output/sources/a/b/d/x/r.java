package a.b.d.x;

import a.b.g.k.u;
import android.view.View;
/* compiled from: ViewOffsetHelper.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public final View f402a;

    /* renamed from: b  reason: collision with root package name */
    public int f403b;

    /* renamed from: c  reason: collision with root package name */
    public int f404c;

    /* renamed from: d  reason: collision with root package name */
    public int f405d;

    /* renamed from: e  reason: collision with root package name */
    public int f406e;

    public r(View view) {
        this.f402a = view;
    }

    public boolean a(int i2) {
        if (this.f406e != i2) {
            this.f406e = i2;
            c();
            return true;
        }
        return false;
    }

    public void b() {
        this.f403b = this.f402a.getTop();
        this.f404c = this.f402a.getLeft();
        c();
    }

    public final void c() {
        View view = this.f402a;
        u.d(view, this.f405d - (view.getTop() - this.f403b));
        View view2 = this.f402a;
        u.c(view2, this.f406e - (view2.getLeft() - this.f404c));
    }

    public int a() {
        return this.f405d;
    }

    public boolean b(int i2) {
        if (this.f405d != i2) {
            this.f405d = i2;
            c();
            return true;
        }
        return false;
    }
}
