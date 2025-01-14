package c.b.a.b;

import java.util.Locale;
import java.util.Map;
/* compiled from: AnswersEventValidator.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f2855a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2856b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2857c;

    public d(int i2, int i3, boolean z) {
        this.f2855a = i2;
        this.f2856b = i3;
        this.f2857c = z;
    }

    public String a(String str) {
        int length = str.length();
        int i2 = this.f2856b;
        if (length > i2) {
            a(new IllegalArgumentException(String.format(Locale.US, "String is too long, truncating to %d characters", Integer.valueOf(i2))));
            return str.substring(0, this.f2856b);
        }
        return str;
    }

    public boolean a(Object obj, String str) {
        if (obj == null) {
            a(new NullPointerException(str + " must not be null"));
            return true;
        }
        return false;
    }

    public boolean a(Map<String, Object> map, String str) {
        if (map.size() < this.f2855a || map.containsKey(str)) {
            return false;
        }
        a(new IllegalArgumentException(String.format(Locale.US, "Limit of %d attributes reached, skipping attribute", Integer.valueOf(this.f2855a))));
        return true;
    }

    public final void a(RuntimeException runtimeException) {
        if (!this.f2857c) {
            d.a.a.a.c.h().c("Answers", "Invalid user input detected", runtimeException);
            return;
        }
        throw runtimeException;
    }
}
