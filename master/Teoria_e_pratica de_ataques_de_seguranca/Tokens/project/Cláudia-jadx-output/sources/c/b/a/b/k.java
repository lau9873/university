package c.b.a.b;
/* compiled from: CustomEvent.java */
/* loaded from: classes.dex */
public class k extends c<k> {

    /* renamed from: c  reason: collision with root package name */
    public final String f2888c;

    public k(String str) {
        if (str != null) {
            this.f2888c = this.f2853a.a(str);
            return;
        }
        throw new NullPointerException("eventName must not be null");
    }

    public String b() {
        return this.f2888c;
    }

    public String toString() {
        return "{eventName:\"" + this.f2888c + "\", customAttributes:" + this.f2854b + "}";
    }
}
