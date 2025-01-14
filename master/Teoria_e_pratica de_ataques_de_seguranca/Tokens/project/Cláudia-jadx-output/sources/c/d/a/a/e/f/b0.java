package c.d.a.a.e.f;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f3458a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f3459b;

    public b0(Object obj) {
        c0.a(obj);
        this.f3459b = obj;
        this.f3458a = new ArrayList();
    }

    public final b0 a(String str, Object obj) {
        List<String> list = this.f3458a;
        c0.a(str);
        String str2 = str;
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
        sb.append(str2);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(valueOf);
        list.add(sb.toString());
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(this.f3459b.getClass().getSimpleName());
        sb.append('{');
        int size = this.f3458a.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(this.f3458a.get(i2));
            if (i2 < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
