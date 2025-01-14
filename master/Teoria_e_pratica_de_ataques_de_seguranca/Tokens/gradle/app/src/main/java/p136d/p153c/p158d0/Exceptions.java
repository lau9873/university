package p136d.p153c.p158d0;

import p136d.p153c.p160f0.p175j.ExceptionHelper;

/* renamed from: d.c.d0.a */
/* loaded from: classes.dex */
public final class Exceptions {
    /* renamed from: a */
    public static RuntimeException m3661a(Throwable th) {
        throw ExceptionHelper.m3413a(th);
    }

    /* renamed from: b */
    public static void m3660b(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (th instanceof LinkageError) {
                    throw ((LinkageError) th);
                }
                return;
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }
}
