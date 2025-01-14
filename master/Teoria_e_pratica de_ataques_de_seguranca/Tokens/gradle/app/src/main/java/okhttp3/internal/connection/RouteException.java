package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class RouteException extends RuntimeException {

    /* renamed from: b */
    public static final Method f10568b;

    /* renamed from: a */
    public IOException f10569a;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f10568b = method;
    }

    public RouteException(IOException iOException) {
        super(iOException);
        this.f10569a = iOException;
    }

    /* renamed from: a */
    public IOException m493a() {
        return this.f10569a;
    }

    /* renamed from: a */
    public void m492a(IOException iOException) {
        m491a(iOException, this.f10569a);
        this.f10569a = iOException;
    }

    /* renamed from: a */
    public final void m491a(IOException iOException, IOException iOException2) {
        Method method = f10568b;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
