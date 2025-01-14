package c.b.a.b;

import c.b.a.b.c;
import java.util.Map;
/* compiled from: AnswersEvent.java */
/* loaded from: classes.dex */
public abstract class c<T extends c> {

    /* renamed from: a  reason: collision with root package name */
    public final d f2853a = new d(20, 100, d.a.a.a.c.i());

    /* renamed from: b  reason: collision with root package name */
    public final b f2854b = new b(this.f2853a);

    public Map<String, Object> a() {
        return this.f2854b.f2852b;
    }

    public T a(String str, String str2) {
        this.f2854b.a(str, str2);
        return this;
    }

    public T a(String str, Number number) {
        this.f2854b.a(str, number);
        return this;
    }
}
