package c.d.a.a.e.e.l;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ c.d.a.a.e.e.g f3438a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ v1 f3439b;

    public w1(v1 v1Var, c.d.a.a.e.e.g gVar) {
        this.f3439b = v1Var;
        this.f3438a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference weakReference;
        x1 x1Var;
        x1 x1Var2;
        WeakReference weakReference2;
        c.d.a.a.e.e.j jVar;
        x1 x1Var3;
        x1 x1Var4;
        WeakReference weakReference3;
        try {
            try {
                BasePendingResult.p.set(true);
                jVar = this.f3439b.f3429a;
                c.d.a.a.e.e.e a2 = jVar.a((c.d.a.a.e.e.j) this.f3438a);
                x1Var3 = this.f3439b.f3435g;
                x1Var4 = this.f3439b.f3435g;
                x1Var3.sendMessage(x1Var4.obtainMessage(0, a2));
                BasePendingResult.p.set(false);
                v1 v1Var = this.f3439b;
                v1.a(this.f3438a);
                weakReference3 = this.f3439b.f3434f;
                c.d.a.a.e.e.d dVar = (c.d.a.a.e.e.d) weakReference3.get();
                if (dVar != null) {
                    dVar.a(this.f3439b);
                }
            } catch (RuntimeException e2) {
                x1Var = this.f3439b.f3435g;
                x1Var2 = this.f3439b.f3435g;
                x1Var.sendMessage(x1Var2.obtainMessage(1, e2));
                BasePendingResult.p.set(false);
                v1 v1Var2 = this.f3439b;
                v1.a(this.f3438a);
                weakReference2 = this.f3439b.f3434f;
                c.d.a.a.e.e.d dVar2 = (c.d.a.a.e.e.d) weakReference2.get();
                if (dVar2 != null) {
                    dVar2.a(this.f3439b);
                }
            }
        } catch (Throwable th) {
            BasePendingResult.p.set(false);
            v1 v1Var3 = this.f3439b;
            v1.a(this.f3438a);
            weakReference = this.f3439b.f3434f;
            c.d.a.a.e.e.d dVar3 = (c.d.a.a.e.e.d) weakReference.get();
            if (dVar3 != null) {
                dVar3.a(this.f3439b);
            }
            throw th;
        }
    }
}
