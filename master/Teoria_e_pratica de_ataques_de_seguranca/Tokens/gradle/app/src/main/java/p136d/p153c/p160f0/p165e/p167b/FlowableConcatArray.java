package p136d.p153c.p160f0.p165e.p167b;

import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p160f0.p174i.SubscriptionArbiter;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.b */
/* loaded from: classes.dex */
public final class FlowableConcatArray<T> extends Flowable<T> {

    /* renamed from: b */
    public final Publisher<? extends T>[] f7098b;

    /* renamed from: c */
    public final boolean f7099c;

    /* compiled from: FlowableConcatArray.java */
    /* renamed from: d.c.f0.e.b.b$a */
    /* loaded from: classes.dex */
    public static final class C1599a<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {

        /* renamed from: h */
        public final Subscriber<? super T> f7100h;

        /* renamed from: i */
        public final Publisher<? extends T>[] f7101i;

        /* renamed from: j */
        public final boolean f7102j;

        /* renamed from: k */
        public final AtomicInteger f7103k = new AtomicInteger();

        /* renamed from: m */
        public int f7104m;

        /* renamed from: n */
        public List<Throwable> f7105n;

        /* renamed from: o */
        public long f7106o;

        public C1599a(Publisher<? extends T>[] publisherArr, boolean z, Subscriber<? super T> subscriber) {
            this.f7100h = subscriber;
            this.f7101i = publisherArr;
            this.f7102j = z;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            m3436b(subscription);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            this.f7106o++;
            this.f7100h.mo2187a((Subscriber<? super T>) t);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f7102j) {
                List list = this.f7105n;
                if (list == null) {
                    list = new ArrayList((this.f7101i.length - this.f7104m) + 1);
                    this.f7105n = list;
                }
                list.add(th);
                mo2189a();
                return;
            }
            this.f7100h.mo2186a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            if (this.f7103k.getAndIncrement() == 0) {
                Publisher<? extends T>[] publisherArr = this.f7101i;
                int length = publisherArr.length;
                int i = this.f7104m;
                while (i != length) {
                    Publisher<? extends T> publisher = publisherArr[i];
                    if (publisher == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (this.f7102j) {
                            List list = this.f7105n;
                            if (list == null) {
                                list = new ArrayList((length - i) + 1);
                                this.f7105n = list;
                            }
                            list.add(nullPointerException);
                            i++;
                        } else {
                            this.f7100h.mo2186a((Throwable) nullPointerException);
                            return;
                        }
                    } else {
                        long j = this.f7106o;
                        if (j != 0) {
                            this.f7106o = 0L;
                            m3437b(j);
                        }
                        publisher.mo2190a(this);
                        i++;
                        this.f7104m = i;
                        if (this.f7103k.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list2 = this.f7105n;
                if (list2 != null) {
                    if (list2.size() == 1) {
                        this.f7100h.mo2186a(list2.get(0));
                        return;
                    } else {
                        this.f7100h.mo2186a((Throwable) new CompositeException(list2));
                        return;
                    }
                }
                this.f7100h.mo2189a();
            }
        }
    }

    public FlowableConcatArray(Publisher<? extends T>[] publisherArr, boolean z) {
        this.f7098b = publisherArr;
        this.f7099c = z;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        C1599a c1599a = new C1599a(this.f7098b, this.f7099c, subscriber);
        subscriber.mo2188a((Subscription) c1599a);
        c1599a.mo2189a();
    }
}
