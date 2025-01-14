package p070c.p074b.p075a.p076b;

import java.io.File;
import java.util.List;
import p136d.p137a.p138a.p139a.p140m.p143c.p144n.C1516b;
import p136d.p137a.p138a.p139a.p140m.p143c.p144n.ExponentialBackoff;
import p136d.p137a.p138a.p139a.p140m.p143c.p144n.RetryState;
import p136d.p137a.p138a.p139a.p140m.p145d.FilesSender;

/* renamed from: c.b.a.b.i */
/* loaded from: classes.dex */
public class AnswersRetryFilesSender implements FilesSender {

    /* renamed from: a */
    public final SessionAnalyticsFilesSender f4681a;

    /* renamed from: b */
    public final RetryManager f4682b;

    public AnswersRetryFilesSender(SessionAnalyticsFilesSender sessionAnalyticsFilesSender, RetryManager retryManager) {
        this.f4681a = sessionAnalyticsFilesSender;
        this.f4682b = retryManager;
    }

    /* renamed from: a */
    public static AnswersRetryFilesSender m6044a(SessionAnalyticsFilesSender sessionAnalyticsFilesSender) {
        return new AnswersRetryFilesSender(sessionAnalyticsFilesSender, new RetryManager(new RetryState(new RandomBackoff(new ExponentialBackoff(1000L, 8), 0.1d), new C1516b(5))));
    }

    @Override // p136d.p137a.p138a.p139a.p140m.p145d.FilesSender
    /* renamed from: a */
    public boolean mo3939a(List<File> list) {
        long nanoTime = System.nanoTime();
        if (this.f4682b.m6032a(nanoTime)) {
            if (this.f4681a.mo3939a(list)) {
                this.f4682b.m6033a();
                return true;
            }
            this.f4682b.m6031b(nanoTime);
        }
        return false;
    }
}
