package p070c.p071a.p072a.p073o;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: c.a.a.o.d */
/* loaded from: classes.dex */
public class ByteArrayPool {

    /* renamed from: e */
    public static final Comparator<byte[]> f4613e = new C0793a();

    /* renamed from: a */
    public final List<byte[]> f4614a = new ArrayList();

    /* renamed from: b */
    public final List<byte[]> f4615b = new ArrayList(64);

    /* renamed from: c */
    public int f4616c = 0;

    /* renamed from: d */
    public final int f4617d;

    /* compiled from: ByteArrayPool.java */
    /* renamed from: c.a.a.o.d$a */
    /* loaded from: classes.dex */
    public class C0793a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public ByteArrayPool(int i) {
        this.f4617d = i;
    }

    /* renamed from: a */
    public synchronized byte[] m6154a(int i) {
        for (int i2 = 0; i2 < this.f4615b.size(); i2++) {
            byte[] bArr = this.f4615b.get(i2);
            if (bArr.length >= i) {
                this.f4616c -= bArr.length;
                this.f4615b.remove(i2);
                this.f4614a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    /* renamed from: a */
    public synchronized void m6153a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f4617d) {
                this.f4614a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f4615b, bArr, f4613e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f4615b.add(binarySearch, bArr);
                this.f4616c += bArr.length;
                m6155a();
            }
        }
    }

    /* renamed from: a */
    public final synchronized void m6155a() {
        while (this.f4616c > this.f4617d) {
            byte[] remove = this.f4614a.remove(0);
            this.f4615b.remove(remove);
            this.f4616c -= remove.length;
        }
    }
}
