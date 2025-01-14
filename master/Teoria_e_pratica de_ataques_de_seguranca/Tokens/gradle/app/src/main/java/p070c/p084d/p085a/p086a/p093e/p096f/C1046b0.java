package p070c.p084d.p085a.p086a.p093e.p096f;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.List;

/* renamed from: c.d.a.a.e.f.b0 */
/* loaded from: classes.dex */
public final class C1046b0 {

    /* renamed from: a */
    public final List<String> f5374a;

    /* renamed from: b */
    public final Object f5375b;

    public C1046b0(Object obj) {
        C1049c0.m5294a(obj);
        this.f5375b = obj;
        this.f5374a = new ArrayList();
    }

    /* renamed from: a */
    public final C1046b0 m5298a(String str, Object obj) {
        List<String> list = this.f5374a;
        C1049c0.m5294a(str);
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
        sb.append(this.f5375b.getClass().getSimpleName());
        sb.append('{');
        int size = this.f5374a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.f5374a.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
