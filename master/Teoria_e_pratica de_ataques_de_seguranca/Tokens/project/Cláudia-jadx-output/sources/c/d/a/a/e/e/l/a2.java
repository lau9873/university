package c.d.a.a.e.e.l;

import android.os.IBinder;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class a2 implements IBinder.DeathRecipient, b2 {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<BasePendingResult<?>> f3255a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<c.d.a.a.e.e.o> f3256b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<IBinder> f3257c;

    public a2(BasePendingResult<?> basePendingResult, c.d.a.a.e.e.o oVar, IBinder iBinder) {
        this.f3256b = new WeakReference<>(oVar);
        this.f3255a = new WeakReference<>(basePendingResult);
        this.f3257c = new WeakReference<>(iBinder);
    }

    public /* synthetic */ a2(BasePendingResult basePendingResult, c.d.a.a.e.e.o oVar, IBinder iBinder, z1 z1Var) {
        this(basePendingResult, null, iBinder);
    }

    public final void a() {
        BasePendingResult<?> basePendingResult = this.f3255a.get();
        c.d.a.a.e.e.o oVar = this.f3256b.get();
        if (oVar != null && basePendingResult != null) {
            oVar.a(basePendingResult.e().intValue());
        }
        IBinder iBinder = this.f3257c.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @Override // c.d.a.a.e.e.l.b2
    public final void a(BasePendingResult<?> basePendingResult) {
        a();
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        a();
    }
}
