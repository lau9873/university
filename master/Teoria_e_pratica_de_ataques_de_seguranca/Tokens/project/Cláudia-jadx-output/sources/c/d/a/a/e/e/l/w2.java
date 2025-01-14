package c.d.a.a.e.e.l;

import android.os.Bundle;
/* loaded from: classes.dex */
public final class w2 implements y0 {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ u2 f3440a;

    public w2(u2 u2Var) {
        this.f3440a = u2Var;
    }

    public /* synthetic */ w2(u2 u2Var, v2 v2Var) {
        this(u2Var);
    }

    @Override // c.d.a.a.e.e.l.y0
    public final void a(int i2, boolean z) {
        u2.a(this.f3440a).lock();
        try {
            if (!u2.c(this.f3440a) && u2.d(this.f3440a) != null && u2.d(this.f3440a).f()) {
                u2.a(this.f3440a, true);
                u2.e(this.f3440a).onConnectionSuspended(i2);
            }
            u2.a(this.f3440a, false);
            u2.a(this.f3440a, i2, z);
        } finally {
            u2.a(this.f3440a).unlock();
        }
    }

    @Override // c.d.a.a.e.e.l.y0
    public final void a(Bundle bundle) {
        u2.a(this.f3440a).lock();
        try {
            u2.a(this.f3440a, bundle);
            u2.a(this.f3440a, c.d.a.a.e.a.f3212e);
            u2.b(this.f3440a);
        } finally {
            u2.a(this.f3440a).unlock();
        }
    }

    @Override // c.d.a.a.e.e.l.y0
    public final void a(c.d.a.a.e.a aVar) {
        u2.a(this.f3440a).lock();
        try {
            u2.a(this.f3440a, aVar);
            u2.b(this.f3440a);
        } finally {
            u2.a(this.f3440a).unlock();
        }
    }
}
