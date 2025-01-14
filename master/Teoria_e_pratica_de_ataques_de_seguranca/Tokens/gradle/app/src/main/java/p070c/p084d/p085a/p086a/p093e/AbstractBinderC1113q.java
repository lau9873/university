package p070c.p084d.p085a.p086a.p093e;

import java.lang.ref.WeakReference;

/* renamed from: c.d.a.a.e.q */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1113q extends AbstractBinderC1111o {

    /* renamed from: c */
    public static final WeakReference<byte[]> f5508c = new WeakReference<>(null);

    /* renamed from: b */
    public WeakReference<byte[]> f5509b;

    public AbstractBinderC1113q(byte[] bArr) {
        super(bArr);
        this.f5509b = f5508c;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.AbstractBinderC1111o
    /* renamed from: h */
    public final byte[] mo5109h() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f5509b.get();
            if (bArr == null) {
                bArr = mo5108i();
                this.f5509b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    /* renamed from: i */
    public abstract byte[] mo5108i();
}
