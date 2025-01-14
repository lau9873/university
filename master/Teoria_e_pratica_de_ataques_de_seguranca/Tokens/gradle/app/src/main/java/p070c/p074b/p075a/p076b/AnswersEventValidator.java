package p070c.p074b.p075a.p076b;

import java.util.Locale;
import java.util.Map;
import p136d.p137a.p138a.p139a.Fabric;

/* renamed from: c.b.a.b.d */
/* loaded from: classes.dex */
public class AnswersEventValidator {

    /* renamed from: a */
    public final int f4656a;

    /* renamed from: b */
    public final int f4657b;

    /* renamed from: c */
    public boolean f4658c;

    public AnswersEventValidator(int i, int i2, boolean z) {
        this.f4656a = i;
        this.f4657b = i2;
        this.f4658c = z;
    }

    /* renamed from: a */
    public String m6065a(String str) {
        int length = str.length();
        int i = this.f4657b;
        if (length > i) {
            m6066a(new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", Integer.valueOf(i))));
            return str.substring(0, this.f4657b);
        }
        return str;
    }

    /* renamed from: a */
    public boolean m6067a(Object obj, String str) {
        if (obj == null) {
            m6066a(new NullPointerException(str + " must not be null"));
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m6064a(Map<String, Object> map, String str) {
        if (map.size() < this.f4656a || map.containsKey(str)) {
            return false;
        }
        m6066a(new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", Integer.valueOf(this.f4656a))));
        return true;
    }

    /* renamed from: a */
    public final void m6066a(RuntimeException runtimeException) {
        if (!this.f4658c) {
            Fabric.m4197h().mo4159c("Answers", "Invalid user input detected", runtimeException);
            return;
        }
        throw runtimeException;
    }
}
