package p070c.p074b.p075a.p076b;

import java.util.HashSet;
import java.util.Set;
import p070c.p074b.p075a.p076b.SessionEvent;

/* renamed from: c.b.a.b.r */
/* loaded from: classes.dex */
public class SamplingEventFilter implements EventFilter {

    /* renamed from: b */
    public static final Set<SessionEvent.EnumC0810c> f4708b = new C0807a();

    /* renamed from: a */
    public final int f4709a;

    /* compiled from: SamplingEventFilter.java */
    /* renamed from: c.b.a.b.r$a */
    /* loaded from: classes.dex */
    public static class C0807a extends HashSet<SessionEvent.EnumC0810c> {
        public C0807a() {
            add(SessionEvent.EnumC0810c.START);
            add(SessionEvent.EnumC0810c.RESUME);
            add(SessionEvent.EnumC0810c.PAUSE);
            add(SessionEvent.EnumC0810c.STOP);
        }
    }

    public SamplingEventFilter(int i) {
        this.f4709a = i;
    }

    @Override // p070c.p074b.p075a.p076b.EventFilter
    /* renamed from: a */
    public boolean mo6030a(SessionEvent sessionEvent) {
        return (f4708b.contains(sessionEvent.f4719c) && sessionEvent.f4717a.f4748g == null) && (Math.abs(sessionEvent.f4717a.f4744c.hashCode() % this.f4709a) != 0);
    }
}
