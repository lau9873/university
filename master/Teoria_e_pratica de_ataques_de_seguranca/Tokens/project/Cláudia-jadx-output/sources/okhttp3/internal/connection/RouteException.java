package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class RouteException extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    public static final Method f7591b;

    /* renamed from: a  reason: collision with root package name */
    public IOException f7592a;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f7591b = method;
    }

    public RouteException(IOException iOException) {
        super(iOException);
        this.f7592a = iOException;
    }

    public IOException a() {
        return this.f7592a;
    }

    public void a(IOException iOException) {
        a(iOException, this.f7592a);
        this.f7592a = iOException;
    }

    public final void a(IOException iOException, IOException iOException2) {
        Method method = f7591b;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
