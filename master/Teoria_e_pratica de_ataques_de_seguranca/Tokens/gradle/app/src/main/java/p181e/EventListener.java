package p181e;

/* renamed from: e.q */
/* loaded from: classes.dex */
public abstract class EventListener {

    /* renamed from: a */
    public static final EventListener f8320a = new C1805a();

    /* compiled from: EventListener.java */
    /* renamed from: e.q$a */
    /* loaded from: classes.dex */
    public class C1805a extends EventListener {
    }

    /* compiled from: EventListener.java */
    /* renamed from: e.q$b */
    /* loaded from: classes.dex */
    public class C1806b implements InterfaceC1807c {
        public C1806b() {
        }

        @Override // p181e.EventListener.InterfaceC1807c
        /* renamed from: a */
        public EventListener mo2775a(Call call) {
            return EventListener.this;
        }
    }

    /* compiled from: EventListener.java */
    /* renamed from: e.q$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1807c {
        /* renamed from: a */
        EventListener mo2775a(Call call);
    }

    /* renamed from: a */
    public static InterfaceC1807c m2776a(EventListener eventListener) {
        return new C1806b();
    }
}
