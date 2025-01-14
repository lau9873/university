package d.c.d0;

import d.c.f0.j.f;
/* compiled from: Exceptions.java */
/* loaded from: classes.dex */
public final class a {
    public static RuntimeException a(Throwable th) {
        throw f.a(th);
    }

    public static void b(Throwable th) {
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
