package c.d.a.a.e.e.l;

import android.os.Bundle;
/* loaded from: classes.dex */
public final class x2 implements y0 {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ u2 f3442a;

    public x2(u2 u2Var) {
        this.f3442a = u2Var;
    }

    public /* synthetic */ x2(u2 u2Var, v2 v2Var) {
        this(u2Var);
    }

    @Override // c.d.a.a.e.e.l.y0
    public final void a(int i2, boolean z) {
        this.f3442a.l.lock();
        try {
            if (this.f3442a.k) {
                this.f3442a.k = false;
                this.f3442a.a(i2, z);
            } else {
                this.f3442a.k = true;
                this.f3442a.f3420c.onConnectionSuspended(i2);
            }
        } finally {
            this.f3442a.l.unlock();
        }
    }

    @Override // c.d.a.a.e.e.l.y0
    public final void a(Bundle bundle) {
        this.f3442a.l.lock();
        try {
            this.f3442a.j = c.d.a.a.e.a.f3212e;
            this.f3442a.e();
        } finally {
            this.f3442a.l.unlock();
        }
    }

    @Override // c.d.a.a.e.e.l.y0
    public final void a(c.d.a.a.e.a aVar) {
        this.f3442a.l.lock();
        try {
            this.f3442a.j = aVar;
            this.f3442a.e();
        } finally {
            this.f3442a.l.unlock();
        }
    }
}
