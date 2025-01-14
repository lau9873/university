package c.d.a.a.e.f;

import android.util.Log;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class m0<TListener> {

    /* renamed from: a  reason: collision with root package name */
    public TListener f3527a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3528b = false;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ h0 f3529c;

    public m0(h0 h0Var, TListener tlistener) {
        this.f3529c = h0Var;
        this.f3527a = tlistener;
    }

    public final void a() {
        synchronized (this) {
            this.f3527a = null;
        }
    }

    public abstract void a(TListener tlistener);

    public final void b() {
        ArrayList arrayList;
        ArrayList arrayList2;
        a();
        arrayList = this.f3529c.o;
        synchronized (arrayList) {
            arrayList2 = this.f3529c.o;
            arrayList2.remove(this);
        }
    }

    public abstract void c();

    public final void d() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.f3527a;
            if (this.f3528b) {
                String valueOf = String.valueOf(this);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                sb.append("Callback proxy ");
                sb.append(valueOf);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (tlistener != null) {
            try {
                a(tlistener);
            } catch (RuntimeException e2) {
                c();
                throw e2;
            }
        } else {
            c();
        }
        synchronized (this) {
            this.f3528b = true;
        }
        b();
    }
}
