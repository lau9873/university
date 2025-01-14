package p136d.p153c.p160f0.p175j;

import java.io.Serializable;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.j.h */
/* loaded from: classes.dex */
public enum NotificationLite {
    COMPLETE;

    /* compiled from: NotificationLite.java */
    /* renamed from: d.c.f0.j.h$a */
    /* loaded from: classes.dex */
    public static final class C1716a implements Serializable {

        /* renamed from: a */
        public final Disposable f7714a;

        public String toString() {
            return "NotificationLite.Disposable[" + this.f7714a + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* renamed from: d.c.f0.j.h$b */
    /* loaded from: classes.dex */
    public static final class C1717b implements Serializable {

        /* renamed from: a */
        public final Throwable f7715a;

        public C1717b(Throwable th) {
            this.f7715a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1717b) {
                return ObjectHelper.m3599a(this.f7715a, ((C1717b) obj).f7715a);
            }
            return false;
        }

        public int hashCode() {
            return this.f7715a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f7715a + "]";
        }
    }

    /* compiled from: NotificationLite.java */
    /* renamed from: d.c.f0.j.h$c */
    /* loaded from: classes.dex */
    public static final class C1718c implements Serializable {

        /* renamed from: a */
        public final Subscription f7716a;

        public C1718c(Subscription subscription) {
            this.f7716a = subscription;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f7716a + "]";
        }
    }

    /* renamed from: a */
    public static <T> Object m3406a(T t) {
        return t;
    }

    /* renamed from: a */
    public static Object m3403a(Throwable th) {
        return new C1717b(th);
    }

    /* renamed from: b */
    public static Object m3402b() {
        return COMPLETE;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    /* renamed from: a */
    public static Object m3407a(Subscription subscription) {
        return new C1718c(subscription);
    }

    /* renamed from: a */
    public static <T> boolean m3404a(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.mo2189a();
            return true;
        } else if (obj instanceof C1717b) {
            subscriber.mo2186a(((C1717b) obj).f7715a);
            return true;
        } else if (obj instanceof C1718c) {
            subscriber.mo2188a(((C1718c) obj).f7716a);
            return false;
        } else {
            subscriber.mo2187a((Subscriber<? super T>) obj);
            return false;
        }
    }

    /* renamed from: a */
    public static <T> boolean m3405a(Object obj, InterfaceC1730s<? super T> interfaceC1730s) {
        if (obj == COMPLETE) {
            interfaceC1730s.mo573a();
            return true;
        } else if (obj instanceof C1717b) {
            interfaceC1730s.mo569a(((C1717b) obj).f7715a);
            return true;
        } else if (obj instanceof C1716a) {
            interfaceC1730s.mo572a(((C1716a) obj).f7714a);
            return false;
        } else {
            interfaceC1730s.mo570a((InterfaceC1730s<? super T>) obj);
            return false;
        }
    }
}
