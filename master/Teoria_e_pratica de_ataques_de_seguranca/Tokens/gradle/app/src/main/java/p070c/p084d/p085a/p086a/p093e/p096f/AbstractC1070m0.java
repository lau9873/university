package p070c.p084d.p085a.p086a.p093e.p096f;

import android.util.Log;
import java.util.ArrayList;

/* renamed from: c.d.a.a.e.f.m0 */
/* loaded from: classes.dex */
public abstract class AbstractC1070m0<TListener> {

    /* renamed from: a */
    public TListener f5460a;

    /* renamed from: b */
    public boolean f5461b = false;

    /* renamed from: c */
    public /* synthetic */ AbstractC1060h0 f5462c;

    public AbstractC1070m0(AbstractC1060h0 abstractC1060h0, TListener tlistener) {
        this.f5462c = abstractC1060h0;
        this.f5460a = tlistener;
    }

    /* renamed from: a */
    public final void m5194a() {
        synchronized (this) {
            this.f5460a = null;
        }
    }

    /* renamed from: a */
    public abstract void mo5193a(TListener tlistener);

    /* renamed from: b */
    public final void m5192b() {
        ArrayList arrayList;
        ArrayList arrayList2;
        m5194a();
        arrayList = this.f5462c.f5426o;
        synchronized (arrayList) {
            arrayList2 = this.f5462c.f5426o;
            arrayList2.remove(this);
        }
    }

    /* renamed from: c */
    public abstract void mo5191c();

    /* renamed from: d */
    public final void m5190d() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.f5460a;
            if (this.f5461b) {
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
                mo5193a(tlistener);
            } catch (RuntimeException e) {
                mo5191c();
                throw e;
            }
        } else {
            mo5191c();
        }
        synchronized (this) {
            this.f5461b = true;
        }
        m5192b();
    }
}
