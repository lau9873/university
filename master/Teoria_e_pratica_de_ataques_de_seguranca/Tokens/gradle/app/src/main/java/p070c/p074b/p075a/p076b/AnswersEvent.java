package p070c.p074b.p075a.p076b;

import java.util.Map;
import p070c.p074b.p075a.p076b.AnswersEvent;
import p136d.p137a.p138a.p139a.Fabric;

/* renamed from: c.b.a.b.c */
/* loaded from: classes.dex */
public abstract class AnswersEvent<T extends AnswersEvent> {

    /* renamed from: a */
    public final AnswersEventValidator f4654a = new AnswersEventValidator(20, 100, Fabric.m4196i());

    /* renamed from: b */
    public final AnswersAttributes f4655b = new AnswersAttributes(this.f4654a);

    /* renamed from: a */
    public Map<String, Object> m6070a() {
        return this.f4655b.f4653b;
    }

    /* renamed from: a */
    public T m6068a(String str, String str2) {
        this.f4655b.m6071a(str, str2);
        return this;
    }

    /* renamed from: a */
    public T m6069a(String str, Number number) {
        this.f4655b.m6073a(str, number);
        return this;
    }
}
