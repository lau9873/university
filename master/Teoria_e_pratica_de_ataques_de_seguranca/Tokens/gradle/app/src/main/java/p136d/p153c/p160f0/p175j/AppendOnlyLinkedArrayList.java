package p136d.p153c.p160f0.p175j;

import p136d.p153c.InterfaceC1730s;
import p193g.p204b.Subscriber;

/* renamed from: d.c.f0.j.a */
/* loaded from: classes.dex */
public class AppendOnlyLinkedArrayList<T> {

    /* renamed from: a */
    public final int f7703a;

    /* renamed from: b */
    public final Object[] f7704b;

    /* renamed from: c */
    public Object[] f7705c;

    /* renamed from: d */
    public int f7706d;

    public AppendOnlyLinkedArrayList(int i) {
        this.f7703a = i;
        this.f7704b = new Object[i + 1];
        this.f7705c = this.f7704b;
    }

    /* renamed from: a */
    public void m3421a(T t) {
        int i = this.f7703a;
        int i2 = this.f7706d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f7705c[i] = objArr;
            this.f7705c = objArr;
            i2 = 0;
        }
        this.f7705c[i2] = t;
        this.f7706d = i2 + 1;
    }

    /* renamed from: b */
    public void m3420b(T t) {
        this.f7704b[0] = t;
    }

    /* renamed from: a */
    public <U> boolean m3422a(Subscriber<? super U> subscriber) {
        int i;
        Object[] objArr = this.f7704b;
        int i2 = this.f7703a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            while (i < i2) {
                Object[] objArr2 = objArr[i];
                i = (objArr2 == null || NotificationLite.m3404a(objArr2, subscriber)) ? 0 : i + 1;
                objArr = objArr[i2];
            }
            objArr = objArr[i2];
        }
    }

    /* renamed from: a */
    public <U> boolean m3423a(InterfaceC1730s<? super U> interfaceC1730s) {
        int i;
        Object[] objArr = this.f7704b;
        int i2 = this.f7703a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            while (i < i2) {
                Object[] objArr2 = objArr[i];
                i = (objArr2 == null || NotificationLite.m3405a(objArr2, interfaceC1730s)) ? 0 : i + 1;
                objArr = objArr[i2];
            }
            objArr = objArr[i2];
        }
    }
}
