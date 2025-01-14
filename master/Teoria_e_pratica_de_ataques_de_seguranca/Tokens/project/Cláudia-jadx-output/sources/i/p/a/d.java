package i.p.a;

import i.l;
/* compiled from: Result.java */
/* loaded from: classes.dex */
public final class d<T> {
    public d(l<T> lVar, Throwable th) {
    }

    public static <T> d<T> a(Throwable th) {
        if (th != null) {
            return new d<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> d<T> a(l<T> lVar) {
        if (lVar != null) {
            return new d<>(lVar, null);
        }
        throw new NullPointerException("response == null");
    }
}
