package h.b.a.e.d;

import android.content.Context;
import android.support.v4.app.Fragment;
import java.text.DateFormat;
/* compiled from: AbstractFragment.java */
/* loaded from: classes.dex */
public abstract class g3 extends Fragment {
    public a.b.g.a.g Z;
    public h.b.a.e.a.h a0;
    public Context b0;

    @Override // android.support.v4.app.Fragment
    public void X() {
        this.b0 = null;
        super.X();
    }

    public void a(Fragment fragment, boolean z) {
        h.b.a.e.a.h hVar = this.a0;
        if (hVar != null) {
            hVar.a(this, fragment, z);
        }
    }

    public void b(Fragment fragment) {
        h.b.a.e.a.h hVar = this.a0;
        if (hVar != null) {
            hVar.a(this, fragment, true);
        }
    }

    public void c(Fragment fragment) {
        h.b.a.e.a.h hVar = this.a0;
        if (hVar != null) {
            hVar.a(this, fragment);
        }
    }

    public void n0() {
        h.b.a.e.a.h hVar = this.a0;
        if (hVar != null) {
            hVar.a(this);
        }
    }

    public DateFormat o0() {
        h.b.a.e.a.h hVar = this.a0;
        if (hVar == null) {
            return null;
        }
        return hVar.c();
    }

    @Override // android.support.v4.app.Fragment
    public void a(Context context) {
        super.a(context);
        this.b0 = context;
        a.b.g.a.g j = j();
        if (j == null || !(j instanceof h.b.a.e.a.h)) {
            return;
        }
        this.a0 = (h.b.a.e.a.h) j;
        this.Z = j;
    }
}
