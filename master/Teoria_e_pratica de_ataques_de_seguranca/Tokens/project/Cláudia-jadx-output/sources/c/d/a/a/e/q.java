package c.d.a.a.e;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public abstract class q extends o {

    /* renamed from: c  reason: collision with root package name */
    public static final WeakReference<byte[]> f3575c = new WeakReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<byte[]> f3576b;

    public q(byte[] bArr) {
        super(bArr);
        this.f3576b = f3575c;
    }

    @Override // c.d.a.a.e.o
    public final byte[] h() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f3576b.get();
            if (bArr == null) {
                bArr = i();
                this.f3576b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    public abstract byte[] i();
}
