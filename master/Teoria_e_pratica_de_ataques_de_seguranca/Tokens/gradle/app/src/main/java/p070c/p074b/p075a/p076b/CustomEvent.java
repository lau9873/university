package p070c.p074b.p075a.p076b;

/* renamed from: c.b.a.b.k */
/* loaded from: classes.dex */
public class CustomEvent extends AnswersEvent<CustomEvent> {

    /* renamed from: c */
    public final String f4689c;

    public CustomEvent(String str) {
        if (str != null) {
            this.f4689c = this.f4654a.m6065a(str);
            return;
        }
        throw new NullPointerException("eventName must not be null");
    }

    /* renamed from: b */
    public String m6037b() {
        return this.f4689c;
    }

    public String toString() {
        return "{eventName:\"" + this.f4689c + "\", customAttributes:" + this.f4655b + "}";
    }
}
