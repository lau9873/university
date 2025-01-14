package p220i.p221p.p222a;

import p220i.C2632l;

/* renamed from: i.p.a.d */
/* loaded from: classes.dex */
public final class Result<T> {
    public Result(C2632l<T> c2632l, Throwable th) {
    }

    /* renamed from: a */
    public static <T> Result<T> m575a(Throwable th) {
        if (th != null) {
            return new Result<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    /* renamed from: a */
    public static <T> Result<T> m576a(C2632l<T> c2632l) {
        if (c2632l != null) {
            return new Result<>(c2632l, null);
        }
        throw new NullPointerException("response == null");
    }
}
