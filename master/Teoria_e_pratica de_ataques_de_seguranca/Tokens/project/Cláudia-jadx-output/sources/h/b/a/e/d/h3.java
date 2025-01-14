package h.b.a.e.d;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import h.b.a.e.d.n3;
/* compiled from: AbstractHomeFragment.java */
/* loaded from: classes.dex */
public abstract class h3 extends g3 {
    public n3 c0;

    public void b(View view) {
    }

    @Override // android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        Fragment z = z();
        if (z == null || !(z instanceof n3)) {
            return;
        }
        this.c0 = (n3) z;
    }

    public void d(int i2) {
        n3 n3Var = this.c0;
        if (n3Var != null) {
            n3Var.e(i2);
        }
    }

    public void p0() {
    }

    public int q0() {
        n3 n3Var = this.c0;
        if (n3Var == null) {
            return 0;
        }
        return n3Var.r0();
    }

    public int r0() {
        n3 n3Var = this.c0;
        if (n3Var != null) {
            return n3Var.s0();
        }
        return 0;
    }

    public n3.h s0() {
        n3 n3Var = this.c0;
        if (n3Var != null) {
            return n3Var.t0();
        }
        return null;
    }
}
