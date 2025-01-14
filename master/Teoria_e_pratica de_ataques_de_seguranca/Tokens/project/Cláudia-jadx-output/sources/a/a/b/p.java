package a.a.b;

import java.util.HashMap;
/* compiled from: ViewModelStore.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, n> f50a = new HashMap<>();

    public final void a(String str, n nVar) {
        n put = this.f50a.put(str, nVar);
        if (put != null) {
            put.a();
        }
    }

    public final n a(String str) {
        return this.f50a.get(str);
    }

    public final void a() {
        for (n nVar : this.f50a.values()) {
            nVar.a();
        }
        this.f50a.clear();
    }
}
