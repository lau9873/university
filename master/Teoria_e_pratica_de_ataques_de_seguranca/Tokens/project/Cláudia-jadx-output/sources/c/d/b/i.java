package c.d.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: JsonArray.java */
/* loaded from: classes.dex */
public final class i extends l implements Iterable<l> {

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f3732a = new ArrayList();

    public void a(l lVar) {
        if (lVar == null) {
            lVar = m.f3733a;
        }
        this.f3732a.add(lVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f3732a.equals(this.f3732a));
    }

    public int hashCode() {
        return this.f3732a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return this.f3732a.iterator();
    }

    @Override // c.d.b.l
    public String p() {
        if (this.f3732a.size() == 1) {
            return this.f3732a.get(0).p();
        }
        throw new IllegalStateException();
    }
}
