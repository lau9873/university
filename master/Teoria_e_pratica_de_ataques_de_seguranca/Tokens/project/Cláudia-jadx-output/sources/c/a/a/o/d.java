package c.a.a.o;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* compiled from: ByteArrayPool.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f2816e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f2817a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f2818b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    public int f2819c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f2820d;

    /* compiled from: ByteArrayPool.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public d(int i2) {
        this.f2820d = i2;
    }

    public synchronized byte[] a(int i2) {
        for (int i3 = 0; i3 < this.f2818b.size(); i3++) {
            byte[] bArr = this.f2818b.get(i3);
            if (bArr.length >= i2) {
                this.f2819c -= bArr.length;
                this.f2818b.remove(i3);
                this.f2817a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f2820d) {
                this.f2817a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f2818b, bArr, f2816e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f2818b.add(binarySearch, bArr);
                this.f2819c += bArr.length;
                a();
            }
        }
    }

    public final synchronized void a() {
        while (this.f2819c > this.f2820d) {
            byte[] remove = this.f2817a.remove(0);
            this.f2818b.remove(remove);
            this.f2819c -= remove.length;
        }
    }
}
